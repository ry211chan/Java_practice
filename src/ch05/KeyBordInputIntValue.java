package jp.co.fl.superintro.ch05;

import java.util.Scanner;

public class KeyBordInputIntValue {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		Scanner sc = new Scanner(System.in);
		 System.out.print("1つ目の数字を入力して下さい>");
		 int num1 = sc.nextInt();
		 System.out.print("2つ目の数字を入力して下さい>");
		 int num2 = sc.nextInt();
		
		 System.out.println(num1 +"+"+num2 +"="+(num1 + num2));

	}

}
