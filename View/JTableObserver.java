package View;

import java.util.Observable;
import java.util.Observer;
import java.util.Vector;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Model.Client;
import Model.Depot;
import Model.LigneStock;
import Model.Vendeur;

public class JTableObserver implements Observer {

	JTable table;

    public JTableObserver(JTable table) {
        this.table = table;
    }
	@Override
	public void update(Observable obs, Object arg) {
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		 if (obs instanceof Depot) {
			 LigneStock ls = (LigneStock) arg;
			// vérifie si la LigneStock envoyé existe déja dans notre table
	        // si elle existe ca veut dire que le boutton supprimer a été appuyer donc
	        // on le supprime et on quitte avec return;
			 for (int i = 0; i < table.getRowCount(); i++) {
				 Object nom_ligne = table.getValueAt(i, 0);
	                if (((String) nom_ligne) == ls.article.nom) {
	                    model.removeRow(i);
	                    return;
	                }
			 }
			// si elle y est pas ca veut dire qu'on doit l'ajouter :
			 Vector<Object> o = new Vector<Object>();
			 o.add(ls.article.nom);
	         o.add(ls.article.prix);
	         o.add(ls.qte);
	         o.add(ls.article.description);
	         model.addRow(o);
		 }
		  
		 
		 
		 
	      // le cas où l'observation vient de l'interface GestionVendeurs
	        if( arg instanceof Vendeur) {
	        	 Vendeur vendeur = (Vendeur) arg;
	        	// parcours le tableau pour voir si le vendeur existe ou pas
	            // si l'observation vient du boutton supprimer
	        	 for (int i = 0; i < table.getRowCount(); i++) {
	        		 Object nom_ligne = table.getValueAt(i, 0);
	        		 Object prenom_row = table.getValueAt(i, 1);
	        		 
	        		 if ( vendeur.nom.equals( ((String)nom_ligne) ) && vendeur.prenom.equals( ((String)prenom_row) ) ) {
	        			 model.removeRow(i);
	        			 return; // si un vendeur a été supprimer ça quitte comme ca il sera pas ajouter juste au dessous 
	        		 }
	        	 }
	           	// sinon si l'observation vient du boutton ajouter, apres avoir parcourru le tableau et
	             // avoir vérifier que le vendeur n'existe pas alors elle l'ajoute
	             // ajouter le vendeur si il existe pas dans le tableau
	        	 
	        	 Vector<Object> o = new Vector<Object>();
	      
	             o.add(vendeur.nom);
	             o.add(vendeur.prenom);
	             o.add(vendeur.num);
	             o.add(vendeur.adresse);
	             model.addRow(o);
	         }
	         
	         
	      // le cas où l'observation vient de l'interface GestionClient
	         if( arg instanceof Client){
	             Client client = (Client) arg;

	             // parcours le tableau pour voir si le client existe ou pas
	             // si l'observation vien du boutton supprimer
	             for (int i = 0; i < table.getRowCount(); i++) {
	                 Object nom_ligne = table.getValueAt(i, 0);
	                 Object prenom_ligne = table.getValueAt(i, 1);
	                 if ( client.nom.equals( ((String)nom_ligne) ) && client.prenom.equals( ((String)prenom_ligne) ) ) {
	                     model.removeRow(i);
	                     return; // si un client a été supprimer ça quitte comme ca il sera pas ajouter juste audessous
	                 }
	             }

	             // sinon si l'observation vien du boutton ajouter, apres avoir parcourru le tableau et
	             // avoir vérifier que le client n'existe pas alors elle l'ajoute
	             // ajouter le client si il existe pas dans le tableau
	             Vector<Object> o = new Vector<Object>();
	             o.add(client.nom);
	             o.add(client.prenom);
	             o.add(client.num);
	             o.add(client.adresse);
	             model.addRow(o);
	         }
	         
		 }
	

}
