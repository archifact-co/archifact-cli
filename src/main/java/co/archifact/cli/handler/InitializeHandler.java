package co.archifact.cli.handler;

import co.archifact.core.InitializeWorkspaceRequest;
import co.archifact.core.WorkspaceServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class InitializeHandler {

    public void initializeWorkspace(String projectName) {
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 8080)
                .usePlaintext()
                .build();

        WorkspaceServiceGrpc.WorkspaceServiceBlockingStub stub = WorkspaceServiceGrpc.newBlockingStub(channel);

        stub.initializeWorkspace(
                InitializeWorkspaceRequest.newBuilder()
                        .setWorkspaceName(projectName)
                        .build()
        );
        channel.shutdown();
    }
}
