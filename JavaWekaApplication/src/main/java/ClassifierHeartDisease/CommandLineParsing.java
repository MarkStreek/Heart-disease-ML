package ClassifierHeartDisease;

import org.apache.commons.cli.*;

public class CommandLineParsing {
    private CommandLine commandLine;
    private String[] arg;
    private final Options options = new Options();
    public void initialize(String[] arg) {
        this.arg = arg;
        buildOptions();
        processCommandLine();
    }

    private void buildOptions() {
        Option input = new Option("f", "filename", true, "Name of the file");
        input.setRequired(true);
        options.addOption(input);

        Option confusionMatrix = new Option("m", "confusionMatrix", false, "Show the confustion Matrix of the predictions");
        confusionMatrix.setRequired(false);
        options.addOption(confusionMatrix);

        Option areaUnderAOC = new Option("a", "areaUnderAOC", false, "Get the area under AOC");
        areaUnderAOC.setRequired(false);
        options.addOption(areaUnderAOC);

        Option writingOut = new Option("w", "writingOut", false, "Writing the output to a file");
        writingOut.setRequired(false);
        options.addOption(writingOut);
    }

    private void processCommandLine() {
        try {
            CommandLineParser parser = new DefaultParser();
            this.commandLine = parser.parse(this.options, this.arg);
        } catch (ParseException e) {
            System.out.println(e.getMessage());
            throw new IllegalArgumentException(e);
        }
    }

    public void help(){
        HelpFormatter formatter = new HelpFormatter();
        formatter.printHelp("As Below:",this.options);
    }

    public String getFilename() {
        // return a new String
        // Why return a new string and not just the string?
        // This way, the original can't be changed!
        return new String(this.commandLine.getOptionValue("filename"));
    }

    public boolean isConfusionMatrix() {
        return this.commandLine.hasOption("confusionMatrix");
    }

    public boolean isAreaUnderAOC() {
        return this.commandLine.hasOption("areaUnderAOC");
    }

    public boolean isWritingOut() {
        return this.commandLine.hasOption("writingOut");
    }
}
