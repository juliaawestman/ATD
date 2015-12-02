package main.java.GUI;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Joakim on 2015-12-02.
 */
public class HighScoreGUI {

    private JFrame frame;
    private JPanel panel = new JPanel();
    private JButton newGame;
    private JButton highScore;
    private JButton quit;
    private JButton sound;
    private JPanel upperPanel = null;
    private JPanel lowerPanel;
    private JTextArea textArea = new JTextArea("Använvdare 1 - 2000p", 20, 20);
    private JScrollPane scrollPane = new JScrollPane(textArea,
            JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
            JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

    private JPanel buildUpperPanel() {
        JPanel upperPanel = new JPanel();

        //BufferedImage myPicture = ImageIO.read(new File("loggo.png"));
        JLabel picLabel = new JLabel(new ImageIcon("src/main/resources/loggo.png"));
        upperPanel.add(picLabel);

        upperPanel.setOpaque(false);

        return upperPanel;
    }

    private JPanel buildLowerPanel() {
        JPanel lowerPanel = new JPanel();
        //lowerPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        lowerPanel.setLayout(new BorderLayout());
        lowerPanel.add(scrollPane);

        return lowerPanel;
    }

    public JPanel getPanel() {

        upperPanel = buildUpperPanel();
        lowerPanel = buildLowerPanel();

        panel.setLayout(new BorderLayout());

        //Add panels to the frame
        panel.add(upperPanel, BorderLayout.NORTH);
        panel.add(lowerPanel, BorderLayout.SOUTH);

        return panel;
    }


}
