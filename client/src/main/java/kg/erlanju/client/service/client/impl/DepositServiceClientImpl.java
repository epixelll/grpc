package kg.erlanju.client.service.client.impl;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import kg.erlanju.DepositRequest;
import kg.erlanju.DepositServiceGrpc;
import kg.erlanju.client.dto.DepositRequestDto;
import kg.erlanju.client.service.client.DepositServiceClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class DepositServiceClientImpl implements DepositServiceClient {
    private static final Logger LOGGER = LoggerFactory.getLogger(DepositServiceClientImpl.class);

    private DepositServiceGrpc.DepositServiceBlockingStub depositServiceBlockingStub;

    @PostConstruct
    private void init() {
        ManagedChannel managedChannel = ManagedChannelBuilder.forAddress("localhost", 6565).usePlaintext().build();

        depositServiceBlockingStub = DepositServiceGrpc.newBlockingStub(managedChannel);
    }

    @Override
    public void deposit(DepositRequestDto requestDto) {
        DepositRequest depositRequest = DepositRequest.newBuilder()
                .setUserId(requestDto.getUserId())
                .setCurrency(DepositRequest.Currency.valueOf(requestDto.getCurrency().toString()))
                .setAmount(requestDto.getAmount())
                .build();

        depositServiceBlockingStub.deposit(depositRequest);
    }
}