package br.com.leandro.desafio;

import junit.framework.TestCase;
import br.com.leandro.desafio.business.ProcessadorDecimals;
import br.com.leandro.desafio.business.ProcessadorParse;


public class TesteProcessadorDecimals extends TestCase {

	public void testeRetornoSucesso(){
		ProcessadorParse processador = new ProcessadorDecimals();
		assertTrue( "202207777".equals(processador.processa("a B s") ) );
	}
	
	public void testeRetorno(){
		ProcessadorParse processador = new ProcessadorDecimals();
		try {
			processador.processa("a BÇ s");
			assertTrue(false);
		} catch (Exception e) {
			assertTrue( true);
		}
	}
	
}
