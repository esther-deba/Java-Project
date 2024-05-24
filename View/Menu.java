package View;

import java.awt.*;

import javax.swing.*;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;

import Controller.MenuListener;
import Model.Magasin;

public class Menu extends JFrame{
	
	JLabel titre = new JLabel("Bienvenu chez ITools");
	JButton produits = new JButton("Gestion Produits");
    JButton clients = new JButton("Gestion Clients");
	JButton vendeurs = new JButton("Gestion Vendeurs");
	JButton ventes = new JButton("Gestion Ventes");
	JButton statC = new JButton("Statistiques clients");
	JButton statV = new JButton("Statistiques vendeurs");
	JButton statG = new JButton("Statistiques Générales");
	
	JPanel gridContainer = new JPanel();
	Magasin monMagasin;
	
	public Menu(Magasin m) {
	
		monMagasin = m;
		this.setTitle("Le menu de "+m.nom);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setPreferredSize(new Dimension(600,600));
		this.setResizable(false);
        
		
		titre.setHorizontalAlignment(SwingConstants.CENTER);
		titre.setPreferredSize(new Dimension(150,50));
		
		getContentPane().setLayout(new BorderLayout(10,25));
		getContentPane().add(titre, BorderLayout.NORTH);
		
		
		JLabel vide1 = new JLabel(" ");
		JLabel vide2 = new JLabel(" ");
		JLabel vide3 = new JLabel(" ");
		vide1.setPreferredSize(new Dimension(100,100));
		vide2.setPreferredSize(new Dimension(100,100));
		vide3.setPreferredSize(new Dimension(25,25));
		getContentPane().add(vide1, BorderLayout.EAST);
		getContentPane().add(vide2, BorderLayout.WEST);
		getContentPane().add(vide3, BorderLayout.SOUTH);
		

		
		gridContainer.setLayout(new GridLayout(7,1,50,25));
		gridContainer.add(produits);
		gridContainer.add(ventes);
		gridContainer.add(clients);
		gridContainer.add(vendeurs);
		gridContainer.add(statC);
		gridContainer.add(statV);
		gridContainer.add(statG);
		
		
		getContentPane().add(gridContainer, BorderLayout.CENTER);
		
		
		MenuListener m_listener = new MenuListener(monMagasin);
		produits.addActionListener(m_listener);
        clients.addActionListener(m_listener);
        vendeurs.addActionListener(m_listener);
        ventes.addActionListener(m_listener);
		
		this.setVisible(true);
		 this.pack();
	}
}
