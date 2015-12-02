package main.java.GUI;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * Created by Joakim on 2015-12-02.
 */
public class NewGameGUI {

    private ArrayList<String> levels;
    private JComboBox<String> levelList;
    private JFrame frame;
    private JPanel panel = new JPanel();
    private JButton newGame;
    private JButton highScore;
    private JButton quit;
    private JButton sound;
    private JButton start;
    private JPanel upperPanel = null;
    private JPanel middlePanel;
    private JPanel lowerPanel;
    private JPanel soundPanel;
    private JTextArea textArea = new JTextArea("Använvdare 1 - 2000p", 20, 20);
    private JScrollPane scrollPane = new JScrollPane(textArea,
            JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
            JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

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
        //lowerPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        //lowerPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
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

        upperPanel = buildUpperPanel();
        middlePanel = buildMiddlePanel();
        lowerPanel = buildLowerPanel();
        soundPanel = buildSoundPanel();

        panel.setLayout(new BorderLayout());

        //Add panels to the frame
        panel.add(upperPanel, BorderLayout.NORTH);
        panel.add(middlePanel, BorderLayout.CENTER);
        panel.add(lowerPanel, BorderLayout.SOUTH);
        panel.add(soundPanel, BorderLayout.SOUTH);

        return panel;
    }

    private void updateLevels() {

        levels.add("a");
        levels.add("b");
        levels.add("c");
    }


}
