package org.aal.vassist.bluetooth.le.gatt.refimpl;



import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import org.aal.vassist.at.R;


import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.RemoteException;
import android.util.Log;
import android.view.Menu;
import android.widget.ListView;
import android.widget.SimpleAdapter;


/**
 * @author Hugues Sansen, Shankaa, for AAL vAssist project, http://vassist.cure.at/project_overview/
 * 
 *         Licence : European Union Public License (EUPL)
 * 
 *         A template implementation of an activity displaying the logs of Bluetooth LE events received by our service.
 *         Can be implemented inside the same application project as the service or inside an independent application.
 *         For tests purpose it may be simpler to integrate in the same project though and remove it for deployment
 *         
 *         This activity is useful for the development of the application (mostly to check what happens on the remote device)
 *         
 *         Caution
 *         Check the position of R
 *         Corresponding layouts are provided in res.layout
 * 		
 * 
 * 
 * 
 */
public class AAL_vAssist_BLE_Service_Logs_Activity_Template extends Activity {
	private static final String TAG = "AAL_vAssist_BLE_Service_Logs_Activity_Template";
	
	private static final int Message_What_Logs	=  0;
	
	private static final String KEY_TIMESTAMP 	= "timestamp";
	private static final String KEY_OPS 		= "opsType";
	private static final String KEY_UUID 		= "uuid";
	private static final String KEY_DATA 		= "data";
	
	
	private static ArrayList<HashMap<String, String>> logs = new ArrayList<HashMap<String, String>>();
	

	private ListView logView;
	private SimpleAdapter logViewAdapter;
	private static final Calendar ANCILIARY_CALENDAR = Calendar.getInstance();
	

	private LinkedBlockingQueue<Runnable> workQueue = new LinkedBlockingQueue<Runnable>();
	private ThreadPoolExecutor mThreadPoolExecutor = new ThreadPoolExecutor(5,
			5, 500, TimeUnit.MILLISECONDS, workQueue);
	
	//private IAAL_vAssist_AT_Service serviceBinder;
	private IAAL_vAssist_BLE_Service_Logs serviceBinder;
	
	/**
	 * not static to make it simpler. This activity is not part of the deployed application
	 */
	@SuppressLint("HandlerLeak")
	private Handler mHandler = new Handler(){
		@Override
		public void handleMessage(Message msg) {
			Bundle data = msg.getData();
			switch (msg.what) {
			case Message_What_Logs:
				HashMap<String, String> map = new HashMap<String, String>();
				map.put(KEY_TIMESTAMP, data.getString(KEY_TIMESTAMP));
				map.put(KEY_OPS, data.getString(KEY_OPS));
				map.put(KEY_UUID, data.getString(KEY_UUID));
				map.put(KEY_DATA, data.getString(KEY_DATA));
				
				logs.add(map);
				logViewAdapter.notifyDataSetChanged();
				logView.smoothScrollToPosition(logViewAdapter.getCount());
				break;

			default:
				break;
			}
		}
	};
	
	
	private IAAL_vAssist_BLE_Service_Logs_Callback.Stub mIAAL_vAssist_BLE_Service_Logs_Callback = new IAAL_vAssist_BLE_Service_Logs_Callback.Stub() {
		
		@Override
		public void onBTLELog(final long time,final int ops,final String uuid,final byte[] packet)
				throws RemoteException {
			Runnable runnable = new Runnable() {
				public void run() {
					synchronized (logViewAdapter){
						updateLogView(time, ops, uuid, packet);
					}
				}
			};
			mThreadPoolExecutor.execute(runnable);
		}
	};
	
