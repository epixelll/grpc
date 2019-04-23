package kg.erlanju.client;

import kg.erlanju.client.service.HelloServiceClient;
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
	private HelloServiceClient helloServiceClient;

	@Test
	public void testHello() {
		Assert.assertEquals(
                "Hello John / DOE",
                helloServiceClient.hello("John", "DOE")
        );
	}

}
