/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

/**
 *
 * @author Jean
 */
public class Bulletin {
    private int id;
    private int idinscription;
    private String appreciation;
    private int idtrimestre;
    
    public Bulletin(){
        
    }
    public Bulletin(int id , int idinscription, String appreciation, int idtrimestre)
    {
        this.id=id;
        this.idinscription = idinscription;
        this.idtrimestre = idtrimestre;
        this.appreciation = appreciation;
    }
}
