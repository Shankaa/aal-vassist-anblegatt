//IAAl_vAssist_BLE_Service_Template.aidl file

package org.aal.vassist.bluetooth.le.gatt.refimpl;
import android.bluetooth.BluetoothDevice;

import org.aal.vassist.bluetooth.le.gatt.refimpl.IAAL_vAssist_BLE_Service_Template_Callback;

/**
 * @author Hugues Sansen, Shankaa, for AAL vAssist project, http://vassist.cure.at/project_overview/
 * 
 *         Licence : European Union Public License (EUPL)
 *
 */
interface IAAL_vAssist_BLE_Service_Template {
	
	/**
	 * register the callback on the IAAL_vAssist_BLE_Service_Template
	 *
	 */
	void registerCallback(IAAL_vAssist_BLE_Service_Template_Callback callback);
	
	/**
	 * return an array of all Bluetooth LE connected devices
	 *
	 */
	BluetoothDevice[] getConnectedDevices();


}