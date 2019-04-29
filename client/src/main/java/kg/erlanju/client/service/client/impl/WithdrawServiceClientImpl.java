package kg.erlanju.client.service.client.impl;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import kg.erlanju.WithdrawRequest;
import kg.erlanju.WithdrawServiceGrpc;
import kg.erlanju.client.dto.WithdrawRequestDto;
import kg.erlanju.client.service.client.WithdrawServiceClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Slf4j
@Component
public class WithdrawServiceClientImpl implements WithdrawServiceClient {

    private WithdrawServiceGrpc.WithdrawServiceBlockingStub withdrawServiceBlockingStub;

    @PostConstruct
    private void init() {
        ManagedChannel managedChannel = ManagedChannelBuilder.forAddress("localhost", 6565).usePlaintext().build();

        withdrawServiceBlockingStub = WithdrawServiceGrpc.newBlockingStub(managedChannel);
    }

    @Override
    public void withdraw(WithdrawRequestDto requestDto) {
        WithdrawRequest withdrawRequest = WithdrawRequest.newBuilder()
                .setUserId(requestDto.getUserId())
                .setCurrency(WithdrawRequest.Currency.valueOf(requestDto.getCurrency().toString()))
                .setAmount(requestDto.getAmount())
                .build();

        try {
            withdrawServiceBlockingStub.withdraw(withdrawRequest);
            log.info(String.format("WITHDRAW: %.2f %s to users(id = %d) account", requestDto.getAmount(), requestDto.getCurrency(), requestDto.getUserId()));
        } catch (Exception e){
            log.error(String.format("WITHDRAW ERROR(%s) on user(id = %d) for %.2f %s", e.getMessage(), requestDto.getUserId(), requestDto.getAmount(), requestDto.getCurrency()));
        }
    }
}
