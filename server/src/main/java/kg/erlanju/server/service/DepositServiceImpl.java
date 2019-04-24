//package kg.erlanju.server.service;
//
//import io.grpc.stub.StreamObserver;
//import kg.erlanju.HelloRequest;
//import kg.erlanju.HelloResponse;
//import kg.erlanju.HelloServiceGrpc;
//import org.lognet.springboot.grpc.GRpcService;
//
//@GRpcService
//public class DepositServiceImpl extends HelloServiceGrpc.HelloServiceImplBase {
//
//    @Override
//    public void hello(HelloRequest request, StreamObserver<HelloResponse> responseObserver){
//        final HelloResponse.Builder responseBuilder = HelloResponse.newBuilder();
//        responseObserver.onNext(responseBuilder.build());
//        responseObserver.onCompleted();
//    }
//}
