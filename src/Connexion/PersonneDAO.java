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
            connexion.executeUpdate("INSERT INTO personne (idpersonne, nom, prenom, type) VALUES ("+as.get_id()+", '"+as.get_nom()+"', '"+as.get_prenom()+"', '"+as.get_type()+"')");
            return true;
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return false;
    }
    @Override
    public boolean delete(Personne as)
    {
        try{connexion.executeUpdate("DELETE FROM personne WHERE idpersonne="+as.get_id());
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
            connexion.executeUpdate("UPDATE personne SET nom='"+as.get_nom()+"', prenom='"+as.get_prenom()+"', type='"+as.get_type()+"' WHERE idpersonne="+as.get_id());
            return true;
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
        return false;
    }
    @Override
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
    }
}
