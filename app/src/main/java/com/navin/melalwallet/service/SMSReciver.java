package com.navin.melalwallet.service;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsMessage;
import android.widget.Toast;

public class SMSReciver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {





        Bundle bundle = intent.getExtras();
        if (bundle != null) {

            final Object[] pdusObj = (Object[]) bundle.get("pdus");

            for (int i = 0; i < pdusObj.length; i++) {
                SmsMessage currentMessage = SmsMessage.createFromPdu((byte[]) pdusObj[i]);
                String phoneNumber = currentMessage.getDisplayOriginatingAddress();
                String senderNum = phoneNumber;
                String message = currentMessage.getDisplayMessageBody();
                Toast.makeText(context, "Phone number is"+ phoneNumber +" \n , Message : "+ message, Toast.LENGTH_LONG).show();
            } // end for loop
        } // bundle is null


    }
}
