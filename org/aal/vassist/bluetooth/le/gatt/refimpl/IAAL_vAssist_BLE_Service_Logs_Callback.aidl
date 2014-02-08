package org.aal.vassist.bluetooth.le.gatt.refimpl;



/**
 * @author Hugues Sansen, Shankaa, for AAL vAssist project, http://vassist.cure.at/project_overview/
 * 
 *         Licence : European Union Public License (EUPL)
 *
 */
oneway interface IAAL_vAssist_BLE_Service_Logs_Callback {
	
	/**
	 * gets the log for a BT LE event
	 * @param time the event time in milliseconds,
	 * @param ops the type of operation (read, write etc)
	 * @param uuid the BTLE uuid service
	 * @param the packet received
	 */
	void onBTLELog(long time, int ops, String uuid,in byte[] packet);
}