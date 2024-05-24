package Controller;

import Model.Article;
import Model.LigneStock;
import Model.Depot;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class GestionProduitsListener implements ActionListener {

    Depot depot;
    JTextField[] tabJTF;
    JTextField descriptionJtf;
    JTable tableProduits;

    public GestionProduitsListener(Depot d, JTextField[] jtf, JTextField jtf2, JTable jt){
    	depot = d;
        tabJTF = jtf;
        descriptionJtf = jtf2;
        tableProduits = jt;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (((JButton) e.getSource()).getText().equals("Ajouter")) {
            // vérifie si un des champs est vide alors n'execute pas le boutton
            if (tabJTF[0].getText().equals("") || tabJTF[1].getText().equals("") || tabJTF[2].getText().equals("")) {
                return;
            }

            // récupération des valeurs dans les JTextField 
            String nomP = tabJTF[0].getText();
            int prixP = Integer.parseInt(tabJTF[1].getText());
            int qteP = Integer.parseInt(tabJTF[2].getText());
            String descriptionP = descriptionJtf.getText();

            // vérifie si le nom du produit existe déja dans notre stock : si OUI on n'éxecute pas le boutton
            for (int i = 0; i < depot.listLigneStock.size(); i++) {
                if (depot.listLigneStock.get(i).article.nom.equals(nomP)) {
                    return;
                }
            }

            // Ajout de la ligneStock dans notre Stock
            depot.ajouteLigneStock(new LigneStock(qteP, depot, new Article(nomP, prixP, descriptionP)));


            // Vider les champs
            for (int i = 0; i < 3; i++) {
                tabJTF[i].setText("");
            }
            descriptionJtf.setText("");
        }
        if (((JButton) e.getSource()).getText().equals("Supprimer")) {
            // ce boutton utilisera uniquement le champs nom du produit, il supprimera le produit dont le nom est introduit

            // vérifie le champs nom si il est vide et si il est vide alors on ne supprime aucun produit
            if (tabJTF[0].getText().equals("")) {
                return;
            }
            // parcours le JTable à la recherche de la ligne du nom correspendant au nom saisit dans le champs nom
            // et on supprime cette ligne
            for (int i = 0; i < tableProduits.getRowCount(); i++) {
                Object nom_row = tableProduits.getValueAt(i, 0);
                if (((String) nom_row).equals(tabJTF[0].getText())) {
                	depot.supprimerLigneStock(depot.rechercherLigneStock( (String) nom_row) );
                }
            }

        }
    }
}
