package pr06;

public class PersonMain {

    public static void main(String[] args) {
        //オブジェクトの生成
        Person name1 = new Person();
        Person name2 = new Person("三好","堀川");


        // アクセッサでの代入は削除

        // メソッドを実行する
    name1.run();
    name2.run();

    }
}