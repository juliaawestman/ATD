package main.java.GUI;

import javax.swing.*;
import java.awt.*;

/**
 * Created by juliawestman on 2015-12-15.
 */
public class AboutGUI extends JPanel {

    private CLayout c;
    private JButton sound;
    private JPanel panel= new JPanel();;
    private JPanel upperPanel;
    private JPanel middlePanel;
    private JPanel lowerPanel;

    public AboutGUI(CLayout c) {
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
        middlePanel.setLayout(new BoxLayout(middlePanel, BoxLayout.Y_AXIS));
        middlePanel.setBackground(new Color(169,255,151));

        JPanel buttonPanelOver = new JPanel();
        buttonPanelOver.setPreferredSize(new Dimension(400, 45));
        buttonPanelOver.setBackground(new Color(169,255,151));

        JPanel buttonPanelUnder = new JPanel();
        buttonPanelUnder.setPreferredSize(new Dimension(400, 45));
        buttonPanelUnder.setBackground(new Color(169,255,151));


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

        lowerPanel.add(sound, new FlowLayout(FlowLayout.RIGHT));

        return lowerPanel;
    }

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
