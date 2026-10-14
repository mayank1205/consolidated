import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Sample {

    static class UserScore {
        private final String name;
        private final int score;

        public UserScore(String name, int score) {
            this.name = name;
            this.score = score;
        }

        public String getName() {
            return this.name;
        }

        public int getScore() {
            return this.score;
        }

        @Override
        public String toString() {
            return "UserScore{" +
                    "name='" + name + '\'' +
                    ", score=" + score +
                    '}';
        }
    }

    static class Competition {
        private final List<UserScore> scores;

        private Competition(UserScore... scores) {
            this.scores = List.of(scores);
        }

        public List<UserScore> getScores() {
            return this.scores;
        }
    }

    public static void main(String[] args) {
        Competition round1 = new Competition(
                new UserScore("Harish", 2),
                new UserScore("Rudy", 4),
                new UserScore("Alexa", 9),
                new UserScore("Mary", 10),
                new UserScore("Bella", 2),
                new UserScore("John", 1));

                Competition round2 = new Competition( 
                new UserScore("Terry", 10), 
                new UserScore("Mark", 8), 
                new UserScore("Angela", 3) 
                ); 
                Competition round3 = new Competition( 
                new UserScore("Catty", 5), 
                new UserScore("Raymond", 2), 
                new UserScore("Bella", 8) 
                );

        Optional<Integer> total = round1.getScores().stream().map(us -> us.getScore()).reduce(Integer::sum);
        List<UserScore> sorted = round1.getScores().stream().sorted(Comparator.comparing(UserScore::getScore).thenComparing((UserScore::getName))).toList();
        System.out.println(total);
        System.out.println(sorted);
        Optional<UserScore> highest = round1.getScores().stream().max(Comparator.comparing(UserScore::getScore));
        System.out.println(highest.get().getName());
        Double average1 = round1.getScores().stream().collect(Collectors.averagingDouble(UserScore::getScore));
        Stream.of(round1,round2,round3).map(competition -> competition.getScores().stream().filter(score -> score.getScore()> 2 && score.getScore()< 6).count()).toList();

        Double sumOfAllRounds = Stream.of(round1.getScores(), round2.getScores(),round3.getScores()).flatMap(List::stream).mapToDouble(UserScore::getScore).sum();
        List<Integer> sortedSum = Stream.of(round1.getScores(), round2.getScores(),round3.getScores()).flatMap(List::stream).sorted(Comparator.comparing(UserScore::getScore).thenComparing(UserScore::getName)).map(UserScore::getScore).toList();
        Optional<String> nameMax = Stream.of(round1.getScores(), round2.getScores(),round3.getScores()).flatMap(List::stream).sorted(Comparator.comparing(UserScore::getScore).reversed().thenComparing(UserScore::getName)).map(UserScore::getName).findFirst();
        System.out.println(sumOfAllRounds);
        System.out.println(sortedSum);
        nameMax.ifPresent(System.out::println);
    }
}