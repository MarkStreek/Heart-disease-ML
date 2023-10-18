package ClassifierHeartDisease;

import weka.classifiers.Classifier;
import weka.core.Instances;
import weka.core.SerializationHelper;
import weka.core.converters.ConverterUtils.DataSource;

import java.util.List;


public class Main {

    public static void main(String[] args) {
        try {
            System.out.println("Starting classifier application");
            Main main = new Main();
            main.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void start() throws Exception {
        // laad model
        //Classifier model = loadClassifier("tacking_Heart_Disease_Model.model");
        // laad data
        //Instances data = loadData("Set4.arff");
        // voorspel
        //Instances predictions = classifyData(model, data);

        Classifier model = new LoadingModelData().loadClassifier();
        Instances data = new LoadingUserData().loadData("Set4.arff");
        Instances predictions = classifyData(model, data);

        new CalculateScores().calculation(predictions, data);
    }

    private Classifier loadClassifier(String modelFile) throws Exception {
        // try // except
        SerializationHelper modelReader = new SerializationHelper();
        Classifier model = (Classifier) modelReader.read(modelFile);

        return model;
    }

    private Instances loadData(String dataFile) throws Exception {
        // try // except
        DataSource reader = new DataSource(dataFile);
        Instances data = reader.getDataSet();
        data.setClassIndex(data.numAttributes() - 1);

        return data;
    }

    private Instances classifyData(Classifier model, Instances data) throws Exception {
        Instances labeled = new Instances(data);
        for (int i = 0; i < data.numInstances(); i++) {
            double label = model.classifyInstance(data.instance(i));
            labeled.instance(i).setClassValue(label);
        }

        return labeled;
    }

}
