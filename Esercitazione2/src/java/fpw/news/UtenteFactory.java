/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fpw.news;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Sary
 */
public class UtenteFactory {

    //Attributi
    private static UtenteFactory singleton;
    private String db_str_connection;
    private ArrayList<Utente> listaUtenti = new ArrayList<Utente>();

    public static UtenteFactory getInstance() {
        if (singleton == null) {
            singleton = new UtenteFactory();
        }
        return singleton;
    }

    //Costruttore
    private UtenteFactory() {
        

        /*
        //Utente 1
        Utente u1 = new Utente();
        u1.setId(0);
        u1.setNome("Sara");
        u1.setCognome("Casti");
        u1.setEmail("sara@gmail.com");
        u1.setPassword("dsjkdfs");

        //Utente 2
        Utente u2 = new Utente();
        u2.setId(1);
        u2.setNome("Paolo");
        u2.setCognome("Masala");
        u2.setEmail("paolo@gmail.com");
        u2.setPassword("dsadffaadsjkdfs");

        //Utente 3
        Utente u3 = new Utente();
        u3.setId(2);
        u3.setNome("Carla");
        u3.setCognome("Boi");
        u3.setEmail("boi@gmail.com");
        u3.setPassword("prova");

        //inseriamo tutti gli utenti
        listaUtenti.add(u1);
        listaUtenti.add(u2);
        listaUtenti.add(u3);
*/
    }
    
    public Connection connect_db(){
        try
        {
            Connection conn = DriverManager.getConnection(getDb_str_connection(), "sara", "fpw18");
            return conn;
        }catch(SQLException ex)
        {
            ex.printStackTrace();
        }
        return null;
    }

    public Utente getUtenteById(int idUser) {        
        for (Utente user : listaUtenti) {
            if (user.getId() == idUser) {
                return user;
            }
        }
        return null;
    }

    public Utente getUtenteByEmail(String email) {
        //Cerca l'utente con email uguale a quella passata come parametro
        for (Utente user : listaUtenti) {
            if (user.getEmail().equals(email)) {
                return user;
            }
        }
        return null;
    }

    public boolean login(String email, String password) {
        //Cerca l'utente con email uguale a quella passata come parametro 
        for(Utente user : listaUtenti) {
            //Cerca l'utente che abbia stessa email e stessa password
            if (user.getEmail().equals(email) && user.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }

    public ArrayList<Utente> getAllUsers() {    
        return listaUtenti;
    }

    /**
     * @return the db_str_connection
     */
    public String getDb_str_connection() {
        return db_str_connection;
    }

    /**
     * @param db_str_connection the db_str_connection to set
     */
    public void setDb_str_connection(String db_str_connection) {
        this.db_str_connection = db_str_connection;
    }
    
}