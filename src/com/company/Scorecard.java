package com.company;

public class Scorecard
{
    private UpperSection upper;
    private LowerSection lower;
    private int grandTotal;

    public UpperSection getUpper() {
        return upper;
    }

    public void setUpper(UpperSection upper) {
        this.upper = upper;
    }

    public LowerSection getLower() {
        return lower;
    }

    public void setLower(LowerSection lower) {
        this.lower = lower;
    }

    public int getGrandTotal() {
        return grandTotal;
    }

    public void setGrandTotal(int grandTotal) {
        this.grandTotal = grandTotal;
    }

    public void calcScore()
    {
        grandTotal = upper.getUpperTotal() + lower.getLowerTotal();

    }
}
