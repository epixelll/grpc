package kg.erlanju.server.service.impl;

import kg.erlanju.server.dto.BalanceResponseDto;
import kg.erlanju.server.entity.Account;
import kg.erlanju.server.mapper.BalanceMapper;
import kg.erlanju.server.repository.AccountRepository;
import kg.erlanju.server.service.AccountService;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;

@Service
public class AccountServiceImpl implements AccountService {

    private AccountRepository accountRepository;
    private BalanceMapper balanceMapper;

    public AccountServiceImpl(
            AccountRepository accountRepository,
            BalanceMapper balanceMapper
    ) {
        this.accountRepository = accountRepository;
        this.balanceMapper = balanceMapper;
    }

    @Override
    public Account findById(Integer accountId) {
        return accountRepository.findById(accountId)
                .orElseThrow(() -> new EntityNotFoundException(String.format("Account with id: %s not found", accountId)));
    }

    @Override
    @Transactional
    public BalanceResponseDto getBalance(Integer accountId) {
        return balanceMapper.accountToBalanceResponseDto(findById(accountId));
    }
}
