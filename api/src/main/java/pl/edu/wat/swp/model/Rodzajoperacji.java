package pl.edu.wat.swp.model;

import java.io.Serializable;
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
@Table( name = "RodzajOperacji" )
@XmlRootElement
@NamedQueries( {
        @NamedQuery( name = "Rodzajoperacji.findAll", query = "SELECT r FROM Rodzajoperacji r" ),
        @NamedQuery( name = "Rodzajoperacji.findByIdRO", query = "SELECT r FROM Rodzajoperacji r WHERE r.idRO = :idRO" ),
        @NamedQuery( name = "Rodzajoperacji.findByNazwaRO", query = "SELECT r FROM Rodzajoperacji r WHERE r.nazwaRO = :nazwaRO" ) } )
public class Rodzajoperacji implements Serializable
{
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue( strategy = GenerationType.AUTO )
    @Column( name = "IdRO" )
    private Integer idRO;
    @Size( max = 30 )
    @Column( name = "NazwaRO" )
    private String nazwaRO;
    @OneToMany( cascade = CascadeType.ALL, mappedBy = "rodzajoperacji", fetch = FetchType.LAZY )
    private Collection<Operacjabankowa> operacjabankowaCollection;

    public Rodzajoperacji()
    {
    }

    public Rodzajoperacji( Integer idRO )
    {
        this.idRO = idRO;
    }

    public Integer getIdRO()
    {
        return idRO;
    }

    public void setIdRO( Integer idRO )
    {
        this.idRO = idRO;
    }

    public String getNazwaRO()
    {
        return nazwaRO;
    }

    public void setNazwaRO( String nazwaRO )
    {
        this.nazwaRO = nazwaRO;
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
        hash += ( idRO != null ? idRO.hashCode() : 0 );
        return hash;
    }

    @Override
    public boolean equals( Object object )
    {
        // TODO: Warning - this method won't work in the case the id fields are
        // not set
        if ( !( object instanceof Rodzajoperacji ) )
        {
            return false;
        }
        Rodzajoperacji other = (Rodzajoperacji) object;
        if ( ( this.idRO == null && other.idRO != null ) || ( this.idRO != null && !this.idRO.equals( other.idRO ) ) )
        {
            return false;
        }
        return true;
    }

    @Override
    public String toString()
    {
        return "pl.edu.wat.swp.model.Rodzajoperacji[ idRO=" + idRO + " ]";
    }

}