	private ServiceConnection serviceConnection = new ServiceConnection() {
		
		@Override
		public void onServiceDisconnected(ComponentName name) {
			// TODO Auto-generated method stub
			Log.i(TAG, "AAl_vAssist_BLE_Service_Template disconnected");
		}
		
		@Override
		public void onServiceConnected(ComponentName name, IBinder service) {
			serviceBinder = IAAL_vAssist_BLE_Service_Logs.Stub.asInterface(service);
			Log.i(TAG, "AAl_vAssist_BLE_Service_Template started");
			//We finish the activity when the service has started
			//finish();
			try {
				serviceBinder.registerLogsCallback(mIAAL_vAssist_BLE_Service_Logs_Callback);
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.activity_vassist__service_);
		Runnable runnable = new Runnable() {
			@Override
			public void run() {
				
					logView = (ListView) findViewById(R.id.logView);
					
					String[] from = { KEY_TIMESTAMP, KEY_UUID, KEY_OPS, KEY_DATA };
					int[] to = new int[] { R.id.timestampView, R.id.uuidView,
							R.id.opsView, R.id.dataView };
					logViewAdapter = new SimpleAdapter(
							AAL_vAssist_BLE_Service_Logs_Activity_Template.this, logs,
							R.layout.log_event, from, to);
	
					logView.setAdapter(logViewAdapter);
	
					Intent intent = new Intent(
							AAL_vAssist_BLE_Service_Logs_Activity_Template.this,
							AAl_vAssist_BLE_Service_Template.class);
					intent.putExtra("BinderType", "Logs");
	
					bindService(intent, serviceConnection, Context.BIND_AUTO_CREATE);
			}
		};
		mThreadPoolExecutor.execute(runnable);
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		//getMenuInflater().inflate(R.menu.vassist__service_, menu);
		return true; 
	}
	
	@Override
	public void onDestroy(){
		try {
			serviceBinder.unregisterLogsCallback(mIAAL_vAssist_BLE_Service_Logs_Callback);
		} catch (RemoteException e) {
			
		}
		unbindService(serviceConnection);
		super.onDestroy();
	}

	private void updateLogView(final long timestamp, final int opsType,
			final String uuid, final byte[] bytes) {
		int i = 0;
		int l = bytes.length;
		int v = 0;
		String ops;

		Message msg = mHandler.obtainMessage(Message_What_Logs);
		Bundle data = msg.getData();

		switch (opsType) {
		case AAl_vAssist_BLE_Service_Template.MSG_DEVICE_DISCONNECTED:
			ops = "disconnected from device";
			break;
		case AAl_vAssist_BLE_Service_Template.MSG_DEVICE_CONNECTED:
			ops = "connected to device";
			break;
		case AAl_vAssist_BLE_Service_Template.MSG_CHARACTERISTIC_CHANGED:
			ops = "characteristic changed";
			break;
		case AAl_vAssist_BLE_Service_Template.MSG_CHARACTERISTIC_READ:
			ops = "characteristic read";
			break;
		case AAl_vAssist_BLE_Service_Template.MSG_CHARACTERISTIC_READ_FAILED:
			ops = "characteristic read failed";
			break;
		case AAl_vAssist_BLE_Service_Template.MSG_CHARACTERISTIC_WRITE:
			ops = "characteristic write";
			break;
		case AAl_vAssist_BLE_Service_Template.MSG_CHARACTERISTIC_WRITE_FAILED:
			ops = "characteristic write failed";
			break;
		case AAl_vAssist_BLE_Service_Template.MSG_DESCRIPTION_READ:
			ops = "description read";
			break;
		case AAl_vAssist_BLE_Service_Template.MSG_DESCRIPTION_READ_FAILED:
			ops = "description read failed";
			break;
		case AAl_vAssist_BLE_Service_Template.MSG_DESCRIPTION_WRITE:
			ops = "description write";
			break;
		case AAl_vAssist_BLE_Service_Template.MSG_DESCRIPTION_WRITE_FAILED:
			ops = "description write failed";
			break;
		case AAl_vAssist_BLE_Service_Template.MSG_SCANNING:
			ops = "scanning";
			break;
		case AAl_vAssist_BLE_Service_Template.MSG_SCANNING_FAILED:
			ops = "scanning failed";
			break;
		case AAl_vAssist_BLE_Service_Template.MSG_STOP_SCANNING:
			ops = "scanning over";
			break;
		case AAl_vAssist_BLE_Service_Template.MSG_NO_DEVICE_FOUND:
			ops = "no device found";
			break;

		default:
			ops = "operation unknown";
			break;
		}

		data.putString(KEY_TIMESTAMP, getPrintableHour(timestamp));
		data.putString(KEY_OPS, ops);
		data.putString(KEY_UUID, uuid);
		StringBuilder sb = new StringBuilder(l * 3);
		while (l-- > 0) {

			v = 255 & bytes[i++];
			if (v < 16) {
				sb.append('0');
			}
			sb.append(Integer.toString(v, 16));
			sb.append(' ');
		}
		data.putString(KEY_DATA, sb.toString());
		msg.sendToTarget();
	}
	
	
	/**
	 * you can replace by your time format
	 * 
	 * @param timestamp
	 * @return
	 */
	private static String getPrintableHour(long timestamp){
		StringBuilder time = new StringBuilder(12);
		ANCILIARY_CALENDAR.setTimeInMillis(timestamp);
		time.append(ANCILIARY_CALENDAR.get(Calendar.HOUR_OF_DAY));
		time.append(':');
		time.append(ANCILIARY_CALENDAR.get(Calendar.MINUTE));
		time.append(':');
		time.append(ANCILIARY_CALENDAR.get(Calendar.SECOND));
		time.append('.');
		time.append(ANCILIARY_CALENDAR.get(Calendar.MILLISECOND));
		return time.toString();
	}

}
