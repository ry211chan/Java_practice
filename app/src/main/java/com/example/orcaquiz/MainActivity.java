package com.example.orcaquiz;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.orcaquiz.databinding.ActivityMainBinding;

import java.util.ArrayList;  //自動で追加してくれている

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private String rightAnswer; //正解
    private int rightAnswerCount; //正解数をカウントする
    private int quizCount  = 1; //今何問目かカウントする


    private ArrayList<ArrayList<String>> quizarray = new ArrayList<>();
    private String[][] quizData = {
            // {"問題","正解","選択肢１","選択肢２","選択肢３","選択肢４"} 配列の中に配列→多次元配列
            {"シャチは何の仲間？","魚類","哺乳類","爬虫類","両生類"},
            {"シャチは超音波で周囲を探る能力があるが、その能力を何と呼ぶか？","ソナー","エコーロケーション","サブマリンセンス","音響探査"}

    }

    @Override
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
            quiz.add(quizData[i][5]); //選択肢４
            //add　リストに要素を追加する

            quiz.add()
        }
    }
}