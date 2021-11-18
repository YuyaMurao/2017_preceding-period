function initialize() {
var latlng = new Array(2);
latlng[0] = new google.maps.LatLng(39.70040342900193, 141.13317627291644);
latlng[1] = new google.maps.LatLng(39.70319862472954, 141.145435309219);
latlng[2] = new google.maps.LatLng(39.7036126936955, 141.14417713578678);

//中心座標の経度・緯度の指定
var opts = {
//// optでは主に下記３つを指定し，Mapクラスのインスタンス作成の2番目の引数に指定する
zoom: 15, //倍率の指定（小さいほど広域）
center: latlng[0], 　//中心座標
mapTypeId: google.maps.MapTypeId.ROADMAP 
// 市街地図（ROADMAP），航空写真（SATELLITE），HYBRIDなど地図の形式
};
var map = new google.maps.Map(document.getElementById("map_canvas"), opts); 
//地図オブジェクトの（Mapクラスのインスタンス）作成 
// ---- 手順3 ドラックできるマーカーの配置 開始---
var marker = new Array(2);
for(var i=0;i<3;i++){
    marker[i] = new google.maps.Marker({// マーカーオブジェクトの作成
    position: latlng[i], // マーカーの座標
    title: "", // マーカーのタイトル
    draggable: false // falseだと動かせない
    });
    marker[i].setMap(map);
}
// --- 手順3 ドラックできるマーカーの配置 終了---
// --- 手順5 マーカーに情報ウィンドウを表示 開始 ---
var info1 = new google.maps.InfoWindow({content: '<a href="http://www.round1.co.jp/shop/tenpo/iwate-morioka.html" target="_blank">ラウンドワン盛岡店</a><p>アミューズメント施設。よく音ゲーするために行くゲーセン１</p>'}); 
var info2 = new google.maps.InfoWindow({content: '<a href="http://www.sunleisure1976.com/page32868.html" target="_blank">サンシャイン大通り店</a><p>アミューズメント施設。よく音ゲーするために行くゲーセン２</p>'}); 
var info3 = new google.maps.InfoWindow({content: '<a href="http://mac-enterprise.jp/" target="_blank">佐々木家</a><p>ラーメン屋。お気に入りのラーメン屋でとんこつしょうゆのこってりがおすすめ</p>'}); 
////情報ウィンドウオブジェクトの作成
google.maps.event.addListener(marker[0], 'click', function() {
    //先に定義したMarkerオブジェクトがクリックされたら情報ウィンドウを開く
    info1.open(map, marker[0]);
});
google.maps.event.addListener(marker[1], 'click', function() {
    //先に定義したMarkerオブジェクトがクリックされたら情報ウィンドウを開く
    info2.open(map, marker[1]);
});
google.maps.event.addListener(marker[2], 'click', function() {
    //先に定義したMarkerオブジェクトがクリックされたら情報ウィンドウを開く
    info3.open(map, marker[2]);
});
// --- 手順5 マーカーに情報ウィンドウを表示 終了 ---
}