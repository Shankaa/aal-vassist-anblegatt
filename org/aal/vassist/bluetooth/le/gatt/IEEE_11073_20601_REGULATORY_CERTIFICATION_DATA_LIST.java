/**
 * 
 */
package org.aal.vassist.bluetooth.le.gatt;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Bundle;


/**
 * established with
 * PERSONAL HEALTH DEVICES TRANSCODING WHITE PAPER
 * 31 May 2012
 * Revision V13r00
 * Document File Name Personal Health Devices Transcoding_WP_V13
 * 
 * @author Shankaa, Hugues Sansen
 * 
 * Licence : European Union Public License (EUPL)
 *
 */
public class IEEE_11073_20601_REGULATORY_CERTIFICATION_DATA_LIST {
	
	public static String EXTRA_Regulatory_Certification_Data_List_Count = "org.aal.vassist.Regulatory_Certification_Data_List_Count";
	public static String EXTRA_Regulatory_Certification_Data_List_Length = "org.aal.vassist.Regulatory_Certification_Data_List_Length";
	public static String EXTRA_Authorization_Body = "org.aal.vassist.EXTRA_Authorization_Body";
	public static String EXTRA_Authorization_Body_Structure_Type = "org.aal.vassist.EXTRA_Authorization_Body_Structure_Type";
	public static String EXTRA_Authorization_Body_Structure_Length = "org.aal.vassist.EXTRA_Authorization_Body_Structure_Length";
	public static String EXTRA_Major_IG_version = "org.aal.vassist.Major_IG_version";
	public static String EXTRA_Minor_IG_version = "org.aal.vassist.Minor_IG_version";
	public static String EXTRA_Certified_device_class_list_Count = "org.aal.vassist.Certified_device_class_list_Count";
	public static String EXTRA_Certified_device_class_list_Length = "org.aal.vassist.Certified_device_class_list_Length";
	public static String EXTRA_Certified_device_class_entry = "org.aal.vassist.Certified_device_class_entry";
	public static String EXTRA_Continua_Regulatory_Structure = "org.aal.vassist.Continua_Regulatory_Structure";
	public static String EXTRA_Structure_length = "org.aal.vassist.Structure_length";
	public static String EXTRA_Regulation_Bit_Field_Type = "org.aal.vassist.Regulation_Bit_Field_Type";

	
	public int RegCertDataList_count;
	public int RegCertDataList_length;
	public int authorizationBody;
	public int authorizationBodyStructureType;
	public int authorizationBodyStructureLength;
	public int majorIGversion;
	public int minorIGversion;
	public int Certifieddeviceclasslistcount;
	public int Certifieddeviceclasslistlength ;
	public int[] Certifieddeviceclassentry ;
	public int ContinuaRegulatoryStructure;
	public int Structurelength;
	public int RegulationBitFieldType;
	
	public IEEE_11073_20601_REGULATORY_CERTIFICATION_DATA_LIST(Bundle bundle){
		this.RegCertDataList_count = bundle.getInt(EXTRA_Regulatory_Certification_Data_List_Count);
		this.RegCertDataList_length = bundle.getInt(EXTRA_Regulatory_Certification_Data_List_Length);
		this.authorizationBody = bundle.getInt(EXTRA_Authorization_Body);
		this.authorizationBodyStructureType = bundle.getInt(EXTRA_Authorization_Body_Structure_Type);
		this.authorizationBodyStructureLength = bundle.getInt(EXTRA_Authorization_Body_Structure_Length);
		this.majorIGversion = bundle.getInt(EXTRA_Major_IG_version);
		this.minorIGversion = bundle.getInt(EXTRA_Minor_IG_version);
		this.Certifieddeviceclasslistcount = bundle.getInt(EXTRA_Certified_device_class_list_Count);
		this.Certifieddeviceclasslistlength = bundle.getInt(EXTRA_Certified_device_class_list_Length);
		this.Certifieddeviceclassentry = bundle.getIntArray(EXTRA_Certified_device_class_entry);
		this.ContinuaRegulatoryStructure = bundle.getInt(EXTRA_Continua_Regulatory_Structure);
		this.Structurelength = bundle.getInt(EXTRA_Structure_length);
		this.RegulationBitFieldType = bundle.getInt(EXTRA_Regulation_Bit_Field_Type);
	}
	
