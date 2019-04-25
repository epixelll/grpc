package kg.erlanju.server;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import kg.erlanju.DepositServiceGrpc;
import kg.erlanju.WithdrawRequest;
import kg.erlanju.WithdrawResponse;
import kg.erlanju.WithdrawServiceGrpc;
import kg.erlanju.server.dto.WithdrawRequestDto;
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
    private AccountRepository accountRepository;

    @Autowired
    private WalletRepository walletRepository;

    private DepositServiceGrpc.DepositServiceBlockingStub depositServiceBlockingStub;
    private WithdrawServiceGrpc.WithdrawServiceBlockingStub withdrawServiceBlockingStub;

    @PostConstruct
    private void init() {
        initDatabaseAccount();

        ManagedChannel managedChannel = ManagedChannelBuilder.forAddress("localhost", 6565).usePlaintext().build();

        depositServiceBlockingStub = DepositServiceGrpc.newBlockingStub(managedChannel);
        withdrawServiceBlockingStub = WithdrawServiceGrpc.newBlockingStub(managedChannel);
    }


    @Test
    public void contextLoads() {
    }

    @Test(expected = IllegalStateException.class)
    public void withdrawalOf200USD_throwsInsufficientFundsException() {
        WithdrawResponse response = withdrawServiceBlockingStub.withdraw(get200USDWithdrawRequest());
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
