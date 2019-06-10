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
            connexion.executeUpdate("INSERT INTO niveau (idniveau, nom) VALUES ("+as.getid()+", '"+as.getnom()+"')");
            return true;
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return false;
    }
    @Override
    public boolean delete(Niveau as)
    {
        try{connexion.executeUpdate("DELETE FROM niveau WHERE idniveau="+as.getid());
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
            connexion.executeUpdate("UPDATE niveau SET nom='"+as.getnom()+"' WHERE idniveau="+as.getid());
            return true;
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
        return false;
    }
    @Override
    public ArrayList<Niveau> tout()
    {
        ArrayList<Niveau> a = new ArrayList<>();
        a.add(new Niveau());
        try{
            ArrayList<String>results=connexion.remplirChampsRequete("SELECT * FROM niveau");
            for(String elem:results)
            {
                String[] result=elem.split(",");
                a.add(new Niveau(Integer.parseInt(result[0]),result[1]));
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return a;
    }
    /*@Override
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
    }*/
}
