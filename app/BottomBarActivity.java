package com.example.nationpetition10;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.nationpetition10.fragment.HomeFragment;
import com.example.nationpetition10.fragment.NotificationFragment;
import com.example.nationpetition10.fragment.ProfileFragment;
import com.example.nationpetition10.fragment.QrFragment;
import com.example.nationpetition10.fragment.SearchFragment;
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
                        mFragment = new SearchFragment();
                        fragmentManager.beginTransaction().replace(R.id.framelayout, mFragment).commit();
                    break;
                    case 2:
                        mFragment = new QrFragment();
                        fragmentManager.beginTransaction().replace(R.id.framelayout, mFragment).commit();
                    break;
                    case 3:
                        mFragment = new NotificationFragment();
                        fragmentManager.beginTransaction().replace(R.id.framelayout, mFragment).commit();
                    break;
                    case 4:
                        mFragment = new ProfileFragment();
                        fragmentManager.beginTransaction().replace(R.id.framelayout, mFragment).commit();
                    break;
                }
            }
        });
    }
}
