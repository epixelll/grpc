package kg.erlanju.client.service.client;

import kg.erlanju.client.dto.WithdrawRequestDto;

public interface WithdrawServiceClient {
    void withdraw(WithdrawRequestDto requestDto);
}
