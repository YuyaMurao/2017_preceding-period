package pr06;

public class Person {
// フィールド変数
protected String firstName;
protected String lastName;

//コンストラクタ
public Person() {
lastName = "名無しの";
firstName = "ごんべい";
}
public Person(String firstName, String lastName) {
this.firstName = firstName;
this.lastName = lastName;
}

// メソッド
public void run() {
System.out.printf("あなたの名前は%s%sです\n",lastName,firstName);
}

// アクセッサ
public String getFirstName() {
return firstName;
}
public String getLastName() {
return lastName;
}

public void setFirstName(String firstName) {
this.firstName = firstName;
}
public void setLastName(String lastName) {
this.lastName = lastName;
}
}