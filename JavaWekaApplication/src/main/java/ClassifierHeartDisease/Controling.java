package ClassifierHeartDisease;

import weka.classifiers.Classifier;
import weka.classifiers.Evaluation;
import weka.core.Instances;
import weka.core.converters.ArffSaver;
import weka.gui.beans.CrossValidationFoldMaker;

import java.io.File;
import java.util.Arrays;

import static weka.clusterers.ClusterEvaluation.crossValidateModel;

public class Controling {
    private CommandLineParsing starter;
    private Classifier model;
    private Instances data;
    private Instances predictions;

    public Controling(CommandLineParsing starter) {
        this.starter = starter;
        loading();
        predicting();
        userScore();
    }

    private void loading() {
        // laad model
        this.model = new LoadingModelData().loadClassifier();
        // laad data
        this.data = new LoadingUserData().loadData(this.starter.getFilename());
    }

    private void predicting(){
        // voorspel
        this.predictions = new Classify().classifyData(this.model, this.data);
    }

    private void userScore() {
        if (this.starter.isConfusionMatrix()) {
            ConfusionMatrix matrix = new ConfusionMatrix();
            String print = matrix.getFeedback(this.predictions, this.data);
            System.out.println(print);
        } else if (this.starter.isAreaUnderAOC()) {
            // get the area under aoc
            try {
                Evaluation eval = new Evaluation(predictions);
                eval.evaluateModel(this.model, this.data);
                System.out.println(eval.areaUnderROC(0));
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        } else if (this.starter.isWritingOut()) {
            // writing output to a new file
            try {
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
