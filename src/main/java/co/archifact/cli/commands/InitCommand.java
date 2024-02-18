package co.archifact.cli.commands;

import co.archifact.cli.handler.InitializeHandler;
import co.archifact.core.DeployResourcesRequest;
import co.archifact.core.ResourceManagementServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;

@Command(name = "init", description = "Initializes a new 'archifact' project.")
public class InitCommand implements Runnable {

    private final InitializeHandler initializeHandler;

    @Option(names = {"-n", "--name"}, description = "The name of the workspace.", required = true)
    private String workspaceName;

    public InitCommand(final InitializeHandler initializeHandler) {
        this.initializeHandler = initializeHandler;
    }

    @Override
    public void run() {
        System.out.printf("Initializing new 'archifact' workspace: %s%n", workspaceName);

        initializeHandler.initializeWorkspace(workspaceName);
    }
}