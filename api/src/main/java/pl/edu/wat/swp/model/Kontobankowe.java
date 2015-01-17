package pl.edu.wat.swp.model;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
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
@Table( name = "KontoBankowe" )
@XmlRootElement
@NamedQueries( {
        @NamedQuery( name = "Kontobankowe.findAll", query = "SELECT k FROM Kontobankowe k" ),
        @NamedQuery( name = "Kontobankowe.findByCif", query = "SELECT k FROM Kontobankowe k WHERE k.cif = :cif" ),
        @NamedQuery( name = "Kontobankowe.findByDataUtworzenia", query = "SELECT k FROM Kontobankowe k WHERE k.dataUtworzenia = :dataUtworzenia" ) } )
public class Kontobankowe implements Serializable
{
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue( strategy = GenerationType.AUTO )
    @Size( min = 1, max = 8 )
    @Column( name = "CIF" )
    private String cif;
    @Column( name = "DataUtworzenia" )
    @Temporal( TemporalType.DATE )
    private Date dataUtworzenia;
    @ManyToMany( mappedBy = "kontobankoweCollection", fetch = FetchType.LAZY )
    private Collection<Klient> klientCollection;
    @OneToMany( cascade = CascadeType.ALL, mappedBy = "kontobankowe", fetch = FetchType.LAZY )
    private Collection<Subkonto> subkontoCollection;
    @JoinColumns( { @JoinColumn( name = "CWB", referencedColumnName = "CWB" ),
            @JoinColumn( name = "IdOddzialu", referencedColumnName = "IdOddzialu" ) } )
    @ManyToOne( optional = false, fetch = FetchType.LAZY )
    private Oddzial oddzial;

    public Kontobankowe()
    {
    }

    public Kontobankowe( String cif )
    {
        this.cif = cif;
    }

    public String getCif()
    {
        return cif;
    }

    public void setCif( String cif )
    {
        this.cif = cif;
    }

    public Date getDataUtworzenia()
    {
        return dataUtworzenia;
    }

    public void setDataUtworzenia( Date dataUtworzenia )
    {
        this.dataUtworzenia = dataUtworzenia;
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

    @XmlTransient
    public Collection<Subkonto> getSubkontoCollection()
    {
        return subkontoCollection;
    }

    public void setSubkontoCollection( Collection<Subkonto> subkontoCollection )
    {
        this.subkontoCollection = subkontoCollection;
    }

    public Oddzial getOddzial()
    {
        return oddzial;
    }

    public void setOddzial( Oddzial oddzial )
    {
        this.oddzial = oddzial;
    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        hash += ( cif != null ? cif.hashCode() : 0 );
        return hash;
    }

    @Override
    public boolean equals( Object object )
    {
        // TODO: Warning - this method won't work in the case the id fields are
        // not set
        if ( !( object instanceof Kontobankowe ) )
        {
            return false;
        }
        Kontobankowe other = (Kontobankowe) object;
        if ( ( this.cif == null && other.cif != null ) || ( this.cif != null && !this.cif.equals( other.cif ) ) )
        {
            return false;
        }
        return true;
    }

    @Override
    public String toString()
    {
        return "pl.edu.wat.swp.model.Kontobankowe[ cif=" + cif + " ]";
    }

}
