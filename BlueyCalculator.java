import java.awt.event.ActionEvent;


import java.awt.*;
import javax.swing.*;


public class BlueyCalculator extends Calculator {
    // Additional button for the sine operation
    private JButton sinButton;


    public BlueyCalculator() {
        super();


        setTitle("Bluey Calculator ??????");
        super.panel.setBackground(Color.BLUE);
        textField.setFont(new Font("Times New Roman", Font.ITALIC, 15));
        textField.setForeground(Color.BLACK); // Set text color to black


        Color lightBlue = new Color(173, 216, 230); // Define light blue color
        Color darkBlue = new Color(0, 0, 139); // Define dark blue color


        for (int i = 0; i < 10; i++) {
            super.numberButtons[i].setBackground(lightBlue); // Set button background to light blue
            super.numberButtons[i].setFont(new Font("Times New Roman", Font.PLAIN, 15));
            super.numberButtons[i].setForeground(darkBlue); // Set button text color to dark blue
        }


        for (int i = 0; i < functionButtons.length; i++) {
            super.functionButtons[i].setBackground(lightBlue); // Set button background to light blue
            super.functionButtons[i].setFont(new Font("Times New Roman", Font.PLAIN, 15));
            super.functionButtons[i].setForeground(darkBlue); // Set button text color to dark blue
        }


        // Create the sine button and add it to the panel
        sinButton = new JButton("s");
        sinButton.addActionListener(this);
        sinButton.setBackground(lightBlue);
        sinButton.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        sinButton.setForeground(darkBlue);
        panel.add(sinButton);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        super.actionPerformed(e);


        JButton source = (JButton) e.getSource();
        String buttonText = source.getText();


        if (buttonText.equals("s")) { // Sine button
            num1 = Double.parseDouble(textField.getText());
            result = Math.sin(num1);
            textField.setText(String.valueOf(result));
            num1 = result;
        }
    }
}
