package pl.edu.wat.swp.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * 
 * @author: Krzysztof Jedynak @email: (jedynakpoczta@gmail.com)
 * @date: 7 gru 2014
 * 
 */

@Entity
@Table( name = "Oferta" )
@XmlRootElement
@NamedQueries( { @NamedQuery( name = "Oferta.findAll", query = "SELECT o FROM Oferta o" ),
        @NamedQuery( name = "Oferta.findByIdOferty", query = "SELECT o FROM Oferta o WHERE o.idOferty = :idOferty" ),
        @NamedQuery( name = "Oferta.findByOpis", query = "SELECT o FROM Oferta o WHERE o.opis = :opis" ),
        @NamedQuery( name = "Oferta.findByDataOd", query = "SELECT o FROM Oferta o WHERE o.dataOd = :dataOd" ),
        @NamedQuery( name = "Oferta.findByDataDo", query = "SELECT o FROM Oferta o WHERE o.dataDo = :dataDo" ) } )
public class Oferta implements Serializable
{
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue( strategy = GenerationType.AUTO )
    @Column( name = "IdOferty" )
    private Integer idOferty;
    @Size( max = 100 )
    @Column( name = "Opis" )
    private String opis;
    @Column( name = "DataOd" )
    @Temporal( TemporalType.DATE )
    private Date dataOd;
    @Column( name = "DataDo" )
    @Temporal( TemporalType.DATE )
    private Date dataDo;
    @JoinColumns( { @JoinColumn( name = "CWB", referencedColumnName = "CWB" ),
            @JoinColumn( name = "IdOddzialu", referencedColumnName = "IdOddzialu" ) } )
    @ManyToOne( fetch = FetchType.LAZY )
    private Oddzial oddzial;
    @JoinColumn( name = "IdTypOfer", referencedColumnName = "IdTypOfer" )
    @ManyToOne( fetch = FetchType.LAZY )
    private Typoferty idTypOfer;

    public Oferta()
    {
    }

    public Oferta( Integer idOferty )
    {
        this.idOferty = idOferty;
    }

    public Integer getIdOferty()
    {
        return idOferty;
    }

    public void setIdOferty( Integer idOferty )
    {
        this.idOferty = idOferty;
    }

    public String getOpis()
    {
        return opis;
    }

    public void setOpis( String opis )
    {
        this.opis = opis;
    }

    public Date getDataOd()
    {
        return dataOd;
    }

    public void setDataOd( Date dataOd )
    {
        this.dataOd = dataOd;
    }

    public Date getDataDo()
    {
        return dataDo;
    }

    public void setDataDo( Date dataDo )
    {
        this.dataDo = dataDo;
    }

    public Oddzial getOddzial()
    {
        return oddzial;
    }

    public void setOddzial( Oddzial oddzial )
    {
        this.oddzial = oddzial;
    }

    public Typoferty getIdTypOfer()
    {
        return idTypOfer;
    }

    public void setIdTypOfer( Typoferty idTypOfer )
    {
        this.idTypOfer = idTypOfer;
    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        hash += ( idOferty != null ? idOferty.hashCode() : 0 );
        return hash;
    }

    @Override
    public boolean equals( Object object )
    {
        // TODO: Warning - this method won't work in the case the id fields are
        // not set
        if ( !( object instanceof Oferta ) )
        {
            return false;
        }
        Oferta other = (Oferta) object;
        if ( ( this.idOferty == null && other.idOferty != null )
             || ( this.idOferty != null && !this.idOferty.equals( other.idOferty ) ) )
        {
            return false;
        }
        return true;
    }

    @Override
    public String toString()
    {
        return "pl.edu.wat.swp.model.Oferta[ idOferty=" + idOferty + " ]";
    }

}
