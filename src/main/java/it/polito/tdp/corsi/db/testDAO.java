package it.polito.tdp.corsi.db;

import java.util.*;

import it.polito.tdp.corsi.model.Corso;
import it.polito.tdp.corsi.model.Studente;

public class testDAO {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		CorsoDAO dao = new CorsoDAO();
		List<Corso> result= new ArrayList<>();
		Map <Corso,Integer> resultMap= new TreeMap<Corso,Integer>();
		List<Studente> result2= new ArrayList<>();
		
		
		result= dao.getCorsiByPeriodo(1);
		resultMap= dao.getCorsiIscritti(1);
		result2= dao.getStudentiByCorso("01KSUPG");
		
		
		for(Corso c: result) {
			System.out.println(""+c);
			
		}
		
		
		System.out.println("\n ******************************** \n ");

		for(Studente c: result2) {
			System.out.println(""+c);
			
		}
		
		
		

	}

}
