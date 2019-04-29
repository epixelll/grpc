package kg.erlanju.server.service.impl;


import kg.erlanju.server.dto.DepositRequestDto;
import kg.erlanju.server.dto.WithdrawRequestDto;
import kg.erlanju.server.entity.Account;
import kg.erlanju.server.entity.Wallet;
import kg.erlanju.server.enums.Currency;
import kg.erlanju.server.repository.WalletRepository;
import kg.erlanju.server.service.AccountService;
import kg.erlanju.server.service.WalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigDecimal;

@Service
public class WalletServiceImpl implements WalletService {

    private WalletRepository walletRepository;
    private AccountService accountService;

    @Autowired
    public WalletServiceImpl(
            WalletRepository walletRepository,
            AccountService accountService
    ) {
        this.walletRepository = walletRepository;
        this.accountService = accountService;
    }

    @Override
    @Transactional
    public void deposit(DepositRequestDto depositRequestDto) {
        Wallet wallet = getWallet(depositRequestDto.getAccountId(), depositRequestDto.getCurrency());

        wallet.setAmount(wallet.getAmount().add(depositRequestDto.getAmount()));

        walletRepository.save(wallet);
    }

    @Override
    @Transactional
    public void withdraw(WithdrawRequestDto withdrawRequestDto) {

        Wallet wallet = getWallet(withdrawRequestDto.getAccountId(), withdrawRequestDto.getCurrency());
        BigDecimal newAmount = wallet.getAmount().subtract(withdrawRequestDto.getAmount());

        if(newAmount.compareTo(BigDecimal.ZERO) < 0)
            throw new IllegalStateException("insufficient_funds");

        wallet.setAmount(newAmount);
        walletRepository.save(wallet);
    }

    private Wallet getWallet(Integer accountId, Currency currency) {
        Account account = accountService.findById(accountId);

        return account.getWallets().stream().filter(w -> w.getCurrency().equals(currency)).findAny()
                .orElseThrow(() -> new IllegalStateException("Unknown currency."));
    }
}
