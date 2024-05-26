package Controller;

import Model.Article;
import Model.LigneStock;
import Model.Depot;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

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

            Article article = new Article(nomP, prixP, descriptionP);
            depot.ajouteOuRechargeLigneStock(article, qteP);


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
         
            // Récupère le nom de l'article à supprimer
            String nomProduitASupprimer = tabJTF[0].getText();

            DefaultTableModel model = (DefaultTableModel) tableProduits.getModel();

            // Parcours le JTable à la recherche de la ligne du nom correspondant au nom saisi dans le champs nom
            for (int i = 0; i < model.getRowCount(); i++) {
                Object nom_row = model.getValueAt(i, 0);
                if (nomProduitASupprimer.equals(nom_row)) {
                    // Supprime la ligne correspondante de la JTable et du modèle sous-jacent
                    model.removeRow(i);
                    depot.supprimerLigneStock(depot.rechercherLigneStock(nomProduitASupprimer));
                    break; // Pas besoin de continuer la boucle après avoir trouvé et supprimé l'article
                }
            }

        }
    }
}
