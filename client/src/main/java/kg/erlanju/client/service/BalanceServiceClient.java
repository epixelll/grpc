package kg.erlanju.client.service;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import kg.erlanju.BalanceRequest;
import kg.erlanju.BalanceResponse;
import kg.erlanju.BalanceServiceGrpc;
import kg.erlanju.client.dto.BalanceRequestDto;
import kg.erlanju.client.dto.BalanceResponseDto;
import kg.erlanju.client.dto.WalletInfoDto;
import kg.erlanju.client.enums.Currency;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.math.BigDecimal;
import java.util.stream.Collectors;

@Component
public class BalanceServiceClient {
    private static final Logger LOGGER = LoggerFactory.getLogger(BalanceServiceClient.class);

    private BalanceServiceGrpc.BalanceServiceBlockingStub balanceServiceBlockingStub;

    @PostConstruct
    private void init() {
        ManagedChannel managedChannel = ManagedChannelBuilder.forAddress("localhost", 6565).usePlaintext().build();

        balanceServiceBlockingStub = BalanceServiceGrpc.newBlockingStub(managedChannel);
    }

    public BalanceResponseDto checkBalance(BalanceRequestDto requestDto) {
        BalanceRequest balanceRequest = BalanceRequest.newBuilder()
                .setUserId(requestDto.getUserId())
                .build();

        BalanceResponse balanceResponse = balanceServiceBlockingStub.checkBalance(balanceRequest);

        return new BalanceResponseDto(
                balanceResponse.getUserId(),
                balanceResponse.getWalletList().stream().map(w ->
                        new WalletInfoDto(Currency.valueOf(w.getCurrency().toString()), BigDecimal.valueOf(w.getAmount()))
                ).collect(Collectors.toSet())
        );
    }
}
