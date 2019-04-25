package kg.erlanju.client.service;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import kg.erlanju.WithdrawRequest;
import kg.erlanju.WithdrawServiceGrpc;
import kg.erlanju.client.dto.WithdrawRequestDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class WithdrawServiceClient {
    private static final Logger LOGGER = LoggerFactory.getLogger(WithdrawServiceClient.class);

    private WithdrawServiceGrpc.WithdrawServiceBlockingStub withdrawServiceBlockingStub;

    @PostConstruct
    private void init() {
        ManagedChannel managedChannel = ManagedChannelBuilder.forAddress("localhost", 6565).usePlaintext().build();

        withdrawServiceBlockingStub = WithdrawServiceGrpc.newBlockingStub(managedChannel);
    }

    public void withdraw(WithdrawRequestDto requestDto) {
        WithdrawRequest withdrawRequest = WithdrawRequest.newBuilder()
                .setUserId(requestDto.getUserId())
                .setCurrency(WithdrawRequest.Currency.valueOf(requestDto.getCurrency().toString()))
                .setAmount(requestDto.getAmount())
                .build();

        withdrawServiceBlockingStub.withdraw(withdrawRequest);
    }
}
