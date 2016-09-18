package com.example.kmurali.harambe;

import android.location.Location;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.location.LocationManager;
import android.content.Context;
import android.location.LocationListener;
import android.util.Log;
import android.widget.TextView;
import android.app.DownloadManager.Request;
import com.android.volley.Cache;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.DiskBasedCache;
import com.android.volley.toolbox.BasicNetwork;
import com.android.volley.toolbox.HurlStack;
import com.android.volley.toolbox.StringRequest;
//import com.android.volley.;
import com.android.volley.Network;
//import com.android.volley.Request.Method.GET;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.Volley;
import android.widget.LinearLayout;

import java.io.UnsupportedEncodingException;

public class HeartBeatMapping extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_heart_beat_mapping);
        Log.i("en","pen");
        LinearLayout linearLayout = new LinearLayout(this);
        final TextView mTextView = new TextView(this);
        mTextView.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT));
        linearLayout.addView(mTextView);


        RequestQueue queue = Volley.newRequestQueue(this);
        String url ="http://www.google.com";

// Request a string response from the provided URL.
        StringRequest stringRequest = new StringRequest(com.android.volley.Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        // Display the first 500 characters of the response string.
                        mTextView.setText("Response is: "+ response.substring(0,500));
                        Log.i("pen","Response is: "+ response.substring(0,500));
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                mTextView.setText("That didn't work!");
                Log.e("pen","That didn't work!");
                String body;
                String statusCode = String.valueOf(error.networkResponse.statusCode);
                if(error.networkResponse.data!=null) {
                    try {
                        body = new String(error.networkResponse.data,"UTF-8");
                        Log.e("error",body);
                    } catch (UnsupportedEncodingException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
// Add the request to the RequestQueue.
        queue.add(stringRequest);


       /* // Acquire a reference to the system Location Manager
        LocationManager locationManager = (LocationManager) this.getSystemService(Context.LOCATION_SERVICE);

      //  locationManager.requestLocationUpdates(
                LocationManager.GPS_PROVIDER, 1000, 1, locListener);
        Location mobileLocation = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
        // Define a listener that responds to location updates
        LocationListener locationListener = new LocationListener() {
            public void onLocationChanged(Location location) {
                // Called when a new location is found by the network location provider.
                //makeUseOfNewLocation(location);
                double lat =  location.getLatitude();
                double longi =  location.getLongitude();
                double time =   location.getTime();

                RequestQueue mRequestQueue;

                Cache cache = new DiskBasedCache(getCacheDir(), 1024 * 1024); // 1MB cap
                Network network = new BasicNetwork(new HurlStack());

// Instantiate the RequestQueue with the cache and network.
                mRequestQueue = new RequestQueue(cache, network);

// Start the queue
                mRequestQueue.start();

                String url ="http://heartsoutforharambe.com/input/longitude="+longi+"latitude="+lat+"time="+time+"";

// Formulate the request and handle the response.
                StringRequest stringRequest = new StringRequest(com.android.volley.Request.Method.GET, url,
                        new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {
                                // Do something with the response


                            }
                        },
                        new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {
                                // Handle error
                            }
                        });

// Add the request to the RequestQueue.
                mRequestQueue.add(stringRequest);


            }

            public void onStatusChanged(String provider, int status, Bundle extras) {
                Log.i("Error","kk");
            }

            public void onProviderEnabled(String provider) {
                Log.i("Error","kk");
            }

            public void onProviderDisabled(String provider) {
                Log.i("Error","kk");
            }
        };*/

        // Register the listener with the Location Manager to receive location updates
     //   locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 0, 0, locationListener);


        /*LocationManager mLocationManager = (LocationManager)this.getSystemService(Context.LOCATION_SERVICE);

        if (mLocationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)) {
            Location lastLocation = mLocationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
            if (lastLocation != null) {
                // Do whatever...
            }
        }*/



    }


}
