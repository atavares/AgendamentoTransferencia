package br.com.teste.agendamentotarefa;

import org.junit.Assert;
import org.junit.Test;

import br.com.teste.agendamentotarefa.util.Util;

public class TransferenciaFinanceiraTest {

	
	@Test
	public void verificaMascaraContaTransferencia(){
		String conta = "12345-9";
		Assert.assertEquals(true, Util.isContaTransferenciaValida(conta));
	}
	
	

}
