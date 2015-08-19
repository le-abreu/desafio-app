package br.com.leandro.desafio;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import br.com.leandro.desafio.business.ProcessadorCaracteres;
import br.com.leandro.desafio.business.ProcessadorDecimals;
import br.com.leandro.desafio.business.ProcessadorParse;

public class ProcessaTela implements ActionListener {
    ProcessadorParse processadorCaracteres = new ProcessadorCaracteres();
    ProcessadorParse processadorDecimals = new ProcessadorDecimals();
    
	JButton botaoProcessar = new JButton();
    JTextField inputText = new JTextField();
    String msgTexto;

    ProcessaTela(JButton botao, JTextField text1){
        this.botaoProcessar=botao;
        inputText = text1;
    }

    public void actionPerformed(ActionEvent evento) {
        msgTexto = inputText.getText();
        
        try{
        	
        	if(isInteger(msgTexto.replaceFirst("_", ""))){
        		msgTexto = processadorCaracteres.processa(msgTexto);
        	}else{
        		msgTexto = processadorDecimals.processa(msgTexto);
        	}
        }catch(Exception e){
        	msgTexto = e.getMessage();
        }
        
        JOptionPane.showMessageDialog(null, msgTexto);
    }
    
    public static boolean isInteger(String block2)
	{
		try
		{
			Integer i = Integer.valueOf(block2);
			return true;
		}
		catch (Exception e)
		{
			return false;
		}
	}
}