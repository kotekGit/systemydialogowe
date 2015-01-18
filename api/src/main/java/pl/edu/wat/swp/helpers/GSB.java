package pl.edu.wat.swp.helpers;

import java.util.List;

import pl.edu.wat.swp.model.Rodzajoperacji;

/**
 * Klasa przechowująca buildy stringów dla gramatyki.
 * 
 * @author lkotowski
 *
 */
public class GSB {

	public static StringBuilder transactionType(StringBuilder s,
			List<Rodzajoperacji> typy) {
		for (Rodzajoperacji r : typy) {
			s.append("[(" + r.getNazwaRO() + ")] {<type \"" + r.getNazwaRO()
					+ "\">} ");
		}
		return s;
	}

	public static StringBuilder transactionInterval(StringBuilder s) {
		s.append("[(month) (last mont)] {<time \"month\">} ");
		s.append("[(year) (last year)] {<time \"year\">} ");
		s.append("[(today) (this day)] {<time \"today\">} ");
		return s;
	}

	public static StringBuilder transactionCategory(StringBuilder s) {
		s.append("[(food) (dish) (eating)] {<category \"food\">} ");
		s.append("[(bills) (taxes)] {<category \"bills\">} ");
		s.append("[(uncategorized)] {<category \"uncategorized\">} ");
		return s;
	}

	public static StringBuilder placesType(StringBuilder s) {
		s.append("FindType([facility { <findType \"facility\"> }  ");
		s.append("atm { <findType \"ATM\"> }]) ");
		return s;
	}

	public static StringBuilder placesCity(StringBuilder s, String[] places) {
		String cities = null;
		for (String p : places) {
			String tmp = p + " { <city \""+p+"\"> } ";
			cities += tmp;
		}
		s.append("City(?in[ "+cities+" ]} ");
		return s;
	}

	public static StringBuilder placesDistrict(StringBuilder s, String[] places) {
		String district = null;
		for (String p : places) {
			String tmp = p + " { <district \""+p+"\"> } ";
			district += tmp;
		}
		s.append("District(?in[ "+district+" ]} ");
		return s;
	}

}
