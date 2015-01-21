package pl.edu.wat.swp.managers;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import pl.edu.wat.swp.dto.AddressDTO;
import pl.edu.wat.swp.dto.xmls.Address;
import pl.edu.wat.swp.helpers.CommonVariables;
import pl.edu.wat.swp.model.Adres;
import pl.edu.wat.swp.model.Bankomat;
import pl.edu.wat.swp.model.Oddzial;
import pl.edu.wat.swp.repository.jpa.service.AdresRepository;
import pl.edu.wat.swp.repository.jpa.service.BankomatRepository;
import pl.edu.wat.swp.repository.jpa.service.OddzialReposirory;

import com.google.common.base.Function;
import com.google.common.base.Predicate;
import com.google.common.collect.Collections2;
import com.google.common.collect.Lists;
import com.sun.istack.Nullable;

/**
 * 
 * @author Krzysztof Jedynak @email jedynakpoczta@gmail.com
 * @date 17 sty 2015
 */

@Component
public class PlaceManager
{
    @Autowired
    BankomatRepository bankomatRepository;

    @Autowired
    OddzialReposirory oddzialReposirory;

    @Autowired
    AdresRepository adresRepository;

    /**
     * Get places by type and other criteria.
     * 
     * @param type
     * @param place
     * @param district
     * @return
     */
    public Address getPlacesByCriteria( Integer type, String place, String district )
    {
        List<Adres> adresses = new ArrayList<Adres>();
        Address resultAdres = new Address();

        if ( type.intValue() == 1 )
        {
            List<Bankomat> atms = bankomatRepository.findAll();
            resultAdres = this.getAllPlacesForCriteria( place, district, atms, null );
        }
        else if ( type.intValue() == 2 )
        {
            List<Oddzial> branches = oddzialReposirory.findAll();
            resultAdres = this.getAllPlacesForCriteria( place, district, null, branches );
        }
        return resultAdres;
    }

    /**
     * Get all places unique.
     * 
     * @return
     */
    public Address getAllPlaces()
    {
        Address address = new Address();
        Set<String> addreses = new HashSet<String>();
        List<Adres> allAdres = adresRepository.findAll();

        Function<Adres, String> transform = new Function<Adres, String>()
        {

            @Nullable
            public String apply( Adres input )
            {
                if ( input == null )
                {
                    return null;
                }
                if ( input.getMiejscowosc() == null )
                {
                    return null;
                }
                return input.getMiejscowosc();
            }
        };

        addreses = new HashSet<String>( Lists.transform( allAdres, transform ) );
        StringBuilder fullAdres = new StringBuilder();
        for ( String name : addreses )
        {
            if ( name != null )
            {
                fullAdres.append( CommonVariables.ADDRESS_DELIMITER );
                fullAdres.append( name );
            }
        }

        address.setFullAdress( fullAdres.toString() );

        return address;
    }

    /**
     * Get all districts unique.
     * 
     * @return
     */
    public Address getAllDistrictss()
    {
        Address address = new Address();
        Set<String> addreses = new HashSet<String>();
        List<Adres> allAdres = adresRepository.findAll();

        Function<Adres, String> transform = new Function<Adres, String>()
        {

            @Nullable
            public String apply( Adres input )
            {
                if ( input == null )
                {
                    return null;
                }
                if ( input.getDzielnica() == null )
                {
                    return null;
                }
                return input.getDzielnica();
            }
        };

        addreses = new HashSet<String>( Lists.transform( allAdres, transform ) );
        StringBuilder fullAdres = new StringBuilder();
        for ( String name : addreses )
        {
            if ( name != null )
            {
                fullAdres.append( CommonVariables.ADDRESS_DELIMITER );
                fullAdres.append( name );
            }
        }

        address.setFullAdress( fullAdres.toString() );
        return address;
    }

