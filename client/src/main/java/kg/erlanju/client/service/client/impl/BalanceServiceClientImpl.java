package kg.erlanju.client.service.client.impl;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import kg.erlanju.BalanceRequest;
import kg.erlanju.BalanceResponse;
import kg.erlanju.BalanceServiceGrpc;
import kg.erlanju.client.dto.BalanceRequestDto;
import kg.erlanju.client.dto.BalanceResponseDto;
import kg.erlanju.client.dto.WalletInfoDto;
import kg.erlanju.client.enums.Currency;
import kg.erlanju.client.service.client.BalanceServiceClient;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.math.BigDecimal;
import java.util.stream.Collectors;

@Slf4j
@Component
public class BalanceServiceClientImpl implements BalanceServiceClient {

    private BalanceServiceGrpc.BalanceServiceBlockingStub balanceServiceBlockingStub;

    @PostConstruct
    private void init() {
        ManagedChannel managedChannel = ManagedChannelBuilder.forAddress("localhost", 6565).usePlaintext().build();

        balanceServiceBlockingStub = BalanceServiceGrpc.newBlockingStub(managedChannel);
    }

    @Override
    public BalanceResponseDto checkBalance(BalanceRequestDto requestDto) {
        BalanceRequest balanceRequest = BalanceRequest.newBuilder()
                .setUserId(requestDto.getUserId())
                .build();

        try {
            BalanceResponse balanceResponse = balanceServiceBlockingStub.checkBalance(balanceRequest);

            BalanceResponseDto response = new BalanceResponseDto(
                    balanceResponse.getUserId(),
                    balanceResponse.getWalletList().stream().map(w ->
                            new WalletInfoDto(Currency.valueOf(w.getCurrency().toString()), BigDecimal.valueOf(w.getAmount()))
                    ).collect(Collectors.toSet())
            );

            log.info(String.format("BALANCE: for user(id = %d)", requestDto.getUserId()));
            response.getWallets().forEach((w) -> log.info(String.format("%s: %.2f", w.getCurrency(), w.getAmount())));

            return response;
        } catch (Exception e) {
            log.error(String.format("BALANCE ERROR(%s) on user(id = %d)", e.getMessage(), requestDto.getUserId()));
        }
        return null;
    }
}
