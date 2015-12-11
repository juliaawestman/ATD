package main.java;

import java.sql.*;

/**
 * Created by Joakim on 2015-12-11.
 */
public class HighscoreDB {

    private Connection conn;
    private Statement st = null;

    private String user = "SA";

    private String password = "";

    private User u;

    final private String sqlCreateTable = "CREATE TABLE HIGHSCORE(id INTEGER IDENTITY, userName VARCHAR(30), wave integer, level VARCHAR(30), date VARCHAR(30))";
    final private String sqlAddHighscore = "insert into highscore (userName, wave, level, date) values (?,?,?,?)";

    //private String url = "jdbc:hsqldb:hsql://localhost";
    private String url = "jdbc:hsqldb:file:highscore";
    // url jdbc:hsqldb:hsql://itchy.cs.umu.se:28282/highscore

    public HighscoreDB(User u) throws Exception {

        this.u = u;

        try {
        Class.forName("org.hsqldb.jdbcDriver");
    } catch (Exception e) {
            System.out.println("ERROR: failed to load HSQLDB JDBC driver.");
            e.printStackTrace();
            return;
        }

        conn = DriverManager.getConnection(url, user, password);
        //"jdbc:hsqldb:"

        st = conn.createStatement();

        setup();

        addUser(u);
        getData();

    }

    public void setup() {
        try {
            st.execute(sqlCreateTable);
        } catch (SQLException e) {
            System.err.println("Something went horrible wrong during setup");
            e.printStackTrace();
        }
    }

    public void shutdown() throws SQLException {

        Statement st = conn.createStatement();

        // db writes out to files and performs clean shuts down
        // otherwise there will be an unclean shutdown
        // when program ends
        st.execute("SHUTDOWN");
        conn.close();    // if there are no other open connection
    }

    public void addUser(User u) {
        /*
        try {
            if (psAddUser == null) {
                psAddUser = conn.prepareStatement(sqlAddUser);
            }
            psAddUser.setString(1, u.getUserName());
            psAddUser.setInt(2, u.getScore());
            psAddUser.setString(3, u.getMap());
            psAddUser.setString(4, u.getCurrentDate());
            psAddUser.executeUpdate();

            */
        String userName = u.getUserName();
        int wave = u.getScore();
        String map = u.getMap();
        String date = u.getCurrentDate();

        String sql = "INSERT INTO HIGHSCORE " + "VALUES (5,"+"'"+userName+"'"+", "+ wave + ", "+ "'"+map+"'" + ", " + "'"+date+"')";
        try {
            st.executeUpdate(sql);
        } catch (SQLException e) {
            System.err.println("Couldn't create add user");
            e.printStackTrace();
        }
    }

    private void getData() {
        String sql = "SELECT id, userName, wave, level, date FROM highscore";
        ResultSet rs = null;
        try {
            rs = st.executeQuery(sql);

            while (rs.next()) {
                int id = rs.getInt("id");
                String userName = rs.getString("userName");
                int wave = rs.getInt("wave");
                String level = rs.getString("level");
                String date = rs.getString("date");

                System.out.print("ID " + id);
                System.out.print(", User: " + userName);
                System.out.print(", Wave: " + wave);
                System.out.print(", Level: " + level);
                System.out.println(", Date: " + date);

            }
        }catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
