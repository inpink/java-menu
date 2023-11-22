package menu.domain.category;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import menu.util.ExceptionUtil;

public enum Category {

    JAPANESE("일식", 1, JapaneseCategory.values()),
    KOREAN("한식", 2, KoreanCategory.values()),
    CHINESE("중식", 3, ChineseCategory.values()),
    ASIAN("아시안", 4, AsianCategory.values()),
    WESTERN("양식", 5, WesternCategory.values());

    private final String description;
    private final int number;
    private final List<CategoryItem> items;

    Category(final String description, final int number, final CategoryItem[] items) {
        this.description = description;
        this.number = number;
        this.items = Arrays.stream(items)
                .collect(Collectors.toList()); //TODO: JDK 17에서는 .toList() 가능
    }

    public static CategoryItem findItem(String coachRestriction) {
        return Arrays.stream(Category.values())
                .flatMap(category -> category.items.stream())
                .filter(item -> item.isSameName(coachRestriction))
                .findFirst()
                .orElseThrow(() -> ExceptionUtil.returnInvalidValueException());
    }

    public static Category pickRandomCategory() {
        int randomIndex = Randoms.pickNumberInRange(1, 5);

        return Stream.of(Category.values())
                .filter(category -> category.number == randomIndex)
                .findFirst()
                .orElseThrow(() -> ExceptionUtil.returnInvalidValueException());
    }

}
