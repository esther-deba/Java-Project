
import java.time.LocalDate;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;

import Model.*;
import View.*;

public class Main {

	public static void main(String[] args) throws UnsupportedLookAndFeelException {
		// TODO Auto-generated method stub
		UIManager.setLookAndFeel(new NimbusLookAndFeel());
		Magasin magasin = new Magasin("ITools");
		Depot depot = new Depot(magasin,"03 Avenue Germaine");
		Menu menu = new Menu(magasin);
		Article pcDell = new Article("Pc DELL",600,"Bon état");
  Article iphone15 = new Article("iPhone 15",1400,"Neuf");
		Article iphone14Pro = new Article("iPhone 14 pro",900,"Reconditionné");
  Article cleUSB = new Article("Clé USB",80,"16 GO");
  depot.ajouteLigneStock(new LigneStock(30,depot,pcDell));
  depot.ajouteLigneStock(new LigneStock(40,depot,iphone15));
  depot.ajouteLigneStock(new LigneStock(5,depot,iphone14Pro));
  depot.ajouteLigneStock(new LigneStock(100,depot,cleUSB));
		magasin.ajouteStock(depot);
		Client client = new Client("DEBA", "esther", "0123456789", "27 rue d'Alger",magasin);
		Client client1 = new Client("DUPONT", "samy", "0123456789", "26 rue d'Alger",magasin);
		Client client2 = new Client("PIERRE", "hugo", "0123456789", "10 rue barbes",magasin);
		Vendeur vendeur = new Vendeur("DELLECI", "yanis", "0123456789", "26 rue de Telemcen",magasin);
		Vendeur vendeur2 = new Vendeur("JEAN", "luc", "0123456789", "26 rue d'henry",magasin);
		magasin.ajouteClient(client);
		magasin.ajouteClient(client1);
		magasin.ajouteClient(client2);
		magasin.ajouteVendeur(vendeur);
		magasin.ajouteVendeur(vendeur2);
		
		Commande commande = new Commande(LocalDate.now(),vendeur,client);
		vendeur.ajouteCommande(commande);
		client.ajouteCommande(commande);
		LigneCommande ligneCommande = new LigneCommande(2,commande,iphone15);
  commande.ajouteLigneCommande(ligneCommande);
	
		
	}

}
