package com.example.smartelec.smartelec;

import android.util.Log;
import android.util.Log;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;
import com.google.firebase.messaging.FirebaseMessagingService;

/**
 * Created by tejas on 1/22/2017.
 */






    public class MyFirebaseMessagingServices extends FirebaseInstanceIdService {

        private static final String TAG = "MyFirebaseIIDService";


        @Override
        public void onTokenRefresh() {
            // Get updated InstanceID token.
            String refreshedToken = FirebaseInstanceId.getInstance().getToken();
            Log.d("the token is",refreshedToken);

            // If you want to send messages to this application instance or
            // manage this apps subscriptions on the server side, send the
            // Instance ID token to your app server.
            //sendRegistrationToServer(refreshedToken);
        }

        private void sendRegistrationToServer(String token) {
            // TODO: Implement this method to send token to your app server.
        }
    }


