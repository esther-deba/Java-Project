
import java.time.LocalDate;

import Model.*;
import View.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Magasin m = new Magasin("nom");
		Depot d = new Depot(m,"ad");
		Menu menu = new Menu(m);
	    //GestionProduit p = new GestionProduit(d);
		//GestionClient c = new GestionClient(m);
		Article pcPortable = new Article("Pc Portable",600,"Pc portable de marque HP i7 1To SSD Windows10");
        Article iphone15 = new Article("iPhone 15",1400,"La nouvelle pépite Apple est enfin la !");
        Article macBook = new Article("MacBook",900,"L'ordinateur intélligent d'apple !");
        Article tv = new Article("TV",200,"Télévision énorme avec une dalle OLED 4K");
        d.ajouteLigneStock(new LigneStock(30,d,pcPortable));
        d.ajouteLigneStock(new LigneStock(45,d,iphone15));
        d.ajouteLigneStock(new LigneStock(10,d,macBook));
        d.ajouteLigneStock(new LigneStock(70,d,tv));
		m.ajouteStock(d);
		Client client = new Client("DEBA", "Esther", "0365695", "dejhif",m);
		Vendeur vendeur = new Vendeur("DEBA", "Esther", "0365695", "dejhif",m);
		m.ajouteClient(client);
		m.ajouteVendeur(vendeur);
		
		Commande commande = new Commande(LocalDate.now(),vendeur,client);
		vendeur.ajouteCommande(commande);
		client.ajouteCommande(commande);
		LigneCommande ligneCommande = new LigneCommande(2,commande,iphone15);
        commande.ajouteLigneCommande(ligneCommande);
		//GestionVente vente = new GestionVente(m);
		//StatClient statC = new StatClient(m);
		
	}

}
