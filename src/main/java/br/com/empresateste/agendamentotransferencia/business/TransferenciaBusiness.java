package br.com.empresateste.agendamentotransferencia.business;

import java.math.BigDecimal;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import br.com.empresateste.agendamentotransferencia.exception.GenericException;
import br.com.empresateste.agendamentotransferencia.model.Transferencia;
import br.com.empresateste.agendamentotransferencia.model.TipoConta;

public class TransferenciaBusiness {
	
	private static TransferenciaBusiness instance = null;
	
	private TransferenciaBusiness(){}
	
	public static TransferenciaBusiness getInstance(){
		if(instance==null){
			instance = new TransferenciaBusiness();
		}
		return instance;
	}
	
	public void verificaContaTransferenciaValida(String conta) throws GenericException{
		// TODO Auto-generated method stub

		//padrão XXXXX­X
		String mascaraConta = "\\d{5}-[a-zA-Z0-9]{1}";
		Pattern padrao = Pattern.compile(mascaraConta);
		Matcher m = padrao.matcher(conta);
		if(!m.matches()){
			throw new GenericException("Conta informada nao esta no padrao");
		}
	}

	/**
	 * A: Operações do tipo A tem uma taxa de $2 mais 3% do valor da transferência
	 * 
	 **/
	private void calculaTaxaTipoA(Transferencia transferencia){
		BigDecimal valorTaxaCalculada  = transferencia.getValorTransferencia().multiply(new BigDecimal("3")).divide(new BigDecimal("100")).add(new BigDecimal("2"));
		transferencia.setTaxa(valorTaxaCalculada.doubleValue());
	}
	
//	/**
//	 * Operações do tipo B tem uma taxa de:
//	 * $10 para pedidos com agendamento até 30 dias da data de cadastro
//	 * $8 para os demais
//	 **/
//	private void calculaTaxaTipoB(ContaTransferencia conta){
//		BigDecimal valorTaxaCalculada  = conta.getValorTransferencia().multiply(new BigDecimal("3").divide(new BigDecimal("100"))).add(new BigDecimal(2));
//		conta.setTaxa(valorTaxaCalculada);
//	}
	
	public void calculaTaxaTransferencia(Transferencia transferencia) {
		// TODO Auto-generated method stub
		if(transferencia.getTipoConta().equals(TipoConta.A)){
			calculaTaxaTipoA(transferencia);
		}
		
	}


}
