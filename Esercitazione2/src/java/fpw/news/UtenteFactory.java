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
import java.util.logging.Level;
import java.util.logging.Logger;

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

    public Utente getUtenteById(int idUser) {    
        try
        {
            Connection conn = DbConnection.getInstance().getConnection();

            // creo lo statement
            Statement stmt = conn.createStatement();
            //Definisco la query
            String sql = "select * from utente where id = '"+ idUser + "'";

            // la eseguo
            ResultSet set = stmt.executeQuery(sql);
            Utente u =  new Utente();
            // ciclo sulle righe restituite
            while (set.next()) {
                int id = set.getInt("id");
                String nome = set.getString("nome");
                String cognome = set.getString("cognome");
                String password = set.getString("password");
                String  email = set.getString("email");
                String urlImg = set.getString("urlImg");

                System.out.println(id);
                System.out.println(nome);
                System.out.println(cognome);
                System.out.println(email);
                System.out.println(password);
                System.out.println(urlImg);           
                
                u.setId(id);
                u.setNome(nome);
                u.setCognome(cognome);
                u.setEmail(email);
                u.setImage(urlImg);
                u.setPassword(password);

        }
        
        stmt.close();
        conn.close();
        
        return u;
        
        }catch(SQLException e)
        {
            // nel caso la query fallisca (p.e. errori di sintassi)
            // viene sollevata una SQLException
            Logger.getLogger(UtenteFactory.class.getName()).log(Level.SEVERE, null, e);
        }
        return null;
    /*
        for (Utente user : listaUtenti) {
            if (user.getId() == idUser) {
                return user;
            }
        }
        return null;
    */
    }

    public Utente getUtenteByEmail(String email) {
        try
        {
            Connection conn = DbConnection.getInstance().getConnection();

            // creo lo statement
            Statement stmt = conn.createStatement();
            //Definisco la query
            String sql = "select * from utente where email = '"+ email + "'";

            // la eseguo
            ResultSet set = stmt.executeQuery(sql);
            Utente u =  new Utente();
            // ciclo sulle righe restituite
            while (set.next()) {
                int id = set.getInt("id");
                String nome = set.getString("nome");
                String cognome = set.getString("cognome");
                String password = set.getString("password");
                String urlImg = set.getString("urlImg");

                System.out.println(id);
                System.out.println(nome);
                System.out.println(cognome);
                System.out.println(email);
                System.out.println(password);
                System.out.println(urlImg);           
                
                u.setId(id);
                u.setNome(nome);
                u.setCognome(cognome);
                u.setEmail(email);
                u.setImage(urlImg);
                u.setPassword(password);

        }
        
        stmt.close();
        conn.close();
        
        return u;
        
        }catch(SQLException e)
        {
            // nel caso la query fallisca (p.e. errori di sintassi)
            // viene sollevata una SQLException
            Logger.getLogger(UtenteFactory.class.getName()).log(Level.SEVERE, null, e);
        }
        return null;
        /*
        //Cerca l'utente con email uguale a quella passata come parametro
        for (Utente user : listaUtenti) {
            if (user.getEmail().equals(email)) {
                return user;
            }
        }
        return null;*/
    }

    public boolean login(String email, String password) {
        boolean is_logged=false;
        try
        {
            //Prevenire sql injection con i PreparedStatement
            Connection conn = DbConnection.getInstance().getConnection();
            String sql = "select * from utente where email = ? and password = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, email);
            stmt.setString(2, password);
            
            ResultSet set = stmt.executeQuery();
            while(set.next())
            {
                is_logged = true;
            }
            
            stmt.close();
            conn.close();
            
        }catch(SQLException e)
        {
            // nel caso la query fallisca (p.e. errori di sintassi)
            // viene sollevata una SQLException
            Logger.getLogger(UtenteFactory.class.getName()).log(Level.SEVERE, null, e);
        }
        
        return is_logged;
        /*
        //Cerca l'utente con email uguale a quella passata come parametro 
        for(Utente user : listaUtenti) {
            //Cerca l'utente che abbia stessa email e stessa password
            if (user.getEmail().equals(email) && user.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
        */
    }

    public ArrayList<Utente> getAllUsers() {    
        try
        {
        Connection conn = DbConnection.getInstance().getConnection();
        
        // creo lo statement
        Statement stmt = conn.createStatement();
        //Definisco la query
        String sql = "select * from utente";
        
        // la eseguo
        ResultSet set = stmt.executeQuery(sql);
        // ciclo sulle righe restituite
        while (set.next()) {
            int id = set.getInt("id");
            String nome = set.getString("nome");
            String cognome = set.getString("cognome");
            String password = set.getString("password");
            String  email = set.getString("email");
            String urlImg = set.getString("urlImg");
            
            System.out.println(id);
            System.out.println(nome);
            System.out.println(cognome);
            System.out.println(email);
            System.out.println(password);
            System.out.println(urlImg);           
            
            Utente u =  new Utente();
            u.setId(id);
            u.setNome(nome);
            u.setCognome(cognome);
            u.setEmail(email);
            u.setImage(urlImg);
            u.setPassword(password);
            
            listaUtenti.add(u);
           
        }
        
        stmt.close();
        conn.close();
        
        }catch(SQLException e)
        {
            // nel caso la query fallisca (p.e. errori di sintassi)
            // viene sollevata una SQLException
            Logger.getLogger(UtenteFactory.class.getName()).log(Level.SEVERE, null, e);
        }
        return listaUtenti;
    }
    
    public boolean insertUser(String nome, String cognome, String email, 
            String password, String urlImg)
    {
        boolean insert_OK = false;
        try
        {
            Connection conn = DbConnection.getInstance().getConnection();
            String sql = "insert into utente values (default, ?, ?, ?, ?, ?) ";
            /*
               id serial primary key,
               nome varchar(100),
               cognome varchar(100),
               email varchar(100) not null,
               password varchar(100) not null,
               urlImg varchar(100)
            */
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1,nome);
            stmt.setString(2,cognome);
            stmt.setString(3,email);
            stmt.setString(4,password);
            stmt.setString(5, urlImg);
            
            int rows = stmt.executeUpdate();
            if(rows == 1){
                System.out.println("Insert ok!");
                insert_OK = true;
            }
            // chiudo lo statement
            stmt.close();
            // chiusura della connessione
            conn.close();    
            
        }catch(SQLException e)
        {
            // nel caso la query fallisca (p.e. errori di sintassi)
            // viene sollevata una SQLException
            Logger.getLogger(UtenteFactory.class.getName()).log(Level.SEVERE, null, e);
        }
        return insert_OK;     
    }
    
    public boolean removeUser(int idUser)
    {
        Connection conn=null;
        try
        {
            conn = DbConnection.getInstance().getConnection();
            conn.setAutoCommit(false);
            String post = "DELETE FROM notizia WHERE autore = ?";
            PreparedStatement removeNotizia = conn.prepareStatement(post);
            removeNotizia.setInt(1, idUser);
            removeNotizia.executeUpdate();
            
            String user = "DELETE FROM utente WHERE id = ?";
            PreparedStatement removeUtente = conn.prepareStatement(user);
            removeUtente.setInt(1, idUser);
            removeUtente.executeUpdate();
            
            conn.commit();
            conn.setAutoCommit(true);
            return true;
        } catch(SQLException e) 
        {
            Logger.getLogger(UtenteFactory.class.getName()).log(Level.SEVERE, null, e);
            if(conn!=null)
            {
                try
                {
                    conn.rollback();
                }catch(SQLException ex)
                {
                    Logger.getLogger(UtenteFactory.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            return false;
        }  
    }
}