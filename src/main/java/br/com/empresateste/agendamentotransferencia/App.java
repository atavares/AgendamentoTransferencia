package br.com.empresateste.agendamentotransferencia;

import java.math.BigDecimal;

import org.joda.time.DateTime;

import br.com.empresateste.agendamentotransferencia.exception.GenericException;
import br.com.empresateste.agendamentotransferencia.model.TipoConta;
import br.com.empresateste.agendamentotransferencia.model.Transferencia;
import br.com.empresateste.agendamentotransferencia.service.TransferenciaService;

/**
 * Apenas a simulação do o cliente
 *
 */
public class App 
{
    public static void main( String[] args ){
    	try{
    		
    		System.out.println("===iniciando as transferencias===");
    		TransferenciaService s = new TransferenciaService();
    		
    		Transferencia t1 =new Transferencia("12345-9","67890-1",new BigDecimal("2000.0"), new DateTime(2017, 05, 29 , 0, 0), new DateTime(), TipoConta.A);
    		s.adicionaTransferencia(t1);
    		
    		Transferencia t2 =new Transferencia("22222-9","33333-1",new BigDecimal("1000.0"), new DateTime(2017, 07, 27 , 0, 0), new DateTime(), TipoConta.B);
    		s.adicionaTransferencia(t2);
    		
    		
    		Transferencia t3 =new Transferencia("23265-9","67890-1",new BigDecimal("350.0"), new DateTime(2017, 7, 8 , 0, 0), new DateTime(), TipoConta.C);
    		s.adicionaTransferencia(t3);
    		
    		Transferencia t4 =new Transferencia("12985-9","67540-1",new BigDecimal("144000.0"), new DateTime(2017, 10, 1 , 0, 0), new DateTime(), TipoConta.D);
    		s.adicionaTransferencia(t4);
    		
    		
    		for (Transferencia t : s.listaTransferenciasCadastradas()) {
				System.out.println(t);
			}
    		System.out.println("===Transferencias finalizadas===");
    	}catch(GenericException ge){
    		System.out.println("Ocorreu um erro:" +ge.getMessage());
    	}
        
    }
}
