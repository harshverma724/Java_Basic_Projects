import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SimpleCalculator {

    // Create frame and other components
    private JFrame frame;
    private JTextField textField;
    private double num1, num2, result;
    private String operator;

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                SimpleCalculator window = new SimpleCalculator();
                window.frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public SimpleCalculator() {
        // Initialize frame and components
        frame = new JFrame();
        frame.setBounds(100, 100, 400, 550);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        // TextField for display
        textField = new JTextField();
        textField.setFont(new Font("Arial", Font.PLAIN, 24));
        textField.setBounds(10, 11, 364, 50);
        frame.getContentPane().add(textField);
        textField.setColumns(10);

        // Buttons for digits and operations
        String[] buttonLabels = {
                "7", "8", "9", "/",
                "4", "5", "6", "*",
                "1", "2", "3", "-",
                "C", "0", "=", "+"
        };

        int xPos = 10, yPos = 72;

        for (String label : buttonLabels) {
            JButton button = new JButton(label);
            button.setFont(new Font("Arial", Font.PLAIN, 24));
            button.setBounds(xPos, yPos, 85, 50);
            button.addActionListener(new ButtonClickListener());
            frame.getContentPane().add(button);

            xPos += 95;
            if (xPos > 295) {
                xPos = 10;
                yPos += 60;
            }
        }
    }

    private class ButtonClickListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String command = e.getActionCommand();

            // Clear text field
            if (command.equals("C")) {
                textField.setText("");
                num1 = num2 = result = 0;
                operator = null;
            }

            // Handle number inputs
            else if (command.matches("[0-9]")) {
                textField.setText(textField.getText() + command);
            }

            // Handle operator inputs
            else if (command.equals("=")) {
                num2 = Double.parseDouble(textField.getText());
                switch (operator) {
                    case "+":
                        result = num1 + num2;
                        break;
                    case "-":
                        result = num1 - num2;
                        break;
                    case "*":
                        result = num1 * num2;
                        break;
                    case "/":
                        if (num2 != 0) {
                            result = num1 / num2;
                        } else {
                            textField.setText("Error");
                            return;
                        }
                        break;
                }
                textField.setText(String.valueOf(result));
                operator = null;
            } else {
                if (operator == null) {
                    num1 = Double.parseDouble(textField.getText());
                }
                operator = command;
                textField.setText("");
            }
        }
    }
}



