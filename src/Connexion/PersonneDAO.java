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
public class PersonneDAO extends DAO<Personne>{
    public PersonneDAO(Connexion conn){
        super(conn);
    }
    @Override
    public boolean create(Personne as)
    {
        try{
            connexion.executeUpdate("INSERT INTO personne (idpersonne, nom, prenom, type) VALUES ("+as.getid()+", '"+as.getnom()+"', '"+as.getprenom()+"', '"+as.gettype()+"')");
            return true;
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return false;
    }
    @Override
    public boolean delete(Personne as)
    {
        try{connexion.executeUpdate("DELETE FROM personne WHERE idpersonne="+as.getid());
        return true;
        }catch(SQLException e)
        {
            System.out.println(e.getMessage());
        }
        return false;
    }
    @Override
    public boolean update(Personne as)
    {
        try{
            connexion.executeUpdate("UPDATE personne SET nom='"+as.getnom()+"', prenom='"+as.getprenom()+"', type='"+as.gettype()+"' WHERE idpersonne="+as.getid());
            return true;
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
        return false;
    }
    
    @Override
    public ArrayList<Personne> tout()
    {
        ArrayList<Personne> a = new ArrayList<>();
        a.add(new Personne());
        try{
            ArrayList<String>results=connexion.remplirChampsRequete("SELECT * FROM personne");
            for(String elem:results)
            {
                String[] result=elem.split(",");
                a.add(new Personne(Integer.parseInt(result[0]),result[1],result[2],result[3]));
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return a;
    }
    /*@Override
    public Personne find(int id)
    {
        Personne a = new Personne();
        try{
            String result = (String) connexion.remplirChampsRequete("SELECT * FROM personne WHERE idpersonne="+id).get(0);
            String[] elements =result.split(",");
            a = new Personne(Integer.parseInt(elements[0]), elements[1], elements[2], elements[3]);
        }catch (Exception e){
            System.out.println("La personne cherchée n'existe pas.");
        }
        return a;
    }*/
}
