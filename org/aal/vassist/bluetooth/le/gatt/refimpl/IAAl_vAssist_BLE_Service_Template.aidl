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
     * register a callback interface with the service to allow the service to call back to its clients.
     * You must implement a subclass of IAAL_vAssist_AT_Service_Callback in your code
     * eg : IAAL_vAssist_BLE_Service_Template_Callback.Stub mAAL_vAssist_BLE_Service_Template_Callback = new IAAL_vAssist_BLE_Service_Template_Callback.Stub() {....
     */
	void registerCallback(IAAL_vAssist_BLE_Service_Template_Callback callback);
	
	/**
     * Remove a previously registered callback interface.
     * Callbacks should unregister before destroying the application.
     * 
     */
    void unregisterCallback(IAAL_vAssist_BLE_Service_Template_Callback callback);
	
	/**
	 * return an array of all Bluetooth LE connected devices
	 *
	 */
	BluetoothDevice[] getConnectedDevices();

	//Etc....
}