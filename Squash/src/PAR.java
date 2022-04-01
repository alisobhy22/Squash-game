class PAR {
private String player1;
private String player2;
public String winner;
private int player1_score;
private int player2_score;
private int max_no_of_rounds;
public boolean game_done;
public boolean overtime;


PAR(String p1,String p2)
{
	player1 = p1;
	player2 = p2;
	player1_score = 0;
	player2_score = 0;
	winner = "";
	max_no_of_rounds = 0;
	game_done = false;
	overtime = false;
}
void set_winner(String win)
{
	winner = win;
}
void increment_p1_score()
{
	player1_score = player1_score + 1;
}
int get_p1_score()
{
	return player1_score;
}
void increment_p2_score ()
{
	player2_score = player2_score + 1;
}
int get_p2_score()
{
	return player2_score;
}
void update_score(String round_winner)
{
	if((get_p1_score() == 10  && get_p2_score() == 10))
			{
				overtime = true;
			}
	if(round_winner.equals(player1))
	{
		increment_p1_score();
		if(overtime)
		{
			if(player1_score - player2_score ==2)
			{
				winner = player1;
				game_done = true;
			}
		}
			
		else if(get_p1_score() == 11)
		{
			winner = player1;
			game_done = true;
		}
	}
	else
	{
		increment_p2_score();
		if(overtime)
		{
			if(player2_score - player1_score ==2)
			{
				winner = player2;
				game_done = true;
			}
		}
		else if(get_p2_score() == 11)
		{
			winner = player2;
			game_done = true;
		}
	}
	max_no_of_rounds = max_no_of_rounds + 1;
}
}