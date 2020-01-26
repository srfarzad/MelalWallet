package com.navin.melalwallet.ui.login;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatEditText;

import android.Manifest;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.location.Address;
import android.location.Geocoder;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;
import com.karumi.dexter.Dexter;
import com.karumi.dexter.MultiplePermissionsReport;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionDeniedResponse;
import com.karumi.dexter.listener.PermissionGrantedResponse;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.multi.MultiplePermissionsListener;
import com.karumi.dexter.listener.single.PermissionListener;
import com.navin.melalwallet.EventBus.Events;
import com.navin.melalwallet.EventBus.GlobalBus;
import com.navin.melalwallet.MainActivity;
import com.navin.melalwallet.R;
import com.navin.melalwallet.database.AppDatabase;
import com.navin.melalwallet.di.DaggerUserComponent;
import com.navin.melalwallet.di.UserComponent;
import com.navin.melalwallet.di.UserModule;
import com.navin.melalwallet.di.context.ActivityComponent;
import com.navin.melalwallet.di.context.DaggerActivityComponent;
import com.navin.melalwallet.di.context.MainActivityModule;
import com.navin.melalwallet.models.IMessageListener;
import com.navin.melalwallet.models.User;
import com.navin.melalwallet.service.BootupService;
import com.navin.melalwallet.service.UpdateService;
import com.navin.melalwallet.ui.loginAuth.LoginAuthenticationActivity;
import com.navin.melalwallet.ui.map.GoogleMapActivity;
import com.navin.melalwallet.utils.ApplicationManager;
import com.navin.melalwallet.utils.GPSTracker;
import com.navin.melalwallet.webservice.WebserviceCaller;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends AppCompatActivity implements ILoginView {

    @BindView(R.id.edt_username) AppCompatEditText edt_username;
    @BindView(R.id.edt_password) AppCompatEditText edt_password;
    @BindView(R.id.btn_login) AppCompatButton btn_login;
    @BindView(R.id.progress) ProgressBar progress;

    LoginPresentor loginPresentor;
    AppDatabase appDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);

        getLocationPermission();

        Events.FragmenActivityMessage  event=new Events.FragmenActivityMessage("hi");
        GlobalBus.getBus().post(event);

         appDatabase = AppDatabase.getInstance(this);

        loginPresentor = new LoginPresentor(this,this,new LoginIntractor());

       // startService(new Intent(getApplicationContext(),UpdateService.class));


        //com.navin.ipcmanager
        Intent intent = new Intent();
        intent.setClassName("com.navin.ipcmanager","com.navin.ipcmanager.MessageListener");
        intent.setAction("com.navin.ipcmanager.MessageListener");
        intent.putExtra("id",1);
        intent.putExtra("mydata", "{\"name\": \"Andrroid\", \"BrandLogo\" : \"ic_launcer\"}");

        sendBroadcast(intent);



        if(!ApplicationManager.isMyServiceRunning(getApplicationContext(),BootupService.class)){

          AlarmManager alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);


        Intent intent1 = new Intent(getApplicationContext() , BootupService.class);
        PendingIntent  pendingIntent = PendingIntent.getBroadcast(getApplicationContext(),1,intent1,0);

        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(System.currentTimeMillis());
        calendar.set(Calendar.HOUR_OF_DAY, 20);
        calendar.set(Calendar.MINUTE, 17);



        //alarmManager.set(AlarmManager.RTC_WAKEUP,calendar.getTimeInMillis(),pendingIntent);
        alarmManager.setRepeating(AlarmManager.RTC_WAKEUP,calendar.getTimeInMillis(),60000,pendingIntent);
        }


        UserComponent component =  DaggerUserComponent.builder().userModule(new UserModule()).build();


        component.provideUser().setEmail("");
        component.provideUser().getEmailAccount();
        component.provideContact().deleteEmail();
      //  component.provideWebservice().loginUser();


        ActivityComponent activityComponent = DaggerActivityComponent.builder()
                .mainActivityModule(new MainActivityModule(getApplicationContext())).build();



        //activityComponent.context()




    }

    double latitude;
    double longitude;
    GPSTracker gpsTracker;
    Geocoder geocoder;

    public void getLocationPermission () {

        Dexter.withActivity(LoginActivity.this)
                .withPermissions(Manifest.permission.ACCESS_COARSE_LOCATION,Manifest.permission.ACCESS_FINE_LOCATION)
                .withListener(new MultiplePermissionsListener() {
                    @Override
                    public void onPermissionsChecked(MultiplePermissionsReport report) {

                        gpsTracker = new GPSTracker(getApplicationContext());

                        if(gpsTracker.canGetLocation()) {
                            Log.e("","");

                            latitude = gpsTracker.getLatitude();
                            longitude = gpsTracker.getLongitude();


                            latitude = 35.7130653;
                            longitude = 51.4070569;

                            Locale locale = new Locale("fa");
                            geocoder = new Geocoder(getApplicationContext(),locale);




                            new updateLocationTask().execute();


                        }
                        else {
                            gpsTracker.showSettingsAlert();
                        }


                    }

                    @Override
                    public void onPermissionRationaleShouldBeShown(List<PermissionRequest> permissions, PermissionToken token) {

                    }
                }).check();


    }


    class updateLocationTask extends AsyncTask<Void,Void,Void> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected Void doInBackground(Void... voids) {


            try {

                List<Address> addressList= geocoder.getFromLocation(latitude,longitude,1);


                Log.e("","");

            } catch (IOException e) {
                e.printStackTrace();
            }catch (Exception e) {
                e.printStackTrace();
            }





            return null;
        }

        @Override
        protected void onProgressUpdate(Void... values) {
            super.onProgressUpdate(values);
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
        }
    }



    @OnClick(R.id.btn_login)
    public void btn_login_click() {

        String username = edt_username.getText().toString().trim();
        String password = edt_password.getText().toString().trim();



        loginPresentor.loginUser(username,password);




    }


    @OnClick(R.id.txt_forgot)
    public void txt_forgot_click() {
        Intent intent = new Intent(getApplicationContext() , GoogleMapActivity.class);

        startActivity(intent);
    }



    @OnClick(R.id.txt_login_social)
    public void txt_login_social_click() {


        startActivity(new Intent(getApplicationContext(), LoginAuthenticationActivity.class));

    }

    @Override
    public void onUsernameError() {
        Toast.makeText(getApplicationContext(), R.string.username_required, Toast.LENGTH_LONG).show();
    }

    @Override
    public void onPasswordError() {
        Toast.makeText(getApplicationContext(), R.string.password_required, Toast.LENGTH_LONG).show();
    }

    @Override
    public void onFailureError(String reason) {
        Toast.makeText(getApplicationContext(), R.string.fail_request, Toast.LENGTH_LONG).show();
    }

    @Override
    public void onError(String reason) {
        Toast.makeText(getApplicationContext(), R.string.wrong_user_pass, Toast.LENGTH_LONG).show();
    }

    @Override
    public void onSuccess(Object response) {



        User user = new User();
       // String time = Double.
      //  user.id=(int)ApplicationManager.getRandomDoubleBetweenRange(100,10000);
        user.username= "android";
        user.password = "123";


        runOnUiThread(new Runnable() {
            @Override
            public void run() {

                appDatabase.userDAO().insert(user);

                List<User> users = appDatabase.userDAO().getAll();
                Log.e("","");


            }
        });


        finish();
        Intent intent = new Intent(getApplicationContext() , MainActivity.class);
        startActivity(intent);

    }

    @Override
    public void showProgressBar() {
        progress.setVisibility(View.VISIBLE);
    }

    @Override
    public void hidesProgressBar() {
        progress.setVisibility(View.GONE);
    }
}
