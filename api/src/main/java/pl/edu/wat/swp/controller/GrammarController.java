package pl.edu.wat.swp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import pl.edu.wat.swp.dto.xmls.Address;
import pl.edu.wat.swp.helpers.GSB;
import pl.edu.wat.swp.managers.AccountManager;
import pl.edu.wat.swp.managers.PlaceManager;
import pl.edu.wat.swp.model.Rodzajoperacji;


@Controller
public class GrammarController {
	
	@Autowired
	AccountManager am;
	
	@Autowired
	PlaceManager pm;

	@RequestMapping(value = "/grammar/gsl/transactions", produces="application/x-gsl")
	@ResponseBody
	public String grammarGslTransacctions() {
		
		StringBuilder s = new StringBuilder();
		s.append("Request( ?[(i want) (i need) (i'am looking for)] Service ?Service ?Service  )");
		s.append(" Service([ ");
		List<Rodzajoperacji> typy = am.getTransactionTypes();
		s = GSB.transactionType(s, typy);
		s = GSB.transactionInterval(s);
		s = GSB.transactionCategory(s);
		s.append(" ])");
		return s.toString();
	}
	
	
	@RequestMapping(value = "/grammar/gsl/places", produces="application/x-gsl")
	@ResponseBody
	public String grammarGslPlaces() {
		StringBuilder s = new StringBuilder();
		s.append("Request( ?[(i want) (i need) (i'am looking for)]");
		s.append(" [(FindType City District)(FindType District City)]");
		s.append(" ?please");
		s.append(") ");
		
		s = GSB.placesType(s);
		
		Address adress = pm.getAllPlaces();
		String p = adress.getFullAdress();
		String[] places = p.split("#");
		s = GSB.placesCity(s, places);
		
		adress = pm.getAllDistrictss();
		p = adress.getFullAdress();
		places = p.split("#");
		s = GSB.placesDistrict(s, places);
		
		return s.toString();
	}

}
