import java.util.Scanner;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Calculator implements ActionListener {
     JFrame frame;
     JPanel panel;
     JTextField numberField;
     JButton add, subtract, multiply, divide, decimal, equals, clearbtn, deletebtn;
     JButton[] numbers = new JButton[10];
     JButton[] operators = new JButton[6];
     double firstNum = 0, secondNum = 0, total = 0;
     char operator;
     Font calcFont = new Font("Franklin Gothic", Font.BOLD, 38);

     // Create GUI display for calculator and its operations
    Calculator(){
        frame = new JFrame("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(480, 535);
        frame.setLayout(null);
        Container c = frame.getContentPane();
        c.setBackground(Color.pink.brighter());

        numberField = new JTextField();
        numberField.setBounds(70, 25, 320, 75);
        numberField.setEditable(false);
        numberField.setFont(calcFont);

        add = new JButton("+");
        subtract = new JButton("-");
        multiply = new JButton("X");
        divide = new JButton("÷");
        decimal = new JButton(".");
        equals = new JButton("=");
        deletebtn = new JButton("Delete");
        clearbtn = new JButton("Clear");
        operators[0] = add;
        operators[1] = subtract;
        operators[2] = multiply;
        operators[3] = divide;
        operators[4] = decimal;
        operators[5] = equals;

        panel = new JPanel();
        panel.setBounds(70, 120, 320, 300);
        panel.setLayout(new GridLayout(4,4,10,10));

        // Set up notation and functionality for buttons
        numbers[0] = new JButton(String.valueOf(0));
        for(int i = 1; i < 4; i++){
            numbers[i] = new JButton(String.valueOf(i));
            numbers[i].addActionListener(this);
            panel.add(numbers[i]);
            operators[0].addActionListener(this);
            panel.add(operators[0]);
        }
        for(int i = 4; i < 7; i++){
            numbers[i] = new JButton(String.valueOf(i));
            numbers[i].addActionListener(this);
            panel.add(numbers[i]);
            operators[1].addActionListener(this);
            panel.add(operators[1]);
        }
        for(int i = 7; i < 10; i++){
            numbers[i] = new JButton(String.valueOf(i));
            numbers[i].addActionListener(this);
            panel.add(numbers[i]);
            operators[2].addActionListener(this);
            panel.add(operators[2]);
        }

        numbers[0].addActionListener(this);
        operators[3].addActionListener(this);
        operators[4].addActionListener(this);
        operators[5].addActionListener(this);
        deletebtn.addActionListener(this);
        clearbtn.addActionListener(this);

        panel.add(operators[4]);
        panel.add(numbers[0]);
        panel.add(operators[5]);
        panel.add(operators[3]);

        deletebtn.setBounds(79, 430, 145, 50);
        clearbtn.setBounds(235, 430, 145, 50);

        frame.add(deletebtn);
        frame.add(clearbtn);
        frame.add(panel);
        frame.add(numberField);
        frame.setVisible(true);
    }

    public static void main(String[] args){
        Calculator calculator = new Calculator();
    }

    // Set actions for each button clicked
    @Override
    public void actionPerformed(ActionEvent e) {

        for(int i = 0; i < 10; i++){
            if(e.getSource() == numbers[i]){
                numberField.setText(numberField.getText().concat(String.valueOf(i)));
            }
        }
        if(e.getSource() == decimal){
            numberField.setText(numberField.getText().concat("."));
        }
        if(e.getSource() == add){
            firstNum = Double.parseDouble(numberField.getText());
            operator ='+';
            numberField.setText("");
        }
        if(e.getSource() == subtract){
            firstNum = Double.parseDouble(numberField.getText());
            operator = '-';
            numberField.setText("");
        }
        if(e.getSource() == multiply){
            firstNum = Double.parseDouble(numberField.getText());
            operator = 'X';
            numberField.setText("");
        }
        if(e.getSource() == divide){
            firstNum = Double.parseDouble(numberField.getText());
            operator = '÷';
            numberField.setText("");
        }
        CalculatorOperations calcOp = new CalculatorOperations();
        if(e.getSource() == equals){
            secondNum = Double.parseDouble(numberField.getText());
            switch(operator){
                case '+':
                    total = firstNum+secondNum;
                    break;
                case '-':
                    total = firstNum-secondNum;
                    break;
                case 'X':
                case '*':
                    total = firstNum*secondNum;
                    break;
                case '/':
                case '÷':
                    total = firstNum/secondNum;
                    break;
            }
            numberField.setText(String.valueOf(calcOp.numberFormat(total)));
            firstNum = total;
        }
        if(e.getSource() == clearbtn){
            numberField.setText("");
        }
        if(e.getSource() == deletebtn){
            String str = numberField.getText();
            numberField.setText(str.substring(0, str.length()-1));
        }
    }
}
