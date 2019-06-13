
  var mymap;
  mymap = L.map('map'); 
  L.tileLayer('https://cyberjapandata.gsi.go.jp/xyz/std/{z}/{x}/{y}.png', {
    maxZoom: 18,
    attribution: "<a href=\"https://maps.gsi.go.jp/development/ichiran.html\">国土地理院</a>",
  }).addTo(mymap);
  mymap.locate({setView: true, maxZoom: 18, timeout: 20000});

  $(function(){
    
    //input属性のものを一括で取得する
    var inputItem = document.getElementById("disAbledInput").getElementsByTagName("input");
    //ループしながら全てに処理を行う
    for (var i=0; i<inputItem.length; i++){
      //項目がreadonlyの場合のみ処理
      if (inputItem[i].readOnly){
        //背景色を設定する
        inputItem[i].style.backgroundColor = "#e9e9e9";
        //タブ遷移を不可にする
        inputItem[i].tabIndex = "-1";
        //テキストボックスにマウスオーバーした際に禁止マークに切り替える
        inputItem[i].style.cursor = "not-allowed";
      }
    }
  });