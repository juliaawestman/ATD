package main.java.GUI;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * Class: NewGameGUI
 * Class for creating the GUI for the new game menu
 *
 * Created by Joakim on 2015-12-02.
 */
public class NewGameGUI {

    private ArrayList<String> levels;
    private JComboBox levelList = new JComboBox<String>();
    private JPanel panel = new JPanel();
    private JButton newGame;
    private JButton back;
    private JButton sound;
    private CLayout c;

    public NewGameGUI(CLayout c){
        this.c = c;
    }

    /**
     *
     * @return
     */
    private JPanel buildUpperPanel() {
        JPanel upperPanel = new JPanel();

        //BufferedImage myPicture = ImageIO.read(new File("loggo.png"));
        JLabel picLabel = new JLabel(new ImageIcon("main/resources/loggo.png"));
        upperPanel.add(picLabel);

        upperPanel.setOpaque(false);

        return upperPanel;
    }

    /**
     *
     * @return
     */
    private JPanel buildMiddlePanel() {
        JPanel middlePanel = new JPanel();
        middlePanel.setBackground(new Color(169,255,151));
        middlePanel.setLayout(new BoxLayout(middlePanel, BoxLayout.Y_AXIS));

        JPanel levelListPanel = new JPanel();
        levelListPanel.setBackground(new Color(169,255,151));

        JPanel buttonPanelOver = new JPanel();
        buttonPanelOver.setBackground(new Color(169,255,151));

        JPanel buttonPanelUnder = new JPanel();
        buttonPanelUnder.setBackground(new Color(169,255,151));

        //middlePanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        updateLevels();
        levelList = new JComboBox(levels.toArray());

        levelListPanel.add(levelList);
        middlePanel.add(levelListPanel, BorderLayout.NORTH);

        back = new JButton(new ImageIcon("main/resources/backButton.png"));
        back.addMouseListener(new BackListener(back, c));
        back.setBorderPainted(false);
        back.setContentAreaFilled(false);
        back.setFocusPainted(false);
        buttonPanelUnder.add(back);

        newGame = new JButton(new ImageIcon("main/resources/newGameButton.png"));

        newGame.addMouseListener(new StartGameListener(newGame, c, levelList));
        newGame.setBorderPainted(false);
        newGame.setContentAreaFilled(false);
        newGame.setFocusPainted(false);
        buttonPanelOver.add(newGame);



        middlePanel.add(buttonPanelOver, BorderLayout.CENTER);
        middlePanel.add(buttonPanelUnder, BorderLayout.SOUTH);

        return middlePanel;
    }

    /**
     *
     * @return
     */
    private JPanel buildLowerPanel() {
        JPanel lowerPanel = new JPanel();
        lowerPanel.setBackground(new Color(169,255,151));

        back = new JButton(new ImageIcon("main/resources/backButton.png"));
        back.addMouseListener(new BackListener(back, c));
        back.setBorderPainted(false);
        back.setContentAreaFilled(false);
        back.setFocusPainted(false);

        newGame = new JButton(new ImageIcon("main/resources/newGameButton.png"));
        newGame.addMouseListener(new StartGameListener(newGame, c, levelList));
        newGame.setBorderPainted(false);
        newGame.setContentAreaFilled(false);
        newGame.setFocusPainted(false);


        lowerPanel.add(back);
        lowerPanel.add(newGame);

        return lowerPanel;
    }

    private JPanel buildSoundPanel() {
        JPanel soundPanel = new JPanel();
        soundPanel.setBackground(new Color(169,255,151));
        soundPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));

        sound = new JButton(new ImageIcon("main/resources/sound.png"));
        sound.addMouseListener(new SoundListener(sound, c));

        sound.setBorderPainted(false);
        sound.setContentAreaFilled(false);
        sound.setFocusPainted(false);

        soundPanel.add(sound);

        return soundPanel;
    }

    /**
     *
     * @return A panel that shows the game menu after "New game" is pressed
     */
    public JPanel getPanel() {

        panel.setBackground(new Color(169,255,151));
        panel.setLayout(new BorderLayout());

        //Add panels to the frame
        panel.add(buildUpperPanel(), BorderLayout.NORTH);
        panel.add(buildMiddlePanel(), BorderLayout.CENTER);
        panel.add(buildSoundPanel(), BorderLayout.SOUTH);

        return panel;
    }

    /**
     * Updates the level name
     */
    private void updateLevels() {

        levels = c.mapinfo.getLevelName();

    }
}
