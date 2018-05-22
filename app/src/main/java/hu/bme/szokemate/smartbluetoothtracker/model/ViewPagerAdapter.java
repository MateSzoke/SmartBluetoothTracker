package hu.bme.szokemate.smartbluetoothtracker.model;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import hu.bme.szokemate.smartbluetoothtracker.ui.AboutFragment;
import hu.bme.szokemate.smartbluetoothtracker.ui.DetailsFragment;

public class ViewPagerAdapter extends FragmentStatePagerAdapter {

    private static final int NUM_PAGES = 2;

    public ViewPagerAdapter(FragmentManager manager) {
        super(manager);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0: return new DetailsFragment();
            case 1: return new AboutFragment();
            default: return new AboutFragment();
        }
    }
    /*
    @Override
    public CharSequence getPageTitle(int position) {
        String title;
        switch (position) {
            case 0:
                title = "Details";
                break;
            case 1:
                title = "About";
                break;
            default:
                title = "";
        }
        return title;
    }
*/

    @Override
    public int getCount() {
        return NUM_PAGES;
    }
}