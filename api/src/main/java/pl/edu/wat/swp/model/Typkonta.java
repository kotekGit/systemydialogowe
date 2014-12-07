package pl.edu.wat.swp.model;

import java.io.Serializable;
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
@Table( name = "typkonta" )
@XmlRootElement
@NamedQueries( {
        @NamedQuery( name = "Typkonta.findAll", query = "SELECT t FROM Typkonta t" ),
        @NamedQuery( name = "Typkonta.findByIdTypuKonta", query = "SELECT t FROM Typkonta t WHERE t.idTypuKonta = :idTypuKonta" ),
        @NamedQuery( name = "Typkonta.findByNazwaKonta", query = "SELECT t FROM Typkonta t WHERE t.nazwaKonta = :nazwaKonta" ) } )
public class Typkonta implements Serializable
{
    private static final long serialVersionUID = 1L;
    @Id
    @Basic( optional = false )
    @NotNull
    @Column( name = "IdTypuKonta" )
    private Integer idTypuKonta;
    @Size( max = 40 )
    @Column( name = "NazwaKonta" )
    private String nazwaKonta;
    @OneToMany( cascade = CascadeType.ALL, mappedBy = "idTypuKonta", fetch = FetchType.LAZY )
    private Collection<Subkonto> subkontoCollection;

    public Typkonta()
    {
    }

    public Typkonta( Integer idTypuKonta )
    {
        this.idTypuKonta = idTypuKonta;
    }

    public Integer getIdTypuKonta()
    {
        return idTypuKonta;
    }

    public void setIdTypuKonta( Integer idTypuKonta )
    {
        this.idTypuKonta = idTypuKonta;
    }

    public String getNazwaKonta()
    {
        return nazwaKonta;
    }

    public void setNazwaKonta( String nazwaKonta )
    {
        this.nazwaKonta = nazwaKonta;
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
        hash += ( idTypuKonta != null ? idTypuKonta.hashCode() : 0 );
        return hash;
    }

    @Override
    public boolean equals( Object object )
    {
        // TODO: Warning - this method won't work in the case the id fields are
        // not set
        if ( !( object instanceof Typkonta ) )
        {
            return false;
        }
        Typkonta other = (Typkonta) object;
        if ( ( this.idTypuKonta == null && other.idTypuKonta != null )
             || ( this.idTypuKonta != null && !this.idTypuKonta.equals( other.idTypuKonta ) ) )
        {
            return false;
        }
        return true;
    }

    @Override
    public String toString()
    {
        return "pl.edu.wat.swp.model.Typkonta[ idTypuKonta=" + idTypuKonta + " ]";
    }

}
