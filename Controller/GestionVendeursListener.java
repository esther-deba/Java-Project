package Controller;

import Model.Magasin;
import Model.Vendeur;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GestionVendeursListener implements ActionListener {
    Magasin monMagasin;
    JTextField[] tabTF;
    JTextField textTF;
    JTable tableVendeurs;

    public GestionVendeursListener(Magasin m, JTextField[] tab_tf, JTextField adr_text, JTable tab_donnees) {
        monMagasin = m;
        tabTF = tab_tf;
        textTF = adr_text;
        tableVendeurs = tab_donnees;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    	//on ajuste le nom et le prenom pour unifier l'ecriture à l'interieur du tableau et faciliter ainsi la suppression 
    	// par exemple toto c'est pareil que Toto ainsi que TOTO chez l'humain
        String nomVendeur = tabTF[0].getText().toUpperCase().trim();
        String prenomVendeur = tabTF[1].getText().toLowerCase().trim();
        String telVendeur = tabTF[2].getText();
        String adresseVendeur = textTF.getText();

        if (((JButton) e.getSource()).getText().equals("Ajouter")) {
            // vérifie si un des 4 champs est vide
            if (nomVendeur.equals("") || prenomVendeur.equals("") || telVendeur.equals("") || adresseVendeur.equals("")) {
                return;
            }
            // recupérer et creer un nouveau vendeur depuis les champs saisis
            Vendeur vendeur = new Vendeur(nomVendeur,prenomVendeur,telVendeur, adresseVendeur, monMagasin);

            //vérifie si le vendeur existe déja dans notre magasin
            for (int i = 0; i < monMagasin.listVendeurs.size(); i++) {
                if (monMagasin.listVendeurs.get(i).nom.equals(nomVendeur) && monMagasin.listVendeurs.get(i).prenom.equals(prenomVendeur)) {
                    return;
                }
            }

            // Ajouter et afficher le vendeur
            monMagasin.ajouteVendeur(vendeur);

            // Vider les champs
            for (int i = 0; i < 3; i++) {
                tabTF[i].setText("");
            }
            textTF.setText("");

        }
        if (((JButton) e.getSource()).getText().equals("Supprimer")) {
            //Vérifie le champs nom et prenom pour supprimer
            if( nomVendeur.equals("") || prenomVendeur.equals("") ) { return ; }

            // recherche et suppression du vendeur dont le nom et prenom ont été saisi
            for (int i = 0; i < tableVendeurs.getRowCount(); i++) {
                Object nom_row = tableVendeurs.getValueAt(i, 0);
                Object prenom_row = tableVendeurs.getValueAt(i, 1);
                
        
                if ( nomVendeur.equals( ((String)nom_row) ) && prenomVendeur.equals( ((String)prenom_row) ) ) {
                    monMagasin.supprimerVendeur( monMagasin.rechercherVendeur( nomVendeur , prenomVendeur));
                }
            }

        }
    }
}