//IAAl_vAssist_BLE_Service_Template_Callback.aidl file

package org.aal.vassist.bluetooth.le.gatt.refimpl;


import android.bluetooth.BluetoothDevice;

/**
 * @author Hugues Sansen, Shankaa, for AAL vAssist project, http://vassist.cure.at/project_overview/
 * 
 *         Licence : European Union Public License (EUPL)
 *
 */
oneway interface IAAL_vAssist_BLE_Service_Template_Callback {

	
	void onConnectedToDevice(in BluetoothDevice device);
	
	void onDisconnectedFromDevice(in BluetoothDevice device);


}