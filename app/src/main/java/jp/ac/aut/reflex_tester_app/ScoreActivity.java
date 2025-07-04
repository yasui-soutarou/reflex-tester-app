package jp.ac.aut.reflex_tester_app;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

public class ScoreActivity extends AppCompatActivity {

    private ListView scoreListView;
    private ScoreManager scoreManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);

        scoreListView = findViewById(R.id.score_list);
        scoreManager = ScoreManager.getInstance();

        List<Double> scores = scoreManager.getScores();

        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                scores.stream()
                        .map(score -> String.format("%.2f ms", score))
                        .toList()
        );

        scoreListView.setAdapter(adapter);
    }
}
