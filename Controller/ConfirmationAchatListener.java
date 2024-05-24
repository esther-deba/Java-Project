package Controller;

import Model.Commande;
import Model.Magasin;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ConfirmationAchatListener implements ActionListener {
    Magasin monMagasin;
    Commande commande;
    JFrame frame;
    Container container;

    public ConfirmationAchatListener(Magasin m, Commande c, Container co, JFrame f){
        monMagasin = m;
        commande = c;
        container = co;
        frame = f;
    }

    @Override
    public void actionPerformed(ActionEvent e){
        if (((JButton)e.getSource()).getText().equals("Confirmer")){
            monMagasin.rechercherClient(commande.client.nom).ajouteCommande(commande);
            monMagasin.rechercherVendeur(commande.vendeur.nom).ajouteCommande(commande);
            container.removeAll();
            container.revalidate();
            container.repaint();

            container.setLayout( new FlowLayout());
            container.add( new JLabel("Commande bien effectué !"));
            container.add(new JLabel("Vous pouvez passer en magasin la récuperer") );
            
        }
        if (((JButton)e.getSource()).getText().equals("Annuler")){
            frame.dispose();
        }
    }

}
