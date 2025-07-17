package jp.ac.aut.reflex_tester_app;

import java.util.Collections;
import java.util.List;

public class Statistical {

    public static double calculateAverage(List<Double> scores) {
        double sum = 0.0;
        for (double score : scores) {
            sum += score;
        }
        return sum / scores.size();
    }

    public static double calculateMedian(List<Double> scores) {
        List<Double> sorted = new java.util.ArrayList<>(scores);
        Collections.sort(sorted);
        int middle = sorted.size() / 2;
        if (sorted.size() % 2 == 0) {
            return (sorted.get(middle - 1) + sorted.get(middle)) / 2.0;
        } else {
            return sorted.get(middle);
        }
    }

    public static double calculateMax(List<Double> scores) {
        return Collections.max(scores);
    }

    public static double calculateMin(List<Double> scores) {
        return Collections.min(scores);
    }
}
