package br.com.leandro.desafio;

import junit.framework.TestCase;
import br.com.leandro.desafio.business.ProcessadorCaracteres;
import br.com.leandro.desafio.business.ProcessadorParse;


public class TesteProcessadorCaracteres extends TestCase {

	public void testeRetornoSucesso(){
		ProcessadorParse processador = new ProcessadorCaracteres();
		assertTrue( "ED".equals(processador.processa("33_3") ) );
	}
	
	public void testeRetornoException(){
		ProcessadorParse processador = new ProcessadorCaracteres();
		try {
			processador.processa("2222");
			assertTrue(false);
		} catch (Exception e) {
			assertTrue( true);
		}
	}
	
}
