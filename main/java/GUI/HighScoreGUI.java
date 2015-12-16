package main.java.GUI;

import main.java.HighscoreDB;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
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
    private JButton back;
    private JPanel upperPanel = null;
    private JPanel lowerPanel;
    private JPanel middelPanel;
    private JTextArea textArea = new JTextArea("HIGHSCORES\n", 20, 20);
    private JScrollPane scrollPane = new JScrollPane(textArea,
            JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
            JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
    ArrayList<String> highscores = new ArrayList<>();
    private CLayout c;

    public HighScoreGUI(CLayout c){
        this.c = c;
    }
    JLabel label = new JLabel();


    private JPanel buildUpperPanel() {
        JPanel upperPanel = new JPanel();
        JLabel picLabel = new JLabel(new ImageIcon("main/resources/loggo.png"));
        upperPanel.add(picLabel);

        upperPanel.setOpaque(false);

        return upperPanel;
    }

    private JPanel buildMiddelPanel() {
        JPanel middelPanel = new JPanel();
        middelPanel.setBackground(new Color(56, 134, 96));


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

        label.setFont(new Font("Arial", Font.PLAIN, 25));
        label.setForeground(Color.white);
        highscores.forEach((temp) -> label.setText("<html>"+ label.getText() +"\t\t\t" +"<br>"+temp+"<html>"));
        middelPanel.add(label);

        return middelPanel;
    }

    private JPanel buildLowerPanel() {
        JPanel lowerPanel = new JPanel();
        lowerPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
        lowerPanel.setBackground(new Color(56, 134, 96));

        JPanel soundPanel = new JPanel();
        soundPanel.setBackground(new Color(56, 134, 96));

        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(new Color(56, 134, 96));


        sound = new JButton(new ImageIcon("main/resources/sound.png"));
        sound.addMouseListener(new SoundListener(sound, c));
        sound.setBorderPainted(false);
        sound.setContentAreaFilled(false);
        sound.setFocusPainted(false);
        soundPanel.add(sound);

        back = new JButton(new ImageIcon("main/resources/backButton.png"));
        back.addMouseListener(new BackListener(back, c));
        back.setLayout(new FlowLayout(FlowLayout.LEFT));
        back.setBorderPainted(false);
        back.setContentAreaFilled(false);
        back.setFocusPainted(false);
        buttonPanel.add(back);


        lowerPanel.add(buttonPanel, BorderLayout.WEST);
        lowerPanel.add(soundPanel, BorderLayout.SOUTH);

        return lowerPanel;
    }
    /**
     *
     * @return The highscore GUI as a JPanel
     */
    public JPanel getPanel() {

        upperPanel = buildUpperPanel();
        middelPanel = buildMiddelPanel();
        lowerPanel = buildLowerPanel();

        panel.setBackground(new Color(56, 134, 96));
        panel.setLayout(new BorderLayout());

        //Add panels to the frame
        panel.add(upperPanel, BorderLayout.NORTH);
        panel.add(middelPanel, BorderLayout.CENTER);
        panel.add(lowerPanel, BorderLayout.SOUTH);

        return panel;
    }


}
