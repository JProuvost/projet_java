/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visuelle;

import data.AnneeScolaire;
import data.Classe;
import data.Enseignement;
import data.Inscription;
import data.Niveau;
import data.Personne;
import data.Trimestre;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import static visuelle.Fenetre.content;
import static visuelle.Fenetre.e;
import static visuelle.Selannee.annee;
import javax.swing.JScrollPane;
import static visuelle.Fenetre.e;
import static visuelle.Selannee.annee;
/**
 *
 * @author Jean
 */
public class VoirLProf extends javax.swing.JPanel {

    /**
     * Creates new form panelvoirclasse
     */
    public VoirLProf() {
        
        initComponents();
    }
                         
    private void initComponents() {

        home = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        ajouterProfesseur = new javax.swing.JButton();
        DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);
        // The 0 argument is number rows.
        JTable table = new JTable(tableModel);
        JScrollPane scroll= new JScrollPane(table);
                ArrayList<Personne> enseignants=e.getProfs();
                for(Personne prof: enseignants)
                {
                    int id=prof.getid();
                    String nom = prof.getnom();
                    String prenom = prof.getprenom();
                    Object[] data ={id,nom,prenom,"Voir plus","Ajouter Enseignement"};   
                    tableModel.addRow(data);
                }
        Action selectprofesseur = new AbstractAction()
        {
            public void actionPerformed(ActionEvent e)
            {
                int modelRow = Integer.valueOf( e.getActionCommand() );
                content.add(new VoirProf((int) table.getModel().getValueAt(modelRow,0)),"VoirProf");
                Fenetre.changePanel("VoirProf");
            }
        };
 
        ButtonColumn buttonColumn = new ButtonColumn(table, selectprofesseur, 3);
        buttonColumn.setMnemonic(KeyEvent.VK_D);

        Action ajoutenseignement = new AbstractAction()
        {
            public void actionPerformed(ActionEvent e)
            {
                int modelRow = Integer.valueOf( e.getActionCommand() );
                content.add(new AjouterCours((int) table.getModel().getValueAt(modelRow,0)),"AjouterCours");
                Fenetre.changePanel("AjouterCours");
        }
    };
 
        ButtonColumn buttonColumn2 = new ButtonColumn(table,ajoutenseignement , 4);
        buttonColumn2.setMnemonic(KeyEvent.VK_D);
        
        home.setText("Home");
        home.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                homeActionPerformed(evt);
            }
        });
        
        jLabel1.setText("Liste des Professeurs         "+annee);

        ajouterProfesseur.setText("Ajouter Professeur");
        ajouterProfesseur.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ajouterProfesseurActionPerformed(evt);
            }
        });
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(scroll)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ajouterProfesseur, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 61, Short.MAX_VALUE)
                .addComponent(home)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(home)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ajouterProfesseur))
                .addContainerGap()
                .addComponent(scroll)
                .addContainerGap(10, Short.MAX_VALUE))
        );
    }                        

    private void ajouterProfesseurActionPerformed(java.awt.event.ActionEvent evt) {                                              
        // TODO add your handling code here:
        content.add(new AjouterProf(),"AjouterProf");
        Fenetre.changePanel("AjouterProf");
        
    }                                             

    private void homeActionPerformed(java.awt.event.ActionEvent evt) {                                     
        // TODO add your handling code here:
        Fenetre.changePanel("accueil");
    }                                    
    
                     
    
    private javax.swing.JButton ajouterProfesseur;
    private javax.swing.JButton home;
    private javax.swing.JLabel jLabel1;
    private String[] columnNames = {"id","Nom","Prénom","",""};
    // End of variables declaration                   
}
