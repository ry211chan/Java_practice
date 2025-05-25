package jp.co.fl.superintro.ch06;

public class NestedIfStatement1 {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		//比較⽤の数値を管理するための変数aを宣言し、7で初期化
		 int a=7;
		
		 System.out.println("*****if文の判定開始*****");
		
		 if(a>=0){
		 System.out.println("変数aは0以上。");
		 if(a<=10){
		 System.out.println("変数aは10以下。");
		 }else{
		 System.out.println("変数aは10より大きい。");
		 }
		 }
		
		 System.out.println("*****if文の判定終了*****");


	}

}
