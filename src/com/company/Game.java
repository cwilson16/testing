package com.company;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Game
{
    HandOfDice hand = new HandOfDice();
    private int turn;
    Scanner input = new Scanner(System.in);

    public int getTurn() {
        return turn;
    }

    public void setTurn(int turn) {
        this.turn = turn;
    }

    public Scanner getInput() {
        return input;
    }

    public void setInput(Scanner input) {
        this.input = input;
    }

    public void scoreGame()
    {
        Scorecard score = new Scorecard();




        score.calcScore();
    }

    public void showPossibleScores()
    {
        //aces
        System.out.println("Aces:        " + (hand.ones));
        //twos
        System.out.println("Twos:        " + (2 * hand.twos));
        //threes
        System.out.println("Threes:      " + (3 * hand.threes));
        //fours
        System.out.println("Fours:       " + (4 * hand.fours));
        //fives
        System.out.println("Fives:       " + (5 * hand.fives));
        //sixes
        System.out.println("Sixes:       " + (6 * hand.sixes));

        //3ofakind
        if(hand.triple)
        {
            System.out.println("3 of a Kind: " + hand.handSum);
        }
        else
        {
            System.out.println("3 of a Kind: 0");
        }
        //4ofakind
        if(hand.quad)
        {
            System.out.println("4 of a Kind: " + hand.handSum);
        }
        else
        {
            System.out.println("4 of a Kind: 0");
        }
        //fullhouse
        if(hand.fullHouse)
        {
            System.out.println("Full House:  25");
        }
        else
        {
            System.out.println("Full House:  0");
        }

        //smstraight
        if(hand.smStraight)
        {
            System.out.println("SM Straight: 30");
        }
        else
        {
            System.out.println("SM Straight: 0");
        }

        //lgstraight
        if(hand.lgStraight)
        {
            System.out.println("LG Straight: 40");
        }
        else
        {
            System.out.println("LG Straight: 0");
        }

        //yahtzee
        if(hand.yahtzee)
        {
            System.out.println("YAHTZEE:     50");
        }
        else
        {
            System.out.println("YAHTZEE:     0");
        }

        //chance
        System.out.println("Chance:      " + hand.handSum);
    }

    public Game()
    {
        System.out.println("test");
        //HandOfDice hand = new HandOfDice();
        hand.initDice();
        hand.rollAllDice();
        hand.printHand();

        for(int j = 0; j < 3; j++)
        {
            System.out.println("Which dice would you like to keep?");
            System.out.println("Enter k in each position to keep and r for re-roll.");
            System.out.println("For example: kkkrr to keep the first 3 and re-roll the last 2");

            String keeps = input.next();

            for(int i = 0; i < 5; i++)
            {
                if(keeps.charAt(i) == 'k')
                {
                    //System.out.println("you wanted to keep the " + (i+1) + " die");
                }
                else if(keeps.charAt(i) == 'r')
                {
                    //System.out.println("you wanted to re-roll the " + (i+1) + " die");
                    hand.reRollADie(i+1);
                }
                else
                {
                    System.out.println("you entered something wrong");
                }
            }

            if(j < 2)
            {
                hand.printHand();
            }


        }

        System.out.println("That was your last re-roll.");
        System.out.println("Here is your final hand: ");
        hand.printHand();
        System.out.println("Here it is sorted:");
        hand.sortHand();
        hand.printHand();
        System.out.println();
        System.out.println("Okay, let's look at your possible scores.");
        hand.tallyHand();
        showPossibleScores();

        //System.out.println("Upper Section: \n");








    }
}
