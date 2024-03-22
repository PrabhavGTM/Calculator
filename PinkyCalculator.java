

import java.awt.event.ActionEvent;
import java.awt.*;
import javax.swing.*;


public class PinkyCalculator extends Calculator {
    public PinkyCalculator() {
        super();


        setTitle("(Coquette) Calculator");
        super.panel.setBackground(Color.PINK);
        textField.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        textField.setForeground(Color.BLACK); // Set text color to black


        Color lightPink = new Color(255, 182, 193); // Define light pink color
        Color darkPink = new Color(255, 105, 180); // Define dark pink color


        for (int i = 0; i < 10; i++) {
            super.numberButtons[i].setBackground(lightPink); // Set button background to light pink
            super.numberButtons[i].setFont(new Font("Times New Roman", Font.PLAIN, 15));
            super.numberButtons[i].setForeground(darkPink); // Set button text color to dark pink
        }


        for (int i = 0; i < functionButtons.length; i++) {
            super.functionButtons[i].setBackground(lightPink); // Set button background to light pink
            super.functionButtons[i].setFont(new Font("Times New Roman", Font.PLAIN, 15));
            super.functionButtons[i].setForeground(darkPink); // Set button text color to dark pink
        }
    }
}