    /**
     * Get all addreses for bankomat and criteria.
     * 
     * @param place
     * @param district
     * @return
     */
    public Address getAllPlacesForCriteria( String place, String district, List<Bankomat> atms, List<Oddzial> branches )
    {
        List<Adres> adresses = adresRepository.findAll();
        Set<Adres> filteredByCriteria = new HashSet<Adres>();
        Address resultAddresses = null;
        final String placeCriteria = place;
        final String districtCriteria = district;
        Set<Integer> ids = null;
        Function<Bankomat, Integer> transformBankomat;
        Function<Oddzial, Integer> transformOddzial;

        if ( atms != null && atms.size() > 0 )
        {
            // get all unique id from Bankomat place
            Function<Bankomat, Integer> transform = new Function<Bankomat, Integer>()
            {

                @Nullable
                public Integer apply( Bankomat input )
                {
                    if ( input == null )
                    {
                        return null;
                    }
                    else if ( input.getIdAdresu() == null )
                    {
                        return null;
                    }
                    return input.getIdAdresu().getIdAdresu();
                }

            };

            ids = new HashSet<Integer>( Lists.transform( atms, transform ) );
        }

        if ( branches != null && branches.size() > 0 )
        {
            // get all unique id from Oddzial place
            Function<Oddzial, Integer> transform = new Function<Oddzial, Integer>()
            {

                @Nullable
                public Integer apply( Oddzial input )
                {
                    if ( input == null )
                    {
                        return null;
                    }
                    else if ( input.getIdAdresu() == null )
                    {
                        return null;
                    }
                    return input.getIdAdresu().getIdAdresu();
                }

            };

            ids = new HashSet<Integer>( Lists.transform( branches, transform ) );
        }

        for ( final Integer id : ids )
        {
            if ( id != null )
            {
                // get values for criteria
                Predicate<Adres> predicatPlace = new Predicate<Adres>()
                {

                    public boolean apply( Adres input )
                    {
                        return ( input.getMiejscowosc() != null
                                 && input.getMiejscowosc().equalsIgnoreCase( placeCriteria )
                                 && input.getDzielnica() != null
                                 && input.getDzielnica().equalsIgnoreCase( districtCriteria )
                                 && input.getIdAdresu() != null && input.getIdAdresu().intValue() == id );

                    }
                };

                Collection<Adres> filteredAdres = Collections2.filter( adresses, predicatPlace );
                filteredByCriteria.addAll( filteredAdres );

            }
        }

        resultAddresses = this.makeXMLFromEntities( new ArrayList<Adres>( filteredByCriteria ) );
        return resultAddresses;
    }

    /**
     * Make xml object for adres entity list.
     * 
     * @param adresses
     * @return
     */
    public Address makeXMLFromEntities( List<Adres> adresses )
    {
        Address address = new Address();
        StringBuilder fullAddress = new StringBuilder();

        for ( Adres adres : adresses )
        {
            StringBuilder currentAdres = new StringBuilder();
            currentAdres.append( CommonVariables.ADDRESS_DELIMITER );
            currentAdres.append( CommonVariables.ADDRESS_CITY );
            if ( adres.getMiejscowosc() != null )
            {
                currentAdres.append( adres.getMiejscowosc() + CommonVariables.ADDRESS_ELEMENT_DELIMITER );
            }
            currentAdres.append( CommonVariables.ADDRESS_DISTRICT );
            if ( adres.getDzielnica() != null )
            {
                currentAdres.append( adres.getDzielnica() + CommonVariables.ADDRESS_ELEMENT_DELIMITER );
            }
            currentAdres.append( CommonVariables.ADDRESS_STREET );
            if ( adres.getUlica() != null )
            {
                currentAdres.append( adres.getUlica() + CommonVariables.ADDRESS_ELEMENT_DELIMITER );
            }
            currentAdres.append( CommonVariables.ADDRESS_LOCAL_NO );
            if ( adres.getNrLokalu() != null )
            {
                currentAdres.append( adres.getNrLokalu() );
            }

            fullAddress.append( currentAdres );
        }
        if ( adresses.size() > 0 )
        {
            address.setFullAdress( fullAddress.toString() );
        }
        else
        {
            address.setFullAdress( CommonVariables.NOT_FOUND_MESSAGE );
        }

        return address;
    }

