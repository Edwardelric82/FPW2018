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
public class Notizia {

    /**
     * @return the categoria
     */
    public String getCategoria() {
        return categoria;
    }

    /**
     * @param categoria the categoria to set
     */
    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
    private int id;
    private String titolo;
    private String content;
    private String img;
    private Utente autore;
    private String categoria;

    public int getType() {
        return type;
    }
    private int type;

    public void setType(int type) {
        this.type = type;
    }
    
    public Notizia()
    {
        this.id = 0;
        this.titolo = " ";
        this.content = " ";
        this.autore = new Utente();
        this.img = " ";
    }
    
    //Metodi get e set per la notizia
    public void setId(int _id)
    {
        this.id = _id;
    }
    
    public int getId()
    {
       return this.id;
    }
    
    public void setTitolo(String _titolo)
    {
        this.titolo = _titolo;
    }
    
    public String getTitolo()
    {
        return this.titolo;
    }
    
    public void setContent(String _content)
    {
        this.content = _content;
    }
    
    public String getContent()
    {
        return this.content;
    }
    
    public void setAutore(Utente _autore)
    {
        this.autore = _autore;
    }
    
    public Utente getAutore()
    {
        return this.autore;
    }
    
    public void setImg(String _img)
    {
        this.img = _img;
    }
    
    public String getImg()
    {
        return this.img;
    }
}
