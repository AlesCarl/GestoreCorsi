/**
 * Sample Skeleton for 'Scene.fxml' Controller Class
 */

package it.polito.tdp.corsi;

import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

import it.polito.tdp.corsi.model.Corso;
import it.polito.tdp.corsi.model.Divisione;
import it.polito.tdp.corsi.model.Model;
import it.polito.tdp.corsi.model.Studente;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {

	private Model model;
	
	
	
    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="txtPeriodo"
    private TextField txtPeriodo; // Value injected by FXMLLoader

    @FXML // fx:id="txtCorso"
    private TextField txtCorso; // Value injected by FXMLLoader

    @FXML // fx:id="btnCorsiPerPeriodo"
    private Button btnCorsiPerPeriodo; // Value injected by FXMLLoader

    @FXML // fx:id="btnNumeroStudenti"
    private Button btnNumeroStudenti; // Value injected by FXMLLoader

    @FXML // fx:id="btnStudenti"
    private Button btnStudenti; // Value injected by FXMLLoader

    @FXML // fx:id="btnDivisioneStudenti"
    private Button btnDivisioneStudenti; // Value injected by FXMLLoader

    @FXML // fx:id="txtRisultato"
    private TextArea txtRisultato; // Value injected by FXMLLoader

    
    
    @FXML  //  ******************    #1   ***************
    void corsiPerPeriodo(ActionEvent event) {
    	String input= txtPeriodo.getText();
    	int inputNumerico=0; 
    	
    	//controllo se è un intero il numero inserito 
    	try {
    	 inputNumerico= Integer.parseInt(input);
    	
    	}catch(NumberFormatException e) {
    		txtRisultato.setText("valore inserito non è un intero ");
    		return ; 
    	}
    	
    	if(inputNumerico<1 || inputNumerico>2) {
    		txtRisultato.setText("inserisci 1 o 2 ");
    		return; 

    	}
    	List <Corso> result = new ArrayList<>();
    	
    	result= model.getCorsiByPeriodo(inputNumerico);
    	
    	txtRisultato.clear();
		txtRisultato.setText("ho trovato "+result.size()+" corsi. \n ");
		
		for(Corso c: result) {
			txtRisultato.appendText(""+c);
		}
	
    	
    }

    @FXML //  ******************    #2    ***************
    void numeroStudenti(ActionEvent event) {
		Map <Corso,Integer> resultMap = new  HashMap<>();
		int cont=0;
		int inputNumerico=0; 
		
		String input= txtPeriodo.getText();
		
		try {
	    	 inputNumerico= Integer.parseInt(input);
	    	
	    	}catch(NumberFormatException e) {
	    		txtRisultato.setText("valore inserito non è un intero ");
	    		return ; 
	    	}
		
		if(inputNumerico<1 || inputNumerico>2) {
    		txtRisultato.setText("inserisci 1 o 2 ");
    		return; 
    	}
		
		resultMap= model.getCorsiIscritti(inputNumerico);
		
    	txtRisultato.clear();

    	for(int ii:resultMap.values() ) {
    		cont+= ii; 
    	}
    	
	    txtRisultato.setText("ci sono "+cont+" studenti iscritti al periodo didattico scelto. \n ");
    	
    }

    @FXML //  ******************    #4    ***************
    void stampaDivisione(ActionEvent event) {
		
    	List <Divisione> result = new ArrayList<>();
    	String input= txtCorso.getText();    	
    	
    	//controlli
    	
        result= model.getStudentiByCDS(input); 
        
    	
    	txtRisultato.clear();
    	System.out.println(input);
		//txtRisultato.setText("ho trovato "+resultMap.size()+" gruppi di CORSI DI STUDIO. \n ");
		
    	if(result.size()==0) {
    		txtRisultato.setText("NESSUNA CORRIPONDENZA");
    		return ; 
    	}
    	
		for(Divisione d: result) {
			txtRisultato.appendText(""+d.getCDS()+" "+d.getN()+'\n');
		}
    }

    @FXML //  ******************    #3   ***************
    void stampaStudenti(ActionEvent event) {
    	
      String input= txtCorso.getText();    	
    	
    	//controlli
    	
   
    	List <Studente> result = new ArrayList<>();
    	
    	result= model.getStudentiByCorso(input);
    	
    	txtRisultato.clear();
		txtRisultato.setText("ho trovato "+result.size()+" studenti. \n ");
		
		for(Studente s: result) {
			txtRisultato.appendText(""+s+'\n');
		}

    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert txtPeriodo != null : "fx:id=\"txtPeriodo\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtCorso != null : "fx:id=\"txtCorso\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnCorsiPerPeriodo != null : "fx:id=\"btnCorsiPerPeriodo\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnNumeroStudenti != null : "fx:id=\"btnNumeroStudenti\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnStudenti != null : "fx:id=\"btnStudenti\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnDivisioneStudenti != null : "fx:id=\"btnDivisioneStudenti\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtRisultato != null : "fx:id=\"txtRisultato\" was not injected: check your FXML file 'Scene.fxml'.";

    }
    
    public void setModel(Model model) {
    	this.model = model;
    }
    
    
}