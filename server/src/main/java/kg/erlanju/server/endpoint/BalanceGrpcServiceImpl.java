package kg.erlanju.server.endpoint;

import io.grpc.stub.StreamObserver;
import kg.erlanju.BalanceRequest;
import kg.erlanju.BalanceResponse;
import kg.erlanju.BalanceServiceGrpc;
import kg.erlanju.server.dto.BalanceResponseDto;
import kg.erlanju.server.service.AccountService;
import org.lognet.springboot.grpc.GRpcService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.stream.Collectors;

@GRpcService
public class BalanceGrpcServiceImpl extends BalanceServiceGrpc.BalanceServiceImplBase {

    private AccountService accountService;

    @Autowired
    public BalanceGrpcServiceImpl(AccountService accountService) {
        this.accountService = accountService;
    }

    @Override
    public void checkBalance(BalanceRequest request, StreamObserver<BalanceResponse> responseObserver) {

        BalanceResponseDto balanceResponseDto = accountService.getBalance(request.getUserId());

        final BalanceResponse.Builder responseBuilder = BalanceResponse.newBuilder();

        responseBuilder.setUserId(balanceResponseDto.getAccountId())
                .addAllWallet(balanceResponseDto.getWallets().stream().map(w ->
                    BalanceResponse.Wallet.newBuilder()
                            .setCurrency(BalanceResponse.Currency.valueOf(w.getCurrency().toString()))
                            .setAmount(w.getAmount().doubleValue())
                            .build()
                ).collect(Collectors.toList()));

        responseObserver.onNext(responseBuilder.build());
        responseObserver.onCompleted();
    }
}
