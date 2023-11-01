package ClassifierHeartDisease;

import weka.classifiers.Classifier;
import weka.core.SerializationHelper;

import java.io.File;

public class LoadingModelData {

    private static final String MODELNAME = "Stacking_Heart_Disease_Model.model";

    public Classifier loadClassifier() {
        if (new File(this.MODELNAME).isFile()) {
            try {
                return (Classifier) SerializationHelper.read(this.MODELNAME);
            } catch (Exception e) {
                throw new RuntimeException("Error loading the classifier model");
            }
        } else throw new RuntimeException("Something is wrong with the Model file!");
    }
}