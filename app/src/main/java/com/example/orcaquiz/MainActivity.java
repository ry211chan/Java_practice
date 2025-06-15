package com.example.orcaquiz;

import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.orcaquiz.databinding.ActivityMainBinding;

import java.util.ArrayList;  //自動で追加してくれている
import java.util.Collections;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
//implements→インターフェースの実装（継承はextends）
//View→AndroidのUI部品(UserInterface=ボタンなど)を表す基本クラス
//OnClickListener→Viewクラス内で定義されている。クリック時の処理を書くためのインターフェース
//インターフェース：ボタンが押されたら何か処理するということだけが決められている
    private ActivityMainBinding binding;
    private String rightAnswer; //正解
    private int rightAnswerCount; //正解数をカウントする
    private int quizCount  = 1; //今何問目かカウントする

    private static final int QUIZ_COUNT = 2;
    //クイズの出題数を決める
    //final→定数としたいとき。再代入不可（定数は大文字のスネークケースを使うのが慣例）


    private ArrayList<ArrayList<String>> quizArray = new ArrayList<>();
    private String[][] quizData = {
            // {"問題","正解","選択肢１","選択肢２","選択肢３"} 配列の中に配列→多次元配列
            {"シャチは何の仲間？","哺乳類","魚類","爬虫類","両生類"},
            {"シャチは超音波で周囲を探る能力があるが、その能力を何と呼ぶか？","エコーロケーション","ソナー","サブマリンセンス","音響探査"}

    };

    @Override //親メソッドの処理内容を子メソッドで書き換えたいとき。既存コードへの影響が少ない
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        for (int i =0; i < quizData.length; i++) {
            ArrayList<String> quiz = new ArrayList<>(); //ArrayList　配列の要素数を決めておかなくてよい
            quiz.add(quizData[i][0]); //問題
            quiz.add(quizData[i][1]); //正解
            quiz.add(quizData[i][2]); //選択肢１
            quiz.add(quizData[i][3]); //選択肢２
            quiz.add(quizData[i][4]); //選択肢３
            //add　リストに要素を追加する

            quizArray.add(quiz);
        }

        Collections.shuffle(quizArray);
        //出題順をシャッフルする

        nextQuiz();
    }

    private void nextQuiz() {
        binding.countLabel.setText(getString(R.string.count_label, quizCount));
        //binding.countLabel→TextViewにViewBinding経由でアクセス
        //(count_label(スネークケース)=countLabel(キャメルケース)ViewBindingは自動変換してくれる)
        //setText()→テキストを表示
        //getString()リソースから文字列を取得
        // R(Resource).string→文字列リソースのcount_Labelの%d(プレースホルダ)にquizCountの値を埋め込む

        ArrayList<String> oQuiz = quizArray.get(0);
        //.get() quizArrayから問題を取り出す

        binding.quentionLabel.setText(oQuiz.get(0));
        //問題文を表示する

        rightAnswer = oQuiz.get(1);
        //正解をrightAnswerにセットする

        oQuiz.remove(0);
        //oQuiz配列から問題文を削除（表示後だから消えてok）

        Collections.shuffle(oQuiz);
        //正解と選択肢3つをシャッフルする

        binding.answerBtn1.setText(oQuiz.get(0));
        binding.answerBtn2.setText(oQuiz.get(1));
        binding.answerBtn3.setText(oQuiz.get(2));
        binding.answerBtn4.setText(oQuiz.get(3));
        //選択肢をanswerBtnXにセットする(シャッフルされている)

        quizArray.remove(0);
        //この問題をquizArrayから削除する(重複出題防止)
    }
}