package jp.co.fl.superintro.ch07;

import java.util.Scanner;

public class BreakStatement {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		 Scanner sc = new Scanner(System.in);
		
		 //カウンタ変数
		 int count = 0;
		
		 System.out.println("**ループ開始**");
		 while(true){
		 System.out.print("ループを続けるなら「y」を入力してください＞");
		 String result = sc.nextLine();
		
		 //入力判定
		 if(result.equals("y")){
		 //カウントを1増やす
		 count++;
		 System.out.println(count+"回目のループです。");
		 System.out.println();
		 }else{
		 System.out.println("y以外の"+result+"が入力されたので終了します。");
		 break;
		 }
		 }
		 System.out.println("**ループ終了**");
	}

}
