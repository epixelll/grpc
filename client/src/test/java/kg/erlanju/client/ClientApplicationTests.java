package kg.erlanju.client;

import kg.erlanju.client.dto.BalanceRequestDto;
import kg.erlanju.client.dto.BalanceResponseDto;
import kg.erlanju.client.dto.DepositRequestDto;
import kg.erlanju.client.dto.WithdrawRequestDto;
import kg.erlanju.client.enums.Currency;
import kg.erlanju.client.service.client.impl.BalanceServiceClient;
import kg.erlanju.client.service.client.impl.DepositServiceClient;
import kg.erlanju.client.service.client.impl.WithdrawServiceClient;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ClientApplicationTests {

	@Autowired
	private DepositServiceClient depositServiceClient;

	@Autowired
	private WithdrawServiceClient withdrawServiceClient;

	@Autowired
	private BalanceServiceClient balanceServiceClient;

	@Test
	public void testDeposit() {
		//arrange
		DepositRequestDto requestDto = new DepositRequestDto(1, 100.0, Currency.USD);
		//act
        depositServiceClient.deposit(requestDto);

		//assert
	}

	@Test
	public void testWithdraw() {
		//arrange
		WithdrawRequestDto requestDto = new WithdrawRequestDto(1, 100.0, Currency.USD);
		//act
		withdrawServiceClient.withdraw(requestDto);

		//assert
	}

	@Test
	public void testBalance() {
		//arrange
		BalanceRequestDto requestDto = new BalanceRequestDto(1);
		//act
		BalanceResponseDto balanceResponseDto = balanceServiceClient.checkBalance(requestDto);

		//assert
	}


}
