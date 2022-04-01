public class HIHO {
private String player1;
private String player2;
public String winner;
private String last_round_winner;
private int player1_score;
private int player2_score;
private int max_no_of_rounds;
public boolean game_done;
public boolean overtime;


HIHO(String p1,String p2)
{
	player1 = p1;
	player2 = p2;
	player1_score = 0;
	player2_score = 0;
	winner = "";
	max_no_of_rounds = 0;
	game_done = false;
	overtime = false;
	last_round_winner = "";
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
void set_lastrw(String a)
{
	last_round_winner = a;
}
void update_scores(String round_winner)
{
	if(round_winner.equals(player1)) // if p1 wins
	{
		if(last_round_winner.equals(player1)) // give point if he won last round as well
		{
			increment_p1_score();
			if(get_p1_score() == 9)
			{
				winner = player1;
				game_done = true;
			}
		}
		else // else make him last round winner (he has the serve)
		{
			set_lastrw(player1);
		}
	}
	else //same for player 2
	{
		if(last_round_winner.equals(player2))
			{
			increment_p2_score();
			if(get_p2_score() == 9)
			{
				winner = player2;
				game_done = true;
			}
			}
		else
		{
			set_lastrw(player2);
		}
	}
max_no_of_rounds = max_no_of_rounds + 1;
}
}
