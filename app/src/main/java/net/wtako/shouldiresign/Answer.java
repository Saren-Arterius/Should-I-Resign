package net.wtako.shouldiresign;

import android.content.Context;
import android.support.annotation.StringRes;

public enum Answer {
    RICH_ENOUGH_YES(R.string.answer_yes, "ARE_YOU_SURE"),
    RICH_ENOUGH_NO(R.string.answer_no, "THAT_SOMEBODY"),
    ARE_YOU_SURE_YES(R.string.answer_yes, null),
    ARE_YOU_SURE_NO(R.string.answer_no, "FOUND_A_NEW_JOB"),
    FOUND_A_NEW_JOB_YES(R.string.answer_yes, "GO_FOR_NEW_JOB"),
    FOUND_A_NEW_JOB_NO(R.string.answer_no, "WHY_RESIGN"),
    GO_FOR_NEW_JOB_YES(R.string.answer_yes, "WOULD_YOU_REGRET"),
    GO_FOR_NEW_JOB_NO(R.string.answer_no, "FOUND_A_NEW_JOB"),
    WHY_RESIGN_BAD_SALARY(R.string.answer_bad_salary, "TALK_TO_BOSS"),
    WHY_RESIGN_UNHAPPY(R.string.answer_unhappy, "TALK_TO_BOSS"),
    WHY_RESIGN_JUST_WANT_LEAVE(R.string.answer_just_want_leave, null),
    WHY_RESIGN_CHASE_DREAM(R.string.answer_chase_dream, "CHASE_DREAM"),
    WOULD_YOU_REGRET_YES(R.string.answer_yes, "TRY_STAY_LONGER"),
    WOULD_YOU_REGRET_NO(R.string.answer_no, null),
    THAT_SOMEBODY_YES(R.string.answer_yes, "TRUSTWORTHY"),
    THAT_SOMEBODY_NO(R.string.answer_no, "FOUND_A_NEW_JOB"),
    TRUSTWORTHY_YES(R.string.answer_yes, null),
    TRUSTWORTHY_NO(R.string.answer_no, "FOUND_A_NEW_JOB"),
    TALK_TO_BOSS_OK(R.string.answer_ok, "HOW_GOING"),
    DOES_IT_WORK_YES(R.string.answer_yes, "WHY_STILL_USE_THIS_APP"),
    DOES_IT_WORK_NO(R.string.answer_no, "STILL_RESIGNING"),
    CHASE_DREAM_YES(R.string.answer_yes, null),
    CHASE_DREAM_NO(R.string.answer_no, "STILL_RESIGNING"),
    TRY_STAY_LONGER_YES(R.string.answer_ok, "DOES_IT_WORK"),
    TRY_STAY_LONGER_NO(R.string.answer_try_stay_longer_no, null),
    HOW_GOING_GOOD(R.string.answer_good, "STILL_RESIGNING"),
    HOW_GOING_BAD(R.string.answer_bad, "FOUND_A_NEW_JOB"),
    STILL_RESIGNING_YES(R.string.answer_yes, "WOULD_YOU_REGRET"),
    STILL_RESIGNING_NO(R.string.answer_no, "TRY_STAY_LONGER");

    private final int answerStringRes;
    // Circular reference makes nulls
    private final String nextQuestionName;

    Answer(@StringRes int answerStringRes, String nexQuestionName) {
        this.answerStringRes = answerStringRes;
        this.nextQuestionName = nexQuestionName;
    }

    public Question getNextQuestion() {
        if (nextQuestionName == null) {
            return null;
        }
        return Question.valueOf(nextQuestionName);
    }

    public String getAnswerText(Context ctx) {
        return ctx.getString(answerStringRes);
    }

}
