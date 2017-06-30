package br.com.empresateste.agendamentotransferencia.model;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;

import org.joda.time.DateTime;

public class Transferencia {

	private String contaOrigem;
	private String contaDestino;
	private BigDecimal valorTransferencia;
	private Double taxa;
	private DateTime dataAgendamento;
	private DateTime dataCadastro;
	private TipoConta tipoConta;

	public Transferencia(String contaOrigem, String contaDestino, BigDecimal valorTransferencia, DateTime dataAgendamento, DateTime dataCadastro, TipoConta tipoConta) {
		// TODO Auto-generated constructor stub
		this.contaOrigem = contaOrigem;
		this.contaDestino= contaDestino;
		this.valorTransferencia = valorTransferencia;
		this.dataAgendamento = dataAgendamento;
		this.dataCadastro = dataCadastro;
		this.tipoConta = tipoConta;
	}


	public TipoConta getTipoConta() {
		return tipoConta;
	}

	

	public DateTime getDataAgendamento() {
		return dataAgendamento;
	}


	public DateTime getDataCadastro() {
		return dataCadastro;
	}


	public void setTaxa(Double taxa) {
		this.taxa = taxa;
	}



	public Double getTaxa() {
		return taxa;
	}


	public BigDecimal getValorTransferencia() {
		return valorTransferencia;
	}


	public String getContaOrigem() {
		return contaOrigem;
	}


	public String getContaDestino() {
		return contaDestino;
	}
	
	@Override
	public String toString() {
		return "[conta origem:"+contaOrigem+" "+" conta destino:"+contaDestino+" data agendamento:"+ new SimpleDateFormat("dd/MM/yyyy").format(dataAgendamento.toDate())+" data cadastro:"+ new SimpleDateFormat("dd/MM/yyyy").format(dataCadastro.toDate())+" valor transferência:"+new DecimalFormat("###,###,##0.00").format(valorTransferencia)+" tipo conta:"+tipoConta+" taxa calculada:"+taxa+"]";
	}
	
	
}
