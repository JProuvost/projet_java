/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestion;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 *
 * @author 931701524
 */
public class Gestion {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException, ClassNotFoundException {
       
        boolean quit = false;
        Instrument I;
        Fond F;
        String name;
        String nameI;
        String nameF;
        double montant;
        Vue v = new Vue();
        
        Portefeuille p = new Portefeuille();
        
        while(quit!=true){
            
            System.out.println("1.changer de portefeuille");
            System.out.println("2.Liste des Instruments");
            System.out.println("3.Liste des Fonds");
            System.out.println("4.Créer un nouvel instrument");
            System.out.println("5.Créer un nouveau fond");
            System.out.println("6.Ajouter un fond a un instrument");
            System.out.println("7.Ajouter un portefeuille");
            System.out.println("8.Trier un Instrument");
            System.out.println("9.afficher un instrument");
            System.out.println("10.afficher % intsrument");
            System.out.println("11.Supprimer un Instrument");
            System.out.println("12.Supprimer un Fond");
            System.out.println("0.quitter");
            System.out.println("");


            Scanner sc = new Scanner(System.in);
            int sel = sc.nextInt();

            switch (sel) 
                        {
                            case 1:
                                System.out.println("nom du portefeuille");
                                name = sc.next();
                                p.save();
                                p = p.load(name);
                                v = new Vue(p);
                                break;
                            case 2:
                                v.afficherInstruments();
                                break;
                            case 3:
                                v.afficherFonds();
                                break;
                            case 4:
                                v.listInstrument();
                                System.out.println("nom de L'instrument");
                                name = sc.next();
                                I = new Instrument();
                                p.add(name,I);
                                break;
                            case 5:
                                v.listFond();
                                System.out.println("nom du Fond");
                                name = sc.next();
                                System.out.println("montant du Fond");
                                montant = sc.nextDouble();
                                F = new Fond(montant);
                                p.add(name,F);
                                break;
                            case 6:
                                v.listFond();
                                System.out.println("nom du Fond");
                                nameF = sc.next();
                                System.out.println("");
                                v.listInstrument();
                                System.out.println("nom de L'instrument");
                                nameI = sc.next();
                                p.add(nameI,nameF);
                                break;
                            case 7:
                                System.out.println("nom du Portefeuille");
                                name = sc.next();
                                File dir = new File(name);
                                dir.mkdirs();
                                p.save();
                                p = new Portefeuille(name);
                                v = new Vue(p);
                                System.out.println("");
                                break;
                            case 8:
                                v.listInstrument();
                                System.out.println("nom de L'instrument");
                                nameI = sc.next();
                                p.tri(nameI);
                                System.out.println("");
                                break;
                            case 9:
                                v.listInstrument();
                                System.out.println("nom de L'instrument");
                                nameI = sc.next();
                                v.afficherInstruments(nameI);
                                System.out.println("");
                                break;
                            case 10:
                                v.listInstrument();
                                System.out.println("nom de l'instrument");
                                nameI = sc.next();
                                v.pourcentInstrument(nameI);
                                System.out.println("");
                                break;
                            case 11:
                                v.listInstrument();
                                System.out.println("nom de l'instrument");
                                nameI = sc.next();
                                p.supprI(nameI);
                                System.out.println("");
                                break;
                            case 12:
                                v.listFond();
                                System.out.println("nom du fond");
                                nameF = sc.next();
                                p.supprF(nameF);
                                System.out.println("");
                                break;
                            case 0:
                                p.save();
                                quit = true;
                                break;
                            default:
                                break;
                        }
            System.out.println("");
        }
    }
}
