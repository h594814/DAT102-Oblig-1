package FilmOgFilmarkiv;

public class Film {
	
	private int filmNr;
	private String filmskaper;
	private String tittel;
	private int lansering;
	private String filmselskap;
	private Sjanger sjanger;
	
	public Film() {
		
	}
	
	public Film(int filmnr, String Filmskaper, String filmTittel,
            int lanseringsår, String Filmselskap, Sjanger Sjanger) {
        
        filmNr = filmnr;
        filmskaper = Filmskaper;
        tittel = filmTittel;
        lansering = lanseringsår;
        filmselskap = Filmselskap;
        sjanger = Sjanger;
        
        
    } 
	
	public int getfilmNr() {
		return filmNr;
	}
	
	public void setfilmNr(int filmNr) {
		this.filmNr = filmNr;
	}

	public String getFilmskaper() {
		return filmskaper;
	}

	public void setFilmskaper(String filmskaper) {
		this.filmskaper = filmskaper;
	}

	public String getTittel() {
		return tittel;
	}

	public void setTittel(String tittel) {
		this.tittel = tittel;
	}

	public int getLansering() {
		return lansering;
	}

	public void setLansering(int lansering) {
		this.lansering = lansering;
	}


	public String getFilmselskap() {
		return filmselskap;
	}

	public void setFilmselskap(String filmselskap) {
		this.filmselskap = filmselskap;
	}
	
	public Sjanger getSjanger() {
		return sjanger;
	}
	
	public void setSjanger(Sjanger sjanger) {
		this.sjanger = sjanger;
	}
	
	@Override
	public boolean equals(Object a) {
		
		return this.getfilmNr() == ((Film) a).getfilmNr();
		
	}
	
	@Override
	public int hashCode() {
	 Integer temp = filmNr;
	 return temp.hashCode();
	}
	
	

}
