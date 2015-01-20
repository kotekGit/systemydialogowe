var XML = {
  get : function(d,t) {
    return (d.getElementsByTagName(t).item(0).firstChild.data);
  },
  checkExist : function(d, t) {
    var element = d.getElementsByTagName(t);
    return typeof(element) != 'undefined' && element != null;
  }
};