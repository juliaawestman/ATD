package main.java;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
/**
 * Created by juliawestman on 2015-12-06.
 */
public class User {
    private int points;
    private int credits;
    private int income;
    private String userName;
    private String map;
    private String currentDate;


    public User (int credits, int income) {
        this.credits = credits;
        this.income = income;

    }


    public void setCurrentDate(){
        currentDate =  new java.sql.Date(System.currentTimeMillis()).toString();
    }

    public String getCurrentDate() {
        return currentDate;
    }

    public void setCredits(int creditsToSet){
        credits = creditsToSet;
    }

    public int getCredits(){
        return credits;
    }

    public void setIncome(int incomeToSet){
        income = incomeToSet;
    }

    public int getIncome(){
        return income;
    }

    public int getScore(){
        return  points;
    }

    public void setPoints(int pointsToSet){
        points = pointsToSet;
    }

    public void setUserName(String name){
        userName = name;
    }

    public String getUserName(){
        return userName;
    }

    public void setMap(String map) {
        this.map = map;
    }

    public String getMap() {
        return map;
    }

    public void increaseCredits(int value){
        this.credits = this.credits+credits;
    }

    public void decreaseCredits(int value){
        this.credits = this.credits - value;
    }


}
