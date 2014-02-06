/**
 * 
 */
package org.aal.vassist.bluetooth.le.gatt.refimpl;

import java.util.Calendar;
import java.util.List;

import org.aal.vassist.at.AAL_vAssist_Asica_AT_AccessService;
import org.aal.vassist.at.IAAL_vAssist_AT_Service_Logs;
import org.aal.vassist.bluetooth.le.gatt.BluetoothGattSpecification_Characteristics;
import org.aal.vassist.bluetooth.le.gatt.IBluetoothGattCharacteristicHandler;
import org.aal.vassist.bluetooth.le.gatt.IEEE_11073_20601_REGULATORY_CERTIFICATION_DATA_LIST;

import android.app.Service;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCallback;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.bluetooth.BluetoothManager;
import android.bluetooth.BluetoothProfile;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.RemoteCallbackList;
import android.os.RemoteException;

/**
 * @author Hugues Sansen, Shankaa, for AAL vAssist project, http://vassist.cure.at/project_overview/
 * 
 *         Licence : European Union Public License (EUPL)
 * 
 *         A template implementation of a service using org.aal.vassist.bluetooth.le.gatt api
 *         we do not implement the connection logics as it may be different between applications.
 *         
 *         In the scope of the vAssist project, dependent people should not deal with complex operations.
 *         In our vAssist real implementation, the service starts up at boot.
 *         So we handle the connections, reconnections in a fully automated way based on the RSSI level betting that the closer device
 *         is de facto the device that the person has to connect to.
 *         We force the enabling of Bluetooth and relaunch BT if it has been stopped intentionally or not.
 *         
 *         
 *         Most probably you will have to exchange information with Gui applications and do it through the IPC
 *         
 *         Your project may have other logics.
 * 
 */
public class AAl_vAssist_BLE_Service_Template extends Service {

	private static final String TAG = "AAl_vAssist_BLE_Service_Template";

	// message ids for handlers
	private static final int MSG_DEVICE_DISCONNECTED = BluetoothProfile.STATE_DISCONNECTED;
	private static final int MSG_DEVICE_CONNECTING = BluetoothProfile.STATE_CONNECTING;
	private static final int MSG_DEVICE_CONNECTED = BluetoothProfile.STATE_CONNECTED;
	private static final int MSG_DEVICE_DISCONNECTING = BluetoothProfile.STATE_DISCONNECTING;
	private static final int MSG_CONNECTION_STATE_CHANGED = 4;
	private static final int MSG_SERVICES_DISCOVERED = 54;
	private static final int MSG_SCAN_RESULT = 6;
	private static final int MSG_CHARACTERISTIC_CHANGED = 7;
	private static final int MSG_CHARACTERISTIC_READ = 8;
	private static final int MSG_CHARACTERISTIC_WRITE = 9;
	private static final int MSG_DESCRIPTION_READ = 10;
	private static final int MSG_DESCRIPTION_WRITE = 11;
	private static final int MSG_REMOTE_RSSI_READ = 12;

	private static final int SCAN_IDLE = 0;
	private static final int SCANNING = 1;
	private static final int SCAN_OK = 2;

	/**
	 * used to check scan operation in order to avoid multiple scans which could
	 * happen when you have different threads that wake up for any reasons.
	 */
	private int scanStatus = SCAN_IDLE;

	private BluetoothAdapter mBluetoothAdapter = null;

	/**
	 * this class is defined below as an embedded class
	 */
	private static BluetoothGattCharacteristicHandler mBluetoothGattCharacteristicHandler;

	/**
	 * 
	 * this is a handler that is used to decouple actions from this thread.
	 * You know why to use it in an Activity... and it is not a bad
	 * practice to use it inside a Service
	 * 
	 * 
	 * 
	 */
	private static Handler mGattServiceHandler = new Handler() {
		@Override
		public void handleMessage(Message msg) {
			Bundle data = msg.getData();
			switch (msg.what) {

			case MSG_DEVICE_DISCONNECTED:

				break;
			case MSG_DEVICE_CONNECTING:

				break;
			case MSG_DEVICE_CONNECTED:

				break;
			case MSG_DEVICE_DISCONNECTING:

				break;
			case MSG_CONNECTION_STATE_CHANGED:

				break;
			case MSG_SERVICES_DISCOVERED:

				break;
			case MSG_SCAN_RESULT:

				break;
			case MSG_CHARACTERISTIC_CHANGED:
			case MSG_CHARACTERISTIC_READ:
				BluetoothGattSpecification_Characteristics.onHandleMessage(msg,
						mBluetoothGattCharacteristicHandler);
				break;
			case MSG_CHARACTERISTIC_WRITE:

				break;
			case MSG_DESCRIPTION_READ:

				break;
			case MSG_DESCRIPTION_WRITE:

				break;
			case MSG_REMOTE_RSSI_READ:

				break;
			}
		}
	};

