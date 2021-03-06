package br.edu.facisa.caixa.gui;

import java.awt.Font;
import java.awt.SystemColor;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Color;

public class Senha extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel panel;
	public JTextField textField;
	private JLabel lbl;
	
	public JPanel getPanel() {
		return panel;
	}

	public void setPanel(JPanel panel) {
		this.panel = panel;
	}

	public JTextField getTextField() {
		return textField;
	}

	public void setTextField(JTextField textField) {
		this.textField = textField;
	}

	public JLabel getLbl() {
		return lbl;
	}

	public void setLbl(JLabel lbl) {
		this.lbl = lbl;
	}
	
	/**
	 * Create the application.
	 */
	public Senha() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		panel = new JPanel();
		panel.setBackground(SystemColor.window);
		panel.setSize(535,  320);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Digite sua senha:");
		lblNewLabel.setBounds(181, 136, 178, 27);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(193, 173, 147, 33);
		textField.setEditable(false);
		panel.add(textField);
		textField.setColumns(10);
		
		lbl = new JLabel("Deposito realizado com sucesso!");
		lbl.setBounds(145, 120, 246, 14);
		lbl.setFont(new Font("Tahoma", Font.BOLD, 14));
		lbl.setForeground(new Color(0, 128, 0));
		lbl.setHorizontalAlignment(SwingConstants.CENTER);
		lbl.setVisible(false);
		panel.add(lbl);
		
	}
}