	public IEEE_11073_20601_REGULATORY_CERTIFICATION_DATA_LIST(BluetoothGattCharacteristic characteristic, int offset){
	
		//Regulatory Certification Data List
		RegCertDataList_count = characteristic.getIntValue(BluetoothGattCharacteristic.FORMAT_UINT16, offset);
		offset += 2;
		RegCertDataList_length = characteristic.getIntValue(BluetoothGattCharacteristic.FORMAT_UINT16, offset);
		offset += 2;
		authorizationBody = characteristic.getIntValue(BluetoothGattCharacteristic.FORMAT_UINT32, offset);
		offset += 1;
		authorizationBodyStructureType = characteristic.getIntValue(BluetoothGattCharacteristic.FORMAT_UINT32, offset);
		offset += 1;
		authorizationBodyStructureLength = characteristic.getIntValue(BluetoothGattCharacteristic.FORMAT_UINT16, offset);
		offset += 2;
		
		//Authorizing Body Data
		majorIGversion = characteristic.getIntValue(BluetoothGattCharacteristic.FORMAT_UINT32, offset);
		offset += 1;
		minorIGversion = characteristic.getIntValue(BluetoothGattCharacteristic.FORMAT_UINT32, offset);
		offset += 1;
		
		//Certified device class list
		Certifieddeviceclasslistcount = characteristic.getIntValue(BluetoothGattCharacteristic.FORMAT_UINT16, offset);
		offset += 2;
		Certifieddeviceclasslistlength = characteristic.getIntValue(BluetoothGattCharacteristic.FORMAT_UINT16, offset);
		offset += 2;
		
		Certifieddeviceclassentry = new int[Certifieddeviceclasslistcount];
		for (int i = 0;i<Certifieddeviceclasslistcount;i++){
			Certifieddeviceclassentry[i] = characteristic.getIntValue(BluetoothGattCharacteristic.FORMAT_UINT16, offset);
			offset += 2;
		}
		ContinuaRegulatoryStructure = characteristic.getIntValue(BluetoothGattCharacteristic.FORMAT_UINT16, offset);
		offset += 2;
		Structurelength = characteristic.getIntValue(BluetoothGattCharacteristic.FORMAT_UINT16, offset);
		offset += 2;
		RegulationBitFieldType = characteristic.getIntValue(BluetoothGattCharacteristic.FORMAT_UINT16, offset);
		offset += 2;
	
	}
	

	
	public Bundle toBundle(){
		Bundle bundle = new Bundle();
		bundle.putInt(EXTRA_Regulatory_Certification_Data_List_Count, RegCertDataList_count);
		bundle.putInt(EXTRA_Regulatory_Certification_Data_List_Length, RegCertDataList_length);
		bundle.putInt(EXTRA_Authorization_Body, authorizationBody);
		bundle.putInt(EXTRA_Authorization_Body_Structure_Type, authorizationBodyStructureType);
		bundle.putInt(EXTRA_Authorization_Body_Structure_Length, authorizationBodyStructureLength);
		bundle.putInt(EXTRA_Major_IG_version, majorIGversion);
		bundle.putInt(EXTRA_Minor_IG_version, minorIGversion);
		bundle.putInt(EXTRA_Certified_device_class_list_Count, Certifieddeviceclasslistcount);
		bundle.putInt(EXTRA_Certified_device_class_list_Length, Certifieddeviceclasslistlength);
		bundle.putIntArray(EXTRA_Certified_device_class_entry, Certifieddeviceclassentry);
		bundle.putInt(EXTRA_Continua_Regulatory_Structure , ContinuaRegulatoryStructure);
		bundle.putInt(EXTRA_Structure_length, Structurelength);
		bundle.putInt(EXTRA_Regulation_Bit_Field_Type, RegulationBitFieldType);
		return bundle;
	}
}
