package br.com.teste.agendamentotarefa.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Util {
	
	public static boolean isContaTransferenciaValida(String conta){
		//padrão XXXXX­X
		String mascaraConta = "\\d{5}-[a-zA-Z0-9]{1}";
		Pattern padrao = Pattern.compile(mascaraConta);
		Matcher m = padrao.matcher(conta);
		return m.matches();
	}

}
