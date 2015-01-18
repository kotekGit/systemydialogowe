package pl.edu.wat.swp.helpers;

/**
 * Klasa przechowująca buildy stringów dla gramatyki.
 * @author lkotowski
 *
 */
public class GSB {
	
	public static StringBuilder transactionType(StringBuilder s) {
		s.append("[(income) (inc)] {<type \"income\">} ");
		s.append("[(out flow) (out) (loose)] {<type \"out flow\">} ");
		s.append("[(all transactions) (all types)] {<type \"all\">} ");
		return s;
	}
	
	public static  StringBuilder transactionInterval(StringBuilder s) {
		s.append("[(month) (last mont)] {<time \"month\">} ");
		s.append("[(year) (last year)] {<time \"year\">} ");
		s.append("[(today) (this day)] {<time \"today\">} ");
		return s;
	}
	
	public static  StringBuilder transactionCategory(StringBuilder s) {
		//TODO dorobić
		return s;
	}

}
