package pl.edu.wat.swp.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
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
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * 
 * @author: Krzysztof Jedynak @email: (jedynakpoczta@gmail.com)
 * @date: 7 gru 2014
 * 
 */

@Entity
@Table( name = "OperacjaBankowa" )
@XmlRootElement
/*@NamedQueries( {
        @NamedQuery( name = "Operacjabankowa.findAll", query = "SELECT o FROM Operacjabankowa o" ),
        @NamedQuery( name = "Operacjabankowa.findByIdRO", query = "SELECT o FROM Operacjabankowa o WHERE o.operacjabankowaPK.idRO = :idRO" ),
        @NamedQuery( name = "Operacjabankowa.findByIdOB", query = "SELECT o FROM Operacjabankowa o WHERE o.operacjabankowaPK.idOB = :idOB" ),
        @NamedQuery( name = "Operacjabankowa.findByKwotaOB", query = "SELECT o FROM Operacjabankowa o WHERE o.kwotaOB = :kwotaOB" ),
        @NamedQuery( name = "Operacjabankowa.findByDataOB", query = "SELECT o FROM Operacjabankowa o WHERE o.dataOB = :dataOB" ) } )*/
public class Operacjabankowa implements Serializable
{
    private static final long serialVersionUID = 1L;
    /*    @EmbeddedId
        protected OperacjabankowaPK operacjabankowaPK;*/

    @Id
    @GeneratedValue( strategy = GenerationType.AUTO )
    @Column( name = "IdOB" )
    private Integer idOB;

    // @Max(value=?) @Min(value=?)//if you know range of your decimal fields
    // consider using these annotations to enforce field validation
    @Column( name = "KwotaOB" )
    private BigDecimal kwotaOB;
    @Column( name = "DataOB" )
    @Temporal( TemporalType.TIMESTAMP )
    private Date dataOB;
    @JoinColumn( name = "PESEL", referencedColumnName = "PESEL" )
    @ManyToOne( fetch = FetchType.LAZY )
    private Pracownik pesel;
    @JoinColumn( name = "NIK", referencedColumnName = "NIK" )
    @ManyToOne( fetch = FetchType.LAZY )
    private Klient nik;
    @JoinColumns( { @JoinColumn( name = "Sub_CIF", referencedColumnName = "CIF" ),
            @JoinColumn( name = "NRSK", referencedColumnName = "NRSK" ) } )
    @ManyToOne( fetch = FetchType.LAZY )
    private Subkonto subkonto;
    @JoinColumns( { @JoinColumn( name = "CIF", referencedColumnName = "CIF" ),
            @JoinColumn( name = "Sub_NRSK", referencedColumnName = "NRSK" ) } )
    @ManyToOne( optional = false, fetch = FetchType.LAZY )
    private Subkonto subkonto1;
    @JoinColumn( name = "IdRO", referencedColumnName = "IdRO", insertable = false, updatable = false )
    @ManyToOne( fetch = FetchType.LAZY )
    private Rodzajoperacji rodzajoperacji;

    public Operacjabankowa()
    {
    }

    /* public Operacjabankowa( OperacjabankowaPK operacjabankowaPK )
     {
         this.operacjabankowaPK = operacjabankowaPK;
     }

     public Operacjabankowa( OperacjabankowaPK operacjabankowaPK, Date dataOB )
     {
         this.operacjabankowaPK = operacjabankowaPK;
         this.dataOB = dataOB;
     }

     public Operacjabankowa( int idRO, int idOB )
     {
         this.operacjabankowaPK = new OperacjabankowaPK( idRO, idOB );
     }

     public OperacjabankowaPK getOperacjabankowaPK()
     {
         return operacjabankowaPK;
     }

     public void setOperacjabankowaPK( OperacjabankowaPK operacjabankowaPK )
     {
         this.operacjabankowaPK = operacjabankowaPK;
     }*/

    public Integer getIdOB()
    {
        return idOB;
    }

    public void setIdOB( Integer idOB )
    {
        this.idOB = idOB;
    }

    public BigDecimal getKwotaOB()
    {
        return kwotaOB;
    }

    public void setKwotaOB( BigDecimal kwotaOB )
    {
        this.kwotaOB = kwotaOB;
    }

    public Date getDataOB()
    {
        return dataOB;
    }

    public void setDataOB( Date dataOB )
    {
        this.dataOB = dataOB;
    }

    public Pracownik getPesel()
    {
        return pesel;
    }

    public void setPesel( Pracownik pesel )
    {
        this.pesel = pesel;
    }

    public Klient getNik()
    {
        return nik;
    }

    public void setNik( Klient nik )
    {
        this.nik = nik;
    }

    public Subkonto getSubkonto()
    {
        return subkonto;
    }

    public void setSubkonto( Subkonto subkonto )
    {
        this.subkonto = subkonto;
    }

    public Subkonto getSubkonto1()
    {
        return subkonto1;
    }

    public void setSubkonto1( Subkonto subkonto1 )
    {
        this.subkonto1 = subkonto1;
    }

    public Rodzajoperacji getRodzajoperacji()
    {
        return rodzajoperacji;
    }

    public void setRodzajoperacji( Rodzajoperacji rodzajoperacji )
    {
        this.rodzajoperacji = rodzajoperacji;
    }

    /*    @Override
        public int hashCode()
        {
            int hash = 0;
            hash += ( operacjabankowaPK != null ? operacjabankowaPK.hashCode() : 0 );
            return hash;
        }

        @Override
        public boolean equals( Object object )
        {
            // TODO: Warning - this method won't work in the case the id fields are
            // not set
            if ( !( object instanceof Operacjabankowa ) )
            {
                return false;
            }
            Operacjabankowa other = (Operacjabankowa) object;
            if ( ( this.operacjabankowaPK == null && other.operacjabankowaPK != null )
                 || ( this.operacjabankowaPK != null && !this.operacjabankowaPK.equals( other.operacjabankowaPK ) ) )
            {
                return false;
            }
            return true;
        }

        @Override
        public String toString()
        {
            return "pl.edu.wat.swp.model.Operacjabankowa[ operacjabankowaPK=" + operacjabankowaPK + " ]";
        }*/

}
