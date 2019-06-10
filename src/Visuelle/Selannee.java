/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visuelle;
import static visuelle.Fenetre.content;
import static visuelle.Fenetre.e;
/**
 *
 * @author Jean
 */
public class Selannee extends javax.swing.JPanel {

    /**
     * Creates new form panel_selannee
     */
    public Selannee() {
        initComponents();
    }
                          
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        f_annee = new javax.swing.JLabel();
        f_annee_n = new javax.swing.JTextField();
        valider = new javax.swing.JButton();
        ajouterannee = new javax.swing.JButton();

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Actuelle :");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("Nouvelle :");
        
        f_annee.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        f_annee.setText(Integer.toString(annee));

        f_annee_n.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                f_annee_nActionPerformed(evt);
            }
        });

        valider.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        valider.setText("Valider");
        valider.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                validerActionPerformed(evt);
            }
        });
        
        ajouterannee.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        ajouterannee.setText("Ajouter année");
        ajouterannee.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ajouterannneeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(ajouterannee)
                .addGap(106, 106, 106)
                .addComponent(valider)
                .addGap(0, 159, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 95, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(f_annee_n)
                    .addComponent(f_annee, javax.swing.GroupLayout.DEFAULT_SIZE, 84, Short.MAX_VALUE))
                .addGap(29, 29, 29))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(71, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE)
                    .addComponent(f_annee))
                .addGap(45, 45, 45)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(f_annee_n)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE))
                .addGap(21, 21, 21)
                .addComponent(ajouterannee)
                .addGap(21, 21, 21)
                .addComponent(valider)
                .addGap(28, 28, 28))
        );
    }                        

    private void f_annee_nActionPerformed(java.awt.event.ActionEvent evt) {                                          
        // TODO add your handling code here:
        try{
            annee = Integer.parseInt(f_annee_n.getText());
        }catch (NumberFormatException e){
            System.out.println(e.getMessage());
        }
        
    }
    
    private void validerActionPerformed(java.awt.event.ActionEvent evt) {                                        
        // TODO add your handling code here:
        try{
            annee = Integer.parseInt(f_annee_n.getText());
        }catch (NumberFormatException e){
            System.out.println(e.getMessage());
            Fenetre.changePanel("accueil");
        }
        Fenetre.changePanel("accueil");
    } 

    private void ajouterannneeActionPerformed(java.awt.event.ActionEvent evt) {                                        
        // TODO add your handling code here:
        e.addAnnee();
        int index = e.getannee().size()-1;
        annee = e.getannee().get(index).getid();
        content.add(new ModifierTrimestre(),"ModifierTrimestre");
        Fenetre.changePanel("ModifierTrimestre");
    }                                       


    // Variables declaration - do not modify                     
    private javax.swing.JLabel f_annee;
    private javax.swing.JTextField f_annee_n;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JButton valider;
    private javax.swing.JButton ajouterannee;
    public static int annee =2018;
    // End of variables declaration                   
}
