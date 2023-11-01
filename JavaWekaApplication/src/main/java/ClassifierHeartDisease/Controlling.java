package ClassifierHeartDisease;

import weka.classifiers.Classifier;
import weka.core.Instances;

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
            // Only when the class labels are given, the confusion matrix can be constructed
            if (!this.labelsGiven) {
                System.out.println("User didn't provide labels at input");
            } else System.out.println(new ConfusionMatrix().getFeedback(this.predictions, this.data));}
        if (this.starter.isAreaUnderAOC()) {
            if (!this.labelsGiven) {
                System.out.println("User didn't provide labels at input");
            } else System.out.println(new AreaUnderAOC(this.model).getFeedback(this.data, this.predictions));}
        if (this.starter.isWritingOut()) {
            WritingOutput writingOutput = new WritingOutput(this.starter);
            System.out.println(writingOutput.getFeedback(this.data, this.predictions));}
        // If the user didn't provide any feedback, the predictions are being printed in terminal
        if (!this.starter.isConfusionMatrix() & !this.starter.isAreaUnderAOC() & !this.starter.isWritingOut()) {
            System.out.println("\nPredictions:" + "\n" + this.predictions + "\n");
        }
    }
}
