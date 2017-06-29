package br.com.teste.agendamentotarefa.model;

import java.math.BigDecimal;

import org.joda.time.DateTime;

public class ContaTransferencia {

	private String contaOrigem;
	private String contaDestino;
	private BigDecimal valorTransferencia;
	private Double taxa;
	private DateTime dataAgendamento;
	private TipoConta tipoConta;
	private String contaDestino2;

	


	public void setContaOrigem(String contaOrigem) {
		this.contaOrigem = contaOrigem;
	}

	public void setValorTransferencia(BigDecimal valorTransferencia) {
		this.valorTransferencia = valorTransferencia;
		
	}

	public void setDataAgendamento(DateTime dataAgendamento) {
		this.dataAgendamento = dataAgendamento;
	}

	public void setTipoConta(TipoConta tipoConta) {
		this.tipoConta = tipoConta;
		
	}
	
	public TipoConta getTipoConta() {
		return tipoConta;
	}

	public void setContaDestino(String contaDestino) {
		this.contaDestino2 = contaDestino;
	}

	

	public Double getTaxa() {
		return taxa;
	}

	public void setTaxa(Double taxa) {
		this.taxa = taxa;
	}

	public BigDecimal getValorTransferencia() {
		return valorTransferencia;
	}
	
	
	
	
}
