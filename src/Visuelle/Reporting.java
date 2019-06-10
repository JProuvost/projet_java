/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visuelle;

import Stat.*;
import static visuelle.Fenetre.e;

/**
 *
 * @author Mikhali
 */
public class Reporting extends javax.swing.JPanel {

    /**
     * Creates new form Reporting
     */
    public Reporting() {
        initComponents();
    }
    
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextArea3 = new javax.swing.JTextArea();
        fIdNiveau = new javax.swing.JTextField();
        fAnneeMoy = new javax.swing.JTextField();
        Moy = new javax.swing.JButton();
        AnneeRatio = new javax.swing.JTextField();
        Ratio = new javax.swing.JButton();
        Evol = new javax.swing.JButton();
        home = new javax.swing.JButton();

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jTextArea1.setText("Moyenne classe :");
        jScrollPane1.setViewportView(jTextArea1);

        jScrollPane2.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane2.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        jTextArea2.setColumns(20);
        jTextArea2.setRows(5);
        jTextArea2.setText("Ratio Professeur :");
        jScrollPane2.setViewportView(jTextArea2);

        jScrollPane3.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane3.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        jTextArea3.setColumns(20);
        jTextArea3.setRows(5);
        jTextArea3.setText("Evolution du nombre d'eleve :");
        jScrollPane3.setViewportView(jTextArea3);

        fIdNiveau.setText("idNiveau");
        fIdNiveau.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fIdNiveauActionPerformed(evt);
            }
        });

        fAnneeMoy.setText("Annee");
        fAnneeMoy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fAnneeMoyActionPerformed(evt);
            }
        });

        Moy.setText("Voir");
        Moy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MoyActionPerformed(evt);
            }
        });

        AnneeRatio.setText("Annee");
        AnneeRatio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AnneeRatioActionPerformed(evt);
            }
        });

        Ratio.setText("Voir");
        Ratio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RatioActionPerformed(evt);
            }
        });
        
        home.setText("Home");
        home.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                homeActionPerformed(evt);
            }
        });
        
        Evol.setText("Voir");
        Evol.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EvolActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jScrollPane1)
                            .addComponent(jScrollPane2))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(AnneeRatio)
                            .addComponent(fIdNiveau, javax.swing.GroupLayout.DEFAULT_SIZE, 55, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(fAnneeMoy, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 57, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(Moy, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Ratio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Evol)
                        .addComponent(home)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(Moy, javax.swing.GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE)
                    .addComponent(fAnneeMoy)
                    .addComponent(fIdNiveau)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(49, 49, 49)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(AnneeRatio)
                    .addComponent(Ratio, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(Evol, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE))
                .addGap(56, 56, 56)
                .addComponent(home))
        );
    }             

    private void fIdNiveauActionPerformed(java.awt.event.ActionEvent evt) {                                          
        // TODO add your handling code here:
        try{niveau = Integer.parseInt(fIdNiveau.getText());}
        catch(Exception e){
            niveau=0;
            System.out.println("niveau mis valeur par defaut car le champ est incorrectement entré");
        }
    }
    
    private void fAnneeMoyActionPerformed(java.awt.event.ActionEvent evt) {                                          
        // TODO add your handling code here:
        try{anneemoy = Integer.parseInt(fAnneeMoy.getText());}
        catch(Exception e){
            anneemoy=0;
            System.out.println("annee mis valeur par defaut car le champ est incorrectement entré");
        }
    }
    
    private void AnneeRatioActionPerformed(java.awt.event.ActionEvent evt) {                                           
        // TODO add your handling code here:
        try{anneeratio = Integer.parseInt(AnneeRatio.getText());}
        catch(Exception e){
            anneeratio=0;
            System.out.println("annee mis valeur par defaut car le champ est incorrectement entré");
        }
    }                                          

    private void RatioActionPerformed(java.awt.event.ActionEvent evt) {                                      
        // TODO add your handling code here:
        try{anneeratio = Integer.parseInt(AnneeRatio.getText());}
        catch(Exception e){
            anneeratio=0;
            System.out.println("annee mis valeur par defaut car le champ est incorrectement entré");
        }
        Profratio pr = new Profratio(e,anneeratio);
        pr.fedetruc();
        
    }                                     

    private void MoyActionPerformed(java.awt.event.ActionEvent evt) {                                    
        // TODO add your handling code here:
        
        try{niveau = Integer.parseInt(fIdNiveau.getText());}
        catch(Exception e){
            niveau=0;
            System.out.println("niveau mis valeur par defaut car le champ est incorrectement entré");
        }
        try{anneemoy = Integer.parseInt(fAnneeMoy.getText());}
        catch(Exception e){
            anneemoy=0;
            System.out.println("annee mis valeur par defaut car le champ est incorrectement entré");
        }
        ClasseMoyenne cm = new ClasseMoyenne(e,anneemoy,niveau);
        cm.fedetruc();
    }                                   
    
    private void homeActionPerformed(java.awt.event.ActionEvent evt) {                                     
        // TODO add your handling code here:
        Fenetre.changePanel("accueil");
    }     
    
    private void EvolActionPerformed(java.awt.event.ActionEvent evt) {                                     
        // TODO add your handling code here:
        evEleve eve = new evEleve(e);
        eve.fedetruc();
    } 
    // Variables declaration - do not modify                     
    private javax.swing.JTextField AnneeRatio;
    private javax.swing.JButton home;
    private javax.swing.JButton Evol;
    private javax.swing.JButton Moy;
    private javax.swing.JButton Ratio;
    private javax.swing.JTextField fAnneeMoy;
    private javax.swing.JTextField fIdNiveau;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextArea jTextArea2;
    private javax.swing.JTextArea jTextArea3;
    private int niveau;
    private int anneemoy;
    private int anneeratio;
    // End of variables declaration                   
}
