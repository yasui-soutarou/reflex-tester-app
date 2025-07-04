package jp.ac.aut.reflex_tester_app;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class HansyaActivity extends AppCompatActivity {

    private Button tapButton;
    private TextView statusText;
    private long startTime;
    private boolean ready = false;
    private Handler handler = new Handler();
    private Runnable showTapRunnable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hansya);

        tapButton = findViewById(R.id.tap_button);
        statusText = findViewById(R.id.status_text);

        tapButton.setEnabled(false);
        statusText.setText("待機中...");

        showTapRunnable = () -> {
            ready = true;
            startTime = System.nanoTime();
            statusText.setText("今だ！Tap!");
            tapButton.setEnabled(true);
        };

        // ランダムな待機（1〜5秒）
        int delay = new Random().nextInt(4000) + 1000;
        handler.postDelayed(showTapRunnable, delay);

        tapButton.setOnClickListener(v -> {
            if (ready) {
                long endTime = System.nanoTime();
                double reactionTime = (endTime - startTime) / 1_000_000.0;
                Toast.makeText(this, "反応時間: " + reactionTime + " ms", Toast.LENGTH_LONG).show();
                // TODO: スコア保存処理
            } else {
                handler.removeCallbacks(showTapRunnable);
                Toast.makeText(this, "早すぎます！もう一度", Toast.LENGTH_SHORT).show();
                recreate(); // アクティビティを再起動
            }
        });
    }
}
