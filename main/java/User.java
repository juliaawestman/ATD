package main.java;

/**
 * Created by juliawestman on 2015-12-06.
 */
public class User {
    private int points;
    private int credits;
    private int income;

    public User (int points, int credits, int income) {
        this.points = points;
        this.credits = credits;
        this.income = income;

    }

    public boolean useIncome(int useIncome){
        if(income >= useIncome){
            return true;
        }
        else {
            return false;
        }
    }

    public int getCredits(){
        return credits;
    }

    public void income(int incomeToAdd){
        income = income + incomeToAdd;
    }

    public int getScore(){
        return  points;
    }

    public void addPoints(int pointsToAdd){
        points = points + pointsToAdd;
    }

    public void increaseIncome(int incomeToIncreasse){
        income = income - incomeToIncreasse;
    }

    public int getIncome(){
        return income;
    }

}
