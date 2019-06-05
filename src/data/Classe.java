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
public class Classe {
    private int id;
    private String nom;
    private int idniveau;
    private int idannee;
    public Classe(){
        
    }
    public Classe(int a, String b, int c, int d)
    {
        id=a;
        nom=b;
        idniveau=c;
        idannee=d;
    }
    public int get_id()
    {
        return id;
    }
    public String get_nom()
    {
        return nom;
    }
    public int get_idniveau()
    {
        return idniveau;
    }
    public int get_idannee()
    {
        return idannee;
    }
    public void set_id(int a)
    {
        id=a;
    }
    public void set_nom(String a)
    {
        nom=a;
    }
    public void set_idniveau(int a)
    {
        idniveau=a;
    }
    public void set_idannee(int a)
    {
        idannee=a;
    }
}