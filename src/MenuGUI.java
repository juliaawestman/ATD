package src;

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
    private CardLayout cardLayout = new CardLayout();
    private String gameTitle = "Anti defence";
    private JPanel upperPanel = null;
    private JPanel lowerPanel;
    private JPanel soundPanel;

    public MenuGUI() {

        frame = new JFrame(gameTitle);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        try {
            upperPanel = buildUpperPanel();
        } catch (IOException e) {
            e.printStackTrace();
        }
        lowerPanel = buildLowerPanel();
        soundPanel = buildSoundPanel();

        //Add panels to the frame
        frame.add(upperPanel, BorderLayout.NORTH);
        frame.add(lowerPanel, BorderLayout.SOUTH);
        frame.add(soundPanel, BorderLayout.SOUTH);

        frame.setSize(600, 600);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);

    }

    private JPanel buildUpperPanel() throws IOException {
        JPanel upperPanel = new JPanel();
        upperPanel.setLayout(new FlowLayout(FlowLayout.CENTER));

        BufferedImage myPicture = ImageIO.read(new File("loggo.png"));
        JLabel picLabel = new JLabel(new ImageIcon(myPicture));
        upperPanel.add(picLabel);

        return upperPanel;
    }

    private JPanel buildLowerPanel() {
        JPanel lowerPanel = new JPanel();
        lowerPanel.setLayout(new FlowLayout(FlowLayout.CENTER));

        return lowerPanel;
    }

    private JPanel buildSoundPanel() {
        JPanel soundPanel = new JPanel();
        soundPanel.setLayout(new FlowLayout(FlowLayout.CENTER));

        //Icon i=new ImageIcon("image.jpg");
        //jButton1.setIcon(i);

        return soundPanel;

    }

    public void show() {
        frame.setVisible(true);
    }
}
