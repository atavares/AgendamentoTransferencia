package br.com.empresateste.agendamentotransferencia;

import java.math.BigDecimal;

import org.joda.time.DateTime;
import org.junit.Assert;
import org.junit.Test;

import br.com.empresateste.agendamentotransferencia.business.TransferenciaBusiness;
import br.com.empresateste.agendamentotransferencia.exception.GenericException;
import br.com.empresateste.agendamentotransferencia.model.TipoConta;
import br.com.empresateste.agendamentotransferencia.model.Transferencia;

public class TransferenciaTest {

	
	@Test(expected=GenericException.class)
	public void verificaMascaraContaTransferenciaTest() throws GenericException{
		String conta = "12345-90";
		TransferenciaBusiness.getInstance().verificaContaTransferenciaValida(conta);
	}
	
	@Test
	public void calculaTaxaTransferenciaFinanceiraTipoATest() throws GenericException{
		try{
			Transferencia transferencia = new Transferencia("12345-9","67890-1",new BigDecimal("2000.0"), new DateTime(2017, 05, 29 , 0, 0), new DateTime(), TipoConta.A);
			TransferenciaBusiness.getInstance().calculaTaxaTransferencia(transferencia);
			Assert.assertEquals(new Double("62"), transferencia.getTaxa());			
		}catch(GenericException ge){
			Assert.fail(ge.getMessage());
		}
	}
	
	@Test
	public void calculaTaxaTransferenciaFinanceiraTipoBTest(){
		try{
			Transferencia transferencia1 = new Transferencia("22222-9","33333-1",new BigDecimal("1000.0"), new DateTime(2017, 07, 27 , 0, 0), new DateTime(), TipoConta.B);
			TransferenciaBusiness.getInstance().calculaTaxaTransferencia(transferencia1);
			Assert.assertEquals(new Double("10"), transferencia1.getTaxa());
			
			Transferencia transferencia2 = new Transferencia("44444-9","55555-1",new BigDecimal("1000.0"), new DateTime(2017, 8, 1 , 0, 0), new DateTime(), TipoConta.B);
			TransferenciaBusiness.getInstance().calculaTaxaTransferencia(transferencia2);
			Assert.assertEquals(new Double("8"), transferencia2.getTaxa());
			
		}catch(GenericException ge){
			Assert.fail(ge.getMessage());
		}
	}
	
	
	@Test
	public void calculaTaxaTransferenciaFinanceiraTipoCTest(){
		try{
			Transferencia transferencia1 = new Transferencia("12785-9","67890-1",new BigDecimal("159.10"), new DateTime(2017, 8, 30 , 0, 0), new DateTime(), TipoConta.C);
			TransferenciaBusiness.getInstance().calculaTaxaTransferencia(transferencia1);
			Assert.assertEquals(new Double("1.9"), transferencia1.getTaxa());
			
			
			Transferencia transferencia2 = new Transferencia("13265-9","67890-1",new BigDecimal("3500.0"), new DateTime(2017, 7, 3 , 0, 0), new DateTime(), TipoConta.C);
			TransferenciaBusiness.getInstance().calculaTaxaTransferencia(transferencia2);
			Assert.assertEquals(new Double("290.5"), transferencia2.getTaxa());
			
			Transferencia transferencia3 = new Transferencia("23265-9","67890-1",new BigDecimal("350.0"), new DateTime(2017, 7, 8 , 0, 0), new DateTime(), TipoConta.C);
			TransferenciaBusiness.getInstance().calculaTaxaTransferencia(transferencia3);
			Assert.assertEquals(new Double("25.9"), transferencia3.getTaxa());
			
			Transferencia transferencia4 = new Transferencia("23665-3","17890-1",new BigDecimal("50.0"), new DateTime(2017, 7, 12 , 0, 0), new DateTime(), TipoConta.C);
			TransferenciaBusiness.getInstance().calculaTaxaTransferencia(transferencia4);
			Assert.assertEquals(new Double("3.4"), transferencia4.getTaxa());
			
			Transferencia transferencia5 = new Transferencia("28885-3","11190-1",new BigDecimal("5.0"), new DateTime(2017, 7, 18 , 0, 0), new DateTime(), TipoConta.C);
			TransferenciaBusiness.getInstance().calculaTaxaTransferencia(transferencia5);
			Assert.assertEquals(new Double("0.3"), transferencia5.getTaxa());
			
			Transferencia transferencia6 = new Transferencia("28285-3","17190-X",new BigDecimal("290.0"), new DateTime(2017, 7, 23 , 0, 0), new DateTime(), TipoConta.C);
			TransferenciaBusiness.getInstance().calculaTaxaTransferencia(transferencia6);
			Assert.assertEquals(new Double("12.5"), transferencia6.getTaxa());
			
			Transferencia transferencia7 = new Transferencia("38285-3","47190-X",new BigDecimal("1290.0"), new DateTime(2017, 7, 29 , 0, 0), new DateTime(), TipoConta.C);
			TransferenciaBusiness.getInstance().calculaTaxaTransferencia(transferencia7);
			Assert.assertEquals(new Double("27.1"), transferencia7.getTaxa());
			
			
		}catch(GenericException ge){
			Assert.fail(ge.getMessage());
		}
	}
	

	
	

}
