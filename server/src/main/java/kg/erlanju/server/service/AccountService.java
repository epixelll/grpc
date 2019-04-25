package kg.erlanju.server.service;

import kg.erlanju.server.dto.BalanceResponseDto;
import kg.erlanju.server.entity.Account;

public interface AccountService {
    Account findById(Integer accountId);
    BalanceResponseDto getBalance(Integer accountId);
}
