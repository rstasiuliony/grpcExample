package com.hardfreedom.service;


import com.hardfreedom.grpc.User;
import com.hardfreedom.grpc.userGrpc;
import io.grpc.stub.StreamObserver;

public class UserService extends userGrpc.userImplBase {

    @Override
    public void login(User.LoginRequest request, StreamObserver<User.APIResponse> responseObserver) {
        System.out.println("Inside login");
        String username = request.getUsername();
        String passw = request.getPassword();

        //We will get login details through request but we also need to send a response to client:
        User.APIResponse.Builder response = User.APIResponse.newBuilder();

        if (username.equals(passw)) {
            response.setResponsecode(0).setResponsemessage("Success");
        } else {
            response.setResponsecode(100).setResponsemessage("Invalid password");
        }
        //we use "onNext" to return our response;
        responseObserver.onNext(response.build());
        responseObserver.onCompleted();
    }

    @Override
    public void logout(User.Empty request, StreamObserver<User.APIResponse> responseObserver) {
    }
}
