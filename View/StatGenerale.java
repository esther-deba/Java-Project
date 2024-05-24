package View;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import Model.Magasin;

public class StatGenerale extends JFrame{
	Magasin magasin;
	JLabel titreGen = new JLabel("Statistiques générales");
    JLabel article = new JLabel("Quantité d'articles vendus :");
    JLabel chifreAffairGeneral = new JLabel("Chiffre d'affaire :");
    JLabel artPlusVendu = new JLabel("L'article le plus vendu :");
    JLabel nbTArticle = new JLabel();
    JLabel nbChiffreAffair = new JLabel();
    JLabel nomArticlePlusVendus = new JLabel();
    
    JPanel generalPanel = new JPanel();
    
    public StatGenerale(Magasin m){
    	magasin = m;
    	
    	this.setTitle("Statistiques générales");
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setPreferredSize(new Dimension(500,350));
        this.setResizable(false);
        getContentPane().setLayout(new BorderLayout());
        titreGen.setHorizontalAlignment(SwingConstants.CENTER);
        titreGen.setPreferredSize(new Dimension(60,70));
        
        getContentPane().add(titreGen,BorderLayout.NORTH);
        
    	generalPanel.setLayout(new GridLayout(3,2,3,2));
        
        
        
       
        generalPanel.add(article);
        generalPanel.add(nbTArticle);
        generalPanel.add(chifreAffairGeneral);
        generalPanel.add(nbChiffreAffair);
        generalPanel.add(artPlusVendu);
        generalPanel.add(nomArticlePlusVendus);
        
        getContentPane().add(generalPanel,BorderLayout.CENTER);
        
        JLabel vide1 = new JLabel(" ");
		JLabel vide2 = new JLabel(" ");
		vide1.setPreferredSize(new Dimension(25,25));
		vide2.setPreferredSize(new Dimension(50,50));
		getContentPane().add(vide1, BorderLayout.EAST);
		getContentPane().add(vide2, BorderLayout.WEST);
		
        this.pack();
        
    	
    }

	
}
