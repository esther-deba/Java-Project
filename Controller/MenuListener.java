package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

import View.*;

import Model.Magasin;

public class MenuListener implements ActionListener{

	Magasin magasin;
	
	public MenuListener(Magasin m) {
		magasin = m;
	} 
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (((JButton)e.getSource()).getText().equals("Gestion Produits")) {
            GestionProduit gestionProduits = new GestionProduit(magasin.depots.get(0));
            gestionProduits.setVisible(true);
        }
		if (((JButton)e.getSource()).getText().equals("Gestion Vendeurs")) {
            GestionVendeur gestionVendeurs = new GestionVendeur(magasin);
            gestionVendeurs.setVisible(true);
        }
        if (((JButton)e.getSource()).getText().equals("Gestion Ventes")) {
            GestionVente gestionVentes = new GestionVente(magasin);
            gestionVentes.setVisible(true);
        }
        if (((JButton)e.getSource()).getText().equals("Gestion Clients")) {
            GestionClient gestionClients = new GestionClient(magasin);
            gestionClients.setVisible(true);
        }
        
		
	}

}