package pr7;
import java.sql.*; //SQLに関連したクラスライブラリをインポート
public class Dbquery2 {

/* 1. フィールドの定義 */ protected String[] stu_num = new String[10]; //学生番号
protected String[] stu_name = new String[10]; //名前
protected Date[] ent_year = new Date[10]; //入学年
protected int num; //データ取得件数 

/* 2. メソッド */
/* 2.1 データベースからのデータ取得メソッド */
public void dataload() throws Exception { //エラー処理が必要にする
/* 2.1.1 データベースに接続 */
Class.forName("com.mysql.jdbc.Driver").newInstance(); //com.mysql.jdbc.Driverはドライバのクラス名
String url = "jdbc:mysql://localhost/softd1?characterEncoding=UTF-8"; //softd1がデータベース名：文字エンコードはUTF-8
Connection conn = DriverManager.getConnection(url, "softd", "softd"); //上記URL設定でユーザ名とパスワードを使って接続

/* 2.1.2 SELECT文の実行 */ 
String sql = "SELECT * FROM student"; //SQL文の設定 ?などパラメータが必要がない場合は通常のStatementを利用
PreparedStatement stmt = conn.prepareStatement(sql); //JDBCのステートメント（SQL文）の作成
ResultSet rs = stmt.executeQuery(); //ステートメントを実行しリザルトセットに代入

/* 2.1.3 結果の取り出しと表示 */
while (rs.next()) { //リザルトセットを1行進める．ない場合は終了
this.stu_num[num] = rs.getString("stu_num");
this.stu_name[num] = rs.getString("stu_name");
this.ent_year[num] = rs.getDate("ent_year");
num++;
}

/* 2.1.4 データベースからの切断 */
rs.close(); //開いた順に閉じる
stmt.close();
conn.close();
}

/* 2.2 データベースへのインサートメソッド */
public void insert(String stu_num, String stu_name, String ent_year) throws Exception {
/* 2.2.1 データベースに接続 */
Class.forName("com.mysql.jdbc.Driver").newInstance(); // SELECTの時と同じ
String url = "jdbc:mysql://localhost/softd1?characterEncoding=UTF-8";
Connection conn = DriverManager.getConnection(url, "softd", "softd");

/* 2.2.2 INSERT文の実行 */
String sql = "INSERT INTO student (stu_num,stu_name,ent_year) VALUES (?,?,?)";
//SQL文の設定 INSERTはパラメータが必要なことが多い

PreparedStatement stmt = conn.prepareStatement(sql); //JDBCのステートメント（SQL文）の作成
stmt.setString(1, stu_num); //1つ目の？に引数をセットする
stmt.setString(2, stu_name); //2つ目の？に引数をセットする
stmt.setString(3, ent_year); //3つ目の？に引数をセットする
/* 2.2.3 実行（UpdateやDeleteも同じメソッドを使う） */
stmt.executeUpdate();

/* 2.2.4 データベースからの切断 */
stmt.close();
conn.close();
}

/* 3. アクセッサ */
/* 3.1 Getアクセッサ */
public String getStu_num(int i) {
if (i >= 0 && num > i) {
return stu_num[i];
} else {
return "";
}
}
public String getStu_name(int i) {
if (i >= 0 && num > i) {
return stu_name[i];
} else {
return "";
}
}
public Date getEnt_year(int i) {
if (i >= 0 && num > i) {
return ent_year[i];
} else {
return null;
}
}
public int getNum() {
return num; // データ件数
}
}