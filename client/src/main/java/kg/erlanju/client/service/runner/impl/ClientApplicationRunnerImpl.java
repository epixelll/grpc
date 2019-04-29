package kg.erlanju.client.service.runner.impl;

import kg.erlanju.client.service.runner.ClientApplicationRunner;
import kg.erlanju.client.service.runner.SingleUserRoundsRunner;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.stream.IntStream;

@Service
public class ClientApplicationRunnerImpl implements ClientApplicationRunner {

    private SingleUserRoundsRunner singleUserRoundsRunner;

    public ClientApplicationRunnerImpl(SingleUserRoundsRunner singleUserRoundsRunner){
        this.singleUserRoundsRunner = singleUserRoundsRunner;
    }

    @PostConstruct
    private void run(){
        Integer numberOfUsers = Integer.valueOf(System.getProperty("users"));
        Integer concurrentThreadsPerUser = Integer.valueOf(System.getProperty("concurrent_threads_per_user"));
        Integer roundsPerThread = Integer.valueOf(System.getProperty("rounds_per_thread"));

        IntStream.rangeClosed(1, numberOfUsers).forEach(
                (int i) -> IntStream.rangeClosed(1, concurrentThreadsPerUser).forEach(
                        (int j) -> singleUserRoundsRunner.callRandomRounds(i, roundsPerThread)
                )
        );
    }
}
