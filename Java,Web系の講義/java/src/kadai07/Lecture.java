package kadai07;

import java.sql.*; //SQLに関連したクラスライブラリをインポート

public class Lecture {
protected int[] lec_id = new int[100]; //授業ID
protected String[] lec_name = new String[100]; //授業名
protected int[] lec_credit = new int[100];//単位数
protected int num; //データ取得件数 

/* 2.1 データベースからのデータ取得メソッド */
//複数のデータを取得するメソッド
public void dataload() throws Exception { //エラー処理が必要にする
/* 2.1.1 データベースに接続 */
Class.forName("com.mysql.jdbc.Driver").newInstance(); //com.mysql.jdbc.Driverはドライバのクラス名
String url = "jdbc:mysql://localhost/softd1?characterEncoding=UTF-8"; //softd1がデータベース名：文字エンコードはUTF-8
Connection conn = DriverManager.getConnection(url, "softd", "softd"); //上記URL設定でユーザ名とパスワードを使って接続

/* 2.1.2 SELECT文の実行 */ 
String sql = "SELECT * FROM lecture"; //SQL文の設定 ?などパラメータが必要がない場合は通常のStatementを利用
PreparedStatement stmt = conn.prepareStatement(sql); //JDBCのステートメント（SQL文）の作成
ResultSet rs = stmt.executeQuery(); //ステートメントを実行しリザルトセットに代入

/* 2.1.3 結果の取り出しと表示 */
while (rs.next()) { //リザルトセットを1行進める．ない場合は終了
this.lec_id[num] = rs.getInt("lec_id");
this.lec_name[num] = rs.getString("lec_name");
this.lec_credit[num] = rs.getInt("lec_credit");
num++;
}

/* 2.1.4 データベースからの切断 */
rs.close(); //開いた順に閉じる
stmt.close();
conn.close();
}

/* 2.2 データベースへのインサートメソッド */
public void insert(int lec_id, String lec_name, int lec_credit) throws Exception {//一件のデータを挿入するメソッド
/* 2.2.1 データベースに接続 */
Class.forName("com.mysql.jdbc.Driver").newInstance(); // SELECTの時と同じ
String url = "jdbc:mysql://localhost/softd1?characterEncoding=UTF-8";
Connection conn = DriverManager.getConnection(url, "softd", "softd");

/* 2.2.2 INSERT文の実行 */
String sql = "INSERT INTO lecture (lec_id,lec_name,lec_credit) VALUES (?,?,?)";
//SQL文の設定 INSERTはパラメータが必要なことが多い

PreparedStatement stmt = conn.prepareStatement(sql); //JDBCのステートメント（SQL文）の作成
stmt.setInt(1, lec_id); //1つ目の？に引数をセットする
stmt.setString(2, lec_name); //2つ目の？に引数をセットする
stmt.setInt(3, lec_credit); //3つ目の？に引数をセットする
/* 2.2.3 実行（UpdateやDeleteも同じメソッドを使う） */
stmt.executeUpdate();

/* 2.2.4 データベースからの切断 */
stmt.close();
conn.close();
}

/* lec_idを条件に一件データを削除するメソッド */
public void delete(int lec_id) throws Exception {//一件のデータを挿入するメソッド
/* データベースに接続 */
Class.forName("com.mysql.jdbc.Driver").newInstance(); // SELECTの時と同じ
String url = "jdbc:mysql://localhost/softd1?characterEncoding=UTF-8";
Connection conn = DriverManager.getConnection(url, "softd", "softd");

/* DELETE文の実行 */
String sql = "DELETE FROM lecture WHERE lec_id = ?";

PreparedStatement stmt = conn.prepareStatement(sql); //JDBCのステートメント（SQL文）の作成
stmt.setInt(1, lec_id); //1つ目の？に引数をセットする
/*実行（UpdateやDeleteも同じメソッドを使う） */
stmt.executeUpdate();

/* データベースからの切断 */
stmt.close();
conn.close();
}

/* lec_idを条件に一件データを更新するメソッド */
public void update(int lec_id, String lec_name, int lec_credit) throws Exception {//一件のデータを挿入するメソッド
/* データベースに接続 */
Class.forName("com.mysql.jdbc.Driver").newInstance(); // SELECTの時と同じ
String url = "jdbc:mysql://localhost/softd1?characterEncoding=UTF-8";
Connection conn = DriverManager.getConnection(url, "softd", "softd");

/* UPDATE文の実行 */
String sql = "UPDATE lecture SET lec_id = ?,lec_name = ?,lec_credit = ?  WHERE lec_id = ?";

PreparedStatement stmt = conn.prepareStatement(sql); //JDBCのステートメント（SQL文）の作成
stmt.setInt(1, lec_id); //1つ目の？に引数をセットする
stmt.setString(2, lec_name); //2つ目の？に引数をセットする
stmt.setInt(3, lec_credit); //3つ目の？に引数をセットする
stmt.setInt(4, lec_id); //4つ目の？に引数をセットする
/*実行 */
stmt.executeUpdate();

/* データベースからの切断 */
stmt.close();
conn.close();
}




/*Getアクセッサ */
public int getLec_id(int i) {
if (i >= 0 && num > i) {
    return lec_id[i];
} else {
    return 0;
}
}
public String getLec_name(int i) {
if (i >= 0 && num > i) {
return lec_name[i];
} else {
return "";
}
}
public int getLec_credit(int i) {
if (i >= 0 && num > i) {
    return lec_credit[i];
} else {
    return 0;
}
}
public int getNum() {
return num; // データ件数
}
}
