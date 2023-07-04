import trails.ExtraTrial;
import trails.LightTrial;
import trails.StrongTrial;
import trails.Trial;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;

public class Runner {

    public static void main(String[] args) {
        final var trials = new ArrayList<>(Arrays.asList(
        new Trial("NotPassed", 32, 36 ),
        new Trial("Passed", 41, 42),
        new Trial("PassedSecond", 45, 48),

        new LightTrial("NotPassed", 38, 39),
        new LightTrial("Passed", 91, 88),

        new StrongTrial("NotPassed", 34, 36),
        new StrongTrial("Passed", 99, 51),

        new ExtraTrial("NotPassed", 20, 20, 20),
        new ExtraTrial("Passed", 45, 45, 90)
        ));

        trials.forEach(System.out::println);
        System.out.println();

        final var successCount = trials.stream()
            .filter(Trial::isPassed)
            .count();

        System.out.println("Success: " + successCount);
        System.out.println();

        trials.sort(Comparator.comparingInt(Trial::calculateResult));

        trials.stream()
            .map(Trial::calculateResult)
            .forEach(System.out::println);
        System.out.println();

         final var unpassedTrials = trials.stream()
            .filter(trial -> !trial.isPassed())
            .map(Trial::getCopy)
            .peek(Trial::clearMarks).toList();

        unpassedTrials.forEach(System.out::println);
        System.out.println();

        System.out.println("All trials are failed: " + unpassedTrials.stream().noneMatch(Trial::isPassed));
        System.out.println();
        // 7
        final var firstAndSecondMarksArrayString = trials.stream()
            .map(trial -> String.valueOf(trial.calculateResult()))
            .collect(Collectors.joining(", "));

        System.out.println(firstAndSecondMarksArrayString);
    }
}
    

