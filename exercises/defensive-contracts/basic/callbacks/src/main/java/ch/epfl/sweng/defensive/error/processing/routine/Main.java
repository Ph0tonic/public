package ch.epfl.sweng.defensive.error.processing.routine;

import ch.epfl.sweng.defensive.error.processing.routine.callback.Callback;
import ch.epfl.sweng.defensive.error.processing.routine.exception.NoJokeException;
import ch.epfl.sweng.defensive.error.processing.routine.model.Joke;
import ch.epfl.sweng.defensive.error.processing.routine.repository.JokeRepository;

import java.util.Random;

public class Main {
    public static void main(String[] args) throws NoJokeException {
        JokeRepository repository = new JokeRepository();
        repository.random(new Callback<Joke>() {
            @Override
            public void onSuccess(Joke value) {
                System.out.println(value);
            }

            @Override
            public void onError(Exception e) {

            }
        });
    }
}