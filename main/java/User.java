package main.java;
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
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

/* TODO create increase/decrease methods instead of get/set for certain values */
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
        this.credits = this.credits+value;
    }

    public GraphicEvent generateGraphicEvent() {
        BufferedImage img = null;

        /*Make the image*/
        BufferedImage laser = new BufferedImage(100, 100, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g = laser.createGraphics();
        g.setColor(new Color(255, 0, 3));
        g.setStroke(new BasicStroke(2));
        g.drawString(String.valueOf(this.credits),10,10);

        return new GraphicEvent(999,new Position(70,70),laser);
    }

    public void decreaseCredits(int value){
        this.credits = this.credits - value;
    }


}
