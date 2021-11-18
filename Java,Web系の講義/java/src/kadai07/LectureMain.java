/*
mainメソッド
insert(lec_id,lec_name,lec_credit)
delete(lec_id)
update(lec_id,lec_name,lec_credit)
*/

package kadai07;

public class LectureMain {
    public static void main(String[] args) {
    // オブジェクトの生成
    Lecture stu = new Lecture();

//　各種メソッドを実行する
try {
stu.insert(5, "プログラミング演習０５", 10);//挿入(動作OK)
//stu.delete(5);//削除(動作OK)
//stu.update(5,"プログラミング演習００５",20);//更新(動作OK)
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
System.out.printf("授業ID：%d，授業名：%s，単位数：%d\n", stu.getLec_id(i), stu.getLec_name(i), stu.getLec_credit(i));
}

}
}
