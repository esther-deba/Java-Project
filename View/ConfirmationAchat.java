package View;

import java.awt.*;

import javax.swing.*;

import Model.Commande;
import Model.Magasin;

public class ConfirmationAchat extends JFrame {
	JLabel qst = new JLabel("Voulez vous confirmer votre commande ?");
	 JLabel txt;
	    JPanel affichage = new JPanel();
	    JButton bConfirmer = new JButton("Confirmer");
	    JButton bAnnuler = new JButton("Annuler");
	    JPanel bouttons = new JPanel();
	    Commande commande;
	    Magasin magasin;
	    public ConfirmationAchat(Magasin m,Commande c){
	        this.setTitle("CONFIRMATION");
	        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	        this.setPreferredSize(new Dimension(300,150));
	        this.setResizable(false);

	        commande = c;
	        magasin = m;
	        
	        qst.setHorizontalAlignment(SwingConstants.CENTER);
	        txt = new JLabel("Mr."+commande.client.nom+", Cela vous coûtera : "+commande.getPrice());
	        txt.setHorizontalAlignment(SwingConstants.CENTER);
	        getContentPane().setLayout( new BorderLayout());
	        affichage.setLayout(new FlowLayout());
	        affichage.add(qst);
	        affichage.add(txt);
	        getContentPane().add(affichage,BorderLayout.CENTER);
	        bouttons.setLayout(new FlowLayout());
	       
	      
	        getContentPane().add(bouttons,BorderLayout.SOUTH);
	        
	        
	        
	        this.pack();
	        this.setVisible(true);
	        
}}
