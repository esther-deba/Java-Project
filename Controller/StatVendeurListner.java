package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JLabel;

import Model.Magasin;

public class StatVendeurListner implements ActionListener {

    Magasin monMagasin;
    JComboBox listeVendeurs;
    JLabel chiffreAffaire;
    JLabel nombreArtVendue;
    
    public StatVendeurListner(Magasin monMagasin,JComboBox listeVendeurs,JLabel chiffreAffaire,JLabel nombreArtVendue ) {
    	this.monMagasin = monMagasin;
    	this.listeVendeurs = listeVendeurs;
    	this.nombreArtVendue = nombreArtVendue;
    	this.chiffreAffaire = chiffreAffaire;
    	
    	
    }
    
    
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == listeVendeurs) {
            if (listeVendeurs.getSelectedItem() == "") {
                return;
            }
            String chiffreAffair = "";
            String nombreArtVend = "";
            String nomV = (String) listeVendeurs.getSelectedItem();
            for (int i = 0; i < monMagasin.listVendeurs.size(); i++) {
                if ((monMagasin.listVendeurs.get(i).nom + " " + monMagasin.listVendeurs.get(i).prenom).equals(nomV)) {
                    chiffreAffair = Double.toString(monMagasin.listVendeurs.get(i).chiffreAffaireVendeur());
                    nombreArtVend = Integer.toString(monMagasin.listVendeurs.get(i).nbrProduitsVendus());
                }
            }
            chiffreAffaire.setText(chiffreAffair);
            nombreArtVendue.setText(nombreArtVend);
        }
		
	}
   
}
