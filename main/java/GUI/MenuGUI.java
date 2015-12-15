package main.java.GUI;

import javax.swing.*;
import java.awt.*;

/**
 * Class: MenuGUI
 * Builds the starting menu for when the application is starting
 *
 * Created by Joakim on 2015-11-30.
 */
public class MenuGUI {

    private JFrame frame;
    private JPanel panel = new JPanel();
    private JButton newGame;
    private JButton highScore;
    private JButton quit;
    private JButton sound;
    private String gameTitle = "Anti tower Defence";
    private JPanel upperPanel = null;
    private JPanel middlePanel;
    private JPanel lowerPanel;


    private CLayout c;

    public MenuGUI(CLayout c) {
        this.c = c;


        //frame = new JFrame(gameTitle);
/*
        try {
            frame.setContentPane(new ImagePanel(ImageIO.read(new File("startBack.png"))));
        } catch (IOException e) {
            e.printStackTrace();
        } */

        //frame.setContentPane(new JLabel(bg));

        //ImageLabel bg = new JLabel(new ImageIcon("startBack.png"));
        //frame.setContentPane(bg);
/*
        JLabel background = new JLabel(new ImageIcon("startBack.png"));
        frame.add(background);
        background.setLayout(new FlowLayout());

        */







/*
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        */

/*
        upperPanel = buildUpperPanel();
        middlePanel = buildMiddlePanel();
        lowerPanel = buildLowerPanel();

        //Add panels to the frame
        panel.add(upperPanel, BorderLayout.NORTH);
        panel.add(middlePanel, BorderLayout.CENTER);
        panel.add(lowerPanel, BorderLayout.SOUTH);

        */



        /*
        frame.setSize(600, 600);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setVisible(true);
        */

    }

    private JPanel buildUpperPanel() {
        JPanel upperPanel = new JPanel();

        //BufferedImage myPicture = ImageIO.read(new File("loggo.png"));
        JLabel picLabel = new JLabel(new ImageIcon("main/resources/loggo.png"));
        upperPanel.add(picLabel);

        upperPanel.setOpaque(false);

        return upperPanel;
    }

    private JPanel buildMiddlePanel() {
        JPanel middlePanel = new JPanel();
        middlePanel.setBackground(new Color(169,255,151));

        newGame = new JButton(new ImageIcon("main/resources/newGameButton.png"));
        newGame.addMouseListener(new NewGameListener(newGame, c));
        newGame.setBorderPainted(false);
        newGame.setContentAreaFilled(false);
        newGame.setFocusPainted(false);

        highScore = new JButton(new ImageIcon("main/resources/highScoreButton.png"));
        highScore.addMouseListener(new HighScoreListener(highScore, c));
        highScore.setBorderPainted(false);
        highScore.setContentAreaFilled(false);
        highScore.setFocusPainted(false);

        quit = new JButton(new ImageIcon("main/resources/quitButton.png"));
        quit.addMouseListener(new QuitListener(quit, c));
        quit.setBorderPainted(false);
        quit.setContentAreaFilled(false);
        quit.setFocusPainted(false);


        middlePanel.add(newGame);
        middlePanel.add(highScore);
        middlePanel.add(quit);

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
/*
class ImagePanel extends JComponent {
    private Image image;
    public ImagePanel(Image image) {
        this.image = image;
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 0, 0, this);
    }
}
*/
