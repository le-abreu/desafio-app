package br.com.leandro.desafio.business;

import java.util.HashMap;
import java.util.Map;

/**
 * Apenas armazena a tabela do parse
 * @author Leandro
 *
 */
public class MapaShortToMessage {

	private final Map<String, String>  mapaDecimalToCaracter;
	
	private final String separador = "_";
	
	public MapaShortToMessage() {
		
		mapaDecimalToCaracter = new HashMap<String, String>();
//		ABC    ->  2 
		mapaDecimalToCaracter.put("2", "ABC");
//		DEF    ->  3 
		mapaDecimalToCaracter.put("3", "DEF");
//		GHI    ->  4 
		mapaDecimalToCaracter.put("4", "GHI");
//		JKL    ->  5 
		mapaDecimalToCaracter.put("5", "JKL");
//		MNO    ->  6 
		mapaDecimalToCaracter.put("6", "MNO");
//		PQRS    ->  7 
		mapaDecimalToCaracter.put("7", "PQRS");
//		TUV    ->  8            
		mapaDecimalToCaracter.put("8", "TUV");
//		WXYZ   ->  9            
		mapaDecimalToCaracter.put("9", "WXYZ");
//		Espaço -> 0             
		mapaDecimalToCaracter.put("0", " ");
	}
	
	public Map<String, String> getMapaDecimalToCaracter() {
		return mapaDecimalToCaracter;
	}

	public String getSeparador() {
		return separador;
	}

}