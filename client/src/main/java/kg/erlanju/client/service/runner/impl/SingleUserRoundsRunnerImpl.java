package kg.erlanju.client.service.runner.impl;

import kg.erlanju.client.service.runner.RoundsRunner;
import kg.erlanju.client.service.runner.SingleUserRoundsRunner;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.Random;
import java.util.stream.IntStream;

@Slf4j
@Service
public class SingleUserRoundsRunnerImpl implements SingleUserRoundsRunner {

    private RoundsRunner roundsRunner;

    public SingleUserRoundsRunnerImpl(RoundsRunner roundsRunner) {
        this.roundsRunner = roundsRunner;
    }

    @Async
    @Override
    public void callRandomRounds(int userId, Integer roundsPerThread) {
        IntStream.rangeClosed(1, roundsPerThread).forEach((int i) -> {
            int randomRoundNumber = new Random().nextInt(3);
            try {
                switch (randomRoundNumber) {
                    case 0:
                        roundsRunner.runFirstRound(userId);
                    case 1:
                        roundsRunner.runSecondRound(userId);
                    case 2:
                        roundsRunner.runThirdRound(userId);
                }
            } catch (Exception e) {
                log.error(e.getMessage());
            }
        });
    }
}
