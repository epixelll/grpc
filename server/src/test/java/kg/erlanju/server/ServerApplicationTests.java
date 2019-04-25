package kg.erlanju.server;

import kg.erlanju.WithdrawRequest;
import kg.erlanju.server.dto.WithdrawRequestDto;
import kg.erlanju.server.endpoint.DepositGrpcServiceImpl;
import kg.erlanju.server.endpoint.WithdrawGrpcServiceImpl;
import kg.erlanju.server.entity.Account;
import kg.erlanju.server.entity.Wallet;
import kg.erlanju.server.enums.Currency;
import kg.erlanju.server.repository.AccountRepository;
import kg.erlanju.server.repository.WalletRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.PostConstruct;
import java.math.BigDecimal;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ServerApplicationTests {

    @Autowired
    private DepositGrpcServiceImpl depositGrpcServiceImpl;

    @Autowired
    private WithdrawGrpcServiceImpl withdrawGrpcServiceImpl;

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private WalletRepository walletRepository;

    @PostConstruct
    public void init() {
        initDatabaseAccount();
    }


    @Test
    public void contextLoads() {
    }

    @Test
    public void withdrawalOf200USD_throwsInsufficientFundsException() {
        withdrawGrpcServiceImpl.withdraw(get200USDWithdrawRequest());
        WithdrawRequestDto requestDto = new WithdrawRequestDto(1, Currency.USD, 100.0);
    }

    private WithdrawRequest get200USDWithdrawRequest() {
        return WithdrawRequest.newBuilder()
                .setUserId(1)
                .setCurrency(WithdrawRequest.Currency.USD)
                .setAmount(200)
                .build();
    }

    private void initDatabaseAccount() {
        Account account = new Account();
        accountRepository.save(account);

        createWalletForCurrency(account, Currency.EUR);
        createWalletForCurrency(account, Currency.USD);
        createWalletForCurrency(account, Currency.GBP);
    }

    private void createWalletForCurrency(Account account, Currency currency) {
        Wallet walletUsd = new Wallet();
        walletUsd.setAccount(account);
        walletUsd.setCurrency(currency);
        walletUsd.setAmount(BigDecimal.ZERO);
        walletRepository.save(walletUsd);
    }
}
