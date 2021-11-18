package pr06;

public class Student extends Person { // 継承

    // フィールド
    String studentNum; // 学籍番号

    // コンストラクタ
    public Student(String firstName, String lastName, String studentNum) {
        super(firstName, lastName); // 親クラスのコンストラクタを利用
        this.studentNum = studentNum;
    }

    // メソッド
    @Override
    public void run() {
        System.out.printf("学籍番号%s：名前は%s%sです\n", studentNum, lastName, firstName);
    }

}