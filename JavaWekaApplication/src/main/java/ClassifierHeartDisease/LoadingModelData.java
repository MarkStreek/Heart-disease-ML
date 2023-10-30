package ClassifierHeartDisease;

import weka.classifiers.Classifier;
import weka.core.SerializationHelper;

public class LoadingModelData {

    private static final String MODELNAME = "Stacking_Heart_Disease_Model.model";

    public Classifier loadClassifier() {
        try {
            return (Classifier) SerializationHelper.read(this.MODELNAME);
        } catch (Exception e) {
            throw new RuntimeException("ERROR" + e.getMessage());
        }
    }
}