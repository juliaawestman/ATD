package src.GUI;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.*;
import java.io.File;
import java.io.IOException;

/**
 * Created by Joakim on 2015-11-30.
 */
public class MenuGUI {

    private JFrame frame;
    private JButton newGame;
    private JButton highScore;
    private JButton quit;
    private JButton sound;
    private CardLayout cardLayout = new CardLayout();
    private String gameTitle = "Anti Tower Defence";
    private String newGameTitle = "New Game";
    private String highScoreTitle = "High Score";
    private String quitTitle = "Quit";
    private String soundTitle = "Sound";
    private JPanel upperPanel = null;
    private JPanel middlePanel;
    private JPanel lowerPanel;

    public MenuGUI() {

        frame = new JFrame(gameTitle);
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








        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        upperPanel = buildUpperPanel();
        middlePanel = buildMiddlePanel();
        lowerPanel = buildLowerPanel();

        //Add panels to the frame
        frame.add(upperPanel, BorderLayout.NORTH);
        frame.add(middlePanel, BorderLayout.CENTER);
        frame.add(lowerPanel, BorderLayout.SOUTH);

        frame.setSize(600, 600);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setVisible(true);

    }

    private JPanel buildUpperPanel() {
        JPanel upperPanel = new JPanel();

        //BufferedImage myPicture = ImageIO.read(new File("loggo.png"));
        JLabel picLabel = new JLabel(new ImageIcon("loggo.png"));
        upperPanel.add(picLabel);

        upperPanel.setOpaque(false);

        return upperPanel;
    }

    private JPanel buildMiddlePanel() {
        JPanel middlePanel = new JPanel();

        newGame = new JButton(new ImageIcon("newGameButton.png"));
        newGame.addMouseListener(new NewGameListener(newGame));
        newGame.setBorderPainted(false);
        newGame.setContentAreaFilled(false);
        newGame.setFocusPainted(false);

        highScore = new JButton(new ImageIcon("highScoreButton.png"));
        highScore.addMouseListener(new HighScoreListener(highScore));
        highScore.setBorderPainted(false);
        highScore.setContentAreaFilled(false);
        highScore.setFocusPainted(false);

        quit = new JButton(new ImageIcon("quitButton.png"));
        quit.addMouseListener(new QuitListener(quit));
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

        sound = new JButton(new ImageIcon("sound.png"));
        sound.addMouseListener(new SoundListener(sound));

        sound.setBorderPainted(false);
        sound.setContentAreaFilled(false);
        sound.setFocusPainted(false);

        lowerPanel.add(sound);

        return lowerPanel;
    }

    public void show() {
        frame.setVisible(true);
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
