// 地図を作成する
var mymap = L.map('map');
 
// タイルレイヤーを作成し、地図にセットする
L.tileLayer('https://cyberjapandata.gsi.go.jp/xyz/std/{z}/{x}/{y}.png', {
  maxZoom: 18,
  attribution: "国土地理院",
}).addTo(mymap);
 
// 地図の中心座標とズームレベルを設定する
mymap.setView([41.768667, 140.728917], 13);