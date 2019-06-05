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
public class NiveauDAO extends DAO<Niveau>{
    public NiveauDAO(Connexion conn){
        super(conn);
    }
    @Override
    public boolean create(Niveau as)
    {
        try{
            connexion.executeUpdate("INSERT INTO niveau (idniveau, nom) VALUES ("+as.get_id()+", '"+as.get_nom()+"')");
            return true;
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return false;
    }
    @Override
    public boolean delete(Niveau as)
    {
        try{connexion.executeUpdate("DELETE FROM niveau WHERE idniveau="+as.get_id());
        return true;
        }catch(SQLException e)
        {
            System.out.println(e.getMessage());
        }
        return false;
    }
    @Override
    public boolean update(Niveau as)
    {
        try{
            connexion.executeUpdate("UPDATE niveau SET nom='"+as.get_nom()+"' WHERE idniveau="+as.get_id());
            return true;
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
        return false;
    }
    @Override
    public Niveau find(int id)
    {
        Niveau a = new Niveau();
        try{
            String result = (String) connexion.remplirChampsRequete("SELECT * FROM niveau WHERE idniveau="+id).get(0);
            String[] elements =result.split(",");
            a = new Niveau(Integer.parseInt(elements[0]), elements[1]);
        }catch (Exception e){
            System.out.println("Le niveau cherché n'existe pas.");
        }
        return a;
    }
}
