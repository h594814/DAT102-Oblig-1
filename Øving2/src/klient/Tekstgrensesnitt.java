package klient;

import java.util.Scanner;

import FilmOgFilmarkiv.Film;
import FilmOgFilmarkiv.Sjanger;
import adt.FilmarkivADT;

public class Tekstgrensesnitt {
	// lese opplysningene om en FILM fra tastatur
	public Film lesFilm() {
		
		Film film;
		
		Scanner scanner = new Scanner (System.in);
		System.out.println("Skriv inn filmnr.");
		int filmnr = scanner.nextInt();
		
		System.out.println("Skriv inn Filmskaper");
		String Filmsakper = scanner.nextLine();
		
		System.out.println("Skriv inn Filmtittel");
		String filmTittel = scanner.nextLine();
		
		System.out.println("Skriv inn lanseringsår");
		int lanseringsår = scanner.nextInt();
		
		System.out.println("Skriv inn Filmselskap");
		String Filmselskap = scanner.nextLine();
		
		System.out.println("Velg sjanger, mellom: Action, Drama, History og Scifi.");
		String sjanger = scanner.nextLine();
		Sjanger sjang = null;
		
		do {
		if(sjanger.equals("Action")) {
			sjang = Sjanger.ACTION;
		} else if(sjanger.equals("Drama")) {
			sjang = Sjanger.DRAMA;
		} else if(sjanger.equals("History")) {
			sjang = Sjanger.HISTORY;
		} else if(sjanger.equals("Scifi")) {
			sjang = Sjanger.SCIFI;
		} else {
			System.out.println("Ugyldig sjanger, prøv igjen");
			sjanger = scanner.nextLine();
		}
		} while(sjang == null);
		
		film = new Film(filmnr,Filmsakper,filmTittel,lanseringsår,Filmselskap,sjang);
		
		return film;
		
	}

	// vise en film med alle opplysninger på skjerm (husk tekst for sjanger)
	public void visFilm(Film film) {
		
		System.out.println("Filmnr: " + film.getfilmNr());
		System.out.println("Filmskaper: " + film.getFilmskaper());
		System.out.println("Filmtittel: " + film.getTittel());
		System.out.println("Lanseringsår: " + film.getLansering());
		System.out.println("Filmselskap: " + film.getFilmselskap());
		System.out.println("Sjanger: " + film.getSjanger());
	}

	// Skrive ut alle Filmer med en spesiell delstreng i tittelen
	public void skrivUtFilmDelstrengITittel(FilmarkivADT filma, String delstreng) {
		
		Film[] tabell = filma.soekTittel(delstreng);
		
		for(Film film : tabell) {
			
			visFilm(film);
			System.out.println();
			
		}
		
	}

	// Skriver ut alle Filmer av en produsent / en gruppe
	public void skrivUtFilmProdusent(FilmarkivADT filma, String delstreng) {
		
		Film[] tabell = filma.soekTittel(delstreng);
		
		for(Film film : tabell) {
			
			visFilm(film);
			System.out.println();
			
		}
		
	}

	// Skrive ut en enkel statistikk som inneholder antall Filmer totalt
	// og hvor mange det er i hver sjanger
	public void skrivUtStatistikk(FilmarkivADT filma) {
		
		System.out.println("Antall filmer totalt: " + filma.antall());
		System.out.println("Antall filmer i Action sjangeren: " + filma.antall(Sjanger.ACTION));
		System.out.println("Antall filmer i Drama sjangeren: " + filma.antall(Sjanger.DRAMA));
		System.out.println("Antall filmer i History sjangeren: " + filma.antall(Sjanger.HISTORY));
		System.out.println("Antall filmer i Scifi sjangeren: " + filma.antall(Sjanger.SCIFI));
	}

}













