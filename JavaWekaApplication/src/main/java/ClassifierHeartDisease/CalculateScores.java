package ClassifierHeartDisease;

import weka.core.Instances;

public class CalculateScores {

    private int TP = 0;
    private int FN = 0;
    private int FP = 0;
    private int TN = 0;

    public void calculation(Instances predictions, Instances data) {
        double classified;
        double actual;
        for (int i = 0; i < data.numInstances(); i++) {
            // 0 Presence
            // 1 Absence
            classified = predictions.instance(i).classValue();
            actual = data.instance(i).classValue();
            if (classified == 0.0) {
                // Classified as Presence
                // Check Actual
                if (actual == 0.0) {
                    TN++;
                } else {FN++;}
            } else if (actual == 0.0) {
                FP++;
            } else {TP++;}
        }
        System.out.println(
                String.format("Classified as: \nPresence | Absence \n---------|--------\n\t%d  | %d \n\t%d   | %d", TN, FP, FN, TP)
        );
    }
}
