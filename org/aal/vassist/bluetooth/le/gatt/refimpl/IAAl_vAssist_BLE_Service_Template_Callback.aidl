//IAAl_vAssist_BLE_Service_Template_Callback.aidl file

package org.aal.vassist.bluetooth.le.gatt.refimpl;
import android.bluetooth.BluetoothDevice;

/**
 * @author Hugues Sansen, Shankaa, for AAL vAssist project, http://vassist.cure.at/project_overview/
 * 
 *         Licence : European Union Public License (EUPL)
 *
 */
interface IAAL_vAssist_BLE_Service_Template_Callback {

	
	BluetoothDevice connectedToDevice();
	
	BluetoothDevice disconnectedFromDevice();


}