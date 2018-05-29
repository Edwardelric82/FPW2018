/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fpw.news;

import java.sql.Connection;
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
public class NotiziaFactory {
    private static NotiziaFactory singleton;
    private ArrayList<Notizia> listaNews = new ArrayList<Notizia>();
    
    public static NotiziaFactory getInstance()
    {
        if(singleton==null)
        {
            singleton = new NotiziaFactory();
        }
        return singleton;
    }
        
    private NotiziaFactory()
    {
        Notizia n1 = new Notizia();
        n1.setId(0);
        n1.setTitolo("Scandalo Facebook!");
        n1.setContent("Sconvolgente e scioccante, lo scandalo facebook..");
        UtenteFactory utFactory = UtenteFactory.getInstance();
        Utente autore = utFactory.getUtenteById(0);
        n1.setAutore(autore);
        
        
        Notizia n2 = new Notizia();
        n2.setId(1);
        n2.setTitolo("Pirati della strada investono bambino");
        n2.setContent("Sconvolgente e scioccante, bambino trovato morto a seguito di un incidente stradale");
        Utente autore2 = utFactory.getUtenteById(1);
        n2.setAutore(autore2);
        
        Notizia n3 = new Notizia();
        n3.setId(1);
        n3.setTitolo("Giornata Calcistica di domenica");
        n3.setContent("Ecco qua i risultati della giornata calcistica");
        n3.setAutore(autore2);
        
        listaNews.add(n1);
        listaNews.add(n2);
        listaNews.add(n3);
    }
    
    public Notizia getNotiziaById(int idN)
    {
        for(Notizia news : listaNews)
        {
            if(news.getId()==idN)
                return news;
        }
        return null;
    }
    
    public ArrayList<Notizia> getListaNewsByAutore(Utente _aut)
    {
        ArrayList<Notizia> listaForUser = new ArrayList<Notizia>();
        for(Notizia news : listaNews)
        {
            if(news.getAutore().equals(_aut))
            {
                listaForUser.add(news);
            }
        }
        return listaForUser;
    }
    
    public ArrayList<Notizia> getAllNews()
    {
        return listaNews;
    }
    
    public ArrayList<Notizia> searchNewsByQueryStr(String query_str)
    {
        ArrayList<Notizia> lista_news = new ArrayList<Notizia>();
        try
        {
            //Prevenire sql injection con i PreparedStatement
            Connection conn = DbConnection.getInstance().getConnection();
            String sql ="Select * from notizia where titolo like '%"+query_str+"%'";
            System.out.println(sql);
            Statement stmt = conn.createStatement();
            ResultSet set = stmt.executeQuery(sql);
            while(set.next())
            {
                int id = set.getInt("id");
                String titolo = set.getString("titolo");
                String content = set.getString("content");
                String img = set.getString("img");
                int id_autore = set.getInt("autore");
                Utente u = UtenteFactory.getInstance().getUtenteById(id_autore);
                String categoria = set.getString("categoria");
                
                Notizia news = new Notizia();
                news.setId(id);
                news.setAutore(u);
                news.setCategoria(categoria);
                news.setImg(img);
                news.setTitolo(titolo);
                news.setContent(content);
                
                lista_news.add(news);           
            }
            
            stmt.close();
            conn.close();
        }catch(SQLException e)
        {
            // nel caso la query fallisca (p.e. errori di sintassi)
            // viene sollevata una SQLException
            Logger.getLogger(UtenteFactory.class.getName()).log(Level.SEVERE, null, e);
        }
        return lista_news;
    }
}
