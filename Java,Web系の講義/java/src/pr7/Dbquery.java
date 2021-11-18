package pr7;

import java.sql.*; //SQLに関連したクラスライブラリをインポート

public class Dbquery {

/* 1. フィールドの定義 */
protected String stu_num; //学生番号
protected String stu_name; //名前
protected Date ent_year; //入学年

/* 2. データベースからのデータ取得メソッド */
public void dataload(String stu_num) throws Exception { //エラー処理が必要にする
/* 2.1 データベースに接続 */
Class.forName("com.mysql.jdbc.Driver").newInstance(); //com.mysql.jdbc.Driverはドライバのクラス名
String url = "jdbc:mysql://localhost/softd1?characterEncoding=UTF-8"; //softd1がデータベース名：文字エンコードはUTF-8
Connection conn = DriverManager.getConnection(url, "softd", "softd"); //上記URL設定でユーザ名とパスワードを使って接続

/* 2.2 SELECT文の実行 */
String sql = "SELECT * FROM student WHERE stu_num=?"; //SQL文の設定 ?などパラメータが必要がない場合は通常のStatementを利用
PreparedStatement stmt = conn.prepareStatement(sql); //JDBCのステートメント（SQL文）の作成
stmt.setString(1, stu_num); //一つ目の？に引数をセットする
ResultSet rs = stmt.executeQuery(); //ステートメントを実行しリザルトセットに代入

/* 2.3 結果の取り出しと表示 */
while (rs.next()) { //リザルトセットを1行進める．ない場合は終了
this.stu_num = rs.getString("stu_num");
this.stu_name = rs.getString("stu_name");
this.ent_year = rs.getDate("ent_year");
}

/* 2.4 データベースからの切断 */
rs.close(); //開いた順に閉じる
stmt.close();
conn.close();
}

/* 3. アクセッサ */
/* 3.1 Getアクセッサ */
public String getStu_num() {
return stu_num;
}

public String getStu_name() {
return stu_name;
}

public Date getEnt_year() {
return ent_year;
}

}