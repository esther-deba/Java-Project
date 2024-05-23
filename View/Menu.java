package View;

import java.awt.*;

import javax.swing.*;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;

import Model.Magasin;

public class Menu extends JFrame{
	
	JLabel titre = new JLabel("Bienvenu chez ITools");
	JButton produits = new JButton("Gestion Produits");
    JButton clients = new JButton("Gestion Clients");
	JButton vendeurs = new JButton("Gestion Vendeurs");
	JButton ventes = new JButton("Gestion Ventes");
	JButton stat = new JButton("Statistiques");
	JPanel borderContainer = new JPanel();
	JPanel gridContainer = new JPanel();
	Magasin monMagasin;
	
	public Menu(Magasin m) {
	
		monMagasin = m;
		this.setTitle("Le menu de "+m.nom);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setPreferredSize(new Dimension(600,450));
		this.setResizable(false);
        
		
		titre.setHorizontalAlignment(SwingConstants.CENTER);
		titre.setPreferredSize(new Dimension(150,50));
		
		getContentPane().add(borderContainer);		
		borderContainer.setLayout(new BorderLayout(10,25));
		borderContainer.add(titre, BorderLayout.NORTH);
		stat.setPreferredSize(new Dimension(150,50));
		borderContainer.add(stat, BorderLayout.SOUTH);
		
		JLabel vide1 = new JLabel(" ");
		JLabel vide2 = new JLabel(" ");
		vide1.setPreferredSize(new Dimension(50,50));
		vide2.setPreferredSize(new Dimension(50,50));
		borderContainer.add(vide1, BorderLayout.EAST);
		borderContainer.add(vide2, BorderLayout.WEST);

		
		gridContainer.setLayout(new GridLayout(2,2,50,25));
		gridContainer.add(produits);
		gridContainer.add(ventes);
		gridContainer.add(clients);
		gridContainer.add(vendeurs);
		
		
		borderContainer.add(gridContainer, BorderLayout.CENTER);
		
		this.setVisible(true);
		 this.pack();
	}
}
