//package pl.edu.wat.swp.model;
//
//import java.io.Serializable;
//
//import javax.persistence.Basic;
//import javax.persistence.Column;
//import javax.persistence.Embeddable;
//import javax.validation.constraints.NotNull;
//import javax.validation.constraints.Size;
//
///**
// * 
// * @author: Krzysztof Jedynak @email: (jedynakpoczta@gmail.com)
// * @date: 7 gru 2014
// * 
// */
//
//@Embeddable
//public class SubkontoPK implements Serializable
//{
//    @Basic( optional = false )
//    @NotNull
//    @Size( min = 1, max = 8 )
//    @Column( name = "CIF" )
//    private String cif;
//    @Basic( optional = false )
//    @NotNull
//    @Size( min = 1, max = 26 )
//    @Column( name = "NRSK" )
//    private String nrsk;
//
//    public SubkontoPK()
//    {
//    }
//
//    public SubkontoPK( String cif, String nrsk )
//    {
//        this.cif = cif;
//        this.nrsk = nrsk;
//    }
//
//    public String getCif()
//    {
//        return cif;
//    }
//
//    public void setCif( String cif )
//    {
//        this.cif = cif;
//    }
//
//    public String getNrsk()
//    {
//        return nrsk;
//    }
//
//    public void setNrsk( String nrsk )
//    {
//        this.nrsk = nrsk;
//    }
//
//    @Override
//    public int hashCode()
//    {
//        int hash = 0;
//        hash += ( cif != null ? cif.hashCode() : 0 );
//        hash += ( nrsk != null ? nrsk.hashCode() : 0 );
//        return hash;
//    }
//
//    @Override
//    public boolean equals( Object object )
//    {
//        // TODO: Warning - this method won't work in the case the id fields are
//        // not set
//        if ( !( object instanceof SubkontoPK ) )
//        {
//            return false;
//        }
//        SubkontoPK other = (SubkontoPK) object;
//        if ( ( this.cif == null && other.cif != null ) || ( this.cif != null && !this.cif.equals( other.cif ) ) )
//        {
//            return false;
//        }
//        if ( ( this.nrsk == null && other.nrsk != null ) || ( this.nrsk != null && !this.nrsk.equals( other.nrsk ) ) )
//        {
//            return false;
//        }
//        return true;
//    }
//
//    @Override
//    public String toString()
//    {
//        return "pl.edu.wat.swp.model.SubkontoPK[ cif=" + cif + ", nrsk=" + nrsk + " ]";
//    }
//
//}
