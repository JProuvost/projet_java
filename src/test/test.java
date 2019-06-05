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
/**
 *
 * @author Jean
 */
public class test {
    public static void main(String[] args)
    {
        ArrayList<String> resultat;
        try{
            Connexion connexion = new Connexion("ecole", "root","");
            connexion.ajouterTable("anneescolaire");
            try{connexion.executeUpdate("INSERT INTO anneescolaire VALUES()");}
            catch(Exception e){System.out.println(e.getMessage());}
            resultat=connexion.remplirChampsRequete("SELECT * FROM bulletin");
            for(String elem:resultat)
            {
                System.out.println(elem);
            }
            DAO<AnneeScolaire> anneescolaireDAO = new AnneeScolaireDAO(connexion);
            AnneeScolaire a=anneescolaireDAO.find(2);
            System.out.println(a.get_id());
        }catch(Exception e){
            System.out.println("fuh");
        }
    }
}
