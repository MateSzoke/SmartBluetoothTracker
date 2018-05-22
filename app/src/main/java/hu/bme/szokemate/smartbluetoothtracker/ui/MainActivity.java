package hu.bme.szokemate.smartbluetoothtracker.ui;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import hu.bme.szokemate.smartbluetoothtracker.R;
import hu.bme.szokemate.smartbluetoothtracker.model.ViewPagerAdapter;

public class MainActivity extends AppCompatActivity {

    private ViewPager pager;
    private ViewPagerAdapter pagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.AppTheme);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pager = findViewById(R.id.viewPager);
        pagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        pager.setAdapter(pagerAdapter);
    }
}
