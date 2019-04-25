package kg.erlanju.server.mapper.impl;

import kg.erlanju.server.dto.BalanceResponseDto;
import kg.erlanju.server.dto.WalletInfoDto;
import kg.erlanju.server.entity.Account;
import kg.erlanju.server.mapper.BalanceMapper;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.stream.Collectors;

@Component
public class BalanceMapperImpl implements BalanceMapper {

    @Override
    public BalanceResponseDto accountToBalanceResponseDto(Account account) {

        Set<WalletInfoDto> walletInfoDtos = account.getWallets().stream()
                .map(w -> new WalletInfoDto(w.getCurrency(), w.getAmount()))
                .collect(Collectors.toSet());

        return new BalanceResponseDto(account.getId(), walletInfoDtos);
    }
}
