var URL = "http://ssd-wat.azurewebsites.net/api-0.1.0/";
var GrammarURL = URL + "grammar/";
var RESPONSE = {
    getMsg : function(xml) {
        return XML.get(xml, "msg");
    }
};

var ACCOUNT = {
    loginURL : function(NIK, Haslo) {
        var url = URL + "login/"+NIK+"/"+Haslo;
        return url;
    },
    isAuthorized : function(xml) {
        return Boolean(XML.get(xml, "status"));
    },
    getBalanceURL : function(ID) {
        return URL + "getbalance/" + ID;
    },
    getBalance : function(xml) {
        return XML.get(xml, "balance");
    },
    dataChangeURL : function(ID, PLACE, DISTRICT, STREET) {
        return Url + "/changedata/"+Id+"/"+PLACE+"/"+DISTRICT+"/"+STREET;
    }
}

var OFFER = {
    allOfferURL : function() {
        return URL + "alloffer";
    },
    allOffer : function(xml) {
        return XML.get(xml, "nameAndContents");
    }
};

var PLACE = {
    placesURL : function(TYPE, PLACE, DISTRICT) {
        var typeId = TYPEtoLowerCase() == 'atm' ? 1 : 2;
        return URL + "places/"+typeId+"/"+PLACE+"/"+DISTRICT;
    },
    places : function(xml) {
        return XML.get(xml, "fullAdress");
    },
    fullAdressURL : function() {
        return URL + "allplaces";
    },
    fullAdress : function(xml) {
        return XML.get(xml, "fullAdress");
    },
    allDistrictsURL : function() {
        return URL + "alldistricts";
    },
    allDistricts : function(xml) {
        return XML.get(xml, "fullAdress");
    },
    grammarURL : function() {
        return GrammarURL + "gsl/places";
    }
};

var TRANSACTIONS = {
    transactionsURL : function(TYPE, CATEGORY, INTERVAL) {
        return URL + "transactions/"+TYPE+"/"+CATEGORY+"/"+INTERVAL;
    },
    transactions : function(xml) {
        return XML.get(xml, "");
    },
    grammarURL : function() {
        return GrammarURL + "gsl/transactions";
    }
};