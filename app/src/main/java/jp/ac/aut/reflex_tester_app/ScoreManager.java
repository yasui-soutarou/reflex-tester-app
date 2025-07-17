package jp.ac.aut.reflex_tester_app;

import java.util.ArrayList;
import java.util.List;

public class ScoreManager {

    private static ScoreManager instance;
    private final List<Double> scores;

    private ScoreManager() {
        scores = new ArrayList<>();
    }

    public static synchronized ScoreManager getInstance() {
        if (instance == null) {
            instance = new ScoreManager();
        }
        return instance;
    }

    public void addScore(double score) {
        scores.add(score);
    }

    public List<Double> getScores() {
        return new ArrayList<>(scores); // 外部から変更されないようにコピーを返す
    }

    public void clearScores() {
        scores.clear();
    }
}
