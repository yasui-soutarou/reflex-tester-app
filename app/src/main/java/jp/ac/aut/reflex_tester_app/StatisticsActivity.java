package jp.ac.aut.reflex_tester_app;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

public class StatisticsActivity extends AppCompatActivity {

    private TextView statsText;
    private Button backButton;
    private ScoreManager scoreManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_statistics);

        statsText = findViewById(R.id.stats_text);
        backButton = findViewById(R.id.button_back); // 戻るボタン
        scoreManager = ScoreManager.getInstance();

        List<Double> scores = scoreManager.getScores();

        if (scores.isEmpty()) {
            statsText.setText("データがありません。");
        } else {
            double avg = Statistical.calculateAverage(scores);
            double med = Statistical.calculateMedian(scores);
            double max = Statistical.calculateMax(scores);
            double min = Statistical.calculateMin(scores);

            String stats = String.format(
                    "回数: %d\n平均: %.2f ms\n中央値: %.2f ms\n最大: %.2f ms\n最小: %.2f ms",
                    scores.size(), avg, med, max, min
            );
            statsText.setText(stats);
        }

        // 戻るボタンを押したときの処理
        backButton.setOnClickListener(v -> {
            finish(); // アクティビティを終了して前の画面に戻る
        });
    }
}
