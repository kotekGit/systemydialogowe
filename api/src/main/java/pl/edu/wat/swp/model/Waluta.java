package pl.edu.wat.swp.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table( name = "Waluta" )
@XmlRootElement
@NamedQueries( {
        @NamedQuery( name = "Waluta.findAll", query = "SELECT w FROM Waluta w" ),
        @NamedQuery( name = "Waluta.findByIdWaluty", query = "SELECT w FROM Waluta w WHERE w.idWaluty = :idWaluty" ),
        @NamedQuery( name = "Waluta.findByNazwaWaluty", query = "SELECT w FROM Waluta w WHERE w.nazwaWaluty = :nazwaWaluty" ),
        @NamedQuery( name = "Waluta.findByKursWaluty", query = "SELECT w FROM Waluta w WHERE w.kursWaluty = :kursWaluty" ) } )
public class Waluta implements Serializable
{
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue( strategy = GenerationType.AUTO )
    @Column( name = "IdWaluty" )
    private Integer idWaluty;
    @Size( max = 30 )
    @Column( name = "NazwaWaluty" )
    private String nazwaWaluty;
    // @Max(value=?) @Min(value=?)//if you know range of your decimal fields
    // consider using these annotations to enforce field validation
    @Column( name = "KursWaluty" )
    private BigDecimal kursWaluty;
    @OneToMany( cascade = CascadeType.ALL, mappedBy = "idWaluty", fetch = FetchType.LAZY )
    private Collection<Subkonto> subkontoCollection;

    public Waluta()
    {
    }

    public Waluta( Integer idWaluty )
    {
        this.idWaluty = idWaluty;
    }

    public Integer getIdWaluty()
    {
        return idWaluty;
    }

    public void setIdWaluty( Integer idWaluty )
    {
        this.idWaluty = idWaluty;
    }

    public String getNazwaWaluty()
    {
        return nazwaWaluty;
    }

    public void setNazwaWaluty( String nazwaWaluty )
    {
        this.nazwaWaluty = nazwaWaluty;
    }

    public BigDecimal getKursWaluty()
    {
        return kursWaluty;
    }

    public void setKursWaluty( BigDecimal kursWaluty )
    {
        this.kursWaluty = kursWaluty;
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

    @Override
    public int hashCode()
    {
        int hash = 0;
        hash += ( idWaluty != null ? idWaluty.hashCode() : 0 );
        return hash;
    }

    @Override
    public boolean equals( Object object )
    {
        // TODO: Warning - this method won't work in the case the id fields are
        // not set
        if ( !( object instanceof Waluta ) )
        {
            return false;
        }
        Waluta other = (Waluta) object;
        if ( ( this.idWaluty == null && other.idWaluty != null )
             || ( this.idWaluty != null && !this.idWaluty.equals( other.idWaluty ) ) )
        {
            return false;
        }
        return true;
    }

    @Override
    public String toString()
    {
        return "pl.edu.wat.swp.model.Waluta[ idWaluty=" + idWaluty + " ]";
    }

}
