package org.aal.vassist.bluetooth.le.gatt.refimpl;

import org.aal.vassist.bluetooth.le.gatt.refimpl.IAAL_vAssist_BLE_Service_Logs_Callback;


/**
 * @author Hugues Sansen, Shankaa, for AAL vAssist project, http://vassist.cure.at/project_overview/
 * 
 *         Licence : European Union Public License (EUPL)
 *
 */
interface IAAL_vAssist_BLE_Service_Logs {

    void registerLogsCallback(IAAL_vAssist_BLE_Service_Logs_Callback cb);
    
    void unregisterLogsCallback(IAAL_vAssist_BLE_Service_Logs_Callback cb);
    
}