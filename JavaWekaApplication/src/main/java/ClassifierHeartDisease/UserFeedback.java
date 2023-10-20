package ClassifierHeartDisease;

import weka.core.Instances;

public interface UserFeedback {

    String getFeedback(Instances data, Instances predictions);
}
