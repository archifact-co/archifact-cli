package co.archifact.cli;

import co.archifact.cli.commands.InitCommand;
import picocli.CommandLine;

@CommandLine.Command(name = "af",
        description = "The 'af' CLI for cloud infrastructure management.",
        subcommands = {InitCommand.class})
public class ArchCliApplication implements Runnable {

    @Override
    public void run() {
        // This method can be used to run any code when the main command is invoked without subcommands
        CommandLine.usage(this, System.out);
    }

    public static void main(String[] args) {
        int exitCode = new CommandLine(new ArchCliApplication()).execute(args);
        System.exit(exitCode);
    }
}