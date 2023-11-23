package menu.domain.util;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class RandomUtil {

    public static int pickNumberInRange(int min, int max) {
        return Randoms.pickNumberInRange(min, max);
    }

    public static String pickRandom(List<String> input) {
        return Randoms.shuffle(input).get(0);
    }

}
