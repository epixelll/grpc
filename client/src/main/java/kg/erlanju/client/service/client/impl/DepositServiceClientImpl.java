package kg.erlanju.client.service.client.impl;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import kg.erlanju.DepositRequest;
import kg.erlanju.DepositResponse;
import kg.erlanju.DepositServiceGrpc;
import kg.erlanju.client.dto.DepositRequestDto;
import kg.erlanju.client.service.client.DepositServiceClient;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Slf4j
@Service
public class DepositServiceClientImpl implements DepositServiceClient {

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

        try{
            depositServiceBlockingStub.deposit(depositRequest);
            log.info(String.format("DEPOSIT: %.2f %s to users(id = %d) account", requestDto.getAmount(), requestDto.getCurrency(), requestDto.getUserId()));
        }catch (Exception e) {
            log.error(String.format("DEPOSIT ERROR(%s) on user(id = %d) for %.2f %s", e.getMessage(), requestDto.getUserId(), requestDto.getAmount(), requestDto.getCurrency()));
        }
    }
}
