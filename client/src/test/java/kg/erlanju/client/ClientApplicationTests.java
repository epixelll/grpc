package kg.erlanju.client;

import kg.erlanju.client.dto.DepositRequestDto;
import kg.erlanju.client.enums.Currency;
import kg.erlanju.client.service.DepositServiceClient;
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

	@Test
	public void testDeposit() {
		//arrange
		DepositRequestDto requestDto = new DepositRequestDto(55, 100.0, Currency.USD);
		//act
        depositServiceClient.deposit(requestDto);

		//assert
	}

}
