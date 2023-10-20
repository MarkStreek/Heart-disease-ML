package ClassifierHeartDisease;

public class Main {

    public static void main(String[] args) {
        CommandLineParsing starter = new CommandLineParsing();
        try {
            starter.initialize(args);
            System.out.println("Starting Classifier Application...");
            Controling controling = new Controling(starter);
        } catch (Exception e) {
            starter.help();
        }
    }
}
