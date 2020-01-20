import java.util.Arrays;
import java.util.List;
import java.util.Optional;

class Yacht {

    private final int[] dice;
    private final YachtCategory yachtCategory;


    Yacht(int[] dice, YachtCategory yachtCategory) {
        this.dice = dice;
        this.yachtCategory = yachtCategory;
    }

    int score() {
        if (yachtCategory.equals(YachtCategory.YACHT)) {
            if (Arrays.stream(this.dice).allMatch(value -> value == this.dice[0])) {
                return 50;
            }
            return 0;
        } else if (yachtCategory.equals(YachtCategory.FOURS)) {
            return Arrays.stream(dice)
                    .filter(element -> element == 4)
                    .reduce(Integer::sum)
                    .getAsInt();
        }
        throw new UnsupportedOperationException();
    }

    public static void main(String[] args) {
        Integer[] diceArray = new Integer[]{4, 4, 5, 1, 2};
        List<Integer> diceList = Arrays.asList(diceArray);
        Optional<Integer> reduce = diceList.stream().reduce(Integer::sum);
        reduce.ifPresent(System.out::println);
    }

}
