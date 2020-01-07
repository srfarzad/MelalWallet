package com.navin.melalwallet.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;

import androidx.annotation.Nullable;

import com.navin.melalwallet.IPurchaseListener;

public class PurchaseService extends Service {

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return binder;
    }

    private final IPurchaseListener.Stub binder = new IPurchaseListener.Stub() {
        @Override
        public boolean isLoggedIn() throws RemoteException {
            Log.e("","");
            return false;
        }

        @Override
        public void payment(String price) throws RemoteException {
            Log.e("","");
        }

        @Override
        public void login(String username, String password) throws RemoteException {
            Log.e("","");
        }
    };


}
