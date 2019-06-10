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
public class DetailBulletinDAO extends DAO<DetailBulletin>{
    public DetailBulletinDAO(Connexion conn){
        super(conn);
    }
    @Override
    public boolean create(DetailBulletin as)
    {
        try{
            connexion.executeUpdate("INSERT INTO detailbulletin (iddetail, idbulletin, idenseignement, appreciation) VALUES ("+as.getid()+", "+as.getidBulletin()+", "+as.getidEnseignement()+", '"+as.getappreciation()+"')");
            return true;
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return false;
    }
    @Override
    public boolean delete(DetailBulletin as)
    {
        try{connexion.executeUpdate("DELETE FROM detailbulletin WHERE iddetail="+as.getid());
        return true;
        }catch(SQLException e)
        {
            System.out.println(e.getMessage());
        }
        return false;
    }
    @Override
    public boolean update(DetailBulletin as)
    {
        try{
            connexion.executeUpdate("UPDATE detailbulletin SET idbulletin="+as.getidBulletin()+", idenseignement="+as.getidEnseignement()+", appreciation='"+as.getappreciation()+"' WHERE iddetail="+as.getid());
            return true;
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
        return false;
    }
    @Override
    public ArrayList<DetailBulletin> tout()
    {
        ArrayList<DetailBulletin> a = new ArrayList<>();
        a.add(new DetailBulletin());
        try{
            ArrayList<String>results=connexion.remplirChampsRequete("SELECT * FROM detailbulletin");
            for(String elem:results)
            {
                String[] result=elem.split(",");
                a.add(new DetailBulletin(Integer.parseInt(result[0]),Integer.parseInt(result[1]),Integer.parseInt(result[2]),result[3]));
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return a;
    }
    /*@Override
    public DetailBulletin find(int id)
    {
        DetailBulletin a = new DetailBulletin();
        try{
            String result = (String) connexion.remplirChampsRequete("SELECT * FROM detailbulletin WHERE iddetail="+id).get(0);
            String[] elements =result.split(",");
            a = new DetailBulletin(Integer.parseInt(elements[0]), Integer.parseInt(elements[1]), Integer.parseInt(elements[2]), elements[3]);
        }catch (Exception e){
            System.out.println("Le détail cherché n'existe pas.");
        }
        return a;
    }*/
}
