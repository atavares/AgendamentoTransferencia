package br.com.empresateste.agendamentotransferencia.dao;

import java.util.ArrayList;
import java.util.List;

import br.com.empresateste.agendamentotransferencia.model.Transferencia;


public class TransferenciaDAO {
	
	private static TransferenciaDAO instance = null;
	
	private TransferenciaDAO(){}
	
	public static TransferenciaDAO getInstance(){
		if(instance==null){
			instance = new TransferenciaDAO();
		}
		return instance;
	}
	
	private List<Transferencia> dados = new ArrayList<Transferencia>();

	


	public void adiciona(Transferencia t){
		dados.add(t);
	}
	
	public List<Transferencia> listaTodos(){
		return dados;
	}

}
