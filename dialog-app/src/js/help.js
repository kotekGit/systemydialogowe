var XML = {
  get : function(d,t) {
    return (d.getElementsByTagName(t).item(0).firstChild.data);
  }
};