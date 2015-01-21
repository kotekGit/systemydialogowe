package pl.edu.wat.swp.dto;

import java.math.BigDecimal;

import pl.edu.wat.swp.model.Klient;
import pl.edu.wat.swp.model.Subkonto;

/**
 * 
 * @author Krzysztof Jedynak @email jedynakpoczta@gmail.com
 * @date 21 sty 2015
 */
public class SubAccountDTO
{

    private Integer nrsk;
    private Integer id;
    private String surname;
    private String name;
    private String login;
    private String password;
    private BigDecimal saldo;

    public SubAccountDTO()
    {
    }

    public SubAccountDTO( Klient klient, Subkonto subkonto )
    {
        this.nrsk = subkonto.getNrsk();
        this.saldo = subkonto.getStanKonta();
        this.id = klient.getNik();
        this.surname = klient.getNazwisko();
        this.name = klient.getImie();
        this.login = klient.getLogin();
    }

    public Integer getNrsk()
    {
        return nrsk;
    }

    public void setNrsk( Integer nrsk )
    {
        this.nrsk = nrsk;
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

    public BigDecimal getSaldo()
    {
        return saldo;
    }

    public void setSaldo( BigDecimal saldo )
    {
        this.saldo = saldo;
    }

}
