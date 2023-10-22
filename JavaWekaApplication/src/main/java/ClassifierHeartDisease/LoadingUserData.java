package ClassifierHeartDisease;

import weka.core.Attribute;
import weka.core.Instances;
import weka.core.converters.ConverterUtils;

import java.util.List;

public class LoadingUserData {

    private boolean labelsGiven;

    public Instances loadData(String dataFile, CommandLineParsing starter) {
        try {
            ConverterUtils.DataSource reader = new ConverterUtils.DataSource(dataFile);
            Instances data = reader.getDataSet();
            try {
                List<String> classLabels = List.of("Absence", "Presence");
                Attribute newClassAttribute = new Attribute("Heart.Disease", classLabels);
                data.insertAttributeAt(newClassAttribute, data.numAttributes());
                data.setClassIndex(data.numAttributes()-1);
                this.labelsGiven = false;
            } catch (IllegalArgumentException e) {
                data.setClassIndex(data.numAttributes()-1);
                this.labelsGiven = true;
            }
            return data;
        } catch (Exception e) {
            throw new RuntimeException("ERROR!" + e.getMessage());
        }
    }

    public boolean isLabelsGiven() {
        return labelsGiven;
    }
}
