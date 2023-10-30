package ClassifierHeartDisease;

public class Main {

    public static void main(String[] args) {
        CommandLineParsing starter = new CommandLineParsing();
        try {
            starter.initialize(args);
            System.out.println("Starting Classifier Application...");
            Controlling controlling = new Controlling(starter);
        } catch (Exception e) {
            System.out.println((String.format("(Line %d) %s: %s",
                    e.getStackTrace()[0].getLineNumber(),
                    e.getClass().getSimpleName(), e.getMessage())));
            starter.help();
        }
    }
}
