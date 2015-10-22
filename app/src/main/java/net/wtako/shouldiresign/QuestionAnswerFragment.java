package net.wtako.shouldiresign;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

/**
 * A placeholder fragment containing a simple view.
 */
public class QuestionAnswerFragment extends Fragment {
    /**
     * The fragment argument representing the section number for this
     * fragment.
     */
    private static final String ARG_QUESTION_NAME = "question_name";
    private QuestionsActivity parent;
    private Question question;

    public QuestionAnswerFragment() {
    }

    /**
     * Returns a new instance of this fragment for the given section
     * number.
     */
    public static QuestionAnswerFragment newInstance(Question question) {
        QuestionAnswerFragment fragment = new QuestionAnswerFragment();
        Bundle args = new Bundle();
        args.putString(ARG_QUESTION_NAME, question.name());
        fragment.setArguments(args);
        return fragment;
    }

    private void setUpButton(Button button, final int index) {
        final Answer answer = question.getPossibleAnswers().get(index);
        button.setText(answer.getAnswerText(parent));
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                parent.nextQuestion(answer.getNextQuestion());
            }
        });
    }

    private View singleAnswerQuestion(LayoutInflater inflater, ViewGroup container) {
        View rootView = inflater.inflate(R.layout.single_answer_question, container, false);
        TextView title = (TextView) rootView.findViewById(R.id.question_text);
        title.setText(question.getQuestionText(parent));
        setUpButton((Button) rootView.findViewById(R.id.answer_button), 0);
        return rootView;
    }

    private View yesNoQuestion(LayoutInflater inflater, ViewGroup container) {
        View rootView = inflater.inflate(R.layout.yes_no_question, container, false);
        TextView title = (TextView) rootView.findViewById(R.id.question_text);
        title.setText(question.getQuestionText(parent));
        setUpButton((Button) rootView.findViewById(R.id.top_button), 0);
        setUpButton((Button) rootView.findViewById(R.id.bottom_button), 1);
        return rootView;
    }

    private View fourAnswersQuestion(LayoutInflater inflater, ViewGroup container) {
        View rootView = inflater.inflate(R.layout.four_answers_question, container, false);
        TextView title = (TextView) rootView.findViewById(R.id.question_text);
        title.setText(question.getQuestionText(parent));
        setUpButton((Button) rootView.findViewById(R.id.button_1), 0);
        setUpButton((Button) rootView.findViewById(R.id.button_2), 1);
        setUpButton((Button) rootView.findViewById(R.id.button_3), 2);
        setUpButton((Button) rootView.findViewById(R.id.button_4), 3);
        return rootView;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        if (!(getActivity() instanceof QuestionsActivity)) {
            throw new IllegalArgumentException();
        }
        parent = (QuestionsActivity) getActivity();
        question = Question.valueOf(getArguments().getString(ARG_QUESTION_NAME));
        View rootView = null;
        switch (question.getPossibleAnswers().size()) {
            case 0:
                rootView = inflater.inflate(R.layout.resign_now, container, false);
                break;
            case 1:
                rootView = singleAnswerQuestion(inflater, container);
                break;
            case 2:
                rootView = yesNoQuestion(inflater, container);
                break;
            case 4:
                rootView = fourAnswersQuestion(inflater, container);
                break;
        }
        return rootView;

    }


}