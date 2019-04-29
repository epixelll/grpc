package kg.erlanju.client.service.client;

import kg.erlanju.client.dto.DepositRequestDto;

public interface DepositServiceClient {
    void deposit(DepositRequestDto requestDto);
}
