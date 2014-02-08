package org.aal.vassist.bluetooth.le.gatt.refimpl;



import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;


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
			long timestamp;
			int opsType;
			String uuid;
			byte[] bytes;
			int l = 0;
			int v = 0;
			String s;
			String packet = "";
			switch (msg.what) {
			case Message_What_Logs:
				//final ListView logView = (ListView) findViewById(R.id.logView);
				timestamp = data.getLong(KEY_TIMESTAMP);
				opsType = data.getInt(KEY_OPS);
				uuid = data.getString(KEY_UUID);
				bytes = data.getByteArray(KEY_DATA);
				l = bytes.length;
				HashMap<String, String> map = new HashMap<String, String>();
				
				map.put(KEY_TIMESTAMP, getPrintableHour(timestamp));
				switch (opsType) {
				case AAl_vAssist_BLE_Service_Template.MSG_DEVICE_DISCONNECTED:
					map.put(KEY_OPS,"disconnected from device");
					break;
				case AAl_vAssist_BLE_Service_Template.MSG_DEVICE_CONNECTED:
					map.put(KEY_OPS,"connected to device");
					break;
				case AAl_vAssist_BLE_Service_Template.MSG_CHARACTERISTIC_CHANGED:
					map.put(KEY_OPS, "characteristic changed");
					break;
				case AAl_vAssist_BLE_Service_Template.MSG_CHARACTERISTIC_READ:
					map.put(KEY_OPS, "characteristic read");
					break;
				case AAl_vAssist_BLE_Service_Template.MSG_CHARACTERISTIC_READ_FAILED:
					map.put(KEY_OPS, "characteristic read failed");
					break;
				case AAl_vAssist_BLE_Service_Template.MSG_CHARACTERISTIC_WRITE:
					map.put(KEY_OPS, "characteristic write");
					break;
				case AAl_vAssist_BLE_Service_Template.MSG_CHARACTERISTIC_WRITE_FAILED:
					map.put(KEY_OPS, "characteristic write failed");
					break;
				case AAl_vAssist_BLE_Service_Template.MSG_DESCRIPTION_READ:
					map.put(KEY_OPS, "description read");
					break;
				case AAl_vAssist_BLE_Service_Template.MSG_DESCRIPTION_READ_FAILED:
					map.put(KEY_OPS, "description read failed");
					break;
				case AAl_vAssist_BLE_Service_Template.MSG_DESCRIPTION_WRITE:
					map.put(KEY_OPS, "description write");
					break;
				case AAl_vAssist_BLE_Service_Template.MSG_DESCRIPTION_WRITE_FAILED:
					map.put(KEY_OPS, "description write failed");
					break;
				case AAl_vAssist_BLE_Service_Template.MSG_SCANNING:
					map.put(KEY_OPS,"scanning");
					break;
				case AAl_vAssist_BLE_Service_Template.MSG_SCANNING_FAILED:
					map.put(KEY_OPS,"scanning failed");
					break;
				case AAl_vAssist_BLE_Service_Template.MSG_STOP_SCANNING:
					map.put(KEY_OPS,"scanning over");
					break;
				case AAl_vAssist_BLE_Service_Template.MSG_NO_DEVICE_FOUND:
					map.put(KEY_OPS,"no device found");
					break;

				default:
					map.put(KEY_OPS, "operation unknown");
					break;
				}
				
				map.put(KEY_UUID, uuid);
				
				while(l-->0){
					try{
						v = 255 & bytes[l];
						s =  Integer.toString(v, 16);
						s = s.length() == 1?"0"+s:s;
						packet = s + (packet.length()>0?" ":"")+ packet;
					} catch (Exception e){
						break;
					}
				}
				map.put(KEY_DATA, packet);
				logs.add(map);
				/*
				ListView logView = (ListView) findViewById(R.id.logView);
				((SimpleAdapter)logView.getAdapter()).notifyDataSetChanged();
				*/
				break;

			default:
				break;
			}
		}
	};
	
	
	private IAAL_vAssist_BLE_Service_Logs_Callback.Stub mIAAL_vAssist_BLE_Service_Logs_Callback = new IAAL_vAssist_BLE_Service_Logs_Callback.Stub() {
		
		@Override
		public void onBTLELog(long time, int ops, String uuid, byte[] packet)
				throws RemoteException {
			Message msg = mHandler.obtainMessage(Message_What_Logs);
			Bundle data = msg.getData();
			data.putLong(KEY_TIMESTAMP, time);
			data.putInt(KEY_OPS, ops);
			data.putString(KEY_UUID, uuid);
			data.putByteArray(KEY_DATA, packet);
			msg.sendToTarget();
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
		/*
		setContentView(R.layout.activity_vassist__service_);
		ListView logView = (ListView) findViewById(R.id.logView); 
		String[] from = {KEY_TIMESTAMP,KEY_UUID,KEY_OPS,KEY_DATA};
		int[] to = new int[] { R.id.timestampView, R.id.uuidView,R.id.opsView, R.id.dataView};
		SimpleAdapter adapter = new SimpleAdapter(this, logs, R.layout.log_event, from, to);
		logView.setAdapter(adapter);
		*/
		
		Intent intent  = new Intent(AAL_vAssist_BLE_Service_Logs_Activity_Template.this,AAl_vAssist_BLE_Service_Template.class);
		intent.putExtra("BinderType", "Logs");
		//startService(new Intent(AAL_vAssist_BLE_Service_Logs_Activity_Template.this,org.aal.vassist.service.Samsung_BLE_Access_AndroidService.class));
		//startService(intent);
		
		bindService(intent, serviceConnection, Context.BIND_AUTO_CREATE);
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
	
	private static String getPrintableHour(long timestamp){
		String time = "";
		Calendar cal = Calendar.getInstance();
		cal.setTimeInMillis(timestamp);
		time += cal.get(Calendar.HOUR_OF_DAY);
		time += ":";
		time += cal.get(Calendar.MINUTE);
		time += ":";
		time += cal.get(Calendar.SECOND);
		time += ".";
		time += cal.get(Calendar.MILLISECOND);
		return time;
	}

}
