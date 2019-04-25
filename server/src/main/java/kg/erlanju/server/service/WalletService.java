package kg.erlanju.server.service;

import kg.erlanju.server.dto.DepositRequestDto;
import kg.erlanju.server.dto.WithdrawRequestDto;

public interface WalletService {
    void deposit(DepositRequestDto depositRequestDto);
    void withdraw(WithdrawRequestDto withdrawRequestDto);
}
