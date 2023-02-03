package klient;

import FilmOgFilmarkiv.Film;
import FilmOgFilmarkiv.Filmarkiv;
import adt.FilmarkivADT;

public class KlientFilmarkiv {

	public static void main(String[] args) {
		FilmarkivADT filma = new Filmarkiv(100);
		Meny meny = new Meny(filma);
		meny.start();
	}

	
		
}
