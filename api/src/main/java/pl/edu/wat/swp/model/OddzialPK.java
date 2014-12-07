package pl.edu.wat.swp.model;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * 
 * @author: Krzysztof Jedynak @email: (jedynakpoczta@gmail.com)
 * @date: 7 gru 2014
 * 
 */

@Embeddable
public class OddzialPK implements Serializable
{
    @Basic( optional = false )
    @NotNull
    @Size( min = 1, max = 4 )
    @Column( name = "CWB" )
    private String cwb;
    @Basic( optional = false )
    @NotNull
    @Column( name = "IdOddzialu" )
    private int idOddzialu;

    public OddzialPK()
    {
    }

    public OddzialPK( String cwb, int idOddzialu )
    {
        this.cwb = cwb;
        this.idOddzialu = idOddzialu;
    }

    public String getCwb()
    {
        return cwb;
    }

    public void setCwb( String cwb )
    {
        this.cwb = cwb;
    }

    public int getIdOddzialu()
    {
        return idOddzialu;
    }

    public void setIdOddzialu( int idOddzialu )
    {
        this.idOddzialu = idOddzialu;
    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        hash += ( cwb != null ? cwb.hashCode() : 0 );
        hash += (int) idOddzialu;
        return hash;
    }

    @Override
    public boolean equals( Object object )
    {
        // TODO: Warning - this method won't work in the case the id fields are
        // not set
        if ( !( object instanceof OddzialPK ) )
        {
            return false;
        }
        OddzialPK other = (OddzialPK) object;
        if ( ( this.cwb == null && other.cwb != null ) || ( this.cwb != null && !this.cwb.equals( other.cwb ) ) )
        {
            return false;
        }
        if ( this.idOddzialu != other.idOddzialu )
        {
            return false;
        }
        return true;
    }

    @Override
    public String toString()
    {
        return "pl.edu.wat.swp.model.OddzialPK[ cwb=" + cwb + ", idOddzialu=" + idOddzialu + " ]";
    }

}
