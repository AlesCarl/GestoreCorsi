package it.polito.tdp.corsi.model;

public class Divisione {

	String CDS;
	Integer n;
	
	
	public Divisione(String cDS, Integer n) {
		
		CDS = cDS;
		this.n = n;
	}
	
	

	public String getCDS() {
		return CDS;
	}



	public void setCDS(String cDS) {
		CDS = cDS;
	}



	public Integer getN() {
		return n;
	}



	public void setN(Integer n) {
		this.n = n;
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((CDS == null) ? 0 : CDS.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Divisione other = (Divisione) obj;
		if (CDS == null) {
			if (other.CDS != null)
				return false;
		} else if (!CDS.equals(other.CDS))
			return false;
		return true;
	}


	
	
	
	
}
