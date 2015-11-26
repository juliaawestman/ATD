package src;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Created by Zacke on 2015-11-26.
 */
class ButtonListener implements ActionListener {

    private final JTextField textField;
    private Color textColor;

    public ButtonListener(JTextField textField, Color c) {
        this.textField = textField;
        textColor = c;
    }

    public void actionPerformed(ActionEvent e) {
        textField.setForeground(textColor);
    }
}