	/**
	 * implementation of the interface for notifying BluetoothProfile IPC
	 * clients when they have been connected or disconnected to the service.
	 * 
	 */
	private BluetoothProfile.ServiceListener mProfileServiceListener = new BluetoothProfile.ServiceListener() {

		@Override
		public void onServiceDisconnected(int profile) {
			if(profile == BluetoothProfile.GATT){
				// get the devices you are disconnected to
				// broadcast the disconnection event here
			}
			//TODO do what you have to do when devices are disconnected

		}

		@Override
		public void onServiceConnected(int profile, BluetoothProfile proxy) {
			List<BluetoothDevice> devices = proxy.getConnectedDevices();
			if(profile == BluetoothProfile.GATT){
				for (BluetoothDevice device : devices ){
					broadcastConnectedToBTLEDevice(device);
				}
			}
			//TODO do what you have to do when devices are connected

		}
	};

	/**
	 * this is the standard Android 4.3 BluetoothGattCallback that you use with
	 * mBluetoothDevice.connectGatt(myContext, autoConnect,
	 * mBluetoothGattCallback);
	 * 
	 * 
	 */
	BluetoothGattCallback mBluetoothGattCallback = new BluetoothGattCallback() {

		private void handleCharacteristicReadOrChange(
				BluetoothGattCharacteristic characteristic, int status, int what) {

			Message msg = Message.obtain(mGattServiceHandler,
					MSG_CHARACTERISTIC_READ);
			Bundle bundle = msg.getData();
			// You can can put extra values into the bundle

			BluetoothGattSpecification_Characteristics
			.onCharacteristicReadOrChange(bundle, characteristic, msg);
			if (msg.arg1 != 0) {
				msg.what = what;
				msg.setData(bundle);
				msg.sendToTarget();
			}

		}

		/**
		 * Callback triggered as a result of a remote characteristic
		 * notification.
		 * 
		 * @param gatt
		 *            GATT client the characteristic is associated with
		 * @param characteristic
		 *            Characteristic that has been updated as a result of a
		 *            remote notification event.
		 * 
		 */
		@Override
		public void onCharacteristicChanged(BluetoothGatt gatt,
				BluetoothGattCharacteristic characteristic) {
			// TODO implement a response specific to characteristic changed

			handleCharacteristicReadOrChange(characteristic,
					BluetoothGatt.GATT_SUCCESS, MSG_CHARACTERISTIC_CHANGED);
		}

		/**
		 * Callback reporting the result of a characteristic read operation.
		 * 
		 * @param gatt
		 *            GATT client the characteristic is associated with
		 * @param characteristic
		 *            Characteristic that has been updated as a result of a
		 *            remote notification event.
		 * @param status
		 *            GATT_SUCCESS if the read operation was completed
		 *            successfully.
		 */
		@Override
		public void onCharacteristicRead(BluetoothGatt gatt,
				BluetoothGattCharacteristic characteristic, int status) {
			// TODO implement a response specific to characteristic read

			if (status == BluetoothGatt.GATT_SUCCESS) {
				handleCharacteristicReadOrChange(characteristic, status,
						MSG_CHARACTERISTIC_READ);
			}

			// TODO do something after e.g
			// if you implement a queue to send your read or write commands
			// allow the next command to be sent
		}

		/**
		 * Callback indicating the result of a characteristic write operation.
		 * If this callback is invoked while a reliable write transaction is in
		 * progress, the value of the characteristic represents the value
		 * reported by the remote device. An application should compare this
		 * value to the desired value to be written. If the values don't match,
		 * the application must abort the reliable write transaction.
		 * 
		 * @param gatt
		 *            GATT client invoked
		 *            writeCharacteristic(BluetoothGattCharacteristic)
		 * @param characteristic
		 *            Characteristic that was written to the associated remote
		 *            device.
		 * @param status
		 *            The result of the write operation GATT_SUCCESS if the
		 *            operation succeeds.
		 */
		@Override
		public void onCharacteristicWrite(BluetoothGatt gatt,
				BluetoothGattCharacteristic characteristic, int status) {

		}

		/**
		 * Callback indicating when GATT client has connected/disconnected
		 * to/from a remote GATT server.
		 * 
		 * @param gatt
		 *            GATT client
		 * @param status
		 *            Status of the connect or disconnect operation.
		 *            GATT_SUCCESS if the operation succeeds.
		 * @param newState
		 *            Returns the new connection state. Can be one of
		 *            STATE_DISCONNECTED or STATE_CONNECTED
		 */
		@Override
		public void onConnectionStateChange(BluetoothGatt gatt, int status,
				int newState) {

		}

		/**
		 * Callback reporting the result of a descriptor read operation.
		 * 
		 * @param gatt
		 *            GATT client invoked
		 *            readDescriptor(BluetoothGattDescriptor)
		 * @param descriptor
		 *            Descriptor that was read from the associated remote
		 *            device.
		 * @param status
		 *            GATT_SUCCESS if the read operation was completed
		 *            successfully
		 */
		@Override
		public void onDescriptorRead(BluetoothGatt gatt,
				BluetoothGattDescriptor descriptor, int status) {
		}

		/**
		 * Callback reporting the result of a descriptor write operation.
		 * 
		 * @param gatt
		 *            GATT client invoked
		 *            writeDescriptor(BluetoothGattDescriptor)
		 * @param descriptor
		 *            Descriptor that was writte to the associated remote
		 *            device.
		 * @param status
		 *            The result of the write operation GATT_SUCCESS if the
		 *            operation succeeds.
		 */
		@Override
		public void onDescriptorWrite(BluetoothGatt gatt,
				BluetoothGattDescriptor descriptor, int status) {

		}

		/**
		 * Callback reporting the RSSI for a remote device connection.
		 * 
		 * @param gatt
		 *            GATT client invoked readRemoteRssi()
		 * @param rssi
		 *            The RSSI value for the remote device
		 * @param status
		 *            GATT_SUCCESS if the RSSI was read successfully
		 */
		@Override
		public void onReadRemoteRssi(BluetoothGatt gatt, int rssi, int status) {

		}

		/**
		 * Callback invoked when a reliable write transaction has been
		 * completed.
		 * 
		 * @param gatt
		 * @param status
		 */
		@Override
		public void onReliableWriteCompleted(BluetoothGatt gatt, int status) {

		}

		/**
		 * Callback invoked when the list of remote services, characteristics
		 * and descriptors for the remote device have been updated, ie new
		 * services have been discovered.
		 * 
		 * @param gatt
		 *            GATT client invoked discoverServices()
		 * @param status
		 *            GATT_SUCCESS if the remote device has been explored
		 *            successfully.
		 */
		@Override
		public void onServicesDiscovered(BluetoothGatt gatt, int status) {

		}
	};

