package jp.co.fl.superintro.ch05;

public class IncrementOperator {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		// インクリメント用の値を管理する変数の初期化
		int num = 9;
	
		System.out.println(num); //初期値の表示
		System.out.println(++num); //足しこまれた後に表示する
		System.out.println(num); //前置インクリメント後の値の表示
		
		// インクリメント用の値を管理する変数の再初期化
		num = 9;
		
		System.out.println(num); //初期値の表示
		System.out.println(num++);//表示した後に足しこまれる
		System.out.println(num); //後置インクリメント後の値の表示
		
	}

}
