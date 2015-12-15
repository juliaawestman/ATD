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

        //BufferedImage myPicture = ImageIO.read(new File("loggo.png"));
        JLabel picLabel = new JLabel(new ImageIcon("main/resources/loggo.png"));
        JLabel victoryText = new JLabel();
        victoryText.setText("VICTORY ! ! ! !");
        victoryText.setFont(new Font("Arial", Font.ITALIC, 24));
        upperPanel.add(picLabel);

        upperPanel.setOpaque(false);

        return upperPanel;
    }

    private JPanel buildMiddlePanel() {
        JPanel middlePanel = new JPanel();
        middlePanel.setLayout(new BoxLayout(middlePanel, BoxLayout.Y_AXIS));
        middlePanel.setBackground(new Color(169,255,151));

        JPanel buttonPanelOver = new JPanel();
        buttonPanelOver.setBackground(new Color(169,255,151));

        JPanel buttonPanelMiddle = new JPanel();
        buttonPanelMiddle.setBackground(new Color(169,255,151));

        JPanel buttonPanelUnder = new JPanel();
        buttonPanelUnder.setBackground(new Color(169,255,151));

        newGame = new JButton(new ImageIcon("main/resources/newGameButton.png"));
        newGame.addMouseListener(new NewGameListener(newGame, c));
        newGame.setBorderPainted(false);
        newGame.setContentAreaFilled(false);
        newGame.setFocusPainted(false);
        buttonPanelOver.add(newGame);

        highScore = new JButton(new ImageIcon("main/resources/highScoreButton.png"));
        highScore.addMouseListener(new HighScoreListener(highScore, c));
        highScore.setBorderPainted(false);
        highScore.setContentAreaFilled(false);
        highScore.setFocusPainted(false);
        buttonPanelMiddle.add(highScore);

        quit = new JButton(new ImageIcon("main/resources/quitButton.png"));
        quit.addMouseListener(new QuitListener(quit, c));
        quit.setBorderPainted(false);
        quit.setContentAreaFilled(false);
        quit.setFocusPainted(false);
        buttonPanelUnder.add(quit);


        middlePanel.add(buttonPanelOver, BorderLayout.NORTH);
        middlePanel.add(buttonPanelMiddle, BorderLayout.CENTER);
        middlePanel.add(buttonPanelUnder, BorderLayout.SOUTH);

        return middlePanel;

    }

    private JPanel buildLowerPanel() {
        JPanel lowerPanel = new JPanel();
        lowerPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
        lowerPanel.setBackground(new Color(169,255,151));

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
        panel.setBackground(new Color(169,255,151));
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
