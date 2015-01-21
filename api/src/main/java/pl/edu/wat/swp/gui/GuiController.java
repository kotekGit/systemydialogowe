package pl.edu.wat.swp.gui;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pl.edu.wat.swp.dto.AddressDTO;
import pl.edu.wat.swp.dto.SearchAddressDTO;
import pl.edu.wat.swp.managers.AccountManager;
import pl.edu.wat.swp.managers.OfferManager;
import pl.edu.wat.swp.managers.PlaceManager;

/**
 * 
 * @author Krzysztof Jedynak @email jedynakpoczta@gmail.com
 * @date 21 sty 2015
 */

@Controller
@RequestMapping( "/gui" )
public class GuiController
{
    @Autowired
    AccountManager accountManager;

    @Autowired
    OfferManager offerManager;

    @Autowired
    PlaceManager placeManager;

    @RequestMapping( "/users" )
    public String getUsers( Model model )
    {
        model.addAttribute( "users", accountManager.getAllUsersData() );
        return "users";
    }

    @RequestMapping( "/subaccounts" )
    public String getSubAccounts( Model model )
    {
        model.addAttribute( "subaccounts", accountManager.getAllSubAccountsData() );
        return "subaccounts";
    }

    @RequestMapping( "/offers" )
    public String getAllOffers( Model model )
    {
        model.addAttribute( "offers", offerManager.getAllOffer() );
        return "offers";
    }

    @RequestMapping( value = "/addresses", method = RequestMethod.GET )
    public String getAddreessesForCriteria( Model model )
    {
        model.addAttribute( "addressSearch", new SearchAddressDTO() );
        model.addAttribute( "addresses", new ArrayList<AddressDTO>() );
        this.getAddressTypeList( model );
        return "searchAddresses";
    }

    @RequestMapping( value = "/addresses", method = RequestMethod.POST )
    public String getAddreessesForCriteria( @ModelAttribute( "addressSearch" ) SearchAddressDTO searchAddressDTO,
            BindingResult addressBindingResult, Model model )
    {
        model.addAttribute(
                "addresses",
                placeManager.getPlacesForView( searchAddressDTO.getType(), searchAddressDTO.getCity(),
                        searchAddressDTO.getDistrict() ) );
        this.getAddressTypeList( model );
        return "searchAddresses";
    }

    private void getAddressTypeList( Model model )
    {
        HashMap<Integer, String> types = new HashMap<Integer, String>();
        types.put( 1, "Bankomat" );
        types.put( 2, "Placówka" );
        model.addAttribute( "types", types );
    }

}
