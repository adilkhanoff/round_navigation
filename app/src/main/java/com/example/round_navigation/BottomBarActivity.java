package com.example.round_navigation;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.gauravk.bubblenavigation.BubbleNavigationLinearView;
import com.gauravk.bubblenavigation.listener.BubbleNavigationChangeListener;

public class BottomBarActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom_bar);
        Fragment mFragment = null;
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.framelayout, new HomeFragment()).commit();

        final BubbleNavigationLinearView bubbleNavigationLinearView = findViewById(R.id.bottom_navigation_view_linear);
       // bubbleNavigationLinearView.setTypeface(Typeface.createFromAsset(getAssets(), "rubik.ttf"));

        bubbleNavigationLinearView.setBadgeValue(0, null);
        bubbleNavigationLinearView.setBadgeValue(1, null); //invisible badge
        bubbleNavigationLinearView.setBadgeValue(2, null);
        bubbleNavigationLinearView.setBadgeValue(3, "2");
        bubbleNavigationLinearView.setBadgeValue(4, null); //empty badge


        bubbleNavigationLinearView.setNavigationChangeListener(new BubbleNavigationChangeListener() {
            @Override
            public void onNavigationChanged(View view, int position) {
                Fragment mFragment = null;

                FragmentManager fragmentManager = getSupportFragmentManager();
                //viewPager.setCurrentItem(position, true);
                fragmentManager.beginTransaction().replace(R.id.framelayout, new HomeFragment()).commit();
                switch (position){
                    case 0:
                        mFragment = new HomeFragment();
                        fragmentManager.beginTransaction().replace(R.id.framelayout, mFragment).commit();
                    break;
                    case 1:
                        mFragment = new HomeFragment();
                        fragmentManager.beginTransaction().replace(R.id.framelayout, mFragment).commit();
                    break;
                    case 2:
                        mFragment = new HomeFragment();
                        fragmentManager.beginTransaction().replace(R.id.framelayout, mFragment).commit();
                    break;
                    case 3:
                        mFragment = new HomeFragment();
                        fragmentManager.beginTransaction().replace(R.id.framelayout, mFragment).commit();
                    break;
                    case 4:
                        mFragment = new HomeFragment();
                        fragmentManager.beginTransaction().replace(R.id.framelayout, mFragment).commit();
                    break;
                }
            }
        });
    }
}
