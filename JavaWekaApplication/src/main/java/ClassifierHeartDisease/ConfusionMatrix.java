package ClassifierHeartDisease;

import weka.core.Instance;
import weka.core.Instances;

public class ConfusionMatrix implements UserFeedback{

    private int TP = 0;
    private int FN = 0;
    private int FP = 0;
    private int TN = 0;

    @Override
    public String getFeedback(Instances data, Instances predictions) {
        return calculation(data, predictions);
    }

    public String calculation(Instances predictions, Instances data) {
        double classified;
        double actual;
        for (int i = 0; i < data.numInstances(); i++) {
            classified = predictions.instance(i).classValue();
            actual = data.instance(i).classValue();
            if (classified == 0.0) {
                if (actual == 0.0) {
                    TN++;
                } else {FN++;}
            } else if (actual == 0.0) {
                FP++;
            } else {TP++;}
        }
        return String.format("\nClassified as: \nPresence | " +
                        "Absence \n---------|--------\n\t%d  | %d " +
                        "\n\t%d   | %d", TN, FP, FN, TP);
    }
}
