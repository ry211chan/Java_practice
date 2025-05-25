package jp.co.fl.superintro.ch05;

public class PriorityCheck {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		// 計算⽤の値を管理する変数を宣言し、値を代入
		int a = 9;
		int b = 1;
		int c = 3;
		
		// 回答を管理する変数を宣言
		int answer;
		
		System.out.print("a = ");
		System.out.println(a);
		
		System.out.print("b = ");
		System.out.println(b);
		
		System.out.print("c = ");
		System.out.println(c);
		
		answer = a + b * c;
		System.out.print("a + b * c = ");
		System.out.println(answer);
		
		answer = (a + b)* c;
		System.out.print("(a + b)* c=");
		System.out.println(answer);

	}

}
