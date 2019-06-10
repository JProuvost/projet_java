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
public class BulletinDAO extends DAO<Bulletin>{
    public BulletinDAO(Connexion conn){
        super(conn);
    }
    @Override
    public boolean create(Bulletin as)
    {
        try{
            connexion.executeUpdate("INSERT INTO bulletin (idbulletin, idinscription, appreciation, idtrimestre) VALUES ("+as.getid()+", "+as.getidInscription()+", '"+as.getappreciation()+"', "+as.getidTrimestre()+")");
            return true;
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return false;
    }
    @Override
    public boolean delete(Bulletin as)
    {
        try{connexion.executeUpdate("DELETE FROM bulletin WHERE idbulletin="+as.getid());
        return true;
        }catch(SQLException e)
        {
            System.out.println(e.getMessage());
        }
        return false;
    }
    @Override
    public boolean update(Bulletin as)
    {
        try{
            connexion.executeUpdate("UPDATE bulletin SET idinscription="+as.getidInscription()+", appreciation='"+as.getappreciation()+"', idtrimestre="+as.getidTrimestre()+" WHERE idbulletin="+as.getid());
            return true;
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
        return false;
    }
    @Override
    public ArrayList<Bulletin> tout()
    {
        ArrayList<Bulletin> a = new ArrayList<>();
        a.add(new Bulletin());
        try{
            ArrayList<String>results=connexion.remplirChampsRequete("SELECT * FROM bulletin");
            for(String elem:results)
            {
                String[] result=elem.split(",");
                a.add(new Bulletin(Integer.parseInt(result[0]),Integer.parseInt(result[1]),Integer.parseInt(result[2]),result[3]));
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return a;
    }
    /*@Override
     public Bulletin find(int id)
    {
        Bulletin a = new Bulletin();
        try{
            String result = (String) connexion.remplirChampsRequete("SELECT * FROM bulletin WHERE idbulletin="+id).get(0);
            String[] elements =result.split(",");
            a = new Bulletin(Integer.parseInt(elements[0]), Integer.parseInt(elements[1]), elements[2], Integer.parseInt(elements[3]));
        }catch (Exception e){
            System.out.println("Le bulletin cherché n'existe pas.");
        }
        return a;
    } */
}
