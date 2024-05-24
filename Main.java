
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;

import Model.*;
import View.*;

public class Main {

	public static void main(String[] args) throws UnsupportedLookAndFeelException {
		// TODO Auto-generated method stub
				UIManager.setLookAndFeel(new NimbusLookAndFeel());
				Magasin m = new Magasin("nom");
				Depot d = new Depot(m,"ad");
				Menu menu = new Menu(m);
	   //GestionProduit p = new GestionProduit(d);
				// GestionClient c = new GestionClient(m);
				// GestionVendeur v = new GestionVendeur(m);
				Article pcPortable = new Article("Pc Portable",600,"Pc portable de	marque HP i7 1To SSD Windows10");
    Article iphone15 = new Article("iPhone 15",1400,"La nouvelle pépite Apple est enfin la !");
    Article macBook = new Article("MacBook",900,"L'ordinateur intélligent d'apple !");
    Article tv = new Article("TV",200,"Télévision énorme avec une dalle OLED 4K");
    d.ajouteLigneStock(new LigneStock(30,d,pcPortable));
    d.ajouteLigneStock(new LigneStock(45,d,iphone15));
    d.ajouteLigneStock(new LigneStock(10,d,macBook));
    d.ajouteLigneStock(new LigneStock(70,d,tv));
		  m.ajouteStock(d);
		  // GestionVente vente = new GestionVente(m);
	}

}
