package hu.bme.szokemate.smartbluetoothtracker.network;


import hu.bme.szokemate.smartbluetoothtracker.model.ThingSpeak.Field1;
import hu.bme.szokemate.smartbluetoothtracker.model.ThingSpeak.Field2;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

//Retrofit singleton object
public class ApiClient {

    // singleton instance of this client
    private static ThingSpeakApiInterface clientInstance;

    private static final String ADDRESS = "https://api.thingspeak.com/";



    public static ThingSpeakApiInterface getInstance() {
        if (clientInstance == null) {
            Retrofit retrofit = new Retrofit.Builder().baseUrl(ADDRESS).addConverterFactory(GsonConverterFactory.create()).build();

            clientInstance = retrofit.create(ThingSpeakApiInterface.class);
        }

        return clientInstance;
    }

    //ApiInterface for get data from ThingSpeak
    public interface ThingSpeakApiInterface {


        @GET("channels/496270/fields/1/last.json")
        Call<Field1> getLastField1();

        @GET("channels/496270/fields/2/last.json")
        Call<Field2> getLastField2();

    }
}