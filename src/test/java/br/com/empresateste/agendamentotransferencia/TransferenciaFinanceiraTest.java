package br.com.empresateste.agendamentotransferencia;

import java.math.BigDecimal;

import org.joda.time.DateTime;
import org.junit.Assert;
import org.junit.Test;

import br.com.empresateste.agendamentotransferencia.business.TransferenciaBusiness;
import br.com.empresateste.agendamentotransferencia.exception.GenericException;
import br.com.empresateste.agendamentotransferencia.model.TipoConta;
import br.com.empresateste.agendamentotransferencia.model.Transferencia;

public class TransferenciaFinanceiraTest {

	
	@Test(expected=GenericException.class)
	public void verificaMascaraContaTransferenciaTest() throws GenericException{
		String conta = "12345-90";
		TransferenciaBusiness.getInstance().verificaContaTransferenciaValida(conta);
	}
	
	@Test
	public void calculaTaxaTransferenciaFinanceiraTipoATest(){
		Transferencia transferencia = new Transferencia();
		transferencia.setContaOrigem("12345-9");
		transferencia.setContaDestino("67890-1");
		transferencia.setValorTransferencia(new BigDecimal("1000.0"));
		transferencia.setDataAgendamento(new DateTime(2017, 05, 29 , 0, 0));
		transferencia.setTipoConta(TipoConta.A);
		TransferenciaBusiness.getInstance().calculaTaxaTransferencia(transferencia);
		Assert.assertEquals(new Double("32"), transferencia.getTaxa());
	}


}
