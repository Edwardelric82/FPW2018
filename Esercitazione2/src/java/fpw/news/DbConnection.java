/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fpw.news;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;



/**
 *
 * @author Sary
 */
//Classe per la gestione del DB, è un singleton
public class DbConnection {
    private static DbConnection singleton;
    //Ci garantisce che venga eseguito una sola volta
    private DbConnection(){
        try
        {
            // si carica a run-time la classe del Driver
            // tramite il nome del driver stesso
            // N.B. la string dipende dal DBMS in uso
            Class.forName("com.mysql.jdbc.Driver");
        }catch(ClassNotFoundException ex)
        {
            // viene sollevata questa eccezione nel caso
            // non si riesca a caricare la classe specificata.
            // Il DB in questo caso non sarà utilizzabile,
            // potrebbe essere il caso di terminare l’applicazione
            Logger.getLogger(DbConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static DbConnection getInstance(){
        //Non ancora istanziato
        if(singleton == null)
        {
            singleton =  new DbConnection();
        }
        return singleton;
    }
    
    public Connection getConnection()
    {
        Connection conn=null;
        //Stringa di connessione
        String str_conn = "jdbc:mysql://ec2-52-47-198-123.eu-west-3.compute.amazonaws.com:443/fpw18_sara";
        try
        {
            //Connessione al db 'fpw18_sara' con l'utente 'sara' la cui password è 'fpw18'
            conn = DriverManager.getConnection(str_conn, "sara", "fpw18");
        }catch(SQLException e)
        {
            e.printStackTrace();
        }
         return conn;
    }
}
