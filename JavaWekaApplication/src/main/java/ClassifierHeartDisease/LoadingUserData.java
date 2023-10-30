package ClassifierHeartDisease;

import weka.Run;
import weka.core.Attribute;
import weka.core.Instances;
import weka.core.converters.ConverterUtils;

import java.io.File;
import java.util.List;

public class LoadingUserData {

    private boolean labelsGiven;

    public Instances loadData(CommandLineParsing starter) {

        if (new File(starter.getFilename()).isFile()) {
            try {
                ConverterUtils.DataSource reader = new ConverterUtils.DataSource(starter.getFilename());
                Instances data = reader.getDataSet();
                try {
                    List<String> classLabels = List.of("Absence", "Presence");
                    Attribute newClassAttribute = new Attribute("Heart.Disease", classLabels);
                    data.insertAttributeAt(newClassAttribute, data.numAttributes());
                    data.setClassIndex(data.numAttributes() - 1);
                    this.labelsGiven = false;
                } catch (IllegalArgumentException e) {
                    data.setClassIndex(data.numAttributes() - 1);
                    this.labelsGiven = true;
                }
                return data;
            } catch (Exception e) {
                throw new RuntimeException(String.format("(Line %d) %s: %s",
                        e.getStackTrace()[0].getLineNumber(),
                        e.getClass().getSimpleName(), e.getMessage()));
            }
        } else throw new RuntimeException("Something is wrong with the given file!");
    }

    public boolean isLabelsGiven() {
        return labelsGiven;
    }
}
