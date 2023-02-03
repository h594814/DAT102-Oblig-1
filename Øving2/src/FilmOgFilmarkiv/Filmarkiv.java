package FilmOgFilmarkiv;

import adt.FilmarkivADT;

public class Filmarkiv implements FilmarkivADT {
	
	private int antall = 0;
	private Film[] filmer;

	public Filmarkiv (int plass) {
		filmer = new Film[plass];
	}
	
	
	@Override
	public Film finnFilm(int nr) {
		
		Film film = null;
		
		for(int i = 0; i<filmer.length; i++) {
			if(nr == filmer[i].getfilmNr()) {
				
				film = filmer[i];
			}
		}
		return film;
	}

	@Override
	public void leggTilFilm(Film nyFilm) {
		
		if(antall < filmer.length) {
            
            filmer[antall] = nyFilm;
            antall++;
        } else {
        	utvid();
        	filmer[antall]=nyFilm;
        	antall++;
        }
	}

	@Override
	public boolean slettFilm(int filmnr) {
		
		boolean sant = false;
		
		for(int i =0; i < filmer.length; i++) {
			
			if(filmer[i].getfilmNr() == filmnr) {
				filmer[i] = filmer[antall - 1];
				filmer[antall - 1] = null;
				antall--;
				sant = true;
			}
		}
		
		return sant;
			
	}

	@Override
	public Film[] soekTittel(String delstreng) {
		

		Film[] newFilm = new Film[antall];
		int j = 0;

		for (int i = 0; i < antall; i++) {
			if (filmer[i].getTittel().contains(delstreng)) {
				newFilm[j] = filmer[i];
				j++;
			}
		}
		return trimTab(filmer, j);
	}
	
	Film[] soekProdusent(String delstreng) {
		
		/**
		* Søker og henter filmer med en gitt delstreng i filmprodusent
		*
		* @param delstreng
		* @return
		*/
		Film[] newFilm = new Film[antall];
		int j = 0;

		for (int i = 0; i < antall; i++) {
			if (filmer[i].getFilmskaper().contains(delstreng)) {
				newFilm[j] = filmer[i];
				j++;
			}
		}
		return trimTab(filmer, j);
		
		
	}
	

	@Override
	public int antall(Sjanger sjanger) {
		
		int antSjanger = 0;
		
		for(int i = 0; i < antall; i++) {
			
			if(filmer[i].getSjanger().equals(sjanger)) {
				antSjanger++;
			}
		}
		
		return antSjanger;
	}

	@Override
	public int antall() {
		
		return antall;
	}
	
	private Film[] utvid() {
		
		int newSize = filmer.length * 2;
	    Film[] newFilmer = new Film[newSize];
	    for (int i = 0; i < filmer.length; i++) {
	        newFilmer[i] = filmer[i];
	    }
	    filmer = newFilmer;
	    return filmer;
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
	
	
	

}
