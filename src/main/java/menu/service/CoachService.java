package menu.service;

import java.util.Set;
import java.util.stream.Collectors;
import menu.domain.dto.CoachNameDto;
import menu.domain.dto.CoachRestrctionsDto;
import menu.domain.entity.Coach;
import menu.domain.entity.Restrictions;
import menu.domain.category.Category;
import menu.domain.category.CategoryItem;

public class CoachService {

    public Coach createCoach(final CoachNameDto coachNameDto,
                             final CoachRestrctionsDto coachRestrctionsDto) {

        final String receiveName = coachNameDto.getCoachName();
        final Set<String> receiveRestrictions = coachRestrctionsDto.getCoachRestrctions();

        final Set<CategoryItem> restrictItems = receiveRestrictions.stream()
                .map(Category::findItem)
                .collect(Collectors.toSet());

        final Restrictions restrictions = Restrictions.create(restrictItems);

        return Coach.create(receiveName, restrictions);
    }
}
