package kg.erlanju.client.service;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import kg.erlanju.HelloRequest;
import kg.erlanju.HelloResponse;
import kg.erlanju.HelloServiceGrpc;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class HelloServiceClient {
    private static final Logger LOGGER = LoggerFactory.getLogger(HelloServiceClient.class);

    private HelloServiceGrpc.HelloServiceBlockingStub helloServiceBlockingStub;

    @PostConstruct
    private void init() {
        ManagedChannel managedChannel = ManagedChannelBuilder.forAddress("localhost", 6565).usePlaintext().build();

        helloServiceBlockingStub = HelloServiceGrpc.newBlockingStub(managedChannel);
    }

    public String hello(String firstName, String lastName) {
        HelloRequest helloRequest = HelloRequest.newBuilder()
                .setFirstName(firstName)
                .setLastName(lastName)
                .build();

        LOGGER.info("client sending {}",  helloRequest);

        HelloResponse response = helloServiceBlockingStub.hello(helloRequest);

        LOGGER.info("client received {}", response);

        return response.getGreeting();
    }
}
