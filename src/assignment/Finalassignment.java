package jp.co.fl.superintro.assignment;

import java.util.Scanner;

public class Finalassignment {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		System.out.println("*****************\n*  High & Low   *\n*****************");

        while (true) {
            int num1 = (int)(Math.random() * 9)+1;
            int num2 = (int)(Math.random() * 9)+1;

            System.out.println("\n[問題表示]\n***** *****\n*   * * * *\n* "+num1+" * * * *\n*   * * * *\n***** *****");

            Scanner sc = new Scanner(System.in);
            System.out.print("High  or  Low ?(h/l) > ");
            String str = sc.nextLine();

            if (str.equals("h")) {
                System.out.println("→High を選択しました。");
            } else {
                System.out.println("→Low を選択しました。");
            }

            if ((num1 < num2 && str.equals("h")) || (num1 > num2 && str.equals("l")) || (num1 == num2)) {
                System.out.println("\n[結果表示]\n***** *****\n*   * *　 *\n* "+num1+" * * "+num2+" *\n*   * *   *\n***** *****");
                System.out.println("→You Win！");
            } else {
            	System.out.println("\n[結果表示]\n***** *****\n*   * *　 *\n* "+num1+" * * "+num2+" *\n*   * *   *\n***** *****");
                System.out.println("→You Lose ...");
                System.out.println("--ゲーム終了--");
                break;
            }
        }

	}

}
