package View;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.Vector;

import javax.swing.*;

import Model.Magasin;

public class StatVendeur extends JFrame {
	Magasin magasin;
	
	JLabel titreVendeur= new JLabel("Statistiques des vendeurs");
	JComboBox<String> listVendeurs ;
	JLabel chiffreAffaireVendeur = new JLabel("Chiffre d'affaires:");
    JLabel chiffre = new JLabel();
    JLabel nombreArticleVendue = new JLabel("Nombre articles vendus:");
    JLabel nombre = new JLabel();
    JPanel vendeursCenter = new JPanel();

	public StatVendeur(Magasin m) {
		magasin = m;
		 this.setTitle("Statistiques des Vendeurs");
	     this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	     getContentPane().add(vendeursCenter);
	     
		vendeursCenter.setLayout(new GridBagLayout());
        vendeursCenter.setPreferredSize(new Dimension(500,300));
   
        
      
        GridBagConstraints constraints2 = new GridBagConstraints();
        constraints2.gridx = 0;
        constraints2.gridy = 0;
        constraints2.weightx=0.9;
        constraints2.weighty=0.9;
        constraints2.gridwidth = 2;
        constraints2.insets=new Insets(10,10,0,0);
        vendeursCenter.add(titreVendeur,constraints2);

        constraints2.gridx = 0;
        constraints2.gridy = 1;
        constraints2.weightx= 0.9;
        constraints2.weighty= 0.9;
        constraints2.gridwidth = 2;
        constraints2.anchor=GridBagConstraints.PAGE_START;
        constraints2.insets=new Insets(10,10,0,0);
        
        Vector<String> nomVendeurs = new Vector<String>();
        nomVendeurs.add("");
        for (int i =0;i<magasin.listVendeurs.size();i++){
            nomVendeurs.add(magasin.listVendeurs.get(i).nom +" "+magasin.listVendeurs.get(i).prenom);
        }
        listVendeurs = new JComboBox<>(nomVendeurs);
        vendeursCenter.add(listVendeurs,constraints2);
        listVendeurs.setPreferredSize(new Dimension(150,30));

        constraints2.gridx = 0;
        constraints2.gridy = 2;
        constraints2.weightx= 0.9;
        constraints2.weighty= 0.9;
        constraints2.gridwidth = 1;
        constraints2.anchor=GridBagConstraints.PAGE_START;
        constraints2.insets=new Insets(10,60,0,0);
        vendeursCenter.add(chiffreAffaireVendeur,constraints2);

        constraints2.gridx = 1;
        constraints2.gridy = 2;
        constraints2.weightx= 0.9;
        constraints2.weighty= 0.9;
        constraints2.gridwidth = 1;
        constraints2.anchor=GridBagConstraints.FIRST_LINE_START;
        vendeursCenter.add(chiffre,constraints2);

        constraints2.gridx = 0;
        constraints2.gridy = 3;
        constraints2.weightx= 0.9;
        constraints2.weighty= 0.9;
        constraints2.gridwidth = 1;
        constraints2.anchor=GridBagConstraints.PAGE_START;
        constraints2.insets=new Insets(10,60,0,0);
        vendeursCenter.add(nombreArticleVendue,constraints2);


        constraints2.gridx = 1;
        constraints2.gridy = 3;
        constraints2.weightx= 0.9;
        constraints2.weighty= 0.9;
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.insets=new Insets(10,30,0,0);
        constraints2.anchor = GridBagConstraints.FIRST_LINE_START;
        vendeursCenter.add(nombre,constraints2);



		this.setVisible(false);
        this.pack();
	}

} 


