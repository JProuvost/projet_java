/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vue;

import data.AnneeScolaire;
import data.Bulletin;
import data.Classe;
import data.Enseignement;
import data.Inscription;
import data.Niveau;
import data.DetailBulletin;
import data.Discipline;
import data.Evaluation;
import data.Personne;
import data.Trimestre;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import static vue.Fenetre.content;
import static vue.Fenetre.ecole;
import static vue.Selannee.annee;
import javax.swing.JScrollPane;
/**
 *
 * @author Jean
 */
public class VoirDetail extends javax.swing.JPanel {

    public VoirDetail(int a) {
        id=a;
        initComponents(a);
    }
                         
    private void initComponents(int a) {
        
        home = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        ajouterNote = new javax.swing.JButton();
        DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);
        // The 0 argument is number rows.
        JTable table = new JTable(tableModel);
        JScrollPane scroll= new JScrollPane(table);
        try{
            DetailBulletin detail=ecole.seekerDetail(a);
            Personne etudiant=ecole.seekerPersonne(ecole.seekerInscription(ecole.seekerBulletin(detail.getidBulletin()).getidInscription()).getidPersonne());
            Discipline discipline=ecole.seekerDiscipline(ecole.seekerEnseignement(detail.getidEnseignement()).getidDiscipline());
            Trimestre trimestre=ecole.seekerTrimestre(ecole.seekerBulletin(detail.getidBulletin()).getidTrimestre());
            String info;
            info=etudiant.getnom()+"   "+etudiant.getprenom()+"    "+annee+"    T"+trimestre.getnumero()+"     "+discipline.getnom();
            jLabel1.setText(info);
            ArrayList<Evaluation> notes = null;
            ecole.getmine(detail, notes);
            for(Evaluation elem: notes)
            {
                double note=elem.getnote();
                String appreciation=elem.getappreciation();
                Object[] data={note,appreciation};
                tableModel.addRow(data);
            }
        }catch(Exception e){System.out.println("Erreur lors de la récupération de la discipline");}
        
        
        home.setText("Home");
        home.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                homeActionPerformed(evt);
            }
        });
        
        ajouterNote.setText("Ajouter une Note");
        ajouterNote.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ajouterNoteActionPerformed(evt);
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
                .addComponent(ajouterNote, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                    .addComponent(ajouterNote))
                .addContainerGap()
                .addComponent(scroll)
                .addContainerGap(10, Short.MAX_VALUE))
        );
    }                                                                
    
    private void ajouterNoteActionPerformed(java.awt.event.ActionEvent evt) {                                              
        // TODO add your handling code here:
        content.add(new AjouterNote(id),"AjouterNote");
        Fenetre.changePanel("ajouterNote");
    }
    
    private void homeActionPerformed(java.awt.event.ActionEvent evt) {                                     
        // TODO add your handling code here:
        Fenetre.changePanel("accueil");
    }                                    
    private int id;
    private javax.swing.JButton ajouterNote;                 
    private javax.swing.JButton home;
    private javax.swing.JLabel jLabel1;
    private String[] columnNames = {"Note","Appréciation"};
    // End of variables declaration                   
}
