package kg.erlanju.server.mapper;

import kg.erlanju.server.dto.BalanceResponseDto;
import kg.erlanju.server.entity.Account;

public interface BalanceMapper {
    BalanceResponseDto accountToBalanceResponseDto(Account account);
}
