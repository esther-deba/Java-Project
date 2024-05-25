package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Model.Article;
import Model.Magasin;

public class StatClientListener implements ActionListener {

    Magasin monMagasin;
    JComboBox<String> listeClients;
    JTable tableArticleClient;
    JLabel articlePlusAchete;

    public StatClientListener(Magasin m, JComboBox<String> lc, JTable tac, JLabel apa) {
        monMagasin = m;
        listeClients = lc;
        tableArticleClient = tac;
        articlePlusAchete = apa;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == listeClients) {
            if (listeClients.getSelectedItem().equals("")) {
                articlePlusAchete.setText("");
                DefaultTableModel model = (DefaultTableModel) tableArticleClient.getModel();
                model.setRowCount(0);
                return;
            }
            // Effacer les anciennes données du tableau
            DefaultTableModel model = (DefaultTableModel) tableArticleClient.getModel();
            model.setRowCount(0);

            Vector<Article> listeArticleClient = new Vector<Article>();
            String article = "";
            String nomC = (String) listeClients.getSelectedItem();
            for (int i = 0; i < monMagasin.listClients.size(); i++) {
                if ((monMagasin.listClients.get(i).nom + " " + monMagasin.listClients.get(i).prenom).equals(nomC)) {
                    listeArticleClient = monMagasin.listClients.get(i).listesArticleCommandesClient();
                    if (listeArticleClient.isEmpty()) {
                        articlePlusAchete.setText(""); // Si aucun achat, vider le label
                    } else {
                        article = monMagasin.listClients.get(i).articleLePlusAcheterClient().nom;
                        for (int j = 0; j < listeArticleClient.size(); j++) {
                            Vector<Object> o = new Vector<Object>();
                            o.add(listeArticleClient.get(j).nom);
                            o.add(listeArticleClient.get(j).prix);
                            o.add(monMagasin.listClients.get(i).qteArticleCommandeClient(listeArticleClient.get(j).nom));
                            o.add(listeArticleClient.get(j).description);
                            model.addRow(o);
                        }
                        articlePlusAchete.setText(article);
                    }
                }
            }
        }
    }
}
