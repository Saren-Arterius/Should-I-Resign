package net.wtako.shouldiresign;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class QuestionsActivity extends AppCompatActivity {

    List<Question> currentQuestions = new ArrayList<>(Collections.singletonList(Question.RICH_ENOUGH));
    /**
     * The {@link android.support.v4.view.PagerAdapter} that will provide
     * fragments for each of the sections. We use a
     * {@link FragmentPagerAdapter} derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * {@link android.support.v4.app.FragmentStatePagerAdapter}.
     */
    private SectionsPagerAdapter mSectionsPagerAdapter;
    /**
     * The {@link ViewPager} that will host the section contents.
     */
    private ViewPager mViewPager;
    private TabLayout tabLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questions);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);
        tabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);
    }

    public void goBack(View view) {
        if (mViewPager.getCurrentItem() == 0) {
            return;
        }
        mViewPager.setCurrentItem(mViewPager.getCurrentItem() - 1, true);
    }

    public void nextQuestion(Question question) {
        if (question == null) {
            question = Question.RESIGN_NOW;
        }
        if (mViewPager.getCurrentItem() != currentQuestions.size() - 1) {
            currentQuestions = currentQuestions.subList(0, mViewPager.getCurrentItem() + 1);
        }
        currentQuestions.add(question);
        mSectionsPagerAdapter.notifyDataSetChanged();
        tabLayout.setupWithViewPager(mViewPager);
        tabLayout.post(new Runnable() {
            @Override
            public void run() {
                mViewPager.setCurrentItem(currentQuestions.size() - 1, true);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_questions, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_back_to_first_question) {
            mViewPager.setCurrentItem(0, true);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    public class SectionsPagerAdapter extends FragmentStatePagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            // getItem is called to instantiate the fragment for the given page.
            // Return a QuestionAnswerFragment (defined as a static inner class below).
            return QuestionAnswerFragment.newInstance(currentQuestions.get(position));
        }

        @Override
        public int getCount() {
            return currentQuestions.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return currentQuestions.get(position).getDisplayName();
        }

        //this is called when notifyDataSetChanged() is called
        @Override
        public int getItemPosition(Object object) {
            // refresh all fragments when data set changed
            return PagerAdapter.POSITION_NONE;
        }

    }

}
