package ClassifierHeartDisease;

import weka.classifiers.Classifier;
import weka.core.Instances;

public class Classify {

    public Instances classifyData(Classifier model, Instances data) {
        Instances labeled = new Instances(data);
        for (int i = 0; i < data.numInstances(); i++) {
            try {
                double label = model.classifyInstance(data.instance(i));
                labeled.instance(i).setClassValue(label);
            } catch (Exception e) {
                throw new RuntimeException("ERROR" + e.getMessage(), e);
            }
        }
        return labeled;
    }
}
