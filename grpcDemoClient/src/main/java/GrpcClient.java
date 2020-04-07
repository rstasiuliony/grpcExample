import com.hardfreedom.grpc.User;
import com.hardfreedom.grpc.userGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class GrpcClient {

    public static void main(String[] args) {

        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 9090).usePlaintext().build();

        //we need stubs - they will be generated from proto files (take the same proto file from server)
        //so my stub will be able to use services from proto file, in this case - login and logout
        //because my proto requires LoginRequest as an input, I have to create it first.
        userGrpc.userBlockingStub userStub = userGrpc.newBlockingStub(channel);

        User.LoginRequest loginRequest = User.LoginRequest.newBuilder().setUsername("asd").setPassword("asd").build();
        User.APIResponse response = userStub.login(loginRequest);

        System.out.println(response);
    }
}
