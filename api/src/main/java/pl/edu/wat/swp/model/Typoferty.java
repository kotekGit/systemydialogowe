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
@Table( name = "typoferty" )
@XmlRootElement
@NamedQueries( {
        @NamedQuery( name = "Typoferty.findAll", query = "SELECT t FROM Typoferty t" ),
        @NamedQuery( name = "Typoferty.findByIdTypOfer", query = "SELECT t FROM Typoferty t WHERE t.idTypOfer = :idTypOfer" ),
        @NamedQuery( name = "Typoferty.findByNazwa", query = "SELECT t FROM Typoferty t WHERE t.nazwa = :nazwa" ),
        @NamedQuery( name = "Typoferty.findByOpis", query = "SELECT t FROM Typoferty t WHERE t.opis = :opis" ) } )
public class Typoferty implements Serializable
{
    private static final long serialVersionUID = 1L;
    @Id
    @Basic( optional = false )
    @NotNull
    @Column( name = "IdTypOfer" )
    private Integer idTypOfer;
    @Size( max = 20 )
    @Column( name = "Nazwa" )
    private String nazwa;
    @Size( max = 100 )
    @Column( name = "Opis" )
    private String opis;
    @OneToMany( mappedBy = "idTypOfer", fetch = FetchType.LAZY )
    private Collection<Oferta> ofertaCollection;

    public Typoferty()
    {
    }

    public Typoferty( Integer idTypOfer )
    {
        this.idTypOfer = idTypOfer;
    }

    public Integer getIdTypOfer()
    {
        return idTypOfer;
    }

    public void setIdTypOfer( Integer idTypOfer )
    {
        this.idTypOfer = idTypOfer;
    }

    public String getNazwa()
    {
        return nazwa;
    }

    public void setNazwa( String nazwa )
    {
        this.nazwa = nazwa;
    }

    public String getOpis()
    {
        return opis;
    }

    public void setOpis( String opis )
    {
        this.opis = opis;
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

    @Override
    public int hashCode()
    {
        int hash = 0;
        hash += ( idTypOfer != null ? idTypOfer.hashCode() : 0 );
        return hash;
    }

    @Override
    public boolean equals( Object object )
    {
        // TODO: Warning - this method won't work in the case the id fields are
        // not set
        if ( !( object instanceof Typoferty ) )
        {
            return false;
        }
        Typoferty other = (Typoferty) object;
        if ( ( this.idTypOfer == null && other.idTypOfer != null )
             || ( this.idTypOfer != null && !this.idTypOfer.equals( other.idTypOfer ) ) )
        {
            return false;
        }
        return true;
    }

    @Override
    public String toString()
    {
        return "pl.edu.wat.swp.model.Typoferty[ idTypOfer=" + idTypOfer + " ]";
    }

}
