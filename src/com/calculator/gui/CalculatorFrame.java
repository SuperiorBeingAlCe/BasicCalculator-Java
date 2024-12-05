package com.calculator.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.calculator.logic.Calculator;

public class CalculatorFrame extends JFrame implements ActionListener{
	 private JTextField displayField;
	 private StringBuilder input = new StringBuilder();
	 private Calculator calculator= new Calculator();
	 
	 public CalculatorFrame() {
		 setTitle("Hesap Makinesi");
	        setSize(400, 500);
	        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        setLocationRelativeTo(null);
	        setLayout(new BorderLayout());
	        getContentPane().setBackground(Color.GRAY);
	        
	        displayField = new JTextField();
	        displayField.setFont(new Font("Arial", Font.BOLD, 24));
	        displayField.setHorizontalAlignment(JTextField.RIGHT);
	        displayField.setEditable(false);
	        add(displayField, BorderLayout.NORTH);
	        
	        JPanel buttonPanel = new JPanel();
	        buttonPanel.setLayout(new GridLayout(4, 4, 5, 5));
	        buttonPanel.setBackground(Color	.GRAY);
	        
	        String[] buttons = {
	                "7", "8", "9", "/",
	                "4", "5", "6", "*",
	                "1", "2", "3", "-",
	                "0", "C", "=", "+"
	        };

	        for (String text : buttons) {
	            JButton button = new JButton(text);
	            button.setFont(new Font("Arial", Font.BOLD, 20));
	            button.addActionListener(this);
	        
	            if (text.matches("\\d")) {
	                button.setBackground(new Color(70, 130, 180));
	                button.setForeground(Color.WHITE);
	            } else {
	                button.setBackground(new Color(100, 149, 237)); 
	                button.setForeground(Color.BLACK);
	            }

	            buttonPanel.add(button);
	        
	            
		 
	}
	        add(buttonPanel, BorderLayout.CENTER);
	        setVisible(true);
	        
	       

}
	 @Override
     public void actionPerformed(ActionEvent e) {
         String command = e.getActionCommand();
         if (command.matches("\\d")) { 
             input.append(command);
             displayField.setText(input.toString());
         } else if (command.equals("C")) { 
             input.setLength(0);
             displayField.setText("");
         } else if (command.equals("=")) { 
             try {
                 double result = calculator.evaluate(input.toString());
                 displayField.setText(String.valueOf(result));
                 input.setLength(0);
                 input.append(result); 
             } catch (Exception ex) {
                 displayField.setText("Hata!");
                 input.setLength(0);
             }
         } else { 
             input.append(" ").append(command).append(" ");
             displayField.setText(input.toString());
         }
} }

	
