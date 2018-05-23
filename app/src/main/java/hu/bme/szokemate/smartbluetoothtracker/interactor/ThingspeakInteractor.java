package hu.bme.szokemate.smartbluetoothtracker.interactor;

import org.greenrobot.eventbus.EventBus;

import hu.bme.szokemate.smartbluetoothtracker.model.ThingSpeak.Field1;
import hu.bme.szokemate.smartbluetoothtracker.model.ThingSpeak.Field2;
import hu.bme.szokemate.smartbluetoothtracker.network.ApiClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

//Interactor class which get field1 and field2 from ThingSpeak
//This class calls http request with retrofit
public class ThingspeakInteractor {


    public ThingspeakInteractor(){

    }

    public void getField1(){
        Call<Field1> feedCall = ApiClient.getInstance().getLastField1();
        final GetField1Event event = new GetField1Event();
        try {

            feedCall.enqueue(new Callback<Field1>() {
                @Override
                public void onResponse(Call<Field1> call, Response<Field1> response) {

                    event.setCode(response.code());
                    event.setField(response.body());
                    EventBus.getDefault().post(event);
                }

                @Override
                public void onFailure(Call<Field1> call, Throwable t) {

                }
            });

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void getField2(){
        Call<Field2> feedCall = ApiClient.getInstance().getLastField2();
        final GetField2Event event = new GetField2Event();
        try {

            feedCall.enqueue(new Callback<Field2>() {
                @Override
                public void onResponse(Call<Field2> call, Response<Field2> response) {

                    event.setCode(response.code());
                    event.setField(response.body());
                    EventBus.getDefault().post(event);
                }

                @Override
                public void onFailure(Call<Field2> call, Throwable t) {

                }
            });

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
