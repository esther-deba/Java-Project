package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.Vector;

import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;

import Model.Commande;
import Model.LigneCommande;
import Model.LigneStock;
import Model.Magasin;
import View.ConfirmationAchat;

public class GestionVentesListener implements ActionListener {

    Magasin monMagasin;
    JList listeProduits;
    JComboBox listeVendeurs;
    JComboBox listeClients;
    JSpinner maQte;
    JTable tableLignesCommandes;

    public GestionVentesListener(Magasin m, JList jlp, JComboBox jlv, JComboBox jlc, JSpinner js, JTable tableDonnees) {
        monMagasin = m;
        listeProduits = jlp;
        listeVendeurs = jlv;
        listeClients = jlc;
        maQte = js;
        tableLignesCommandes = tableDonnees;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (((JButton) e.getSource()).getText().equals("Ajouter au panier")) {
            // vérifie si un produit et une quantité ont été sélectionnés
            if (listeProduits.getSelectedValue() == null || ((int) maQte.getValue()) <= 0) {
                return;
            }
            String nomP = (String) listeProduits.getSelectedValue();

            if (monMagasin.rechercherLigneStock(nomP).qte <= 0) {
                JOptionPane.showMessageDialog(null, "Désolé, le produit '" + nomP + "' n'est plus disponible en stock.", "Stock épuisé", JOptionPane.ERROR_MESSAGE);
                return;
            }

            int qteP = (int) maQte.getValue();
            LigneStock articleEnStock = monMagasin.rechercherLigneStock(nomP);

            if (articleEnStock.qte < qteP) {
                qteP = articleEnStock.qte;
            }
            articleEnStock.qte -= qteP;

            DefaultTableModel model = (DefaultTableModel) tableLignesCommandes.getModel();
            boolean found = false;

            // Parcourir le tableau pour voir si le produit existe déjà
            for (int i = 0; i < model.getRowCount(); i++) {
                String nomProduitTableau = (String) model.getValueAt(i, 0);
                if (nomProduitTableau.equals(nomP)) {
                    // Produit trouvé, mettre à jour la quantité et le prix total
                    int nouvelleQte = (int) model.getValueAt(i, 1) + qteP;
                    model.setValueAt(nouvelleQte, i, 1);
                    model.setValueAt(articleEnStock.article.prix * nouvelleQte, i, 3);
                    found = true;
                    break;
                }
            }

            // Si le produit n'a pas été trouvé dans le tableau, ajouter une nouvelle ligne
            if (!found) {
                Vector<Object> o = new Vector<Object>();
                o.add(nomP);
                o.add(qteP);
                o.add(articleEnStock.article.prix);
                o.add(articleEnStock.article.prix * qteP);
                model.addRow(o);
            }
            
            // Réinitialiser le JSpinner à 0 après l'ajout au panier
            maQte.setValue(0);
        }

        if (((JButton) e.getSource()).getText().equals("Supprimer du panier")) {
            // vérifie si un produit et une quantité à supprimer ont été sélectionnés
            if (listeProduits.getSelectedValue() == null || ((int) maQte.getValue()) <= 0) {
                return;
            }
            String nomPSupp = (String) listeProduits.getSelectedValue();
            int qtePSupp = (int) maQte.getValue();
            LigneStock articleEnStock = monMagasin.rechercherLigneStock(nomPSupp);

            // parcourir le tableau et modifier les valeurs
            for (int i = 0; i < tableLignesCommandes.getRowCount(); i++) {
                Object nom_row = tableLignesCommandes.getValueAt(i, 0);
                Object qte_row = tableLignesCommandes.getValueAt(i, 1);
                if (nomPSupp.equals(nom_row)) {
                    DefaultTableModel model = (DefaultTableModel) tableLignesCommandes.getModel();
                    if (qtePSupp >= (int) qte_row) {
                        model.removeRow(i);
                        i--;
                        qtePSupp -= (int) qte_row;
                        articleEnStock.qte += (int) qte_row;
                    } else {
                        tableLignesCommandes.setValueAt(((int) qte_row - qtePSupp), i, 1);
                        tableLignesCommandes.setValueAt((double) (((int) tableLignesCommandes.getValueAt(i, 1)) * (double) tableLignesCommandes.getValueAt(i, 2)), i, 3);
                        articleEnStock.qte += qtePSupp;
                    }
                }
            }
        }

        if (((JButton) e.getSource()).getText().equals("Valider le panier")) {
            if (listeVendeurs.getSelectedItem() == "" || listeClients.getSelectedItem() == "" || tableLignesCommandes.getRowCount() == 0) {
                JOptionPane.showMessageDialog(null, "Veuillez ajouter des produits au panier avant de valider. \nVérifiez que vous avez bien sélectionner le vendeur et le client", "Erreur", JOptionPane.ERROR_MESSAGE);
                return;
            }

            String nomVendeur = (String) listeVendeurs.getSelectedItem();
            String nomClient = (String) listeClients.getSelectedItem();
            Commande commande = new Commande(LocalDate.now(), monMagasin.rechercherVendeur(nomVendeur), monMagasin.rechercherClient(nomClient));

            for (int i = 0; i < tableLignesCommandes.getRowCount(); i++) {
                if ((int) tableLignesCommandes.getValueAt(i, 1) > 0) {
                    commande.ajouteLigneCommande(new LigneCommande((int) tableLignesCommandes.getValueAt(i, 1), commande, monMagasin.rechercherLigneStock((String) tableLignesCommandes.getValueAt(i, 0)).article));
                }
            }
            ConfirmationAchat confirmationAchat = new ConfirmationAchat(monMagasin, commande);
            confirmationAchat.setVisible(true);

            // Vider le tableau après validation du panier
            DefaultTableModel model = (DefaultTableModel) tableLignesCommandes.getModel();
            model.setRowCount(0);
        }
    }
}
