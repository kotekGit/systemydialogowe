package pl.edu.wat.swp.gui;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import pl.edu.wat.swp.dto.AddressDTO;
import pl.edu.wat.swp.dto.SearchAddressDTO;
import pl.edu.wat.swp.dto.SearchTransactionsDTO;
import pl.edu.wat.swp.dto.TransactionDTO;
import pl.edu.wat.swp.dto.TransactionTypeDTO;
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

    @RequestMapping( "/" )
    public String getMainPage( Model model, RedirectAttributes redirectAttributes )
    {
        return "redirect:/gui/users";
    }

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
    public String getAddreessesForCriteria(
            @Valid @ModelAttribute( "addressSearch" ) SearchAddressDTO searchAddressDTO,
            BindingResult addressBindingResult, Model model )
    {
        model.addAttribute(
                "addresses",
                placeManager.getPlacesForView( searchAddressDTO.getType(), searchAddressDTO.getCity(),
                        searchAddressDTO.getDistrict() ) );
        this.getAddressTypeList( model );
        return "searchAddresses";
    }

    @RequestMapping( value = "/transactions", method = RequestMethod.GET )
    public String getTransactionsForCriteria( Model model )
    {
        model.addAttribute( "transactionsSearch", new SearchTransactionsDTO() );
        model.addAttribute( "transactions", new ArrayList<TransactionDTO>() );
        this.getIntervalList( model );
        this.getTransactionTypeList( model );
        return "searchTransactions";
    }

    @RequestMapping( value = "/transactions", method = RequestMethod.GET )
    public String getTransactionsForCriteria(
            @ModelAttribute( "transactionsSearch" ) SearchTransactionsDTO searchTransactionsDTO,
            BindingResult transactionBindingResult, Model model )
    {

        model.addAttribute(
                "transactions",
                accountManager.getTransactionsEntityForCriteria( searchTransactionsDTO.getId(),
                        searchTransactionsDTO.getType(), searchTransactionsDTO.getCategory(),
                        searchTransactionsDTO.getType() ) );
        this.getIntervalList( model );
        this.getTransactionTypeList( model );
        return "searchTransactions";
    }

    private void getAddressTypeList( Model model )
    {
        HashMap<Integer, String> types = new HashMap<Integer, String>();
        types.put( 1, "Bankomat" );
        types.put( 2, "Placowka" );
        model.addAttribute( "types", types );
    }

    private void getTransactionTypeList( Model model )
    {
        HashMap<Integer, String> types = new HashMap<Integer, String>();
        List<TransactionTypeDTO> transactionTypes = accountManager.getAllTransactionType();

        for ( TransactionTypeDTO transactionTypeDTO : transactionTypes )
        {
            types.put( transactionTypeDTO.getId(), transactionTypeDTO.getType() );
        }
        model.addAttribute( "types", types );
    }

    private void getIntervalList( Model model )
    {
        HashMap<Integer, String> intervals = new HashMap<Integer, String>();
        intervals.put( 1, "Year" );
        intervals.put( 2, "Month" );
        intervals.put( 3, "Day" );
        model.addAttribute( "intervals", intervals );
    }

}
