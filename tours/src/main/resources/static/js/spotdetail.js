
  var mymap;
m
  mymap = L.map('map'); 
  L.tileLayer('https://cyberjapandata.gsi.go.jp/xyz/std/{z}/{x}/{y}.png', {
    maxZoom: 18,
    attribution: "<a href=\"https://maps.gsi.go.jp/development/ichiran.html\">国土地理院</a>",
  }).addTo(mymap);
  mymap.locate({setView: true, maxZoom: 18, timeout: 20000});
 
  