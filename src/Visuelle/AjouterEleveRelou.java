/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visuelle;

import data.Personne;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import static visuelle.Fenetre.content;
import static visuelle.Fenetre.e;

/**
 *
 * @author Jean
 */
public class AjouterEleveRelou extends javax.swing.JPanel {

    /**
     * Creates new form NewJPanel
     */
    public AjouterEleveRelou(int id) {
        this.id=id;
        eleves=e.getEleves();
        initComponents();
    }

                              
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        
        valider = new javax.swing.JButton();
        home = new javax.swing.JButton();
        
        DefaultComboBoxModel b = new DefaultComboBoxModel();
        combobox = new javax.swing.JComboBox<>(b);
        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("ID");
        System.out.println(eleves.size());
        for(Personne elem: eleves)
        {
            b.addElement(elem.getid());
        }
        
        combobox.setModel(b);
        combobox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboboxActionPerformed(evt);
            }
        });

        valider.setText("Valider");
        valider.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                validerActionPerformed(evt);
            }
        });

        home.setText("Home");
        home.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                homeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(102, 102, 102)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(home, javax.swing.GroupLayout.DEFAULT_SIZE, 122, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(valider, javax.swing.GroupLayout.DEFAULT_SIZE, 122, Short.MAX_VALUE)
                        .addComponent(combobox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(55, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(home, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(56, 56, 56)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(combobox)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 47, Short.MAX_VALUE))
                .addGap(53, 53, 53)
                .addComponent(valider, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(42, Short.MAX_VALUE))
        );
    }                      

    private void homeActionPerformed(java.awt.event.ActionEvent evt) {                                     
        // TODO add your handling code here:
        Fenetre.changePanel("accueil");
    }                                    

    private void validerActionPerformed(java.awt.event.ActionEvent evt) {                                        
        // TODO add your handling code here:
        try{idpersonne=(int)combobox.getSelectedItem();
        e.addInscription(id, idpersonne);
        content.add(new VoirLEleve(id),"VoirLEleve");
        Fenetre.changePanel("VoirLEleve");}catch(Exception e){}
    }                                       

    private void comboboxActionPerformed(java.awt.event.ActionEvent evt) {                                         
        // TODO add your handling code here:
        idpersonne=(int)combobox.getSelectedItem();
    }                                        


    // Variables declaration - do not modify   
    private int idpersonne;
    private ArrayList<Personne> eleves;
    private int id;
    private javax.swing.JComboBox<String> combobox;
    private javax.swing.JButton home;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton valider;
    // End of variables declaration                   
}
