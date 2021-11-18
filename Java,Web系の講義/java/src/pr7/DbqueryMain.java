package pr7;

public class DbqueryMain {

public static void main(String[] args) {
// オブジェクトの生成
Dbquery stu = new Dbquery();

// データロードメソッドを実行する
try {
stu.dataload("g00001");
} catch (Exception e) {
System.out.println("例外発生：" + e.getMessage());
}

// プリントアウトする
System.out.printf("学籍番号：%s，名前：%s，入学年：%s\n", stu.getStu_num(), stu.getStu_name(), stu.getEnt_year());

}
}