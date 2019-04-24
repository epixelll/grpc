package kg.erlanju.server.endpoint;

import io.grpc.stub.StreamObserver;
import kg.erlanju.DepositServiceGrpc;
import kg.erlanju.DepositRequest;
import kg.erlanju.DepositResponse;
import kg.erlanju.DepositServiceGrpc;
import org.lognet.springboot.grpc.GRpcService;

@GRpcService
public class DepositGrpcServiceImpl extends DepositServiceGrpc.DepositServiceImplBase {

    @Override
    public void deposit(DepositRequest request, StreamObserver<DepositResponse> responseObserver){
        final DepositResponse.Builder responseBuilder = DepositResponse.newBuilder();
        System.out.println(request.getAmount() + ": " + request.getCurrency() + ": " + request.getUserId());
        responseObserver.onNext(responseBuilder.build());
        responseObserver.onCompleted();
    }
}
