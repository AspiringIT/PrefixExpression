import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Stack;

public class Main extends Frame implements ActionListener {

    private TextField expressionTextField;
    private Button evaluateButton;
    private Label resultLabel;

    public Main() {
        // Set layout manager
        setLayout(new BorderLayout());
        //creating objects for the GUI
        expressionTextField = new TextField(20);
        evaluateButton = new Button("Evaluate");
        resultLabel = new Label("Please enter your equation in the top text box (Remember to put the operator first)");
        // GUI components
        add(expressionTextField, BorderLayout.NORTH);
        add(evaluateButton, BorderLayout.CENTER);
        add(resultLabel,BorderLayout.SOUTH);

        // Add action listener to the button
        evaluateButton.addActionListener(this);

        // Set frame properties
        setTitle("Prefix Expression Evaluator");
        setSize(550, 150);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == evaluateButton) {
            String expression = expressionTextField.getText();
            try {
                double result = evaluatePrefix(expression);
                resultLabel.setText("Result: " + result);
            } catch (Exception ex) {
                resultLabel.setText("Error: Invalid expression");
            }
        }
    }

    // Evaluate the prefix expression
    private double evaluatePrefix(String expression) {
        Stack<Double> stack = new Stack<Double>();

        // Process characters from right to left
        for (int i = expression.length() - 1; i >= 0; i--) {
            char currentChar = expression.charAt(i);

            if (isOperand(currentChar)) {
                stack.push((double) Character.getNumericValue(currentChar));
            } else if (isOperator(currentChar)) {
                // Operator encountered
                double operand1 = stack.pop();
                double operand2 = stack.pop();

                switch (currentChar) {
                    case '+':
                        stack.push(operand1 + operand2);
                        break;
                    case '*':
                        stack.push(operand1 * operand2);
                        break;

                    case '-':
                        stack.push(operand1 - operand2);
                        break;
                    case '/':
                        stack.push(operand1/operand2);
                }
            } else if (!Character.isWhitespace(currentChar)) {
                throw new IllegalArgumentException("Invalid character in expression");
            }
        }

        return stack.peek();
    }

    // Check if a character is an operand (positive integer)
    private boolean isOperand(char c) {
        return Character.isDigit(c);
    }

    // Check if a character is an operator
    private boolean isOperator(char c) {
        return c == '+' || c == '*' || c == '-' || c == '/'; // Add more operators as needed
    }

    public static void main(String[] args) {
        new Main();
    }
}
