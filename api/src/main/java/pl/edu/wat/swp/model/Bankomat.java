package pl.edu.wat.swp.model;

import java.io.Serializable;

import javax.persistence.Basic;
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
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * 
 * @author: Krzysztof Jedynak @email: (jedynakpoczta@gmail.com)
 * @date: 7 gru 2014
 * 
 */

@Entity
@Table( name = "Bankomat" )
@XmlRootElement
@NamedQueries( {
        @NamedQuery( name = "Bankomat.findAll", query = "SELECT b FROM Bankomat b" ),
        @NamedQuery( name = "Bankomat.findByIdBankomatu", query = "SELECT b FROM Bankomat b WHERE b.idBankomatu = :idBankomatu" ) } )
public class Bankomat implements Serializable
{
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue( strategy = GenerationType.AUTO )
    @Column( name = "IdBankomatu" )
    private Integer idBankomatu;
    @JoinColumn( name = "IdAdresu", referencedColumnName = "IdAdresu" )
    @ManyToOne( fetch = FetchType.LAZY )
    private Adres idAdresu;
    @JoinColumns( { @JoinColumn( name = "CWB", referencedColumnName = "CWB" ),
            @JoinColumn( name = "IdOddzialu", referencedColumnName = "IdOddzialu" ) } )
    @ManyToOne( fetch = FetchType.LAZY )
    private Oddzial oddzial;

    public Bankomat()
    {
    }

    public Bankomat( Integer idBankomatu )
    {
        this.idBankomatu = idBankomatu;
    }

    public Integer getIdBankomatu()
    {
        return idBankomatu;
    }

    public void setIdBankomatu( Integer idBankomatu )
    {
        this.idBankomatu = idBankomatu;
    }

    public Adres getIdAdresu()
    {
        return idAdresu;
    }

    public void setIdAdresu( Adres idAdresu )
    {
        this.idAdresu = idAdresu;
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
        hash += ( idBankomatu != null ? idBankomatu.hashCode() : 0 );
        return hash;
    }

    @Override
    public boolean equals( Object object )
    {
        // TODO: Warning - this method won't work in the case the id fields are
        // not set
        if ( !( object instanceof Bankomat ) )
        {
            return false;
        }
        Bankomat other = (Bankomat) object;
        if ( ( this.idBankomatu == null && other.idBankomatu != null )
             || ( this.idBankomatu != null && !this.idBankomatu.equals( other.idBankomatu ) ) )
        {
            return false;
        }
        return true;
    }

    @Override
    public String toString()
    {
        return "pl.edu.wat.swp.model.Bankomat[ idBankomatu=" + idBankomatu + " ]";
    }

}
