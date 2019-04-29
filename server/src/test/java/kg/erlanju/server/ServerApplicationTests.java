package kg.erlanju.server;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.StatusRuntimeException;
import kg.erlanju.*;
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

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.fail;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ServerApplicationTests {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private WalletRepository walletRepository;

    private DepositServiceGrpc.DepositServiceBlockingStub depositServiceBlockingStub;
    private WithdrawServiceGrpc.WithdrawServiceBlockingStub withdrawServiceBlockingStub;
    private BalanceServiceGrpc.BalanceServiceBlockingStub balanceServiceBlockingStub;

    @PostConstruct
    private void init() {
        initDatabaseAccount();

        ManagedChannel managedChannel = ManagedChannelBuilder.forAddress("localhost", 6565).usePlaintext().build();

        depositServiceBlockingStub = DepositServiceGrpc.newBlockingStub(managedChannel);
        withdrawServiceBlockingStub = WithdrawServiceGrpc.newBlockingStub(managedChannel);
        balanceServiceBlockingStub = BalanceServiceGrpc.newBlockingStub(managedChannel);
    }


    @Test
    public void contextLoads() {
    }

    @Test
    public void test() {
        //1
        try {
            withdrawServiceBlockingStub.withdraw(get200USDWithdrawRequest());
        }catch (StatusRuntimeException e) {
            assertThat(e.getStatus().getDescription()).isEqualTo("insufficient_funds");
        }

        //2
        depositServiceBlockingStub.deposit(getDepositRequest(DepositRequest.Currency.USD, 100d));

        //3
        BalanceResponse balanceResponse = balanceServiceBlockingStub.checkBalance(getBalanceRequest());
        Double usdAmount = balanceResponse.getWalletList().stream().filter(w -> w.getCurrency().equals(BalanceResponse.Currency.USD)).findFirst().get().getAmount();
        assertThat(usdAmount).isEqualTo(100d);

        //4
        try {
            withdrawServiceBlockingStub.withdraw(get200USDWithdrawRequest());
        }catch (StatusRuntimeException e) {
            assertThat(e.getStatus().getDescription()).isEqualTo("insufficient_funds");
        }

        //5
        depositServiceBlockingStub.deposit(getDepositRequest(DepositRequest.Currency.EUR, 100d));

        //6
        balanceResponse = balanceServiceBlockingStub.checkBalance(getBalanceRequest());
        usdAmount = balanceResponse.getWalletList().stream().filter(w -> w.getCurrency().equals(BalanceResponse.Currency.USD)).findFirst().get().getAmount();
        Double eurAmount = balanceResponse.getWalletList().stream().filter(w -> w.getCurrency().equals(BalanceResponse.Currency.EUR)).findFirst().get().getAmount();
        assertThat(usdAmount).isEqualTo(100d);
        assertThat(eurAmount).isEqualTo(100d);

        //7
        try {
            withdrawServiceBlockingStub.withdraw(get200USDWithdrawRequest());
        }catch (StatusRuntimeException e) {
            assertThat(e.getStatus().getDescription()).isEqualTo("insufficient_funds");
        }

        //8
        depositServiceBlockingStub.deposit(getDepositRequest(DepositRequest.Currency.USD, 100d));

        //9
        balanceResponse = balanceServiceBlockingStub.checkBalance(getBalanceRequest());
        usdAmount = balanceResponse.getWalletList().stream().filter(w -> w.getCurrency().equals(BalanceResponse.Currency.USD)).findFirst().get().getAmount();
        eurAmount = balanceResponse.getWalletList().stream().filter(w -> w.getCurrency().equals(BalanceResponse.Currency.EUR)).findFirst().get().getAmount();
        assertThat(usdAmount).isEqualTo(200d);
        assertThat(eurAmount).isEqualTo(100d);

        //10
        try {
            withdrawServiceBlockingStub.withdraw(get200USDWithdrawRequest());
        }catch (StatusRuntimeException e) {
            fail("There is exception in withdraw.");
            throw e;
        }

        //11
        balanceResponse = balanceServiceBlockingStub.checkBalance(getBalanceRequest());
        usdAmount = balanceResponse.getWalletList().stream().filter(w -> w.getCurrency().equals(BalanceResponse.Currency.USD)).findFirst().get().getAmount();
        eurAmount = balanceResponse.getWalletList().stream().filter(w -> w.getCurrency().equals(BalanceResponse.Currency.EUR)).findFirst().get().getAmount();
        assertThat(usdAmount).isEqualTo(0d);
        assertThat(eurAmount).isEqualTo(100d);

        //12
        try {
            withdrawServiceBlockingStub.withdraw(get200USDWithdrawRequest());
        }catch (StatusRuntimeException e) {
            assertThat(e.getStatus().getDescription()).isEqualTo("insufficient_funds");
        }
    }

    private BalanceRequest getBalanceRequest() {
        return BalanceRequest.newBuilder()
                .setUserId(1)
                .build();
    }

    private DepositRequest getDepositRequest(DepositRequest.Currency currency, Double amount) {
        return DepositRequest.newBuilder()
                .setUserId(1)
                .setCurrency(currency)
                .setAmount(amount)
                .build();
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
