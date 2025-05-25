package jp.co.fl.superintro.ch05;

public class LogicalOperator {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		 int X = 6 ;
		 int Y = 6 ;
		 int Z = 5 ;
		
		 // 「 && 」
		 boolean logicalValue1 = X != Y && Y > Z ;
		 System.out.println(logicalValue1) ;
		
		 // 「 || 」
		 boolean logicalValue2 = X != Y || Y > Z ;
		 System.out.println(logicalValue2) ;
		
		 // 「 ^ 」
		 boolean logicalValue3 = X != Y ^ Y > Z ;
		 System.out.println(logicalValue3) ;
		
		 // 「 ! 」
		 boolean logicalValue4 = !logicalValue3;
		System.out.println(logicalValue4) ;
	}

}
