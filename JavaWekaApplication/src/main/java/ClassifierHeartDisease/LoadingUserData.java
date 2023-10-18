package ClassifierHeartDisease;

import weka.core.Instances;
import weka.core.converters.ConverterUtils;

public class LoadingUserData {

    public Instances loadData(String dataFile) {
        try {
            ConverterUtils.DataSource reader = new ConverterUtils.DataSource(dataFile);
            Instances data = reader.getDataSet();
            data.setClassIndex(data.numAttributes() - 1);
            return data;
        } catch (Exception e) {
            throw new RuntimeException("ERROR!" + e.getMessage());
        }
    }
}
