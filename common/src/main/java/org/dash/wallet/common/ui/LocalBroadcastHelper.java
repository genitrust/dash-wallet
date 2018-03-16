package org.dash.wallet.common.ui;


import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v4.content.LocalBroadcastManager;

import java.io.Serializable;

public interface LocalBroadcastHelper {

    class FreshReceiveAddressBroadcast {

        public static final String REQUEST_ACTION = "FreshReceiveAddressRequest";
        private static final String RESPONSE_ACTION = "FreshReceiveAddressResponse";

        private static final String RESPONSE_DATA_ADDRESS = "FreshReceiveAddressResponseAddress";

        public static void sendRequestBroadcast(Context context, BroadcastReceiver responseReceiver) {
            registerReceiver(context, responseReceiver, RESPONSE_ACTION);
            sendBroadcast(context, new Intent(REQUEST_ACTION));
        }

        public static void sendResponseBroadcast(Context context, Serializable freshReceiveAddress) {
            Intent responseIntent = new Intent(RESPONSE_ACTION);
            responseIntent.putExtra(RESPONSE_DATA_ADDRESS, freshReceiveAddress);
            sendBroadcast(context, responseIntent);
        }

        public static Serializable extractAddress(Intent responseIntent) {
            return responseIntent.getSerializableExtra(RESPONSE_DATA_ADDRESS);
        }

        private static void sendBroadcast(Context context, Intent broadcastIntent) {
            LocalBroadcastManager.getInstance(context).sendBroadcast(broadcastIntent);
        }

        public static void registerRequestReceiver(Context context, BroadcastReceiver receiver) {
            registerReceiver(context, receiver, REQUEST_ACTION);
        }

        private static void registerReceiver(Context context, BroadcastReceiver receiver, String action) {
            LocalBroadcastManager.getInstance(context).registerReceiver(receiver, new IntentFilter(action));
        }

        public static void unregisterReceiver(Context context, BroadcastReceiver receiver) {
            LocalBroadcastManager.getInstance(context).unregisterReceiver(receiver);
        }
    }

    class WalletBalanceBroadcast {

        public static final String REQUEST_ACTION = "WalletBalanceRequest";
        private static final String RESPONSE_ACTION = "WalletBalanceResponse";

        private static final String RESPONSE_DATA_BALANCE = "WalletBalanceResponseBalance";

        public static void sendRequestBroadcast(Context context) {
            sendBroadcast(context, new Intent(REQUEST_ACTION));
        }

        public static void sendRequestBroadcast(Context context, BroadcastReceiver responseReceiver) {
            registerResponseReceiver(context, responseReceiver);
            sendBroadcast(context, new Intent(REQUEST_ACTION));
        }

        public static void sendResponseBroadcast(Context context, Serializable walletBalance) {
            Intent responseIntent = new Intent(RESPONSE_ACTION);
            responseIntent.putExtra(RESPONSE_DATA_BALANCE, walletBalance);
            sendBroadcast(context, responseIntent);
        }

        public static Serializable extractBalance(Intent responseIntent) {
            return responseIntent.getSerializableExtra(RESPONSE_DATA_BALANCE);
        }

        private static void sendBroadcast(Context context, Intent broadcastIntent) {
            LocalBroadcastManager.getInstance(context).sendBroadcast(broadcastIntent);
        }

        public static void registerResponseReceiver(Context context, BroadcastReceiver receiver) {
            registerReceiver(context, receiver, RESPONSE_ACTION);
        }

        public static void registerRequestReceiver(Context context, BroadcastReceiver receiver) {
            registerReceiver(context, receiver, REQUEST_ACTION);
        }

        private static void registerReceiver(Context context, BroadcastReceiver receiver, String action) {
            LocalBroadcastManager.getInstance(context).registerReceiver(receiver, new IntentFilter(action));
        }

        public static void unregisterReceiver(Context context, BroadcastReceiver receiver) {
            LocalBroadcastManager.getInstance(context).unregisterReceiver(receiver);
        }
    }
}
