
  var mymap;
  var geo_lat = 35.6825;
  var geo_lng = 139.752778;

  mymap = L.map('map'); 
  L.tileLayer('https://cyberjapandata.gsi.go.jp/xyz/std/{z}/{x}/{y}.png', {
    maxZoom: 18,
    attribution: "<a href=\"https://maps.gsi.go.jp/development/ichiran.html\">国土地理院</a>",
  }).addTo(mymap);
  
  function onLocationFound(e) {

    geo_lat = e.latitude;
    geo_lng = e.longitude;
}
  
  function onLocationError(e) {
    alert("現在地を取得できませんでした。" + e.message);
  }
  
  mymap.on('locationfound', onLocationFound);
  mymap.on('locationerror', onLocationError);
  mymap.locate({setView: true, maxZoom: 18, timeout: 20000});
  mymap.setView([geo_lat, geo_lng], 12);
 
 
  //最初の値を出力
  outputPos(mymap); 

  //マップムーブイベント
  mymap.on('move', function(e) {
    //マップムーブイベントで値を出力
    outputPos(mymap);
    
    
  });

 
//現在の緯度・経度・倍率を取得して指定の要素に情報を出力する関数
function outputPos(map){
    var pos = map.getCenter();
    var zoom = map.getZoom();

    //inputに出力
    document.getElementById('spotLat').value = pos.lat;
    document.getElementById('spotLng').value = pos.lng;
    //document.getElementById('zoom_input').value = zoom;
}