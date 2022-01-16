package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class HandOfDice
{
    private ArrayList<Die> hand;

    public int ones = 0;
    public int twos = 0;
    public int threes = 0;
    public int fours = 0;
    public int fives = 0;
    public int sixes = 0;
    public boolean pair = false;
    public boolean triple = false;
    public boolean quad = false;
    public boolean fullHouse = false;
    public boolean smStraight = false;
    public boolean lgStraight = false;
    public boolean yahtzee = false;
    public int handSum = 0;

    public ArrayList<Die> getHand() {
        return hand;
    }

    public void setHand(ArrayList<Die> hand) {
        this.hand = hand;
    }

    public void initDice()
    {
        hand = new ArrayList<Die> ();
        for(int i = 0; i < 5; i++)
        {
            Die d = new Die();
            hand.add(d);
        }
    }

    public void rollAllDice()
    {
        for(Die d : hand)
        {
            d.roll();
        }
    }

    public void printHand()
    {
        System.out.print("Your hand is: ");
        for(Die d : hand)
        {
            System.out.print(d.getFaceValue() + " ");
        }
        System.out.println();
    }

    public void reRollADie(int index)
    {
        Die d = new Die();
        d.roll();
        hand.set((index - 1), d);

    }

    public void sortHand()
    {
        Collections.sort(hand);
    }

    public void tallyHand()
    {
        for(Die d : hand)
        {
            if(d.getFaceValue() == 1)
            {
                ones++;
                handSum += 1;
            }

            if(d.getFaceValue() == 2)
            {
                twos++;
                handSum += 2;
            }

            if(d.getFaceValue() == 3)
            {
                threes++;
                handSum += 3;
            }

            if(d.getFaceValue() == 4)
            {
                fours++;
                handSum += 4;
            }

            if(d.getFaceValue() == 5)
            {
                fives++;
                handSum += 5;
            }

            if(d.getFaceValue() == 6)
            {
                sixes++;
                handSum += 6;
            }
        }

        if((ones == 2) || (twos == 2) || (threes == 2) || (fours == 2) || (fives == 2) || (sixes == 2))
        {
            pair = true;
        }

        if((ones > 2) || (twos > 2) || (threes > 2) || (fours > 2) || (fives > 2) || (sixes > 2))
        {
             triple = true;
        }

        if((ones > 3) || (twos > 3) || (threes > 3) || (fours > 3) || (fives > 3) || (sixes > 3))
        {
             quad = true;
        }

        if((pair) && (triple))
        {
            fullHouse = true;
        }

        if(     (ones>0 && twos>0 && threes>0 && fours>0)     ||
                (twos>0 && threes>0 && fours>0 && fives>0)    ||
                (threes>0 && fours>0 && fives>0 && sixes>0)   )
        {
            smStraight = true;
        }

        if(    (ones>0 && twos>0 && threes>0 && fours>0 && fives>0)     ||
              (twos>0 && threes>0 && fours>0 && fives>0 && sixes>0)      )
        {
            lgStraight = true;
        }

        if(ones>4 || twos>4 || threes>4 || fours>4 || fives>4 || sixes>4)
        {
            yahtzee = true;
        }


    }






}
