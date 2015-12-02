package main.java.GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

/**
 * Created by Zacke on 2015-11-26.
 */
public class GameGUI {

    private JFrame frame;

    private JButton blackButton;
    private JButton redButton;
    private JButton greenButton;

    private JCheckBox disableCheckBox;

    private JTextField textField;


    //Should only be called on EDT
    public GameGUI(String title) {
        frame=new JFrame(title);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Build panels
        JPanel upperPanel = buildUpperPanel();
        JPanel middlePanel = buildMiddlePanel();
        JPanel lowerPanel = buildLowerPanel();

        //Add panels to the frame
        frame.add(upperPanel, BorderLayout.NORTH);
        frame.add(middlePanel, BorderLayout.CENTER);
        frame.add(lowerPanel, BorderLayout.SOUTH);

        frame.pack();

    }

    //Should only be called on EDT
    public void show() {
        frame.setVisible(true);
    }

    private JPanel buildLowerPanel() {
        JPanel lowerPanel = new JPanel();
        lowerPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));

        disableCheckBox = new JCheckBox("Inga fÃ¶rÃ¤ndringar");
        disableCheckBox.addItemListener(new ItemListener() {

                                            public void itemStateChanged(ItemEvent e) {
                                                boolean enabled =
                                                        e.getStateChange() == ItemEvent.DESELECTED;
                                                blackButton.setEnabled( enabled );
                                                redButton.setEnabled( enabled );
                                                greenButton.setEnabled( enabled );
                                            }

                                        }

        );

        lowerPanel.add(disableCheckBox);
        return lowerPanel;
    }

    private JPanel buildMiddlePanel() {
        JPanel middlePanel = new JPanel();
        middlePanel.setBorder(BorderFactory.createTitledBorder("TextfÃ¤rgskontroll"));
        middlePanel.setLayout(new FlowLayout(FlowLayout.CENTER));

        blackButton = new JButton("Svart");
        //blackButton.addActionListener(new NewGameListener());

        middlePanel.add(blackButton);

        redButton = new JButton("RÃ¶tt");
        //redButton.addActionListener(new NewGameListener());

        middlePanel.add(redButton);

        greenButton = new JButton("GrÃ¶nt");
        //greenButton.addActionListener(new NewGameListener());

        middlePanel.add(greenButton);
        return middlePanel;
    }

    private JPanel buildUpperPanel() {
        JPanel upperPanel = new JPanel();
        upperPanel.setBorder(BorderFactory.createTitledBorder("Exempel"));
        upperPanel.setLayout(new BorderLayout());

        textField = new JTextField("Byt fÃ¤rg pÃ¥ texten");
        upperPanel.add(textField, BorderLayout.CENTER);
        return upperPanel;
    }


}
