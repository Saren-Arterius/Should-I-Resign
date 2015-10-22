package net.wtako.shouldiresign;

import android.content.Context;
import android.support.annotation.StringRes;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public enum Question {
    RICH_ENOUGH(R.string.question_rich_enough, Arrays.asList(Answer.RICH_ENOUGH_YES, Answer.RICH_ENOUGH_NO)),
    ARE_YOU_SURE(R.string.question_are_you_sure, Arrays.asList(Answer.ARE_YOU_SURE_YES, Answer.ARE_YOU_SURE_NO)),
    FOUND_A_NEW_JOB(R.string.question_found_new_job, Arrays.asList(Answer.FOUND_A_NEW_JOB_YES, Answer.FOUND_A_NEW_JOB_NO)),
    GO_FOR_NEW_JOB(R.string.question_go_for_new_job, Arrays.asList(Answer.GO_FOR_NEW_JOB_YES, Answer.GO_FOR_NEW_JOB_NO)),
    WHY_RESIGN(R.string.question_why_resign, Arrays.asList(Answer.WHY_RESIGN_BAD_SALARY,
            Answer.WHY_RESIGN_UNHAPPY, Answer.WHY_RESIGN_JUST_WANT_LEAVE, Answer.WHY_RESIGN_CHASE_DREAM)),
    WOULD_YOU_REGRET(R.string.question_would_you_regret, Arrays.asList(Answer.WOULD_YOU_REGRET_YES, Answer.WOULD_YOU_REGRET_NO)),
    THAT_SOMEBODY(R.string.question_that_somebody,
            Arrays.asList(Answer.THAT_SOMEBODY_YES, Answer.THAT_SOMEBODY_NO)),
    TALK_TO_BOSS(R.string.question_talk_to_boss, Collections.singletonList(Answer.TALK_TO_BOSS_OK)),
    CHASE_DREAM(R.string.question_chase_dream,
            Arrays.asList(Answer.CHASE_DREAM_YES, Answer.CHASE_DREAM_NO)),
    TRY_STAY_LONGER(R.string.question_try_to_stay_longer, Arrays.asList(Answer.TRY_STAY_LONGER_YES, Answer.TRY_STAY_LONGER_NO)),
    TRUSTWORTHY(R.string.question_trustworthy, Arrays.asList(Answer.TRUSTWORTHY_YES, Answer.TRUSTWORTHY_NO)),
    DOES_IT_WORK(R.string.question_does_it_work, Arrays.asList(Answer.DOES_IT_WORK_YES, Answer.DOES_IT_WORK_NO)),
    WHY_STILL_USE_THIS_APP(R.string.question_why_still_use_this_app,
            Arrays.asList(Answer.WHY_RESIGN_BAD_SALARY, Answer.WHY_RESIGN_UNHAPPY,
                    Answer.WHY_RESIGN_JUST_WANT_LEAVE, Answer.WHY_RESIGN_CHASE_DREAM)),
    HOW_GOING(R.string.question_how_going,
            Arrays.asList(Answer.HOW_GOING_GOOD, Answer.HOW_GOING_BAD)),
    STILL_RESIGNING(R.string.question_still_resigning,
            Arrays.asList(Answer.STILL_RESIGNING_YES, Answer.STILL_RESIGNING_NO)),
    RESIGN_NOW(R.string.resign_now, Collections.EMPTY_LIST);


    private final int questionStringRes;
    private final List<Answer> possibleAnswers;

    Question(@StringRes int questionStringRes, List<Answer> possibleAnswers) {
        this.questionStringRes = questionStringRes;
        this.possibleAnswers = possibleAnswers;
    }

    public List<Answer> getPossibleAnswers() {
        return possibleAnswers;
    }

    public String getDisplayName() {
        return name().replace('_', ' ');
    }

    public String getQuestionText(Context ctx) {
        return ctx.getString(questionStringRes);
    }

}
