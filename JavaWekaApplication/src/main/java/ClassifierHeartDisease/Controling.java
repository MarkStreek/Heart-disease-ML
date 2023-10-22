package ClassifierHeartDisease;

import weka.classifiers.Classifier;
import weka.classifiers.Evaluation;
import weka.core.Instances;
import weka.core.converters.ArffSaver;
import java.io.File;


public class Controling {
    private CommandLineParsing starter;
    private Classifier model;
    private Instances data;
    private Instances predictions;
    private boolean labelsGiven;

    public Controling(CommandLineParsing starter) {
        this.starter = starter;
        loading();
        predicting();
        userScore();
    }

    private void loading() {
        // laad model
        this.model = new LoadingModelData().loadClassifier();

        // Loading data
        LoadingUserData userData = new LoadingUserData();
        this.data = userData.loadData(this.starter.getFilename(), this.starter);

        // Getting boolean if labels were in the original data
        this.labelsGiven = userData.isLabelsGiven();
    }

    private void predicting(){
        // voorspel
        this.predictions = new Classify().classifyData(this.model, this.data);
    }

    private void userScore() {
        if (this.starter.isConfusionMatrix() & this.labelsGiven) {
            System.out.println(new ConfusionMatrix().getFeedback(this.predictions, this.data));}
        if (this.starter.isAreaUnderAOC() & this.labelsGiven) {
            // get the area under aoc
            try {
                Evaluation eval = new Evaluation(predictions);
                eval.evaluateModel(this.model, this.data);
                System.out.println(eval.areaUnderROC(0));
            } catch (Exception e) {
                throw new RuntimeException(e);
            }}
        if (this.starter.isWritingOut()) {
            // writing output to a new file
            try {
                System.out.println("writing output!");
                ArffSaver arff = new ArffSaver();
                arff.setInstances(this.predictions);
                arff.setFile(new File(String.format("Predictions" + starter.getFilename())));
                arff.writeBatch();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }
}
