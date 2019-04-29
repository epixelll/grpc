package kg.erlanju.client.service.runner.impl;

import kg.erlanju.client.service.client.BalanceServiceClient;
import kg.erlanju.client.service.client.DepositServiceClient;
import kg.erlanju.client.service.client.WithdrawServiceClient;
import kg.erlanju.client.service.runner.RoundsRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoundsRunnerImpl implements RoundsRunner {

    @Autowired
    private DepositServiceClient depositServiceClient;

    @Autowired
    private WithdrawServiceClient withdrawServiceClient;

    @Autowired
    private BalanceServiceClient balanceServiceClient;


    @Override
    public void runFirstRound() {

    }
}
