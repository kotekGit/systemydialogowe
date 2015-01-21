package pl.edu.wat.swp.dto;

import pl.edu.wat.swp.model.Adres;

/**
 * 
 * @author Krzysztof Jedynak @email jedynakpoczta@gmail.com
 * @date 21 sty 2015
 */
public class AddressDTO
{

    private Integer id;
    private String city;
    private String postalCode;
    private String post;
    private String street;
    private String buildingNo;
    private String localNo;
    private String district;
    private String type;

    public AddressDTO()
    {

    }

    public AddressDTO( Adres adres, String addressType )
    {
        this.id = adres.getIdAdresu();
        this.city = adres.getMiejscowosc();
        this.postalCode = adres.getKodPocztowy();
        this.post = adres.getPoczta();
        this.street = adres.getUlica();
        this.buildingNo = adres.getNrBudynku();
        this.localNo = adres.getNrLokalu();
        this.district = adres.getDzielnica();
        this.type = addressType;

    }

    public Integer getId()
    {
        return id;
    }

    public void setId( Integer id )
    {
        this.id = id;
    }

    public String getCity()
    {
        return city;
    }

    public void setCity( String city )
    {
        this.city = city;
    }

    public String getPostalCode()
    {
        return postalCode;
    }

    public void setPostalCode( String postalCode )
    {
        this.postalCode = postalCode;
    }

    public String getPost()
    {
        return post;
    }

    public void setPost( String post )
    {
        this.post = post;
    }

    public String getStreet()
    {
        return street;
    }

    public void setStreet( String street )
    {
        this.street = street;
    }

    public String getBuildingNo()
    {
        return buildingNo;
    }

    public void setBuildingNo( String buildingNo )
    {
        this.buildingNo = buildingNo;
    }

    public String getLocalNo()
    {
        return localNo;
    }

    public void setLocalNo( String localNo )
    {
        this.localNo = localNo;
    }

    public String getDistrict()
    {
        return district;
    }

    public void setDistrict( String district )
    {
        this.district = district;
    }

    public String getType()
    {
        return type;
    }

    public void setType( String type )
    {
        this.type = type;
    }

}
