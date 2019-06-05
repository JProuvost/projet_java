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
            connexion.executeUpdate("INSERT INTO detailbulletin (iddetail, idbulletin, idenseignement, appreciation) VALUES ("+as.get_id()+", "+as.get_idbulletin()+", "+as.get_idenseignement()+", '"+as.get_appreciation()+"')");
            return true;
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return false;
    }
    @Override
    public boolean delete(DetailBulletin as)
    {
        try{connexion.executeUpdate("DELETE FROM detailbulletin WHERE iddetail="+as.get_id());
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
            connexion.executeUpdate("UPDATE detailbulletin SET idbulletin="+as.get_idbulletin()+", idenseignement="+as.get_idenseignement()+", appreciation='"+as.get_appreciation()+"' WHERE iddetail="+as.get_id());
            return true;
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
        return false;
    }
    @Override
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
    }
}
