package kg.erlanju.server.endpoint;

import io.grpc.stub.StreamObserver;
import kg.erlanju.DepositRequest;
import kg.erlanju.DepositResponse;
import kg.erlanju.DepositServiceGrpc;
import kg.erlanju.server.dto.DepositRequestDto;
import kg.erlanju.server.mapper.DepositMapper;
import kg.erlanju.server.service.WalletService;
import org.lognet.springboot.grpc.GRpcService;
import org.springframework.beans.factory.annotation.Autowired;

@GRpcService
public class DepositGrpcServiceImpl extends DepositServiceGrpc.DepositServiceImplBase {

    private WalletService walletService;
    private DepositMapper depositMapper;

    @Autowired
    public DepositGrpcServiceImpl(
            DepositMapper depositMapper,
            WalletService walletService
    ) {
        this.depositMapper = depositMapper;
        this.walletService = walletService;
    }

    @Override
    public void deposit(DepositRequest request, StreamObserver<DepositResponse> responseObserver){

        DepositRequestDto depositRequestDto = depositMapper.toDepositRequestDto(request);
        walletService.deposit(depositRequestDto);

        final DepositResponse.Builder responseBuilder = DepositResponse.newBuilder();

        responseObserver.onNext(responseBuilder.build());
        responseObserver.onCompleted();
    }
}
