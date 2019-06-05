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
            connexion.executeUpdate("INSERT INTO inscription (idinscription, ideleve, idclasse) VALUES ("+as.get_id()+", "+as.get_ideleve()+", "+as.get_idclasse()+")");
            return true;
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return false;
    }
    @Override
    public boolean delete(Inscription as)
    {
        try{connexion.executeUpdate("DELETE FROM inscription WHERE idinscription="+as.get_id());
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
            connexion.executeUpdate("UPDATE inscription SET ideleve="+as.get_ideleve()+", idclasse="+as.get_idclasse()+" WHERE idinscription="+as.get_id());
            return true;
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
        return false;
    }
    @Override
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
    }
}
