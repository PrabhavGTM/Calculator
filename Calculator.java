// Calculator.java


// Import statements allow us to use classes and other types from other packages
import javax.swing.*; // This is for the Swing components (JFrame, JTextField, JButton, JPanel)
import java.awt.*; // This is for the AWT components (Color, Font, BorderLayout, GridLayout)
import java.awt.event.ActionEvent; // This is for handling events (ActionEvent)
import java.awt.event.ActionListener; // This is for handling events (ActionListener)


// The Calculator class extends JFrame and implements ActionListener
public class Calculator extends JFrame implements ActionListener {
    // Class variables for the calculator's interface and state
    protected JTextField textField; // Displays input and results
    protected JButton[] numberButtons; // Buttons for digits 0-9
    protected JButton[] functionButtons; // Buttons for operations
    protected JPanel panel; // Panel to hold the buttons


    protected double num1 = 0, num2 = 0, result = 0; // Variables for calculations
    protected char operator; // Stores the current operation


    // Constructor sets up the calculator's interface
    public Calculator() {
        // Set up the window
        setTitle("Default Calculator");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);


        // Set up the text field
        textField = new JTextField();
        textField.setFont(new Font("Times New Roman", Font.PLAIN, 24));
        textField.setHorizontalAlignment(JTextField.RIGHT);
        textField.setEditable(false);


        // Set up the panel for the buttons
        panel = new JPanel();
        panel.setLayout(new GridLayout(4, 5, 20, 20)); // Added gaps between buttons


        // Create number buttons and add them to the panel
        numberButtons = new JButton[10];
        for (int i = 0; i < 10; i++) {
            numberButtons[i] = new JButton(String.valueOf(i));
            numberButtons[i].addActionListener(this);
            numberButtons[i].setBackground(Color.LIGHT_GRAY);
            panel.add(numberButtons[i]);
        }


        // Create function buttons and add them to the panel
        functionButtons = new JButton[8];
        String[] functions = { "+", "-", "*", "/", "=", "C", "!", "v" }; // Changed "sqrt" to "v"
        for (int i = 0; i < functionButtons.length; i++) {
            functionButtons[i] = new JButton(functions[i]);
            functionButtons[i].addActionListener(this);
            functionButtons[i].setBackground(Color.CYAN);
            panel.add(functionButtons[i]);
        }


        // Add the text field and panel to the window
        add(textField, BorderLayout.NORTH);
        add(panel);


        // Finalize the window setup
        pack();
        setLocationRelativeTo(null); // Center the window
        setVisible(true);
    }


    // Handles button presses
    public void actionPerformed(ActionEvent e) {
        // Get the button that was pressed
        JButton source = (JButton) e.getSource();
        String buttonText = source.getText();


        // Handle each type of button
        if (buttonText.equals("C")) { // Clear button
            textField.setText("");
            num1 = num2 = result = 0;
            operator = ' ';
        } else if (buttonText.matches("[0-9]")) { // Number button
            textField.setText(textField.getText() + buttonText);
        } else if (buttonText.equals("+") || buttonText.equals("-") || buttonText.equals("*")
                || buttonText.equals("/")) { // Operation button
            num1 = Double.parseDouble(textField.getText());
            operator = buttonText.charAt(0);
            textField.setText("");
        } else if (buttonText.equals("=")) { // Equals button
            num2 = Double.parseDouble(textField.getText());
            result = calculate(num1, num2, operator);
            textField.setText(String.valueOf(result));
            num1 = result;
        } else if (buttonText.equals("!")) { // Factorial button
            int number = Integer.parseInt(textField.getText());
            textField.setText(String.valueOf(factorial(number)));
        } else if (buttonText.equals("v")) { // Square root button
            double number = Double.parseDouble(textField.getText());
            textField.setText(String.valueOf(squareRoot(number)));
        }
    }


    // Performs a calculation
    protected double calculate(double num1, double num2, char operator) {
        switch (operator) {
            case '+':
                return num1 + num2;
            case '-':
                return num1 - num2;
            case '*':
                return num1 * num2;
            case '/':
                return num1 / num2;
            default:
                return 0;
        }
    }


    // Calculates a factorial
    protected long factorial(int number) {
        long result = 1;
        for (int factor = 2; factor <= number; factor++) {
            result *= factor;
        }
        return result;
    }


    // Calculates a square root
    protected double squareRoot(double number) {
        return Math.sqrt(number);
    }
}



