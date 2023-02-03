package FilmOgFilmarkiv;

import adt.FilmarkivADT;

public class Filmarkiv2 implements FilmarkivADT {
	
	private int antall; 
    private LinearNode<Film> start;
	
    public Filmarkiv2 () {
    	start = new LinearNode<>();
    }
    
    @Override
    public Film finnFilm(int nr) {
		
		Film film = null;
		LinearNode<Film> current = start;
		
		while(current != null) {
			if(nr == current.getElement().getfilmNr()) {
				film = current.getElement();
				break;
			}
			current = current.getNeste();
		}
		return film;
	}

	@Override
	public void leggTilFilm(Film film) {
		LinearNode<Film> newNode = new LinearNode<>(film);
		newNode.setNeste(start);
		start = newNode;
		antall++;
	}

	@Override
	public boolean slettFilm(int filmnr) {
	    boolean sant = false;
	    LinearNode<Film> current = start;
	    LinearNode<Film> previous = null;

	    while (current != null) {
	        if (current.getElement().getfilmNr() == filmnr) {
	            if (previous == null) {
	                start = current.getNeste();
	            } else {
	                previous.setNeste(current.getNeste());
	            }
	            antall--;
	            sant = true;
	            break;
	        }
	        previous = current;
	        current = current.getNeste();
	    }
	    return sant;
	}


	@Override
	public Film[] soekTittel(String delstreng) {
		

		Film[] newFilm = new Film[antall];
		LinearNode<Film> current = start;
		int j = 0;
		
		while(current != null) {
			if(current.getElement().getTittel().contains(delstreng)) {
				newFilm[j] = current.getElement();
				j++;
			}	
				current = current.getNeste();
			
		}
		return trimTab(newFilm, j);
	}
	
	Film[] soekProdusent(String delstreng) {
		
		/**
		* Søker og henter filmer med en gitt delstreng i filmprodusent
		*
		* @param delstreng
		* @return
		*/
		Film[] newFilm = new Film[antall];
		LinearNode<Film> current = start;
		int j = 0;
		
		while(current != null) {
			if(current.getElement().getFilmskaper().contains(delstreng)) {
				newFilm[j] = current.getElement();
				j++;
			}	
				current = current.getNeste();
			
		}
		return trimTab(newFilm, j);
		
		
	}
	

	@Override
	public int antall(Sjanger sjanger) {
		
		int antSjanger = 0;
		LinearNode<Film> current = start;
		
			
		while(current != null) {
			if(current.getElement().getSjanger().equals(sjanger)) {
				antSjanger++;
			}
			current = current.getNeste();
		}
		
		return antSjanger;
	}

	@Override
	public int antall() {
		
		return antall;
	}
	
	
	private Film[] trimTab(Film[] tab, int n) {

		Film[] filmtab2 = new Film[n];
		int i = 0;
		while (i < n) {
			filmtab2[i] = tab[i];
			i++;
		}
		return filmtab2;
	}
	
	/*
	 * La k være antall sjangre og n være antall filmer. Hva er tidskompleksiteten uttrykt i O-notasjon med  
		k og n for de to metodene i) og ii) under? Begrunn svaret. 
		
		i) For å finne antall sjangere i en LinkedList, så må vi sjekke hver node, når vi sjekker 1 og 1 node
			om gangen, får vi en O(n) tidskompleksitet.
			
		ii) Her må vi printe ut en linje med hver av de ulike statistikkene. Dette vil også gi oss en
			tidskompleksitet av O(n)
	
	 */
	
	
	

}









