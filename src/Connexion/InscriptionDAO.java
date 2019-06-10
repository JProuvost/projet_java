/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Connexion;
import java.sql.SQLException;
import jdbcv2018.Connexion;
import java.util.ArrayList;
import data.*;
/**
 *
 * @author Jean
 */
public class InscriptionDAO extends DAO<Inscription>{
    public InscriptionDAO(Connexion conn){
        super(conn);
    }
    @Override
    public boolean create(Inscription as)
    {
        try{
            connexion.executeUpdate("INSERT INTO inscription (idinscription, ideleve, idclasse) VALUES ("+as.getid()+", "+as.getidPersonne()+", "+as.getidClasse()+")");
            return true;
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return false;
    }
    @Override
    public boolean delete(Inscription as)
    {
        try{connexion.executeUpdate("DELETE FROM inscription WHERE idinscription="+as.getid());
        return true;
        }catch(SQLException e)
        {
            System.out.println(e.getMessage());
        }
        return false;
    }
    @Override
    public boolean update(Inscription as)
    {
        try{
            connexion.executeUpdate("UPDATE inscription SET ideleve="+as.getidPersonne()+", idclasse="+as.getidClasse()+" WHERE idinscription="+as.getid());
            return true;
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
        return false;
    }
    @Override
    public ArrayList<Inscription> tout()
    {
        ArrayList<Inscription> a = new ArrayList<>();
        a.add(new Inscription());
        try{
            ArrayList<String>results=connexion.remplirChampsRequete("SELECT * FROM inscription");
            for(String elem:results)
            {
                String[] result=elem.split(",");
                a.add(new Inscription(Integer.parseInt(result[0]),Integer.parseInt(result[1]),Integer.parseInt(result[2])));
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return a;
    }
    /*@Override
    public Inscription find(int id)
    {
        Inscription a = new Inscription();
        try{
            String result = (String) connexion.remplirChampsRequete("SELECT * FROM inscription WHERE idinscription="+id).get(0);
            String[] elements =result.split(",");
            a = new Inscription(Integer.parseInt(elements[0]), Integer.parseInt(elements[1]), Integer.parseInt(elements[2]));
        }catch (Exception e){
            System.out.println("L'inscription cherché n'existe pas.");
        }
        return a;
    }*/
}
