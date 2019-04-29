package kg.erlanju.client.service.runner.impl;

import kg.erlanju.client.dto.BalanceRequestDto;
import kg.erlanju.client.dto.DepositRequestDto;
import kg.erlanju.client.dto.WithdrawRequestDto;
import kg.erlanju.client.enums.Currency;
import kg.erlanju.client.service.client.BalanceServiceClient;
import kg.erlanju.client.service.client.DepositServiceClient;
import kg.erlanju.client.service.client.WithdrawServiceClient;
import kg.erlanju.client.service.runner.RoundsRunner;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class RoundsRunnerImpl implements RoundsRunner {

    @Autowired
    private DepositServiceClient depositServiceClient;

    @Autowired
    private WithdrawServiceClient withdrawServiceClient;

    @Autowired
    private BalanceServiceClient balanceServiceClient;


    @Override
    public void runFirstRound(Integer userId) {
        log.info("ROUND 1");
        depositServiceClient.deposit(new DepositRequestDto(userId, 100d, Currency.USD));
        withdrawServiceClient.withdraw(new WithdrawRequestDto(userId, 200d, Currency.USD));
        depositServiceClient.deposit(new DepositRequestDto(userId, 100d, Currency.EUR));
        balanceServiceClient.checkBalance(new BalanceRequestDto(userId));
        withdrawServiceClient.withdraw(new WithdrawRequestDto(userId, 100d, Currency.USD));
        balanceServiceClient.checkBalance(new BalanceRequestDto(userId));
        withdrawServiceClient.withdraw(new WithdrawRequestDto(userId, 100d, Currency.USD));
    }

    @Override
    public void runSecondRound(Integer userId) {
        log.info("ROUND 2");
        withdrawServiceClient.withdraw(new WithdrawRequestDto(userId, 100d, Currency.GBP));
        depositServiceClient.deposit(new DepositRequestDto(userId, 300d, Currency.GBP));
        withdrawServiceClient.withdraw(new WithdrawRequestDto(userId, 100d, Currency.GBP));
        withdrawServiceClient.withdraw(new WithdrawRequestDto(userId, 100d, Currency.GBP));
        withdrawServiceClient.withdraw(new WithdrawRequestDto(userId, 100d, Currency.GBP));
    }

    @Override
    public void runThirdRound(Integer userId) {
        log.info("ROUND 3");
        balanceServiceClient.checkBalance(new BalanceRequestDto(userId));
        depositServiceClient.deposit(new DepositRequestDto(userId, 100d, Currency.USD));
        depositServiceClient.deposit(new DepositRequestDto(userId, 100d, Currency.USD));
        withdrawServiceClient.withdraw(new WithdrawRequestDto(userId, 100d, Currency.USD));
        depositServiceClient.deposit(new DepositRequestDto(userId, 100d, Currency.USD));
        balanceServiceClient.checkBalance(new BalanceRequestDto(userId));
        withdrawServiceClient.withdraw(new WithdrawRequestDto(userId, 200d, Currency.USD));
        balanceServiceClient.checkBalance(new BalanceRequestDto(userId));
    }

}
