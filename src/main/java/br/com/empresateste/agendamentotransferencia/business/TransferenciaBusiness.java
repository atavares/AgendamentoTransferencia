package br.com.empresateste.agendamentotransferencia.business;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.joda.time.Days;

import br.com.empresateste.agendamentotransferencia.exception.GenericException;
import br.com.empresateste.agendamentotransferencia.model.TipoConta;
import br.com.empresateste.agendamentotransferencia.model.Transferencia;

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
		// TODO Auto-generated method stub
		Double valorTaxaCalculada  = (transferencia.getValorTransferencia().doubleValue()*3)/100+2.0;
		transferencia.setTaxa(Double.parseDouble(String.format(new Locale("en", "US"),"%.1f", valorTaxaCalculada.doubleValue())));
	}
	
	/**
	 * Operações do tipo B tem uma taxa de:
	 * $10 para pedidos com agendamento até 30 dias da data de cadastro
	 * $8 para os demais
	 **/
	private void calculaTaxaTipoB(Transferencia transferencia){
		// TODO Auto-generated method stub
		Integer quantidadeDiasDiferencaDatas = Days.daysBetween(transferencia.getDataCadastro(),transferencia.getDataAgendamento()).getDays();
		Double valorTaxaCalculada  = 8.0;
		if(quantidadeDiasDiferencaDatas<=30){
			valorTaxaCalculada  = 10.0;
		}
		transferencia.setTaxa(Double.parseDouble(String.format(new Locale("en", "US"),"%.1f", valorTaxaCalculada.doubleValue())));
	}
	
	/**
	 *	C: Operações do tipo C tem uma taxa regressiva conforme a data de
	 *	agendamento:
	 *	maior que 30 dias da data de cadastro ­ 1.2%
	 *	até 5 dias da data de cadastro ­ 8.3%
	 *	até 10 dias da data de cadastro ­ 7.4%
	 *	até 15 dias da data de cadastro ­ 6.7%
	 *	até 20 dias da data de cadastro ­ 5.4%
	 *	até 25 dias da data de cadastro ­ 4.3%
	 *	até 30 dias da data de cadastro ­ 2.1%
	 **/
	private void calculaTaxaTipoC(Transferencia transferencia){
		// TODO Auto-generated method stub
		Integer quantidadeDiasDiferencaDatas = Days.daysBetween(transferencia.getDataCadastro(),transferencia.getDataAgendamento()).getDays();
		Double valorTaxaCalculada = 0.0;
		
		if(quantidadeDiasDiferencaDatas>30){
			valorTaxaCalculada  = (transferencia.getValorTransferencia().doubleValue()*1.2)/100;
		}else{
			if(quantidadeDiasDiferencaDatas<=5){
				valorTaxaCalculada  = (transferencia.getValorTransferencia().doubleValue()*8.3)/100;
			}else{
				if(quantidadeDiasDiferencaDatas<=10){
					valorTaxaCalculada  = (transferencia.getValorTransferencia().doubleValue()*7.4)/100;
				}else{
					if(quantidadeDiasDiferencaDatas<=15){
						valorTaxaCalculada  = (transferencia.getValorTransferencia().doubleValue()*6.7)/100;
					}else{
						if(quantidadeDiasDiferencaDatas<=20){
							valorTaxaCalculada  = (transferencia.getValorTransferencia().doubleValue()*5.4)/100;
						}else{
							if(quantidadeDiasDiferencaDatas<=25){
								valorTaxaCalculada  = (transferencia.getValorTransferencia().doubleValue()*4.3)/100;
							}else{
								if(quantidadeDiasDiferencaDatas<=30){
									valorTaxaCalculada  = (transferencia.getValorTransferencia().doubleValue()*2.1)/100;
								}
							}
						}
					}
				}
			}
		}
		transferencia.setTaxa(Double.parseDouble(String.format(new Locale("en", "US"),"%.1f", valorTaxaCalculada.doubleValue())));
	}
	
	/**
	 *	D: Operações do tipo D tem a taxa igual a A, B ou C dependendo do valor da
	 *	transferência.
	 *	Valores até $25.000 seguem a taxação tipo A
	 *	Valores de $25.001 até $120.000 seguem a taxação tipo B
	 *	Valores maiores que $120.000 seguem a taxação tipo C
	 **/
	private void calculaTaxaTipoD(Transferencia transferencia){
		// TODO Auto-generated method stub
		if(transferencia.getValorTransferencia().compareTo(new BigDecimal("25000"))==-1){
			calculaTaxaTipoA(transferencia);
		}else{
			if(transferencia.getValorTransferencia().compareTo(new BigDecimal("25000"))>0 && transferencia.getValorTransferencia().compareTo(new BigDecimal("120000"))==-1){
				calculaTaxaTipoB(transferencia);
			}else{
				if(transferencia.getValorTransferencia().compareTo(new BigDecimal("120000"))>=1){
					calculaTaxaTipoC(transferencia);
				}
			}
		}
	}
	
	public void calculaTaxaTransferencia(Transferencia transferencia) throws GenericException {
		// TODO Auto-generated method stub
		verificaContaTransferenciaValida(transferencia.getContaOrigem());
		verificaContaTransferenciaValida(transferencia.getContaDestino());

		if(transferencia.getTipoConta().equals(TipoConta.A)){
			calculaTaxaTipoA(transferencia);
		}else{
			if(transferencia.getTipoConta().equals(TipoConta.B)){
				calculaTaxaTipoB(transferencia);
			}else{
				if(transferencia.getTipoConta().equals(TipoConta.C)){
					calculaTaxaTipoC(transferencia);
				}else{
					if(transferencia.getTipoConta().equals(TipoConta.D)){
						calculaTaxaTipoD(transferencia);
					}
				}
			}
		}
		
	}


}
