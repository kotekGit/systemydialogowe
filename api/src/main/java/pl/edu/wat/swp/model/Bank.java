package pl.edu.wat.swp.model;

import java.io.Serializable;
import java.util.Collection;

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
@Table( name = "Bank" )
@XmlRootElement
@NamedQueries( {
        @NamedQuery( name = "Bank.findAll", query = "SELECT b FROM Bank b" ),
        @NamedQuery( name = "Bank.findByCwb", query = "SELECT b FROM Bank b WHERE b.cwb = :cwb" ),
        @NamedQuery( name = "Bank.findByNazwaBanku", query = "SELECT b FROM Bank b WHERE b.nazwaBanku = :nazwaBanku" ),
        @NamedQuery( name = "Bank.findByRodzajBanku", query = "SELECT b FROM Bank b WHERE b.rodzajBanku = :rodzajBanku" ) } )
public class Bank implements Serializable
{
    private static final long serialVersionUID = 1L;

    @Id
    @NotNull
    @Size( min = 1, max = 4 )
    @Column( name = "CWB" )
    private String cwb;
    @Size( max = 40 )
    @Column( name = "NazwaBanku" )
    private String nazwaBanku;
    @Size( max = 30 )
    @Column( name = "RodzajBanku" )
    private String rodzajBanku;
    @OneToMany( cascade = CascadeType.ALL, mappedBy = "bank", fetch = FetchType.LAZY )
    private Collection<Oddzial> oddzialCollection;

    public Bank()
    {
    }

    public Bank( String cwb )
    {
        this.cwb = cwb;
    }

    public String getCwb()
    {
        return cwb;
    }

    public void setCwb( String cwb )
    {
        this.cwb = cwb;
    }

    public String getNazwaBanku()
    {
        return nazwaBanku;
    }

    public void setNazwaBanku( String nazwaBanku )
    {
        this.nazwaBanku = nazwaBanku;
    }

    public String getRodzajBanku()
    {
        return rodzajBanku;
    }

    public void setRodzajBanku( String rodzajBanku )
    {
        this.rodzajBanku = rodzajBanku;
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

    @Override
    public int hashCode()
    {
        int hash = 0;
        hash += ( cwb != null ? cwb.hashCode() : 0 );
        return hash;
    }

    @Override
    public boolean equals( Object object )
    {
        // TODO: Warning - this method won't work in the case the id fields are
        // not set
        if ( !( object instanceof Bank ) )
        {
            return false;
        }
        Bank other = (Bank) object;
        if ( ( this.cwb == null && other.cwb != null ) || ( this.cwb != null && !this.cwb.equals( other.cwb ) ) )
        {
            return false;
        }
        return true;
    }

    @Override
    public String toString()
    {
        return "pl.edu.wat.swp.model.Bank[ cwb=" + cwb + " ]";
    }

}
