package br.com.leandro.desafio.business;

import java.util.ArrayList;
import java.util.List;

/**
 * Processador Caracteres 
 * @author Leandro
 *
 */
public class ProcessadorCaracteres implements ProcessadorParse {

	private MapaShortToMessage mapaShortToMessage = new MapaShortToMessage();
	
	/**
	 * Processa o valor Decimal para Caracteres
	 */
	public String processa(String decimals) {
		// variavel de retorno
		String caracteres = "";
		// array agrupado por casa decimal
		String[] decimaisOrdenados = extrairArrayDecimalOrdenados(decimals);
		
		for (String string : decimaisOrdenados) {
			// verificando separador
			if(string.equals(mapaShortToMessage.getSeparador()))
				continue;
			
			// valor da posição
			String value = mapaShortToMessage.getMapaDecimalToCaracter().get(string.substring(0, 1));
			// armazeno de acordo com o indice da letra enviado por numero
			caracteres += value.substring(string.length()-1, string.length() );
		}
		
		return caracteres;
	}
	
	
	/**
	 * Extrai um array ordenado de posição 
	 * @param decimals
	 * @return
	 */
	private String[] extrairArrayDecimalOrdenados(String decimals) {
		
		List<String> decimaisOrdenados = new ArrayList<String>();
		int tamanho = decimals.length();
		// variavel controla ultima casa usada para setar no array
		String ultimaCasaDecimalUsadaParaComparar = "";
		// variavel para armazenar o valor da letra de acorod com a repetição 
		String armazenarAdicionar = "";
		
		for (int indice = 0 ; indice < tamanho; indice++) {
			// variavel para controlar a casa Decimal comparada 
			String atualCasaDecimalComparar = decimals.substring(indice, indice+1);
			
			// armazeno caso seja 
			if(ultimaCasaDecimalUsadaParaComparar.equals(atualCasaDecimalComparar) && !atualCasaDecimalComparar.equals("_")){
				armazenarAdicionar += atualCasaDecimalComparar;
				validaLimiteValorKey(armazenarAdicionar);
			}else{
				// verifico se não eh o inicio
				if(!ultimaCasaDecimalUsadaParaComparar.equals("")){
					decimaisOrdenados.add(armazenarAdicionar);
				}
				//altero os valores
				armazenarAdicionar = ultimaCasaDecimalUsadaParaComparar = atualCasaDecimalComparar;
			}
		}
		decimaisOrdenados.add(armazenarAdicionar);
		
		return decimaisOrdenados.toArray(new String[0]);
	}



	/**
	 * valida o limite por casa decimal	
	 * @param valor
	 */
	private void validaLimiteValorKey(String valor) {
		
		String value = mapaShortToMessage.getMapaDecimalToCaracter().get(valor.substring(0, 1));

		if(value == null)
			throw new IllegalArgumentException("Valor "+ valor +" não está dentro dos valores processados");
		if(value.length() < valor.length())
			throw new IllegalArgumentException("Use _ para separar caracteres com a mesma casa decimal, esse valor "+ valor +" passou o limite permitido da casa ");
			
	}

}
