package com.chatbot2.chatBot2;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class SwingGUI implements ActionListener{

	// Attributes
	private ChatBot bot; 
	private JButton button;
	private JButton btn2; 
	private JLabel output; 
	private JTextField userInput; 
	private JFrame frame; 
	private JPanel panel; 
	private JPanel p2;

	// Set up the constructor
	public SwingGUI() {

		// Set up the attributes
		this.bot = new ChatBot(); 
		frame = new JFrame(); 
		panel = new JPanel(); 
		p2 = new JPanel(); 
		output = new JLabel(); 
		userInput = new JTextField(); 
		button = new JButton("Start Chatting!"); 
		btn2 = new JButton("Send Message!"); 

		// Set up the Frame
		frame.setLayout(new BorderLayout());
		frame.setSize(1000, 600); 
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Chat Bot");
		frame.add(p2); 
		frame.add(panel, BorderLayout.SOUTH); 	
	}




	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	} 
}
