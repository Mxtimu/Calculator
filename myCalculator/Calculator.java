package myCalculator;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Calculator implements ActionListener {
    //First the Instances
    int number;
    JFrame frame;
    JTextField textField;
    JButton[] numberButtons = new JButton[10];
    JButton[] functionButtons = new JButton[8];
    JButton addButton, subtractButton, divideButton , multiplicationButton;
    JButton decimalButton, equalsButton, deleteButton , clearButton;
    JPanel panel;
    Font myFont = new Font("Ink Free", Font.BOLD, 30);

    double number1 =0, number2 = 0, result = 0;
    char operator;
    Calculator(){
    frame = new JFrame("Calculator");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(420, 550);
    frame.setLayout(null);

    textField = new JTextField();
    textField.setBounds(50, 25, 300, 50);
    textField.setFont(myFont);
    textField.setEditable(false);
    addButton = new JButton("+");
    subtractButton = new JButton("-");
    divideButton = new JButton("/");
    multiplicationButton = new JButton("*");
    decimalButton = new JButton(".");
    equalsButton = new JButton("=");
    deleteButton = new JButton("Delete");
    clearButton = new JButton("Clear");

    functionButtons[0] = addButton;
    functionButtons[1] = subtractButton;
    functionButtons[2] = multiplicationButton;
    functionButtons[3] = divideButton;
    functionButtons[4] = clearButton;
    functionButtons[5] = deleteButton;
    functionButtons[6] = equalsButton;
    functionButtons[7] = decimalButton;
    for(int i = 0; i<8; i++){
        functionButtons[i].addActionListener(this);
        functionButtons[i].setFont(myFont);
        functionButtons[i].setFocusable(false);

        }
    for(int i = 0; i<10; i++){
           numberButtons[i] = new JButton(String.valueOf(i));
           numberButtons[i].addActionListener(this);
           numberButtons[i].setFont(myFont);
           numberButtons[i].setFocusable(false);


        }
    deleteButton.setBounds(50,430,145,50);
    clearButton.setBounds(205,430,145,50);

    panel = new JPanel();
    panel.setBounds(50, 100, 300,300);
    panel.setLayout(new GridLayout(4,4, 10,10));

    panel.add(numberButtons[1]);
    panel.add(numberButtons[2]);
    panel.add(numberButtons[3]);
    panel.add(addButton);
    panel.add(numberButtons[4]);
    panel.add(numberButtons[5]);
    panel.add(numberButtons[6]);
    panel.add(subtractButton);
    panel.add(numberButtons[7]);
    panel.add(numberButtons[8]);
    panel.add(numberButtons[9]);
    panel.add(multiplicationButton);
    panel.add(decimalButton);
    panel.add(numberButtons[0]);
    panel.add(equalsButton);
    panel.add(divideButton);



    frame.add(panel);
    frame.add(deleteButton);
    frame.add(clearButton);
    frame.add(textField);
    frame.setVisible(true);
    }
    public int add(int a, int b){
        return a + b;
    }
    public int subtract(int a, int b){
        return a - b;
    }
    public int divide(int a, int b){
        return a / b;
    }
    public int multiply(int a, int b){
        return a * b;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
    for(int i = 0; i<10; i++){
    if(e.getSource() == numberButtons[i]){
        textField.setText(textField.getText().concat(String.valueOf(i)));
    }
}
    if(e.getSource() == decimalButton){
        textField.setText(textField.getText().concat("."));
    }
        if(e.getSource() == addButton){
            number1 = Double.parseDouble(textField.getText());
            operator = '+';
            textField.setText("");

        }
        if(e.getSource() == subtractButton){
            number1 = Double.parseDouble(textField.getText());
            operator = '-';
            textField.setText("");

        }
        if(e.getSource() == multiplicationButton){
            number1 = Double.parseDouble(textField.getText());
            operator = '*';
            textField.setText("");

        }
        if(e.getSource() == divideButton){
            number1 = Double.parseDouble(textField.getText());
            operator = '/';
            textField.setText("");

        }
        if (e.getSource() == equalsButton){
            number2 = Double.parseDouble(textField.getText());
            switch (operator){
                case'+':
                    result = number1 + number2;
                    break;
                case'-':
                    result = number1 - number2;
                    break;
                case'*':
                    result = number1 * number2;
                    break;
                case'/':
                    result = number1 / number2;
                    break;

            }
            textField.setText(String.valueOf(result));
            number1 = result;
        }
        if(e.getSource() == clearButton) {
            textField.setText("");
        }
        if(e.getSource() == deleteButton) {
            String string = textField.getText();
            textField.setText("");
            for (int i = 0; i<string.length()-1;i++){
                textField.setText(textField.getText() + string.charAt(i));
            }
        }

    }
}
