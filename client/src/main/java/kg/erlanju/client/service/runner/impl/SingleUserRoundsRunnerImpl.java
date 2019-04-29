package kg.erlanju.client.service.runner.impl;

import kg.erlanju.client.service.runner.SingleUserRoundsRunner;
import org.springframework.stereotype.Service;

import java.util.Random;
import java.util.stream.IntStream;

@Service
public class SingleUserRoundsRunnerImpl implements SingleUserRoundsRunner {

    @Override
    public void callRandomRounds(int userId, Integer roundsPerThread) {
        IntStream.rangeClosed(1, roundsPerThread).forEach((int i) -> {
            Integer randomRoundNumber = new Random().nextInt(3);
            switch (randomRoundNumber) {
                case 0:
            }
        });
    }
}
