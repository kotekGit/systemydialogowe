package pl.edu.wat.swp.dto;

import pl.edu.wat.swp.model.Adres;
import pl.edu.wat.swp.model.Klient;

/**
 * 
 * @author Krzysztof Jedynak @email jedynakpoczta@gmail.com
 * @date 21 sty 2015
 */
public class UserDTO
{

    private Integer id;
    private String surname;
    private String name;
    private String login;
    private String password;
    private String place;
    private String post;
    private String street;
    private String district;

    public UserDTO()
    {
    }

    public UserDTO( Klient klient, Adres adres )
    {
        this.id = klient.getNik();
        this.surname = klient.getNazwisko();
        this.name = klient.getImie();
        this.login = klient.getLogin();
        this.password = klient.getHaslo();
        if ( adres != null )
        {
            this.place = adres.getMiejscowosc();
            this.post = adres.getPoczta();
            this.street = adres.getUlica();
            this.district = adres.getDzielnica();
        }

    }

    public Integer getId()
    {
        return id;
    }

    public void setId( Integer id )
    {
        this.id = id;
    }

    public String getSurname()
    {
        return surname;
    }

    public void setSurname( String surname )
    {
        this.surname = surname;
    }

    public String getName()
    {
        return name;
    }

    public void setName( String name )
    {
        this.name = name;
    }

    public String getLogin()
    {
        return login;
    }

    public void setLogin( String login )
    {
        this.login = login;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword( String password )
    {
        this.password = password;
    }

    public String getPlace()
    {
        return place;
    }

    public void setPlace( String place )
    {
        this.place = place;
    }

    public String getPost()
    {
        return post;
    }

    public void setPost( String post )
    {
        this.post = post;
    }

    public String getStreet()
    {
        return street;
    }

    public void setStreet( String street )
    {
        this.street = street;
    }

    public String getDistrict()
    {
        return district;
    }

    public void setDistrict( String district )
    {
        this.district = district;
    }

}
