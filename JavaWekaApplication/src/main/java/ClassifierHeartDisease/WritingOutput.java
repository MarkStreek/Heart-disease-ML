package ClassifierHeartDisease;

import weka.core.Instances;
import weka.core.converters.ArffSaver;

import java.io.File;
import java.io.FileWriter;

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
            String filename = this.starter.getOutputFilename();
            filename += ".arff";
            FileWriter myWriter = new FileWriter(filename);
            myWriter.write(String.valueOf(predictions));
            myWriter.close();
            System.out.println("Successfully wrote to the file.");

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
