/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;
import data.*;
import java.util.ArrayList;
import jdbcv2018.Connexion;
import Connexion.*;
import org.jfree.ui.RefineryUtilities;
import visuelle.*;
/**
 * 
 *
 * @author Jean
 */
public class test {
    public static void main(String[] args)
    {
        ArrayList<String> resultat;
        Fenetre all = new Fenetre();
        RefineryUtilities.centerFrameOnScreen(all);
        try{
            Connexion connexion = new Connexion("ecole", "root","");
            resultat=connexion.remplirChampsRequete("SELECT * FROM bulletin");
            
            DAO<AnneeScolaire> anneescolaireDAO = new AnneeScolaireDAO(connexion);
            
        }catch(Exception e){
            System.out.println("fuh");
        }
    }
}