	/**
	 * Callback reporting a LE device found during a device scan initiated by
	 * the startLeScan(BluetoothAdapter.LeScanCallback) function.
	 * 
	 * @param device
	 *            Identifies the remote device
	 * @param rssi
	 *            The RSSI value for the remote device as reported by the
	 *            Bluetooth hardware. 0 if no RSSI value is available.
	 * @param scanRecord
	 *            The content of the advertisement record offered by the remote
	 *            device.
	 */
	private BluetoothAdapter.LeScanCallback mLeScanCallback = new BluetoothAdapter.LeScanCallback() {

		@Override
		public void onLeScan(BluetoothDevice device, int rssi, byte[] scanRecord) {
			// TODO Auto-generated method stub

		}
	};
	
	
	/**
	 * mIAAL_vAssist_BLE_Service_Template_Callbacks is used to store IAAL_vAssist_BLE_Service_Template_Callback objects sent by clients that bind to this service.
	 * IAAL_vAssist_BLE_Service_Template_Callback is defined in the corresponding aidl file
	 * we have defined no method in this descriptor
	 * we made it static so it can be used inside a static Handler
	 */
	public static final RemoteCallbackList<IAAL_vAssist_BLE_Service_Template_Callback> mIAAL_vAssist_BLE_Service_Template_Callbacks = new  RemoteCallbackList<IAAL_vAssist_BLE_Service_Template_Callback>();
	
	/**
	 * the standard binder we use with our remote clients.
	 * IAAL_vAssist_BLE_Service_Template is defined in the corresponding aidl file
	 * We have defined a minimum of methods. It is up to you to declare more methods to send data or do actions upon request.
	 */
	private IAAL_vAssist_BLE_Service_Template.Stub mIAAL_vAssist_BLE_Service_Template = new IAAL_vAssist_BLE_Service_Template.Stub() {
		
		@Override
		public void registerCallback(
				IAAL_vAssist_BLE_Service_Template_Callback callback)
				throws RemoteException {
			mIAAL_vAssist_BLE_Service_Template_Callbacks.register(callback);
			
		}

		@Override
		public BluetoothDevice[] getConnectedDevices() throws RemoteException {
			// TODO Auto-generated method stub
			return null;
		}
	};

