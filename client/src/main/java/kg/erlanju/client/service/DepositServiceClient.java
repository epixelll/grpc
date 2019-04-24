package kg.erlanju.client.service;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import kg.erlanju.DepositRequest;
import kg.erlanju.DepositResponse;
import kg.erlanju.DepositServiceGrpc;
import kg.erlanju.client.dto.DepositRequestDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class DepositServiceClient {
    private static final Logger LOGGER = LoggerFactory.getLogger(DepositServiceClient.class);

    private DepositServiceGrpc.DepositServiceBlockingStub depositServiceBlockingStub;

    @PostConstruct
    private void init() {
        ManagedChannel managedChannel = ManagedChannelBuilder.forAddress("localhost", 6565).usePlaintext().build();

        depositServiceBlockingStub = DepositServiceGrpc.newBlockingStub(managedChannel);
    }

    public void deposit(DepositRequestDto requestDto) {
        DepositRequest depositRequest = DepositRequest.newBuilder()
                .setUserId(requestDto.getUserId())
                .setCurrency(DepositRequest.Currency.valueOf(requestDto.getCurrency().toString()))
                .setAmount(requestDto.getAmount())
                .build();

        depositServiceBlockingStub.deposit(depositRequest);
    }
}
