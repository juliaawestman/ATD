package main.java.GUI;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * Created by Joakim on 2015-12-02.
 */
public class NewGameGUI {

    private ArrayList<String> levels;
    private JComboBox levelList = new JComboBox<String>();
    private JPanel panel = new JPanel();
    private JButton newGame;
    private JButton quit;
    private JButton sound;
    private CLayout c;

    public NewGameGUI(CLayout c){
        this.c = c;
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
        //middlePanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        updateLevels();
        levelList = new JComboBox(levels.toArray());
        middlePanel.add(levelList);

        return middlePanel;
    }

    private JPanel buildLowerPanel() {
        JPanel lowerPanel = new JPanel();

        newGame = new JButton(new ImageIcon("main/resources/newGameButton.png"));
        newGame.addMouseListener(new StartGameListener(newGame, c, levelList));
        newGame.setBorderPainted(false);
        newGame.setContentAreaFilled(false);
        newGame.setFocusPainted(false);

        quit = new JButton(new ImageIcon("main/resources/quitButton.png"));
        quit.addMouseListener(new QuitListener(quit, c));
        quit.setBorderPainted(false);
        quit.setContentAreaFilled(false);
        quit.setFocusPainted(false);


        lowerPanel.add(newGame);
        lowerPanel.add(quit);

        return lowerPanel;
    }

    private JPanel buildSoundPanel() {
        JPanel soundPanel = new JPanel();
        soundPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));

        sound = new JButton(new ImageIcon("main/resources/sound.png"));
        sound.addMouseListener(new SoundListener(sound));

        sound.setBorderPainted(false);
        sound.setContentAreaFilled(false);
        sound.setFocusPainted(false);

        soundPanel.add(sound);

        return soundPanel;
    }

    public JPanel getPanel() {

        panel.setLayout(new BorderLayout());

        //Add panels to the frame
        panel.add(buildUpperPanel(), BorderLayout.NORTH);
        panel.add(buildMiddlePanel(), BorderLayout.CENTER);
        panel.add(buildLowerPanel(), BorderLayout.SOUTH);
        //panel.add(buildSoundPanel(), BorderLayout.SOUTH);

        return panel;
    }

    private void updateLevels() {

        levels = c.mapinfo.getLevelName();

    }
}
