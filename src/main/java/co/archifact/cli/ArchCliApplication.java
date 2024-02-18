package co.archifact.cli;

import co.archifact.cli.commands.InitCommand;
import co.archifact.cli.handler.InitializeHandler;
import picocli.CommandLine;

@CommandLine.Command(name = "af",
        description = "The 'af' CLI for cloud infrastructure management."
)
public class ArchCliApplication implements Runnable {

    @Override
    public void run() {
        // This method can be used to run any code when the main command is invoked without subcommands
        CommandLine.usage(this, System.out);
    }

    public static void main(String[] args) {
        CommandLine commandLine = new CommandLine(new ArchCliApplication());
        commandLine.addSubcommand(new InitCommand(
                new InitializeHandler()
        ));
        int exitCode = commandLine.execute(args);
        System.exit(exitCode);
    }
}