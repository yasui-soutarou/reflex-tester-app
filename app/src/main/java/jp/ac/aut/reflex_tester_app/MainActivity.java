package jp.ac.aut.reflex_tester_app;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private Button startButton;

    private Button historyButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);


        // ボタンの初期化
        startButton = findViewById(R.id.button_start);
        historyButton = findViewById(R.id.button_history);

        // 開始ボタン：HansyaActivity へ遷移
        startButton.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, HansyaActivity.class);
            startActivity(intent);
        });


        // 履歴ボタン：ScoreActivity へ遷移
        historyButton.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, ScoreActivity.class);
            startActivity(intent);
        });
    }
}
