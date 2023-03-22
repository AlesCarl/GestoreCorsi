package it.polito.tdp.corsi.model;

import java.util.List;
import java.util.Map;

import it.polito.tdp.corsi.db.CorsoDAO;

public class Model {
	
	
	private CorsoDAO corsoDAO; 
	
	
	
	public Model() {
		this.corsoDAO= new CorsoDAO();
	}
	
	
	public List<Corso> getCorsiByPeriodo(int periodo){
		return corsoDAO.getCorsiByPeriodo(periodo);
		
	}
	
	public Map <Corso,Integer> getCorsiIscritti(int periodo){
		return corsoDAO.getCorsiIscritti(periodo);
	}
	
	public List<Studente> getStudentiByCorso(String codiceCorso){
		return corsoDAO.getStudentiByCorso(codiceCorso);
		
	}
	
	public List<Divisione> getStudentiByCDS(String codiceCorso){
		return corsoDAO.getStudentiByCDS(codiceCorso);
	}
	
		
}
