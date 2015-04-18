package br.com.leandro.desafio.business;


/**
 * Processador de Decimal's 
 * @author Leandro
 *
 */
public class ProcessadorDecimals implements ProcessadorParse {

	private MapaShortToMessage mapaShortToMessage = new MapaShortToMessage();
	
	/**
	 * Recebe uma mensagem em caracter 
	 * @param caracteres
	 * @return
	 */
	public String processa(String caracteres) {
		
		String decimal_s = "";
		
		int tamanho = caracteres.length();
		
		String ultimaKeyUsadaParaComparar = "";
		
		for (int indice = 0 ; indice < tamanho; indice++) {
			
			String posicaoComparar = caracteres.substring(indice, indice+1);
			
			String decimal = getValorUnitarioDecimal(posicaoComparar);
					
			String casaDecimal = decimal.substring(0, 1);
			if(ultimaKeyUsadaParaComparar.equals(casaDecimal)){
				decimal_s += mapaShortToMessage.getSeparador();
			}
			
			ultimaKeyUsadaParaComparar = casaDecimal;
			decimal_s += decimal;
		}
		
		return decimal_s;
	}

	/**
	 * Metodo para encotrar o valor decimal unitario
	 * @param caracter
	 * @return
	 */
	private String getValorUnitarioDecimal(String caracter) {
		
		String decimal = "";
		
		// percorre a lista de chaves
		for (String key : mapaShortToMessage.getMapaDecimalToCaracter().keySet()) {
			
			// recebe o valor da chave da iteração apenas para comparcação
			String value = mapaShortToMessage.getMapaDecimalToCaracter().get(key);
			if(value.contains(caracter.toUpperCase())){
				
				// verifica o numero da posição do caracter no valor da chave 
				int repeticao = value.indexOf(caracter.toUpperCase());
				
				// seta a quantidade de caracteres 
				while(repeticao > -1){
					decimal += key;
					repeticao--;
				}
			}
		}
		
		if(decimal.isEmpty()){
			throw new IllegalArgumentException("O valor "+caracter +" não está dentro dos valores permitidos");
		}
		
		return decimal;
	}

}
