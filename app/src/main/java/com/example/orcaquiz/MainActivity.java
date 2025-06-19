package com.example.orcaquiz;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.orcaquiz.databinding.ActivityMainBinding;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;

import java.util.ArrayList;
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

        binding.answerBtn1.setOnClickListener(this);
        binding.answerBtn2.setOnClickListener(this);
        binding.answerBtn3.setOnClickListener(this);
        binding.answerBtn4.setOnClickListener(this);

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

    @Override
    public void onClick(View v){
        Button answerBtn = (Button) findViewById(view.getId());
        String btnText = answerBtn.getText().toString();
        //findViewById(view.getId())→IDを取得してからそれに対応する中身を代入
        //(Button)→キャスト（型変換）、viewからButtonへ、型推論の進化で今は不要？
        //answerBtn.getText().toString();→中のテキストを取得（CharSequence型、文字系のインターフェース）
        //→Stringに変換

        String judgment;
        if (btnText.equals(rightAnswer)){
            judgment = "正解です！";
            //文字列の比較にはequals()を使う。==はintはプリミティブ（基本）型で可能、
            //Stringはオブジェクト型のためアドレスを比較するため不可（A,Bの箱に入った同じ種類のキャンディーは＝ではない）
            rightAnswerCount++; //正解数加算
        } else {
            judgment = "残念、、";
        } //この時点では代入のみでどこにも載っていない

        //ダイアログを作製　judgment、答え、閉じるボタンが必要。
        new MaterialAlertDialogBuilder(this)
                //MaterialAlertDialogBuilder→ダイアログ（ポップアップウィンドウ）を表示させるクラス。
                //マテリアル→物質的、現実のように影や奥行きがあるデザイン⇔フラット
                .setTitle(judgment)
                .setMessage("答え：" + rightAnswer)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        if (quizCount == QUIZ_COUNT) {
                            //出題数まで到達すると結果画面に移動する
                        } else {
                            quizCount++;
                            oQuiz();
                            //到達していないときは加算、またoQuizメソッドを呼ぶ
                        }
                    }
                })
                .setCancelable(false) //ダイアログの外側をタップしたときにダイアログを閉じるか？false閉じない
                .show(); //ダイアログを表示させる（↑までは設計のみで実際表示はされていない）

    }
}