import java.util.Scanner;
import java.util.Random;

public class Squash 
{

	public static void main(String[] args) 
	{
		
		String p1;
		int p1_score_hiho = 0;
		int p2_score_hiho = 0;
		int p1_score_par = 0;
		int p2_score_par = 0;
		String p2;
		int gm;
		String[] rounds = new String[100];
		Scanner input = new Scanner(System.in);
		System.out.println("Welcome to the game of squash, please enter the two names of the players facing each other");
		p1 = input.next();
		p2 = input.next();
		System.out.println("Please enter 1 for random inputs of rounds or 2 for manual");
		gm = input.nextInt();
		if(gm == 2) //manual
		{
			for(int i = 0; i < 5; i++) //number of games
			{
				int noRounds = 0;
				String winner;
				PAR p = new PAR(p1,p2);
				HIHO h = new HIHO(p1,p2);
				while((p.game_done ==false) || (h.game_done == false)) //while two games aren't done
				{
					System.out.print("Please input winner of round "); //manual input of round
					System.out.println(noRounds+1);
					winner = input.next();
					rounds[noRounds] = winner; //saving round winner for printing
					if(p.game_done == false)
						{
							p.update_score(winner); //update score if game isn't done
						}
					if(h.game_done == false)
					{
						h.update_scores(winner); //update score if game isn't  done
					}
					noRounds = noRounds +1;
					
				}
				//incrementing game points based on HIHO and PAR winners
				if(p.winner == p1)
					p1_score_par = p1_score_par + 1;
				if(p.winner == p2)
					p2_score_par = p2_score_par + 1;
				if(h.winner == p1)
					p1_score_hiho = p1_score_hiho + 1;
				if(h.winner == p2)
					p2_score_hiho = p2_score_hiho + 1;
				print_table(p1,p2,i+1,rounds,noRounds); //print table
			}
			
		}
		else
		{ //same as manual but changed input to random
			
			for(int i = 0; i < 5; i++)
			{
				int noRounds = 0;
				int rndom;
				String winner;
				PAR p = new PAR (p1,p2);
				HIHO h = new HIHO(p1,p2);
				while((p.game_done ==false) || (h.game_done == false))
				{
					
					Random rand = new Random();
					 rndom = (rand.nextInt((2-1)+1)+1); //random input
					 if(rndom == 1)
						 winner = p1;
					 else
						 winner = p2;
					rounds[noRounds] = winner;
					if(p.game_done == false)
						{
						
							p.update_score(winner);
						}
					if(h.game_done == false)
					{
						h.update_scores(winner);
					}
					noRounds = noRounds +1;
					
			}
				if(p.winner == p1)
					p1_score_par = p1_score_par + 1;
				if(p.winner == p2)
					p2_score_par = p2_score_par + 1;
				if(h.winner == p1)
					p1_score_hiho = p1_score_hiho + 1;
				if(h.winner == p2)
					p2_score_hiho = p2_score_hiho + 1;
				print_table(p1,p2,i+1,rounds,noRounds);
		}
	}
		if(p1_score_par > p2_score_par) //printing if p1 wins par
		{
			System.out.print("According to PAR, The winner is ");
			System.out.print(p1);
			System.out.print(" with a score of ");
			System.out.print(p1_score_par);
			System.out.print(" - ");
			System.out.println(p2_score_par);
		}
	else 
		{
		System.out.print("According to PAR, The winner is "); //printing if p2 wins par
		System.out.print(p2);
		System.out.print(" with a score of ");
		System.out.print(p1_score_par);
		System.out.print(" - ");
		System.out.println(p2_score_par);
		}
	if(p1_score_hiho > p2_score_hiho)
	{
		System.out.print("According to HIHO, The winner is "); //printing if p1 wins hiho
		System.out.print(p1);
		System.out.print(" with a score of ");
		System.out.print(p1_score_hiho);
		System.out.print(" - ");
		System.out.println(p2_score_hiho);
	}
else 
	{
	System.out.print("According to HIHO, The winner is "); //printing if p2 wins hiho
	System.out.print(p2);
	System.out.print(" with a score of ");
	System.out.print(p1_score_par);
	System.out.print(" - ");
	System.out.println(p2_score_par);
	}
}


static void print_table (String p1,String p2,int game_no,String[] rounds, int norounds)
{
	System.out.printf("%s\t\t%s\t\t%s\t\t%s\n", "Game #","Round #",p1, p2); //print header
	for(int i = 0; i < norounds;i++)
	{
		char p1_letter;
		char p2_letter;
		if(rounds[i].equals(p1)) //assigning W and L based on round winner
		{
			p1_letter = 'W';
			p2_letter = 'L';
		}
		else
		{
			p1_letter = 'L';
			p2_letter = 'W';
		}
		System.out.printf("%d\t\t%d\t\t%s\t\t%s\n", game_no,i+1,p1_letter, p2_letter); //printing each round
	}
}}


