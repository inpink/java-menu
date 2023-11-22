package menu.view;

import menu.domain.dto.CoachNameDto;
import menu.domain.dto.CoachRestrctionsDto;
import menu.domain.dto.CoachesNamesDto;

public interface InputView {

    CoachesNamesDto inputCoachesNames();

    CoachRestrctionsDto inputCoachMenuRestrictions(CoachNameDto coachNameDto);
}
