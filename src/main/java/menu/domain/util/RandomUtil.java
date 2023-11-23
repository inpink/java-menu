package menu.domain.util;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class RandomUtil {

    public static int pickNumberInRange(int min, int max) {
        int a= Randoms.pickNumberInRange(min, max);
        System.out.println(a);

        return a;
    }

    public static String pickRandom(List<String> input) {
        String a = Randoms.shuffle(input).get(0);
        System.out.println(input);
        System.out.println(a);
        return a;
    }

}
