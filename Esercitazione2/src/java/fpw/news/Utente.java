/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fpw.news;

/**
 *
 * @author Sary
 */
public class Utente {
    private int id;
    private String nome;
    private String cognome;
    private String email;
    private String password;
    private String urlProfImg;
    
    //Costruttore di default
    public Utente()
    {
        this.id = 0;
        this.nome = " ";
        this.cognome = " ";
        this.email = " ";
        this.password = " ";
        this.urlProfImg = " ";
    }
    
    //Metodi get e set
    /**
     * 
     * @param _nome nome dell'utente
     */
    public void setNome(String _nome)
    {
        this.nome = _nome;
    }
    
    public String getNome()
    {
        return this.nome;
    }
    
    // set e get cognome
    public void setCognome(String _cognome)
    {
        this.cognome = _cognome;
    }
    
    public String getCognome()
    {
        return this.cognome;
    }
    
    //Set e get ID
    public void setId(int _id)
    {
        this.id = _id;
    }
    
    public int getId()
    {
        return this.id;
    }
    // Set e get email
    public void setEmail(String _email)
    {
        this.email = _email;
    }
    
    public String getEmail()
    {
        return this.email;
    }
    
    //Set e get password
    public void setPassword(String _psw)
    {
        this.password = _psw;
    }
    
    public String getPassword()
    {
        return this.password;
    }
    
    //Set e get image
    public void setImage(String _url)
    {
        this.urlProfImg = _url;
    }
    
    public String getImage()
    {
        return this.urlProfImg;
    }
    
    //Controlla se si tratta dello stesso utente
    public boolean equals(Utente _u)
    {
        boolean isEqual = false;
        if(this.id == _u.id)
        {
            isEqual = true;
        }
        return isEqual;   
    }
    
}
