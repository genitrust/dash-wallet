package de.schildbach.wallet;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import org.bitcoinj.core.Address;
import org.bitcoinj.core.Coin;
import org.bitcoinj.wallet.Wallet;
import org.dash.wallet.common.ui.LocalBroadcastHelper;

public abstract class IntermoduleBroadcastHandler extends BroadcastReceiver {

    public void register(Context context) {
        LocalBroadcastHelper.FreshReceiveAddressBroadcast.registerRequestReceiver(context, this);
        LocalBroadcastHelper.WalletBalanceBroadcast.registerRequestReceiver(context, this);
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        Wallet wallet = getWallet();
        if (action == null || wallet == null) {
            return;
        }
        switch (action) {
            case LocalBroadcastHelper.FreshReceiveAddressBroadcast.REQUEST_ACTION: {
                Address freshReceiveAddress = wallet.freshReceiveAddress();
                LocalBroadcastHelper.FreshReceiveAddressBroadcast.sendResponseBroadcast(context, freshReceiveAddress);
            }
            case LocalBroadcastHelper.WalletBalanceBroadcast.REQUEST_ACTION: {
                Coin balance = wallet.getBalance(Wallet.BalanceType.ESTIMATED);
                LocalBroadcastHelper.WalletBalanceBroadcast.sendResponseBroadcast(context, balance);
            }
        }
    }

    protected abstract Wallet getWallet();
}
