package com.abs.samih.gpstest;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;


/*//1
add permissions to manifest:
 <uses-permission android:name="android.permission.ACCESS_FINE_LOCATION"/>
    <uses-permission android:name="android.permission.ACCESS_COARSE_LOCATION"/>
 */
public class GPSActivity extends AppCompatActivity {
    //2
    TextView tvLatLng, tvAdress;
    LocationManager locationManager;
    Geocoder geocoder;
    //4
    MyLocLis locLis;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gps);
        tvLatLng = (TextView) findViewById(R.id.tvLatLng);
        tvAdress = (TextView) findViewById(R.id.tvAdress);


    }
    //5
    @Override
    protected void onResume() {
        super.onResume();
        //6
        locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);
        locLis = new MyLocLis();
        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 3000, 20, locLis);
        geocoder=new Geocoder(this);
    }
    //7
    @Override
    protected void onStop() {
        super.onStop();
        locationManager.removeUpdates(locLis);
    }

    //3
    private class MyLocLis implements LocationListener
    {

        @Override
        public void onLocationChanged(Location location) {


        }

        @Override
        public void onStatusChanged(String provider, int status, Bundle extras) {

        }

        @Override
        public void onProviderEnabled(String provider) {

        }

        @Override
        public void onProviderDisabled(String provider) {

        }
    }
}
