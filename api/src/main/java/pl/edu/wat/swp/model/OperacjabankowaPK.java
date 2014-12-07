package pl.edu.wat.swp.model;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 * 
 * @author: Krzysztof Jedynak @email: (jedynakpoczta@gmail.com)
 * @date: 7 gru 2014
 * 
 */

@Embeddable
public class OperacjabankowaPK implements Serializable
{
    @Basic( optional = false )
    @NotNull
    @Column( name = "IdRO" )
    private int idRO;
    @Basic( optional = false )
    @NotNull
    @Column( name = "IdOB" )
    private int idOB;

    public OperacjabankowaPK()
    {
    }

    public OperacjabankowaPK( int idRO, int idOB )
    {
        this.idRO = idRO;
        this.idOB = idOB;
    }

    public int getIdRO()
    {
        return idRO;
    }

    public void setIdRO( int idRO )
    {
        this.idRO = idRO;
    }

    public int getIdOB()
    {
        return idOB;
    }

    public void setIdOB( int idOB )
    {
        this.idOB = idOB;
    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        hash += (int) idRO;
        hash += (int) idOB;
        return hash;
    }

    @Override
    public boolean equals( Object object )
    {
        // TODO: Warning - this method won't work in the case the id fields are
        // not set
        if ( !( object instanceof OperacjabankowaPK ) )
        {
            return false;
        }
        OperacjabankowaPK other = (OperacjabankowaPK) object;
        if ( this.idRO != other.idRO )
        {
            return false;
        }
        if ( this.idOB != other.idOB )
        {
            return false;
        }
        return true;
    }

    @Override
    public String toString()
    {
        return "pl.edu.wat.swp.model.OperacjabankowaPK[ idRO=" + idRO + ", idOB=" + idOB + " ]";
    }

}
