package ro.sebastiani.cordova.bluetoothevent;

// import ro.sebastiani.cordova.bluetoothevent.BluetoothEventService;


import android.bluetooth.BluetoothDevice;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class BluetoothEventReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context ctx, Intent intent) {
        // Gets data from the incoming Intent
        if( BluetoothDevice.ACTION_ACL_DISCONNECTED == intent.getAction() ) {

	        // Get the BluetoothDevice object from the Intent
                BluetoothDevice device = intent.getParcelableExtra(BluetoothDevice.EXTRA_DEVICE);

		Intent launchIntent = ctx.getPackageManager().getLaunchIntentForPackage(ctx.getPackageName());
		if (launchIntent != null) {
		    launchIntent.putExtra("bt_dev_name", device.getName());
		    launchIntent.putExtra("bt_dev_address", device.getAddress());
		    ctx.startActivity(launchIntent);//null pointer check in case package name was not found
		}

		return;
	}

    }
}
