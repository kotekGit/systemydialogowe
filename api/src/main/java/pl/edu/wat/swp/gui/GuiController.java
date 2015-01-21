package pl.edu.wat.swp.gui;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import pl.edu.wat.swp.managers.AccountManager;
import pl.edu.wat.swp.managers.OfferManager;

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

}
