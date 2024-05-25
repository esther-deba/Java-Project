package View;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.Vector;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Controller.StatVendeurListener;
import Model.Magasin;

public class StatVendeur extends JFrame {
    Magasin magasin;

    JLabel titreVendeur = new JLabel("Statistiques des vendeurs");
    JComboBox<String> listVendeurs;
    JLabel chiffreAffaireVendeur = new JLabel("Chiffre d'affaires:");
    JLabel chiffre = new JLabel();
    JLabel nombreArticleVendue = new JLabel("Nombre articles vendus:");
    JLabel nombre = new JLabel();
    JPanel vendeursCenter = new JPanel();

    public StatVendeur(Magasin m) {
        magasin = m;
        this.setTitle("Statistiques des Vendeurs");
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setPreferredSize(new Dimension(500, 400));
        this.setSize(500,400);
		this.setLocationRelativeTo(null);
        this.setResizable(false);
        vendeursCenter.setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();

        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.weightx = 0.9;
        constraints.weighty = 0.9;
        constraints.gridwidth = 2;
        constraints.insets = new Insets(10, 10, 0, 0);
        vendeursCenter.add(titreVendeur, constraints);

        constraints.gridx = 0;
        constraints.gridy = 1;
        constraints.weightx = 0.9;
        constraints.weighty = 0.9;
        constraints.gridwidth = 2;
        constraints.anchor = GridBagConstraints.PAGE_START;
        constraints.insets = new Insets(10, 10, 0, 0);

        Vector<String> nomVendeurs = new Vector<String>();
        nomVendeurs.add("");
        for (int i = 0; i < magasin.listVendeurs.size(); i++) {
            nomVendeurs.add(magasin.listVendeurs.get(i).nom + " " + magasin.listVendeurs.get(i).prenom);
        }
        listVendeurs = new JComboBox<>(nomVendeurs);
        listVendeurs.setPreferredSize(new Dimension(150, 30));
        vendeursCenter.add(listVendeurs, constraints);

        constraints.gridx = 0;
        constraints.gridy = 2;
        constraints.weightx = 0.9;
        constraints.weighty = 0.9;
        constraints.gridwidth = 1;
        constraints.anchor = GridBagConstraints.PAGE_START;
        constraints.insets = new Insets(10, 60, 0, 0);
        vendeursCenter.add(chiffreAffaireVendeur, constraints);

        constraints.gridx = 1;
        constraints.gridy = 2;
        constraints.weightx = 0.9;
        constraints.weighty = 0.9;
        constraints.gridwidth = 1;
        constraints.anchor = GridBagConstraints.FIRST_LINE_START;
        constraints.insets = new Insets(10, 30, 0, 0);
        vendeursCenter.add(chiffre, constraints);

        constraints.gridx = 0;
        constraints.gridy = 3;
        constraints.weightx = 0.9;
        constraints.weighty = 0.9;
        constraints.gridwidth = 1;
        constraints.anchor = GridBagConstraints.PAGE_START;
        constraints.insets = new Insets(10, 60, 0, 0);
        vendeursCenter.add(nombreArticleVendue, constraints);

        constraints.gridx = 1;
        constraints.gridy = 3;
        constraints.weightx = 0.9;
        constraints.weighty = 0.9;
        constraints.gridwidth = 1;
        constraints.anchor = GridBagConstraints.FIRST_LINE_START;
        constraints.insets = new Insets(10, 30, 0, 0);
        vendeursCenter.add(nombre, constraints);

        StatVendeurListener statV = new StatVendeurListener(magasin, listVendeurs, chiffre, nombre);
        listVendeurs.addActionListener(statV);

        getContentPane().add(vendeursCenter);

        this.pack();
        this.setVisible(true);
    }
}
