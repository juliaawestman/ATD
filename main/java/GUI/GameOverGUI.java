package main.java.GUI;

import javax.swing.*;
import java.awt.*;

/**
 * Created by id12jzn on 2015-12-15.
 */
public class GameOverGUI {

    private CLayout c;
    private JPanel panel = new JPanel();
    private JButton ok;
    private JButton sound;
    private JButton newGame;
    private JButton quit;
    private JButton highScore;
    private JPanel upperPanel = null;
    private JPanel middlePanel = null;
    private JPanel lowerPanel;

    public GameOverGUI(CLayout c) {
        this.c = c;

    }

    private JPanel buildUpperPanel() {
        JPanel upperPanel = new JPanel();
        JPanel space = new JPanel();
        space.setBackground(new Color(56, 134, 96));
        space.setPreferredSize(new Dimension(800,100));
        upperPanel.setPreferredSize(new Dimension(400, 200));
        //BufferedImage myPicture = ImageIO.read(new File("loggo.png"));
        //JLabel picLabel = new JLabel(new ImageIcon("main/resources/loggo.png"));
        JLabel victoryText = new JLabel();
        if (c.userinfo.gameOver() == true){
            victoryText.setText("<html>"+"YOU LOSE!!!"+"<br>"+"Score 123"+"<html>");
        } else {
            victoryText.setText("<html>"+"YOU WIN!!!"+"<br>"+"Score 123"+"<html>");
        }

        victoryText.setFont(new Font("Arial", Font.ITALIC, 35));
        victoryText.setForeground(Color.white);
        upperPanel.setBackground(new Color(56, 134, 96));
        upperPanel.add(space);
        upperPanel.add(victoryText);

        //upperPanel.setOpaque(false);

        return upperPanel;
    }

    private JPanel buildMiddlePanel() {
        JPanel middlePanel = new JPanel();
        middlePanel.setLayout(new BoxLayout(middlePanel, BoxLayout.Y_AXIS));
        middlePanel.setBackground(new Color(56, 134, 96));

        /*

        JPanel buttonPanelOver = new JPanel();
        buttonPanelOver.setBackground(new Color(169,255,151));

        JPanel buttonPanelMiddle = new JPanel();
        buttonPanelMiddle.setBackground(new Color(169,255,151));

        JPanel buttonPanelUnder = new JPanel();
        buttonPanelUnder.setBackground(new Color(169,255,151));

        JPanel textfieldPanel = new JPanel();
        textfieldPanel.setBackground(new Color(169,255,151));

        textfieldPanel.add(textfield);

        */

        newGame = new JButton(new ImageIcon("main/resources/newGameButton.png"));
        newGame.addMouseListener(new NewGameListener(newGame, c));
        newGame.setBorderPainted(false);
        newGame.setContentAreaFilled(false);
        newGame.setFocusPainted(false);
        //buttonPanelOver.add(newGame);

        highScore = new JButton(new ImageIcon("main/resources/highScoreButton.png"));
        highScore.addMouseListener(new HighScoreListener(highScore, c));
        highScore.setBorderPainted(false);
        highScore.setContentAreaFilled(false);
        highScore.setFocusPainted(false);
        //buttonPanelMiddle.add(highScore);

        quit = new JButton(new ImageIcon("main/resources/QuitButton.png"));
        quit.addMouseListener(new QuitListener(quit, c));
        quit.setBorderPainted(false);
        quit.setContentAreaFilled(false);
        quit.setFocusPainted(false);
        //buttonPanelUnder.add(quit);

        newGame.setAlignmentX(JComponent.CENTER_ALIGNMENT);
        middlePanel.add(newGame);
        highScore.setAlignmentX(JComponent.CENTER_ALIGNMENT);
        middlePanel.add(highScore);
        quit.setAlignmentX(JComponent.CENTER_ALIGNMENT);
        middlePanel.add(quit);

        return middlePanel;

    }

    private JPanel buildLowerPanel() {
        JPanel lowerPanel = new JPanel();
        lowerPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
        lowerPanel.setBackground(new Color(56, 134, 96));

        sound = new JButton(new ImageIcon("main/resources/sound.png"));
        sound.addMouseListener(new SoundListener(sound, c));

        sound.setBorderPainted(false);
        sound.setContentAreaFilled(false);
        sound.setFocusPainted(false);

        lowerPanel.add(sound);

        return lowerPanel;
    }



    /**
     *
     * @return The main menu GUI as a JPanel
     */
    public JPanel getPanel() {
        //panel.setBackground(new Color(169,255,151));
        upperPanel = buildUpperPanel();
        middlePanel = buildMiddlePanel();
        lowerPanel = buildLowerPanel();

        panel.setLayout(new BorderLayout());


        //Add panels to the frame
        panel.add(upperPanel, BorderLayout.NORTH);
        panel.add(middlePanel, BorderLayout.CENTER);
        panel.add(lowerPanel, BorderLayout.SOUTH);

        return panel;
    }
}
