//rice (eric) and prabhav


import java.util.*;






public class CalculatorRunner {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Choose a calculator to run:\n1: Calculator\n2: Pinky Calculator\n3: Bluey Calculator");
        String s = in.nextLine();


        try {
            int choice = Integer.parseInt(s);
            switch (choice) {
                case 1:
                    new Calculator();
                    break;
                case 2:
                    new PinkyCalculator();
                    break;
                case 3:
                    new BlueyCalculator();
                    break;
                default:
                    System.out.println("Invalid choice. Please enter 1, 2, or 3.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter a number.");
        }
    }
}
