/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package  Connexion;
import java.sql.SQLException;
import jdbcv2018.Connexion;
import java.util.ArrayList;
import data.*;
/**
 *
 * @author Jean
 */
public class AnneeScolaireDAO extends DAO<AnneeScolaire>{
    public AnneeScolaireDAO(Connexion conn){
        super(conn);
    }
    @Override
    public boolean create(AnneeScolaire as)
    {
        try{
            connexion.executeUpdate("INSERT INTO anneescolaire (idannee) VALUES ("+as.getid()+")");
            return true;
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return false;
    }
    @Override
    public boolean delete(AnneeScolaire as)
    {
        try{connexion.executeUpdate("DELETE FROM anneescolaire WHERE idannee="+as.getid());
        return true;
        }catch(SQLException e)
        {
            System.out.println(e.getMessage());
        }
        return false;
    }
    @Override
    public boolean update(AnneeScolaire as)
    {
        return false;
    }
    @Override
    public ArrayList<AnneeScolaire> tout()
    {
        ArrayList<AnneeScolaire> a = new ArrayList<>();
        a.add(new AnneeScolaire());
        try{
            ArrayList<String> results=connexion.remplirChampsRequete("SELECT * FROM anneescolaire");
            int number;
                    
            for(int i=0; i<results.size();i++)
            {
                number = Integer.parseInt(results.get(i));
                a.add(new AnneeScolaire(number));
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return a;
    }
    /*@Override
    public AnneeScolaire find(int id)
    {
        AnneeScolaire a = new AnneeScolaire();
        try{
            String result = (String) connexion.remplirChampsRequete("SELECT * FROM anneescolaire WHERE idannee="+id).get(0);
            System.out.println(result);
            a = new AnneeScolaire(Integer.parseInt(result));
        }catch (Exception e){
            System.out.println("L'annee cherchée n'existe pas.");
        }
        return a;
    }*/
}
