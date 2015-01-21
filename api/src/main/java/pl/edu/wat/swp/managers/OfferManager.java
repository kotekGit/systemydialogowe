package pl.edu.wat.swp.managers;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import pl.edu.wat.swp.dto.OfferDTO;
import pl.edu.wat.swp.dto.xmls.Offer;
import pl.edu.wat.swp.helpers.CommonVariables;
import pl.edu.wat.swp.model.Oferta;
import pl.edu.wat.swp.repository.jpa.impl.OfferRepositoryImpl;

/**
 * 
 * @author Krzysztof Jedynak @email jedynakpoczta@gmail.com
 * @date 18 sty 2015
 */

@Component
public class OfferManager
{
    @Autowired
    OfferRepositoryImpl offerRepositoryImpl;

    /**
     * Find all current offer by date.
     * 
     * @return
     */
    public Offer getCurrentOffer()
    {
        List<Oferta> allCurrentOffer = offerRepositoryImpl.findCurrentOfferWithoutDuplicate( new Date() );
        return this.makeXMLFromEntities( allCurrentOffer );

    }

    /**
     * Make xml object for offer enetity list.
     * 
     * @param offers
     * @return
     */
    public Offer makeXMLFromEntities( List<Oferta> offers )
    {
        Offer offer = new Offer();
        StringBuilder fullInfo = new StringBuilder();

        for ( Oferta ofer : offers )
        {
            StringBuilder currentOffer = new StringBuilder();
            currentOffer.append( CommonVariables.OFFER_DELIMITER );
            currentOffer.append( CommonVariables.OFFER_CONTNET );

            if ( ofer.getOpis() != null )
            {
                currentOffer.append( ofer.getOpis() + CommonVariables.OFFER_ELEMENT_DELIMITER );
            }

            fullInfo.append( currentOffer );
        }

        if ( offers.size() > 0 )
        {
            offer.setNameAndContents( fullInfo.toString() );
        }
        else
        {
            offer.setNameAndContents( CommonVariables.NOT_FOUND_MESSAGE );
        }

        return offer;
    }

    /**
     * Get all offers.
     * 
     * @return
     */
    public List<OfferDTO> getAllOffer()
    {
        List<Oferta> allOffers = offerRepositoryImpl.findAll();
        List<OfferDTO> allOfferDTOs = new ArrayList<OfferDTO>();
        for ( Oferta oferta : allOffers )
        {
            OfferDTO offerDTO = new OfferDTO( oferta );
            allOfferDTOs.add( offerDTO );
        }
        return allOfferDTOs;

    }

}
