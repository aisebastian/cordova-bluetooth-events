package ro.sebastiani.cordova.bluetoothevent;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class BluetoothEventService extends IntentService {
    public BluetoothEventService() {
        super("BluetoothEventService");
    }

    @Override
    protected void onHandleIntent(Intent workIntent) {
        // Gets data from the incoming Intent
        String dataString = workIntent.getDataString();
	if(null == dataString) {
		Log.i("BluetoothEventService", dataString);
	}
//        ...
        // Do work here, based on the contents of dataString
//        ...
    }
}