	/**
	 * 
	 */
	public AAl_vAssist_BLE_Service_Template() {
		// TODO Auto-generated constructor stub
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see android.app.Service#onBind(android.content.Intent)
	 */
	@Override
	public IBinder onBind(Intent arg0) {
		// do something with the intent
		// you can return different binders according to the intent sent in the
		// bindService(Intent service, ServiceConnection conn, int flags)
		
		return mIAAL_vAssist_BLE_Service_Template;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see android.app.Service#onRebind(android.content.Intent)
	 */
	@Override
	public void onRebind(Intent intent) {

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see android.app.Service#onCreate()
	 */
	@Override
	public void onCreate() {

		enableBluetooth();

		if (mBluetoothAdapter == null) {
			// Initializes Bluetooth adapter. in API level 18
			final BluetoothManager bluetoothManager = (BluetoothManager) getSystemService(Context.BLUETOOTH_SERVICE);
			mBluetoothAdapter = bluetoothManager.getAdapter();

			if (mBluetoothAdapter == null) {

				return;
			}

		}

		mBluetoothGattCharacteristicHandler = new BluetoothGattCharacteristicHandler();
		mBluetoothGattCharacteristicHandler.setContext(this);

		scan(true);
	}

	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		return super.onStartCommand(intent, flags, startId);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * android.app.Service#onConfigurationChanged(android.content.res.Configuration
	 * )
	 */
	@Override
	public void onConfigurationChanged(Configuration newConfig) {
		super.onConfigurationChanged(newConfig);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see android.app.Service#onDestroy()
	 */
	@Override
	public void onDestroy() {
		super.onDestroy();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see android.app.Service#onLowMemory()
	 */
	@Override
	public void onLowMemory() {
		super.onLowMemory();
	}

	/**
	 * we need Bluetooth to be enabled constantly.
	 */
	private boolean enableBluetooth() {
		if (!mBluetoothAdapter.isEnabled()) {

			return mBluetoothAdapter.enable();
		}
		return true;
	}

	/**
	 * @param start
	 *            true or stop false
	 */
	private void scan(boolean start) {

		if (start && scanStatus == SCAN_IDLE) {
			mBluetoothAdapter.startLeScan(mLeScanCallback);
		} else {

		}

	}
	//===============================================================================
	//
	// implementation of broadcast to subscribing applications
	// we made those method static in order to use them inside static handlers
	//
	//===============================================================================
	
	
	/**
	 * broadcast the connection event to subscribers
	 * 
	 * integrate this to your code to your ServiceListener code
	 * 
	 * @param device the BluetoothDevice that we are connected to
	 */
	private static void broadcastConnectedToBTLEDevice(BluetoothDevice device){
		
		int i = mIAAL_vAssist_BLE_Service_Template_Callbacks.beginBroadcast();
		while (i > 0) {
			i--;
			try {
				mIAAL_vAssist_BLE_Service_Template_Callbacks.getBroadcastItem(i).onConnectedToDevice(device);
			} catch (RemoteException e) {
				// The RemoteCallbackList will take care of removing
				// the dead object for us.
			}
		}
		mIAAL_vAssist_BLE_Service_Template_Callbacks.finishBroadcast();
	}
	
	

	
	/**
	 * broadcast the disconnection event to subscribers
	 * 
	 * @param device the BluetoothDevice that we are disconnected from
	 */
	private static void broadcastDisconnectedFromBTLEDevice(BluetoothDevice device){
		
		int i = mIAAL_vAssist_BLE_Service_Template_Callbacks.beginBroadcast();
		while (i > 0) {
			i--;
			try {
				mIAAL_vAssist_BLE_Service_Template_Callbacks.getBroadcastItem(i).onDisconnectedFromDevice(device);
			} catch (RemoteException e) {
				// The RemoteCallbackList will take care of removing
				// the dead object for us.
			}
		}
		mIAAL_vAssist_BLE_Service_Template_Callbacks.finishBroadcast();
	}
	
	
	
	//================================================================================

	/**
	 * @author Shankaa, Hugues Sansen for AAL vAssist project
	 * 
	 *         Licence : European Union Public License (EUPL)
	 * 
	 *         you are ready to treat all standard messages received from the
	 *         remote BLE server.
	 *         
	 *         We suggest you to implement the corresponding logics 
	 * 
	 * 
	 */
	public class BluetoothGattCharacteristicHandler implements
	IBluetoothGattCharacteristicHandler {
		
		
		
		
		/**
		 * context is used when the IBluetoothGattCharacteristicHandler implementer is not embedded inside the context class
		 * 
		 */
		private AAl_vAssist_BLE_Service_Template context;

		@Override
		public void setContext(Context context) {
			this.context = (AAl_vAssist_BLE_Service_Template) context;

		}

		@Override
		public void on_default(Bundle bundle, String uuid) {
			// TODO Auto-generated method stub

		}

		@Override
		public void on_aggregate_input(Bundle bundle, int inputBits,
				int analogInput) {
			// TODO Auto-generated method stub

		}

		@Override
		public void on_alert_category_id(Bundle bundle, int categoryID,
				String comment) {
			// TODO Auto-generated method stub

		}

		@Override
		public void on_alert_category_id_bit_mask(Bundle bundle,
				int categoryIDBitMask0, int categoryIDBitMask1) {
			// TODO Auto-generated method stub

		}

		@Override
		public void on_alert_level(Bundle bundle, int alertLevel) {
			// TODO Auto-generated method stub

		}

		@Override
		public void on_alert_notification_control_point(Bundle bundle,
				int commandID, String commandIDComment, int categoryID,
				String categoryIDComment) {
			// TODO Auto-generated method stub

		}

		@Override
		public void on_alert_status(Bundle bundle, int alertStatus,
				int ringerState, int vibratorState, int displayAlertStatus) {
			// TODO Auto-generated method stub

		}

		@Override
		public void on_analog_input(Bundle bundle, int analogValue) {
			// TODO Auto-generated method stub

		}

		@Override
		public void on_analog_output(Bundle bundle, int analogValue) {
			// TODO Auto-generated method stub

		}

		@Override
		public void on_battery_level(Bundle bundle, int level) {
			// TODO Auto-generated method stub

		}

		@Override
		public void on_battery_level_state(Bundle bundle, int level,
				int rawState, int[] stateBits, String[] stateComments) {
			// TODO Auto-generated method stub

		}

		@Override
		public void on_battery_power_state(Bundle bundle, int rawState,
				int[] stateBits, String[] stateComments) {
			// TODO Auto-generated method stub

		}

		@Override
		public void on_blood_pressure_feature(Bundle bundle,
				int bloodPressureFeature, int[] features) {
			// TODO Auto-generated method stub

		}

		@Override
		public void on_blood_pressure_measurement(Bundle bundle, int[] flags,
				int units, float systolic, float diastolic,
				float meanArterialPressure, int[] date, Calendar calendar,
				float pulseRate, int userID, int[] measurementStatusBits,
				String[] measurementStatusBitsComments) {
			// TODO Auto-generated method stub

		}

		@Override
		public void on_body_sensor_location(Bundle bundle,
				int bodySensorLocation, String value) {
			// TODO Auto-generated method stub

		}

		@Override
		public void on_handle_boot_keyboard_input_report(Bundle bundle,
				int bootKeyboardInputReportValue) {
			// TODO Auto-generated method stub

		}

		@Override
		public void on_handle_boot_keyboard_output_report(Bundle bundle,
				int bootKeyboardInputReportValue) {
			// TODO Auto-generated method stub

		}

		@Override
		public void on_boot_mouse_input_report(Bundle bundle,
				int bootMouseInputReportValue) {
			// TODO Auto-generated method stub

		}

		@Override
		public void on_csc_feature(Bundle bundle, int cSCFeatureValue,
				int[] cSCFeatureBits, String[] cSCFeatureComments) {
			// TODO Auto-generated method stub

		}

		@Override
		public void on_csc_measurement(Bundle bundle, int flags, int[] _flags,
				String[] flagsComments, int cumulativeWheelRevolutions,
				int lastWheelEventTime, int cumulativeCrankRevolutions,
				int lastCrankEventTime) {
			// TODO Auto-generated method stub

		}

		@Override
		public void on_current_time(Bundle bundle, int yy, int mm, int dd,
				int hh, int mn, int ss, int dw, int s_256, int adjustReason) {
			// TODO Auto-generated method stub

		}

		@Override
		public void on_cycling_power_control_point(Bundle bundle, int opCodes,
				String opCodesValue, String opCodeDescription) {
			// TODO Auto-generated method stub

		}

		@Override
		public void on_cycling_power_feature(Bundle bundle,
				int cyclingPowerFeature) {
			// TODO Auto-generated method stub

		}

		@Override
		public void on_cycling_power_vector(Bundle bundle, int flags,
				int crankRevolutionData_CumulativeCrankRevolutions,
				int crankRevolutionData_LastCrankEventTime,
				int firstCrankMeasurementAngle,
				int[] instantaneousForceMagnitudeArray,
				int[] instantaneousTorqueMagnitudeArray) {
			// TODO Auto-generated method stub

		}

		@Override
		public void on_date_time(Bundle bundle, int[] dateTimeArray,
				Calendar date) {
			// TODO Auto-generated method stub

		}

		@Override
		public void on_day_date_time(Bundle bundle, int[] dayDateTimeArray,
				Calendar date) {
			// TODO Auto-generated method stub

		}

		@Override
		public void on_day_of_week(Bundle bundle, int dayOfWeek) {
			// TODO Auto-generated method stub

		}

		@Override
		public void on_digital_input(Bundle bundle, int[] bitArray) {
			// TODO Auto-generated method stub

		}

		@Override
		public void on_digital_output(Bundle bundle, int[] bitArray) {
			// TODO Auto-generated method stub

		}

		@Override
		public void on_dst_offset(Bundle bundle, int dSTOffset, String value) {
			// TODO Auto-generated method stub

		}

		@Override
		public void on_exact_time_100(Bundle bundle, int[] exacTime100) {
			// TODO Auto-generated method stub

		}

		@Override
		public void on_exact_time_256(Bundle bundle, int[] exacTime256) {
			// TODO Auto-generated method stub

		}

		@Override
		public void on_firmware_revision_string(Bundle bundle,
				String firmwareRevision) {
			// TODO Auto-generated method stub

		}

		@Override
		public void on_gap_appearance(Bundle bundle, int category,
				int subCategory) {
			// TODO Auto-generated method stub

		}

		@Override
		public void on_gap_device_name(Bundle bundle, String deviceName) {
			// TODO Auto-generated method stub

		}

		@Override
		public void on_gap_peripheral_preferred_connection_parameters(
				Bundle bundle, int minimumConnectionInterval,
				int maximumConnectionInterval, int slaveLatency,
				int connectionSupervisionTimeoutMultiplier) {
			// TODO Auto-generated method stub

		}

		@Override
		public void on_gap_peripheral_privacy_flag(Bundle bundle, boolean flag,
				String value) {
			// TODO Auto-generated method stub

		}

		@Override
		public void on_gap_reconnection_address(Bundle bundle, int address) {
			// TODO Auto-generated method stub

		}

		@Override
		public void on_gatt_service_changed(Bundle bundle,
				int startOfAffectedAttributeHandleRange,
				int endOfAffectedAttributeHandleRange) {
			// TODO Auto-generated method stub

		}

		@Override
		public void on_glucose_feature(Bundle bundle, int glucoseFeature,
				boolean[] glucoseFeatures, String[] glucoseFeatureValues) {
			// TODO Auto-generated method stub

		}

		@Override
		public void on_glucose_measurement(Bundle bundle, int flags,
				int sequenceNumber, Calendar date, int timeOffset,
				float glucoseConcentration_units_of_kg_per_L,
				float glucoseConcentration_units_of_mol_per_L, int type,
				int sampleLocation, int sensorStatusAnnunciation) {
			// TODO Auto-generated method stub

		}

		@Override
		public void on_glucose_measurement_context(Bundle bundle, int flags,
				int sequenceNumber, int extendedFlags, int carbohydrateID,
				float carbohydrate_unitsofkilograms, int meal, int tester,
				int health, int exerciseDuration, int exerciseIntensity,
				int medicationID, float medication_units,
				int MedicationValueUnits, float hbA1c) {
			// TODO Auto-generated method stub

		}

		@Override
		public void on_hardware_revision_string(Bundle bundle,
				String hardwareRevision) {
			// TODO Auto-generated method stub

		}

		@Override
		public void on_heart_rate_control_point(Bundle bundle,
				int heartRateControlPoint) {
			// TODO Auto-generated method stub

		}

		@Override
		public void on_heart_rate_measurement(Bundle bundle, int flags,
				int sensorContactStatusbits, String sensorContactStatus,
				int heartRateMeasurementValue, int energyExpended,
				int rr_Interval) {
			// TODO Auto-generated method stub

		}

		@Override
		public void on_hid_control_point(Bundle bundle,
				int hIDControlPointCommand) {
			// TODO Auto-generated method stub

		}

		@Override
		public void on_hid_information(Bundle bundle, int bcdHID,
				int bCountryCode, int flags) {
			// TODO Auto-generated method stub

		}

		@Override
		public void on_handle_ieee_11073_20601_regulatory_certification_data_list(
				Bundle bundle,
				IEEE_11073_20601_REGULATORY_CERTIFICATION_DATA_LIST list) {
			// TODO Auto-generated method stub

		}

		@Override
		public void on_intermediate_cuff_pressure(Bundle bundle, int[] flags,
				int units, float systolic, float diastolic,
				float meanArterialPressure, int[] date, Calendar calendar,
				float pulseRate, int userID, int[] measurementStatusBits,
				String[] measurementStatusBitsComments) {
			// TODO Auto-generated method stub

		}

		@Override
		public void on_intermediate_temperature(Bundle bundle, int flags,
				float TemperatureMeasurementValue, int TemperatureUnitFlag,
				Calendar date, int temperatureType, String temperatureTypeString) {
			// TODO Auto-generated method stub

		}

		@Override
		public void on_ln_control_point(Bundle bundle, int OpCodes,
				String OpCodeString, String OpCodeComment, int ResponseValue,
				String ResponseValueString, String ResponseValueComment,
				int[] ResponseParameter) {
			// TODO Auto-generated method stub

		}

		@Override
		public void on_ln_feature(Bundle bundle, int LNFeature,
				String[] LNFeatureValues) {
			// TODO Auto-generated method stub

		}

		@Override
		public void on_local_time_information(Bundle bundle, int TimeZone,
				String TimeZoneString, int dSTOffset, String value) {
			// TODO Auto-generated method stub

		}

		@Override
		public void on_location_and_speed(Bundle bundle, int flags,
				String[] flagValues, int InstantaneousSpeed, int TotalDistance,
				int LocationLatitude, int LocationLongitude, int Elevation,
				int Heading, int RollingTime, Calendar date) {
			// TODO Auto-generated method stub

		}

		@Override
		public void on_manufacturer_name_string(Bundle bundle,
				String manufacturer_name_string) {
			// TODO Auto-generated method stub

		}

		@Override
		public void on_measurement_interval(Bundle bundle,
				int MeasurementInterval) {
			// TODO Auto-generated method stub

		}

		@Override
		public void on_model_number_string(Bundle bundle, String model_number) {
			// TODO Auto-generated method stub

		}

		@Override
		public void on_navigation(Bundle bundle, int flags,
				String[] FlagsValues, int Bearing, int Heading,
				int RemainingDistance, int RemainingVerticalDistance,
				Calendar eta) {
			// TODO Auto-generated method stub

		}

		@Override
		public void on_new_alert(Bundle bundle, int NumberofNewAlert,
				String TextStringInformation) {
			// TODO Auto-generated method stub

		}

		@Override
		public void on_pnp_id(Bundle bundle, int VendorIDSource, int VendorID,
				int ProductID, int ProductVersion) {
			// TODO Auto-generated method stub

		}

		@Override
		public void on_position_quality(Bundle bundle, int Flags,
				int NumberofBeaconsinSolution, int NumberofBeaconsinView,
				int TimetoFirstFix, int EHPE, int EVPE, int HDOP, int VDOP) {
			// TODO Auto-generated method stub

		}

		@Override
		public void on_protocol_mode(Bundle bundle, int ProtocolModeValue) {
			// TODO Auto-generated method stub

		}

		@Override
		public void on_pulse_oximetry_continuous_measurement(Bundle bundle,
				int Flags, int MeasurementStatus, int DeviceandSensorStatus,
				int ThresholdStatus) {
			// TODO Auto-generated method stub

		}

		@Override
		public void on_pulse_oximetry_control_point(Bundle bundle, int Flags,
				int MeasurementStatus, int DeviceandSensorStatus,
				int ThresholdStatus) {
			// TODO Auto-generated method stub

		}

		@Override
		public void on_pulse_oximetry_pulsatile_event(Bundle bundle, int Flags,
				int PulseFlags) {
			// TODO Auto-generated method stub

		}

		@Override
		public void on_pulse_oximetry_features(Bundle bundle, int Flags,
				int ConfigurationSupport, int MeasurementStatusSupport,
				int DeviceandSensorStatus, int SpotCheckOperatingMode,
				int ContinuousMeasurementOperatingModeSupport) {
			// TODO Auto-generated method stub

		}

		@Override
		public void on_pulse_oximetry_spot_check_measurement(Bundle bundle,
				int Flags, int MeasurementStatus, int DeviceandSensorStatus) {
			// TODO Auto-generated method stub

		}

		@Override
		public void on_record_access_control_point(Bundle bundle, int OpCode,
				int Operator, byte[] RestOfRecord) {
			// TODO Auto-generated method stub

		}

		@Override
		public void on_reference_time_information(Bundle bundle,
				int TimeSource, int Accuracy, int HoursSinceUpdate) {
			// TODO Auto-generated method stub

		}

		@Override
		public void on_removable(Bundle bundle, int Removable) {
			// TODO Auto-generated method stub

		}

		@Override
		public void on_report(Bundle bundle, int ReportValue) {
			// TODO Auto-generated method stub

		}

		@Override
		public void on_report_map(Bundle bundle, int ReportMap) {
			// TODO Auto-generated method stub

		}

		@Override
		public void on_ringer_control_point(Bundle bundle,
				int RingerControlPoint, String RingerControlPointText) {
			// TODO Auto-generated method stub

		}

		@Override
		public void on_rsc_feature(Bundle bundle, int RSCFeature) {
			// TODO Auto-generated method stub

		}

		@Override
		public void on_rsc_measurement(Bundle bundle, int Flags,
				int InstantaneousSpeed, int InstantaneousCadence,
				int InstantaneousStrideLength, int TotalDistance) {
			// TODO Auto-generated method stub

		}

		@Override
		public void on_scan_refresh(Bundle bundle, int ScanRefreshValue) {
			// TODO Auto-generated method stub

		}

		@Override
		public void on_scientific_temperature_celsius(Bundle bundle,
				double ScientificTemperature) {
			// TODO Auto-generated method stub

		}

		@Override
		public void on_secondary_time_zone(Bundle bundle, int TimeZone,
				String TimeZoneString) {
			// TODO Auto-generated method stub

		}

		@Override
		public void on_sensor_location(Bundle bundle, int SensorLocation,
				String SensorLocationText) {
			// TODO Auto-generated method stub

		}

		@Override
		public void on_serial_number_string(Bundle bundle,
				String serial_number_string) {
			// TODO Auto-generated method stub

		}

		@Override
		public void on_service_required(Bundle bundle, int ServiceRequired) {
			// TODO Auto-generated method stub

		}

		@Override
		public void on_software_revision_string(Bundle bundle, String rev) {
			// TODO Auto-generated method stub

		}

		@Override
		public void on_string(Bundle bundle, String string) {
			// TODO Auto-generated method stub

		}

		@Override
		public void on_supported_new_alert_category(Bundle bundle,
				int categoryIDBitMask0, int categoryIDBitMask1) {
			// TODO Auto-generated method stub

		}

		@Override
		public void on_supported_unread_alert_category(Bundle bundle,
				int categoryIDBitMask0, int categoryIDBitMask1) {
			// TODO Auto-generated method stub

		}

		@Override
		public void on_system_id(Bundle bundle, int[] manufacturerIdentifier,
				int[] organizationallyUniqueIdentifier) {
			// TODO Auto-generated method stub

		}

		@Override
		public void on_temperature_celsius(Bundle bundle, float Temperature) {
			// TODO Auto-generated method stub

		}

		@Override
		public void on_temperature_fahrenheit(Bundle bundle, float Temperature) {
			// TODO Auto-generated method stub

		}

		@Override
		public void on_temperature_measurement(Bundle bundle, int flags,
				float TemperatureMeasurementValue, int TemperatureUnitFlag,
				Calendar date, int temperatureType, String temperatureTypeString) {
			// TODO Auto-generated method stub

		}

		@Override
		public void on_temperature_type(Bundle bundle, int flag,
				String TemperatureTextDescription) {
			// TODO Auto-generated method stub

		}

		@Override
		public void on_time_accuracy(Bundle bundle, int Accuracy) {
			// TODO Auto-generated method stub

		}

		@Override
		public void on_time_source(Bundle bundle, int TimeSource,
				String TimeSourceString) {
			// TODO Auto-generated method stub

		}

		@Override
		public void on_time_update_control_point(Bundle bundle,
				int TimeUpdateControlPoint, String TimeUpdateControlPointString) {
			// TODO Auto-generated method stub

		}

		@Override
		public void on_time_update_state(Bundle bundle, int CurrentState,
				String CurrentStateString, int Result, String ResultString) {
			// TODO Auto-generated method stub

		}

		@Override
		public void on_time_with_dst(Bundle bundle, Calendar date,
				int dSTOffset, String dSTOffsetValue) {
			// TODO Auto-generated method stub

		}

		@Override
		public void on_time_zone(Bundle bundle, int TimeZone,
				String TimeZoneString) {
			// TODO Auto-generated method stub

		}

		@Override
		public void on_tx_power_level(Bundle bundle, int txPoxer) {
			// TODO Auto-generated method stub

		}

		@Override
		public void on_unread_alert_status(Bundle bundle, int categoryId,
				String comment, int Unreadcount) {
			// TODO Auto-generated method stub

		}

		@Override
		public void on_bluegiga_manufacturer_id(Bundle bundle, String hex) {
			// TODO Auto-generated method stub

		}

		@Override
		public void on_bluegiga_model_number(Bundle bundle, String hex) {
			// TODO Auto-generated method stub

		}

		@Override
		public void on_bluegiga_manufacturer_name(Bundle bundle, String hex) {
			// TODO Auto-generated method stub

		}

		@Override
		public void on_bluegiga_Battery(Bundle bundle, String value) {
			// TODO Auto-generated method stub

		}

		@Override
		public void on_handle_bluegiga_accelerometer_x_data(Bundle bundle,
				float x_data) {
			// TODO Auto-generated method stub

		}

		@Override
		public void on_handle_bluegiga_accelerometer_y_data(Bundle bundle,
				float y_data) {
			// TODO Auto-generated method stub

		}

		@Override
		public void on_handle_bluegiga_accelerometer_z_data(Bundle bundle,
				float z_data) {
			// TODO Auto-generated method stub

		}

		@Override
		public void on_handle_asica_heart_rate(Bundle bundle, Calendar date,
				int heartRate) {
			// TODO Auto-generated method stub

		}

		@Override
		public void on_handle_asica_fall_detection_alert(Bundle bundle,
				Calendar date, boolean alertButtonPressed,
				boolean fallDetected, boolean lowBattery,
				boolean ambulatoryTerminalRequest, int futureUse) {
			// TODO Auto-generated method stub

		}

		@Override
		public void on_asica_ambulatory_terminal_state(Bundle bundle,
				Calendar date, boolean fallDetectorWear, boolean horizontal,
				boolean earlobeSensorOff, boolean earlobeUnplugged,
				int futureUse) {
			// TODO Auto-generated method stub

		}

		@Override
		public void on_asica_ambulatory_terminal_activity(Bundle bundle,
				Calendar date, int activity, int futureUse) {
			// TODO Auto-generated method stub

		}

	}

}
