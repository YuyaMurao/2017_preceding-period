function initialize() {
    var latlng = new google.maps.LatLng(39.8012332, 141.1376046);
    //中心座標の経度・緯度の指定
    var opts = {
    //// optでは主に下記３つを指定し，Mapクラスのインスタンス作成の2番目の引数に指定する
    zoom: 15, //倍率の指定（小さいほど広域）
    center: latlng, 　//中心座標
    mapTypeId: google.maps.MapTypeId.ROADMAP 
    // 市街地図（ROADMAP），航空写真（SATELLITE），HYBRIDなど地図の形式
    };
    var map = new google.maps.Map(document.getElementById("map_canvas"), opts); 
    //地図オブジェクトの（Mapクラスのインスタンス）作成 
    // ---- 手順3 ドラックできるマーカーの配置 開始---
    var marker = new google.maps.Marker({// マーカーオブジェクトの作成
    position: latlng, // マーカーの座標
    title: "ドラッグしてみよう", // マーカーのタイトル
    draggable: true // falseだと動かせない
    });
    marker.setMap(map);
    // --- 手順3 ドラックできるマーカーの配置 終了---
    // --- 手順4 マーカーの経度緯度の取得 開始---
    google.maps.event.addListener(marker, 'dragend', function(ev) {
    //// APIにあるマーカードラッグが終了したときのイベントメソッド
    document.getElementById('latitude').value = ev.latLng.lat(); 
    // latitudeセレクタの値にに経度の結果を代入 
    document.getElementById('longitude').value = ev.latLng.lng();
    // longitudeセレクタの値に緯度の結果を代入
    });
    // --- 手順4 マーカーの経度緯度の取得 終了---
    // --- 手順5 マーカーに情報ウィンドウを表示 開始 ---
    var info = new google.maps.InfoWindow({content: '<a href="http://www.iwate-pu.ac.jp/" target="_blank">岩手県立大学</a><p>私たちの大学です</p>'}); 
    ////情報ウィンドウオブジェクトの作成
    google.maps.event.addListener(marker, 'click', function() {
    //先に定義したMarkerオブジェクトがクリックされたら情報ウィンドウを開く
    info.open(map, marker);
    });
    // --- 手順5 マーカーに情報ウィンドウを表示 終了 ---
    }