package ClassifierHeartDisease;

import weka.core.Instances;
import weka.core.converters.ArffSaver;

import java.io.File;

public class WritingOutput implements UserFeedback{

    private final CommandLineParsing starter;

    public WritingOutput(CommandLineParsing starter) {
        this.starter = starter;
    }

    @Override
    public String getFeedback(Instances data, Instances predictions) {
        writeOutput(predictions);
        return "Output was successfully written to file";
    }

    private void writeOutput(Instances predictions) {
        try {
            System.out.println("writing output!");
            ArffSaver arff = new ArffSaver();
            arff.setInstances(predictions);
            String filename = this.starter.getOutputFilename();
            filename += ".arff";
            arff.setFile(new File(String.format(filename)));
            arff.writeBatch();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
