package it.polito.tdp.corsi.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import it.polito.tdp.corsi.model.Corso;
import it.polito.tdp.corsi.model.Divisione;
import it.polito.tdp.corsi.model.Studente;


// -----------------------  PROTOTIPO TIPO PER I DAO   ----------------------- 

public class CorsoDAO {

//  *******************    #1    ***************
	
	public List<Corso> getCorsiByPeriodo(int periodo){
		
		String sql= "SELECT * "
				+"FROM corso "
				+"WHERE pd = ?";
// Elencare tutti i corsi di un determinato periodo didattico. Se l'utente digita "1", il programma dovrà stampare tutti i 
// corsi del primo semestre, se l'utente digita "2", il programma dovrà stampare tutti i corsi del secondo semestre.
		
		
		
		List<Corso> resultCorso = new ArrayList<>();
		//creo connessione: 
		
		
		try {
			Connection conn = ConnectDB.getConnection();  // da qua fa' automaticamente il TRY/CATCH
			PreparedStatement st= conn.prepareStatement(sql);
			
			st.setInt(1, periodo);  // "posizione del "?" nella query " e "valore"
			
			ResultSet rs= st.executeQuery();
			
			while(rs.next()) {
				Corso c = new Corso(rs.getString("codins"), rs.getInt("crediti"), rs.getString("nome"), rs.getInt("pd"));
				resultCorso.add(c);
				
			}
			rs.close();
			st.close();
			conn.close();
			return resultCorso;
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
			return null; 
			
		}
		

		
	}
//  ******************    #2    ***************
	
	public Map <Corso,Integer> getCorsiIscritti (int periodo) {
		
		String sql= "select c.codins, c.crediti, c.nome, c.pd, count(*) as n "
				+ "from corso c, iscrizione i "
				+ "where c.codins = i.codins and c.pd=? "
				+ "group by c.codins, c.crediti, c.nome, c.pd";
				
		//Stampare il numero di iscritti ai corsi di un determinato periodo didattico.

				
		
		
		Map <Corso,Integer> result = new  HashMap<>();
		//creo connessione: 
		
		
		try {
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st= conn.prepareStatement(sql);
			// "posizione del "?" nella query " e "valore"di solito cosa inserisco qui ?? 
			
			ResultSet rs= st.executeQuery();
			
			while(rs.next()) {
				Corso c = new Corso(rs.getString("codins"), rs.getInt("crediti"), rs.getString("nome"), rs.getInt("pd"));
				
				result.put(c, rs.getInt("n"));
				
			}
			rs.close();
			st.close();
			conn.close();
			return result;
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
			return null; 
			
		}
		
		
		
	}
	
//  ******************    #3    ***************
	
     public List<Studente> getStudentiByCorso(String codiceCorso){
		
		String sql= "select s.matricola , s.cognome, s.nome, s.CDS "
			       +"from  iscrizione i, studente s " 
			       +"where i.matricola = s.matricola and i.codins=?"; 
	
	//Elencare tutti gli studenti di un determinato corso. L'utente inserisce il codice di un corso, e il programma stampa tutti gli studenti iscritti.

		
		List<Studente> resultCorso = new ArrayList<>();
		//creo connessione: 
		
		
		try {
			Connection conn = ConnectDB.getConnection();  // da qua fa' automaticamente il TRY/CATCH
			PreparedStatement st= conn.prepareStatement(sql);
			
			st.setString(1, codiceCorso);  // "posizione del "?" nella query " e "valore"
			
			ResultSet rs= st.executeQuery();
			
			while(rs.next()) {
				Studente s = new Studente(rs.getInt("matricola"), rs.getString("cognome"), rs.getString("nome"), rs.getString("CDS"));
				resultCorso.add(s);
				
			}
			rs.close();
			st.close();
			conn.close();
			return resultCorso;
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
			return null; 
			
		}
		
	}
     
 //  ******************    #4    ***************
     
     public List<Divisione> getStudentiByCDS(String codiceCorso){
 		
 		String sql= "select  s.CDS, count(s.CDS) as n "
 				    +"from  iscrizione i, studente s "
 				    +"where i.matricola = s.matricola and i.codins=? and s.CDS <> '' "
 				    +"group by  s.CDS"; 
 	
 	//Dato il codice di un corso, stampare la DIVISIONE degli studenti iscritti tra i vari Corsi di Studio (CDS).

		List<Divisione> result = new ArrayList<>();

 		
 		try {
 			Connection conn = ConnectDB.getConnection();  // da qua fa' automaticamente il TRY/CATCH
 			PreparedStatement st= conn.prepareStatement(sql);
 			
 			st.setString(1, codiceCorso);  // "posizione del "?" nella query " e "valore"
 			
 			ResultSet rs= st.executeQuery();
 			
 			while(rs.next()) {
 				Divisione ds = new Divisione(rs.getString("CDS"), rs.getInt("n"));
 				result.add(ds);
 				
 			}
 			rs.close();
 			st.close();
 			conn.close();
 			return result;
 			
 			
 			
 		} catch (SQLException e) {
 			e.printStackTrace();
 			return null; 
 			
 		}
 		
 	}
	
}
