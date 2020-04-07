import com.hardfreedom.service.UserService;
import io.grpc.Server;
import io.grpc.ServerBuilder;

import java.io.IOException;

public class GrpcServer {

    public static void main(String[] args) throws IOException, InterruptedException {

        //we have to tell on which port we want to run it:
        Server server = ServerBuilder.forPort(9090).addService(new UserService()).build();
        server.start();

        System.out.println("Server started at: " + server.getPort());

        //required if you want to be on "wait mode...". Otherwise it will terminates itself instantly after run.
        server.awaitTermination();
    }
}
