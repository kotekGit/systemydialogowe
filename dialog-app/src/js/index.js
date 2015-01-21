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
    auth : function(xml) {
        return XML.get(xml, "status");
    },
    isAuthorized : function(xml) {
        return XML.get(xml, "status") == 'true';
    },
    getBalanceURL : function(ID) {
        return URL + "getbalance/" + ID;
    },
    getBalance : function(xml) {
        return XML.get(xml, "balance");
    },
    dataChangeURL : function(ID, PLACE, DISTRICT, STREET) {
        return URL + "changedata/"+ID+"/"+PLACE+"/"+DISTRICT+"/"+STREET;
    },
    getDataChangeStatus : function(xml) {
        return XML.get(xml, "status");
    }
}

var OFFER = {
    allOfferURL : function() {
        return URL + "alloffer";
    },
    offerExist : function() {
        return XML.checkExist(xml, "nameAndContents");
    },
    allOffer : function(xml) {
        var body = null;
        var exist = xml != null ? XML.checkExist(xml, "nameAndContents") : false;
        if(exist) body = XML.get(xml, "nameAndContents");
        return body == null ? '' : body;
    }
};

var PLACE = {
    placesURL : function(TYPE, PLACE, DISTRICT) {
        var typeId = TYPE.toLowerCase() == 'atm' ? 1 : 2;
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
    transactionsURL : function(USER_ID, TYPE, CATEGORY, INTERVAL) {
        return URL + "transactions/"+USER_ID+"/"+TYPE+"/"+CATEGORY+"/"+INTERVAL;
    },
    transactions : function(xml) {
        return XML.get(xml, "info");
    },
    grammarURL : function() {
        return GrammarURL + "gsl/transactions";
    }
};