package menu.domain.menuItem;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import menu.util.ExceptionUtil;

public enum Menu {

    JAPANESE("일식", JapaneseCategory.values()),
    KOREAN("한식",KoreanCategory.values()),
    CHINESE("중식",ChineseCategory.values()),
    ASIAN("아시안",AsianCategory.values()),
    WESTERN("양식",WesternCategory.values());

    private final String description;
    private final List<MenuItem> items;

    Menu(final String description, final MenuItem[] items) {
        this.description = description;
        this.items = Arrays.stream(items)
                .collect(Collectors.toList()); //TODO: JDK 17에서는 .toList() 가능
    }

    public static MenuItem findItem(String coachRestriction) {
        return Arrays.stream(Menu.values())
                .flatMap(menu -> menu.items.stream())
                .filter(item -> item.isSameName(coachRestriction))
                .findFirst()
                .orElseThrow(() -> ExceptionUtil.returnInvalidValueException());
    }


/*    public static boolean containsItem(final String itemName) {
        return Arrays.stream(Menu.values())
                .flatMap(menu -> menu.items.stream())
                .anyMatch(item -> item.isSameName(itemName));
    }*/


}
