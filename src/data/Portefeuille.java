/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestion;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author 931701524
 */
public class Portefeuille implements Serializable {
    
    static private final long serialVersionUID = 6L;
    String name;
    HashMap<String,Fond> Fonds;
    HashMap<String,Instrument> Instruments;

    Portefeuille(){
        Fonds = new HashMap<>();
        Instruments = new HashMap<>();
        name = "default";
    }
    
    Portefeuille(String nom){
        Fonds = new HashMap<>();
        Instruments = new HashMap<>();
        name = nom;
    }
    
    Portefeuille(HashMap<String,Instrument> b){
        Fonds = new HashMap<>();
        Instruments = b;
    }
    
    Portefeuille(HashMap<String,Fond> a, HashMap<String,Instrument> b){
        Fonds = a;
        Instruments = b;
    }
    
    public Fond chercherFond(String el) throws FondInexistant {
        if(Fonds.containsKey(el)) {
            return Fonds.get(el);
        }else throw new FondInexistant();
    }
    
    public ArrayList<Fond> chercherInstrument(String el) throws InstrumentInexistant {
        
        Instrument Instru;
        if(Instruments.get(el) == null){
            throw new InstrumentInexistant();
        }else Instru = Instruments.get(el);
        return Instru.getArray();
    }
    
    public void add(String key, Fond f){
        try{
            chercherFond(key);
            throw new FondExistant();
        }catch(FondInexistant e){
            Fonds.put(key, f);
        }catch(FondExistant e){
            System.out.println("Le Fond existe deja");
        }
        System.out.println("");
    }
    
    public void add(String key, Instrument i){
        try{
            chercherInstrument(key);
            throw new InstrumentExistant();
        }catch(InstrumentInexistant e){
            Instruments.put(key, i);
        }catch(InstrumentExistant e){
            System.out.println("L'instrument existe deja");
        }
        System.out.println("");
    }
    
    public void add(String keyI, String keyF) {
        try{
            chercherInstrument(keyI);
            Instrument a = Instruments.get(keyI);
            a.ajouterFond(Fonds.get(keyF));
        }catch(InstrumentInexistant e){
            Instrument a = new Instrument();
            a.ajouterFond(Fonds.get(keyF));
            Instruments.put(keyI, a);
        }
        System.out.println("");
    }
    
    public void supprF(String key){
        try{
            chercherFond(key);
            Fonds.remove(key);
        }catch(FondInexistant e){
            System.out.println("Fond introuvable");
            System.out.println("");
        }
    }
    
    public void supprI(String key){
        try{
            chercherInstrument(key);
            Instruments.get(key).getArray().clear();
            Instruments.remove(key);
        }catch(InstrumentInexistant e){
            System.out.println("Instrument introuvable");
            System.out.println("");
        }
    }
    
    public void save() throws IOException
    {
         
    FileOutputStream fos;
    ObjectOutputStream oos;
    fos = new FileOutputStream(name + "/Fonds.txt", true);
    oos = new ObjectOutputStream(fos);
    oos.writeObject(Fonds);
    oos.flush();
    oos.close();
    
    fos = new FileOutputStream(name + "/Instruments.txt", true);
    oos = new ObjectOutputStream(fos);
    oos.writeObject(Instruments);
    oos.flush();
    oos.close();
    }
    
    public static Portefeuille load(String filename) throws IOException, ClassNotFoundException
    {
    FileInputStream fis;
    ObjectInputStream ois;
    
    Portefeuille tempPortefeuille = new Portefeuille();
    fis = new FileInputStream(filename + "/Fonds.txt");
    ois = new ObjectInputStream(fis);
    tempPortefeuille.Fonds = (HashMap) ois.readObject();
    ois.close();

    fis = new FileInputStream(filename + "/Instruments.txt");
    ois = new ObjectInputStream(fis);
    tempPortefeuille.Instruments = (HashMap) ois.readObject();
    ois.close();
    
    return tempPortefeuille;
    }

    public void tri(String key)
    {
         try{
            chercherInstrument(key);
            Instruments.get(key).getArray().clear();
            Instruments.get(key).tri();
        }catch(InstrumentInexistant e){
            System.out.println("Instrument introuvable");
            System.out.println("");
        }
        
    }
    public String getname() {
        return name;
    }
    
    public HashMap<String,Fond> getFonds(){
        return Fonds;
    }
    
    public HashMap<String,Instrument> getInstruments(){
        return Instruments;
    }
}
