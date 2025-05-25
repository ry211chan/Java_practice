package jp.co.fl.superintro.ch06exercise;

import java.util.Scanner;

public class Practice0601 {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		Scanner sc =new Scanner(System.in);
		 System.out.print("数値を入力-->");
		 int num=sc.nextInt();
		
		 if(num % 2==0){
		 System.out.println("入力数値["+num+"]は偶数です。");
		 }else{
		 System.out.println("入力数値["+num+"]は奇数です。");
		 }

	}

}
