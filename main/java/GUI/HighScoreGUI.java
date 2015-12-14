package main.java.GUI;

import main.java.HighscoreDB;

import javax.swing.*;
import java.awt.*;
import java.awt.List;
import java.util.*;
/**
 * Class HighScoreGUI
 * Builds the GUI for the highscore panel
 *
 * Created by Joakim on 2015-12-02.
 */
public class HighScoreGUI {

    private JFrame frame;
    private JPanel panel = new JPanel();
    private JButton newGame;
    private JButton highScore;
    private JButton quit;
    private JButton sound;
    private JPanel upperPanel = null;
    private JPanel lowerPanel;
    private JTextArea textArea = new JTextArea("HIGHSCORES\n", 20, 20);
    private JScrollPane scrollPane = new JScrollPane(textArea,
            JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
            JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
    //private java.util.List<java.util.List<String>> allHighscores = new ArrayList<>();
    ArrayList<String> highscores = new ArrayList<>();

    JLabel label = new JLabel();







    private JPanel buildUpperPanel() {
        JPanel upperPanel = new JPanel();

        //BufferedImage myPicture = ImageIO.read(new File("loggo.png"));
        JLabel picLabel = new JLabel(new ImageIcon("main/resources/loggo.png"));
        upperPanel.add(picLabel);

        upperPanel.setOpaque(false);

        return upperPanel;
    }

    private JPanel buildLowerPanel() {
        JPanel lowerPanel = new JPanel();
        lowerPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        //lowerPanel.setLayout(new BorderLayout());

/*
        scrollPane.setOpaque(false);
        scrollPane.getViewport().setOpaque(false);
        scrollPane.setBorder(null);
        scrollPane.setViewportBorder(null);

        textArea.setEditable(false);
        textArea.setBorder(null);
        textArea.setBackground(new Color(0, 0, 0, 155));
        */





        HighscoreDB dbs = new HighscoreDB();
        highscores = dbs.getData();
        //textArea.append(dbs.getData());
        //String temp2;
        //highscores.forEach((temp) -> textArea.append("\n"+temp));
        highscores.forEach((temp) -> label.setText("<html>"+label.getText()+"<br>"+temp+"<html>"));
        label.setFont(new Font("Arial", Font.ITALIC, 18));
        lowerPanel.add(label);

        return lowerPanel;
    }

    /**
     *
     * @return The highscore GUI as a JPanel
     */
    public JPanel getPanel() {

        upperPanel = buildUpperPanel();
        lowerPanel = buildLowerPanel();

        panel.setLayout(new BorderLayout());

        //Add panels to the frame
        panel.add(upperPanel, BorderLayout.NORTH);
        panel.add(lowerPanel, BorderLayout.CENTER);

        return panel;
    }


}
