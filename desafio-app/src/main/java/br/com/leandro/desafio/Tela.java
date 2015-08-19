package br.com.leandro.desafio;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class Tela extends JFrame {
    JButton botaoProcessar = new JButton("Processar");
    JTextField inputText = new JTextField();

    public Tela(String titulo) {
        super(titulo);
        setSize(300,100);
        setLocationRelativeTo(null);
        setLayout(new FlowLayout());
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        inputText.setPreferredSize(new Dimension(280,20));
        add(inputText);

        botaoProcessar.addActionListener(new ProcessaTela(botaoProcessar, inputText));
        add(botaoProcessar);
        add(botaoProcessar);
    }
    
    public static void main(String[] args) {
		new Tela("Desafio-app").show(true);
	}
}