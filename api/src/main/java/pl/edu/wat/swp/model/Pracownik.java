package pl.edu.wat.swp.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
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
@Table( name = "pracownik" )
@XmlRootElement
@NamedQueries( {
        @NamedQuery( name = "Pracownik.findAll", query = "SELECT p FROM Pracownik p" ),
        @NamedQuery( name = "Pracownik.findByPesel", query = "SELECT p FROM Pracownik p WHERE p.pesel = :pesel" ),
        @NamedQuery( name = "Pracownik.findByNazwisko", query = "SELECT p FROM Pracownik p WHERE p.nazwisko = :nazwisko" ),
        @NamedQuery( name = "Pracownik.findByImie", query = "SELECT p FROM Pracownik p WHERE p.imie = :imie" ),
        @NamedQuery( name = "Pracownik.findByKodPocztowy", query = "SELECT p FROM Pracownik p WHERE p.kodPocztowy = :kodPocztowy" ),
        @NamedQuery( name = "Pracownik.findByPoczta", query = "SELECT p FROM Pracownik p WHERE p.poczta = :poczta" ),
        @NamedQuery( name = "Pracownik.findByUlica", query = "SELECT p FROM Pracownik p WHERE p.ulica = :ulica" ),
        @NamedQuery( name = "Pracownik.findByNrDomu", query = "SELECT p FROM Pracownik p WHERE p.nrDomu = :nrDomu" ),
        @NamedQuery( name = "Pracownik.findByTelefon", query = "SELECT p FROM Pracownik p WHERE p.telefon = :telefon" ),
        @NamedQuery( name = "Pracownik.findByPensja", query = "SELECT p FROM Pracownik p WHERE p.pensja = :pensja" ) } )
public class Pracownik implements Serializable
{
    private static final long serialVersionUID = 1L;
    @Id
    @Basic( optional = false )
    @NotNull
    @Size( min = 1, max = 11 )
    @Column( name = "PESEL" )
    private String pesel;
    @Size( max = 40 )
    @Column( name = "Nazwisko" )
    private String nazwisko;
    @Size( max = 20 )
    @Column( name = "Imie" )
    private String imie;
    @Size( max = 6 )
    @Column( name = "KodPocztowy" )
    private String kodPocztowy;
    @Size( max = 30 )
    @Column( name = "Poczta" )
    private String poczta;
    @Size( max = 40 )
    @Column( name = "Ulica" )
    private String ulica;
    @Size( max = 10 )
    @Column( name = "NrDomu" )
    private String nrDomu;
    @Size( max = 9 )
    @Column( name = "Telefon" )
    private String telefon;
    // @Max(value=?) @Min(value=?)//if you know range of your decimal fields
    // consider using these annotations to enforce field validation
    @Column( name = "Pensja" )
    private BigDecimal pensja;
    @OneToMany( cascade = CascadeType.ALL, mappedBy = "pesel", fetch = FetchType.LAZY )
    private Collection<Operacjabankowa> operacjabankowaCollection;

    public Pracownik()
    {
    }

    public Pracownik( String pesel )
    {
        this.pesel = pesel;
    }

    public String getPesel()
    {
        return pesel;
    }

    public void setPesel( String pesel )
    {
        this.pesel = pesel;
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

    public String getKodPocztowy()
    {
        return kodPocztowy;
    }

    public void setKodPocztowy( String kodPocztowy )
    {
        this.kodPocztowy = kodPocztowy;
    }

    public String getPoczta()
    {
        return poczta;
    }

    public void setPoczta( String poczta )
    {
        this.poczta = poczta;
    }

    public String getUlica()
    {
        return ulica;
    }

    public void setUlica( String ulica )
    {
        this.ulica = ulica;
    }

    public String getNrDomu()
    {
        return nrDomu;
    }

    public void setNrDomu( String nrDomu )
    {
        this.nrDomu = nrDomu;
    }

    public String getTelefon()
    {
        return telefon;
    }

    public void setTelefon( String telefon )
    {
        this.telefon = telefon;
    }

    public BigDecimal getPensja()
    {
        return pensja;
    }

    public void setPensja( BigDecimal pensja )
    {
        this.pensja = pensja;
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

    @Override
    public int hashCode()
    {
        int hash = 0;
        hash += ( pesel != null ? pesel.hashCode() : 0 );
        return hash;
    }

    @Override
    public boolean equals( Object object )
    {
        // TODO: Warning - this method won't work in the case the id fields are
        // not set
        if ( !( object instanceof Pracownik ) )
        {
            return false;
        }
        Pracownik other = (Pracownik) object;
        if ( ( this.pesel == null && other.pesel != null )
             || ( this.pesel != null && !this.pesel.equals( other.pesel ) ) )
        {
            return false;
        }
        return true;
    }

    @Override
    public String toString()
    {
        return "pl.edu.wat.swp.model.Pracownik[ pesel=" + pesel + " ]";
    }

}
