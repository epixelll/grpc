package kg.erlanju.client.service.client;

import kg.erlanju.client.dto.BalanceRequestDto;
import kg.erlanju.client.dto.BalanceResponseDto;

public interface BalanceServiceClient {
    BalanceResponseDto checkBalance(BalanceRequestDto requestDto);
}
