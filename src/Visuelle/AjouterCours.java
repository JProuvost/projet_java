/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visuelle;

import data.Classe;
import data.Discipline;
import data.Personne;
import data.Trimestre;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import static visuelle.Fenetre.e;
import static visuelle.Selannee.annee;

/**
 *
 * @author Jean
 */
public class AjouterCours extends javax.swing.JPanel {

    /**
     * Creates new form panelajoutercours
     */
    public AjouterCours(int a) {
        id=a;
        initComponents(a);
    }

    
                          
    private void initComponents(int a) {

        labelprof = new javax.swing.JLabel();
        home = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        valider = new javax.swing.JButton();
        DefaultComboBoxModel b = new DefaultComboBoxModel();
        DefaultComboBoxModel c = new DefaultComboBoxModel();
        fdiscipline = new javax.swing.JComboBox<>(c);
        fclasse = new javax.swing.JComboBox<>(b);
        try{Personne prof = e.seekerPersonne(a);
        labelprof.setText(prof.getprenom()+" "+prof.getnom());
        ArrayList<Classe> classes=new ArrayList<>();
        ArrayList<Trimestre> trimestres=new ArrayList<>();
        
        e.getmine(e.seekerAnnee(annee),trimestres,classes);
        for(Discipline elem: e.getdiscipline()){
            c.addElement(elem.getid());
        }
        for(Classe elem: classes){
            b.addElement(elem.getid());
        }
        }
        
        catch (Exception e){System.out.println("Le professeur n'est pas retrouvé");}
        labelprof.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        home.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        home.setText("Home");
        home.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                homeActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("Discipline :");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("Classe :");

        valider.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        valider.setText("Valider");
        valider.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                validerActionPerformed(evt);
            }
        });

        fdiscipline.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        fdiscipline.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fdisciplineActionPerformed(evt);
            }
        });

        fclasse.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        fclasse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fclasseActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(labelprof, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 125, Short.MAX_VALUE)
                        .addComponent(home, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 107, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(fdiscipline, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(fclasse, 0, 117, Short.MAX_VALUE))))
                .addGap(30, 30, 30))
            .addGroup(layout.createSequentialGroup()
                .addGap(128, 128, 128)
                .addComponent(valider, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(home, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelprof, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fdiscipline, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(45, 45, 45)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(fclasse, javax.swing.GroupLayout.DEFAULT_SIZE, 54, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(valider, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
        );
    }                      

    private void fdisciplineActionPerformed(java.awt.event.ActionEvent evt) {                                            
        // TODO add your handling code here:
        iddiscipline=(int)fdiscipline.getSelectedItem();
    }                                           

    private void fclasseActionPerformed(java.awt.event.ActionEvent evt) {                                        
        // TODO add your handling code here
        idclasse=(int)fclasse.getSelectedItem();
    }                                       

    private void validerActionPerformed(java.awt.event.ActionEvent evt) {                                        
        // TODO add your handling code here:
        iddiscipline=(int)fdiscipline.getSelectedItem();
        idclasse=(int)fclasse.getSelectedItem();
        e.addEnseignement(iddiscipline, idclasse, id);
        Fenetre.changePanel("accueil");
    }                                       

    private void homeActionPerformed(java.awt.event.ActionEvent evt) {                                     
        // TODO add your handling code here:
        Fenetre.changePanel("accueil");
    }                                    


    // Variables declaration - do not modify         
    private int id;
    private int iddiscipline;
    private int idclasse;
    private javax.swing.JComboBox<String> fclasse;
    private javax.swing.JComboBox<String> fdiscipline;
    private javax.swing.JButton home;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel labelprof;
    private javax.swing.JButton valider;
    // End of variables declaration                   
}
