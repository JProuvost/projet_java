/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visuelle;

import static visuelle.Fenetre.content;

/**
 *
 * @author Jean
 */
public class Page extends javax.swing.JPanel {

    /**
     * Creates new form NewJPanel
     */
    public Page() {
        initComponents();
    }

                            
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        bannee = new javax.swing.JButton();
        boutonprofesseur = new javax.swing.JButton();
        boutontruc = new javax.swing.JButton();
        boutontrimestre = new javax.swing.JButton();
        boutonclasse = new javax.swing.JButton();
        reporting = new javax.swing.JButton();

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Ecole X");

        bannee.setText("Année");
        bannee.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                banneeActionPerformed(evt);
            }
        });

        boutonprofesseur.setText("Voir Professeurs");
        boutonprofesseur.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boutonprofesseurActionPerformed(evt);
            }
        });


        boutontruc.setText("Ajouter Niveau/Discipline");
        boutontruc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boutontrucActionPerformed(evt);
            }
        });

        boutontrimestre.setText("Modifier Trimestre");
        boutontrimestre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boutontrimestreActionPerformed(evt);
            }
        });

        boutonclasse.setText("Voir Classes");
        boutonclasse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boutonclasseActionPerformed(evt);
            }
        });

        reporting.setText("Reporting");
        reporting.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reportingActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(boutontruc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(boutonprofesseur, javax.swing.GroupLayout.DEFAULT_SIZE, 141, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 264, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(boutontrimestre, javax.swing.GroupLayout.DEFAULT_SIZE, 203, Short.MAX_VALUE)
                        .addComponent(boutonclasse, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(reporting, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(bannee, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(78, 78, 78))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bannee, javax.swing.GroupLayout.DEFAULT_SIZE, 69, Short.MAX_VALUE))
                .addGap(56, 56, 56)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(boutontrimestre, javax.swing.GroupLayout.DEFAULT_SIZE, 72, Short.MAX_VALUE)
                    .addComponent(boutonprofesseur, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(boutonclasse, javax.swing.GroupLayout.DEFAULT_SIZE, 71, Short.MAX_VALUE)
                    )
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(boutontruc, javax.swing.GroupLayout.DEFAULT_SIZE, 77, Short.MAX_VALUE)
                    .addComponent(reporting, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(39, Short.MAX_VALUE))
        );
    }                       

private void boutonclasseActionPerformed(java.awt.event.ActionEvent evt) {                                             
        // TODO add your handling code here:
        content.add(new VoirClasse(),"voirClasse");
        Fenetre.changePanel("voirClasse");
    }                                            

    private void banneeActionPerformed(java.awt.event.ActionEvent evt) {                                       
        // TODO add your handling code here:
        content.add(new Selannee(), "selannee");
        Fenetre.changePanel("selannee");
    }                                      

    private void boutonprofesseurActionPerformed(java.awt.event.ActionEvent evt) {                                                 
        // TODO add your handling code here:
        content.add(new VoirLProf(),"accueilProf");
        Fenetre.changePanel("accueilProf");
    }                                                

    private void boutontrimestreActionPerformed(java.awt.event.ActionEvent evt) {                                                
        // TODO add your handling code here:
        content.add(new ModifierTrimestre(),"ModifierTrimestre");
        Fenetre.changePanel("ModifierTrimestre");
    }                                                                                        

    private void boutontrucActionPerformed(java.awt.event.ActionEvent evt) {                                           
        // TODO add your handling code here:
        content.add(new AjouterTruc(),"AjouterTruc");
        Fenetre.changePanel("AjouterTruc");
    }
    private void reportingActionPerformed(java.awt.event.ActionEvent evt) {                                          
        // TODO add your handling code here:
        content.add(new Reporting(),"Reporting");
        Fenetre.changePanel("Reporting");
    }                                         
                                  


    // Variables declaration - do not modify  
    private javax.swing.JButton bannee;
    private javax.swing.JButton boutonclasse;
    private javax.swing.JButton boutonprofesseur;
    private javax.swing.JButton boutontrimestre;
    private javax.swing.JButton boutontruc;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton reporting;
    // End of variables declaration                   
}
