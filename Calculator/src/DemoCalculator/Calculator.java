package DemoCalculator;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.*;

public class Calculator implements ActionListener {
    JFrame frame;
    JTextField textfield;
    JButton[] numberButtons=new JButton[10];
    JButton[] functionButtons=new JButton[10];
    JButton addButton,subButton,mulButton,divButton;
    JButton decButton, equButton, delButton, clrButton, negButton;
    JPanel panel;
    Font myFont = new Font("courier new",Font.BOLD,30);
    double num1=0,num2=0,result=0;
    char operator;

    Calculator() {
        frame = new JFrame("My Calculator");
        frame.setResizable(false);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420, 560);
        frame.setLayout(null);

        textfield = new JTextField();
        textfield.setBounds(50, 25, 300, 60);
        textfield.setBorder(new LineBorder(Color.black,2));
        textfield.setFont(myFont);
        textfield.setEditable(false);
        textfield.setHorizontalAlignment(JTextField.RIGHT);


        addButton = new JButton("+");
        subButton = new JButton("-");
        mulButton = new JButton("×");
        divButton = new JButton("÷");
        decButton = new JButton(".");
        equButton = new JButton("=");
        delButton = new JButton("Del");
        clrButton = new JButton("Clr");
        negButton = new JButton("(-)");

        functionButtons[0] = addButton;
        functionButtons[1] = subButton;
        functionButtons[2] = mulButton;
        functionButtons[3] = divButton;
        functionButtons[4] = decButton;
        functionButtons[5] = equButton;
        functionButtons[6] = delButton;
        functionButtons[7] = clrButton;
        functionButtons[8] = negButton;

        for(int i=0; i<9; i++) {
            functionButtons[i].addActionListener(this);
            functionButtons[i].setFont(myFont);
            functionButtons[i].setFocusable(false);
            functionButtons[i].setBorder(BorderFactory.createLineBorder(Color.black));
        }

        for(int i=0; i<10; i++) {
            numberButtons[i] = new JButton(String.valueOf(i));
            numberButtons[i].addActionListener(this);
            numberButtons[i].setFont(myFont);
            numberButtons[i].setFocusable(false);
            numberButtons[i].setBorder(BorderFactory.createLineBorder(Color.black));
        }

        clrButton.setBounds(50,410,95,60);
        negButton.setBounds(153,410,95,60);
        equButton.setBounds(255,410,95,60);

        panel = new JPanel();
        panel.setBounds(50, 100, 300, 300);
        panel.setLayout(new GridLayout(4,4,10,10));

        panel.add(numberButtons[7]);
        panel.add(numberButtons[8]);
        panel.add(numberButtons[9]);
        panel.add(addButton);
        panel.add(numberButtons[4]);
        panel.add(numberButtons[5]);
        panel.add(numberButtons[6]);
        panel.add(subButton);
        panel.add(numberButtons[1]);
        panel.add(numberButtons[2]);
        panel.add(numberButtons[3]);
        panel.add(mulButton);
        panel.add(decButton);
        panel.add(numberButtons[0]);
        panel.add(delButton);
        panel.add(divButton);

        frame.add(panel);

        frame.add(clrButton);
        frame.add(negButton);
        frame.add(equButton);

        frame.add(textfield);
        frame.setVisible(true);
    }

    @Override // we override actionPerformed method because we want to update it acc to ourselves
    public void actionPerformed(ActionEvent e) {

        for(int i=0;i<10;i++) {
            if(e.getSource() == numberButtons[i]) {
                textfield.setText(textfield.getText().concat(String.valueOf(i)));
            }
        }
        if(e.getSource()==decButton) {
            //if our textfield does not contain dot then only we need to add/concat dot
            if(!textfield.getText().contains(".")) {
                textfield.setText(textfield.getText().concat("."));
            }
        }
        if(e.getSource()==addButton) {
            num1 = Double.parseDouble(textfield.getText()); //parse-double is typecasting out string in double
            operator ='+';
            textfield.setText("");
        }
        if(e.getSource()==subButton) {
            num1 = Double.parseDouble(textfield.getText());
            operator ='-';
            textfield.setText("");
        }
        if(e.getSource()==mulButton) {
            num1 = Double.parseDouble(textfield.getText());
            operator ='*';
            textfield.setText("");
        }
        if(e.getSource()==divButton) {
            num1 = Double.parseDouble(textfield.getText());
            operator ='/';
            textfield.setText("");
        }
        if(e.getSource()==equButton) {
            num2=Double.parseDouble(textfield.getText());

            switch(operator) {
                case'+':
                    result=num1+num2;
                    break;
                case'-':
                    result=num1-num2;
                    break;
                case'*':
                    result=num1*num2;
                    break;
                case'/':
                    result=num1/num2;
                    break;
            }
            textfield.setText(String.valueOf(result));
            num1=result;
        }
        if(e.getSource()==clrButton) {
            textfield.setText("");
        }
        if(e.getSource()==delButton) {

            String str = textfield.getText();
            textfield.setText(str.substring(0, str.length() -1));

            /*  this is another way to impliment delete button

                String string = textfield.getText();
                textfield.setText("");
                for(int i=0;i<string.length()-1;i++) {
                    textfield.setText(textfield.getText()+string.charAt(i));
                }
            */
        }
        if(e.getSource()==negButton) {
            double temp = Double.parseDouble(textfield.getText());
            temp = temp * -1;
            textfield.setText(String.valueOf(temp));
        }
    }
}
