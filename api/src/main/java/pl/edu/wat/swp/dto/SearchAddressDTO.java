package pl.edu.wat.swp.dto;

/**
 * 
 * @author Krzysztof Jedynak @email jedynakpoczta@gmail.com
 * @date 21 sty 2015
 */
public class SearchAddressDTO
{
    private String type;
    private String city;
    private String district;

    public String getType()
    {
        return type;
    }

    public void setType( String type )
    {
        this.type = type;
    }

    public String getCity()
    {
        return city;
    }

    public void setCity( String city )
    {
        this.city = city;
    }

    public String getDistrict()
    {
        return district;
    }

    public void setDistrict( String district )
    {
        this.district = district;
    }

}
