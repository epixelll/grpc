package kg.erlanju.client.service.runner.impl;

import kg.erlanju.client.service.runner.ClientApplicationRunner;
import kg.erlanju.client.service.runner.SingleUserRoundsRunner;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.stream.IntStream;

@Slf4j
@Service
public class ClientApplicationRunnerImpl implements ClientApplicationRunner {

    private int numberOfUsers;
    private int concurrentThreadsPerUser;
    private int roundsPerThread;

    private SingleUserRoundsRunner singleUserRoundsRunner;

    public ClientApplicationRunnerImpl(SingleUserRoundsRunner singleUserRoundsRunner) {
        this.singleUserRoundsRunner = singleUserRoundsRunner;
        numberOfUsers = Integer.parseInt(System.getProperty("users"));
        concurrentThreadsPerUser = Integer.parseInt(System.getProperty("concurrent_threads_per_user"));
        roundsPerThread = Integer.parseInt(System.getProperty("rounds_per_thread"));
    }

    @PostConstruct
    private void run() {
        log.info(String.format("***** %d users, %d threads, %d rounds started ******", numberOfUsers, concurrentThreadsPerUser, roundsPerThread ));
        IntStream.rangeClosed(1, numberOfUsers).forEach(this::runThreadsForUser);
    }

    private void runThreadsForUser(int userId) {
        log.info("");
        log.info(String.format("------- USER ID: %d -------", userId));
        IntStream.rangeClosed(1, concurrentThreadsPerUser).forEach((int j) -> {
            log.info(String.format("====== THREAD NUMBER: %d ======", concurrentThreadsPerUser));
            singleUserRoundsRunner.callRandomRounds(userId, roundsPerThread);
        });
    }
}
