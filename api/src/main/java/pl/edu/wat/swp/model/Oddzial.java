package pl.edu.wat.swp.model;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
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
@Table( name = "oddzial" )
@XmlRootElement
@NamedQueries( {
        @NamedQuery( name = "Oddzial.findAll", query = "SELECT o FROM Oddzial o" ),
        @NamedQuery( name = "Oddzial.findByCwb", query = "SELECT o FROM Oddzial o WHERE o.oddzialPK.cwb = :cwb" ),
        @NamedQuery( name = "Oddzial.findByIdOddzialu", query = "SELECT o FROM Oddzial o WHERE o.oddzialPK.idOddzialu = :idOddzialu" ),
        @NamedQuery( name = "Oddzial.findByNazwaOddzialu", query = "SELECT o FROM Oddzial o WHERE o.nazwaOddzialu = :nazwaOddzialu" ),
        @NamedQuery( name = "Oddzial.findBySiedziba", query = "SELECT o FROM Oddzial o WHERE o.siedziba = :siedziba" ) } )
public class Oddzial implements Serializable
{
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected OddzialPK oddzialPK;
    @Size( max = 40 )
    @Column( name = "NazwaOddzialu" )
    private String nazwaOddzialu;
    @Size( max = 30 )
    @Column( name = "Siedziba" )
    private String siedziba;
    @JoinColumn( name = "IdAdresu", referencedColumnName = "IdAdresu" )
    @ManyToOne( fetch = FetchType.LAZY )
    private Adres idAdresu;
    @JoinColumn( name = "CWB", referencedColumnName = "CWB", insertable = false, updatable = false )
    @ManyToOne( optional = false, fetch = FetchType.LAZY )
    private Bank bank;
    @OneToMany( mappedBy = "oddzial", fetch = FetchType.LAZY )
    private Collection<Bankomat> bankomatCollection;
    @OneToMany( mappedBy = "oddzial", fetch = FetchType.LAZY )
    private Collection<Oferta> ofertaCollection;
    @OneToMany( cascade = CascadeType.ALL, mappedBy = "oddzial", fetch = FetchType.LAZY )
    private Collection<Kontobankowe> kontobankoweCollection;

    public Oddzial()
    {
    }

    public Oddzial( OddzialPK oddzialPK )
    {
        this.oddzialPK = oddzialPK;
    }

    public Oddzial( String cwb, int idOddzialu )
    {
        this.oddzialPK = new OddzialPK( cwb, idOddzialu );
    }

    public OddzialPK getOddzialPK()
    {
        return oddzialPK;
    }

    public void setOddzialPK( OddzialPK oddzialPK )
    {
        this.oddzialPK = oddzialPK;
    }

    public String getNazwaOddzialu()
    {
        return nazwaOddzialu;
    }

    public void setNazwaOddzialu( String nazwaOddzialu )
    {
        this.nazwaOddzialu = nazwaOddzialu;
    }

    public String getSiedziba()
    {
        return siedziba;
    }

    public void setSiedziba( String siedziba )
    {
        this.siedziba = siedziba;
    }

    public Adres getIdAdresu()
    {
        return idAdresu;
    }

    public void setIdAdresu( Adres idAdresu )
    {
        this.idAdresu = idAdresu;
    }

    public Bank getBank()
    {
        return bank;
    }

    public void setBank( Bank bank )
    {
        this.bank = bank;
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
    public Collection<Oferta> getOfertaCollection()
    {
        return ofertaCollection;
    }

    public void setOfertaCollection( Collection<Oferta> ofertaCollection )
    {
        this.ofertaCollection = ofertaCollection;
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

    @Override
    public int hashCode()
    {
        int hash = 0;
        hash += ( oddzialPK != null ? oddzialPK.hashCode() : 0 );
        return hash;
    }

    @Override
    public boolean equals( Object object )
    {
        // TODO: Warning - this method won't work in the case the id fields are
        // not set
        if ( !( object instanceof Oddzial ) )
        {
            return false;
        }
        Oddzial other = (Oddzial) object;
        if ( ( this.oddzialPK == null && other.oddzialPK != null )
             || ( this.oddzialPK != null && !this.oddzialPK.equals( other.oddzialPK ) ) )
        {
            return false;
        }
        return true;
    }

    @Override
    public String toString()
    {
        return "pl.edu.wat.swp.model.Oddzial[ oddzialPK=" + oddzialPK + " ]";
    }

}
