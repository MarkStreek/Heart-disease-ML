package ClassifierHeartDisease;

import org.apache.commons.cli.CommandLine;
import weka.classifiers.Classifier;
import weka.classifiers.Evaluation;
import weka.core.Instances;
import weka.core.converters.ArffSaver;
import java.io.File;


public class Controlling {
    private final CommandLineParsing starter;
    private Classifier model;
    private Instances data;
    private Instances predictions;
    private boolean labelsGiven;

    public Controlling(CommandLineParsing starter) {
        // Storing CL arguments
        this.starter = starter;
        // loading model and user data
        loading();
        // making the predictions
        predicting();
        // User feedback
        userScore();
    }

    private void loading() {
        // load model
        this.model = new LoadingModelData().loadClassifier();
        // Loading user data
        LoadingUserData userData = new LoadingUserData();
        // The commandline arguments are passed, this way the user can access the filename
        this.data = userData.loadData(this.starter);
        // Getting boolean if labels were in the original data
        this.labelsGiven = userData.isLabelsGiven();
    }

    private void predicting(){
        // Making the predictions in the Classify class
        this.predictions = new Classify().classifyData(this.model, this.data);
    }

    private void userScore() {
        // Confusion matrix option
        if (this.starter.isConfusionMatrix()) {
            // Only when the user provided class labels with the input
            // This checking is done when reading the input data
            if (!this.labelsGiven) {
                System.out.println("User didn't provide labels at input");
            } else System.out.println(new ConfusionMatrix().getFeedback(this.predictions, this.data));}

        if (this.starter.isAreaUnderAOC() & this.labelsGiven) {
            // TODO: Maybe move AREA Under AOC to another class
            try {
                Evaluation eval = new Evaluation(predictions);
                eval.evaluateModel(this.model, this.data);
                System.out.println(eval.areaUnderROC(0));
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        if (this.starter.isWritingOut()) {
            WritingOutput writingOutput = new WritingOutput(this.starter);
            System.out.println(writingOutput.getFeedback(this.data, this.predictions));
        }
    }
}
