package br.com.empresateste.agendamentotransferencia.service;

import java.util.List;

import br.com.empresateste.agendamentotransferencia.business.TransferenciaBusiness;
import br.com.empresateste.agendamentotransferencia.dao.TransferenciaDAO;
import br.com.empresateste.agendamentotransferencia.exception.GenericException;
import br.com.empresateste.agendamentotransferencia.model.Transferencia;

public class TransferenciaService {
		
	public List<Transferencia> listaTransferenciasCadastradas(){
		return TransferenciaDAO.getInstance().listaTodos();
	}

	
	public void adicionaTransferencia(Transferencia transferencia) throws GenericException{
		// TODO Auto-generated method stub
		TransferenciaBusiness.getInstance().calculaTaxaTransferencia(transferencia);
		TransferenciaDAO.getInstance().adiciona(transferencia);
	}

}
