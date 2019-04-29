package kg.erlanju.server.endpoint;

import io.grpc.Status;
import io.grpc.StatusRuntimeException;
import io.grpc.stub.StreamObserver;
import kg.erlanju.WithdrawRequest;
import kg.erlanju.WithdrawResponse;
import kg.erlanju.WithdrawServiceGrpc;
import kg.erlanju.server.dto.WithdrawRequestDto;
import kg.erlanju.server.mapper.WithdrawMapper;
import kg.erlanju.server.service.WalletService;
import lombok.extern.slf4j.Slf4j;
import org.lognet.springboot.grpc.GRpcService;
import org.springframework.beans.factory.annotation.Autowired;

@Slf4j
@GRpcService
public class WithdrawGrpcServiceImpl extends WithdrawServiceGrpc.WithdrawServiceImplBase {

    private WalletService walletService;
    private WithdrawMapper withdrawMapper;

    @Autowired
    public WithdrawGrpcServiceImpl(
            WithdrawMapper withdrawMapper,
            WalletService walletService
    ) {
        this.withdrawMapper = withdrawMapper;
        this.walletService = walletService;
    }

    @Override
    public void withdraw(WithdrawRequest request, StreamObserver<WithdrawResponse> responseObserver){

        WithdrawRequestDto withdrawRequestDto = withdrawMapper.toWithdrawRequestDto(request);

        try{
            walletService.withdraw(withdrawRequestDto);

            final WithdrawResponse.Builder responseBuilder = WithdrawResponse.newBuilder();
            responseObserver.onNext(responseBuilder.build());
            responseObserver.onCompleted();
        }catch (Exception ex) {
            log.error("onError : {}" , ex.getMessage());
            responseObserver.onError(new StatusRuntimeException(Status.INTERNAL.withDescription(ex.getMessage())));
        }
    }
}
