package br.com.teste.agendamentotarefa;

import java.math.BigDecimal;
import java.util.List;

import org.joda.time.DateTime;
import org.junit.Assert;
import org.junit.Test;

import br.com.teste.agendamentotarefa.business.ContaTransferenciaBusiness;
import br.com.teste.agendamentotarefa.exception.GenericException;
import br.com.teste.agendamentotarefa.model.ContaTransferencia;
import br.com.teste.agendamentotarefa.model.TipoConta;

public class TransferenciaFinanceiraTest {

	
	@Test(expected=GenericException.class)
	public void verificaMascaraContaTransferenciaTest() throws GenericException{
		String conta = "12345-90";
		ContaTransferenciaBusiness.getInstance().verificaContaTransferenciaValida(conta);
	}
	
	@Test
	public void calculaTaxaTransferenciaFinanceiraTipoATest(){
		ContaTransferencia conta = new ContaTransferencia();
		conta.setContaOrigem("12345-9");
		conta.setContaDestino("67890-1");
		conta.setValorTransferencia(new BigDecimal("1000.0"));
		conta.setDataAgendamento(new DateTime(2017, 05, 29 , 0, 0));
		conta.setTipoConta(TipoConta.A);
		ContaTransferenciaBusiness.getInstance().calculaTaxaTransferencia(conta);
		Assert.assertEquals(new Double("32"), conta.getTaxa());
	}


}
