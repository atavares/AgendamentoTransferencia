package br.com.empresateste.agendamentotransferencia;

import java.math.BigDecimal;

import org.joda.time.DateTime;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import br.com.empresateste.agendamentotransferencia.exception.GenericException;
import br.com.empresateste.agendamentotransferencia.model.TipoConta;
import br.com.empresateste.agendamentotransferencia.model.Transferencia;
import br.com.empresateste.agendamentotransferencia.service.TransferenciaService;

public class TransferenciaServiceBusinessTest {
	
	private static TransferenciaService service;
	

	@BeforeClass
	public static void init(){
		service=new TransferenciaService();
	}
	
	@Test
	public void adicionaTransferenciaTest(){
		try{

			Transferencia t1 =new Transferencia("12345-9","67890-1",new BigDecimal("2000.0"), new DateTime(2017, 05, 29 , 0, 0), new DateTime(), TipoConta.A);
			service.adicionaTransferencia(t1);

			Transferencia t2 =new Transferencia("22222-9","33333-1",new BigDecimal("1000.0"), new DateTime(2017, 07, 27 , 0, 0), new DateTime(), TipoConta.B);
			service.adicionaTransferencia(t2);
			
			
			Transferencia t3 =new Transferencia("23265-9","67890-1",new BigDecimal("350.0"), new DateTime(2017, 7, 8 , 0, 0), new DateTime(), TipoConta.C);
			service.adicionaTransferencia(t3);
			
			Transferencia t4 =new Transferencia("12985-9","67540-1",new BigDecimal("144000.0"), new DateTime(2017, 10, 1 , 0, 0), new DateTime(), TipoConta.D);
			service.adicionaTransferencia(t4);
			
			
			
			Assert.assertEquals(4, service.listaTransferenciasCadastradas().size());
		
			
		}catch(GenericException ge){
			Assert.fail(ge.getMessage());
		}
		
	}

}
