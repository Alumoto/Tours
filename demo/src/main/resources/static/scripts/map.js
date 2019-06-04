// 地図を作成する
var mymap = L.map('map');
var geo_lat = 35.6825;
var geo_lng = 139.752778;
var watchID;
var WAIT = 5000;

 
// タイルレイヤーを作成し、地図にセットする
L.tileLayer('https://cyberjapandata.gsi.go.jp/xyz/std/{z}/{x}/{y}.png', {
  maxZoom: 18,
  attribution: "<a href=\"https://maps.gsi.go.jp/development/ichiran.html\">国土地理院</a>",
}).addTo(mymap);
 

// function geoSuccess( position )
// {
//   geo_lat = position.coords.latitude;
//   geo_lng = position.coords.longitude;

//   console.log(geo_lat);
//   var str1 = "<h4>緯度</h4> <p>" + geo_lat + "</p>";
//   var str2 = "<h4>経度</h4> <p>" + geo_lng + "</p>";
//   document.getElementById('geo_result').innerHTML = str1 + str2;
// }

// function geoError( error )
// {
// 	// エラーコードのメッセージを定義
// 	var errorMessage = {
// 		0: "原因不明のエラーが発生しました。" ,
// 		1: "位置情報の取得が許可されませんでした。" ,
// 		2: "電波状況などで位置情報が取得できませんでした。" ,
// 		3: "位置情報の取得に時間がかかり過ぎてタイムアウトしました。" ,
//   } ;
//   document.getElementById('geo_result').innerHTML = errorMessage[error.code];
// }



// 地図の中心座標とズームレベルを設定する
function onLocationFound(e) {
  L.marker(e.latlng).addTo(mymap).bindPopup("現在地").openPopup();
}

function onLocationError(e) {
  alert("現在地を取得できませんでした。" + e.message);
}

mymap.on('locationfound', onLocationFound);
mymap.on('locationerror', onLocationError);

mymap.locate({setView: true, maxZoom: 18, timeout: 20000});