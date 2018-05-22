package hu.bme.szokemate.smartbluetoothtracker.ui;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.concurrent.Executor;
import java.util.logging.Logger;

import hu.bme.szokemate.smartbluetoothtracker.R;
import hu.bme.szokemate.smartbluetoothtracker.interactor.GetField1Event;
import hu.bme.szokemate.smartbluetoothtracker.interactor.GetField2Event;
import hu.bme.szokemate.smartbluetoothtracker.interactor.ThingspeakInteractor;

public class DetailsFragment extends Fragment {

    private TextView tvTag;
    private  TextView tvDistance;
    private TextView tvRssi;

    Executor networkExecutor;
    ThingspeakInteractor thingspeakInteractor;


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        EventBus.getDefault().register(this);

    }

    @Override
    public void onDetach() {
        EventBus.getDefault().unregister(this);
        super.onDetach();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_details, container, false);
        tvTag = view.findViewById(R.id.tvTag);
        tvDistance = view.findViewById(R.id.tvDistance);
        tvRssi = view.findViewById(R.id.tvRssi);
        thingspeakInteractor = new ThingspeakInteractor();
        networkExecutor = new Executor() {
            @Override
            public void execute(@NonNull Runnable command) {
                thingspeakInteractor.getField1();
                thingspeakInteractor.getField2();

            }
        };

        PollingServerRunnable pollingServerRunnable = new PollingServerRunnable();
        Thread thread = new Thread(pollingServerRunnable);
        thread.start();

        return view;
    }

    public void refreshFields(){
        networkExecutor.execute(new Runnable() {
            @Override
            public void run() {
                thingspeakInteractor.getField1();
                thingspeakInteractor.getField2();
            }
        });
    }


    @Override
    public void onResume(){
        super.onResume();
        refreshFields();
    }


    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEventMainThread(final GetField1Event event){
        if (event.getThrowable() != null)
            event.getThrowable().printStackTrace();
            tvTag.setText(event.getField().getField1());
    }


    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEventMainThread(final GetField2Event event){
        if (event.getThrowable() != null)
            event.getThrowable().printStackTrace();
        tvRssi.setText(event.getField().getField2());
        tvDistance.setText(Double.toString(calculateDistance(Double.valueOf(event.getField().getField2())))+ " cm");
    }


    public double calculateDistance(double rssi) {
        int txPower = -65; //hard coded power value. Usually ranges between -59 to -65

        if (rssi == 0) {
            return -1.0;
        }

        double ratio = rssi*1.0/txPower;
        if (ratio < 1.0) {
            return Math.pow(ratio,10)*10;
        }
        else {
            double distance =  (0.89976)*Math.pow(ratio,7.7095) + 0.111;
            return distance*10;
        }
    }

    public  class PollingServerRunnable implements Runnable{

        @Override
        public void run() {
            while (true){
                refreshFields();
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}