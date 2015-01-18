package pl.edu.wat.swp.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import pl.edu.wat.swp.dto.xmls.Offer;
import pl.edu.wat.swp.managers.OfferManager;

/**
 * 
 * @author Krzysztof Jedynak @email jedynakpoczta@gmail.com
 * @date 18 sty 2015
 */

@Controller
public class OfferController
{
    private static Logger logger = Logger.getLogger( OfferController.class );

    @Autowired
    OfferManager offerManager;

    @RequestMapping( value = "/alloffer", produces = MediaType.APPLICATION_XML_VALUE )
    @ResponseBody
    public Offer getAddressesByType()
    {
        logger.debug( "Get all current offer by date" );
        return offerManager.getCurrentOffer();
    }

}
