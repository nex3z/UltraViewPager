package test.fragmentpagerdemo;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v7.app.AppCompatActivity;

import com.tmall.ultraviewpager.UltraViewPager;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initPager();
    }

    private void initPager() {
        UltraViewPager pager = (UltraViewPager) findViewById(R.id.ultra_viewpager);

        // Uncomment the following lines to fix the "ViewPager with adapter XXX requires a view id" exception
//        View pagerView = pager.getChildAt(0);
//        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.JELLY_BEAN_MR1) {
//            pagerView.setId(pagerView.hashCode());
//        } else {
//            pagerView.setId(View.generateViewId());
//        }

        FragmentPagerAdapter adapter = new NumberFragmentPagerAdapter(getSupportFragmentManager());
        pager.setAdapter(adapter);
        pager.setScrollMode(UltraViewPager.ScrollMode.VERTICAL);
    }

    private class NumberFragmentPagerAdapter extends FragmentPagerAdapter {
        private List<Fragment> mFragments;

        public NumberFragmentPagerAdapter(FragmentManager fm) {
            super(fm);
            mFragments = new ArrayList<>(5);
            mFragments.add(NumberFragment.newInstance(0, Color.parseColor("#2196F3")));
            mFragments.add(NumberFragment.newInstance(1, Color.parseColor("#673AB7")));
            mFragments.add(NumberFragment.newInstance(2, Color.parseColor("#009688")));
            mFragments.add(NumberFragment.newInstance(3, Color.parseColor("#607D8B")));
            mFragments.add(NumberFragment.newInstance(4, Color.parseColor("#F44336")));
        }

        @Override
        public Fragment getItem(int position) {
            return mFragments.get(position);
        }

        @Override
        public int getCount() {
            return mFragments == null ? 0 : mFragments.size();
        }
    }
}
