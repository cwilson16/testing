package com.company;

import java.util.Random;

public class Die implements Comparable<Die>
{
    private int faceValue;

    public int getFaceValue() {
        return faceValue;
    }

    public void setFaceValue(int faceValue) {
        this.faceValue = faceValue;
    }

    public void roll()
    {
        Random rand = new Random();
        faceValue = rand.nextInt(6) + 1;
    }

    @Override public int compareTo(Die d)
    {
        if(this.getFaceValue() > d.getFaceValue())
        {
            return 1;
        }
        else if(this.getFaceValue() < d.getFaceValue())
        {
            return -1;
        }
        else
        {
            return 0;
        }
    }


}
