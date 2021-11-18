package pr7;

public class Dbquery2Main {

public static void main(String[] args) {
// オブジェクトの生成
Dbquery2 stu = new Dbquery2();

//　INSERTを実行する
try {
stu.insert("g11113", "堀川八好", "2011-04-01");
} catch (Exception e) {
System.out.println("例外発生：" + e.getMessage());
}

// データロードメソッドを実行する
try {
stu.dataload();
} catch (Exception e) {
System.out.println("例外発生：" + e.getMessage());
}

// プリントアウトする
for (int i = 0; i < stu.getNum(); i++) {
System.out.printf("学籍番号：%s，名前：%s，入学年：%s\n", stu.getStu_num(i), stu.getStu_name(i), stu.getEnt_year(i));
}

}
}