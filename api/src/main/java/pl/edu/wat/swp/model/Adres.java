package pl.edu.wat.swp.model;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Basic;
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
@Table( name = "adres" )
@XmlRootElement
@NamedQueries( {
        @NamedQuery( name = "Adres.findAll", query = "SELECT a FROM Adres a" ),
        @NamedQuery( name = "Adres.findByIdAdresu", query = "SELECT a FROM Adres a WHERE a.idAdresu = :idAdresu" ),
        @NamedQuery( name = "Adres.findByMiejscowosc", query = "SELECT a FROM Adres a WHERE a.miejscowosc = :miejscowosc" ),
        @NamedQuery( name = "Adres.findByKodPocztowy", query = "SELECT a FROM Adres a WHERE a.kodPocztowy = :kodPocztowy" ),
        @NamedQuery( name = "Adres.findByPoczta", query = "SELECT a FROM Adres a WHERE a.poczta = :poczta" ),
        @NamedQuery( name = "Adres.findByUlica", query = "SELECT a FROM Adres a WHERE a.ulica = :ulica" ),
        @NamedQuery( name = "Adres.findByNrBudynku", query = "SELECT a FROM Adres a WHERE a.nrBudynku = :nrBudynku" ),
        @NamedQuery( name = "Adres.findByNrLokalu", query = "SELECT a FROM Adres a WHERE a.nrLokalu = :nrLokalu" ) } )
public class Adres implements Serializable
{
    private static final long serialVersionUID = 1L;
    @Id
    @Basic( optional = false )
    @NotNull
    @Column( name = "IdAdresu" )
    private Integer idAdresu;
    @Size( max = 30 )
    @Column( name = "Miejscowosc" )
    private String miejscowosc;
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
    @Column( name = "NrBudynku" )
    private String nrBudynku;
    @Size( max = 5 )
    @Column( name = "NrLokalu" )
    private String nrLokalu;
    @OneToMany( mappedBy = "idAdresu", fetch = FetchType.LAZY )
    private Collection<Oddzial> oddzialCollection;
    @OneToMany( mappedBy = "idAdresu", fetch = FetchType.LAZY )
    private Collection<Bankomat> bankomatCollection;
    @OneToMany( mappedBy = "idAdresu", fetch = FetchType.LAZY )
    private Collection<Klient> klientCollection;

    public Adres()
    {
    }

    public Adres( Integer idAdresu )
    {
        this.idAdresu = idAdresu;
    }

    public Integer getIdAdresu()
    {
        return idAdresu;
    }

    public void setIdAdresu( Integer idAdresu )
    {
        this.idAdresu = idAdresu;
    }

    public String getMiejscowosc()
    {
        return miejscowosc;
    }

    public void setMiejscowosc( String miejscowosc )
    {
        this.miejscowosc = miejscowosc;
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

    public String getNrBudynku()
    {
        return nrBudynku;
    }

    public void setNrBudynku( String nrBudynku )
    {
        this.nrBudynku = nrBudynku;
    }

    public String getNrLokalu()
    {
        return nrLokalu;
    }

    public void setNrLokalu( String nrLokalu )
    {
        this.nrLokalu = nrLokalu;
    }

    @XmlTransient
    public Collection<Oddzial> getOddzialCollection()
    {
        return oddzialCollection;
    }

    public void setOddzialCollection( Collection<Oddzial> oddzialCollection )
    {
        this.oddzialCollection = oddzialCollection;
    }

    @XmlTransient
    public Collection<Bankomat> getBankomatCollection()
    {
        return bankomatCollection;
    }

    public void setBankomatCollection( Collection<Bankomat> bankomatCollection )
    {
        this.bankomatCollection = bankomatCollection;
    }

    @XmlTransient
    public Collection<Klient> getKlientCollection()
    {
        return klientCollection;
    }

    public void setKlientCollection( Collection<Klient> klientCollection )
    {
        this.klientCollection = klientCollection;
    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        hash += ( idAdresu != null ? idAdresu.hashCode() : 0 );
        return hash;
    }

    @Override
    public boolean equals( Object object )
    {
        // TODO: Warning - this method won't work in the case the id fields are
        // not set
        if ( !( object instanceof Adres ) )
        {
            return false;
        }
        Adres other = (Adres) object;
        if ( ( this.idAdresu == null && other.idAdresu != null )
             || ( this.idAdresu != null && !this.idAdresu.equals( other.idAdresu ) ) )
        {
            return false;
        }
        return true;
    }

    @Override
    public String toString()
    {
        return "pl.edu.wat.swp.model.Adres[ idAdresu=" + idAdresu + " ]";
    }

}
