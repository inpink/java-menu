package menu.domain.entity.category;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import menu.domain.util.ExceptionUtil;
import menu.domain.util.RandomUtil;

public enum Category {
    JAPANESE("일식", 1, Japanese.values()),
    KOREAN("한식", 2, Korean.values()),
    CHINESE("중식", 3, Chinese.values()),
    ASIAN("아시안", 4, Asian.values()),
    WESTERN("양식", 5, Western.values());

    private final String categoryName;
    private final int number;
    private final List<CategoryItem> dishes;

    Category(String categoryName, int number, CategoryItem[] dishes) {
        this.categoryName = categoryName;
        this.number = number;
        this.dishes = Arrays.stream(dishes)
                .collect(Collectors.toList());
    }

    public static boolean hasItem(String itemName) {
        return findDishStream(itemName).isPresent();
    }

    public static CategoryItem findItem(String itemName) {
        return findDishStream(itemName)
                .orElseThrow(() -> ExceptionUtil.returnInvalidValueException());
    }

    public static Category pickRandomCategory() {
        int randomNum = RandomUtil.pickNumberInRange(getMinNumber(), getMaxNumber());

        return Arrays.stream(Category.values())
                .filter(category -> category.number == randomNum)
                .findFirst()
                .orElseThrow(() -> ExceptionUtil.returnInvalidValueException());
    }

    public CategoryItem pickRandomItem() {
        String menu = RandomUtil.pickRandom(getAllDishesAsString());
        return findDishStream(menu)
                .orElseThrow(() -> ExceptionUtil.returnInvalidValueException("Dish not found"));
    }

    private static IntStream getCategoryNumbersStream() {
        return Arrays.stream(Category.values())
                .mapToInt(category -> category.number);
    }

    private static int getMinNumber() {
        return getCategoryNumbersStream()
                .min()
                .orElseThrow(() -> ExceptionUtil.returnInvalidValueException());
    }

    private static int getMaxNumber() {
        return getCategoryNumbersStream()
                .max()
                .orElseThrow(() -> ExceptionUtil.returnInvalidValueException());
    }

    private static Optional<CategoryItem> findDishStream(String itemName) {
        return Arrays.stream(Category.values())
                .flatMap(category -> category.getDishes().stream())
                .filter(dish -> dish.getName().equalsIgnoreCase(itemName))
                .findFirst();
    }

    private List<String> getAllDishesAsString() {
        return Arrays.stream(Category.values())
                .flatMap(category -> category.getDishes().stream())
                .map(CategoryItem::getName)
                .collect(Collectors.toList());
    }


    public String getName() {
        return categoryName;
    }

    public List<CategoryItem> getDishes() {
        return dishes;
    }
}
