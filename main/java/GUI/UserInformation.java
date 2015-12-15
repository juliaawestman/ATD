package main.java.GUI;

/**
 * Created by id12jzn on 2015-12-15.
 */
public interface UserInformation {

    public boolean canBuyUnit(int i);

    public String getUnitPath(int i);

    public int getUnitCost(int i);

    public void withdrawCredits(int i);

    public void updateUsername(String s);

}
