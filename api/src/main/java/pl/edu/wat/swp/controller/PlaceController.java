package pl.edu.wat.swp.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import pl.edu.wat.swp.dto.xmls.Address;
import pl.edu.wat.swp.managers.PlaceManager;

/**
 * 
 * @author Krzysztof Jedynak @email jedynakpoczta@gmail.com
 * @date 17 sty 2015
 */

@Controller
public class PlaceController
{
    private static Logger logger = Logger.getLogger( AccountController.class );
    
    @Autowired
    PlaceManager placeManager;
    
    @RequestMapping( value = "/places/{type}/{place}/{district}", produces = MediaType.APPLICATION_XML_VALUE )
    @ResponseBody
    public Address getAddressesByType( @PathVariable( "type" ) Integer type, @PathVariable( "place" ) String place,
            @PathVariable( "district" ) String district )
    {
              return placeManager.getPlacesByCriteria( type, place, district );
    }

}
