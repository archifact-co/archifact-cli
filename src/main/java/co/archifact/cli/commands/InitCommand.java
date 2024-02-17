package co.archifact.cli.commands;

import picocli.CommandLine.Command;
import picocli.CommandLine.Option;

@Command(name = "init", description = "Initializes a new 'archifact' project.")
public class InitCommand implements Runnable {

    @Option(names = {"-n", "--name"}, description = "The name of the project.", required = true)
    private String projectName;

    @Override
    public void run() {
        System.out.printf("Initializing new 'archifact' project: %s%n", projectName);
        // Implementation for initializing a new project
    }
}