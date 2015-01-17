package pl.edu.wat.swp.model;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 * 
 * @author: Krzysztof Jedynak @email: (jedynakpoczta@gmail.com)
 * @date: 7 gru 2014
 * 
 */

@Entity
@Table( name = "Klient" )
@XmlRootElement
@NamedQueries( { @NamedQuery( name = "Klient.findAll", query = "SELECT k FROM Klient k" ),
        @NamedQuery( name = "Klient.findByNik", query = "SELECT k FROM Klient k WHERE k.nik = :nik" ),
        @NamedQuery( name = "Klient.findByNazwisko", query = "SELECT k FROM Klient k WHERE k.nazwisko = :nazwisko" ),
        @NamedQuery( name = "Klient.findByImie", query = "SELECT k FROM Klient k WHERE k.imie = :imie" ),
        @NamedQuery( name = "Klient.findByTelefon", query = "SELECT k FROM Klient k WHERE k.telefon = :telefon" ),
        @NamedQuery( name = "Klient.findByLogin", query = "SELECT k FROM Klient k WHERE k.login = :login" ),
        @NamedQuery( name = "Klient.findByHaslo", query = "SELECT k FROM Klient k WHERE k.haslo = :haslo" ),
        @NamedQuery( name = "Klient.findByEmail", query = "SELECT k FROM Klient k WHERE k.email = :email" ) } )
public class Klient implements Serializable
{
    private static final long serialVersionUID = 1L;
    @Id
    @Basic( optional = false )
    @Column( name = "NIK" )
    private Integer nik;
    @Size( max = 40 )
    @Column( name = "Nazwisko" )
    private String nazwisko;
    @Size( max = 20 )
    @Column( name = "Imie" )
    private String imie;
    @Size( max = 9 )
    @Column( name = "Telefon" )
    private String telefon;
    @Basic( optional = false )
    @Size( min = 1, max = 20 )
    @Column( name = "Login" )
    private String login;
    @Basic( optional = false )
    @Size( min = 1, max = 10 )
    @Column( name = "Haslo" )
    private String haslo;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?",
    // message="Invalid email")//if the field contains email address consider
    // using this annotation to enforce field validation
    @Size( max = 20 )
    @Column( name = "Email" )
    private String email;
    @JoinTable( name = "pelnomocnictwo", joinColumns = { @JoinColumn( name = "NIK", referencedColumnName = "NIK" ) }, inverseJoinColumns = { @JoinColumn( name = "CIF", referencedColumnName = "CIF" ) } )
    @ManyToMany( fetch = FetchType.LAZY )
    private Collection<Kontobankowe> kontobankoweCollection;
    @OneToMany( cascade = CascadeType.ALL, mappedBy = "nik", fetch = FetchType.LAZY )
    private Collection<Operacjabankowa> operacjabankowaCollection;
    @JoinColumn( name = "IdAdresu", referencedColumnName = "IdAdresu" )
    @ManyToOne( fetch = FetchType.LAZY )
    private Adres idAdresu;

    public Klient()
    {
    }

    public Klient( Integer nik )
    {
        this.nik = nik;
    }

    public Klient( Integer nik, String login, String haslo )
    {
        this.nik = nik;
        this.login = login;
        this.haslo = haslo;
    }

    public Integer getNik()
    {
        return nik;
    }

    public void setNik( Integer nik )
    {
        this.nik = nik;
    }

    public String getNazwisko()
    {
        return nazwisko;
    }

    public void setNazwisko( String nazwisko )
    {
        this.nazwisko = nazwisko;
    }

    public String getImie()
    {
        return imie;
    }

    public void setImie( String imie )
    {
        this.imie = imie;
    }

    public String getTelefon()
    {
        return telefon;
    }

    public void setTelefon( String telefon )
    {
        this.telefon = telefon;
    }

    public String getLogin()
    {
        return login;
    }

    public void setLogin( String login )
    {
        this.login = login;
    }

    public String getHaslo()
    {
        return haslo;
    }

    public void setHaslo( String haslo )
    {
        this.haslo = haslo;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail( String email )
    {
        this.email = email;
    }

    @XmlTransient
    public Collection<Kontobankowe> getKontobankoweCollection()
    {
        return kontobankoweCollection;
    }

    public void setKontobankoweCollection( Collection<Kontobankowe> kontobankoweCollection )
    {
        this.kontobankoweCollection = kontobankoweCollection;
    }

    @XmlTransient
    public Collection<Operacjabankowa> getOperacjabankowaCollection()
    {
        return operacjabankowaCollection;
    }

    public void setOperacjabankowaCollection( Collection<Operacjabankowa> operacjabankowaCollection )
    {
        this.operacjabankowaCollection = operacjabankowaCollection;
    }

    public Adres getIdAdresu()
    {
        return idAdresu;
    }

    public void setIdAdresu( Adres idAdresu )
    {
        this.idAdresu = idAdresu;
    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        hash += ( nik != null ? nik.hashCode() : 0 );
        return hash;
    }

    @Override
    public boolean equals( Object object )
    {
        // TODO: Warning - this method won't work in the case the id fields are
        // not set
        if ( !( object instanceof Klient ) )
        {
            return false;
        }
        Klient other = (Klient) object;
        if ( ( this.nik == null && other.nik != null ) || ( this.nik != null && !this.nik.equals( other.nik ) ) )
        {
            return false;
        }
        return true;
    }

    @Override
    public String toString()
    {
        return "pl.edu.wat.swp.model.Klient[ nik=" + nik + " ]";
    }

}