    /**
     * Return all places entity for criteria.
     * 
     * @param place
     * @param district
     * @param atms
     * @param branches
     * @return
     */
    public List<Adres> getAllPlacesEntityForCriteria( String place, String district, List<Bankomat> atms,
            List<Oddzial> branches )
    {
        List<Adres> adresses = adresRepository.findAll();
        Set<Adres> filteredByCriteria = new HashSet<Adres>();
        Address resultAddresses = null;
        final String placeCriteria = place;
        final String districtCriteria = district;
        Set<Integer> ids = null;
        Function<Bankomat, Integer> transformBankomat;
        Function<Oddzial, Integer> transformOddzial;

        if ( atms != null && atms.size() > 0 )
        {
            // get all unique id from Bankomat place
            Function<Bankomat, Integer> transform = new Function<Bankomat, Integer>()
            {

                @Nullable
                public Integer apply( Bankomat input )
                {
                    if ( input == null )
                    {
                        return null;
                    }
                    else if ( input.getIdAdresu() == null )
                    {
                        return null;
                    }
                    return input.getIdAdresu().getIdAdresu();
                }

            };

            ids = new HashSet<Integer>( Lists.transform( atms, transform ) );
        }

        if ( branches != null && branches.size() > 0 )
        {
            // get all unique id from Oddzial place
            Function<Oddzial, Integer> transform = new Function<Oddzial, Integer>()
            {

                @Nullable
                public Integer apply( Oddzial input )
                {
                    if ( input == null )
                    {
                        return null;
                    }
                    else if ( input.getIdAdresu() == null )
                    {
                        return null;
                    }
                    return input.getIdAdresu().getIdAdresu();
                }

            };

            ids = new HashSet<Integer>( Lists.transform( branches, transform ) );
        }

        for ( final Integer id : ids )
        {
            if ( id != null )
            {
                // get values for criteria
                Predicate<Adres> predicatPlace = new Predicate<Adres>()
                {

                    public boolean apply( Adres input )
                    {
                        return ( input.getMiejscowosc() != null
                                 && input.getMiejscowosc().equalsIgnoreCase( placeCriteria )
                                 && input.getDzielnica() != null
                                 && input.getDzielnica().equalsIgnoreCase( districtCriteria )
                                 && input.getIdAdresu() != null && input.getIdAdresu().intValue() == id );

                    }
                };

                Collection<Adres> filteredAdres = Collections2.filter( adresses, predicatPlace );
                filteredByCriteria.addAll( filteredAdres );

            }
        }

        return new ArrayList<Adres>( filteredByCriteria );
    }

    /**
     * Get all places for view.
     * 
     * @param type
     * @param place
     * @param district
     * @return
     */
    public List<AddressDTO> getPlacesForView( String typeAddress, String place, String district )
    {
        List<Adres> adresses = new ArrayList<Adres>();
        List<AddressDTO> resultAddres = new ArrayList<AddressDTO>();

        Integer type = Integer.valueOf( typeAddress );
        if ( type.intValue() == 1 )
        {
            List<Bankomat> atms = bankomatRepository.findAll();
            adresses = this.getAllPlacesEntityForCriteria( place, district, atms, null );
        }
        else if ( type.intValue() == 2 )
        {
            List<Oddzial> branches = oddzialReposirory.findAll();
            adresses = this.getAllPlacesEntityForCriteria( place, district, null, branches );
        }

        for ( Adres adres : adresses )
        {
            String typeForView = type.intValue() == 1 ? "Bankomat" : "Placówka";
            AddressDTO addressDTO = new AddressDTO( adres, typeForView );
            resultAddres.add( addressDTO );
        }

        return resultAddres;
    }
}
