package pl.edu.wat.swp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import pl.edu.wat.swp.helpers.GSB;


@Controller
public class GrammarController {

	@RequestMapping(value = "/grammar/gsl/transactions", produces="application/x-gsl")
	@ResponseBody
	public String grammar() {
		
		StringBuilder s = new StringBuilder();
		s.append("Request( ?[(i want) (i need) (i'am looking for)] Service ?Service ?Service  )");
		s.append("Service([");
		s = GSB.transactionType(s);
		s = GSB.transactionInterval(s);
		s = GSB.transactionCategory(s);
		s.append(")]");
		return s.toString();
	}
	
	


}
