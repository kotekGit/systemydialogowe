package pl.edu.wat.swp.model;

import java.io.Serializable;
import java.math.BigDecimal;
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
@Table( name = "SubKonto" )
@XmlRootElement
@NamedQueries( {
        @NamedQuery( name = "Subkonto.findAll", query = "SELECT s FROM Subkonto s" ),
        @NamedQuery( name = "Subkonto.findByCif", query = "SELECT s FROM Subkonto s WHERE s.subkontoPK.cif = :cif" ),
        @NamedQuery( name = "Subkonto.findByNrsk", query = "SELECT s FROM Subkonto s WHERE s.subkontoPK.nrsk = :nrsk" ),
        @NamedQuery( name = "Subkonto.findByStanKonta", query = "SELECT s FROM Subkonto s WHERE s.stanKonta = :stanKonta" ),
        @NamedQuery( name = "Subkonto.findByStatus", query = "SELECT s FROM Subkonto s WHERE s.status = :status" ) } )
public class Subkonto implements Serializable
{
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected SubkontoPK subkontoPK;
    // @Max(value=?) @Min(value=?)//if you know range of your decimal fields
    // consider using these annotations to enforce field validation
    @Column( name = "StanKonta" )
    private BigDecimal stanKonta;
    @Size( max = 2 )
    @Column( name = "Status" )
    private String status;
    @JoinColumn( name = "IdWaluty", referencedColumnName = "IdWaluty" )
    @ManyToOne( optional = false, fetch = FetchType.LAZY )
    private Waluta idWaluty;
    @JoinColumn( name = "CIF", referencedColumnName = "CIF", insertable = false, updatable = false )
    @ManyToOne( optional = false, fetch = FetchType.LAZY )
    private Kontobankowe kontobankowe;
    @JoinColumn( name = "IdTypuKonta", referencedColumnName = "IdTypuKonta" )
    @ManyToOne( optional = false, fetch = FetchType.LAZY )
    private Typkonta idTypuKonta;
    @OneToMany( mappedBy = "subkonto", fetch = FetchType.LAZY )
    private Collection<Operacjabankowa> operacjabankowaCollection;
    @OneToMany( cascade = CascadeType.ALL, mappedBy = "subkonto1", fetch = FetchType.LAZY )
    private Collection<Operacjabankowa> operacjabankowaCollection1;

    public Subkonto()
    {
    }

    public Subkonto( SubkontoPK subkontoPK )
    {
        this.subkontoPK = subkontoPK;
    }

    public Subkonto( String cif, String nrsk )
    {
        this.subkontoPK = new SubkontoPK( cif, nrsk );
    }

    public SubkontoPK getSubkontoPK()
    {
        return subkontoPK;
    }

    public void setSubkontoPK( SubkontoPK subkontoPK )
    {
        this.subkontoPK = subkontoPK;
    }

    public BigDecimal getStanKonta()
    {
        return stanKonta;
    }

    public void setStanKonta( BigDecimal stanKonta )
    {
        this.stanKonta = stanKonta;
    }

    public String getStatus()
    {
        return status;
    }

    public void setStatus( String status )
    {
        this.status = status;
    }

    public Waluta getIdWaluty()
    {
        return idWaluty;
    }

    public void setIdWaluty( Waluta idWaluty )
    {
        this.idWaluty = idWaluty;
    }

    public Kontobankowe getKontobankowe()
    {
        return kontobankowe;
    }

    public void setKontobankowe( Kontobankowe kontobankowe )
    {
        this.kontobankowe = kontobankowe;
    }

    public Typkonta getIdTypuKonta()
    {
        return idTypuKonta;
    }

    public void setIdTypuKonta( Typkonta idTypuKonta )
    {
        this.idTypuKonta = idTypuKonta;
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

    @XmlTransient
    public Collection<Operacjabankowa> getOperacjabankowaCollection1()
    {
        return operacjabankowaCollection1;
    }

    public void setOperacjabankowaCollection1( Collection<Operacjabankowa> operacjabankowaCollection1 )
    {
        this.operacjabankowaCollection1 = operacjabankowaCollection1;
    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        hash += ( subkontoPK != null ? subkontoPK.hashCode() : 0 );
        return hash;
    }

    @Override
    public boolean equals( Object object )
    {
        // TODO: Warning - this method won't work in the case the id fields are
        // not set
        if ( !( object instanceof Subkonto ) )
        {
            return false;
        }
        Subkonto other = (Subkonto) object;
        if ( ( this.subkontoPK == null && other.subkontoPK != null )
             || ( this.subkontoPK != null && !this.subkontoPK.equals( other.subkontoPK ) ) )
        {
            return false;
        }
        return true;
    }

    @Override
    public String toString()
    {
        return "pl.edu.wat.swp.model.Subkonto[ subkontoPK=" + subkontoPK + " ]";
    }

}
