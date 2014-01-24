package org.aal.vassist.bluetooth.le.gatt;

import java.lang.Character.UnicodeBlock;
import java.math.BigInteger;
import java.util.Calendar;
import java.util.UUID;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattService;
import android.os.Bundle;
import android.os.Message;
import android.util.Log;


/**
 * @author Shankaa, Hugues Sansen for AAL vAssist project
 * 
 *         Licence : European Union Public License (EUPL)
 * 
 *         an implementation attempt of org.bluetooth.characteristic
 *         specification for Samsung Bluetooh LE API for android 4.2.2
 * 
 *         We could have done it automatically from reading the specifications
 *         XML.
 * 
 * 
 *         based on specifications available on May 15, 2013 on bluetooth SIG
 *         website
 * 
 *         facilitates a standard coding of
 *         BluetoothGattCallback.onCharacteristicChanged()
 *         BluetoothGattCallback.onCharacteristicRead()
 * 
 *         and prepares the Message sent to a static handler
 * 
 *         most comments are based on the specification comments and are subject
 *         to Bluetooth SIG copyright
 * 
 *         In some cases the specification may not have been understood
 *         correctly You are invited to test your application
 * 
 */
public class BluetoothGattSpecification_Characteristics {

	private static final String TAG = "BluetoothGattSpecification_Characteristics";

	public static final UUID SERVICE_alert_notification = UUID
			.fromString("00001811-0000-1000-8000-00805f9b34fb");
	public static final UUID SERVICE_automation_io = UUID
			.fromString("00001815-0000-1000-8000-00805f9b34fb");
	public static final UUID SERVICE_battery_service = UUID
			.fromString("0000180f-0000-1000-8000-00805f9b34fb");
	public static final UUID SERVICE_blood_pressure = UUID
			.fromString("00001810-0000-1000-8000-00805f9b34fb");
	public static final UUID SERVICE_current_time = UUID
			.fromString("00001805-0000-1000-8000-00805f9b34fb");
	public static final UUID SERVICE_cycling_power = UUID
			.fromString("00001818-0000-1000-8000-00805f9b34fb");
	public static final UUID SERVICE_cycling_speed_and_cadence = UUID
			.fromString("00001816-0000-1000-8000-00805f9b34fb");
	public static final UUID SERVICE_device_information = UUID
			.fromString("0000180a-0000-1000-8000-00805f9b34fb");
	public static final UUID SERVICE_generic_access = UUID
			.fromString("00001800-0000-1000-8000-00805f9b34fb");
	public static final UUID SERVICE_generic_attribute = UUID
			.fromString("00001801-0000-1000-8000-00805f9b34fb");
	public static final UUID SERVICE_glucose = UUID
			.fromString("00001808-0000-1000-8000-00805f9b34fb");
	public static final UUID SERVICE_health_thermometer = UUID
			.fromString("00001809-0000-1000-8000-00805f9b34fb");
	public static final UUID SERVICE_heart_rate = UUID
			.fromString("0000180d-0000-1000-8000-00805f9b34fb");
	public static final UUID SERVICE_human_interface_device = UUID
			.fromString("00001812-0000-1000-8000-00805f9b34fb");
	public static final UUID SERVICE_immediate_alert = UUID
			.fromString("00001802-0000-1000-8000-00805f9b34fb");
	public static final UUID SERVICE_link_loss = UUID
			.fromString("00001803-0000-1000-8000-00805f9b34fb");
	public static final UUID SERVICE_location_and_navigation = UUID
			.fromString("00001819-0000-1000-8000-00805f9b34fb");
	public static final UUID SERVICE_network_availability = UUID
			.fromString("0000180b-0000-1000-8000-00805f9b34fb");
	public static final UUID SERVICE_next_dst_change = UUID
			.fromString("00001807-0000-1000-8000-00805f9b34fb");
	public static final UUID SERVICE_phone_alert_status = UUID
			.fromString("0000180e-0000-1000-8000-00805f9b34fb");
	public static final UUID SERVICE_reference_time_update = UUID
			.fromString("00001806-0000-1000-8000-00805f9b34fb");
	public static final UUID SERVICE_running_speed_and_cadence = UUID
			.fromString("00001814-0000-1000-8000-00805f9b34fb");
	public static final UUID SERVICE_scan_parameters = UUID
			.fromString("00001813-0000-1000-8000-00805f9b34fb");
	public static final UUID SERVICE_tx_power = UUID
			.fromString("00001804-0000-1000-8000-00805f9b34fb");

	public static final UUID SERVICE_manufacturer = UUID
			.fromString("00009000-0000-1000-8000-00805f9b34fb");
	public static final UUID SERVICE_bluegiga_battery = UUID
			.fromString("0000e001-0000-1000-8000-00805f9b34fb");
	public static final UUID SERVICE_bluegiga_accelerometer = UUID
			.fromString("6d480f49-91d3-4a18-be29-0d27f4109c23");

	public static final UUID SERVICE_asica_ambulatory_terminal = UUID
			.fromString("72ab49a0-cde1-11e2-84b3-0002a5d5c51b");

	// characteristics as they appear in the specification
	public static final UUID GATT_CHARACTERISTIC_aggregate_input = UUID
			.fromString("00002a5a-0000-1000-8000-00805f9b34fb");
	public static final UUID GATT_CHARACTERISTIC_alert_category_id = UUID
			.fromString("00002a43-0000-1000-8000-00805f9b34fb");
	public static final UUID GATT_CHARACTERISTIC_alert_category_id_bit_mask = UUID
			.fromString("00002a42-0000-1000-8000-00805f9b34fb");
	public static final UUID GATT_CHARACTERISTIC_alert_level = UUID
			.fromString("00002a06-0000-1000-8000-00805f9b34fb");
	public static final UUID GATT_CHARACTERISTIC_alert_notification_control_point = UUID
			.fromString("00002a44-0000-1000-8000-00805f9b34fb");
	public static final UUID GATT_CHARACTERISTIC_alert_status = UUID
			.fromString("00002a3f-0000-1000-8000-00805f9b34fb");
	public static final UUID GATT_CHARACTERISTIC_analog_input = UUID
			.fromString("00002a58-0000-1000-8000-00805f9b34fb");
	public static final UUID GATT_CHARACTERISTIC_analog_output = UUID
			.fromString("00002a59-0000-1000-8000-00805f9b34fb");
	public static final UUID GATT_CHARACTERISTIC_battery_level = UUID
			.fromString("00002a19-0000-1000-8000-00805f9b34fb");
	public static final UUID GATT_CHARACTERISTIC_battery_level_state = UUID
			.fromString("00002a1b-0000-1000-8000-00805f9b34fb");
	public static final UUID GATT_CHARACTERISTIC_battery_power_state = UUID
			.fromString("00002a1a-0000-1000-8000-00805f9b34fb");
	public static final UUID GATT_CHARACTERISTIC_blood_pressure_feature = UUID
			.fromString("00002a49-0000-1000-8000-00805f9b34fb");
	public static final UUID GATT_CHARACTERISTIC_blood_pressure_measurement = UUID
			.fromString("00002a35-0000-1000-8000-00805f9b34fb");
	public static final UUID GATT_CHARACTERISTIC_body_sensor_location = UUID
			.fromString("00002a38-0000-1000-8000-00805f9b34fb");
	public static final UUID GATT_CHARACTERISTIC_boot_keyboard_input_report = UUID
			.fromString("00002a22-0000-1000-8000-00805f9b34fb");
	public static final UUID GATT_CHARACTERISTIC_boot_keyboard_output_report = UUID
			.fromString("00002a32-0000-1000-8000-00805f9b34fb");
	public static final UUID GATT_CHARACTERISTIC_boot_mouse_input_report = UUID
			.fromString("00002a33-0000-1000-8000-00805f9b34fb");
	public static final UUID GATT_CHARACTERISTIC_csc_feature = UUID
			.fromString("00002a5c-0000-1000-8000-00805f9b34fb");
	public static final UUID GATT_CHARACTERISTIC_csc_measurement = UUID
			.fromString("00002a5b-0000-1000-8000-00805f9b34fb");
	public static final UUID GATT_CHARACTERISTIC_current_time = UUID
			.fromString("00002a2b-0000-1000-8000-00805f9b34fb");
	public static final UUID GATT_CHARACTERISTIC_cycling_power_control_point = UUID
			.fromString("00002a66-0000-1000-8000-00805f9b34fb");
	public static final UUID GATT_CHARACTERISTIC_cycling_power_feature = UUID
			.fromString("00002a65-0000-1000-8000-00805f9b34fb");
	public static final UUID GATT_CHARACTERISTIC_cycling_power_vector = UUID
			.fromString("00002a64-0000-1000-8000-00805f9b34fb");
	public static final UUID GATT_CHARACTERISTIC_date_time = UUID
			.fromString("00002a08-0000-1000-8000-00805f9b34fb");
	public static final UUID GATT_CHARACTERISTIC_day_date_time = UUID
			.fromString("00002a0a-0000-1000-8000-00805f9b34fb");
	public static final UUID GATT_CHARACTERISTIC_day_of_week = UUID
			.fromString("00002a09-0000-1000-8000-00805f9b34fb");
	public static final UUID GATT_CHARACTERISTIC_digital_input = UUID
			.fromString("00002a56-0000-1000-8000-00805f9b34fb");
	public static final UUID GATT_CHARACTERISTIC_digital_output = UUID
			.fromString("00002a57-0000-1000-8000-00805f9b34fb");
	public static final UUID GATT_CHARACTERISTIC_dst_offset = UUID
			.fromString("00002a0d-0000-1000-8000-00805f9b34fb");
	public static final UUID GATT_CHARACTERISTIC_exact_time_100 = UUID
			.fromString("00002a0b-0000-1000-8000-00805f9b34fb");
	public static final UUID GATT_CHARACTERISTIC_exact_time_256 = UUID
			.fromString("00002a0c-0000-1000-8000-00805f9b34fb");
	public static final UUID GATT_CHARACTERISTIC_firmware_revision_string = UUID
			.fromString("00002a26-0000-1000-8000-00805f9b34fb");
	public static final UUID GATT_CHARACTERISTIC_gap_appearance = UUID
			.fromString("00002a01-0000-1000-8000-00805f9b34fb");
	public static final UUID GATT_CHARACTERISTIC_gap_device_name = UUID
			.fromString("00002a00-0000-1000-8000-00805f9b34fb");
	public static final UUID GATT_CHARACTERISTIC_gap_peripheral_preferred_connection_parameters = UUID
			.fromString("00002a04-0000-1000-8000-00805f9b34fb");
	public static final UUID GATT_CHARACTERISTIC_gap_peripheral_privacy_flag = UUID
			.fromString("00002a02-0000-1000-8000-00805f9b34fb");
	public static final UUID GATT_CHARACTERISTIC_gap_reconnection_address = UUID
			.fromString("00002a03-0000-1000-8000-00805f9b34fb");
	public static final UUID GATT_CHARACTERISTIC_gatt_service_changed = UUID
			.fromString("00002a05-0000-1000-8000-00805f9b34fb");
	public static final UUID GATT_CHARACTERISTIC_glucose_feature = UUID
			.fromString("00002a51-0000-1000-8000-00805f9b34fb");
	public static final UUID GATT_CHARACTERISTIC_glucose_measurement = UUID
			.fromString("00002a18-0000-1000-8000-00805f9b34fb");
	public static final UUID GATT_CHARACTERISTIC_glucose_measurement_context = UUID
			.fromString("00002a34-0000-1000-8000-00805f9b34fb");
	public static final UUID GATT_CHARACTERISTIC_hardware_revision_string = UUID
			.fromString("00002a27-0000-1000-8000-00805f9b34fb");
	public static final UUID GATT_CHARACTERISTIC_heart_rate_control_point = UUID
			.fromString("00002a39-0000-1000-8000-00805f9b34fb");
	public static final UUID GATT_CHARACTERISTIC_heart_rate_measurement = UUID
			.fromString("00002a37-0000-1000-8000-00805f9b34fb");
	public static final UUID GATT_CHARACTERISTIC_hid_control_point = UUID
			.fromString("00002a4c-0000-1000-8000-00805f9b34fb");
	public static final UUID GATT_CHARACTERISTIC_hid_information = UUID
			.fromString("00002a4a-0000-1000-8000-00805f9b34fb");
	public static final UUID GATT_CHARACTERISTIC_ieee_11073_20601_regulatory_certification_data_list = UUID
			.fromString("00002a2a-0000-1000-8000-00805f9b34fb");
	public static final UUID GATT_CHARACTERISTIC_intermediate_cuff_pressure = UUID
			.fromString("00002a36-0000-1000-8000-00805f9b34fb");
	public static final UUID GATT_CHARACTERISTIC_intermediate_temperature = UUID
			.fromString("00002a1e-0000-1000-8000-00805f9b34fb");
	public static final UUID GATT_CHARACTERISTIC_ln_control_point = UUID
			.fromString("00002a6b-0000-1000-8000-00805f9b34fb");
	public static final UUID GATT_CHARACTERISTIC_ln_feature = UUID
			.fromString("00002a6a-0000-1000-8000-00805f9b34fb");
	public static final UUID GATT_CHARACTERISTIC_local_time_information = UUID
			.fromString("00002a0f-0000-1000-8000-00805f9b34fb");
	public static final UUID GATT_CHARACTERISTIC_location_and_speed = UUID
			.fromString("00002a67-0000-1000-8000-00805f9b34fb");
	public static final UUID GATT_CHARACTERISTIC_manufacturer_name_string = UUID
			.fromString("00002a29-0000-1000-8000-00805f9b34fb");
	public static final UUID GATT_CHARACTERISTIC_measurement_interval = UUID
			.fromString("00002a21-0000-1000-8000-00805f9b34fb");
	public static final UUID GATT_CHARACTERISTIC_model_number_string = UUID
			.fromString("00002a24-0000-1000-8000-00805f9b34fb");
	public static final UUID GATT_CHARACTERISTIC_navigation = UUID
			.fromString("00002a68-0000-1000-8000-00805f9b34fb");
	public static final UUID GATT_CHARACTERISTIC_network_availability = UUID
			.fromString("00002a3e-0000-1000-8000-00805f9b34fb");
	public static final UUID GATT_CHARACTERISTIC_new_alert = UUID
			.fromString("00002a46-0000-1000-8000-00805f9b34fb");
	public static final UUID GATT_CHARACTERISTIC_pnp_id = UUID
			.fromString("00002a50-0000-1000-8000-00805f9b34fb");
	public static final UUID GATT_CHARACTERISTIC_position_quality = UUID
			.fromString("00002a69-0000-1000-8000-00805f9b34fb");
	public static final UUID GATT_CHARACTERISTIC_protocol_mode = UUID
			.fromString("00002a4e-0000-1000-8000-00805f9b34fb");
	public static final UUID GATT_CHARACTERISTIC_pulse_oximetry_continuous_measurement = UUID
			.fromString("00002a5f-0000-1000-8000-00805f9b34fb");
	public static final UUID GATT_CHARACTERISTIC_pulse_oximetry_control_point = UUID
			.fromString("00002a62-0000-1000-8000-00805f9b34fb");
	public static final UUID GATT_CHARACTERISTIC_pulse_oximetry_features = UUID
			.fromString("00002a61-0000-1000-8000-00805f9b34fb");
	public static final UUID GATT_CHARACTERISTIC_pulse_oximetry_pulsatile_event = UUID
			.fromString("00002a60-0000-1000-8000-00805f9b34fb");
	public static final UUID GATT_CHARACTERISTIC_pulse_oximetry_spot_check_measurement = UUID
			.fromString("00002a5e-0000-1000-8000-00805f9b34fb");
	public static final UUID GATT_CHARACTERISTIC_record_access_control_point = UUID
			.fromString("00002a52-0000-1000-8000-00805f9b34fb");
	public static final UUID GATT_CHARACTERISTIC_reference_time_information = UUID
			.fromString("00002a14-0000-1000-8000-00805f9b34fb");
	public static final UUID GATT_CHARACTERISTIC_removable = UUID
			.fromString("00002a3a-0000-1000-8000-00805f9b34fb");
	public static final UUID GATT_CHARACTERISTIC_report = UUID
			.fromString("00002a4d-0000-1000-8000-00805f9b34fb");
	public static final UUID GATT_CHARACTERISTIC_report_map = UUID
			.fromString("00002a4b-0000-1000-8000-00805f9b34fb");
	public static final UUID GATT_CHARACTERISTIC_ringer_control_point = UUID
			.fromString("00002a40-0000-1000-8000-00805f9b34fb");
	public static final UUID GATT_CHARACTERISTIC_ringer_setting = UUID
			.fromString("00002a41-0000-1000-8000-00805f9b34fb");
	public static final UUID GATT_CHARACTERISTIC_rsc_feature = UUID
			.fromString("00002a54-0000-1000-8000-00805f9b34fb");
	public static final UUID GATT_CHARACTERISTIC_rsc_measurement = UUID
			.fromString("00002a53-0000-1000-8000-00805f9b34fb");
	public static final UUID GATT_CHARACTERISTIC_sc_control_point = UUID
			.fromString("00002a55-0000-1000-8000-00805f9b34fb");
	public static final UUID GATT_CHARACTERISTIC_scan_interval_window = UUID
			.fromString("00002a4f-0000-1000-8000-00805f9b34fb");
	public static final UUID GATT_CHARACTERISTIC_scan_refresh = UUID
			.fromString("00002a31-0000-1000-8000-00805f9b34fb");
	public static final UUID GATT_CHARACTERISTIC_scientific_temperature_celsius = UUID // sfloat64
			.fromString("00002a3c-0000-1000-8000-00805f9b34fb");
	public static final UUID GATT_CHARACTERISTIC_secondary_time_zone = UUID //
			.fromString("00002a10-0000-1000-8000-00805f9b34fb");
	public static final UUID GATT_CHARACTERISTIC_sensor_location = UUID
			.fromString("00002a5d-0000-1000-8000-00805f9b34fb");
	public static final UUID GATT_CHARACTERISTIC_serial_number_string = UUID
			.fromString("00002a25-0000-1000-8000-00805f9b34fb");
	public static final UUID GATT_CHARACTERISTIC_service_required = UUID
			.fromString("00002a3b-0000-1000-8000-00805f9b34fb");
	public static final UUID GATT_CHARACTERISTIC_software_revision_string = UUID
			.fromString("00002a28-0000-1000-8000-00805f9b34fb");
	public static final UUID GATT_CHARACTERISTIC_string = UUID
			.fromString("00002a3d-0000-1000-8000-00805f9b34fb");
	public static final UUID GATT_CHARACTERISTIC_supported_new_alert_category = UUID
			.fromString("00002a47-0000-1000-8000-00805f9b34fb");
	public static final UUID GATT_CHARACTERISTIC_supported_unread_alert_category = UUID
			.fromString("00002a48-0000-1000-8000-00805f9b34fb");
	public static final UUID GATT_CHARACTERISTIC_system_id = UUID
			.fromString("00002a23-0000-1000-8000-00805f9b34fb");
	public static final UUID GATT_CHARACTERISTIC_temperature_celsius = UUID // sint16
			.fromString("00002a1f-0000-1000-8000-00805f9b34fb");
	public static final UUID GATT_CHARACTERISTIC_temperature_fahrenheit = UUID // sint16
			.fromString("00002a20-0000-1000-8000-00805f9b34fb");
	public static final UUID GATT_CHARACTERISTIC_temperature_measurement = UUID // 8bit
			.fromString("00002a1c-0000-1000-8000-00805f9b34fb");
	public static final UUID GATT_CHARACTERISTIC_temperature_type = UUID
			.fromString("00002a1d-0000-1000-8000-00805f9b34fb");
	public static final UUID GATT_CHARACTERISTIC_time_accuracy = UUID // uint8
			.fromString("00002a12-0000-1000-8000-00805f9b34fb");
	public static final UUID GATT_CHARACTERISTIC_time_broadcast = UUID
			.fromString("00002a15-0000-1000-8000-00805f9b34fb");
	public static final UUID GATT_CHARACTERISTIC_time_source = UUID
			.fromString("00002a13-0000-1000-8000-00805f9b34fb");
	public static final UUID GATT_CHARACTERISTIC_time_update_control_point = UUID
			.fromString("00002a16-0000-1000-8000-00805f9b34fb");
	public static final UUID GATT_CHARACTERISTIC_time_update_state = UUID
			.fromString("00002a17-0000-1000-8000-00805f9b34fb");
	public static final UUID GATT_CHARACTERISTIC_time_with_dst = UUID
			.fromString("00002a11-0000-1000-8000-00805f9b34fb");
	public static final UUID GATT_CHARACTERISTIC_time_zone = UUID
			.fromString("00002a0e-0000-1000-8000-00805f9b34fb");
	public static final UUID GATT_CHARACTERISTIC_tx_power_level = UUID
			.fromString("00002a07-0000-1000-8000-00805f9b34fb");
	public static final UUID GATT_CHARACTERISTIC_unread_alert_status = UUID
			.fromString("00002a45-0000-1000-8000-00805f9b34fb");

	// Bluegiga
	public static final UUID GATT_CHARACTERISTIC_bluegiga_manufacturer_id = UUID
			.fromString("00009100-0000-1000-8000-00805f9b34fb");
	public static final UUID GATT_CHARACTERISTIC_bluegiga_model_number = UUID
			.fromString("00009101-0000-1000-8000-00805f9b34fb");
	public static final UUID GATT_CHARACTERISTIC_bluegiga_manufacturer_name = UUID
			.fromString("00009106-0000-1000-8000-00805f9b34fb");

	public static final UUID GATT_CHARACTERISTIC_bluegiga_xgatt_battery = UUID
			.fromString("0000e101-0000-1000-8000-00805f9b34fb");

	public static final UUID GATT_CHARACTERISTIC_bluegiga_accelerometer_x_data = UUID
			.fromString("11c3876c-9bda-42cc-a30b-1be83c8059d3");
	public static final UUID GATT_CHARACTERISTIC_bluegiga_accelerometer_y_data = UUID
			.fromString("7c55527b-4027-42ae-ae6d-6d1309e5d97e");
	public static final UUID GATT_CHARACTERISTIC_bluegiga_accelerometer_z_data = UUID
			.fromString("f1fa1ce8-cbcc-4401-8428-ae947bd512ae");

	// vAssist fall detection by ASICA
	public static final UUID GATT_CHARACTERISTIC_asica_heart_rate = UUID
			.fromString("40583c00-cde7-11e2-9d17-0002a5d5c51b");
	public static final UUID GATT_CHARACTERISTIC_asica_fall_detection_alert = UUID
			.fromString("f01c60e0-cde6-11e2-a81d-0002a5d5c51b");
	public static final UUID GATT_CHARACTERISTIC_asica_AT_state = UUID
			.fromString("7fe19ac0-cde6-11e2-9002-0002a5d5c51b");
	public static final UUID GATT_CHARACTERISTIC_asica_fall_detection_activity = UUID
			.fromString("efe67940-cde5-11e2-9faa-0002a5d5c51b");
	public static final UUID GATT_CHARACTERISTIC_asica_fall_detection_hour_reset_request = UUID
			.fromString("93749740-cde6-11e2-a1a2-0002a5d5c51b");

	// GATT Characteristic Descriptors
	public static final UUID DESCRIPTOR_external_report_reference = UUID
			.fromString("00002907-0000-1000-8000-00805f9b34fb");
	public static final UUID DESCRIPTOR_characteristic_extended_properties = UUID
			.fromString("00002900-0000-1000-8000-00805f9b34fb");
	public static final UUID DESCRIPTOR_characteristic_presentation_format = UUID
			.fromString("00002904-0000-1000-8000-00805f9b34fb");
	public static final UUID DESCRIPTOR_characteristic_user_description = UUID
			.fromString("00002901-0000-1000-8000-00805f9b34fb");
	public static final UUID DESCRIPTOR_client_characteristic_configuration = UUID
			.fromString("00002902-0000-1000-8000-00805f9b34fb");
	public static final UUID DESCRIPTOR_server_characteristic_configuration = UUID
			.fromString("00002903-0000-1000-8000-00805f9b34fb");
	public static final UUID DESCRIPTOR_number_of_digitals = UUID
			.fromString("00002909-0000-1000-8000-00805f9b34fb");
	public static final UUID DESCRIPTOR_report_reference = UUID
			.fromString("00002908-0000-1000-8000-00805f9b34fb");
	public static final UUID DESCRIPTOR_trigger_setting = UUID
			.fromString("0000290a-0000-1000-8000-00805f9b34fb");
	public static final UUID DESCRIPTOR_valid_range = UUID
			.fromString("00002906-0000-1000-8000-00805f9b34fb");
	public static final UUID DESCRIPTOR_characteristic_aggregate_format = UUID
			.fromString("00002905-0000-1000-8000-00805f9b34fb");

	public static final String EXTRA_UUID = BluetoothDevice.EXTRA_UUID;
	public static final String EXTRA_SERVICE_UUID = "org.aal.vassist.at.SERVICE.EXTRA_UUID";

	public static final String NUMBER_OF_EXTRA_ARGS = "org.aal.vassist.at.NUMBER_OF_ARGUMENTS";

	public static final String EXTRA_VALUE = "org.aal.vassist.at.VALUE";
	public static final String EXTRA_VALUE0 = "org.aal.vassist.at.VALUE0";
	public static final String EXTRA_VALUE1 = "org.aal.vassist.at.VALUE1";
	public static final String EXTRA_VALUE2 = "org.aal.vassist.at.VALUE2";
	public static final String EXTRA_VALUE3 = "org.aal.vassist.at.VALUE3";
	public static final String EXTRA_VALUE4 = "org.aal.vassist.at.VALUE4";
	public static final String EXTRA_VALUE5 = "org.aal.vassist.at.VALUE5";
	public static final String EXTRA_VALUE6 = "org.aal.vassist.at.VALUE6";
	public static final String EXTRA_VALUE7 = "org.aal.vassist.at.VALUE7";
	public static final String EXTRA_VALUE8 = "org.aal.vassist.at.VALUE8";
	public static final String EXTRA_VALUE9 = "org.aal.vassist.at.VALUE9";
	public static final String EXTRA_VALUE10 = "org.aal.vassist.at.VALUE10";
	public static final String EXTRA_VALUE11 = "org.aal.vassist.at.VALUE11";
	public static final String EXTRA_VALUE12 = "org.aal.vassist.at.VALUE12";
	public static final String EXTRA_VALUE13 = "org.aal.vassist.at.VALUE13";
	public static final String EXTRA_VALUE14 = "org.aal.vassist.at.VALUE14";
	public static final String EXTRA_VALUE15 = "org.aal.vassist.at.VALUE15";

	public static final String EXTRA_VALUE0_FORMAT = "org.aal.vassist.at.VALUE0_FORMAT";
	public static final String EXTRA_VALUE1_FORMAT = "org.aal.vassist.at.VALUE1_FORMAT";
	public static final String EXTRA_VALUE2_FORMAT = "org.aal.vassist.at.VALUE2_FORMAT";
	public static final String EXTRA_VALUE3_FORMAT = "org.aal.vassist.at.VALUE3_FORMAT";
	public static final String EXTRA_VALUE4_FORMAT = "org.aal.vassist.at.VALUE4_FORMAT";
	public static final String EXTRA_VALUE5_FORMAT = "org.aal.vassist.at.VALUE5_FORMAT";
	public static final String EXTRA_VALUE6_FORMAT = "org.aal.vassist.at.VALUE6_FORMAT";
	public static final String EXTRA_VALUE7_FORMAT = "org.aal.vassist.at.VALUE7_FORMAT";
	public static final String EXTRA_VALUE8_FORMAT = "org.aal.vassist.at.VALUE8_FORMAT";

	public static final String EXTRA_VALUE0_NAME = "org.aal.vassist.at.VALUE0_NAME";
	public static final String EXTRA_VALUE1_NAME = "org.aal.vassist.at.VALUE1_NAME";
	public static final String EXTRA_VALUE2_NAME = "org.aal.vassist.at.VALUE2_NAME";
	public static final String EXTRA_VALUE3_NAME = "org.aal.vassist.at.VALUE3_NAME";
	public static final String EXTRA_VALUE4_NAME = "org.aal.vassist.at.VALUE4_NAME";
	public static final String EXTRA_VALUE5_NAME = "org.aal.vassist.at.VALUE5_NAME";
	public static final String EXTRA_VALUE6_NAME = "org.aal.vassist.at.VALUE6_NAME";
	public static final String EXTRA_VALUE7_NAME = "org.aal.vassist.at.VALUE7_NAME";
	public static final String EXTRA_VALUE8_NAME = "org.aal.vassist.at.VALUE8_NAME";

	public static final String EXTRA_VALUE_int = "org.aal.vassist.at.int";
	public static final String EXTRA_VALUE_long = "org.aal.vassist.at.long";
	public static final String EXTRA_VALUE_float = "org.aal.vassist.at.float";
	public static final String EXTRA_VALUE_double = "org.aal.vassist.at.double";
	public static final String EXTRA_VALUE_String = "org.aal.vassist.at.String";
	public static final String EXTRA_VALUE_intArray = "org.aal.vassist.at.intArray";
	public static final String EXTRA_VALUE_StringArray = "org.aal.vassist.at.StringArray";

	private static final int MSG_aggregate_input = 0x2a5a;
	private static final int MSG_alert_category_id = 0x2a43;
	private static final int MSG_alert_category_id_bit_mask = 0x2a42;
	private static final int MSG_alert_level = 0x2a06;
	private static final int MSG_alert_notification_control_point = 0x2a44;
	private static final int MSG_alert_status = 0x2a3f;
	private static final int MSG_analog_input = 0x2a58;
	private static final int MSG_analog_output = 0x2a59;
	private static final int MSG_battery_level = 0x2a19;
	private static final int MSG_battery_level_state = 0x2a1b;
	private static final int MSG_battery_power_state = 0x2a1a;
	private static final int MSG_blood_pressure_feature = 0x2a49;
	private static final int MSG_blood_pressure_measurement = 0x2a35;
	private static final int MSG_body_sensor_location = 0x2a38;
	private static final int MSG_boot_keyboard_input_report = 0x2a22;
	private static final int MSG_boot_keyboard_output_report = 0x2a32;
	private static final int MSG_boot_mouse_input_report = 0x2a33;
	private static final int MSG_csc_feature = 0x2a5c;
	private static final int MSG_csc_measurement = 0x2a5b;
	private static final int MSG_current_time = 0x2a2b;
	private static final int MSG_cycling_power_control_point = 0x2a66;
	private static final int MSG_cycling_power_feature = 0x2a65;
	private static final int MSG_cycling_power_vector = 0x2a64;
	private static final int MSG_date_time = 0x2a08;
	private static final int MSG_day_date_time = 0x2a0a;
	private static final int MSG_day_of_week = 0x2a09;
	private static final int MSG_digital_input = 0x2a56;
	private static final int MSG_digital_output = 0x2a57;
	private static final int MSG_dst_offset = 0x2a0d;
	private static final int MSG_exact_time_100 = 0x2a0b;
	private static final int MSG_exact_time_256 = 0x2a0c;
	private static final int MSG_firmware_revision_string = 0x2a26;
	private static final int MSG_gap_appearance = 0x2a01;
	private static final int MSG_gap_device_name = 0x2a00;
	private static final int MSG_gap_peripheral_preferred_connection_parameters = 0x2a04;
	private static final int MSG_gap_peripheral_privacy_flag = 0x2a02;
	private static final int MSG_gap_reconnection_address = 0x2a03;
	private static final int MSG_gatt_service_changed = 0x2a05;
	private static final int MSG_glucose_feature = 0x2a51;
	private static final int MSG_glucose_measurement = 0x2a18;
	private static final int MSG_glucose_measurement_context = 0x2a34;
	private static final int MSG_hardware_revision_string = 0x2a27;
	private static final int MSG_heart_rate_control_point = 0x2a39;
	private static final int MSG_heart_rate_measurement = 0x2a37;
	private static final int MSG_hid_control_point = 0x2a4c;
	private static final int MSG_hid_information = 0x2a4a;
	private static final int MSG_ieee_11073_20601_regulatory_certification_data_list = 0x2a2a;
	private static final int MSG_intermediate_cuff_pressure = 0x2a36;
	private static final int MSG_intermediate_temperature = 0x2a1e;
	private static final int MSG_ln_control_point = 0x2a6b;
	private static final int MSG_ln_feature = 0x2a6a;
	private static final int MSG_local_time_information = 0x2a0f;
	private static final int MSG_location_and_speed = 0x2a67;
	private static final int MSG_manufacturer_name_string = 0x2a29;
	private static final int MSG_measurement_interval = 0x2a21;
	private static final int MSG_model_number_string = 0x2a24;
	private static final int MSG_navigation = 0x2a68;
	private static final int MSG_network_availability = 0x2a3e;
	private static final int MSG_new_alert = 0x2a46;
	private static final int MSG_pnp_id = 0x2a50;
	private static final int MSG_position_quality = 0x2a69;
	private static final int MSG_protocol_mode = 0x2a4e;
	private static final int MSG_pulse_oximetry_continuous_measurement = 0x2a5f;
	private static final int MSG_pulse_oximetry_control_point = 0x2a62;
	private static final int MSG_pulse_oximetry_features = 0x2a61;
	private static final int MSG_pulse_oximetry_pulsatile_event = 0x2a60;
	private static final int MSG_pulse_oximetry_spot_check_measurement = 0x2a5e;
	private static final int MSG_record_access_control_point = 0x2a52;
	private static final int MSG_reference_time_information = 0x2a14;
	private static final int MSG_removable = 0x2a3a;
	private static final int MSG_report = 0x2a4d;
	private static final int MSG_report_map = 0x2a4b;
	private static final int MSG_ringer_control_point = 0x2a40;
	private static final int MSG_ringer_setting = 0x2a41;
	private static final int MSG_rsc_feature = 0x2a54;
	private static final int MSG_rsc_measurement = 0x2a53;
	private static final int MSG_sc_control_point = 0x2a55;
	private static final int MSG_scan_interval_window = 0x2a4f;
	private static final int MSG_scan_refresh = 0x2a31;
	private static final int MSG_scientific_temperature_celsius = 0x2a3c;
	private static final int MSG_secondary_time_zone = 0x2a10;
	private static final int MSG_sensor_location = 0x2a5d;
	private static final int MSG_serial_number_string = 0x2a25;
	private static final int MSG_service_required = 0x2a3b;
	private static final int MSG_software_revision_string = 0x2a28;
	private static final int MSG_string = 0x2a3d;
	private static final int MSG_supported_new_alert_category = 0x2a47;
	private static final int MSG_supported_unread_alert_category = 0x2a48;
	private static final int MSG_system_id = 0x2a23;
	private static final int MSG_temperature_celsius = 0x2a1f;
	private static final int MSG_temperature_fahrenheit = 0x2a20;
	private static final int MSG_temperature_measurement = 0x2a1c;
	private static final int MSG_temperature_type = 0x2a1d;
	private static final int MSG_time_accuracy = 0x2a12;
	private static final int MSG_time_broadcast = 0x2a15;
	private static final int MSG_time_source = 0x2a13;
	private static final int MSG_time_update_control_point = 0x2a16;
	private static final int MSG_time_update_state = 0x2a17;
	private static final int MSG_time_with_dst = 0x2a11;
	private static final int MSG_time_zone = 0x2a0e;
	private static final int MSG_tx_power_level = 0x2a07;
	private static final int MSG_unread_alert_status = 0x2a45;

	private static final int MSG_bluegiga_manufacturer_id = 0x9100;
	private static final int MSG_bluegiga_model_number = 0x9101;
	private static final int MSG_bluegiga_manufacturer_name = 0x9106;
	private static final int MSG_bluegiga_xgatt_battery = 0xe101;
	private static final int MSG_bluegiga_accelerometer_x_data = 0x11c3876c;
	private static final int MSG_bluegiga_accelerometer_y_data = 0x7c55527b;
	private static final int MSG_bluegiga_accelerometer_z_data = 0xf1fa1ce8;

	private static final int MSG_asica_heart_rate = 0x40583c00;
	private static final int MSG_asica_fall_detection_alert = 0xf01c60e0;
	private static final int MSG_asica_ambulatory_terminal_state = 0x7fe19ac0;
	private static final int MSG_asica_fall_detection_activity = 0xefe67940;
	private static final int MSG_asica_fall_detection_hour_reset_request = 0x9374974;

	/*
	 * public static final UUID GATT_CHARACTERISTIC_asica_heart_rate = UUID
	 * .fromString("40583c00-cde7-11e2-9d17-0002a5d5c51b"); public static final
	 * UUID GATT_CHARACTERISTIC_asica_fall_detection_alert = UUID
	 * .fromString("f01c60e0-cde6-11e2_a81d-0002a5d5c51b"); public static final
	 * UUID GATT_CHARACTERISTIC_asica_AT_state = UUID
	 * .fromString("7fe19ac0-cde6-11e2-9002-0002a5d5c51b"); public static final
	 * UUID GATT_CHARACTERISTIC_asica_fall_detection_activity = UUID
	 * .fromString("efe67940-cde5-11e2-9faa-0002a5d5c51b"); public static final
	 * UUID GATT_CHARACTERISTIC_asica_fall_detection_hour_reset_request = UUID
	 * .fromString("9374974-cde6-11e2-a1a2-0002a5d5c51b");
	 */

	public static final int FORMAT_FLOAT64 = 54; // BluetoothGattCharacteristic.FORMAT_FLOAT
	public static final int FORMAT_FLOAT = 52; // BluetoothGattCharacteristic.FORMAT_FLOAT
	public static final int FORMAT_SFLOAT = 50; // BluetoothGattCharacteristic.FORMAT_SFLOAT
	public static final int FORMAT_SINT128 = 44;
	public static final int FORMAT_SINT64 = 40;
	public static final int FORMAT_SINT48 = 38;
	public static final int FORMAT_SINT40 = 37;
	public static final int FORMAT_SINT32 = 36; // BluetoothGattCharacteristic.FORMAT_SFLOAT
	public static final int FORMAT_SINT24 = 35;
	public static final int FORMAT_SINT16 = 34; // BluetoothGattCharacteristic.FORMAT_SINT16
	public static final int FORMAT_SINT8 = 33; // BluetoothGattCharacteristic.FORMAT_SINT32
	public static final int FORMAT_UINT128 = 28;
	public static final int FORMAT_UINT64 = 24;
	public static final int FORMAT_UINT48 = 22;
	public static final int FORMAT_UINT40 = 21;
	public static final int FORMAT_UINT32 = 20; // BluetoothGattCharacteristic.FORMAT_UINT32
	public static final int FORMAT_UINT24 = 19;
	public static final int FORMAT_UINT16 = 18; // BluetoothGattCharacteristic.FORMAT_UINT16
	public static final int FORMAT_UINT8 = 17; // BluetoothGattCharacteristic.FORMAT_UINT8

	private static final int FLOAT_SIZE = 4;
	private static final int SFLOAT_SIZE = 2;
	private static final int SINT64_SIZE = 4;
	private static final int SINT48_SIZE = 4;
	private static final int SINT40_SIZE = 4;
	private static final int SINT32_SIZE = 4;
	private static final int SINT16_SIZE = 2;
	private static final int SINT8_SIZE = 1;
	private static final int UINT64_SIZE = 4;
	private static final int UINT48_SIZE = 4;
	private static final int UINT40_SIZE = 4;
	private static final int UINT32_SIZE = 4;
	private static final int UINT24_SIZE = 3;
	private static final int UINT16_SIZE = 2;
	private static final int UINT8_SIZE = 1;
	private static final int BYTE_SIZE = 1;
	
	private static final boolean CORRECT_ASICA_ENDIANNESS_BUG = true;

	/**
	 * designed to be used directly in
	 * BluetoothGattCallback.onCharacteristicChanged
	 * BluetoothGattCallback.onCharacteristicRead (in that case do not forget to
	 * manage the success status)
	 * 
	 * onCharacteristicChanged( BluetoothGattCharacteristic characteristic) {
	 * Log.d(TAG, "onCharacteristicChanged " + characteristicUuid());
	 * 
	 * Message msg; //instantiate a bundle Bundle bundle = new Bundle(); // add
	 * your custom extra values to the bundle handleCharacteristic(Bundle
	 * bundle, BluetoothGattCharacteristic characteristic); // add custom
	 * characteristic behavior
	 * 
	 * // then send the msg to the handler for an asynchronous management msg =
	 * Message.obtain(mGattServiceHandler, MSG_CHARACTERISTIC_READ); if (msg !=
	 * null) { msg.setData(bundle); msg.sendToTarget(); }
	 * 
	 * }
	 * 
	 * 
	 * puts Extra values into the bundle according to Bluetooth SIG values in
	 * EXTRA_VALUE0, EXTRA_VALUE1 etc and corresponding format in
	 * EXTRA_VALUE0_FORMAT, EXTRA_VALUE1_FORMAT as strings : "int", "long",
	 * "float", "double", "String"
	 * 
	 * characterisics specifications * put extra values into bundle:
	 * BluetoothDevice.EXTRA_UUID the characteristic uuid String see
	 * EXTRA_VALUEX meaning in the following methods
	 * 
	 * put the prefix value as int into message.what
	 * 
	 * note that BluetoothDevice.EXTRA_UUID is put into the bundle in order for
	 * the handler to be static so you do not need to put a what value in your
	 * message The characterististic's service UUID is put into
	 * EXTRA_SERVICE_UUID = "org.aal.vassist.at.SERVICE.EXTRA_UUID"; in order to
	 * manage the characteristic of an especial service.
	 * 
	 * @param bundle
	 * @param characteristic
	 * @param msg
	 *            the message that will be sent to the handler
	 * 
	 */
	public static void onCharacteristicReadOrChange(Bundle bundle,
			BluetoothGattCharacteristic characteristic, Message msg) {
		UUID uuid = characteristic.getUuid();
		BluetoothGattService service = characteristic.getService();
		UUID serviceUUID = service.getUuid();
		bundle.putString(BluetoothDevice.EXTRA_UUID, uuid.toString());
		bundle.putString(EXTRA_SERVICE_UUID, serviceUUID.toString());
		byte[] characteristicValue = characteristic.getValue();
		bundle.putByteArray(EXTRA_VALUE, characteristicValue);
		int offset = 0;
		int[] nextOffset = new int[] { 0 };
		msg.arg2 = 0;
		if (GATT_CHARACTERISTIC_aggregate_input.equals(uuid)) {
			msg.arg1 = aggregate_input(bundle, characteristic, offset,
					nextOffset);
		} else if (GATT_CHARACTERISTIC_alert_category_id.equals(uuid)) {
			msg.arg1 = alert_category_id(bundle, characteristic, offset,
					nextOffset);
		} else if (GATT_CHARACTERISTIC_alert_category_id_bit_mask.equals(uuid)) {
			msg.arg1 = alert_category_id_bit_mask(bundle, characteristic,
					offset, nextOffset);
		} else if (GATT_CHARACTERISTIC_alert_level.equals(uuid)) {
			msg.arg1 = alert_level(bundle, characteristic, offset, nextOffset);
		} else if (GATT_CHARACTERISTIC_alert_notification_control_point
				.equals(uuid)) {
			msg.arg1 = alert_notification_control_point(bundle, characteristic,
					offset, nextOffset);
		} else if (GATT_CHARACTERISTIC_alert_status.equals(uuid)) {
			msg.arg1 = alert_status(bundle, characteristic, offset, nextOffset);
		} else if (GATT_CHARACTERISTIC_analog_input.equals(uuid)) {
			msg.arg1 = analog_input(bundle, characteristic, offset, nextOffset);
		} else if (GATT_CHARACTERISTIC_analog_output.equals(uuid)) {
			msg.arg1 = analog_output(bundle, characteristic, offset, nextOffset);
		} else if (GATT_CHARACTERISTIC_battery_level.equals(uuid)) {
			msg.arg1 = battery_level(bundle, characteristic, offset, nextOffset);
		} else if (GATT_CHARACTERISTIC_battery_level_state.equals(uuid)) {
			msg.arg1 = battery_level_state(bundle, characteristic, offset,
					nextOffset);
		} else if (GATT_CHARACTERISTIC_battery_power_state.equals(uuid)) {
			msg.arg1 = battery_power_state(bundle, characteristic, offset,
					nextOffset);
		} else if (GATT_CHARACTERISTIC_blood_pressure_feature.equals(uuid)) {
			msg.arg1 = blood_pressure_feature(bundle, characteristic, offset,
					nextOffset);
		} else if (GATT_CHARACTERISTIC_blood_pressure_measurement.equals(uuid)) {
			msg.arg1 = blood_pressure_measurement(bundle, characteristic,
					offset, nextOffset);
		} else if (GATT_CHARACTERISTIC_body_sensor_location.equals(uuid)) {
			msg.arg1 = body_sensor_location(bundle, characteristic, offset,
					nextOffset);
		} else if (GATT_CHARACTERISTIC_boot_keyboard_input_report.equals(uuid)) {
			msg.arg1 = boot_keyboard_input_report(bundle, characteristic,
					offset, nextOffset);
		} else if (GATT_CHARACTERISTIC_boot_keyboard_output_report.equals(uuid)) {
			msg.arg1 = boot_keyboard_output_report(bundle, characteristic,
					offset, nextOffset);
		} else if (GATT_CHARACTERISTIC_boot_mouse_input_report.equals(uuid)) {
			msg.arg1 = boot_mouse_input_report(bundle, characteristic, offset,
					nextOffset);
		} else if (GATT_CHARACTERISTIC_csc_feature.equals(uuid)) {
			msg.arg1 = csc_feature(bundle, characteristic, offset, nextOffset);
		} else if (GATT_CHARACTERISTIC_csc_measurement.equals(uuid)) {
			msg.arg1 = csc_measurement(bundle, characteristic, offset,
					nextOffset);
		} else if (GATT_CHARACTERISTIC_current_time.equals(uuid)) {
			msg.arg1 = current_time(bundle, characteristic, offset, nextOffset);
		} else if (GATT_CHARACTERISTIC_cycling_power_control_point.equals(uuid)) {
			msg.arg1 = cycling_power_control_point(bundle, characteristic,
					offset, nextOffset);
		} else if (GATT_CHARACTERISTIC_cycling_power_feature.equals(uuid)) {
			msg.arg1 = cycling_power_feature(bundle, characteristic, offset,
					nextOffset);
		} else if (GATT_CHARACTERISTIC_cycling_power_vector.equals(uuid)) {
			msg.arg1 = cycling_power_vector(bundle, characteristic, offset,
					nextOffset);
		} else if (GATT_CHARACTERISTIC_date_time.equals(uuid)) {
			msg.arg1 = date_time(bundle, characteristic, offset, nextOffset);
		} else if (GATT_CHARACTERISTIC_day_date_time.equals(uuid)) {
			msg.arg1 = day_date_time(bundle, characteristic, offset, nextOffset);
		} else if (GATT_CHARACTERISTIC_day_of_week.equals(uuid)) {
			msg.arg1 = day_of_week(bundle, characteristic, offset, nextOffset);
		} else if (GATT_CHARACTERISTIC_digital_input.equals(uuid)) {
			msg.arg1 = digital_input(bundle, characteristic, offset, nextOffset);
		} else if (GATT_CHARACTERISTIC_digital_output.equals(uuid)) {
			msg.arg1 = digital_output(bundle, characteristic, offset,
					nextOffset);
		} else if (GATT_CHARACTERISTIC_dst_offset.equals(uuid)) {
			msg.arg1 = dst_offset(bundle, characteristic, offset, nextOffset);
		} else if (GATT_CHARACTERISTIC_exact_time_100.equals(uuid)) {
			msg.arg1 = exact_time_100(bundle, characteristic, offset,
					nextOffset);
		} else if (GATT_CHARACTERISTIC_exact_time_256.equals(uuid)) {
			msg.arg1 = exact_time_256(bundle, characteristic, offset,
					nextOffset);
		} else if (GATT_CHARACTERISTIC_firmware_revision_string.equals(uuid)) {
			msg.arg1 = firmware_revision_string(bundle, characteristic, offset,
					nextOffset);
		} else if (GATT_CHARACTERISTIC_gap_appearance.equals(uuid)) {
			msg.arg1 = gap_appearance(bundle, characteristic, offset,
					nextOffset);
		} else if (GATT_CHARACTERISTIC_gap_device_name.equals(uuid)) {
			msg.arg1 = gap_device_name(bundle, characteristic, offset,
					nextOffset);
		} else if (GATT_CHARACTERISTIC_gap_peripheral_preferred_connection_parameters
				.equals(uuid)) {
			msg.arg1 = gap_peripheral_preferred_connection_parameters(bundle,
					characteristic, offset, nextOffset);
		} else if (GATT_CHARACTERISTIC_gap_peripheral_privacy_flag.equals(uuid)) {
			msg.arg1 = gap_peripheral_privacy_flag(bundle, characteristic,
					offset, nextOffset);
		} else if (GATT_CHARACTERISTIC_gap_reconnection_address.equals(uuid)) {
			msg.arg1 = gap_reconnection_address(bundle, characteristic, offset,
					nextOffset);
		} else if (GATT_CHARACTERISTIC_gatt_service_changed.equals(uuid)) {
			msg.arg1 = gatt_service_changed(bundle, characteristic, offset,
					nextOffset);
		} else if (GATT_CHARACTERISTIC_glucose_feature.equals(uuid)) {
			msg.arg1 = glucose_feature(bundle, characteristic, offset,
					nextOffset);
		} else if (GATT_CHARACTERISTIC_glucose_measurement.equals(uuid)) {
			msg.arg1 = glucose_measurement(bundle, characteristic, offset,
					nextOffset);
		} else if (GATT_CHARACTERISTIC_glucose_measurement_context.equals(uuid)) {
			msg.arg1 = glucose_measurement_context(bundle, characteristic,
					offset, nextOffset);
		} else if (GATT_CHARACTERISTIC_hardware_revision_string.equals(uuid)) {
			msg.arg1 = hardware_revision_string(bundle, characteristic, offset,
					nextOffset);
		} else if (GATT_CHARACTERISTIC_heart_rate_control_point.equals(uuid)) {
			msg.arg1 = heart_rate_control_point(bundle, characteristic, offset,
					nextOffset);
		} else if (GATT_CHARACTERISTIC_heart_rate_measurement.equals(uuid)) {
			msg.arg1 = heart_rate_measurement(bundle, characteristic, offset,
					nextOffset);
		} else if (GATT_CHARACTERISTIC_hid_control_point.equals(uuid)) {
			msg.arg1 = hid_control_point(bundle, characteristic, offset,
					nextOffset);
		} else if (GATT_CHARACTERISTIC_hid_information.equals(uuid)) {
			msg.arg1 = hid_information(bundle, characteristic, offset,
					nextOffset);
		} else if (GATT_CHARACTERISTIC_ieee_11073_20601_regulatory_certification_data_list
				.equals(uuid)) {
			msg.arg1 = ieee_11073_20601_regulatory_certification_data_list(
					bundle, characteristic, offset, nextOffset);
		} else if (GATT_CHARACTERISTIC_intermediate_cuff_pressure.equals(uuid)) {
			msg.arg1 = intermediate_cuff_pressure(bundle, characteristic,
					offset, nextOffset);
		} else if (GATT_CHARACTERISTIC_intermediate_temperature.equals(uuid)) {
			msg.arg1 = intermediate_temperature(bundle, characteristic, offset,
					nextOffset);
		} else if (GATT_CHARACTERISTIC_ln_control_point.equals(uuid)) {
			msg.arg1 = ln_control_point(bundle, characteristic, offset,
					nextOffset);
		} else if (GATT_CHARACTERISTIC_ln_feature.equals(uuid)) {
			msg.arg1 = ln_feature(bundle, characteristic, offset, nextOffset);
		} else if (GATT_CHARACTERISTIC_local_time_information.equals(uuid)) {
			msg.arg1 = local_time_information(bundle, characteristic, offset,
					nextOffset);
		} else if (GATT_CHARACTERISTIC_location_and_speed.equals(uuid)) {
			msg.arg1 = location_and_speed(bundle, characteristic, offset,
					nextOffset);
		} else if (GATT_CHARACTERISTIC_manufacturer_name_string.equals(uuid)) {
			msg.arg1 = manufacturer_name_string(bundle, characteristic, offset,
					nextOffset);
		} else if (GATT_CHARACTERISTIC_measurement_interval.equals(uuid)) {
			msg.arg1 = measurement_interval(bundle, characteristic, offset,
					nextOffset);
		} else if (GATT_CHARACTERISTIC_model_number_string.equals(uuid)) {
			msg.arg1 = model_number_string(bundle, characteristic, offset,
					nextOffset);
		} else if (GATT_CHARACTERISTIC_navigation.equals(uuid)) {
			msg.arg1 = navigation(bundle, characteristic, offset, nextOffset);
		} else if (GATT_CHARACTERISTIC_network_availability.equals(uuid)) {
			// not implemented
			msg.arg1 = Integer.MIN_VALUE;
		} else if (GATT_CHARACTERISTIC_new_alert.equals(uuid)) {
			msg.arg1 = new_alert(bundle, characteristic, offset, nextOffset);
		} else if (GATT_CHARACTERISTIC_pnp_id.equals(uuid)) {
			msg.arg1 = pnp_id(bundle, characteristic, offset, nextOffset);
		} else if (GATT_CHARACTERISTIC_position_quality.equals(uuid)) {
			msg.arg1 = position_quality(bundle, characteristic, offset,
					nextOffset);
		} else if (GATT_CHARACTERISTIC_protocol_mode.equals(uuid)) {
			msg.arg1 = protocol_mode(bundle, characteristic, offset, nextOffset);
		} else if (GATT_CHARACTERISTIC_pulse_oximetry_continuous_measurement
				.equals(uuid)) {
			msg.arg1 = pulse_oximetry_continuous_measurement(bundle,
					characteristic, offset, nextOffset);
		} else if (GATT_CHARACTERISTIC_pulse_oximetry_control_point
				.equals(uuid)) {
			msg.arg1 = pulse_oximetry_control_point(bundle, characteristic,
					offset, nextOffset);
		} else if (GATT_CHARACTERISTIC_pulse_oximetry_features.equals(uuid)) {
			msg.arg1 = pulse_oximetry_control_point(bundle, characteristic,
					offset, nextOffset);
		} else if (GATT_CHARACTERISTIC_pulse_oximetry_pulsatile_event
				.equals(uuid)) {
			msg.arg1 = pulse_oximetry_pulsatile_event(bundle, characteristic,
					offset, nextOffset);
		} else if (GATT_CHARACTERISTIC_pulse_oximetry_spot_check_measurement
				.equals(uuid)) {
			msg.arg1 = pulse_oximetry_pulsatile_event(bundle, characteristic,
					offset, nextOffset);
		} else if (GATT_CHARACTERISTIC_record_access_control_point.equals(uuid)) {
			msg.arg1 = record_access_control_point(bundle, characteristic,
					offset, nextOffset);
		} else if (GATT_CHARACTERISTIC_reference_time_information.equals(uuid)) {
			msg.arg1 = reference_time_information(bundle, characteristic,
					offset, nextOffset);
		} else if (GATT_CHARACTERISTIC_removable.equals(uuid)) {
			msg.arg1 = removable(bundle, characteristic, offset, nextOffset);
		} else if (GATT_CHARACTERISTIC_report.equals(uuid)) {
			msg.arg1 = report(bundle, characteristic, offset, nextOffset);
		} else if (GATT_CHARACTERISTIC_report_map.equals(uuid)) {
			msg.arg1 = report_map(bundle, characteristic, offset, nextOffset);
		} else if (GATT_CHARACTERISTIC_ringer_control_point.equals(uuid)) {
			msg.arg1 = ringer_control_point(bundle, characteristic, offset,
					nextOffset);
		} else if (GATT_CHARACTERISTIC_ringer_setting.equals(uuid)) {
			msg.arg1 = ringer_setting(bundle, characteristic, offset,
					nextOffset);
		} else if (GATT_CHARACTERISTIC_rsc_feature.equals(uuid)) {
			msg.arg1 = rsc_feature(bundle, characteristic, offset, nextOffset);
		} else if (GATT_CHARACTERISTIC_rsc_measurement.equals(uuid)) {
			msg.arg1 = rsc_measurement(bundle, characteristic, offset,
					nextOffset);
		} else if (GATT_CHARACTERISTIC_sc_control_point.equals(uuid)) {
			msg.arg1 = sc_control_point(bundle, characteristic, offset,
					nextOffset);
		} else if (GATT_CHARACTERISTIC_scan_interval_window.equals(uuid)) {
			msg.arg1 = scan_interval_window(bundle, characteristic, offset,
					nextOffset);
		} else if (GATT_CHARACTERISTIC_scan_refresh.equals(uuid)) {
			msg.arg1 = scan_refresh(bundle, characteristic, offset, nextOffset);
		} else if (GATT_CHARACTERISTIC_scientific_temperature_celsius
				.equals(uuid)) {
			msg.arg1 = scientific_temperature_celsius(bundle, characteristic,
					offset, nextOffset);
		} else if (GATT_CHARACTERISTIC_secondary_time_zone.equals(uuid)) {
			msg.arg1 = secondary_time_zone(bundle, characteristic, offset,
					nextOffset);
		} else if (GATT_CHARACTERISTIC_sensor_location.equals(uuid)) {
			msg.arg1 = sensor_location(bundle, characteristic, offset,
					nextOffset);
		} else if (GATT_CHARACTERISTIC_serial_number_string.equals(uuid)) {
			msg.arg1 = serial_number_string(bundle, characteristic, offset,
					nextOffset);
		} else if (GATT_CHARACTERISTIC_service_required.equals(uuid)) {
			msg.arg1 = service_required(bundle, characteristic, offset,
					nextOffset);
		} else if (GATT_CHARACTERISTIC_software_revision_string.equals(uuid)) {
			msg.arg1 = software_revision_string(bundle, characteristic, offset,
					nextOffset);
		} else if (GATT_CHARACTERISTIC_string.equals(uuid)) {
			msg.arg1 = string(bundle, characteristic, offset, nextOffset);
		} else if (GATT_CHARACTERISTIC_supported_new_alert_category
				.equals(uuid)) {
			msg.arg1 = supported_new_alert_category(bundle, characteristic,
					offset, nextOffset);
		} else if (GATT_CHARACTERISTIC_supported_unread_alert_category
				.equals(uuid)) {
			msg.arg1 = supported_unread_alert_category(bundle, characteristic,
					offset, nextOffset);
		} else if (GATT_CHARACTERISTIC_system_id.equals(uuid)) {
			msg.arg1 = system_id(bundle, characteristic, offset, nextOffset);
		} else if (GATT_CHARACTERISTIC_temperature_celsius.equals(uuid)) {
			msg.arg1 = temperature_celsius(bundle, characteristic, offset,
					nextOffset);
		} else if (GATT_CHARACTERISTIC_temperature_fahrenheit.equals(uuid)) {
			msg.arg1 = temperature_fahrenheit(bundle, characteristic, offset,
					nextOffset);
		} else if (GATT_CHARACTERISTIC_temperature_measurement.equals(uuid)) {
			msg.arg1 = temperature_measurement(bundle, characteristic, offset,
					nextOffset);
		} else if (GATT_CHARACTERISTIC_temperature_type.equals(uuid)) {
			msg.arg1 = temperature_type(bundle, characteristic, offset,
					nextOffset);
		} else if (GATT_CHARACTERISTIC_time_accuracy.equals(uuid)) {
			msg.arg1 = time_accuracy(bundle, characteristic, offset, nextOffset);
		} else if (GATT_CHARACTERISTIC_time_broadcast.equals(uuid)) {
			msg.arg1 = time_broadcast(bundle, characteristic, offset,
					nextOffset);
		} else if (GATT_CHARACTERISTIC_time_source.equals(uuid)) {
			msg.arg1 = time_source(bundle, characteristic, offset, nextOffset);
		} else if (GATT_CHARACTERISTIC_time_update_control_point.equals(uuid)) {
			msg.arg1 = time_update_control_point(bundle, characteristic,
					offset, nextOffset);
		} else if (GATT_CHARACTERISTIC_time_update_state.equals(uuid)) {
			msg.arg1 = time_update_control_point(bundle, characteristic,
					offset, nextOffset);
		} else if (GATT_CHARACTERISTIC_time_with_dst.equals(uuid)) {
			msg.arg1 = time_with_dst(bundle, characteristic, offset, nextOffset);
		} else if (GATT_CHARACTERISTIC_time_zone.equals(uuid)) {
			msg.arg1 = time_zone(bundle, characteristic, offset, nextOffset);
		} else if (GATT_CHARACTERISTIC_tx_power_level.equals(uuid)) {
			msg.arg1 = tx_power_level(bundle, characteristic, offset,
					nextOffset);
		} else if (GATT_CHARACTERISTIC_unread_alert_status.equals(uuid)) {
			msg.arg1 = unread_alert_status(bundle, characteristic, offset,
					nextOffset);

			// -------------------BLUEGIGA EXAMPLES
		} else if (GATT_CHARACTERISTIC_bluegiga_manufacturer_name.equals(uuid)) {
			msg.arg1 = bluegiga_manufacturer_name(bundle, characteristic,
					offset, nextOffset);
		} else if (GATT_CHARACTERISTIC_bluegiga_manufacturer_id.equals(uuid)) {
			msg.arg1 = bluegiga_manufacturer_id(bundle, characteristic, offset,
					nextOffset);
		} else if (GATT_CHARACTERISTIC_bluegiga_model_number.equals(uuid)) {
			msg.arg1 = bluegiga_model_number(bundle, characteristic, offset,
					nextOffset);
		} else if (GATT_CHARACTERISTIC_bluegiga_xgatt_battery.equals(uuid)) {
			msg.arg1 = bluegiga_xgatt_battery(bundle, characteristic, offset,
					nextOffset);
		} else if (GATT_CHARACTERISTIC_bluegiga_accelerometer_x_data
				.equals(uuid)) {
			msg.arg1 = bluegiga_accelerometer_x_data(bundle, characteristic,
					offset, nextOffset);
		} else if (GATT_CHARACTERISTIC_bluegiga_accelerometer_y_data
				.equals(uuid)) {
			msg.arg1 = bluegiga_accelerometer_y_data(bundle, characteristic,
					offset, nextOffset);
		} else if (GATT_CHARACTERISTIC_bluegiga_accelerometer_z_data
				.equals(uuid)) {
			msg.arg1 = bluegiga_accelerometer_z_data(bundle, characteristic,
					offset, nextOffset);

			// ASICA
		} else if (GATT_CHARACTERISTIC_asica_heart_rate.equals(uuid)) {
			msg.arg1 = asica_heart_rate(bundle, characteristic, offset,
					nextOffset);
			msg.arg2 |= 1;
		} else if (GATT_CHARACTERISTIC_asica_fall_detection_alert.equals(uuid)) {
			msg.arg1 = asica_fall_detection_alert(bundle, characteristic,
					offset, nextOffset);
			msg.arg2 |= 1;
		} else if (GATT_CHARACTERISTIC_asica_AT_state.equals(uuid)) {
			msg.arg1 = asica_ambulatory_terminal_state(bundle, characteristic,
					offset, nextOffset);
			msg.arg2 |= 1;
		} else if (GATT_CHARACTERISTIC_asica_fall_detection_activity
				.equals(uuid)) {
			msg.arg1 = asica_ambulatory_terminal_activity(bundle,
					characteristic, offset, nextOffset);
			msg.arg2 |= 1;
		} else if (GATT_CHARACTERISTIC_asica_fall_detection_hour_reset_request
				.equals(uuid)) {
			// not implemented
			// phone does the updates when it connects to the device
			msg.arg2 |= 1;

		} else {
			msg.arg1 = Integer.MIN_VALUE;
		}

	}

	public static void onHandleMessage(Message msg,
			IBluetoothGattCharacteristicHandler object) {
		Bundle bundle = msg.getData();
		int type = msg.arg2 & 1;
		switch (type) {
		case 0:

			switch (msg.arg1) {
			case MSG_aggregate_input:
				handle_aggregate_input(bundle, object);
				break;
			case MSG_alert_category_id:
				handle_alert_category_id(bundle, object);
				break;
			case MSG_alert_category_id_bit_mask:
				handle_alert_category_id_bit_mask(bundle, object);
				break;
			case MSG_alert_level:
				handle_alert_level(bundle, object);
				break;
			case MSG_alert_notification_control_point:
				handle_alert_notification_control_point(bundle, object);
				break;
			case MSG_alert_status:
				handle_alert_status(bundle, object);
				break;
			case MSG_analog_input:
				handle_analog_input(bundle, object);
				break;
			case MSG_analog_output:
				handle_analog_output(bundle, object);
				break;
			case MSG_battery_level:
				handle_battery_level(bundle, object);
				break;
			case MSG_battery_level_state:
				handle_battery_level_state(bundle, object);
				break;
			case MSG_battery_power_state:
				handle_battery_power_state(bundle, object);
				break;
			case MSG_blood_pressure_feature:
				handle_blood_pressure_feature(bundle, object);
				break;
			case MSG_blood_pressure_measurement:
				handle_blood_pressure_measurement(bundle, object);
				break;
			case MSG_body_sensor_location:
				handle_body_sensor_location(bundle, object);
				break;
			case MSG_boot_keyboard_input_report:
				handle_boot_keyboard_input_report(bundle, object);
				break;
			case MSG_boot_keyboard_output_report:
				handle_boot_keyboard_output_report(bundle, object);
				break;
			case MSG_boot_mouse_input_report:
				handle_boot_mouse_input_report(bundle, object);
				break;
			case MSG_csc_feature:
				handle_csc_feature(bundle, object);
				break;
			case MSG_csc_measurement:
				handle_csc_measurement(bundle, object);
				break;
			case MSG_current_time:
				handle_current_time(bundle, object);
				break;
			case MSG_cycling_power_control_point:
				handle_cycling_power_control_point(bundle, object);
				break;
			case MSG_cycling_power_feature:
				handle_cycling_power_feature(bundle, object);
				break;
			case MSG_cycling_power_vector:
				handle_cycling_power_vector(bundle, object);
				break;
			case MSG_date_time:
				handle_date_time(bundle, object);
				break;
			case MSG_day_date_time:
				handle_day_date_time(bundle, object);
				break;
			case MSG_day_of_week:
				handle_day_of_week(bundle, object);
				break;
			case MSG_digital_input:
				handle_digital_input(bundle, object);
				break;
			case MSG_digital_output:
				handle_digital_output(bundle, object);
				break;
			case MSG_dst_offset:
				handle_dst_offset(bundle, object);
				break;
			case MSG_exact_time_100:
				handle_exact_time_100(bundle, object);
				break;
			case MSG_exact_time_256:
				handle_exact_time_256(bundle, object);
				break;
			case MSG_firmware_revision_string:
				handle_firmware_revision_string(bundle, object);
				break;
			case MSG_gap_appearance:
				handle_gap_appearance(bundle, object);
				break;
			case MSG_gap_device_name:
				handle_gap_device_name(bundle, object);
				break;
			case MSG_gap_peripheral_preferred_connection_parameters:
				handle_gap_peripheral_preferred_connection_parameters(bundle,
						object);
				break;
			case MSG_gap_peripheral_privacy_flag:
				handle_gap_peripheral_privacy_flag(bundle, object);
				break;
			case MSG_gap_reconnection_address:
				handle_gap_reconnection_address(bundle, object);
				break;
			case MSG_gatt_service_changed:
				handle_gatt_service_changed(bundle, object);
				break;
			case MSG_glucose_feature:
				handle_glucose_feature(bundle, object);
				break;
			case MSG_glucose_measurement:
				handle_glucose_measurement(bundle, object);
				break;
			case MSG_glucose_measurement_context:
				handle_glucose_measurement_context(bundle, object);
				break;
			case MSG_hardware_revision_string:
				handle_hardware_revision_string(bundle, object);
				break;
			case MSG_heart_rate_control_point:
				handle_heart_rate_control_point(bundle, object);
				break;
			case MSG_heart_rate_measurement:
				handle_heart_rate_measurement(bundle, object);
				break;
			case MSG_hid_control_point:
				handle_hid_control_point(bundle, object);
				break;
			case MSG_hid_information:
				handle_hid_information(bundle, object);
				break;
			case MSG_ieee_11073_20601_regulatory_certification_data_list:
				handle_ieee_11073_20601_regulatory_certification_data_list(
						bundle, object);
				break;
			case MSG_intermediate_cuff_pressure:
				handle_intermediate_cuff_pressure(bundle, object);
				break;
			case MSG_intermediate_temperature:
				handle_intermediate_temperature(bundle, object);
				break;
			case MSG_ln_control_point:
				handle_ln_control_point(bundle, object);
				break;
			case MSG_ln_feature:
				handle_ln_feature(bundle, object);
				break;
			case MSG_local_time_information:
				handle_local_time_information(bundle, object);
				break;
			case MSG_location_and_speed:
				handle_location_and_speed(bundle, object);
				break;
			case MSG_manufacturer_name_string:
				handle_manufacturer_name_string(bundle, object);
				break;
			case MSG_measurement_interval:
				handle_measurement_interval(bundle, object);
				break;
			case MSG_model_number_string:
				handle_model_number_string(bundle, object);
				break;
			case MSG_navigation:
				handle_navigation(bundle, object);
				break;
			case MSG_network_availability:
				// not implemented

				handle_default(bundle, object);
				break;
			case MSG_new_alert:
				handle_new_alert(bundle, object);
				break;
			case MSG_pnp_id:
				handle_pnp_id(bundle, object);
				break;
			case MSG_position_quality:
				handle_position_quality(bundle, object);
				break;
			case MSG_protocol_mode:
				handle_protocol_mode(bundle, object);
				break;
			case MSG_pulse_oximetry_continuous_measurement:
				handle_pulse_oximetry_continuous_measurement(bundle, object);
				break;
			case MSG_pulse_oximetry_control_point:
				handle_pulse_oximetry_control_point(bundle, object);
				break;
			case MSG_pulse_oximetry_features:
				handle_pulse_oximetry_features(bundle, object);
				break;
			case MSG_pulse_oximetry_pulsatile_event:
				handle_pulse_oximetry_pulsatile_event(bundle, object);
				break;
			case MSG_pulse_oximetry_spot_check_measurement:
				handle_pulse_oximetry_spot_check_measurement(bundle, object);
				break;
			case MSG_record_access_control_point:
				handle_record_access_control_point(bundle, object);
				break;
			case MSG_reference_time_information:
				handle_reference_time_information(bundle, object);
				break;
			case MSG_removable:
				handle_removable(bundle, object);
				break;
			case MSG_report:
				handle_report(bundle, object);
				break;
			case MSG_report_map:
				handle_report_map(bundle, object);
				break;
			case MSG_ringer_control_point:
				handle_ringer_control_point(bundle, object);
				break;
			case MSG_ringer_setting:
				handle_ringer_setting(bundle, object);
				break;
			case MSG_rsc_feature:
				handle_rsc_feature(bundle, object);
				break;
			case MSG_rsc_measurement:
				handle_rsc_measurement(bundle, object);
				break;
			case MSG_sc_control_point:
				handle_sc_control_point(bundle, object);
				break;
			case MSG_scan_interval_window:
				handle_scan_interval_window(bundle, object);
				break;
			case MSG_scan_refresh:
				handle_scan_refresh(bundle, object);
				break;
			case MSG_scientific_temperature_celsius:
				handle_scientific_temperature_celsius(bundle, object);
				break;
			case MSG_secondary_time_zone:
				handle_secondary_time_zone(bundle, object);
				break;
			case MSG_sensor_location:
				handle_sensor_location(bundle, object);
				break;
			case MSG_serial_number_string:
				handle_serial_number_string(bundle, object);
				break;
			case MSG_service_required:
				handle_service_required(bundle, object);
				break;
			case MSG_software_revision_string:
				handle_software_revision_string(bundle, object);
				break;
			case MSG_string:
				handle_string(bundle, object);
				break;
			case MSG_supported_new_alert_category:
				handle_supported_new_alert_category(bundle, object);
				break;
			case MSG_supported_unread_alert_category:
				handle_supported_unread_alert_category(bundle, object);
				break;
			case MSG_system_id:
				handle_system_id(bundle, object);
				break;
			case MSG_temperature_celsius:
				handle_temperature_celsius(bundle, object);
				break;
			case MSG_temperature_fahrenheit:
				handle_temperature_fahrenheit(bundle, object);
				break;
			case MSG_temperature_measurement:
				handle_temperature_measurement(bundle, object);
				break;
			case MSG_temperature_type:
				handle_temperature_type(bundle, object);
				break;
			case MSG_time_accuracy:
				handle_time_accuracy(bundle, object);
				break;
			case MSG_time_broadcast:
				handle_time_broadcast(bundle, object);
				break;
			case MSG_time_source:
				handle_time_source(bundle, object);
				break;
			case MSG_time_update_control_point:
				handle_time_update_control_point(bundle, object);
				break;
			case MSG_time_update_state:
				handle_time_update_state(bundle, object);
				break;
			case MSG_time_with_dst:
				handle_time_with_dst(bundle, object);
				break;
			case MSG_time_zone:
				handle_time_zone(bundle, object);
				break;
			case MSG_tx_power_level:
				handle_tx_power_level(bundle, object);
				break;
			case MSG_unread_alert_status:
				handle_unread_alert_status(bundle, object);
				break;

			// ---BLUEGIGA EXAMPLES
			case MSG_bluegiga_manufacturer_name:
				handle_bluegiga_manufacturer_name(bundle, object);
				break;
			case MSG_bluegiga_manufacturer_id:
				handle_bluegiga_manufacturer_id(bundle, object);
				break;
			case MSG_bluegiga_model_number:
				handle_bluegiga_model_number(bundle, object);
				break;
			case MSG_bluegiga_xgatt_battery:
				handle_bluegiga_xgatt_battery(bundle, object);
				break;
			case MSG_bluegiga_accelerometer_x_data:
				handle_bluegiga_accelerometer_x_data(bundle, object);
				break;
			case MSG_bluegiga_accelerometer_y_data:
				handle_bluegiga_accelerometer_y_data(bundle, object);
				break;
			case MSG_bluegiga_accelerometer_z_data:
				handle_bluegiga_accelerometer_z_data(bundle, object);
				break;

			default:
				handle_default(bundle, object);

			}
			break;
		case 1:
			switch (msg.arg1) {
			// ASICA
			case MSG_asica_heart_rate:
				handle_asica_heart_rate(bundle, object);
				break;
			case MSG_asica_fall_detection_alert:
				handle_asica_fall_detection_alert(bundle, object);
				break;
			case MSG_asica_ambulatory_terminal_state:
				handle_asica_ambulatory_terminal_state(bundle, object);
				break;
			case MSG_asica_fall_detection_activity:
				handle_asica_ambulatory_terminal_activity(bundle, object);
				break;
			case MSG_asica_fall_detection_hour_reset_request:
				// Not implemented
				break;
			default:
				handle_default(bundle, object);
			}
			break;
		default:
			handle_default(bundle, object);

		}
	}

	/**
	 * the default method that gets proprietary characteristics
	 * 
	 * @param bundle
	 * @param object
	 */
	protected static void handle_default(Bundle bundle,
			IBluetoothGattCharacteristicHandler object) {
		String uuid = bundle.getString(BluetoothDevice.EXTRA_UUID);
		object.on_default(bundle, uuid);
	}

	/**
	 * The Aggregate Input is an aggregate of the Digital Input Characteristic
	 * value (if available) and ALL Analog Inputs available.
	 * 
	 * put extra values into bundle: EXTRA_VALUE0 Input Bits format int / uint8
	 * EXTRA_VALUE1 Analog Input format int / uint16 Note : The fields in the
	 * above table, reading from top to bottom, are shown in the order of LSO to
	 * MSO, where LSO = Least Significant Octet and MSO = Most Significant
	 * Octet.
	 * 
	 * Caveat from the developer: this is not clear for me : I used :
	 * getIntValue(BluetoothGattCharacteristic.FORMAT_UINT8, offset) for Input
	 * Bits and getIntValue(BluetoothGattCharacteristic.FORMAT_UINT16, offset)
	 * for Analog Input so it may not work correctly or you may have to take the
	 * note into account when using Analog Input
	 * 
	 * @param bundle
	 * @param characteristic
	 * @return response id to put in message.what
	 */
	protected static int aggregate_input(Bundle bundle,
			BluetoothGattCharacteristic characteristic, int offset,
			int[] nextOffset) {
		// byte[] characteristicValue = characteristic.getValue();

		int inputBits;
		int analogInput;
		inputBits = characteristic.getIntValue(
				BluetoothGattCharacteristic.FORMAT_UINT8, offset);
		offset += UINT8_SIZE;
		analogInput = characteristic.getIntValue(
				BluetoothGattCharacteristic.FORMAT_UINT16, offset);
		offset += UINT16_SIZE;

		bundle.putInt(EXTRA_VALUE0, inputBits);
		bundle.putInt(EXTRA_VALUE1, analogInput);
		bundle.putInt(NUMBER_OF_EXTRA_ARGS, 2);
		bundle.putString(EXTRA_VALUE0_NAME, "Input Bits");
		bundle.putString(EXTRA_VALUE1_NAME, "Analog Input");
		bundle.putString(EXTRA_VALUE0_FORMAT, EXTRA_VALUE_int);
		bundle.putString(EXTRA_VALUE1_FORMAT, EXTRA_VALUE_int);

		nextOffset[0] = offset;
		return MSG_aggregate_input;
	}

	/**
	 * calls object.on_aggregate_input(Bundle bundle, int inputBits, int
	 * analogInput)
	 * 
	 * @param bundle
	 * @param object
	 *            an implementation of IBluetoothGattCharacteristicHandler
	 *            Caution : if your handler is static you must access this
	 *            object from a static variable
	 * @throws IllegalArgumentException
	 *             if the uuid provided by the bundle doesn't correspond
	 */
	protected static void handle_aggregate_input(Bundle bundle,
			IBluetoothGattCharacteristicHandler object)
			throws IllegalArgumentException {
		String sUUID = bundle.getString(BluetoothDevice.EXTRA_UUID);
		UUID aUUID = UUID.fromString(sUUID);
		if (!GATT_CHARACTERISTIC_aggregate_input.equals(aUUID)) {
			throw new IllegalArgumentException(
					"The provided uuid is uncompatible with this method");
		}
		int inputBits = bundle.getInt(EXTRA_VALUE0);
		int analogInput = bundle.getInt(EXTRA_VALUE1);

		object.on_aggregate_input(bundle, inputBits, analogInput);
	}

	/**
	 * Categories of alerts/messages. The value of the characteristic is an
	 * unsigned 8 bit integer that has a fixed point exponent of 0. The Alert
	 * Category ID characteristic defines the predefined categories of messages
	 * as an enumeration. put extra values into bundle: EXTRA_VALUE0 Category ID
	 * format int / uint8 EXTRA_VALUE1 description text as it appears in the
	 * spec format String
	 * 
	 * 
	 * 0 Simple Alert: General text alert or non-text alert" 1 Email: Alert when
	 * Email messages arrives 2 News: News feeds such as RSS, Atom 3 Call:
	 * Incoming call 4 Missed call: Missed Call 5 SMS/MMS: SMS/MMS message
	 * arrives 6 Voice mail: Voice mail 7 Schedule: Alert occurred on calendar,
	 * planner 8 High Prioritized Alert: Alert that should be handled as high
	 * priority 9 Instant Message: Alert for incoming instant messages
	 * 
	 * ReservedForFutureUse end 250 start = 10 DefinedByServiceSpecification
	 * end= 255 start=251
	 * 
	 * @param bundle
	 * @param characteristic
	 * @return response id to put in message.what
	 */
	protected static int alert_category_id(Bundle bundle,
			BluetoothGattCharacteristic characteristic, int offset,
			int[] nextOffset) {
		// byte[] characteristicValue = characteristic.getValue();

		int categoryID = characteristic.getIntValue(
				BluetoothGattCharacteristic.FORMAT_UINT8, offset);
		offset += UINT8_SIZE;
		String comment = alert_category_id_comments(categoryID);

		bundle.putInt(EXTRA_VALUE0, categoryID);
		bundle.putString(EXTRA_VALUE1, comment);
		bundle.putString(EXTRA_VALUE0_NAME, "Category ID");
		bundle.putString(EXTRA_VALUE1_NAME, "comment");
		bundle.putString(EXTRA_VALUE0_FORMAT, EXTRA_VALUE_int);
		bundle.putString(EXTRA_VALUE1_NAME, EXTRA_VALUE_String);

		nextOffset[0] = offset;
		return MSG_alert_category_id;
	}

	private static String alert_category_id_comments(int categoryID) {
		String comment = "Reserved fo future use";
		switch (categoryID) {
		case 0:
			comment = "Simple Alert: General text alert or non-text alert";
			break;
		case 1:
			comment = "Email: Alert when Email messages arrives";
			break;
		case 2:
			comment = "News: News feeds such as RSS, Atom";
			break;
		case 3:
			comment = "Call: Incoming call";
			break;
		case 4:
			comment = "Missed call: Missed Call";
			break;
		case 5:
			comment = "SMS/MMS: SMS/MMS message arrives";
			break;
		case 6:
			comment = "Voice mail: Voice mail";
			break;
		case 7:
			comment = "Schedule: Alert occurred on calendar, planner";
			break;
		case 8:
			comment = "High Prioritized Alert: Alert that should be handled as high priority";
			break;
		case 9:
			comment = "Instant Message: Alert for incoming instant messages";
			break;
		}

		return comment;
	}

	/**
	 * calls object.on_alert_category_id(Bundle bundle, int categoryID,String
	 * comment)
	 * 
	 * @param bundle
	 * @param object
	 *            an implementation of IBluetoothGattCharacteristicHandler
	 *            Caution : if your handler is static you must access this
	 *            object from a static variable
	 * @throws IllegalArgumentException
	 *             if the uuid provided by the bundle doesn't correspond
	 */
	protected static void handle_alert_category_id(Bundle bundle,
			IBluetoothGattCharacteristicHandler object)
			throws IllegalArgumentException {
		String sUUID = bundle.getString(BluetoothDevice.EXTRA_UUID);
		UUID aUUID = UUID.fromString(sUUID);
		if (!GATT_CHARACTERISTIC_alert_category_id.equals(aUUID)) {
			throw new IllegalArgumentException(
					"The provided uuid is uncompatible with this method");
		}
		int categoryId = bundle.getInt(EXTRA_VALUE0);
		String comment = bundle.getString(EXTRA_VALUE1);
		object.on_alert_category_id(bundle, categoryId, comment);
	}

	/**
	 * Categories of alerts/messages. The value of the characteristic is a bit
	 * mask implemented as an array of unsigned 8 bit integers. The Alert
	 * Category ID Bit Mask characteristic defines one bit for each predefined
	 * category ID. The value 0x03 is interpreted as “Simple Alert and Email
	 * bits set”
	 * 
	 * first byte bits : name="Simple Alert" index="0" key="0" "Not Supported"
	 * key="1" "Supported" name="Email" index="1" key="0" "Not Supported"
	 * key="1" "Supported" name="News" index="2" key="0" "Not Supported" key="1"
	 * "Supported" name="Call" index="3" key="0" "Not Supported" key="1"
	 * "Supported" name="Missed Call" index="4" key="0" "Not Supported" key="1"
	 * "Supported" name="SMS/MMS" index="5" key="0" "Not Supported" key="1"
	 * "Supported" name="Voice Mail" index="6" key="0" "Not Supported" key="1"
	 * "Supported" name="Schedule" index="7" key="0" "Not Supported" key="1"
	 * "Supported"
	 * 
	 * second byte bits name="High Prioritized Alert" index="0" key="0"
	 * "Not Supported" key="1" "Supported" name="Instant Message" index="1"
	 * key="0" "Not Supported" key="1" "Supported"
	 * 
	 * 
	 * 
	 * If second octet is not present it is interpreted as all 0’es
	 * 
	 * The fields in the above table are in the order of LSO to MSO. Where LSO =
	 * Least Significant Octet and MSO = Most Significant Octet.
	 * 
	 * 
	 * 
	 * put extra values into bundle: EXTRA_VALUE0 Category ID Bit Mask 0 format
	 * int / uint8 EXTRA_VALUE1 Category ID Bit Mask 1 format int / uint8
	 * 
	 * @param bundle
	 * @param characteristic
	 * @return response id to put in message.what
	 */
	protected static int alert_category_id_bit_mask(Bundle bundle,
			BluetoothGattCharacteristic characteristic, int offset,
			int[] nextOffset) {
		byte[] characteristicValue = characteristic.getValue();

		int categoryIDBitMask0 = 0;
		int categoryIDBitMask1 = 0;

		categoryIDBitMask0 = characteristic.getIntValue(
				BluetoothGattCharacteristic.FORMAT_UINT8, offset);
		offset += UINT8_SIZE;
		if (characteristicValue.length >= 1) {
			categoryIDBitMask0 = characteristic.getIntValue(
					BluetoothGattCharacteristic.FORMAT_UINT8, offset);
			offset += UINT8_SIZE;
		}

		bundle.putInt(EXTRA_VALUE0, categoryIDBitMask0);
		bundle.putInt(EXTRA_VALUE1, categoryIDBitMask1);
		bundle.putString(EXTRA_VALUE0_NAME, "Category ID Bit Mask 0");
		bundle.putString(EXTRA_VALUE1_NAME, "Category ID Bit Mask 1");
		bundle.putString(EXTRA_VALUE0_FORMAT, EXTRA_VALUE_int);
		bundle.putString(EXTRA_VALUE1_NAME, EXTRA_VALUE_int);

		nextOffset[0] = offset;
		return MSG_alert_category_id_bit_mask;
	}

	/**
	 * calls object.on_alert_category_id_bit_mask(Bundle bundle,int
	 * categoryIDBitMask0,int categoryIDBitMask1);
	 * 
	 * @param bundle
	 * @param object
	 *            an implementation of IBluetoothGattCharacteristicHandler
	 *            Caution : if your handler is static you must access this
	 *            object from a static variable
	 * @throws IllegalArgumentException
	 *             if the uuid provided by the bundle doesn't correspond
	 */
	protected static void handle_alert_category_id_bit_mask(Bundle bundle,
			IBluetoothGattCharacteristicHandler object)
			throws IllegalArgumentException {
		String sUUID = bundle.getString(BluetoothDevice.EXTRA_UUID);
		UUID aUUID = UUID.fromString(sUUID);
		if (!GATT_CHARACTERISTIC_alert_category_id_bit_mask.equals(aUUID)) {
			throw new IllegalArgumentException(
					"The provided uuid is uncompatible with this method");
		}

		int categoryIDBitMask0 = bundle.getInt(EXTRA_VALUE0);
		int categoryIDBitMask1 = bundle.getInt(EXTRA_VALUE1);

		object.on_alert_category_id_bit_mask(bundle, categoryIDBitMask0,
				categoryIDBitMask1);
	}

	/**
	 * The level of an alert a device is to sound. If this level is changed
	 * while the alert is being sounded, the new level should take effect.
	 * 
	 * The value of the characteristic shall be an unsigned 8 bit integer that
	 * has a fixed point exponent of 0. The Alert Level characteristic defines
	 * the level of alert, and is one of the following three values:
	 * 
	 * Value 0, meaning “No Alert” Value 1, meaning “Mild Alert” Value 2,
	 * meaning “High Alert” example the value 0x01 is interpreted as “Mild
	 * Alert” minimum 0 maximum 2 Reserved end="255" start="3"
	 * 
	 * put extra values into bundle: EXTRA_VALUE0 alertLevel format int / uint8
	 * 
	 * @param bundle
	 * @param characteristic
	 * @return response id to put in message.what
	 */
	protected static int alert_level(Bundle bundle,
			BluetoothGattCharacteristic characteristic, int offset,
			int[] nextOffset) {
		// byte[] characteristicValue = characteristic.getValue();

		int alertLevel = 0;
		alertLevel = characteristic.getIntValue(
				BluetoothGattCharacteristic.FORMAT_UINT8, offset);
		offset += UINT8_SIZE;

		bundle.putInt(EXTRA_VALUE0, alertLevel);
		bundle.putString(EXTRA_VALUE0_NAME, "Alert Level");
		bundle.putString(EXTRA_VALUE0_FORMAT, EXTRA_VALUE_int);

		nextOffset[0] = offset;
		return MSG_alert_level;
	}

	/**
	 * calls object.on_alert_level(Bundle bundle, int alertLevel)
	 * 
	 * @param bundle
	 * @param object
	 *            an implementation of IBluetoothGattCharacteristicHandler
	 *            Caution : if your handler is static you must access this
	 *            object from a static variable
	 * @throws IllegalArgumentException
	 *             if the uuid provided by the bundle doesn't correspond
	 */
	protected static void handle_alert_level(Bundle bundle,
			IBluetoothGattCharacteristicHandler object)
			throws IllegalArgumentException {
		String sUUID = bundle.getString(BluetoothDevice.EXTRA_UUID);
		UUID aUUID = UUID.fromString(sUUID);
		if (!GATT_CHARACTERISTIC_alert_level.equals(aUUID)) {
			throw new IllegalArgumentException(
					"The provided uuid is uncompatible with this method");
		}

		int alertLevel = bundle.getInt(EXTRA_VALUE0);

		object.on_alert_level(bundle, alertLevel);
	}

	/**
	 * Control point of the Alert Notification server. Client can write the
	 * command here to request the several functions toward the server.
	 * 
	 * The 1st octet value of the characteristic is an unsigned 8 bit integer
	 * that has a fixed point exponent of 0. The 1st octet value expresses the
	 * command ID that defines the server’s actions. The 2nd octet value of the
	 * characteristic is an “Alert Category ID” format. This octet shows the
	 * target category that the command ID applies for.
	 * 
	 * Example : The data 0x02 0x01 interprets “Disable New Incoming
	 * Notification for Email Category”.
	 * 
	 * key=0 Enable New Incoming Alert Notification key=1 "Enable Unread
	 * Category Status Notification key=2 "Disable New Incoming Alert
	 * Notification key=3 "Disable Unread Category Status Notification key=4
	 * "Notify New Incoming Alert immediately" key=5 "Notify Unread Category
	 * Status immediately ReservedForFutureUse end="255" start="6"
	 * 
	 * put extra values into bundle: EXTRA_VALUE0 Command ID format int / uint8
	 * EXTRA_VALUE0 Command ID format int / uint8 uint8 EXTRA_VALUE1 Category ID
	 * format int / uint8 String EXTRA_VALUE2 Command ID comment format String
	 * String EXTRA_VALUE3 Category ID comment format String
	 * 
	 * @param bundle
	 * @param characteristic
	 * @return response id to put in message.what
	 */
	protected static int alert_notification_control_point(Bundle bundle,
			BluetoothGattCharacteristic characteristic, int offset,
			int[] nextOffset) {
		// byte[] characteristicValue = characteristic.getValue();

		int commandID = characteristic.getIntValue(
				BluetoothGattCharacteristic.FORMAT_UINT8, offset);
		offset += UINT8_SIZE;
		// caution this is a guess
		int categoryID = characteristic.getIntValue(
				BluetoothGattCharacteristic.FORMAT_UINT8, offset);
		offset += UINT8_SIZE;
		String commandIDComment = alert_commandID_comments(commandID);
		String categoryIDComment = alert_category_id_comments(categoryID);

		bundle.putInt(EXTRA_VALUE0, commandID);
		bundle.putInt(EXTRA_VALUE1, categoryID);
		bundle.putString(EXTRA_VALUE2, commandIDComment);
		bundle.putString(EXTRA_VALUE3, categoryIDComment);

		bundle.putString(EXTRA_VALUE0_NAME, "Command ID");
		bundle.putString(EXTRA_VALUE1_NAME, "Category ID");
		bundle.putString(EXTRA_VALUE2_NAME, "Command ID comment");
		bundle.putString(EXTRA_VALUE3_NAME, "Category ID comment");

		bundle.putString(EXTRA_VALUE0_FORMAT, EXTRA_VALUE_int);
		bundle.putString(EXTRA_VALUE1_FORMAT, EXTRA_VALUE_String);
		bundle.putString(EXTRA_VALUE2_FORMAT, EXTRA_VALUE_String);
		bundle.putString(EXTRA_VALUE3_FORMAT, EXTRA_VALUE_String);

		nextOffset[0] = offset;
		return MSG_alert_notification_control_point;
	}

	private static String alert_commandID_comments(int commandID) {
		String commandIDComment;
		switch (commandID) {
		case 0:
			commandIDComment = "Enable New Incoming Alert Notification";
			break;
		case 1:
			commandIDComment = "Enable Unread Category Status Notification";
			break;
		case 2:
			commandIDComment = "Disable New Incoming Alert Notification";
			break;
		case 3:
			commandIDComment = "Disable Unread Category Status Notification";
			break;
		case 4:
			commandIDComment = "Notify New Incoming Alert immediately";
			break;
		case 5:
			commandIDComment = "Notify Unread Category Status immediately";
			break;
		default:
			commandIDComment = "Reserved for future use";

		}
		return commandIDComment;
	}

	/**
	 * calls object.on_alert_level(Bundle bundle, int alertLevel)
	 * 
	 * @param bundle
	 * @param object
	 *            an implementation of IBluetoothGattCharacteristicHandler
	 *            Caution : if your handler is static you must access this
	 *            object from a static variable
	 * @throws IllegalArgumentException
	 *             if the uuid provided by the bundle doesn't correspond
	 */
	protected static void handle_alert_notification_control_point(
			Bundle bundle, IBluetoothGattCharacteristicHandler object)
			throws IllegalArgumentException {
		String sUUID = bundle.getString(BluetoothDevice.EXTRA_UUID);
		UUID aUUID = UUID.fromString(sUUID);
		if (!GATT_CHARACTERISTIC_alert_notification_control_point.equals(aUUID)) {
			throw new IllegalArgumentException(
					"The provided uuid is uncompatible with this method");
		}
		int commandID = bundle.getInt(EXTRA_VALUE0);
		int categoryID = bundle.getInt(EXTRA_VALUE1);
		String commandIDComment = bundle.getString(EXTRA_VALUE2);
		String categoryIDComment = bundle.getString(EXTRA_VALUE2);

		object.on_alert_notification_control_point(bundle, commandID,
				commandIDComment, categoryID, categoryIDComment);
	}

	/**
	 * The Alert Status characteristic defines the Status of alert. Bit 0,
	 * meaning “Ringer State” Bit 1, meaning “Vibrator State” Bit 2, meaning
	 * "Display Alert Status"
	 * 
	 * Examples Bit 0, 0 meaning “Ringer State” not active, 1 meaning “Ringer
	 * State” active Bit 1, 0 meaning “Vibrator State” not active, 1 meaning
	 * “Vibrator State” active Bit 2, 0 meaning “Display Alert State” not
	 * active, 1 meaning “Display Alert State” active
	 * 
	 * put extra values into bundle: EXTRA_VALUE0 Command ID format int / uint8
	 * EXTRA_VALUE0 Alert Status format int / uint8
	 * 
	 * 
	 * @param bundle
	 * @param characteristic
	 * @return response id to put in message.what
	 */
	protected static int alert_status(Bundle bundle,
			BluetoothGattCharacteristic characteristic, int offset,
			int[] nextOffset) {
		// byte[] characteristicValue = characteristic.getValue();

		int alertStatus = characteristic.getIntValue(
				BluetoothGattCharacteristic.FORMAT_UINT8, offset);
		offset += UINT8_SIZE;
		bundle.putInt(EXTRA_VALUE0, alertStatus);

		bundle.putString(EXTRA_VALUE0_NAME, "Alert Status");

		bundle.putString(EXTRA_VALUE0_FORMAT, EXTRA_VALUE_int);

		nextOffset[0] = offset;
		return MSG_alert_status;
	}

	/**
	 * calls object.on_alert_status(Bundle bundle,int alertStatus, int
	 * ringerState,int vibratorState, int displayAlertStatus);
	 * 
	 * @param bundle
	 * @param object
	 *            an implementation of IBluetoothGattCharacteristicHandler
	 *            Caution : if your handler is static you must access this
	 *            object from a static variable
	 * @throws IllegalArgumentException
	 *             if the uuid provided by the bundle doesn't correspond
	 */
	protected static void handle_alert_status(Bundle bundle,
			IBluetoothGattCharacteristicHandler object)
			throws IllegalArgumentException {
		String sUUID = bundle.getString(BluetoothDevice.EXTRA_UUID);
		UUID aUUID = UUID.fromString(sUUID);
		if (!GATT_CHARACTERISTIC_alert_status.equals(aUUID)) {
			throw new IllegalArgumentException(
					"The provided uuid is uncompatible with this method");
		}

		int alertStatus = bundle.getInt(EXTRA_VALUE0);
		int ringerState = (alertStatus & 1 << 0) >> 0;
		int vibratorState = (alertStatus & 1 << 1) >> 1;
		int displayAlertStatus = (alertStatus & 1 << 2) >> 2;

		object.on_alert_status(bundle, alertStatus, ringerState, vibratorState,
				displayAlertStatus);
	}

	/**
	 * The Analog Input characteristic represents the value of an analog input
	 * as a 16-bit integer (uint16). The format of the analog value depends on
	 * the implementation.
	 * 
	 * put extra values into bundle: EXTRA_VALUE0 Command ID format int / uint8
	 * EXTRA_VALUE0 Analog Value format int / uint8
	 * 
	 * 
	 * @param bundle
	 * @param characteristic
	 * @return response id to put in message.what
	 */
	protected static int analog_input(Bundle bundle,
			BluetoothGattCharacteristic characteristic, int offset,
			int[] nextOffset) {
		// byte[] characteristicValue = characteristic.getValue();

		int analogValue = characteristic.getIntValue(
				BluetoothGattCharacteristic.FORMAT_UINT16, offset);
		offset += UINT16_SIZE;
		bundle.putInt(EXTRA_VALUE0, analogValue);

		bundle.putString(EXTRA_VALUE0_NAME, "Analog Value");

		bundle.putString(EXTRA_VALUE0_FORMAT, EXTRA_VALUE_int);

		nextOffset[0] = offset;
		return MSG_analog_input;
	}

	/**
	 * calls object.on_analog_input(Bundle bundle,int analogValue)
	 * 
	 * @param bundle
	 * @param object
	 *            an implementation of IBluetoothGattCharacteristicHandler
	 *            Caution : if your handler is static you must access this
	 *            object from a static variable
	 * @throws IllegalArgumentException
	 *             if the uuid provided by the bundle doesn't correspond
	 */
	protected static void handle_analog_input(Bundle bundle,
			IBluetoothGattCharacteristicHandler object)
			throws IllegalArgumentException {
		String sUUID = bundle.getString(BluetoothDevice.EXTRA_UUID);
		UUID aUUID = UUID.fromString(sUUID);
		if (!GATT_CHARACTERISTIC_analog_input.equals(aUUID)) {
			throw new IllegalArgumentException(
					"The provided uuid is uncompatible with this method");
		}
		int analogValue = bundle.getInt(EXTRA_VALUE0);
		object.on_analog_input(bundle, analogValue);
	}

	/**
	 * The Analog Output characteristic represents the value of an analog output
	 * as a 16-bit integer (uint16). The format of the analog value depends on
	 * the implementation.
	 * 
	 * put extra values into bundle: EXTRA_VALUE0 Command ID format int / uint8
	 * EXTRA_VALUE0 Analog Value format int / uint8
	 * 
	 * 
	 * @param bundle
	 * @param characteristic
	 * @return response id to put in message.what
	 */
	protected static int analog_output(Bundle bundle,
			BluetoothGattCharacteristic characteristic, int offset,
			int[] nextOffset) {
		// byte[] characteristicValue = characteristic.getValue();

		int analogValue = characteristic.getIntValue(
				BluetoothGattCharacteristic.FORMAT_UINT16, offset);
		offset += UINT16_SIZE;
		bundle.putInt(EXTRA_VALUE0, analogValue);

		bundle.putString(EXTRA_VALUE0_NAME, "Analog Value");

		bundle.putString(EXTRA_VALUE0_FORMAT, EXTRA_VALUE_int);

		nextOffset[0] = offset;
		return MSG_analog_output;
	}

	/**
	 * calls object.on_analog_output(Bundle bundle,int analogValue)
	 * 
	 * @param bundle
	 * @param object
	 *            an implementation of IBluetoothGattCharacteristicHandler
	 *            Caution : if your handler is static you must access this
	 *            object from a static variable
	 * @throws IllegalArgumentException
	 *             if the uuid provided by the bundle doesn't correspond
	 */
	protected static void handle_analog_output(Bundle bundle,
			IBluetoothGattCharacteristicHandler object)
			throws IllegalArgumentException {
		String sUUID = bundle.getString(BluetoothDevice.EXTRA_UUID);
		UUID aUUID = UUID.fromString(sUUID);
		if (!GATT_CHARACTERISTIC_analog_output.equals(aUUID)) {
			throw new IllegalArgumentException(
					"The provided uuid is uncompatible with this method");
		}
		int analogValue = bundle.getInt(EXTRA_VALUE0);
		object.on_analog_output(bundle, analogValue);
	}

	/**
	 * The current charge level of a battery. 100% represents fully charged
	 * while 0% represents fully discharged.
	 * 
	 * 
	 * put extra values into bundle: EXTRA_VALUE0 Command ID format int / uint8
	 * EXTRA_VALUE0 Level format int / uint8
	 * 
	 * 
	 * @param bundle
	 * @param characteristic
	 * @return response id to put in message.what
	 */
	protected static int battery_level(Bundle bundle,
			BluetoothGattCharacteristic characteristic, int offset,
			int[] nextOffset) {
		// byte[] characteristicValue = characteristic.getValue();

		int level = characteristic.getIntValue(
				BluetoothGattCharacteristic.FORMAT_UINT8, offset);
		offset += UINT8_SIZE;
		bundle.putInt(EXTRA_VALUE0, level);

		bundle.putString(EXTRA_VALUE0_NAME, "Level");

		bundle.putString(EXTRA_VALUE0_FORMAT, EXTRA_VALUE_int);

		nextOffset[0] = offset;
		return MSG_battery_level;
	}

	/**
	 * calls object.on_battery_level(Bundle bundle,int level)
	 * 
	 * @param bundle
	 * @param object
	 *            an implementation of IBluetoothGattCharacteristicHandler
	 *            Caution : if your handler is static you must access this
	 *            object from a static variable
	 * @throws IllegalArgumentException
	 *             if the uuid provided by the bundle doesn't correspond
	 */
	protected static void handle_battery_level(Bundle bundle,
			IBluetoothGattCharacteristicHandler object)
			throws IllegalArgumentException {
		String sUUID = bundle.getString(BluetoothDevice.EXTRA_UUID);
		UUID aUUID = UUID.fromString(sUUID);
		if (!GATT_CHARACTERISTIC_battery_level.equals(aUUID)) {
			throw new IllegalArgumentException(
					"The provided uuid is uncompatible with this method");
		}
		int level = bundle.getInt(EXTRA_VALUE0);

		object.on_battery_level(bundle, level);
	}

	/**
	 * put extra values into bundle: uint8 EXTRA_VALUE0 Level format int / uint8
	 * as received from remote uint8 EXTRA_VALUE0 State format int / uint8 as
	 * received from remote
	 * 
	 * 
	 * @param bundle
	 * @param characteristic
	 * @return response id to put in message.what
	 */
	protected static int battery_level_state(Bundle bundle,
			BluetoothGattCharacteristic characteristic, int offset,
			int[] nextOffset) {
		// byte[] characteristicValue = characteristic.getValue();

		int level = 0;
		int state = 0;

		Bundle b0 = new Bundle();
		battery_level(bundle, characteristic, offset, nextOffset);
		offset = nextOffset[0];

		level = b0.getInt(EXTRA_VALUE0);

		Bundle b1 = new Bundle();
		battery_power_state(b1, characteristic, offset, nextOffset);
		offset = nextOffset[0];

		state = b1.getInt(EXTRA_VALUE0);

		int maskBits0 = 0x03;
		int maskBits1 = 0x0c;
		int maskBits2 = 0x30;
		int maskBits3 = 0xc0;
		int stateBits0 = (state & maskBits0) >> 0;
		int stateBits1 = (state & maskBits1) >> 2;
		int stateBits2 = (state & maskBits2) >> 4;
		int stateBits3 = (state & maskBits3) >> 6;
		String comment0 = battery_power_state_comment(0, stateBits0);
		String comment1 = battery_power_state_comment(1, stateBits1);
		String comment2 = battery_power_state_comment(2, stateBits2);
		String comment3 = battery_power_state_comment(3, stateBits3);

		bundle.putInt(EXTRA_VALUE0, level);
		bundle.putInt(EXTRA_VALUE1, state);
		bundle.putIntArray(EXTRA_VALUE2, new int[] { stateBits0, stateBits1,
				stateBits2, stateBits3 });
		bundle.putStringArray(EXTRA_VALUE3, new String[] { comment0, comment1,
				comment2, comment3 });

		bundle.putString(EXTRA_VALUE0_NAME, "Level");
		bundle.putString(EXTRA_VALUE1_NAME, "State");
		bundle.putString(EXTRA_VALUE2_NAME,
				"[stateBits0,stateBits1,stateBits2,stateBits3]");
		bundle.putString(EXTRA_VALUE3_NAME,
				"comments [stateBits0,stateBits1,stateBits2,stateBits3]");

		bundle.putString(EXTRA_VALUE0_FORMAT, EXTRA_VALUE_int);
		bundle.putString(EXTRA_VALUE1_FORMAT, EXTRA_VALUE_int);
		bundle.putString(EXTRA_VALUE2_FORMAT, EXTRA_VALUE_intArray);
		bundle.putString(EXTRA_VALUE3_FORMAT, EXTRA_VALUE_StringArray);

		nextOffset[0] = offset;
		return MSG_battery_level_state;
	}

	/**
	 * calls object.on_battery_level_state(Bundle bundle,int level,int
	 * state,int[] stateBits,String[] stateComments);
	 * 
	 * @param bundle
	 * @param object
	 *            an implementation of IBluetoothGattCharacteristicHandler
	 *            Caution : if your handler is static you must access this
	 *            object from a static variable
	 * @throws IllegalArgumentException
	 *             if the uuid provided by the bundle doesn't correspond
	 */
	protected static void handle_battery_level_state(Bundle bundle,
			IBluetoothGattCharacteristicHandler object)
			throws IllegalArgumentException {
		String sUUID = bundle.getString(BluetoothDevice.EXTRA_UUID);
		UUID aUUID = UUID.fromString(sUUID);
		if (!GATT_CHARACTERISTIC_battery_level_state.equals(aUUID)) {
			throw new IllegalArgumentException(
					"The provided uuid is uncompatible with this method");
		}
		int level = bundle.getInt(EXTRA_VALUE0);
		int state = bundle.getInt(EXTRA_VALUE1);
		int[] stateBits = bundle.getIntArray(EXTRA_VALUE2);
		String[] stateComments = bundle.getStringArray(EXTRA_VALUE3);

		object.on_battery_level_state(bundle, level, state, stateBits,
				stateComments);
	}

	/**
	 * 
	 * put extra values into bundle: uint8 EXTRA_VALUE0 State format int / uint8
	 * as received from remote
	 * 
	 * 
	 * @param bundle
	 * @param characteristic
	 * @return response id to put in message.what
	 */
	protected static int battery_power_state(Bundle bundle,
			BluetoothGattCharacteristic characteristic, int offset,
			int[] nextOffset) {
		// byte[] characteristicValue = characteristic.getValue();

		int state = characteristic.getIntValue(
				BluetoothGattCharacteristic.FORMAT_UINT8, offset);
		offset += UINT8_SIZE;
		int maskBits0 = 0x03;
		int maskBits1 = 0x0c;
		int maskBits2 = 0x30;
		int maskBits3 = 0xc0;
		int stateBits0 = (state & maskBits0) >> 0;
		int stateBits1 = (state & maskBits1) >> 2;
		int stateBits2 = (state & maskBits2) >> 4;
		int stateBits3 = (state & maskBits3) >> 6;
		String comment0 = battery_power_state_comment(0, stateBits0);
		String comment1 = battery_power_state_comment(1, stateBits1);
		String comment2 = battery_power_state_comment(2, stateBits2);
		String comment3 = battery_power_state_comment(3, stateBits3);

		bundle.putInt(EXTRA_VALUE0, state);
		bundle.putIntArray(EXTRA_VALUE1, new int[] { stateBits0, stateBits1,
				stateBits2, stateBits3 });
		bundle.putStringArray(EXTRA_VALUE2, new String[] { comment0, comment1,
				comment2, comment3 });

		bundle.putString(EXTRA_VALUE0_NAME, "State");
		bundle.putString(EXTRA_VALUE1_NAME,
				"[stateBits0,stateBits1,stateBits2,stateBits3]");
		bundle.putString(EXTRA_VALUE2_NAME,
				"comments [stateBits0,stateBits1,stateBits2,stateBits3]");

		bundle.putString(EXTRA_VALUE0_FORMAT, EXTRA_VALUE_int);
		bundle.putString(EXTRA_VALUE1_FORMAT, EXTRA_VALUE_intArray);
		bundle.putString(EXTRA_VALUE2_FORMAT, EXTRA_VALUE_StringArray);

		nextOffset[0] = offset;
		return MSG_battery_power_state;
	}

	/**
	 * calls object.on_battery_state(Bundle bundle,int rawState,int[]
	 * stateBits,String[] stateComments);
	 * 
	 * @param bundle
	 * @param object
	 *            an implementation of IBluetoothGattCharacteristicHandler
	 *            Caution : if your handler is static you must access this
	 *            object from a static variable
	 * @throws IllegalArgumentException
	 *             if the uuid provided by the bundle doesn't correspond
	 */
	protected static void handle_battery_power_state(Bundle bundle,
			IBluetoothGattCharacteristicHandler object)
			throws IllegalArgumentException {
		String sUUID = bundle.getString(BluetoothDevice.EXTRA_UUID);
		UUID aUUID = UUID.fromString(sUUID);
		if (!GATT_CHARACTERISTIC_battery_power_state.equals(aUUID)) {
			throw new IllegalArgumentException(
					"The provided uuid is uncompatible with this method");
		}
		int rawState = bundle.getInt(EXTRA_VALUE0);
		int[] stateBits = bundle.getIntArray(EXTRA_VALUE1);
		String[] stateComments = bundle.getStringArray(EXTRA_VALUE2);

		object.on_battery_power_state(bundle, rawState, stateBits,
				stateComments);
	}

	/**
	 * 
	 * 
	 * 
	 * @param bitIndex
	 * @param stateBits
	 * @return
	 */
	private static String battery_power_state_comment(int bitIndex,
			int stateBits) {
		String comment = "Unknown";
		switch (bitIndex) {
		case 0:
			switch (stateBits) {
			case 0:
				comment = "Unknown";
				break;
			case 1:
				comment = "Not Supported";
				break;
			case 2:
				comment = "Not Present";
				break;
			case 3:
				comment = "Present";
				break;
			}
			break;
		case 1:
			switch (stateBits) {
			case 0:
				comment = "Unknown";
				break;
			case 1:
				comment = "Not Supported";
				break;
			case 2:
				comment = "Not Discharging";
				break;
			case 3:
				comment = "Discharging";
				break;
			}
			break;
		case 2:
			switch (stateBits) {
			case 0:
				comment = "Unknown";
				break;
			case 1:
				comment = "Not Chargeable";
				break;
			case 2:
				comment = "Not Charging (Chargeable)";
				break;
			case 3:
				comment = "Charging (Chargeable)";
				break;
			}
			break;
		case 3:
			switch (stateBits) {
			case 0:
				comment = "Unknown";
				break;
			case 1:
				comment = "Not Supported";
				break;
			case 2:
				comment = "Good Level";
				break;
			case 3:
				comment = "Critically Low Level)";
				break;
			}
			break;
		}

		return comment;
	}

	/**
	 * The Blood Pressure Feature characteristic is used to describe the
	 * supported features of the Blood Pressure Sensor. <BitField> <Bit
	 * name="Body Movement Detection Support bit" index="0" size="1" > </Bit>
	 * <Bit name="Cuff Fit Detection Support bit" index="1" size="1" > </Bit>
	 * <Bit name="Irregular Pulse Detection Support bit" index="2" size="1" >
	 * </Bit> <Bit name="Pulse Rate Range Detection Support bit" index="3"
	 * size="1" > </Bit> <Bit name="Measurement Position Detection Support bit"
	 * index="4" size="1" > </Bit> <Bit name="Multiple Bond Support bit"
	 * index="5" size="1" > </Bit> <ReservedForFutureUse index="6" size="10" />
	 * </BitField>
	 * 
	 * @param bundle
	 * @param characteristic
	 * @return response id to put in message.what
	 */
	protected static int blood_pressure_feature(Bundle bundle,
			BluetoothGattCharacteristic characteristic, int offset,
			int[] nextOffset) {
		// byte[] characteristicValue = characteristic.getValue();

		int bloodPressureFeature = characteristic.getIntValue(
				BluetoothGattCharacteristic.FORMAT_UINT16, offset);
		offset += UINT16_SIZE;

		bundle.putInt(EXTRA_VALUE0, bloodPressureFeature);
		bundle.putString(EXTRA_VALUE0_NAME, "Blood Pressure Feature");

		nextOffset[0] = offset;
		return MSG_blood_pressure_feature;
	}

	/**
	 * calls object.on_blood_pressure_feature(Bundle bundle, int
	 * bloodPressureFeature, int[] features )
	 * 
	 * @param bundle
	 * @param object
	 *            an implementation of IBluetoothGattCharacteristicHandler
	 *            Caution : if your handler is static you must access this
	 *            object from a static variable
	 * @throws IllegalArgumentException
	 *             if the uuid provided by the bundle doesn't correspond
	 */
	protected static void handle_blood_pressure_feature(Bundle bundle,
			IBluetoothGattCharacteristicHandler object)
			throws IllegalArgumentException {
		String sUUID = bundle.getString(BluetoothDevice.EXTRA_UUID);
		UUID aUUID = UUID.fromString(sUUID);
		if (!GATT_CHARACTERISTIC_blood_pressure_feature.equals(aUUID)) {
			throw new IllegalArgumentException(
					"The provided uuid is uncompatible with this method");
		}

		int bloodPressureFeature = bundle.getInt(EXTRA_VALUE0);
		int[] features = new int[16];
		for (int i = 0; i < 16; i++) {
			features[i] = (bloodPressureFeature & 1 << i) >> i;
		}

		object.on_blood_pressure_feature(bundle, bloodPressureFeature, features);
	}

	/**
	 * The Blood Pressure Measurement characteristic is a variable length
	 * structure containing a Flags field, a Blood Pressure Measurement Compound
	 * Value field, and contains additional fields such as Time Stamp, Pulse
	 * Rate and User ID as determined by the contents of the Flags field.
	 * </Abstract> </InformativeText> <Value> <Field name="Flags" >
	 * <InformativeText> These flags define which data fields are present in the
	 * Characteristic value </InformativeText> <Requirement> Mandatory
	 * </Requirement> <Format> 8bit </Format> <BitField> <Bit
	 * name="Blood Pressure Units Flag" index="0" size="1" > <Enumerations>
	 * <Enumeration key="0" requires="C1"
	 * value="Blood pressure for Systolic, Diastolic and MAP in units of mmHg"
	 * /> <Enumeration key="1" requires="C2"
	 * value="Blood pressure for Systolic, Diastolic and MAP in units of kPa" />
	 * </Enumerations> </Bit> <Bit name="Time Stamp Flag" index="1" size="1" >
	 * <Enumerations> <Enumeration key="0" value="Time Stamp not present" />
	 * <Enumeration key="1" requires="C3" value="Time Stamp present" />
	 * </Enumerations> </Bit> <Bit name="Pulse Rate Flag" index="2" size="1" >
	 * <Enumerations> <Enumeration key="0" value="Pulse Rate not present" />
	 * <Enumeration key="1" requires="C4" value="Pulse Rate present" />
	 * </Enumerations> </Bit> <Bit name="User ID Flag" index="3" size="1" >
	 * <Enumerations> <Enumeration key="0" value="User ID not present" />
	 * <Enumeration key="1" requires="C5" value="User ID present" />
	 * </Enumerations> </Bit> <Bit name="Measurement Status Flag" index="4"
	 * size="1" > <Enumerations> <Enumeration key="0"
	 * value="Measurement Status not present" /> <Enumeration key="1"
	 * requires="C6" value="Measurement Status present" /> </Enumerations>
	 * </Bit> <ReservedForFutureUse index="5" size="1" /> <ReservedForFutureUse
	 * index="6" size="1" /> <ReservedForFutureUse index="7" size="1" />
	 * </BitField> </Field> <Field
	 * name="Blood Pressure Measurement Compound Value - Systolic (mmHg)" >
	 * <InformativeText> C1: Field exists if the key of bit 0 of the Flags field
	 * is set to 0 </InformativeText> <Requirement> C1 </Requirement> <Format>
	 * SFLOAT </Format> <Unit> org.bluetooth.unit.pressure.millimetre_of_mercury
	 * </Unit> </Field> <Field
	 * name="Blood Pressure Measurement Compound Value - Diastolic (mmHg)" >
	 * <InformativeText> C1: Field exists if the key of bit 0 of the Flags field
	 * is set to 0 </InformativeText> <Requirement> C1 </Requirement> <Format>
	 * SFLOAT </Format> <Unit> org.bluetooth.unit.pressure.millimetre_of_mercury
	 * </Unit> </Field> <Field name=
	 * "Blood Pressure Measurement Compound Value - Mean Arterial Pressure (mmHg)"
	 * > <InformativeText> C1: Field exists if the key of bit 0 of the Flags
	 * field is set to 0 </InformativeText> <Requirement> C1 </Requirement>
	 * <Format> SFLOAT </Format> <Unit>
	 * org.bluetooth.unit.pressure.millimetre_of_mercury </Unit> </Field> <Field
	 * name="Blood Pressure Measurement Compound Value - Systolic (kPa)" >
	 * <InformativeText> C2: Field exists if the key of bit 0 of the Flags field
	 * is set to 1 </InformativeText> <Requirement> C2 </Requirement> <Format>
	 * SFLOAT </Format> <Unit> org.bluetooth.unit.pressure.pascal </Unit>
	 * <DecimalExponent> 3 </DecimalExponent> </Field> <Field
	 * name="Blood Pressure Measurement Compound Value - Diastolic (kPa)" >
	 * <InformativeText> C2: Field exists if the key of bit 0 of the Flags field
	 * is set to 1 </InformativeText> <Requirement> C2 </Requirement> <Format>
	 * SFLOAT </Format> <Unit> org.bluetooth.unit.pressure.pascal </Unit>
	 * <DecimalExponent> 3 </DecimalExponent> </Field> <Field name=
	 * "Blood Pressure Measurement Compound Value - Mean Arterial Pressure (kPa)"
	 * > <InformativeText> C2: Field exists if the key of bit 0 of the Flags
	 * field is set to 1 </InformativeText> <Requirement> C2 </Requirement>
	 * <Format> SFLOAT </Format> <Unit> org.bluetooth.unit.pressure.pascal
	 * </Unit> <DecimalExponent> 3 </DecimalExponent> </Field> <Field
	 * name="Time Stamp" > <InformativeText> C3: Field exists if the key of bit
	 * 1 of the Flags field is set to 1 </InformativeText> <Requirement> C3
	 * </Requirement> <Reference> org.bluetooth.characteristic.date_time
	 * </Reference> </Field> <Field name="Pulse Rate" > <InformativeText> C4:
	 * Field exists if the key of bit 2 of the Flags field is set to 1
	 * </InformativeText> <Requirement> C4 </Requirement> <Format> SFLOAT
	 * </Format> <Unit> org.bluetooth.unit.period.beats_per_minute </Unit>
	 * </Field> <Field name="User ID" > <InformativeText> C5: Field exists if
	 * the key of bit 3 of the Flags field is set to 1 </InformativeText>
	 * <Requirement> C5 </Requirement> <Format> uint8 </Format> <Enumerations>
	 * <Enumeration key="255" value="Unknown User" />
	 * <DefinedByServiceSpecification end="254" start="0" /> </Enumerations>
	 * </Field> <Field name="Measurement Status" > <InformativeText> C6: Field
	 * exists if the key of bit 4 of the Flags field is set to 1
	 * </InformativeText> <Requirement> C6 </Requirement> <Format> 16bit
	 * </Format> <BitField> <Bit name="Body Movement Detection Flag" index="0"
	 * size="1" > <Enumerations> <Enumeration key="0" value="No body movement"
	 * /> <Enumeration key="1" value="Body movement during measurement" />
	 * </Enumerations> </Bit> <Bit name="Cuff Fit Detection Flag" index="1"
	 * size="1" > <Enumerations> <Enumeration key="0" value="Cuff fits properly"
	 * /> <Enumeration key="1" value="Cuff too loose" /> </Enumerations> </Bit>
	 * <Bit name="Irregular Pulse Detection Flag" index="2" size="1" >
	 * <Enumerations> <Enumeration key="0" value="No irregular pulse detected"
	 * /> <Enumeration key="1" value="Irregular pulse detected" />
	 * </Enumerations> </Bit> <Bit name="Pulse Rate Range Detection Flags"
	 * index="3" size="2" > <Enumerations> <Enumeration key="0"
	 * value="Pulse rate is within the range" /> <Enumeration key="1"
	 * value="Pulse rate exceeds upper limit" /> <Enumeration key="2"
	 * value="Pulse rate is less than lower limit" /> <ReservedForFutureUse1
	 * end1="3" start1="3" /> </Enumerations> </Bit> <Bit
	 * name="Measurement Position Detection Flag" index="5" size="1" >
	 * <Enumerations> <Enumeration key="0" value="Proper measurement position"
	 * /> <Enumeration key="1" value="Improper measurement position" />
	 * </Enumerations> </Bit> <ReservedForFutureUse index="6" size="1" />
	 * <ReservedForFutureUse index="7" size="1" /> <ReservedForFutureUse
	 * index="8" size="1" /> <ReservedForFutureUse index="9" size="1" />
	 * <ReservedForFutureUse index="10" size="1" /> <ReservedForFutureUse
	 * index="11" size="1" /> <ReservedForFutureUse index="12" size="1" />
	 * <ReservedForFutureUse index="13" size="1" /> <ReservedForFutureUse
	 * index="14" size="1" /> <ReservedForFutureUse index="15" size="1" />
	 * </BitField> </Field> </Value> <Note> The fields in the above table are in
	 * the order of LSO to MSO. Where LSO = Least Significant Octet and MSO =
	 * Most Significant Octet and MAP = Mean Arterial Pressure. </Note>
	 * 
	 * * put extra values into bundle: EXTRA_VALUE0 EXTRA_VALUE1 subcategory
	 * format int
	 * 
	 * 
	 * @param bundle
	 * @param characteristic
	 * @return response id to put in message.what
	 */
	protected static int blood_pressure_measurement(Bundle bundle,
			BluetoothGattCharacteristic characteristic, int offset,
			int[] nextOffset) {
		// byte[] characteristicValue = characteristic.getValue();

		int flags = characteristic.getIntValue(
				BluetoothGattCharacteristic.FORMAT_UINT8, offset);
		int bloodPressureUnitsFlag = flags & 0x01;
		int timestampFlag = flags & 0x02;
		int pulseRateFlag = flags & 0x04;
		int userIDFlag = flags & 0x08;
		int measurementStatusFlag = flags & 0x16;

		int[] _flags = new int[8];
		for (int i = 0; i < 0; i++) {
			_flags[i] = (flags & 1 << i) >> i;
		}

		bundle.putIntArray(EXTRA_VALUE0, _flags);
		bundle.putString(EXTRA_VALUE0_NAME, "Flags");
		bundle.putString(EXTRA_VALUE0_FORMAT, EXTRA_VALUE_int);

		offset += BYTE_SIZE;
		float floatValue = 0;
		floatValue = characteristic.getFloatValue(
				BluetoothGattCharacteristic.FORMAT_SFLOAT, offset);
		bundle.putFloat(EXTRA_VALUE1, floatValue);
		bundle.putString(EXTRA_VALUE1_FORMAT, EXTRA_VALUE_float);
		offset += SFLOAT_SIZE;
		floatValue = characteristic.getFloatValue(
				BluetoothGattCharacteristic.FORMAT_SFLOAT, offset);
		bundle.putFloat(EXTRA_VALUE2, floatValue);
		bundle.putString(EXTRA_VALUE2_FORMAT, EXTRA_VALUE_float);
		offset += SFLOAT_SIZE;
		floatValue = characteristic.getFloatValue(
				BluetoothGattCharacteristic.FORMAT_SFLOAT, offset);
		bundle.putFloat(EXTRA_VALUE3, floatValue);
		bundle.putString(EXTRA_VALUE3_FORMAT, EXTRA_VALUE_float);
		offset += SFLOAT_SIZE;

		if (bloodPressureUnitsFlag == 0) {
			bundle.putString(EXTRA_VALUE1_NAME,
					"Blood Pressure Measurement Compound Value - Systolic (mmHg)");
			bundle.putString(EXTRA_VALUE2_NAME,
					"Blood Pressure Measurement Compound Value - Diastolic (mmHg)");
			bundle.putString(EXTRA_VALUE3_NAME,
					"Blood Pressure Measurement Compound Value - Mean Arterial Pressure (mmHg)");
		} else {
			bundle.putString(EXTRA_VALUE1_NAME,
					"Blood Pressure Measurement Compound Value - Systolic (kPa)");
			bundle.putString(EXTRA_VALUE2_NAME,
					"Blood Pressure Measurement Compound Value - Diastolic (kPa)");
			bundle.putString(EXTRA_VALUE3_NAME,
					"Blood Pressure Measurement Compound Value - Mean Arterial Pressure (kPa)");
		}

		int[] date = new int[6];
		if (timestampFlag == 1) {
			offset = getDateTime(characteristic, date, offset);
		}

		bundle.putIntArray(EXTRA_VALUE4, date);
		bundle.putString(EXTRA_VALUE4_NAME, "Date [yy, mm, dd, hh, mm, ss]");
		bundle.putString(EXTRA_VALUE4_FORMAT, EXTRA_VALUE_intArray);

		float pulseRate = 0;
		if (pulseRateFlag == 1) {
			pulseRate = characteristic.getFloatValue(
					BluetoothGattCharacteristic.FORMAT_SFLOAT, offset);
			offset += SFLOAT_SIZE;
		}
		bundle.putFloat(EXTRA_VALUE5, pulseRate);
		bundle.putString(EXTRA_VALUE5_NAME, "Pulse Rate");
		bundle.putString(EXTRA_VALUE5_FORMAT, EXTRA_VALUE_float);

		int userID = 0;
		if (userIDFlag == 1) {
			userID = characteristic.getIntValue(
					BluetoothGattCharacteristic.FORMAT_UINT8, offset);
			offset += UINT8_SIZE;
		}
		bundle.putFloat(EXTRA_VALUE6, userID);
		bundle.putString(EXTRA_VALUE6_NAME, "User ID");
		bundle.putString(EXTRA_VALUE6_FORMAT, EXTRA_VALUE_int);

		int[] measurementStatusBits = new int[15];
		String[] measurementStatusBitsComments = new String[15];
		int measurementStatus = characteristic.getIntValue(
				BluetoothGattCharacteristic.FORMAT_UINT16, offset);
		offset += UINT16_SIZE;
		if (measurementStatusFlag == 1) {
			int bodyMovementDetectionFlag = (measurementStatus & 1 << 0) >> 0;
			measurementStatusBits[0] = bodyMovementDetectionFlag;
			if (bodyMovementDetectionFlag == 0) {
				measurementStatusBitsComments[0] = "No body movement";
			} else {
				measurementStatusBitsComments[0] = "Body movement during measurement";
			}

			int cuffFitDetectionFlag = (measurementStatus & 1 << 1) >> 1;
			measurementStatusBits[1] = cuffFitDetectionFlag;
			if (cuffFitDetectionFlag == 0) {
				measurementStatusBitsComments[1] = "Cuff fits properly";
			} else {
				measurementStatusBitsComments[1] = "Cuff too loose";
			}

			int irregularPulseDetectionFlag = (measurementStatus & 1 << 2) >> 2;
			measurementStatusBits[2] = irregularPulseDetectionFlag;
			if (irregularPulseDetectionFlag == 0) {
				measurementStatusBitsComments[2] = "No irregular pulse detected";
			} else {
				measurementStatusBitsComments[2] = "Irregular pulse detected";
			}

			int pulseRateRangeDetectionFlags = (measurementStatus & 0x18) >> 3;
			measurementStatusBits[3] = pulseRateRangeDetectionFlags;
			if (pulseRateRangeDetectionFlags == 0) {
				measurementStatusBitsComments[3] = "Pulse rate is within the range";
			} else if (pulseRateRangeDetectionFlags == 1) {
				measurementStatusBitsComments[3] = "Pulse rate exceeds upper limit";
			} else if (pulseRateRangeDetectionFlags == 2) {
				measurementStatusBitsComments[3] = "Pulse rate is less than lower limit";
			} else if (pulseRateRangeDetectionFlags == 3) {
				measurementStatusBitsComments[3] = "Reserved for future use";
			}

			int measurementPositionDetectionFlag = (measurementStatus & 1 << 5) >> 5;
			measurementStatusBits[4] = measurementPositionDetectionFlag;
			if (measurementPositionDetectionFlag == 0) {
				measurementStatusBitsComments[4] = "Proper measurement position";
			} else {
				measurementStatusBitsComments[4] = "Improper measurement position";
			}

			int reservedForFutureUse0 = (measurementStatus & 1 << 6) >> 6;
			measurementStatusBits[5] = reservedForFutureUse0;

			int reservedForFutureUse1 = (measurementStatus & 1 << 7) >> 7;
			measurementStatusBits[6] = reservedForFutureUse1;
			int reservedForFutureUse2 = (measurementStatus & 1 << 8) >> 8;
			measurementStatusBits[7] = reservedForFutureUse2;
			int reservedForFutureUse3 = (measurementStatus & 1 << 9) >> 9;
			measurementStatusBits[8] = reservedForFutureUse3;
			int reservedForFutureUse4 = (measurementStatus & 1 << 10) >> 10;
			measurementStatusBits[9] = reservedForFutureUse4;
			int reservedForFutureUse5 = (measurementStatus & 1 << 11) >> 11;
			measurementStatusBits[10] = reservedForFutureUse5;
			int reservedForFutureUse6 = (measurementStatus & 1 << 12) >> 12;
			measurementStatusBits[11] = reservedForFutureUse6;
			int reservedForFutureUse7 = (measurementStatus & 1 << 13) >> 13;
			measurementStatusBits[12] = reservedForFutureUse7;
			int reservedForFutureUse8 = (measurementStatus & 1 << 14) >> 14;
			measurementStatusBits[13] = reservedForFutureUse8;
			int reservedForFutureUse9 = (measurementStatus & 1 << 15) >> 15;
			measurementStatusBits[14] = reservedForFutureUse9;
		}

		bundle.putIntArray(EXTRA_VALUE7, measurementStatusBits);
		bundle.putString(EXTRA_VALUE7_NAME, "Measurement Status Bits");
		bundle.putString(EXTRA_VALUE7_FORMAT, EXTRA_VALUE_intArray);

		bundle.putStringArray(EXTRA_VALUE8, measurementStatusBitsComments);
		bundle.putString(EXTRA_VALUE8_NAME, "Measurement Status Comments");
		bundle.putString(EXTRA_VALUE8_FORMAT, EXTRA_VALUE_intArray);

		nextOffset[0] = offset;
		return MSG_blood_pressure_measurement;
	}

	/**
	 * calls object.on_blood_pressure_measurement(Bundle bundle, int[] flags,
	 * int units, float systolic, float diastolic, float meanArterialPressure,
	 * int[] date, float pulseRate, int userID, int[] measurementStatusBits,
	 * String[] measurementStatusBitsComments);
	 * 
	 * 
	 * @param bundle
	 * @param object
	 * @throws IllegalArgumentException
	 */
	protected static void handle_blood_pressure_measurement(Bundle bundle,
			IBluetoothGattCharacteristicHandler object)
			throws IllegalArgumentException {
		String sUUID = bundle.getString(BluetoothDevice.EXTRA_UUID);
		UUID aUUID = UUID.fromString(sUUID);
		if (!GATT_CHARACTERISTIC_blood_pressure_measurement.equals(aUUID)) {
			throw new IllegalArgumentException(
					"The provided uuid is uncompatible with this method");
		}

		int[] flags = bundle.getIntArray(EXTRA_VALUE0);
		int units = flags[0];
		float systolic = bundle.getFloat(EXTRA_VALUE1);
		float diastolic = bundle.getFloat(EXTRA_VALUE2);
		float meanArterialPressure = bundle.getFloat(EXTRA_VALUE3);
		int[] date = bundle.getIntArray(EXTRA_VALUE4);
		float pulseRate = bundle.getFloat(EXTRA_VALUE5);
		int userID = bundle.getInt(EXTRA_VALUE6);
		int[] measurementStatusBits = bundle.getIntArray(EXTRA_VALUE7);
		String[] measurementStatusBitsComments = bundle
				.getStringArray(EXTRA_VALUE8);
		Calendar calendar = dateValuesArrayAsCalendar(date);

		object.on_blood_pressure_measurement(bundle, flags, units, systolic,
				diastolic, meanArterialPressure, date, calendar, pulseRate,
				userID, measurementStatusBits, measurementStatusBitsComments);
	}

	protected static int body_sensor_location(Bundle bundle,
			BluetoothGattCharacteristic characteristic, int offset,
			int[] nextOffset) {
		// byte[] characteristicValue = characteristic.getValue();

		int bBodySensorLocation = characteristic.getIntValue(
				BluetoothGattCharacteristic.FORMAT_UINT8, offset);
		offset += UINT8_SIZE;
		String value;
		switch (bBodySensorLocation) {
		case 0:
			value = "Other";
			break;
		case 1:
			value = "Chest";
			break;
		case 2:
			value = "Wrist";
			break;
		case 3:
			value = "Finger";
			break;
		case 4:
			value = "Hand";
			break;
		case 5:
			value = "Ear Lobe";
			break;
		case 6:
			value = "Foot";
			break;
		default:
			value = "Reserved for future use";
		}

		bundle.putInt(EXTRA_VALUE0, bBodySensorLocation);
		bundle.putString(EXTRA_VALUE1, value);

		nextOffset[0] = offset;
		return MSG_body_sensor_location;
	}

	protected static void handle_body_sensor_location(Bundle bundle,
			IBluetoothGattCharacteristicHandler object)
			throws IllegalArgumentException {
		String sUUID = bundle.getString(BluetoothDevice.EXTRA_UUID);
		UUID aUUID = UUID.fromString(sUUID);
		if (!GATT_CHARACTERISTIC_body_sensor_location.equals(aUUID)) {
			throw new IllegalArgumentException(
					"The provided uuid is uncompatible with this method");
		}

		int bBodySensorLocation = bundle.getInt(EXTRA_VALUE0);
		String value = bundle.getString(EXTRA_VALUE1);

		object.on_body_sensor_location(bundle, bBodySensorLocation, value);

	}

	/**
	 * put extra values into bundle: EXTRA_VALUE0 Boot Keyboard Input Report
	 * Value format int
	 * 
	 * @param bundle
	 * @param characteristic
	 * @return response id to put in message.what
	 */
	protected static int boot_keyboard_input_report(Bundle bundle,
			BluetoothGattCharacteristic characteristic, int offset,
			int[] nextOffset) {
		// byte[] characteristicValue = characteristic.getValue();

		int bootKeyboardInputReportValue = characteristic.getIntValue(
				BluetoothGattCharacteristic.FORMAT_UINT8, offset);
		offset += UINT8_SIZE;

		bundle.putInt(EXTRA_VALUE0, bootKeyboardInputReportValue);
		bundle.putString(EXTRA_VALUE0_NAME, "Boot Keyboard Input Report Value");
		bundle.putString(EXTRA_VALUE0_FORMAT, EXTRA_VALUE_int);

		nextOffset[0] = offset;
		return MSG_boot_keyboard_input_report;
	}

	/**
	 * calls object.on_handle_boot_keyboard_input_report(Bundle bundle,int
	 * bootKeyboardInputReportValue );
	 * 
	 * 
	 * @param bundle
	 * @param object
	 * @throws IllegalArgumentException
	 */
	protected static void handle_boot_keyboard_input_report(Bundle bundle,
			IBluetoothGattCharacteristicHandler object)
			throws IllegalArgumentException {
		String sUUID = bundle.getString(BluetoothDevice.EXTRA_UUID);
		UUID aUUID = UUID.fromString(sUUID);
		if (!GATT_CHARACTERISTIC_boot_keyboard_input_report.equals(aUUID)) {
			throw new IllegalArgumentException(
					"The provided uuid is uncompatible with this method");
		}

		int bootKeyboardInputReportValue = bundle.getInt(EXTRA_VALUE0);

		object.on_handle_boot_keyboard_input_report(bundle,
				bootKeyboardInputReportValue);
	}

	/**
	 * put extra values into bundle: EXTRA_VALUE0 Boot Keyboard Output Report
	 * Value format int
	 * 
	 * @param bundle
	 * @param characteristic
	 * @return response id to put in message.what
	 */
	protected static int boot_keyboard_output_report(Bundle bundle,
			BluetoothGattCharacteristic characteristic, int offset,
			int[] nextOffset) {
		// byte[] characteristicValue = characteristic.getValue();

		int bootKeyboardOutputReportValue = characteristic.getIntValue(
				BluetoothGattCharacteristic.FORMAT_UINT8, offset);
		offset += UINT8_SIZE;
		bundle.putInt(EXTRA_VALUE0, bootKeyboardOutputReportValue);
		bundle.putString(EXTRA_VALUE0_NAME, "Boot Keyboard Output Report Value");
		bundle.putString(EXTRA_VALUE0_FORMAT, EXTRA_VALUE_int);

		nextOffset[0] = offset;
		return MSG_boot_keyboard_output_report;
	}

	/**
	 * calls object.on_handle_boot_keyboard_output_report(Bundle bundle,int
	 * bootKeyboardInputReportValue );
	 * 
	 * 
	 * @param bundle
	 * @param object
	 * @throws IllegalArgumentException
	 */
	protected static void handle_boot_keyboard_output_report(Bundle bundle,
			IBluetoothGattCharacteristicHandler object)
			throws IllegalArgumentException {
		String sUUID = bundle.getString(BluetoothDevice.EXTRA_UUID);
		UUID aUUID = UUID.fromString(sUUID);
		if (!GATT_CHARACTERISTIC_boot_keyboard_output_report.equals(aUUID)) {
			throw new IllegalArgumentException(
					"The provided uuid is uncompatible with this method");
		}

		int bootKeyboardInputReportValue = bundle.getInt(EXTRA_VALUE0);

		object.on_handle_boot_keyboard_output_report(bundle,
				bootKeyboardInputReportValue);
	}

	/**
	 * 
	 * 
	 * 
	 * @param bundle
	 * @param characteristic
	 * @return
	 */
	protected static int boot_mouse_input_report(Bundle bundle,
			BluetoothGattCharacteristic characteristic, int offset,
			int[] nextOffset) {
		// byte[] characteristicValue = characteristic.getValue();

		int bootMouseInputReportValue = characteristic.getIntValue(
				BluetoothGattCharacteristic.FORMAT_UINT8, offset);
		offset += UINT8_SIZE;
		bundle.putInt(EXTRA_VALUE0, bootMouseInputReportValue);
		bundle.putString(EXTRA_VALUE0_NAME, "Boot Mouse Input Report Value");
		bundle.putString(EXTRA_VALUE0_FORMAT, EXTRA_VALUE_int);

		nextOffset[0] = offset;
		return MSG_boot_mouse_input_report;
	}

	/**
	 * calls object.public void on_boot_mouse_input_report(Bundle bundle,int
	 * bootMouseInputReportValue);
	 * 
	 * 
	 * @param bundle
	 * @param object
	 * @throws IllegalArgumentException
	 */
	protected static void handle_boot_mouse_input_report(Bundle bundle,
			IBluetoothGattCharacteristicHandler object)
			throws IllegalArgumentException {
		String sUUID = bundle.getString(BluetoothDevice.EXTRA_UUID);
		UUID aUUID = UUID.fromString(sUUID);
		if (!GATT_CHARACTERISTIC_boot_mouse_input_report.equals(aUUID)) {
			throw new IllegalArgumentException(
					"The provided uuid is uncompatible with this method");
		}

		int bootMouseInputReportValue = bundle.getInt(EXTRA_VALUE0);

		object.on_boot_mouse_input_report(bundle, bootMouseInputReportValue);
	}

	protected static int csc_feature(Bundle bundle,
			BluetoothGattCharacteristic characteristic, int offset,
			int[] nextOffset) {
		// byte[] characteristicValue = characteristic.getValue();

		int cSCFeature = characteristic.getIntValue(
				BluetoothGattCharacteristic.FORMAT_UINT16, offset);
		offset += UINT16_SIZE;

		bundle.putInt(EXTRA_VALUE0, cSCFeature);
		bundle.putString(EXTRA_VALUE0_NAME, "CSC Feature Value");
		bundle.putString(EXTRA_VALUE0_FORMAT, EXTRA_VALUE_int);

		int[] _cSCFeature = new int[16];
		String[] _cSCFeatureComments = new String[16];
		for (int i = 0; i < 16; i++) {
			_cSCFeature[i] = (cSCFeature & 1 << i) >> 0;
			switch (i) {
			case 0:
				if (_cSCFeature[i] == 0) {
					_cSCFeatureComments[i] = "Wheel Revolution Data Supported : False";
				} else {
					_cSCFeatureComments[i] = "Wheel Revolution Data Supported : True";
				}
				break;
			case 1:
				if (_cSCFeature[i] == 0) {
					_cSCFeatureComments[i] = "Crank Revolution Data Supported: False";
				} else {
					_cSCFeatureComments[i] = "Crank Revolution Data Supported :True";
				}
				break;
			case 2:
				if (_cSCFeature[i] == 0) {
					_cSCFeatureComments[i] = "Multiple Sensor Locations Supported : False";
				} else {
					_cSCFeatureComments[i] = "Multiple Sensor Locations Supported : True";
				}
				break;

			}
		}
		bundle.putIntArray(EXTRA_VALUE1, _cSCFeature);
		bundle.putString(EXTRA_VALUE1_NAME, "CSC Feature bits");
		bundle.putString(EXTRA_VALUE1_FORMAT, EXTRA_VALUE_intArray);

		bundle.putStringArray(EXTRA_VALUE2, _cSCFeatureComments);
		bundle.putString(EXTRA_VALUE2_NAME, "CSC Feature bits comments");
		bundle.putString(EXTRA_VALUE2_FORMAT, EXTRA_VALUE_intArray);

		nextOffset[0] = offset;
		return MSG_csc_feature;
	}

	/**
	 * calls object.on_csc_feature(Bundle bundle,int cSCFeatureValue,int[]
	 * cSCFeatureBits,String[] cSCFeatureComments);
	 * 
	 * 
	 * @param bundle
	 * @param object
	 * @throws IllegalArgumentException
	 */
	protected static void handle_csc_feature(Bundle bundle,
			IBluetoothGattCharacteristicHandler object)
			throws IllegalArgumentException {
		String sUUID = bundle.getString(BluetoothDevice.EXTRA_UUID);
		UUID aUUID = UUID.fromString(sUUID);
		if (!GATT_CHARACTERISTIC_csc_feature.equals(aUUID)) {
			throw new IllegalArgumentException(
					"The provided uuid is uncompatible with this method");
		}

		int cSCFeatureValue = bundle.getInt(EXTRA_VALUE0);
		int[] cSCFeatureBits = bundle.getIntArray(EXTRA_VALUE1);
		String[] cSCFeatureComments = bundle.getStringArray(EXTRA_VALUE2);

		object.on_csc_feature(bundle, cSCFeatureValue, cSCFeatureBits,
				cSCFeatureComments);
	}

	/**
	 * 
	 * 
	 * 
	 * @param bundle
	 * @param characteristic
	 * @return
	 */
	protected static int csc_measurement(Bundle bundle,
			BluetoothGattCharacteristic characteristic, int offset,
			int[] nextOffset) {
		// byte[] characteristicValue = characteristic.getValue();

		int flags = characteristic.getIntValue(
				BluetoothGattCharacteristic.FORMAT_UINT8, offset);
		offset += UINT8_SIZE;
		int[] _flags = new int[8];
		String[] flagsComments = new String[8];
		for (int i = 0; i < 8; i++) {
			_flags[i] = (flags & 1 << i) >> i;
			switch (i) {
			case 0:
				flagsComments[i] = "Wheel Revolution Data Present : ";
				break;
			case 1:
				flagsComments[i] = "Crank Revolution Data Present : ";
				break;
			}
			if (_flags[i] == 0) {
				flagsComments[i] += "False";
			} else {
				flagsComments[i] += "True";
			}
		}

		bundle.putInt(EXTRA_VALUE0, flags);
		bundle.putString(EXTRA_VALUE0_NAME, "Flags");
		bundle.putString(EXTRA_VALUE0_FORMAT, EXTRA_VALUE_int);

		bundle.putIntArray(EXTRA_VALUE1, _flags);
		bundle.putString(EXTRA_VALUE1_NAME, "Array of Flags");
		bundle.putString(EXTRA_VALUE1_FORMAT, EXTRA_VALUE_intArray);

		bundle.putStringArray(EXTRA_VALUE2_FORMAT, flagsComments);
		bundle.putString(EXTRA_VALUE2_NAME, "Array of Flags comments");
		bundle.putString(EXTRA_VALUE2_FORMAT, EXTRA_VALUE_StringArray);

		int cumulativeWheelRevolutions = 0;
		if (_flags[0] == 1) {
			cumulativeWheelRevolutions = characteristic.getIntValue(
					BluetoothGattCharacteristic.FORMAT_UINT32, offset);
			offset += UINT32_SIZE;
		}
		bundle.putInt(EXTRA_VALUE3, cumulativeWheelRevolutions);
		bundle.putString(EXTRA_VALUE3_NAME, "Cumulative Wheel Revolutions");
		bundle.putString(EXTRA_VALUE3_FORMAT, EXTRA_VALUE_int);

		int lastWheelEventTime = 0;
		if (_flags[0] == 1) {
			lastWheelEventTime = characteristic.getIntValue(
					BluetoothGattCharacteristic.FORMAT_UINT16, offset);
			offset += UINT16_SIZE;
		}
		bundle.putInt(EXTRA_VALUE4, lastWheelEventTime);
		bundle.putString(EXTRA_VALUE4_NAME, "Last Wheel Event Time");
		bundle.putString(EXTRA_VALUE4_FORMAT, EXTRA_VALUE_int);

		int cumulativeCrankRevolutions = 0;
		if (_flags[1] == 1) {
			cumulativeCrankRevolutions = characteristic.getIntValue(
					BluetoothGattCharacteristic.FORMAT_UINT16, offset);
			offset += UINT16_SIZE;
		}
		bundle.putInt(EXTRA_VALUE5, cumulativeCrankRevolutions);
		bundle.putString(EXTRA_VALUE5_NAME, "Cumulative Crank Revolutions");
		bundle.putString(EXTRA_VALUE5_FORMAT, EXTRA_VALUE_int);

		int lastCrankEventTime = 0;
		if (_flags[1] == 1) {
			cumulativeCrankRevolutions = characteristic.getIntValue(
					BluetoothGattCharacteristic.FORMAT_UINT16, offset);
			offset += UINT16_SIZE;
		}
		bundle.putInt(EXTRA_VALUE6, lastCrankEventTime);
		bundle.putString(EXTRA_VALUE6_NAME, "Last Crank Event Time");
		bundle.putString(EXTRA_VALUE6_FORMAT, EXTRA_VALUE_int);

		nextOffset[0] = offset;
		return MSG_csc_measurement;
	}

	/**
	 * calls object.on_csc_measurement(Bundle bundle,int flags, int[]
	 * _flags,String[] flagsComments,int cumulativeWheelRevolutions, int
	 * lastWheelEventTime, int cumulativeCrankRevolutions,int
	 * lastCrankEventTime);
	 * 
	 * 
	 * @param bundle
	 * @param object
	 * @throws IllegalArgumentException
	 */
	protected static void handle_csc_measurement(Bundle bundle,
			IBluetoothGattCharacteristicHandler object)
			throws IllegalArgumentException {
		String sUUID = bundle.getString(BluetoothDevice.EXTRA_UUID);
		UUID aUUID = UUID.fromString(sUUID);
		if (!GATT_CHARACTERISTIC_csc_measurement.equals(aUUID)) {
			throw new IllegalArgumentException(
					"The provided uuid is uncompatible with this method");
		}

		int flags = bundle.getInt(EXTRA_VALUE0);
		int[] _flags = bundle.getIntArray(EXTRA_VALUE1);
		String[] flagsComments = bundle.getStringArray(EXTRA_VALUE2);
		int cumulativeWheelRevolutions = bundle.getInt(EXTRA_VALUE3);
		int lastWheelEventTime = bundle.getInt(EXTRA_VALUE4);
		int cumulativeCrankRevolutions = bundle.getInt(EXTRA_VALUE5);
		int lastCrankEventTime = bundle.getInt(EXTRA_VALUE6);

		object.on_csc_measurement(bundle, flags, _flags, flagsComments,
				cumulativeWheelRevolutions, lastWheelEventTime,
				cumulativeCrankRevolutions, lastCrankEventTime);

	}

	/**
	 * put extra values into bundle: EXTRA_VALUE0
	 * [yy,mm,dd,hh,mn,ss,dw,s/256,adjustReason]
	 * 
	 * @param bundle
	 * @param characteristic
	 * @return
	 */
	protected static int current_time(Bundle bundle,
			BluetoothGattCharacteristic characteristic, int offset,
			int[] nextOffset) {
		// byte[] characteristicValue = characteristic.getValue();

		int[] currentTime = new int[9];
		offset = getExactTime256(characteristic, currentTime, offset);
		int adjustReason = characteristic.getIntValue(
				BluetoothGattCharacteristic.FORMAT_UINT8, offset);
		currentTime[8] = adjustReason;
		bundle.putIntArray(EXTRA_VALUE0, currentTime);
		bundle.putString(EXTRA_VALUE0_NAME, "current time");
		bundle.putString(EXTRA_VALUE0_FORMAT, EXTRA_VALUE_StringArray);

		nextOffset[0] = offset;
		return MSG_current_time;
	}

	/**
	 * calls object.on_current_time(Bundle bundle,int yy,int mm,int dd, int hh,
	 * int mn, int ss,int dw,int s_256,int adjustReason);
	 * 
	 * 
	 * @param bundle
	 * @param object
	 * @throws IllegalArgumentException
	 */
	protected static void handle_current_time(Bundle bundle,
			IBluetoothGattCharacteristicHandler object)
			throws IllegalArgumentException {
		String sUUID = bundle.getString(BluetoothDevice.EXTRA_UUID);
		UUID aUUID = UUID.fromString(sUUID);
		if (!GATT_CHARACTERISTIC_current_time.equals(aUUID)) {
			throw new IllegalArgumentException(
					"The provided uuid is uncompatible with this method");
		}
		int[] currentTime = bundle.getIntArray(EXTRA_VALUE0);

		object.on_current_time(bundle, currentTime[0], currentTime[1],
				currentTime[2], currentTime[3], currentTime[4], currentTime[5],
				currentTime[6], currentTime[7], currentTime[8]);
	}

	/**
	 * caution have not been implemented Parameter Value because optional and
	 * variable Request Op Code Response Value Response Parameter
	 * 
	 * @param bundle
	 * @param characteristic
	 * @return
	 */
	protected static int cycling_power_control_point(Bundle bundle,
			BluetoothGattCharacteristic characteristic, int offset,
			int[] nextOffset) {
		// byte[] characteristicValue = characteristic.getValue();

		int opCodes = characteristic.getIntValue(
				BluetoothGattCharacteristic.FORMAT_UINT8, offset);
		offset += UINT8_SIZE;
		String opCodeValue;
		String opCodeDescription;
		switch (opCodes) {
		case 1:
			opCodeDescription = "Initiate the procedure to set a cumulative value. The new value is sent as parameter following op code (parameter defined per service). The response to this control point is Op Code 0x20 followed by the appropriate Response Value.";
			opCodeValue = "Set Cumulative Value";
			break;
		case 2:
			opCodeDescription = "Update to the location of the Sensor with the value sent as parameter to this op code. The response to this control point is Op Code 0x20 followed by the appropriate Response Value.";
			opCodeValue = "Update Sensor Location";
			break;
		case 3:
			opCodeDescription = "Request a list of supported locations where the Sensor can be attached. The response to this control point is Op Code 0x20 followed by the appropriate Response Value, including a list of supported Sensor locations in the Response Parameter.";
			opCodeValue = "Request Supported Sensor Locations";
			break;
		case 4:
			opCodeDescription = "nitiate the procedure to set the crank length value to Sensor. The new value is sent as a parameter with preceding Op Code 0x04 operand. The response to this control point is Op Code 0x20 followed by the appropriate Response Value.";
			opCodeValue = "Set Crank Length";
			break;
		case 5:
			opCodeDescription = "nitiate the procedure to set the crank length value to Sensor. The new value is sent as a parameter with preceding Op Code 0x04 operand. The response to this control point is Op Code 0x20 followed by the appropriate Response Value.";
			opCodeValue = "Request Crank Length";
			break;
		case 6:
			opCodeDescription = "Initiate the procedure to set the chain length value to Sensor. The new value is sent as a parameter with preceding Op Code 0x06 operand. The response to this control point is Op Code 0x20 followed by the appropriate Response Value.";
			opCodeValue = "Set Chain Length";
			break;
		case 7:
			opCodeDescription = "Request the current chain length value set in the Sensor. The response to this control point is Op Code 0x20 followed by the appropriate Response Value, including the value of the chain length in the Response Parameter.";
			opCodeValue = "Request Chain Length";
			break;
		case 8:
			opCodeDescription = "Initiate the procedure to set the chain weight value to Sensor. The new value is sent as a parameter with preceding Op Code 0x08 operand. The response to this control point is Op Code 0x20 followed by the appropriate Response Value.";
			opCodeValue = "Set Chain Weight";
			break;
		case 9:
			opCodeDescription = "Request the current chain weight value set in the Sensor. The response to this control point is Op Code 0x20 followed by the appropriate Response Value, including the value of the chain weight in the Response Parameter.";
			opCodeValue = "Request Chain Weight";
			break;
		case 10:
			opCodeDescription = "Initiate the procedure to set the span length value to Sensor. The new value is sent as a parameter with preceding Op Code 0x0A operand. The response to this control point is Op Code 0x20 followed by the appropriate Response Value.";
			opCodeValue = "Set Span Length";
			break;
		case 11:
			opCodeDescription = "Request the current span length value set in the Sensor. The response to this control point is Op Code 0x20 followed by the appropriate Response Value, including the value of the span length in the Response Parameter.";
			opCodeValue = "Request Span Length";
			break;
		case 12:
			opCodeDescription = "Starts the offset compensation process of the Sensor. The response to this control point is Op Code 0x20 followed by the appropriate Response Value, including the value of the raw force or a raw torque in the Response Parameter (defined per Service).";
			opCodeValue = "Start Offset Compensation";
			break;
		case 13:
			opCodeDescription = "Initiate the procedure to set the content of Cycling Power Measurement Characteristic. The response to this control point is Op Code 0x20 followed by the appropriate Response Value.";
			opCodeValue = "Mask Cycling Power Measurement Characteristic Content";
			break;
		case 14:
			opCodeDescription = "Request the sampling rate value set in the Sensor. The response to this control point is Op Code 0x20 followed by the appropriate Response Value, including the value of the sampling rate in the Response Parameter.";
			opCodeValue = "Request Sampling Rate";
			break;
		case 15:
			opCodeDescription = "Request the Factory calibration date set in the Sensor. The response to this control point is Op Code 0x20 followed by the appropriate Response Value, including the value of the Factory calibration date in the Response Parameter.";
			opCodeValue = "Request Factory Calibration Date";
			break;
		case 32:
			opCodeDescription = "The Response Code is followed by the Request Op Code, the Response Value and optionally, the Response Parameter.";
			opCodeValue = "Response Code";
			break;
		default:
			opCodeDescription = "Reserved For Future Use";
			opCodeValue = "Reserved For Future Use";
		}

		bundle.putInt(EXTRA_VALUE0, opCodes);
		bundle.putString(EXTRA_VALUE0_NAME, "Op Codes");
		bundle.putString(EXTRA_VALUE0_FORMAT, EXTRA_VALUE_int);

		bundle.putString(EXTRA_VALUE1, opCodeValue);
		bundle.putString(EXTRA_VALUE1_NAME, "Op Codes value");
		bundle.putString(EXTRA_VALUE1_FORMAT, EXTRA_VALUE_String);

		bundle.putString(EXTRA_VALUE2, opCodeDescription);
		bundle.putString(EXTRA_VALUE2_NAME, "Op Codes Description");
		bundle.putString(EXTRA_VALUE2_FORMAT, EXTRA_VALUE_String);

		nextOffset[0] = offset;
		return MSG_cycling_power_control_point;
	}

	protected static void handle_cycling_power_control_point(Bundle bundle,
			IBluetoothGattCharacteristicHandler object)
			throws IllegalArgumentException {
		String sUUID = bundle.getString(BluetoothDevice.EXTRA_UUID);
		UUID aUUID = UUID.fromString(sUUID);
		if (!GATT_CHARACTERISTIC_cycling_power_control_point.equals(aUUID)) {
			throw new IllegalArgumentException(
					"The provided uuid is uncompatible with this method");
		}

		int opCodes = bundle.getInt(EXTRA_VALUE0);
		String opCodeValue = bundle.getString(EXTRA_VALUE1);
		String opCodeDescription = bundle.getString(EXTRA_VALUE2);

		object.on_cycling_power_control_point(bundle, opCodes, opCodeValue,
				opCodeDescription);
	}

	/**
	 * @param bundle
	 * @param characteristic
	 * @return
	 */
	protected static int cycling_power_feature(Bundle bundle,
			BluetoothGattCharacteristic characteristic, int offset,
			int[] nextOffset) {
		// byte[] characteristicValue = characteristic.getValue();

		int cyclingPowerFeature = characteristic.getIntValue(
				BluetoothGattCharacteristic.FORMAT_UINT32, offset);
		offset += UINT32_SIZE;
		bundle.putInt(EXTRA_VALUE0, cyclingPowerFeature);
		bundle.putString(EXTRA_VALUE0_NAME, "Cycling Power Feature");
		bundle.putString(EXTRA_VALUE0_FORMAT, EXTRA_VALUE_int);

		nextOffset[0] = offset;
		return MSG_cycling_power_feature;
	}

	/**
	 * calls object.on_cycling_power_feature(Bundle bundle,int
	 * cyclingPowerFeature);
	 * 
	 * 
	 * @param bundle
	 * @param object
	 * @throws IllegalArgumentException
	 */
	protected static void handle_cycling_power_feature(Bundle bundle,
			IBluetoothGattCharacteristicHandler object)
			throws IllegalArgumentException {
		String sUUID = bundle.getString(BluetoothDevice.EXTRA_UUID);
		UUID aUUID = UUID.fromString(sUUID);
		if (!GATT_CHARACTERISTIC_cycling_power_feature.equals(aUUID)) {
			throw new IllegalArgumentException(
					"The provided uuid is uncompatible with this method");
		}

		int cyclingPowerFeature = bundle.getInt(EXTRA_VALUE0);

		object.on_cycling_power_feature(bundle, cyclingPowerFeature);

	}

	/**
	 * 
	 * 
	 * @param bundle
	 * @param characteristic
	 * @return
	 */
	protected static int cycling_power_vector(Bundle bundle,
			BluetoothGattCharacteristic characteristic, int offset,
			int[] nextOffset) {
		// byte[] characteristicValue = characteristic.getValue();

		int flags = characteristic.getIntValue(
				BluetoothGattCharacteristic.FORMAT_UINT8, offset);
		offset += UINT8_SIZE;

		bundle.putInt(EXTRA_VALUE0, flags);
		bundle.putString(EXTRA_VALUE0_NAME, "Flags");
		bundle.putString(EXTRA_VALUE0_FORMAT, EXTRA_VALUE_int);

		int crankRevolutionDataPresent = (flags & 1 << 0) >> 0;
		int firstCrankMeasurementAnglePresent = (flags & 1 << 1) >> 1;
		int instantaneousForceMagnitudeArrayPresent = (flags & 1 << 2) >> 2;
		int instantaneousTorqueMagnitudeArrayPresent = (flags & 1 << 3) >> 3;
		int instantaneousMeasurementDirection = (flags & 3 << 4) >> 4;

		int crankRevolutionData_CumulativeCrankRevolutions = 0;
		int crankRevolutionData_LastCrankEventTime = 0;
		if (crankRevolutionDataPresent == 1) {
			crankRevolutionData_CumulativeCrankRevolutions = characteristic
					.getIntValue(BluetoothGattCharacteristic.FORMAT_UINT16,
							offset);
			offset += UINT16_SIZE;
			crankRevolutionData_LastCrankEventTime = characteristic
					.getIntValue(BluetoothGattCharacteristic.FORMAT_UINT16,
							offset);
			offset += UINT16_SIZE;
		}

		int firstCrankMeasurementAngle = 0;
		if (firstCrankMeasurementAnglePresent == 1) {
			firstCrankMeasurementAngle = characteristic.getIntValue(
					BluetoothGattCharacteristic.FORMAT_UINT16, offset);
			offset += UINT16_SIZE;
		}

		bundle.putInt(EXTRA_VALUE1,
				crankRevolutionData_CumulativeCrankRevolutions);

		bundle.putInt(EXTRA_VALUE2, crankRevolutionData_LastCrankEventTime);

		bundle.putInt(EXTRA_VALUE3, firstCrankMeasurementAngle);

		int[] instantaneousForceMagnitudeArray = null;
		int instantaneousForceMagnitude = 0;
		int[] tmpArray;
		if (instantaneousForceMagnitudeArrayPresent == 1) {
			instantaneousForceMagnitudeArray = new int[0];
			try {
				while (true) {
					instantaneousForceMagnitude = characteristic.getIntValue(
							BluetoothGattCharacteristic.FORMAT_UINT16, offset);
					offset += UINT16_SIZE;
					tmpArray = new int[instantaneousForceMagnitudeArray.length + 1];
					System.arraycopy(instantaneousForceMagnitudeArray, 0,
							tmpArray, 0,
							instantaneousForceMagnitudeArray.length);
					instantaneousForceMagnitudeArray = tmpArray;
					instantaneousForceMagnitudeArray[instantaneousForceMagnitudeArray.length - 1] = instantaneousForceMagnitude;
				}
			} catch (Exception e) {

			}

		}

		int[] instantaneousTorqueMagnitudeArray = null;
		int instantaneousTorqueMagnitude = 0;
		if (instantaneousTorqueMagnitudeArrayPresent == 1) {
			instantaneousTorqueMagnitudeArray = new int[0];
			try {
				while (true) {
					instantaneousTorqueMagnitude = characteristic.getIntValue(
							BluetoothGattCharacteristic.FORMAT_UINT16, offset);
					offset += UINT16_SIZE;
					tmpArray = new int[instantaneousTorqueMagnitudeArray.length + 1];
					System.arraycopy(instantaneousTorqueMagnitudeArray, 0,
							tmpArray, 0,
							instantaneousTorqueMagnitudeArray.length);
					instantaneousTorqueMagnitudeArray = tmpArray;
					instantaneousTorqueMagnitudeArray[instantaneousTorqueMagnitudeArray.length - 1] = instantaneousTorqueMagnitude;
				}
			} catch (Exception e) {

			}
		}

		bundle.putIntArray(EXTRA_VALUE4, instantaneousForceMagnitudeArray);
		bundle.putIntArray(EXTRA_VALUE5, instantaneousTorqueMagnitudeArray);

		nextOffset[0] = offset;
		return MSG_cycling_power_vector;
	}

	/**
	 * 
	 * 
	 * 
	 * @param bundle
	 * @param object
	 * @throws IllegalArgumentException
	 */
	protected static void handle_cycling_power_vector(Bundle bundle,
			IBluetoothGattCharacteristicHandler object)
			throws IllegalArgumentException {
		String sUUID = bundle.getString(BluetoothDevice.EXTRA_UUID);
		UUID aUUID = UUID.fromString(sUUID);
		if (!GATT_CHARACTERISTIC_cycling_power_vector.equals(aUUID)) {
			throw new IllegalArgumentException(
					"The provided uuid is uncompatible with this method");
		}

		int flags = bundle.getInt(EXTRA_VALUE0);
		int crankRevolutionData_CumulativeCrankRevolutions = bundle
				.getInt(EXTRA_VALUE1);
		int crankRevolutionData_LastCrankEventTime = bundle
				.getInt(EXTRA_VALUE2);
		int firstCrankMeasurementAngle = bundle.getInt(EXTRA_VALUE3);
		int[] instantaneousForceMagnitudeArray = bundle
				.getIntArray(EXTRA_VALUE4);
		int[] instantaneousTorqueMagnitudeArray = bundle
				.getIntArray(EXTRA_VALUE5);

		object.on_cycling_power_vector(bundle, flags,
				crankRevolutionData_CumulativeCrankRevolutions,
				crankRevolutionData_LastCrankEventTime,
				firstCrankMeasurementAngle, instantaneousForceMagnitudeArray,
				instantaneousTorqueMagnitudeArray);
	}

	protected static int date_time(Bundle bundle,
			BluetoothGattCharacteristic characteristic, int offset,
			int[] nextOffset) {
		// byte[] characteristicValue = characteristic.getValue();

		int[] dateTimeArray = new int[6];
		offset = getDateTime(characteristic, dateTimeArray, offset);
		bundle.putIntArray(EXTRA_VALUE0, dateTimeArray);

		nextOffset[0] = offset;
		return MSG_date_time;
	}

	/**
	 * calls object on_date_time(Bundle bundle,int[]dateTimeArray);
	 * 
	 * 
	 * @param bundle
	 * @param object
	 * @throws IllegalArgumentException
	 */
	protected static void handle_date_time(Bundle bundle,
			IBluetoothGattCharacteristicHandler object)
			throws IllegalArgumentException {
		String sUUID = bundle.getString(BluetoothDevice.EXTRA_UUID);
		UUID aUUID = UUID.fromString(sUUID);
		if (!GATT_CHARACTERISTIC_date_time.equals(aUUID)) {
			throw new IllegalArgumentException(
					"The provided uuid is uncompatible with this method");
		}

		int[] dateTimeArray = bundle.getIntArray(EXTRA_VALUE0);

		Calendar calendar = dateValuesArrayAsCalendar(dateTimeArray);

		object.on_date_time(bundle, dateTimeArray, calendar);
	}

	protected static int day_date_time(Bundle bundle,
			BluetoothGattCharacteristic characteristic, int offset,
			int[] nextOffset) {
		// byte[] characteristicValue = characteristic.getValue();

		int[] dateTimeArray = new int[7];
		offset = getDayDateTime(characteristic, dateTimeArray, offset);

		bundle.putIntArray(EXTRA_VALUE0, dateTimeArray);

		nextOffset[0] = offset;
		return MSG_day_date_time;
	}

	protected static void handle_day_date_time(Bundle bundle,
			IBluetoothGattCharacteristicHandler object)
			throws IllegalArgumentException {
		String sUUID = bundle.getString(BluetoothDevice.EXTRA_UUID);
		UUID aUUID = UUID.fromString(sUUID);
		if (!GATT_CHARACTERISTIC_day_date_time.equals(aUUID)) {
			throw new IllegalArgumentException(
					"The provided uuid is uncompatible with this method");
		}

		int[] dayDateTimeArray = bundle.getIntArray(EXTRA_VALUE0);
		Calendar date = dateValuesArrayAsCalendar(dayDateTimeArray);

		object.on_day_date_time(bundle, dayDateTimeArray, date);
	}

	/**
	 * @param bundle
	 * @param characteristic
	 * @return
	 */
	protected static int day_of_week(Bundle bundle,
			BluetoothGattCharacteristic characteristic, int offset,
			int[] nextOffset) {
		// byte[] characteristicValue = characteristic.getValue();

		int dayOfWeek = characteristic.getIntValue(
				BluetoothGattCharacteristic.FORMAT_UINT8, offset);
		offset += UINT8_SIZE;
		bundle.putInt(EXTRA_VALUE0, dayOfWeek);

		nextOffset[0] = offset;
		return MSG_day_of_week;
	}

	/**
	 * calls object.on_day_of_week(Bundle bundle,int dayOfWeek);
	 * 
	 * 
	 * @param bundle
	 * @param object
	 * @throws IllegalArgumentException
	 */
	protected static void handle_day_of_week(Bundle bundle,
			IBluetoothGattCharacteristicHandler object)
			throws IllegalArgumentException {
		String sUUID = bundle.getString(BluetoothDevice.EXTRA_UUID);
		UUID aUUID = UUID.fromString(sUUID);
		if (!GATT_CHARACTERISTIC_day_of_week.equals(aUUID)) {
			throw new IllegalArgumentException(
					"The provided uuid is uncompatible with this method");
		}

		int dayOfWeek = bundle.getInt(EXTRA_VALUE0);

		object.on_day_of_week(bundle, dayOfWeek);
	}

	/**
	 * 
	 * 
	 * 
	 * @param bundle
	 * @param characteristic
	 * @return
	 */
	protected static int digital_input(Bundle bundle,
			BluetoothGattCharacteristic characteristic, int offset,
			int[] nextOffset) {
		// byte[] characteristicValue = characteristic.getValue();

		int[] digital_inputArray = new int[0];
		int bits = 0;
		int[] tmpArray;
		try {
			while (true) {
				bits = characteristic.getIntValue(
						BluetoothGattCharacteristic.FORMAT_UINT8, offset);
				offset += UINT8_SIZE;
				tmpArray = new int[digital_inputArray.length + 1];
				System.arraycopy(digital_inputArray, 0, tmpArray, 0,
						digital_inputArray.length);
				digital_inputArray = tmpArray;
				digital_inputArray[digital_inputArray.length - 1] = bits;
			}
		} catch (Exception e) {

		}
		int[] bitArray = new int[digital_inputArray.length * 8];
		int k = 0;
		int bit = 0;
		for (int i = 0; i < digital_inputArray.length; i++) {
			bits = digital_inputArray[i];
			for (int j = 0; j < 8; j++) {
				bit = (bits & 1 << j) >> j;
				bitArray[i * 8 + j] = bit;
			}
		}

		bundle.putIntArray(EXTRA_VALUE0, bitArray);

		nextOffset[0] = offset;
		return MSG_digital_input;
	}

	/**
	 * 
	 * 
	 * 
	 * @param bundle
	 * @param object
	 * @throws IllegalArgumentException
	 */
	protected static void handle_digital_input(Bundle bundle,
			IBluetoothGattCharacteristicHandler object)
			throws IllegalArgumentException {
		String sUUID = bundle.getString(BluetoothDevice.EXTRA_UUID);
		UUID aUUID = UUID.fromString(sUUID);
		if (!GATT_CHARACTERISTIC_digital_input.equals(aUUID)) {
			throw new IllegalArgumentException(
					"The provided uuid is uncompatible with this method");
		}

		int[] bitArray = bundle.getIntArray(EXTRA_VALUE0);

		object.on_digital_input(bundle, bitArray);
	}

	protected static int digital_output(Bundle bundle,
			BluetoothGattCharacteristic characteristic, int offset,
			int[] nextOffset) {
		byte[] characteristicValue = characteristic.getValue();

		int[] digital_inputArray = new int[0];
		int bits = 0;
		int[] tmpArray;
		try {
			while (true) {
				bits = characteristic.getIntValue(
						BluetoothGattCharacteristic.FORMAT_UINT8, offset);
				offset += UINT8_SIZE;
				tmpArray = new int[digital_inputArray.length + 1];
				System.arraycopy(digital_inputArray, 0, tmpArray, 0,
						digital_inputArray.length);
				digital_inputArray = tmpArray;
				digital_inputArray[digital_inputArray.length - 1] = bits;
			}
		} catch (Exception e) {

		}
		int[] bitArray = new int[digital_inputArray.length * 8];
		int k = 0;
		int bit = 0;
		for (int i = 0; i < digital_inputArray.length; i++) {
			bits = digital_inputArray[i];
			for (int j = 0; j < 8;) {
				bit = (bits & 3 << j * 2) >> j * 2;
				bitArray[i * 8 + k++] = bit;

				j += 2;
			}
		}

		bundle.putIntArray(EXTRA_VALUE0, bitArray);

		nextOffset[0] = offset;
		return MSG_digital_output;
	}

	/**
	 * 
	 * 
	 * @param bundle
	 * @param object
	 * @throws IllegalArgumentException
	 */
	protected static void handle_digital_output(Bundle bundle,
			IBluetoothGattCharacteristicHandler object)
			throws IllegalArgumentException {
		String sUUID = bundle.getString(BluetoothDevice.EXTRA_UUID);
		UUID aUUID = UUID.fromString(sUUID);
		if (!GATT_CHARACTERISTIC_digital_output.equals(aUUID)) {
			throw new IllegalArgumentException(
					"The provided uuid is uncompatible with this method");
		}

		int[] bitArray = bundle.getIntArray(EXTRA_VALUE0);

		object.on_digital_output(bundle, bitArray);
	}

	/**
	 * generated offset 8bits
	 * 
	 * @param bundle
	 * @param characteristic
	 * @param offset
	 * @return
	 */
	protected static int dst_offset(Bundle bundle,
			BluetoothGattCharacteristic characteristic, int offset,
			int[] nextOffset) {
		// byte[] characteristicValue = characteristic.getValue();

		int dSTOffset = characteristic.getIntValue(
				BluetoothGattCharacteristic.FORMAT_UINT8, offset);
		offset += UINT8_SIZE;
		String value;
		switch (dSTOffset) {
		case 0:
			value = "Standard Time";
			break;
		case 2:
			value = "Half An Hour Daylight Time (+0.5h)";
			break;
		case 4:
			value = "Daylight Time (+1h)";
			break;
		case 8:
			value = "Double Daylight Time (+2h)";
			break;
		case 255:
			value = "DST is not known";
		default:
			value = "Reserved";
		}

		bundle.putInt(EXTRA_VALUE0, dSTOffset);
		bundle.putString(EXTRA_VALUE1, value);

		nextOffset[0] = offset;
		return MSG_dst_offset;
	}

	/**
	 * calls object.on_dst_offset(Bundle bundle,int dSTOffset,String value);
	 * 
	 * 
	 * @param bundle
	 * @param object
	 * @throws IllegalArgumentException
	 */
	protected static void handle_dst_offset(Bundle bundle,
			IBluetoothGattCharacteristicHandler object)
			throws IllegalArgumentException {
		String sUUID = bundle.getString(BluetoothDevice.EXTRA_UUID);
		UUID aUUID = UUID.fromString(sUUID);
		if (!GATT_CHARACTERISTIC_dst_offset.equals(aUUID)) {
			throw new IllegalArgumentException(
					"The provided uuid is uncompatible with this method");
		}

		int dSTOffset = bundle.getInt(EXTRA_VALUE0);
		String value = bundle.getString(EXTRA_VALUE1);

		object.on_dst_offset(bundle, dSTOffset, value);
	}

	/**
	 * @param bundle
	 * @param characteristic
	 * @return
	 */
	protected static int exact_time_100(Bundle bundle,
			BluetoothGattCharacteristic characteristic, int offset,
			int[] nextOffset) {
		// byte[] characteristicValue = characteristic.getValue();

		int[] exacTime100 = new int[8];
		offset = getDayDateTime(characteristic, exacTime100, offset);

		exacTime100[7] = characteristic.getIntValue(
				BluetoothGattCharacteristic.FORMAT_UINT8, offset);
		offset += UINT8_SIZE;

		bundle.putIntArray(EXTRA_VALUE0, exacTime100);

		nextOffset[0] = offset;
		return MSG_exact_time_100;
	}

	/**
	 * calls object.on_exact_time_100(Bundle bundle,int[] exacTime100);
	 * 
	 * 
	 * @param bundle
	 * @param object
	 * @throws IllegalArgumentException
	 */
	protected static void handle_exact_time_100(Bundle bundle,
			IBluetoothGattCharacteristicHandler object)
			throws IllegalArgumentException {
		String sUUID = bundle.getString(BluetoothDevice.EXTRA_UUID);
		UUID aUUID = UUID.fromString(sUUID);
		if (!GATT_CHARACTERISTIC_exact_time_100.equals(aUUID)) {
			throw new IllegalArgumentException(
					"The provided uuid is uncompatible with this method");
		}

		int[] exacTime100 = bundle.getIntArray(EXTRA_VALUE0);

		object.on_exact_time_100(bundle, exacTime100);
	}

	protected static int exact_time_256(Bundle bundle,
			BluetoothGattCharacteristic characteristic, int offset,
			int[] nextOffset) {
		// byte[] characteristicValue = characteristic.getValue();

		int[] exacTime256 = new int[8];
		offset = getDayDateTime(characteristic, exacTime256, offset);

		exacTime256[7] = characteristic.getIntValue(
				BluetoothGattCharacteristic.FORMAT_UINT8, offset);
		offset += UINT8_SIZE;
		bundle.putIntArray(EXTRA_VALUE0, exacTime256);

		nextOffset[0] = offset;
		return MSG_exact_time_100;
	}

	/**
	 * calls object.on_exact_time_100(Bundle bundle,int[] exacTime100);
	 * 
	 * 
	 * @param bundle
	 * @param object
	 * @throws IllegalArgumentException
	 */
	protected static void handle_exact_time_256(Bundle bundle,
			IBluetoothGattCharacteristicHandler object)
			throws IllegalArgumentException {
		String sUUID = bundle.getString(BluetoothDevice.EXTRA_UUID);
		UUID aUUID = UUID.fromString(sUUID);
		if (!GATT_CHARACTERISTIC_exact_time_256.equals(aUUID)) {
			throw new IllegalArgumentException(
					"The provided uuid is uncompatible with this method");
		}

		int[] exacTime256 = bundle.getIntArray(EXTRA_VALUE0);

		object.on_exact_time_256(bundle, exacTime256);
	}

	/**
	 * @param bundle
	 * @param characteristic
	 * @return
	 */
	protected static int firmware_revision_string(Bundle bundle,
			BluetoothGattCharacteristic characteristic, int offset,
			int[] nextOffset) {
		byte[] characteristicValue = characteristic.getValue();

		String firmwareRevision = characteristic.getStringValue(offset);
		offset = characteristicValue.length;
		bundle.putString(EXTRA_VALUE0, firmwareRevision);

		nextOffset[0] = offset;
		return MSG_firmware_revision_string;
	}

	/**
	 * calls object.on_firmware_revision_string(Bundle bundle,String
	 * firmwareRevision);
	 * 
	 * 
	 * @param bundle
	 * @param object
	 * @throws IllegalArgumentException
	 */
	protected static void handle_firmware_revision_string(Bundle bundle,
			IBluetoothGattCharacteristicHandler object)
			throws IllegalArgumentException {
		String sUUID = bundle.getString(BluetoothDevice.EXTRA_UUID);
		UUID aUUID = UUID.fromString(sUUID);
		if (!GATT_CHARACTERISTIC_firmware_revision_string.equals(aUUID)) {
			throw new IllegalArgumentException(
					"The provided uuid is uncompatible with this method");
		}

		String firmwareRevision = bundle.getString(EXTRA_VALUE0);

		object.on_firmware_revision_string(bundle, firmwareRevision);
	}

	/**
	 * put extra values into bundle: EXTRA_VALUE0 appearance category format int
	 * EXTRA_VALUE1 subcategory format int
	 * 
	 * @param bundle
	 * @param characteristic
	 * @return response id to put in message.what
	 */
	protected static int gap_appearance(Bundle bundle,
			BluetoothGattCharacteristic characteristic, int offset,
			int[] nextOffset) {
		// byte[] characteristicValue = characteristic.getValue();

		int categoryAndSub = characteristic.getIntValue(
				BluetoothGattCharacteristic.FORMAT_UINT16, offset);
		int category = categoryAndSub >> 6;
		int subCategory = categoryAndSub & 63;

		bundle.putInt(EXTRA_VALUE0, category);
		bundle.putInt(EXTRA_VALUE1, subCategory);

		nextOffset[0] = offset;
		return MSG_gap_appearance;
	}

	/**
	 * calls object.on_gap_appearance(Bundle bundle,int category,int
	 * subCategory);
	 * 
	 * @param bundle
	 * @param object
	 * @throws IllegalArgumentException
	 */
	protected static void handle_gap_appearance(Bundle bundle,
			IBluetoothGattCharacteristicHandler object)
			throws IllegalArgumentException {
		String sUUID = bundle.getString(BluetoothDevice.EXTRA_UUID);
		UUID aUUID = UUID.fromString(sUUID);
		if (!GATT_CHARACTERISTIC_gap_appearance.equals(aUUID)) {
			throw new IllegalArgumentException(
					"The provided uuid is uncompatible with this method");
		}

		int category = bundle.getInt(EXTRA_VALUE0);
		int subCategory = bundle.getInt(EXTRA_VALUE1);

		object.on_gap_appearance(bundle, category, subCategory);
	}

	/**
	 * put extra values into bundle: EXTRA_VALUE0 : device name format String
	 * 
	 * @param bundle
	 * @param characteristic
	 * @return response id to put in message.what
	 */
	protected static int gap_device_name(Bundle bundle,
			BluetoothGattCharacteristic characteristic, int offset,
			int[] nextOffset) {
		byte[] characteristicValue = characteristic.getValue();

		String deviceName = characteristic.getStringValue(offset);
		nextOffset[0] = characteristicValue.length;
		bundle.putString(EXTRA_VALUE0, deviceName);

		nextOffset[0] = offset;
		return MSG_gap_device_name;
	}

	/**
	 * calls object.on_gap_device_name(Bundle bundle,String deviceName);
	 * 
	 * 
	 * @param bundle
	 * @param object
	 * @throws IllegalArgumentException
	 */
	protected static void handle_gap_device_name(Bundle bundle,
			IBluetoothGattCharacteristicHandler object)
			throws IllegalArgumentException {
		String sUUID = bundle.getString(BluetoothDevice.EXTRA_UUID);
		UUID aUUID = UUID.fromString(sUUID);
		if (!GATT_CHARACTERISTIC_gap_device_name.equals(aUUID)) {
			throw new IllegalArgumentException(
					"The provided uuid is uncompatible with this method");
		}

		String deviceName = bundle.getString(EXTRA_VALUE0);

		object.on_gap_device_name(bundle, deviceName);
	}

	/**
	 * 
	 * 
	 * @param bundle
	 * @param characteristic
	 * @return
	 */
	protected static int gap_peripheral_preferred_connection_parameters(
			Bundle bundle, BluetoothGattCharacteristic characteristic,
			int offset, int[] nextOffset) {
		// byte[] characteristicValue = characteristic.getValue();

		int minimumConnectionInterval = characteristic.getIntValue(
				BluetoothGattCharacteristic.FORMAT_UINT16, offset);
		offset += UINT16_SIZE;
		int maximumConnectionInterval = characteristic.getIntValue(
				BluetoothGattCharacteristic.FORMAT_UINT16, offset);
		offset += UINT16_SIZE;
		int slaveLatency = characteristic.getIntValue(
				BluetoothGattCharacteristic.FORMAT_UINT16, offset);
		offset += UINT16_SIZE;
		int connectionSupervisionTimeoutMultiplier = characteristic
				.getIntValue(BluetoothGattCharacteristic.FORMAT_UINT16, offset);
		offset += UINT16_SIZE;

		bundle.putInt(EXTRA_VALUE0, minimumConnectionInterval);
		bundle.putInt(EXTRA_VALUE1, maximumConnectionInterval);
		bundle.putInt(EXTRA_VALUE2, slaveLatency);
		bundle.putInt(EXTRA_VALUE3, connectionSupervisionTimeoutMultiplier);

		nextOffset[0] = offset;
		return MSG_gap_peripheral_preferred_connection_parameters;
	}

	/**
	 * @param bundle
	 * @param object
	 * @throws IllegalArgumentException
	 */
	protected static void handle_gap_peripheral_preferred_connection_parameters(
			Bundle bundle, IBluetoothGattCharacteristicHandler object)
			throws IllegalArgumentException {
		String sUUID = bundle.getString(BluetoothDevice.EXTRA_UUID);
		UUID aUUID = UUID.fromString(sUUID);
		if (!GATT_CHARACTERISTIC_gap_peripheral_preferred_connection_parameters
				.equals(aUUID)) {
			throw new IllegalArgumentException(
					"The provided uuid is uncompatible with this method");
		}

		int minimumConnectionInterval = bundle.getInt(EXTRA_VALUE0);
		int maximumConnectionInterval = bundle.getInt(EXTRA_VALUE1);
		int slaveLatency = bundle.getInt(EXTRA_VALUE3);
		int connectionSupervisionTimeoutMultiplier = bundle
				.getInt(EXTRA_VALUE4);

		object.on_gap_peripheral_preferred_connection_parameters(bundle,
				minimumConnectionInterval, maximumConnectionInterval,
				slaveLatency, connectionSupervisionTimeoutMultiplier);
	}

	/**
	 * @param bundle
	 * @param characteristic
	 * @return
	 */
	protected static int gap_peripheral_privacy_flag(Bundle bundle,
			BluetoothGattCharacteristic characteristic, int offset,
			int[] nextOffset) {
		// byte[] characteristicValue = characteristic.getValue();

		int flagi = characteristic.getIntValue(
				BluetoothGattCharacteristic.FORMAT_UINT8, offset);

		boolean flag = flagi == 0 ? false : true;

		String value = flag ? "privacy is disabled in this device"
				: "privacy is enabled in this device";

		bundle.putBoolean(EXTRA_VALUE0, flag);
		bundle.putString(EXTRA_VALUE1, value);

		nextOffset[0] = offset;
		return MSG_gap_peripheral_privacy_flag;
	}

	/**
	 * 
	 * calls object.public void on_gap_peripheral_privacy_flag( Bundle bundle,
	 * boolean flag, String value);
	 * 
	 * @param bundle
	 * @param object
	 * @throws IllegalArgumentException
	 */
	protected static void handle_gap_peripheral_privacy_flag(Bundle bundle,
			IBluetoothGattCharacteristicHandler object)
			throws IllegalArgumentException {
		String sUUID = bundle.getString(BluetoothDevice.EXTRA_UUID);
		UUID aUUID = UUID.fromString(sUUID);
		if (!GATT_CHARACTERISTIC_gap_peripheral_privacy_flag.equals(aUUID)) {
			throw new IllegalArgumentException(
					"The provided uuid is uncompatible with this method");
		}

		boolean flag = bundle.getBoolean(EXTRA_VALUE0);
		String value = bundle.getString(EXTRA_VALUE1);

		object.on_gap_peripheral_privacy_flag(bundle, flag, value);
	}

	/**
	 * 
	 * 
	 * @param bundle
	 * @param characteristic
	 * @return
	 */
	protected static int gap_reconnection_address(Bundle bundle,
			BluetoothGattCharacteristic characteristic, int offset,
			int[] nextOffset) {
		// byte[] characteristicValue = characteristic.getValue();

		int address = 0;
		int tmp;

		// we expect that the Octet Order from LSO to MSO, where LSO = Least
		// Significant Octet and MSO = Most Significant Octet.
		for (int i = 0; i < 6; i++) {
			tmp = characteristic.getIntValue(
					BluetoothGattCharacteristic.FORMAT_UINT8, offset);
			offset += UINT8_SIZE;
			address |= tmp << (i * 8);
		}

		bundle.putInt(EXTRA_VALUE0, address);

		nextOffset[0] = offset;
		return MSG_gap_reconnection_address;
	}

	/**
	 * 
	 * 
	 * @param bundle
	 * @param object
	 * @throws IllegalArgumentException
	 */
	protected static void handle_gap_reconnection_address(Bundle bundle,
			IBluetoothGattCharacteristicHandler object)
			throws IllegalArgumentException {
		String sUUID = bundle.getString(BluetoothDevice.EXTRA_UUID);
		UUID aUUID = UUID.fromString(sUUID);
		if (!GATT_CHARACTERISTIC_gap_reconnection_address.equals(aUUID)) {
			throw new IllegalArgumentException(
					"The provided uuid is uncompatible with this method");
		}

		int address = bundle.getInt(EXTRA_VALUE0);

		object.on_gap_reconnection_address(bundle, address);
	}

	/**
	 * 
	 * 
	 * @param bundle
	 * @param characteristic
	 * @return
	 */
	protected static int gatt_service_changed(Bundle bundle,
			BluetoothGattCharacteristic characteristic, int offset,
			int[] nextOffset) {
		// byte[] characteristicValue = characteristic.getValue();

		int startOfAffectedAttributeHandleRange = characteristic.getIntValue(
				BluetoothGattCharacteristic.FORMAT_UINT16, offset);
		offset += UINT16_SIZE;
		int endOfAffectedAttributeHandleRange = characteristic.getIntValue(
				BluetoothGattCharacteristic.FORMAT_UINT16, offset);
		offset += UINT16_SIZE;

		bundle.putInt(EXTRA_VALUE0, startOfAffectedAttributeHandleRange);
		bundle.putInt(EXTRA_VALUE1, endOfAffectedAttributeHandleRange);

		nextOffset[0] = offset;
		return MSG_gatt_service_changed;
	}

	/**
	 * calls object.on_gatt_service_changed(Bundle bundle,int
	 * startOfAffectedAttributeHandleRange, int
	 * endOfAffectedAttributeHandleRange);
	 * 
	 * 
	 * @param bundle
	 * @param object
	 * @throws IllegalArgumentException
	 */
	protected static void handle_gatt_service_changed(Bundle bundle,
			IBluetoothGattCharacteristicHandler object)
			throws IllegalArgumentException {
		String sUUID = bundle.getString(BluetoothDevice.EXTRA_UUID);
		UUID aUUID = UUID.fromString(sUUID);
		if (!GATT_CHARACTERISTIC_gatt_service_changed.equals(aUUID)) {
			throw new IllegalArgumentException(
					"The provided uuid is uncompatible with this method");
		}
		int startOfAffectedAttributeHandleRange = bundle.getInt(EXTRA_VALUE0);
		int endOfAffectedAttributeHandleRange = bundle.getInt(EXTRA_VALUE1);

		object.on_gatt_service_changed(bundle,
				startOfAffectedAttributeHandleRange,
				endOfAffectedAttributeHandleRange);
	}

	/**
	 * @param bundle
	 * @param characteristic
	 * @return
	 */
	protected static int glucose_feature(Bundle bundle,
			BluetoothGattCharacteristic characteristic, int offset,
			int[] nextOffset) {
		// byte[] characteristicValue = characteristic.getValue();

		int glucoseFeature = characteristic.getIntValue(
				BluetoothGattCharacteristic.FORMAT_UINT16, offset);
		offset += UINT16_SIZE;
		bundle.putInt(EXTRA_VALUE0, glucoseFeature);

		boolean[] _glucoseFeature = new boolean[16];
		for (int i = 0; i < 16; i++) {
			_glucoseFeature[i] = ((glucoseFeature & 1 << i) >> i) == 0 ? false
					: true;
		}

		String[] _glucoseFeatureValues = new String[16];
		_glucoseFeatureValues[0] = "Low Battery Detection During Measurement "
				+ (_glucoseFeature[0] ? "Not Supported" : "Supported");
		_glucoseFeatureValues[1] = "Sensor Malfunction Detection "
				+ (_glucoseFeature[1] ? "Not Supported" : "Supported");
		_glucoseFeatureValues[2] = "Sensor Sample Size "
				+ (_glucoseFeature[2] ? "Not Supported" : "Supported");
		_glucoseFeatureValues[3] = "Sensor Strip Insertion Error Detection "
				+ (_glucoseFeature[3] ? "Not Supported" : "Supported");
		_glucoseFeatureValues[4] = "Sensor Strip Type Error Detection "
				+ (_glucoseFeature[4] ? "Not Supported" : "Supported");
		_glucoseFeatureValues[5] = "Sensor Result High-Low Detection "
				+ (_glucoseFeature[5] ? "Not Supported" : "Supported");
		_glucoseFeatureValues[6] = "Sensor Temperature High-Low Detection "
				+ (_glucoseFeature[6] ? "Not Supported" : "Supported");
		_glucoseFeatureValues[7] = "Sensor Read Interrupt Detection "
				+ (_glucoseFeature[7] ? "Not Supported" : "Supported");
		_glucoseFeatureValues[8] = "General Device Fault "
				+ (_glucoseFeature[8] ? "Not Supported" : "Supported");
		_glucoseFeatureValues[9] = "Time Fault "
				+ (_glucoseFeature[9] ? "Not Supported" : "Supported");
		_glucoseFeatureValues[10] = "Multiple Bond "
				+ (_glucoseFeature[10] ? "Not Supported" : "Supported");
		_glucoseFeatureValues[11] = "ReservedForFutureUse";
		_glucoseFeatureValues[12] = "ReservedForFutureUse";
		_glucoseFeatureValues[13] = "ReservedForFutureUse";
		_glucoseFeatureValues[14] = "ReservedForFutureUse";
		_glucoseFeatureValues[15] = "ReservedForFutureUse";

		bundle.putInt(EXTRA_VALUE0, glucoseFeature);
		bundle.putBooleanArray(EXTRA_VALUE1, _glucoseFeature);
		bundle.putStringArray(EXTRA_VALUE2, _glucoseFeatureValues);

		nextOffset[0] = offset;
		return MSG_glucose_feature;
	}

	/**
	 * @param bundle
	 * @param object
	 * @throws IllegalArgumentException
	 */
	protected static void handle_glucose_feature(Bundle bundle,
			IBluetoothGattCharacteristicHandler object)
			throws IllegalArgumentException {
		String sUUID = bundle.getString(BluetoothDevice.EXTRA_UUID);
		UUID aUUID = UUID.fromString(sUUID);
		if (!GATT_CHARACTERISTIC_glucose_feature.equals(aUUID)) {
			throw new IllegalArgumentException(
					"The provided uuid is uncompatible with this method");
		}
		int glucoseFeature = bundle.getInt(EXTRA_VALUE0);
		boolean[] glucoseFeatures = bundle.getBooleanArray(EXTRA_VALUE1);
		String[] glucoseFeatureValues = bundle.getStringArray(EXTRA_VALUE2);

		object.on_glucose_feature(bundle, glucoseFeature, glucoseFeatures,
				glucoseFeatureValues);
	}

	protected static int glucose_measurement(Bundle bundle,
			BluetoothGattCharacteristic characteristic, int offset,
			int[] nextOffset) {
		// byte[] characteristicValue = characteristic.getValue();

		int flags = characteristic.getIntValue(
				BluetoothGattCharacteristic.FORMAT_UINT8, offset);
		offset += UINT8_SIZE;
		boolean timeOffsetPresent = ((flags & 1 << 0) >> 0 == 1);
		boolean glucoseConcentrationTypeAndSampleLocationPresent = ((flags & 1 << 1) >> 1 == 1);
		boolean glucoseConcentrationUnits = ((flags & 1 << 2) >> 2 == 1);
		boolean sensorStatusAnnunciationPresent = ((flags & 1 << 3) >> 3 == 1);
		boolean contextInformationFollows = ((flags & 1 << 4) >> 4 == 1);
		boolean reservedForFutureUse = ((flags & 1 << 5) >> 5 == 1);

		int sequenceNumber = characteristic.getIntValue(
				BluetoothGattCharacteristic.FORMAT_UINT16, offset);
		offset += UINT16_SIZE;

		int[] baseTime = new int[6];
		offset = getDateTime(characteristic, baseTime, offset);

		int timeOffset = 0;
		if (timeOffsetPresent) {
			timeOffset = characteristic.getIntValue(
					BluetoothGattCharacteristic.FORMAT_SINT16, offset);
			offset += SINT16_SIZE;
		}

		float glucoseConcentration_units_of_kg_per_L = 0;
		float glucoseConcentration_units_of_mol_per_L = 0;
		int type = 0;
		int sampleLocation = 0;
		if (glucoseConcentrationTypeAndSampleLocationPresent) {
			if (!glucoseConcentrationUnits) {
				glucoseConcentration_units_of_kg_per_L = characteristic
						.getFloatValue(
								BluetoothGattCharacteristic.FORMAT_SFLOAT,
								offset);
			} else {
				glucoseConcentration_units_of_kg_per_L = characteristic
						.getFloatValue(
								BluetoothGattCharacteristic.FORMAT_SFLOAT,
								offset);
			}
			offset += SFLOAT_SIZE;

			type = characteristic.getIntValue(
					BluetoothGattCharacteristic.FORMAT_UINT16, offset);
			offset += UINT16_SIZE;

			sampleLocation = characteristic.getIntValue(
					BluetoothGattCharacteristic.FORMAT_UINT16, offset);
			offset += UINT16_SIZE;
		}

		int sensorStatusAnnunciation = 0;
		if (sensorStatusAnnunciationPresent) {
			sensorStatusAnnunciation = characteristic.getIntValue(
					BluetoothGattCharacteristic.FORMAT_UINT16, offset);
			offset += UINT16_SIZE;
		}

		bundle.putInt(EXTRA_VALUE0, flags);
		bundle.putInt(EXTRA_VALUE1, sequenceNumber);
		bundle.putIntArray(EXTRA_VALUE2, baseTime);
		bundle.putInt(EXTRA_VALUE3, timeOffset);
		bundle.putFloat(EXTRA_VALUE4, glucoseConcentration_units_of_kg_per_L);
		bundle.putFloat(EXTRA_VALUE5, glucoseConcentration_units_of_mol_per_L);
		bundle.putInt(EXTRA_VALUE6, type);
		bundle.putInt(EXTRA_VALUE7, sampleLocation);
		bundle.putInt(EXTRA_VALUE8, sensorStatusAnnunciation);

		nextOffset[0] = offset;
		return MSG_glucose_measurement;
	}

	protected static void handle_glucose_measurement(Bundle bundle,
			IBluetoothGattCharacteristicHandler object)
			throws IllegalArgumentException {
		String sUUID = bundle.getString(BluetoothDevice.EXTRA_UUID);
		UUID aUUID = UUID.fromString(sUUID);
		if (!GATT_CHARACTERISTIC_glucose_measurement.equals(aUUID)) {
			throw new IllegalArgumentException(
					"The provided uuid is uncompatible with this method");
		}

		int flags = bundle.getInt(EXTRA_VALUE0);
		int sequenceNumber = bundle.getInt(EXTRA_VALUE1);
		int[] baseTime = bundle.getIntArray(EXTRA_VALUE2);
		int timeOffset = bundle.getInt(EXTRA_VALUE3);
		float glucoseConcentration_units_of_kg_per_L = bundle
				.getFloat(EXTRA_VALUE4);
		float glucoseConcentration_units_of_mol_per_L = bundle
				.getFloat(EXTRA_VALUE5);
		int type = bundle.getInt(EXTRA_VALUE6);
		int sampleLocation = bundle.getInt(EXTRA_VALUE7);
		;
		int sensorStatusAnnunciation = bundle.getInt(EXTRA_VALUE8);

		Calendar date = dateValuesArrayAsCalendar(baseTime);

		object.on_glucose_measurement(bundle, flags, sequenceNumber, date,
				timeOffset, glucoseConcentration_units_of_kg_per_L,
				glucoseConcentration_units_of_mol_per_L, type, sampleLocation,
				sensorStatusAnnunciation);
	}

	/**
	 * @param bundle
	 * @param characteristic
	 * @return
	 */
	protected static int glucose_measurement_context(Bundle bundle,
			BluetoothGattCharacteristic characteristic, int offset,
			int[] nextOffset) {
		// byte[] characteristicValue = characteristic.getValue();

		int flags = characteristic.getIntValue(
				BluetoothGattCharacteristic.FORMAT_UINT8, offset);
		offset += UINT8_SIZE;

		bundle.putInt(EXTRA_VALUE0, flags);

		int bitMaskAndShift = 0;
		int CarbohydrateIDAndCarbohydratePresent = (flags & 1 << bitMaskAndShift) >> bitMaskAndShift++;
		int MealPresent = (flags & 1 << bitMaskAndShift) >> bitMaskAndShift++;
		int Tester_HealthPresent = (flags & 1 << bitMaskAndShift) >> bitMaskAndShift++;
		int ExerciseDurationAndExerciseIntensityPresent = (flags & 1 << bitMaskAndShift) >> bitMaskAndShift++;
		int MedicationIDAndMedicationPresent = (flags & 1 << bitMaskAndShift) >> bitMaskAndShift++;
		int MedicationValueUnits = (flags & 1 << bitMaskAndShift) >> bitMaskAndShift++;
		int HbA1cPresent = (flags & 1 << bitMaskAndShift) >> bitMaskAndShift++;
		int ExtendedFlagsPresent = (flags & 1 << bitMaskAndShift) >> bitMaskAndShift++;

		bitMaskAndShift = 0;

		int sequenceNumber = characteristic.getIntValue(
				BluetoothGattCharacteristic.FORMAT_UINT16, offset);
		offset += UINT16_SIZE;
		bundle.putInt(EXTRA_VALUE1, sequenceNumber);

		int extendedFlags = 0;
		if (ExtendedFlagsPresent == 1) {
			extendedFlags = characteristic.getIntValue(
					BluetoothGattCharacteristic.FORMAT_UINT8, offset);
			offset += UINT8_SIZE;
		}
		bundle.putInt(EXTRA_VALUE2, extendedFlags);

		int carbohydrateID = 0;
		float carbohydrate_unitsofkilograms = Float.NaN;
		if (CarbohydrateIDAndCarbohydratePresent == 1) {
			characteristic.getIntValue(
					BluetoothGattCharacteristic.FORMAT_UINT8, offset);
			offset += UINT8_SIZE;

			carbohydrate_unitsofkilograms = characteristic.getFloatValue(
					BluetoothGattCharacteristic.FORMAT_SFLOAT, offset);
			offset += SFLOAT_SIZE;

		}
		bundle.putInt(EXTRA_VALUE3, carbohydrateID);
		bundle.putFloat(EXTRA_VALUE4, carbohydrate_unitsofkilograms);

		int meal = 0;
		if (MealPresent == 1) {
			meal = characteristic.getIntValue(
					BluetoothGattCharacteristic.FORMAT_UINT8, offset);
			offset += UINT8_SIZE;
		}
		bundle.putInt(EXTRA_VALUE5, meal);

		int tester = 0;
		int health = 0;
		if (Tester_HealthPresent == 1) {
			int doubleNibble = characteristic.getIntValue(
					BluetoothGattCharacteristic.FORMAT_UINT8, offset);
			offset += UINT8_SIZE;
			tester = doubleNibble & 0x0F;
			health = (doubleNibble & 0xF0) >> 4;
		}
		bundle.putInt(EXTRA_VALUE6, tester);
		bundle.putInt(EXTRA_VALUE7, health);

		int exerciseDuration = 0;
		int exerciseIntensity = 0;
		if (ExerciseDurationAndExerciseIntensityPresent == 1) {
			exerciseDuration = characteristic.getIntValue(
					BluetoothGattCharacteristic.FORMAT_UINT16, offset);
			offset += UINT16_SIZE;

			exerciseIntensity = characteristic.getIntValue(
					BluetoothGattCharacteristic.FORMAT_UINT8, offset);
			offset += UINT8_SIZE;
		}
		bundle.putInt(EXTRA_VALUE8, exerciseDuration);
		bundle.putInt(EXTRA_VALUE9, exerciseIntensity);

		int medicationID = 0;
		float medication_units = Float.NaN;
		if (MedicationIDAndMedicationPresent == 1) {
			medicationID = characteristic.getIntValue(
					BluetoothGattCharacteristic.FORMAT_UINT8, offset);
			offset += UINT8_SIZE;

			if (MedicationValueUnits == 0) {
				medication_units = characteristic.getIntValue(
						BluetoothGattCharacteristic.FORMAT_UINT16, offset);
				offset += UINT16_SIZE;
			} else {
				medication_units = characteristic.getIntValue(
						BluetoothGattCharacteristic.FORMAT_UINT16, offset);
				offset += UINT16_SIZE;
			}
		}

		bundle.putInt(EXTRA_VALUE10, medicationID);
		bundle.putFloat(EXTRA_VALUE11, medication_units);
		bundle.putInt(EXTRA_VALUE12, MedicationValueUnits);

		float hbA1c = Float.NaN;
		if (HbA1cPresent == 1) {
			hbA1c = characteristic.getIntValue(
					BluetoothGattCharacteristic.FORMAT_UINT16, offset);
			offset += UINT16_SIZE;
		}
		bundle.putFloat(EXTRA_VALUE13, hbA1c);

		nextOffset[0] = offset;
		return MSG_glucose_measurement_context;
	}

	/**
	 * @param bundle
	 * @param object
	 * @throws IllegalArgumentException
	 */
	protected static void handle_glucose_measurement_context(Bundle bundle,
			IBluetoothGattCharacteristicHandler object)
			throws IllegalArgumentException {
		String sUUID = bundle.getString(BluetoothDevice.EXTRA_UUID);
		UUID aUUID = UUID.fromString(sUUID);
		if (!GATT_CHARACTERISTIC_glucose_measurement_context.equals(aUUID)) {
			throw new IllegalArgumentException(
					"The provided uuid is uncompatible with this method");
		}

		int flags = bundle.getInt(EXTRA_VALUE0);
		int sequenceNumber = bundle.getInt(EXTRA_VALUE1);
		int extendedFlags = bundle.getInt(EXTRA_VALUE2);
		int carbohydrateID = bundle.getInt(EXTRA_VALUE3);
		float carbohydrate_unitsofkilograms = bundle.getFloat(EXTRA_VALUE4);
		int meal = bundle.getInt(EXTRA_VALUE5);
		int tester = bundle.getInt(EXTRA_VALUE6);
		int health = bundle.getInt(EXTRA_VALUE7);
		int exerciseDuration = bundle.getInt(EXTRA_VALUE8);
		int exerciseIntensity = bundle.getInt(EXTRA_VALUE9);
		int medicationID = bundle.getInt(EXTRA_VALUE10);
		float medication_units = bundle.getFloat(EXTRA_VALUE11);
		int MedicationValueUnits = bundle.getInt(EXTRA_VALUE12);
		float hbA1c = bundle.getFloat(EXTRA_VALUE13);

		object.on_glucose_measurement_context(bundle, flags, sequenceNumber,
				extendedFlags, carbohydrateID, carbohydrate_unitsofkilograms,
				meal, tester, health, exerciseDuration, exerciseIntensity,
				medicationID, medication_units, MedicationValueUnits, hbA1c);
	}

	protected static int hardware_revision_string(Bundle bundle,
			BluetoothGattCharacteristic characteristic, int offset,
			int[] nextOffset) {
		byte[] characteristicValue = characteristic.getValue();

		String hardwareRevision = characteristic.getStringValue(offset);
		offset = characteristicValue.length;
		bundle.putString(EXTRA_VALUE0, hardwareRevision);

		nextOffset[0] = offset;
		return MSG_hardware_revision_string;
	}

	protected static void handle_hardware_revision_string(Bundle bundle,
			IBluetoothGattCharacteristicHandler object)
			throws IllegalArgumentException {
		String sUUID = bundle.getString(BluetoothDevice.EXTRA_UUID);
		UUID aUUID = UUID.fromString(sUUID);
		if (!GATT_CHARACTERISTIC_hardware_revision_string.equals(aUUID)) {
			throw new IllegalArgumentException(
					"The provided uuid is uncompatible with this method");
		}
		String hardwareRevision = bundle.getString(EXTRA_VALUE0);
		object.on_hardware_revision_string(bundle, hardwareRevision);
	}

	protected static int heart_rate_control_point(Bundle bundle,
			BluetoothGattCharacteristic characteristic, int offset,
			int[] nextOffset) {
		// byte[] characteristicValue = characteristic.getValue();

		int heartRateControlPoint = characteristic.getIntValue(
				BluetoothGattCharacteristic.FORMAT_UINT8, offset);
		offset += UINT8_SIZE;
		bundle.putInt(EXTRA_VALUE0, heartRateControlPoint);

		nextOffset[0] = offset;
		return MSG_heart_rate_control_point;
	}

	protected static void handle_heart_rate_control_point(Bundle bundle,
			IBluetoothGattCharacteristicHandler object)
			throws IllegalArgumentException {
		String sUUID = bundle.getString(BluetoothDevice.EXTRA_UUID);
		UUID aUUID = UUID.fromString(sUUID);
		if (!GATT_CHARACTERISTIC_heart_rate_control_point.equals(aUUID)) {
			throw new IllegalArgumentException(
					"The provided uuid is uncompatible with this method");
		}

		int heartRateControlPoint = bundle.getInt(EXTRA_VALUE0);

		object.on_heart_rate_control_point(bundle, heartRateControlPoint);
	}

	/**
	 * put extra values into bundle: EXTRA_VALUE0 heart rate measurement value
	 * format int following values may not be filled depending on the remote
	 * device EXTRA_VALUE1 Energy Expended value format int kJoule or Joule :
	 * specification seems contradictory EXTRA_VALUE2 RR-Interval value format
	 * int you must use default value for those two values when you use
	 * bundle.getInt(EXTRA_VALUE1, defaultValue);
	 * 
	 * @param bundle
	 * @param characteristic
	 * @return response id to put in message.what
	 */
	protected static int heart_rate_measurement(Bundle bundle,
			BluetoothGattCharacteristic characteristic, int offset,
			int[] nextOffset) {
		// byte[] characteristicValue = characteristic.getValue();

		int flags = characteristic.getIntValue(
				BluetoothGattCharacteristic.FORMAT_UINT8, offset);
		offset += UINT8_SIZE;
		bundle.putInt(EXTRA_VALUE0, flags);

		/*
		 * Heart Rate Value Format bit 1 bit index= 0 0 Heart Rate Value Format
		 * is set to UINT8. Units: beats per minute (bpm) 1 Heart Rate Value
		 * Format is set to UINT16. Units: beats per minute (bpm)
		 */
		int heartRateValueFormatbit = flags & 0x01;

		/*
		 * Sensor Contact Status bits 2 bits index= 1 0 Sensor Contact feature
		 * is not supported in the current connection 1 Sensor Contact feature
		 * is not supported in the current connection 2 Sensor Contact feature
		 * is supported, but contact is not detected 3 Sensor Contact feature is
		 * supported and contact is detected
		 */
		int sensorContactStatusbits = flags & 0x06;
		sensorContactStatusbits = sensorContactStatusbits >> 1;
		bundle.putInt(EXTRA_VALUE1, sensorContactStatusbits);

		String sensorContactStatus = "";
		switch (sensorContactStatusbits) {
		case 0:
			sensorContactStatus = "Sensor Contact feature is not supported in the current connection";
			break;
		case 1:
			sensorContactStatus = "Sensor Contact feature is not supported in the current connection";
			break;
		case 2:
			sensorContactStatus = "Sensor Contact feature is supported, but contact is not detected";
			break;
		case 3:
			sensorContactStatus = "Sensor Contact feature is supported and contact is detected";
			break;
		}

		bundle.putString(EXTRA_VALUE2, sensorContactStatus);

		/*
		 * Energy Expended Status bit 1 bit index= 3 0 Energy Expended field is
		 * not present" 1 requires="C3" Energy Expended field is present. Units:
		 * kilo Joules"
		 */
		int energyExpendedStatusbit = flags & 0x08;
		energyExpendedStatusbit = energyExpendedStatusbit >> 3;
		/*
		 * RR-Interval bit" index="4" 1 bit 0 RR-Interval values are not present
		 * 1 requires="C4" One or more RR-Interval values are present. Units:
		 * 1/1024 seconds
		 */
		int rr_Intervalbit = flags & 0x10;
		rr_Intervalbit = rr_Intervalbit >> 4;

		/*
		 * ReservedForFutureUse index="5" size="3"
		 */
		int reservedForFutureUse = flags & 0xE0;
		reservedForFutureUse = reservedForFutureUse >> 5;

		int heartRateMeasurementValue = 0;
		offset += 1;
		if (heartRateValueFormatbit == 0) {
			heartRateMeasurementValue = characteristic.getIntValue(
					BluetoothGattCharacteristic.FORMAT_UINT8, offset);
			offset += UINT8_SIZE;
		} else if (heartRateValueFormatbit == 1) {
			heartRateMeasurementValue = characteristic.getIntValue(
					BluetoothGattCharacteristic.FORMAT_UINT16, offset);
			offset += UINT16_SIZE;
		}

		bundle.putInt(EXTRA_VALUE3, heartRateMeasurementValue);
		offset += 1 + heartRateValueFormatbit * 1;

		/*
		 * Energy Expended The presence of the Energy Expended field is
		 * dependent upon bit 3 of the Flags field. C3 uint16
		 */
		int energyExpended = 0;
		if (energyExpendedStatusbit == 1) {
			energyExpended = characteristic.getIntValue(
					BluetoothGattCharacteristic.FORMAT_UINT16, offset);
			offset += UINT16_SIZE;
		}
		bundle.putInt(EXTRA_VALUE4, energyExpended);

		/*
		 * RR-Interval The presence of the RR-Interval field is dependent upon
		 * bit 4 of the Flags field. The RR-Interval value represents the time
		 * between two R-Wave detections. Because several RR-Intervals may be
		 * measured between transmissions of the HEART RATE MEASUREMENT
		 * characteristic, multiple RR-Interval sub-fields may be present in the
		 * characteristic. The number of RR-Interval sub-fields present is
		 * determined by a combination of the overall length of the
		 * characteristic and whether or not the characteristic contains the
		 * Energy Expended field. Where there are multiple RR-Interval values
		 * transmitted in the HEART RATE MEASUREMENT characteristic, the field
		 * uses the following format: RR-Interval Value 0 (LSO...MSO),
		 * RR-Interval Value 1 (LSO...MSO), RR-Interval Value 2 (LSO...MSO),
		 * RR-Interval Value n (LSO...MSO). Where the RR-Interval Value 0 is
		 * older than the RR-Interval Value 1. RR-Interval Value 0 is
		 * transmitted first followed by the newer measurements. Requirement C4
		 * Format uint16
		 */
		int rr_Interval = 0;
		if (rr_Intervalbit == 1) {
			rr_Interval = characteristic.getIntValue(
					BluetoothGattCharacteristic.FORMAT_UINT16, offset);

			offset += UINT16_SIZE;
		}
		bundle.putInt(EXTRA_VALUE5, rr_Intervalbit);

		nextOffset[0] = offset;
		return MSG_heart_rate_measurement;
	}

	protected static void handle_heart_rate_measurement(Bundle bundle,
			IBluetoothGattCharacteristicHandler object)
			throws IllegalArgumentException {
		String sUUID = bundle.getString(BluetoothDevice.EXTRA_UUID);
		UUID aUUID = UUID.fromString(sUUID);
		if (!GATT_CHARACTERISTIC_heart_rate_measurement.equals(aUUID)) {
			throw new IllegalArgumentException(
					"The provided uuid is uncompatible with this method");
		}
		int flags = bundle.getInt(EXTRA_VALUE0);
		int sensorContactStatusbits = bundle.getInt(EXTRA_VALUE1);
		String sensorContactStatus = bundle.getString(EXTRA_VALUE2);
		int heartRateMeasurementValue = bundle.getInt(EXTRA_VALUE3);
		int energyExpended = bundle.getInt(EXTRA_VALUE4);
		int rr_Interval = bundle.getInt(EXTRA_VALUE5);

		object.on_heart_rate_measurement(bundle, flags,
				sensorContactStatusbits, sensorContactStatus,
				heartRateMeasurementValue, energyExpended, rr_Interval);

	}

	protected static int hid_control_point(Bundle bundle,
			BluetoothGattCharacteristic characteristic, int offset,
			int[] nextOffset) {
		// byte[] characteristicValue = characteristic.getValue();

		int HIDControlPointCommand = characteristic.getIntValue(
				BluetoothGattCharacteristic.FORMAT_UINT8, offset);
		offset += UINT8_SIZE;
		bundle.putInt(EXTRA_VALUE0, HIDControlPointCommand);

		nextOffset[0] = offset;
		return MSG_hid_control_point;
	}

	protected static void handle_hid_control_point(Bundle bundle,
			IBluetoothGattCharacteristicHandler object)
			throws IllegalArgumentException {
		String sUUID = bundle.getString(BluetoothDevice.EXTRA_UUID);
		UUID aUUID = UUID.fromString(sUUID);
		if (!GATT_CHARACTERISTIC_hid_control_point.equals(aUUID)) {
			throw new IllegalArgumentException(
					"The provided uuid is uncompatible with this method");
		}
		int hIDControlPointCommand = bundle.getInt(EXTRA_VALUE0);

		object.on_hid_control_point(bundle, hIDControlPointCommand);
	}

	protected static int hid_information(Bundle bundle,
			BluetoothGattCharacteristic characteristic, int offset,
			int[] nextOffset) {
		// byte[] characteristicValue = characteristic.getValue();

		int bcdHID = characteristic.getIntValue(
				BluetoothGattCharacteristic.FORMAT_UINT16, offset);
		offset += UINT16_SIZE;

		int bCountryCode = characteristic.getIntValue(
				BluetoothGattCharacteristic.FORMAT_UINT8, offset);
		offset += UINT8_SIZE;

		int flags = characteristic.getIntValue(
				BluetoothGattCharacteristic.FORMAT_UINT8, offset);
		offset += UINT8_SIZE;

		bundle.putInt(EXTRA_VALUE0, bcdHID);
		bundle.putInt(EXTRA_VALUE1, bCountryCode);
		bundle.putInt(EXTRA_VALUE2, flags);

		nextOffset[0] = offset;
		return MSG_hid_information;
	}

	protected static void handle_hid_information(Bundle bundle,
			IBluetoothGattCharacteristicHandler object)
			throws IllegalArgumentException {
		String sUUID = bundle.getString(BluetoothDevice.EXTRA_UUID);
		UUID aUUID = UUID.fromString(sUUID);
		if (!GATT_CHARACTERISTIC_hid_information.equals(aUUID)) {
			throw new IllegalArgumentException(
					"The provided uuid is uncompatible with this method");
		}

		int bcdHID = bundle.getInt(EXTRA_VALUE0);
		int bCountryCode = bundle.getInt(EXTRA_VALUE1);
		int flags = bundle.getInt(EXTRA_VALUE2);

		object.on_hid_information(bundle, bcdHID, bCountryCode, flags);
	}

	protected static int ieee_11073_20601_regulatory_certification_data_list(
			Bundle bundle, BluetoothGattCharacteristic characteristic,
			int offset, int[] nextOffset) {
		// byte[] characteristicValue = characteristic.getValue();

		IEEE_11073_20601_REGULATORY_CERTIFICATION_DATA_LIST list = new IEEE_11073_20601_REGULATORY_CERTIFICATION_DATA_LIST(
				characteristic, offset);
		offset = nextOffset[0];
		bundle.putAll(list.toBundle());

		nextOffset[0] = offset;
		return MSG_ieee_11073_20601_regulatory_certification_data_list;
	}

	protected static void handle_ieee_11073_20601_regulatory_certification_data_list(
			Bundle bundle, IBluetoothGattCharacteristicHandler object)
			throws IllegalArgumentException {
		String sUUID = bundle.getString(BluetoothDevice.EXTRA_UUID);
		UUID aUUID = UUID.fromString(sUUID);
		if (!GATT_CHARACTERISTIC_ieee_11073_20601_regulatory_certification_data_list
				.equals(aUUID)) {
			throw new IllegalArgumentException(
					"The provided uuid is uncompatible with this method");
		}

		IEEE_11073_20601_REGULATORY_CERTIFICATION_DATA_LIST list = new IEEE_11073_20601_REGULATORY_CERTIFICATION_DATA_LIST(
				bundle);

		object.on_handle_ieee_11073_20601_regulatory_certification_data_list(
				bundle, list);
	}

	protected static int intermediate_cuff_pressure(Bundle bundle,
			BluetoothGattCharacteristic characteristic, int offset,
			int[] nextOffset) {
		// byte[] characteristicValue = characteristic.getValue();

		blood_pressure_measurement(bundle, characteristic, offset, nextOffset);
		offset = nextOffset[0];

		nextOffset[0] = offset;
		return MSG_intermediate_cuff_pressure;
	}

	protected static void handle_intermediate_cuff_pressure(Bundle bundle,
			IBluetoothGattCharacteristicHandler object)
			throws IllegalArgumentException {
		String sUUID = bundle.getString(BluetoothDevice.EXTRA_UUID);
		UUID aUUID = UUID.fromString(sUUID);
		if (!GATT_CHARACTERISTIC_intermediate_cuff_pressure.equals(aUUID)) {
			throw new IllegalArgumentException(
					"The provided uuid is uncompatible with this method");
		}

		int[] flags = bundle.getIntArray(EXTRA_VALUE0);
		int units = flags[0];
		float systolic = bundle.getFloat(EXTRA_VALUE1);
		float diastolic = bundle.getFloat(EXTRA_VALUE2);
		float meanArterialPressure = bundle.getFloat(EXTRA_VALUE3);
		int[] date = bundle.getIntArray(EXTRA_VALUE4);
		float pulseRate = bundle.getFloat(EXTRA_VALUE5);
		int userID = bundle.getInt(EXTRA_VALUE6);
		int[] measurementStatusBits = bundle.getIntArray(EXTRA_VALUE7);
		String[] measurementStatusBitsComments = bundle
				.getStringArray(EXTRA_VALUE8);
		Calendar calendar = dateValuesArrayAsCalendar(date);

		object.on_intermediate_cuff_pressure(bundle, flags, units, systolic,
				diastolic, meanArterialPressure, date, calendar, pulseRate,
				userID, measurementStatusBits, measurementStatusBitsComments);
	}

	protected static int intermediate_temperature(Bundle bundle,
			BluetoothGattCharacteristic characteristic, int offset,
			int[] nextOffset) {
		// byte[] characteristicValue = characteristic.getValue();

		Bundle b0 = new Bundle();
		temperature_measurement(bundle, characteristic, offset, nextOffset);
		offset = nextOffset[0];

		bundle.putAll(b0);

		nextOffset[0] = offset;
		return MSG_intermediate_temperature;
	}

	protected static void handle_intermediate_temperature(Bundle bundle,
			IBluetoothGattCharacteristicHandler object)
			throws IllegalArgumentException {
		String sUUID = bundle.getString(BluetoothDevice.EXTRA_UUID);
		UUID aUUID = UUID.fromString(sUUID);
		if (!GATT_CHARACTERISTIC_intermediate_temperature.equals(aUUID)) {
			throw new IllegalArgumentException(
					"The provided uuid is uncompatible with this method");
		}

		int flags = bundle.getInt(EXTRA_VALUE0);
		float TemperatureMeasurementValue = bundle.getFloat(EXTRA_VALUE1);
		int TemperatureUnitFlag = bundle.getInt(EXTRA_VALUE2);
		int[] timeStamp = bundle.getIntArray(EXTRA_VALUE3);
		int temperatureType = bundle.getInt(EXTRA_VALUE4);
		String temperatureTypeString = bundle.getString(EXTRA_VALUE5);

		Calendar date = dateValuesArrayAsCalendar(timeStamp);

		object.on_intermediate_temperature(bundle, flags,
				TemperatureMeasurementValue, TemperatureUnitFlag, date,
				temperatureType, temperatureTypeString);

	}

	protected static int ln_control_point(Bundle bundle,
			BluetoothGattCharacteristic characteristic, int offset,
			int[] nextOffset) {
		byte[] characteristicValue = characteristic.getValue();

		int OpCodes = characteristic.getIntValue(
				BluetoothGattCharacteristic.FORMAT_UINT8, offset);
		offset += UINT8_SIZE;
		String OpCodeString;
		String OpCodeComment;
		switch (OpCodes) {
		case 0:
			OpCodeString = "Reserved for future use";
			OpCodeComment = "";
			break;
		case 1:
			OpCodeString = "Set Cumulative Value";
			OpCodeComment = "Initiate the procedure to set the cumulative value.The new value is sent as a parameter following op code. The response to this control point is Op Code 0x20 followed by the appropriate Response Value.";
			break;
		case 2:
			OpCodeString = "Mask Location and Speed Characteristic Content";
			OpCodeComment = "Initiate the procedure to set the content of Location and Speed Characteristic. The response to this control point is Op Code 0x20 followed by the appropriate Response Value.";
			break;
		case 3:
			OpCodeString = "Navigation Control";
			OpCodeComment = "Initiate the procedure to control navigation. The response to this control point is Op Code 0x20 followed by the appropriate Response Value.";
			break;
		case 4:
			OpCodeString = "Request Number of Routes";
			OpCodeComment = "Initiate the procedure to request the number of routes stored into the Sensor. The response to this control point is Op Code 0x20 followed by the appropriate Response Value, including the number of routes in the Response Parameter.";
			break;
		case 5:
			OpCodeString = "Request Name of Route";
			OpCodeComment = "Initiate the procedure to request the name of wanted route stored into the Sensor. The response to this control point is Op Code 0x20 followed by the appropriate Response Value,including the name of the route in the Response Parameter.";
			break;
		case 6:
			OpCodeString = "Select Route";
			OpCodeComment = "Initiate the procedure to select certain route to be used for navigation performed by the Sensor. The response to this control point is Op Code 0x20 followed by the appropriate Response Value.";
			break;
		case 7:
			OpCodeString = "Set Fix Rate";
			OpCodeComment = "Initiate the procedure to set the Sensor fix rate. The response to this control point is Op Code 0x20 followed by the appropriate Response Value.";
			break;
		case 8:
			OpCodeString = "Set Elevation";
			OpCodeComment = "Initiate the procedure to set the elevation value of the sensor (usually this procedure needed if barometric air pressure is used for elevation calculation and elevation needs calibration). The response to this control point is Op Code 0x20 followed by the appropriate Response Value.";
			break;
		case 32:
			OpCodeString = "Response Code";
			OpCodeComment = "The Response Code is followed by the Request Op Code, the Response Value and optionally, the Response Parameter.";
			break;
		default:
			OpCodeString = "Reserved for future use";
			OpCodeComment = "";
		}

		bundle.putInt(EXTRA_VALUE0, OpCodes);
		bundle.putString(EXTRA_VALUE1, OpCodeString);
		bundle.putString(EXTRA_VALUE2, OpCodeComment);

		int RequestOpCode = characteristic.getIntValue(
				BluetoothGattCharacteristic.FORMAT_UINT8, offset);
		offset += UINT8_SIZE;

		int ResponseValue = characteristic.getIntValue(
				BluetoothGattCharacteristic.FORMAT_UINT8, offset);
		offset += UINT8_SIZE;

		String ResponseValueString;
		String ResponseValueComment;
		switch (ResponseValue) {
		case 0:
			ResponseValueString = "Reserved for future use";
			ResponseValueComment = "Reserved for future use";
			break;
		case 1:
			ResponseValueString = "Success";
			ResponseValueComment = "Response for successful operation.";
			break;
		case 2:
			ResponseValueString = "Op Code not Supported";
			ResponseValueComment = "Response if unsupported Op Code is received.";
			break;
		case 3:
			ResponseValueString = "Invalid Parameter";
			ResponseValueComment = "Response if Parameter received does not meet the requirements of the service or is outside of the supported range of the Sensor.";
			break;
		case 4:
			ResponseValueString = "Operation Failed";
			ResponseValueComment = "Response if the requested procedure failed.";
			break;
		default:
			ResponseValueString = "Reserved for future use";
			ResponseValueComment = "Reserved for future use";
		}

		bundle.putInt(EXTRA_VALUE3, ResponseValue);
		bundle.putString(EXTRA_VALUE4, ResponseValueString);
		bundle.putString(EXTRA_VALUE5, ResponseValueComment);

		int[] ResponseParameter = new int[characteristicValue.length - offset];
		int i = 0;
		while (offset < characteristicValue.length) {
			ResponseParameter[i] = characteristic.getIntValue(
					BluetoothGattCharacteristic.FORMAT_UINT8, offset);
			offset += UINT8_SIZE;
		}

		bundle.putIntArray(EXTRA_VALUE6, ResponseParameter);

		nextOffset[0] = offset;
		return MSG_ln_control_point;
	}

	protected static void handle_ln_control_point(Bundle bundle,
			IBluetoothGattCharacteristicHandler object)
			throws IllegalArgumentException {
		String sUUID = bundle.getString(BluetoothDevice.EXTRA_UUID);
		UUID aUUID = UUID.fromString(sUUID);
		if (!GATT_CHARACTERISTIC_ln_control_point.equals(aUUID)) {
			throw new IllegalArgumentException(
					"The provided uuid is uncompatible with this method");
		}
		int OpCodes = bundle.getInt(EXTRA_VALUE0);
		String OpCodeString = bundle.getString(EXTRA_VALUE1);
		String OpCodeComment = bundle.getString(EXTRA_VALUE2);

		int ResponseValue = bundle.getInt(EXTRA_VALUE3);
		String ResponseValueString = bundle.getString(EXTRA_VALUE4);
		String ResponseValueComment = bundle.getString(EXTRA_VALUE5);
		int[] ResponseParameter = bundle.getIntArray(EXTRA_VALUE6);

		object.on_ln_control_point(bundle, OpCodes, OpCodeString,
				OpCodeComment, ResponseValue, ResponseValueString,
				ResponseValueComment, ResponseParameter);
	}

	protected static int ln_feature(Bundle bundle,
			BluetoothGattCharacteristic characteristic, int offset,
			int[] nextOffset) {
		// byte[] characteristicValue = characteristic.getValue();

		int LNFeature = characteristic.getIntValue(
				BluetoothGattCharacteristic.FORMAT_UINT32, offset);
		offset += UINT32_SIZE;

		String[] LNFeatureValues = new String[32];
		int bit = 0;
		LNFeatureValues[bit] = "Instantaneous Speed Supported" + " : "
				+ (((LNFeature & 1 << bit) >> bit++) == 1 ? "true" : "false");
		LNFeatureValues[bit] = "Total Distance Supported" + " : "
				+ (((LNFeature & 1 << bit) >> bit++) == 1 ? "true" : "false");
		LNFeatureValues[bit] = "Location Supported" + " : "
				+ (((LNFeature & 1 << bit) >> bit++) == 1 ? "true" : "false");
		LNFeatureValues[bit] = "Elevation Supported" + " : "
				+ (((LNFeature & 1 << bit) >> bit++) == 1 ? "true" : "false");
		LNFeatureValues[bit] = "Heading Supported" + " : "
				+ (((LNFeature & 1 << bit) >> bit++) == 1 ? "true" : "false");
		LNFeatureValues[bit] = "Rolling Time Supported" + " : "
				+ (((LNFeature & 1 << bit) >> bit++) == 1 ? "true" : "false");
		LNFeatureValues[bit] = "UTC Time Supported" + " : "
				+ (((LNFeature & 1 << bit) >> bit++) == 1 ? "true" : "false");
		LNFeatureValues[bit] = "Remaining Distance Supported" + " : "
				+ (((LNFeature & 1 << bit) >> bit++) == 1 ? "true" : "false");
		LNFeatureValues[bit] = "Remaining Vertical Distance Supported" + " : "
				+ (((LNFeature & 1 << bit) >> bit++) == 1 ? "true" : "false");
		LNFeatureValues[bit] = "Estimated Time of Arrival Supported" + " : "
				+ (((LNFeature & 1 << bit) >> bit++) == 1 ? "true" : "false");
		LNFeatureValues[bit] = "Number of Beacons in Solution Supported"
				+ " : "
				+ (((LNFeature & 1 << bit) >> bit++) == 1 ? "true" : "false");
		LNFeatureValues[bit] = "Number of Beacons in View Supported" + " : "
				+ (((LNFeature & 1 << bit) >> bit++) == 1 ? "true" : "false");
		LNFeatureValues[bit] = "Time to First Fix Supported" + " : "
				+ (((LNFeature & 1 << bit) >> bit++) == 1 ? "true" : "false");
		LNFeatureValues[bit] = "Estimated Horizontal Position Error Supported"
				+ " : "
				+ (((LNFeature & 1 << bit) >> bit++) == 1 ? "true" : "false");
		LNFeatureValues[bit] = "Estimated Vertical Position Error Supported"
				+ " : "
				+ (((LNFeature & 1 << bit) >> bit++) == 1 ? "true" : "false");
		LNFeatureValues[bit] = "Horizontal Dilution of Precision Supported"
				+ " : "
				+ (((LNFeature & 1 << bit) >> bit++) == 1 ? "true" : "false");
		LNFeatureValues[bit] = "Vertical Dilution of Precision Supported"
				+ " : "
				+ (((LNFeature & 1 << bit) >> bit++) == 1 ? "true" : "false");
		LNFeatureValues[bit] = "Location and Speed Characteristic Content Masking Supported"
				+ " : "
				+ (((LNFeature & 1 << bit) >> bit++) == 1 ? "true" : "false");
		LNFeatureValues[bit] = "Fix Rate Setting Supported" + " : "
				+ (((LNFeature & 1 << bit) >> bit++) == 1 ? "true" : "false");
		LNFeatureValues[bit] = "Elevation Setting Supported" + " : "
				+ (((LNFeature & 1 << bit) >> bit++) == 1 ? "true" : "false");
		LNFeatureValues[bit] = "Position Status Supported" + " : "
				+ (((LNFeature & 1 << bit) >> bit++) == 1 ? "true" : "false");

		LNFeatureValues[bit] = "Reserved for future use";

		bundle.putInt(EXTRA_VALUE0, LNFeature);
		bundle.putStringArray(EXTRA_VALUE1, LNFeatureValues);

		nextOffset[0] = offset;
		return MSG_ln_feature;
	}

	protected static void handle_ln_feature(Bundle bundle,
			IBluetoothGattCharacteristicHandler object)
			throws IllegalArgumentException {
		String sUUID = bundle.getString(BluetoothDevice.EXTRA_UUID);
		UUID aUUID = UUID.fromString(sUUID);
		if (!GATT_CHARACTERISTIC_ln_feature.equals(aUUID)) {
			throw new IllegalArgumentException(
					"The provided uuid is uncompatible with this method");
		}

		int LNFeature = bundle.getInt(EXTRA_VALUE0);
		String[] LNFeatureValues = bundle.getStringArray(EXTRA_VALUE1);

		object.on_ln_feature(bundle, LNFeature, LNFeatureValues);
	}

	protected static int local_time_information(Bundle bundle,
			BluetoothGattCharacteristic characteristic, int offset,
			int[] nextOffset) {
		// byte[] characteristicValue = characteristic.getValue();

		Bundle b0 = new Bundle();
		time_zone(b0, characteristic, offset, nextOffset);
		offset = nextOffset[0];

		int TimeZone = b0.getInt(EXTRA_VALUE0);
		String TimeZoneString = b0.getString(EXTRA_VALUE1);

		Bundle b1 = new Bundle();
		dst_offset(b1, characteristic, offset, nextOffset);
		offset = nextOffset[0];

		int dSTOffset = b1.getInt(EXTRA_VALUE0);
		String value = b1.getString(EXTRA_VALUE1);

		bundle.putInt(EXTRA_VALUE0, TimeZone);
		bundle.putString(EXTRA_VALUE1, TimeZoneString);
		bundle.putInt(EXTRA_VALUE2, dSTOffset);
		bundle.putString(EXTRA_VALUE3, value);

		nextOffset[0] = offset;
		return MSG_local_time_information;
	}

	protected static void handle_local_time_information(Bundle bundle,
			IBluetoothGattCharacteristicHandler object)
			throws IllegalArgumentException {
		String sUUID = bundle.getString(BluetoothDevice.EXTRA_UUID);
		UUID aUUID = UUID.fromString(sUUID);
		if (!GATT_CHARACTERISTIC_local_time_information.equals(aUUID)) {
			throw new IllegalArgumentException(
					"The provided uuid is uncompatible with this method");
		}

		int TimeZone = bundle.getInt(EXTRA_VALUE0);
		String TimeZoneString = bundle.getString(EXTRA_VALUE1);
		int dSTOffset = bundle.getInt(EXTRA_VALUE2);
		String value = bundle.getString(EXTRA_VALUE3);

		object.on_local_time_information(bundle, TimeZone, TimeZoneString,
				dSTOffset, value);
	}

	protected static int location_and_speed(Bundle bundle,
			BluetoothGattCharacteristic characteristic, int offset,
			int[] nextOffset) {
		// byte[] characteristicValue = characteristic.getValue();

		int flags = characteristic.getIntValue(
				BluetoothGattCharacteristic.FORMAT_UINT16, offset);
		offset += UINT16_SIZE;

		int bitShift = 0;
		int i = 0;
		String[] flagValues = new String[16];
		for (int j = 0; j < 16; j++) {
			flagValues[j] = "Reserved for future use";
		}

		flagValues[i++] = "Instantaneous Speed Present"
				+ " : "
				+ (((flags & 1 << bitShift) >> bitShift++) == 1 ? "true"
						: "false");
		flagValues[i++] = "Total Distance Present"
				+ " : "
				+ (((flags & 1 << bitShift) >> bitShift++) == 1 ? "true"
						: "false");
		flagValues[i++] = "Location Present"
				+ " : "
				+ (((flags & 1 << bitShift) >> bitShift++) == 1 ? "true"
						: "false");
		flagValues[i++] = "Elevation Present"
				+ " : "
				+ (((flags & 1 << bitShift) >> bitShift++) == 1 ? "true"
						: "false");
		flagValues[i++] = "Heading Present"
				+ " : "
				+ (((flags & 1 << bitShift) >> bitShift++) == 1 ? "true"
						: "false");
		flagValues[i++] = "Rolling Time Present"
				+ " : "
				+ (((flags & 1 << bitShift) >> bitShift++) == 1 ? "true"
						: "false");
		flagValues[i++] = "UTC Time Present"
				+ " : "
				+ (((flags & 1 << bitShift) >> bitShift++) == 1 ? "true"
						: "false");

		flagValues[i] = "Position Status" + " : ";
		switch ((flags & 3 << 7) >> 7) {
		case 0:
			flagValues[i] += "No Position";
			break;
		case 1:
			flagValues[i] += "Position Ok";
			break;
		case 2:
			flagValues[i] += "Estimated Position";
			break;
		case 3:
			flagValues[i] += "Last Known Position";
			break;

		}
		++i;
		bitShift = 9;
		flagValues[i++] = "Speed and Distance format" + " : "
				+ (((flags & 1 << bitShift) >> bitShift++) == 1 ? "3D" : "2D");

		flagValues[i] = "Elevation Source" + " : ";
		switch ((flags & 3 << 10) >> 10) {
		case 0:
			flagValues[i] += "Positioning System";
			break;
		case 1:
			flagValues[i] += "Barometric Air Pressure";
			break;
		case 2:
			flagValues[i] += "Database Service (or similiar)";
			break;
		case 3:
			flagValues[i] += "Other";
			break;

		}
		++i;
		bitShift = 12;
		flagValues[i++] = "Heading Source"
				+ " : "
				+ (((flags & 1 << bitShift) >> bitShift++) == 1 ? "Heading based on magnetic compass"
						: "Heading based on movement");

		int InstantaneousSpeed = Integer.MIN_VALUE;
		if (((flags & 1 << 0) >> 0) == 1) {
			InstantaneousSpeed = characteristic.getIntValue(
					BluetoothGattCharacteristic.FORMAT_UINT16, offset);
			offset += UINT16_SIZE;
		}

		int TotalDistance = Integer.MIN_VALUE;
		if (((flags & 1 << 1) >> 1) == 1) {
			TotalDistance = getINT(characteristic, 3, offset, nextOffset);
			offset = nextOffset[0];
		}

		int LocationLatitude = Integer.MIN_VALUE;
		int LocationLongitude = Integer.MIN_VALUE;
		if (((flags & 1 << 2) >> 2) == 1) {
			LocationLatitude = characteristic.getIntValue(
					BluetoothGattCharacteristic.FORMAT_SINT32, offset);
			offset += SINT32_SIZE;
			LocationLongitude = characteristic.getIntValue(
					BluetoothGattCharacteristic.FORMAT_SINT32, offset);
			offset += SINT32_SIZE;
		}

		int Elevation = Integer.MIN_VALUE;
		if (((flags & 1 << 3) >> 3) == 1) {
			Elevation = getINT(characteristic, FORMAT_SINT32, offset,
					nextOffset);
			offset = nextOffset[0];
		}

		int Heading = Integer.MIN_VALUE;
		if (((flags & 1 << 4) >> 4) == 1) {
			Heading = characteristic.getIntValue(
					BluetoothGattCharacteristic.FORMAT_UINT16, offset);
			offset += UINT16_SIZE;
		}

		int RollingTime = Integer.MIN_VALUE;
		if (((flags & 1 << 5) >> 5) == 1) {
			RollingTime = characteristic.getIntValue(
					BluetoothGattCharacteristic.FORMAT_UINT8, offset);
			offset += UINT8_SIZE;
		}

		int[] UTCTime;
		if (((flags & 1 << 5) >> 5) == 1) {
			Bundle b0 = new Bundle();
			date_time(b0, characteristic, offset, nextOffset);
			offset = nextOffset[0];

			UTCTime = b0.getIntArray(EXTRA_VALUE0);
		} else {
			UTCTime = timeNowAsIntArray();
		}

		bundle.putInt(EXTRA_VALUE0, flags);
		bundle.putStringArray(EXTRA_VALUE1, flagValues);
		bundle.putInt(EXTRA_VALUE2, InstantaneousSpeed);
		bundle.putInt(EXTRA_VALUE3, TotalDistance);
		bundle.putInt(EXTRA_VALUE4, LocationLatitude);
		bundle.putInt(EXTRA_VALUE5, LocationLongitude);
		bundle.putInt(EXTRA_VALUE6, Elevation);
		bundle.putInt(EXTRA_VALUE7, Heading);
		bundle.putInt(EXTRA_VALUE8, RollingTime);
		bundle.putIntArray(EXTRA_VALUE9, UTCTime);

		nextOffset[0] = offset;
		return MSG_location_and_speed;
	}

	protected static void handle_location_and_speed(Bundle bundle,
			IBluetoothGattCharacteristicHandler object)
			throws IllegalArgumentException {
		String sUUID = bundle.getString(BluetoothDevice.EXTRA_UUID);
		UUID aUUID = UUID.fromString(sUUID);
		if (!GATT_CHARACTERISTIC_location_and_speed.equals(aUUID)) {
			throw new IllegalArgumentException(
					"The provided uuid is uncompatible with this method");
		}
		int flags = bundle.getInt(EXTRA_VALUE0);
		String[] flagValues = bundle.getStringArray(EXTRA_VALUE1);
		int InstantaneousSpeed = bundle.getInt(EXTRA_VALUE2);
		int TotalDistance = bundle.getInt(EXTRA_VALUE3);
		int LocationLatitude = bundle.getInt(EXTRA_VALUE4);
		int LocationLongitude = bundle.getInt(EXTRA_VALUE5);
		int Elevation = bundle.getInt(EXTRA_VALUE6);
		int Heading = bundle.getInt(EXTRA_VALUE7);
		int RollingTime = bundle.getInt(EXTRA_VALUE8);
		int[] UTCTime = bundle.getIntArray(EXTRA_VALUE9);

		Calendar date_UTCTime = dateValuesArrayAsCalendar(UTCTime);

		object.on_location_and_speed(bundle, flags, flagValues,
				InstantaneousSpeed, TotalDistance, LocationLatitude,
				LocationLongitude, Elevation, Heading, RollingTime,
				date_UTCTime);
	}

	/**
	 * put extra values into bundle: EXTRA_VALUE0 manufacturer_name_string
	 * format String
	 * 
	 * @param bundle
	 * @param characteristic
	 * @return response id to put in message.what
	 */
	protected static int manufacturer_name_string(Bundle bundle,
			BluetoothGattCharacteristic characteristic, int offset,
			int[] nextOffset) {
		byte[] characteristicValue = characteristic.getValue();
		String manufacturer_name_string = characteristic.getStringValue(0);
		offset = characteristicValue.length;
		bundle.putString(EXTRA_VALUE0, manufacturer_name_string);

		nextOffset[0] = offset;
		return MSG_manufacturer_name_string;
	}

	protected static void handle_manufacturer_name_string(Bundle bundle,
			IBluetoothGattCharacteristicHandler object)
			throws IllegalArgumentException {
		String sUUID = bundle.getString(BluetoothDevice.EXTRA_UUID);
		UUID aUUID = UUID.fromString(sUUID);
		if (!GATT_CHARACTERISTIC_manufacturer_name_string.equals(aUUID)) {
			throw new IllegalArgumentException(
					"The provided uuid is uncompatible with this method");
		}
		String manufacturer_name_string = bundle.getString(EXTRA_VALUE0);
		object.on_manufacturer_name_string(bundle, manufacturer_name_string);
	}

	protected static int measurement_interval(Bundle bundle,
			BluetoothGattCharacteristic characteristic, int offset,
			int[] nextOffset) {
		// byte[] characteristicValue = characteristic.getValue();

		int MeasurementInterval = characteristic.getIntValue(
				BluetoothGattCharacteristic.FORMAT_UINT16, offset);

		bundle.putInt(EXTRA_VALUE0, MeasurementInterval);

		return MSG_measurement_interval;
	}

	protected static void handle_measurement_interval(Bundle bundle,
			IBluetoothGattCharacteristicHandler object)
			throws IllegalArgumentException {
		String sUUID = bundle.getString(BluetoothDevice.EXTRA_UUID);
		UUID aUUID = UUID.fromString(sUUID);
		if (!GATT_CHARACTERISTIC_measurement_interval.equals(aUUID)) {
			throw new IllegalArgumentException(
					"The provided uuid is uncompatible with this method");
		}
		int MeasurementInterval = bundle.getInt(EXTRA_VALUE0);

		object.on_measurement_interval(bundle, MeasurementInterval);
	}

	protected static int model_number_string(Bundle bundle,
			BluetoothGattCharacteristic characteristic, int offset,
			int[] nextOffset) {
		byte[] characteristicValue = characteristic.getValue();

		String model_number = characteristic.getStringValue(offset);
		offset = characteristicValue.length;

		bundle.putString(EXTRA_VALUE0, model_number);

		nextOffset[0] = offset;
		return MSG_model_number_string;
	}

	protected static void handle_model_number_string(Bundle bundle,
			IBluetoothGattCharacteristicHandler object)
			throws IllegalArgumentException {
		String sUUID = bundle.getString(BluetoothDevice.EXTRA_UUID);
		UUID aUUID = UUID.fromString(sUUID);
		if (!GATT_CHARACTERISTIC_model_number_string.equals(aUUID)) {
			throw new IllegalArgumentException(
					"The provided uuid is uncompatible with this method");
		}
		String model_number = bundle.getString(EXTRA_VALUE0);
		object.on_model_number_string(bundle, model_number);
	}

	protected static int navigation(Bundle bundle,
			BluetoothGattCharacteristic characteristic, int offset,
			int[] nextOffset) {
		// byte[] characteristicValue = characteristic.getValue();

		int flags = characteristic.getIntValue(
				BluetoothGattCharacteristic.FORMAT_UINT16, offset);
		offset += UINT16_SIZE;
		String[] FlagsValues = new String[16];
		int bitShift = 0;
		int i = 0;
		FlagsValues[i++] = "Remaining Distance Present"
				+ " : "
				+ ((bitShift & ((1 << bitShift) >> bitShift++)) == 0 ? "False"
						: "True");
		FlagsValues[i++] = "Remaining Vertical Distance Present"
				+ " : "
				+ ((bitShift & ((1 << bitShift) >> bitShift++)) == 0 ? "False"
						: "True");
		FlagsValues[i++] = "Estimated Time of Arrival Present"
				+ " : "
				+ ((bitShift & ((1 << bitShift) >> bitShift++)) == 0 ? "False"
						: "True");
		bitShift = 3;
		FlagsValues[3] = "Position Status : ";
		switch (flags & (3 << 0x02) >> 3) {
		case 0:
			FlagsValues[3] += "No Position";
			break;
		case 1:
			FlagsValues[3] += "Position Ok";
			break;
		case 2:
			FlagsValues[3] += "Estimated Position";
			break;
		case 3:
			FlagsValues[3] += "Last Known Position";
			break;
		}
		bitShift = 5;
		FlagsValues[i++] = "Heading Source"
				+ " : "
				+ ((bitShift & ((1 << bitShift) >> bitShift++)) == 0 ? "Heading based on movement"
						: "Heading based on magnetic compass");
		FlagsValues[i++] = "Navigation Indicator Type"
				+ " : "
				+ ((bitShift & ((1 << bitShift) >> bitShift++)) == 0 ? "To Waypoint"
						: "To Destination");
		FlagsValues[i++] = "Waypoint Reached"
				+ " : "
				+ ((bitShift & ((1 << bitShift) >> bitShift++)) == 0 ? "False"
						: "True");
		FlagsValues[i++] = "Destination Reached"
				+ " : "
				+ ((bitShift & ((1 << bitShift) >> bitShift++)) == 0 ? "False"
						: "True");
		while (i < 16) {
			FlagsValues[i++] = "Reserved for future use";
		}

		int Bearing = characteristic.getIntValue(
				BluetoothGattCharacteristic.FORMAT_UINT16, offset);
		offset += UINT16_SIZE;

		int Heading = characteristic.getIntValue(
				BluetoothGattCharacteristic.FORMAT_UINT16, offset);
		offset += UINT16_SIZE;

		int RemainingDistance = Integer.MIN_VALUE;
		if (((flags & 1 << 0) >> 0) == 1) {
			getINT(characteristic, FORMAT_UINT24, offset, nextOffset);
			offset = nextOffset[0];
		}

		int RemainingVerticalDistance = Integer.MIN_VALUE;
		if (((flags & 1 << 1) >> 1) == 1) {
			RemainingVerticalDistance = getINT(characteristic, FORMAT_SINT32,
					offset, nextOffset);
			offset = nextOffset[0];
		}

		int[] eta;
		if (((flags & 1 << 2) >> 2) == 1) {
			Bundle b0 = new Bundle();
			date_time(b0, characteristic, offset, nextOffset);
			offset = nextOffset[0];
			eta = b0.getIntArray(EXTRA_VALUE0);
		} else {
			eta = timeNowAsIntArray();
		}

		bundle.putInt(EXTRA_VALUE0, flags);
		bundle.putStringArray(EXTRA_VALUE1, FlagsValues);
		bundle.putInt(EXTRA_VALUE2, Bearing);
		bundle.putInt(EXTRA_VALUE3, Heading);
		bundle.putInt(EXTRA_VALUE4, RemainingDistance);
		bundle.putInt(EXTRA_VALUE5, RemainingVerticalDistance);
		bundle.putIntArray(EXTRA_VALUE6, eta);

		nextOffset[0] = offset;
		return MSG_navigation;
	}

	protected static void handle_navigation(Bundle bundle,
			IBluetoothGattCharacteristicHandler object)
			throws IllegalArgumentException {
		String sUUID = bundle.getString(BluetoothDevice.EXTRA_UUID);
		UUID aUUID = UUID.fromString(sUUID);
		if (!GATT_CHARACTERISTIC_navigation.equals(aUUID)) {
			throw new IllegalArgumentException(
					"The provided uuid is uncompatible with this method");
		}

		int flags = bundle.getInt(EXTRA_VALUE0);
		String[] FlagsValues = bundle.getStringArray(EXTRA_VALUE1);
		int Bearing = bundle.getInt(EXTRA_VALUE2);
		int Heading = bundle.getInt(EXTRA_VALUE3);
		int RemainingDistance = bundle.getInt(EXTRA_VALUE4);
		int RemainingVerticalDistance = bundle.getInt(EXTRA_VALUE5);
		int[] eta = bundle.getIntArray(EXTRA_VALUE6);
		Calendar estimatedTimeOfArrival =dateValuesArrayAsCalendar(eta);

		object.on_navigation(bundle, flags, FlagsValues, Bearing, Heading,
				RemainingDistance, RemainingVerticalDistance, estimatedTimeOfArrival);
	}

	protected static int new_alert(Bundle bundle,
			BluetoothGattCharacteristic characteristic, int offset,
			int[] nextOffset) {
		// byte[] characteristicValue = characteristic.getValue();

		Bundle b0 = new Bundle();
		alert_category_id(b0, characteristic, offset, nextOffset);
		offset = nextOffset[0];
		int CategoryID = bundle.getInt(EXTRA_VALUE0);

		int NumberofNewAlert = characteristic.getIntValue(
				BluetoothGattCharacteristic.FORMAT_UINT8, offset);
		offset += UINT8_SIZE;

		String TextStringInformation = characteristic.getStringValue(offset);

		bundle.putInt(EXTRA_VALUE0, NumberofNewAlert);
		bundle.putString(EXTRA_VALUE1, TextStringInformation);

		nextOffset[0] = offset;
		return MSG_new_alert;
	}

	private static void handle_new_alert(Bundle bundle,
			IBluetoothGattCharacteristicHandler object)
			throws IllegalArgumentException {
		String sUUID = bundle.getString(BluetoothDevice.EXTRA_UUID);
		UUID aUUID = UUID.fromString(sUUID);
		if (!GATT_CHARACTERISTIC_new_alert.equals(aUUID)) {
			throw new IllegalArgumentException(
					"The provided uuid is uncompatible with this method");
		}

		int NumberofNewAlert = bundle.getInt(EXTRA_VALUE0);
		String TextStringInformation = bundle.getString(EXTRA_VALUE1);

		object.on_new_alert(bundle, NumberofNewAlert, TextStringInformation);
	}

	protected static int pnp_id(Bundle bundle,
			BluetoothGattCharacteristic characteristic, int offset,
			int[] nextOffset) {
		// byte[] characteristicValue = characteristic.getValue();

		int VendorIDSource = characteristic.getIntValue(
				BluetoothGattCharacteristic.FORMAT_UINT8, offset);
		offset += UINT8_SIZE;
		int VendorID = characteristic.getIntValue(
				BluetoothGattCharacteristic.FORMAT_UINT16, offset);
		offset += UINT16_SIZE;
		int ProductID = characteristic.getIntValue(
				BluetoothGattCharacteristic.FORMAT_UINT16, offset);
		offset += UINT16_SIZE;
		int ProductVersion = characteristic.getIntValue(
				BluetoothGattCharacteristic.FORMAT_UINT16, offset);
		offset += UINT16_SIZE;

		bundle.putInt(EXTRA_VALUE0, VendorIDSource);
		bundle.putInt(EXTRA_VALUE1, VendorID);
		bundle.putInt(EXTRA_VALUE2, ProductID);
		bundle.putInt(EXTRA_VALUE3, ProductVersion);

		nextOffset[0] = offset;
		return MSG_pnp_id;
	}

	protected static void handle_pnp_id(Bundle bundle,
			IBluetoothGattCharacteristicHandler object)
			throws IllegalArgumentException {
		String sUUID = bundle.getString(BluetoothDevice.EXTRA_UUID);
		UUID aUUID = UUID.fromString(sUUID);
		if (!GATT_CHARACTERISTIC_pnp_id.equals(aUUID)) {
			throw new IllegalArgumentException(
					"The provided uuid is uncompatible with this method");
		}
		int VendorIDSource = bundle.getInt(EXTRA_VALUE0);
		int VendorID = bundle.getInt(EXTRA_VALUE1);
		int ProductID = bundle.getInt(EXTRA_VALUE2);
		int ProductVersion = bundle.getInt(EXTRA_VALUE3);

		object.on_pnp_id(bundle, VendorIDSource, VendorID, ProductID,
				ProductVersion);
	}

	protected static int position_quality(Bundle bundle,
			BluetoothGattCharacteristic characteristic, int offset,
			int[] nextOffset) {
		// byte[] characteristicValue = characteristic.getValue();

		int Flags = characteristic.getIntValue(
				BluetoothGattCharacteristic.FORMAT_UINT16, offset);
		offset += UINT16_SIZE;
		int bitShift = 0;
		int NumberofBeaconsinSolution = 0;
		int NumberofBeaconsinView = 0;
		int TimetoFirstFix = 0;
		int EHPE = 0;
		int EVPE = 0;
		int HDOP = 0;
		int VDOP = 0;
		if (((Flags & 1 << bitShift) >> bitShift++) == 1) {
			NumberofBeaconsinSolution = characteristic.getIntValue(
					BluetoothGattCharacteristic.FORMAT_UINT8, offset);
			offset += UINT8_SIZE;
		}
		if (((Flags & 1 << bitShift) >> bitShift++) == 1) {
			NumberofBeaconsinView = characteristic.getIntValue(
					BluetoothGattCharacteristic.FORMAT_UINT8, offset);
			offset += UINT8_SIZE;
		}
		if (((Flags & 1 << bitShift) >> bitShift++) == 1) {
			TimetoFirstFix = characteristic.getIntValue(
					BluetoothGattCharacteristic.FORMAT_UINT16, offset);
			offset += UINT16_SIZE;
		}
		if (((Flags & 1 << bitShift) >> bitShift++) == 1) {
			EHPE = characteristic.getIntValue(
					BluetoothGattCharacteristic.FORMAT_UINT32, offset);
			offset += UINT32_SIZE;
		}
		if (((Flags & 1 << bitShift) >> bitShift++) == 1) {
			EVPE = characteristic.getIntValue(
					BluetoothGattCharacteristic.FORMAT_UINT32, offset);
			offset += UINT32_SIZE;
		}
		if (((Flags & 1 << bitShift) >> bitShift++) == 1) {
			HDOP = characteristic.getIntValue(
					BluetoothGattCharacteristic.FORMAT_UINT8, offset);
			offset += UINT8_SIZE;
		}
		if (((Flags & 1 << bitShift) >> bitShift++) == 1) {
			VDOP = characteristic.getIntValue(
					BluetoothGattCharacteristic.FORMAT_UINT8, offset);
			offset += UINT8_SIZE;
		}

		bundle.putInt(EXTRA_VALUE0, Flags);
		bundle.putInt(EXTRA_VALUE1, NumberofBeaconsinSolution);
		bundle.putInt(EXTRA_VALUE2, NumberofBeaconsinView);
		bundle.putInt(EXTRA_VALUE3, TimetoFirstFix);
		bundle.putInt(EXTRA_VALUE4, EHPE);
		bundle.putInt(EXTRA_VALUE5, EVPE);
		bundle.putInt(EXTRA_VALUE6, HDOP);
		bundle.putInt(EXTRA_VALUE7, VDOP);

		nextOffset[0] = offset;
		return MSG_position_quality;
	}

	protected static void handle_position_quality(Bundle bundle,
			IBluetoothGattCharacteristicHandler object)
			throws IllegalArgumentException {
		String sUUID = bundle.getString(BluetoothDevice.EXTRA_UUID);
		UUID aUUID = UUID.fromString(sUUID);
		if (!GATT_CHARACTERISTIC_position_quality.equals(aUUID)) {
			throw new IllegalArgumentException(
					"The provided uuid is uncompatible with this method");
		}
		int Flags = bundle.getInt(EXTRA_VALUE0);
		int NumberofBeaconsinSolution = bundle.getInt(EXTRA_VALUE1);
		int NumberofBeaconsinView = bundle.getInt(EXTRA_VALUE2);
		int TimetoFirstFix = bundle.getInt(EXTRA_VALUE3);
		int EHPE = bundle.getInt(EXTRA_VALUE4);
		int EVPE = bundle.getInt(EXTRA_VALUE5);
		int HDOP = bundle.getInt(EXTRA_VALUE6);
		int VDOP = bundle.getInt(EXTRA_VALUE7);

		object.on_position_quality(bundle, Flags, NumberofBeaconsinSolution,
				NumberofBeaconsinView, TimetoFirstFix, EHPE, EVPE, HDOP, VDOP);
	}

	protected static int protocol_mode(Bundle bundle,
			BluetoothGattCharacteristic characteristic, int offset,
			int[] nextOffset) {
		// byte[] characteristicValue = characteristic.getValue();

		int ProtocolModeValue = characteristic.getIntValue(
				BluetoothGattCharacteristic.FORMAT_UINT8, offset);
		offset += UINT8_SIZE;

		bundle.putInt(EXTRA_VALUE0, ProtocolModeValue);

		nextOffset[0] = offset;
		return MSG_protocol_mode;
	}

	protected static void handle_protocol_mode(Bundle bundle,
			IBluetoothGattCharacteristicHandler object)
			throws IllegalArgumentException {
		String sUUID = bundle.getString(BluetoothDevice.EXTRA_UUID);
		UUID aUUID = UUID.fromString(sUUID);
		if (!GATT_CHARACTERISTIC_protocol_mode.equals(aUUID)) {
			throw new IllegalArgumentException(
					"The provided uuid is uncompatible with this method");
		}
		int ProtocolModeValue = bundle.getInt(EXTRA_VALUE0);

		object.on_protocol_mode(bundle, ProtocolModeValue);
	}

	/**
	 * built with version 0.5 similar to pulse_oximetry_continuous_measurement
	 * 
	 * @param bundle
	 * @param characteristic
	 * @param offset
	 * @param nextOffset
	 * @return
	 */
	protected static int pulse_oximetry_continuous_measurement(Bundle bundle,
			BluetoothGattCharacteristic characteristic, int offset,
			int[] nextOffset) {
		// byte[] characteristicValue = characteristic.getValue();
		int Flags = 0;
		int MeasurementStatus = 0;
		int DeviceandSensorStatus = 15;
		int ThresholdStatus = 7;

		Flags = characteristic.getIntValue(
				BluetoothGattCharacteristic.FORMAT_UINT8, offset);
		offset += UINT8_SIZE;

		if (((Flags & 1 << 2) >> 2) == 1) {
			MeasurementStatus = characteristic.getIntValue(
					BluetoothGattCharacteristic.FORMAT_UINT16, offset);
			offset += UINT16_SIZE;
		}
		if (((Flags & 1 << 3) >> 3) == 1) {
			DeviceandSensorStatus = characteristic.getIntValue(
					BluetoothGattCharacteristic.FORMAT_UINT16, offset);
			offset += UINT16_SIZE;
		}

		if (((Flags & 1 << 5) >> 5) == 1) {
			ThresholdStatus = characteristic.getIntValue(
					BluetoothGattCharacteristic.FORMAT_UINT8, offset);
			offset += UINT8_SIZE;
		}

		bundle.putInt(EXTRA_VALUE0, Flags);
		bundle.putInt(EXTRA_VALUE1, MeasurementStatus);
		bundle.putInt(EXTRA_VALUE2, DeviceandSensorStatus);
		bundle.putInt(EXTRA_VALUE3, ThresholdStatus);

		nextOffset[0] = offset;
		return MSG_pulse_oximetry_continuous_measurement;
	}

	protected static void handle_pulse_oximetry_continuous_measurement(
			Bundle bundle, IBluetoothGattCharacteristicHandler object)
			throws IllegalArgumentException {
		String sUUID = bundle.getString(BluetoothDevice.EXTRA_UUID);
		UUID aUUID = UUID.fromString(sUUID);
		if (!GATT_CHARACTERISTIC_pulse_oximetry_continuous_measurement
				.equals(aUUID)) {
			throw new IllegalArgumentException(
					"The provided uuid is uncompatible with this method");
		}
		int Flags = bundle.getInt(EXTRA_VALUE0);
		int MeasurementStatus = bundle.getInt(EXTRA_VALUE1);
		int DeviceandSensorStatus = bundle.getInt(EXTRA_VALUE2);
		int ThresholdStatus = bundle.getInt(EXTRA_VALUE3);

		object.on_pulse_oximetry_continuous_measurement(bundle, Flags,
				MeasurementStatus, DeviceandSensorStatus, ThresholdStatus);
	}

	/**
	 * built with version 0.5 similar to pulse_oximetry_continuous_measurement
	 * 
	 * @param bundle
	 * @param characteristic
	 * @param offset
	 * @param nextOffset
	 * @return
	 */
	protected static int pulse_oximetry_control_point(Bundle bundle,
			BluetoothGattCharacteristic characteristic, int offset,
			int[] nextOffset) {
		// byte[] characteristicValue = characteristic.getValue();

		int Flags = 0;
		int MeasurementStatus = 0;
		int DeviceandSensorStatus = 15;
		int ThresholdStatus = 7;

		Flags = characteristic.getIntValue(
				BluetoothGattCharacteristic.FORMAT_UINT8, offset);
		offset += UINT8_SIZE;

		if (((Flags & 1 << 2) >> 2) == 1) {
			MeasurementStatus = characteristic.getIntValue(
					BluetoothGattCharacteristic.FORMAT_UINT16, offset);
			offset += UINT16_SIZE;
		}
		if (((Flags & 1 << 3) >> 3) == 1) {
			DeviceandSensorStatus = characteristic.getIntValue(
					BluetoothGattCharacteristic.FORMAT_UINT16, offset);
			offset += UINT16_SIZE;
		}

		if (((Flags & 1 << 5) >> 5) == 1) {
			ThresholdStatus = characteristic.getIntValue(
					BluetoothGattCharacteristic.FORMAT_UINT8, offset);
			offset += UINT8_SIZE;
		}

		bundle.putInt(EXTRA_VALUE0, Flags);
		bundle.putInt(EXTRA_VALUE1, MeasurementStatus);
		bundle.putInt(EXTRA_VALUE2, DeviceandSensorStatus);
		bundle.putInt(EXTRA_VALUE3, ThresholdStatus);

		nextOffset[0] = offset;
		return MSG_pulse_oximetry_control_point;
	}

	protected static void handle_pulse_oximetry_control_point(Bundle bundle,
			IBluetoothGattCharacteristicHandler object)
			throws IllegalArgumentException {
		String sUUID = bundle.getString(BluetoothDevice.EXTRA_UUID);
		UUID aUUID = UUID.fromString(sUUID);
		if (!GATT_CHARACTERISTIC_pulse_oximetry_control_point.equals(aUUID)) {
			throw new IllegalArgumentException(
					"The provided uuid is uncompatible with this method");
		}
		int Flags = bundle.getInt(EXTRA_VALUE0);
		int MeasurementStatus = bundle.getInt(EXTRA_VALUE1);
		int DeviceandSensorStatus = bundle.getInt(EXTRA_VALUE2);
		int ThresholdStatus = bundle.getInt(EXTRA_VALUE3);

		object.on_pulse_oximetry_control_point(bundle, Flags,
				MeasurementStatus, DeviceandSensorStatus, ThresholdStatus);
	}

	/**
	 * not implemented
	 * 
	 * @param bundle
	 * @param characteristic
	 * @param offset
	 * @param nextOffset
	 * @return
	 */
	protected static int pulse_oximetry_features(Bundle bundle,
			BluetoothGattCharacteristic characteristic, int offset,
			int[] nextOffset) {
		// byte[] characteristicValue = characteristic.getValue();

		int Flags = 0;
		int ConfigurationSupport = 7;
		int MeasurementStatusSupport = 15;
		int DeviceandSensorStatus = 15;
		int SpotCheckOperatingMode = 7;
		int ContinuousMeasurementOperatingModeSupport = 7;

		Flags = characteristic.getIntValue(
				BluetoothGattCharacteristic.FORMAT_UINT8, offset);
		offset += UINT8_SIZE;

		ConfigurationSupport = characteristic.getIntValue(
				BluetoothGattCharacteristic.FORMAT_UINT8, offset);
		offset += UINT8_SIZE;

		if (((Flags & 1 << 0) >> 0) == 1) {
			MeasurementStatusSupport = characteristic.getIntValue(
					BluetoothGattCharacteristic.FORMAT_UINT16, offset);
			offset += UINT16_SIZE;
		}

		if (((Flags & 1 << 1) >> 1) == 1) {
			DeviceandSensorStatus = characteristic.getIntValue(
					BluetoothGattCharacteristic.FORMAT_UINT16, offset);
			offset += UINT16_SIZE;
		}

		if (((Flags & 1 << 2) >> 2) == 1) {
			SpotCheckOperatingMode = characteristic.getIntValue(
					BluetoothGattCharacteristic.FORMAT_UINT8, offset);
			offset += UINT8_SIZE;
		}

		if (((Flags & 1 << 3) >> 3) == 1) {
			ContinuousMeasurementOperatingModeSupport = characteristic
					.getIntValue(BluetoothGattCharacteristic.FORMAT_UINT8,
							offset);
			offset += UINT8_SIZE;
		}

		bundle.putInt(EXTRA_VALUE0, Flags);
		bundle.putInt(EXTRA_VALUE1, ConfigurationSupport);
		bundle.putInt(EXTRA_VALUE2, MeasurementStatusSupport);
		bundle.putInt(EXTRA_VALUE3, DeviceandSensorStatus);
		bundle.putInt(EXTRA_VALUE3, SpotCheckOperatingMode);
		bundle.putInt(EXTRA_VALUE3, ContinuousMeasurementOperatingModeSupport);

		nextOffset[0] = offset;
		return MSG_pulse_oximetry_features;
	}

	protected static void handle_pulse_oximetry_features(Bundle bundle,
			IBluetoothGattCharacteristicHandler object)
			throws IllegalArgumentException {
		String sUUID = bundle.getString(BluetoothDevice.EXTRA_UUID);
		UUID aUUID = UUID.fromString(sUUID);
		if (!GATT_CHARACTERISTIC_pulse_oximetry_features.equals(aUUID)) {
			throw new IllegalArgumentException(
					"The provided uuid is uncompatible with this method");
		}

		int Flags = bundle.getInt(EXTRA_VALUE0);
		int ConfigurationSupport = bundle.getInt(EXTRA_VALUE1);
		int MeasurementStatusSupport = bundle.getInt(EXTRA_VALUE2);
		int DeviceandSensorStatus = bundle.getInt(EXTRA_VALUE3);
		int SpotCheckOperatingMode = bundle.getInt(EXTRA_VALUE4);
		int ContinuousMeasurementOperatingModeSupport = bundle
				.getInt(EXTRA_VALUE5);

		object.on_pulse_oximetry_features(bundle, Flags, ConfigurationSupport,
				MeasurementStatusSupport, DeviceandSensorStatus,
				SpotCheckOperatingMode,
				ContinuousMeasurementOperatingModeSupport);
	}

	/**
	 * 
	 * 
	 * @param bundle
	 * @param characteristic
	 * @param offset
	 * @param nextOffset
	 * @return
	 */
	protected static int pulse_oximetry_pulsatile_event(Bundle bundle,
			BluetoothGattCharacteristic characteristic, int offset,
			int[] nextOffset) {
		// byte[] characteristicValue = characteristic.getValue();

		int Flags = 0;
		int PulseFlags = 0;

		Flags = characteristic.getIntValue(
				BluetoothGattCharacteristic.FORMAT_UINT8, offset);
		offset += UINT8_SIZE;
		PulseFlags = characteristic.getIntValue(
				BluetoothGattCharacteristic.FORMAT_UINT8, offset);
		offset += UINT8_SIZE;

		bundle.putInt(EXTRA_VALUE0, Flags);
		bundle.putInt(EXTRA_VALUE1, PulseFlags);

		nextOffset[0] = offset;
		return MSG_pulse_oximetry_pulsatile_event;
	}

	protected static void handle_pulse_oximetry_pulsatile_event(Bundle bundle,
			IBluetoothGattCharacteristicHandler object)
			throws IllegalArgumentException {
		String sUUID = bundle.getString(BluetoothDevice.EXTRA_UUID);
		UUID aUUID = UUID.fromString(sUUID);
		if (!GATT_CHARACTERISTIC_pulse_oximetry_pulsatile_event.equals(aUUID)) {
			throw new IllegalArgumentException(
					"The provided uuid is uncompatible with this method");
		}
		int Flags = bundle.getInt(EXTRA_VALUE0);
		int PulseFlags = bundle.getInt(EXTRA_VALUE1);

		object.on_pulse_oximetry_pulsatile_event(bundle, Flags, PulseFlags);
	}

	/**
	 * not implemented
	 * 
	 * @param bundle
	 * @param characteristic
	 * @param offset
	 * @param nextOffset
	 * @return
	 */
	protected static int pulse_oximetry_spot_check_measurement(Bundle bundle,
			BluetoothGattCharacteristic characteristic, int offset,
			int[] nextOffset) {
		// byte[] characteristicValue = characteristic.getValue();
		int Flags = 0;
		int MeasurementStatus = 0;
		int DeviceandSensorStatus = 15;

		Flags = characteristic.getIntValue(
				BluetoothGattCharacteristic.FORMAT_UINT8, offset);
		offset += UINT8_SIZE;

		if (((Flags & 1 << 0) >> 0) == 1) {
			MeasurementStatus = characteristic.getIntValue(
					BluetoothGattCharacteristic.FORMAT_UINT16, offset);
			offset += UINT16_SIZE;
		}
		if (((Flags & 1 << 1) >> 1) == 1) {
			DeviceandSensorStatus = characteristic.getIntValue(
					BluetoothGattCharacteristic.FORMAT_UINT16, offset);
			offset += UINT16_SIZE;
		}

		bundle.putInt(EXTRA_VALUE0, Flags);
		bundle.putInt(EXTRA_VALUE1, MeasurementStatus);
		bundle.putInt(EXTRA_VALUE2, DeviceandSensorStatus);

		nextOffset[0] = offset;
		return MSG_pulse_oximetry_spot_check_measurement;
	}

	protected static void handle_pulse_oximetry_spot_check_measurement(
			Bundle bundle, IBluetoothGattCharacteristicHandler object)
			throws IllegalArgumentException {
		String sUUID = bundle.getString(BluetoothDevice.EXTRA_UUID);
		UUID aUUID = UUID.fromString(sUUID);
		if (!GATT_CHARACTERISTIC_pulse_oximetry_spot_check_measurement
				.equals(aUUID)) {
			throw new IllegalArgumentException(
					"The provided uuid is uncompatible with this method");
		}

		int Flags = bundle.getInt(EXTRA_VALUE0);
		int MeasurementStatus = bundle.getInt(EXTRA_VALUE1);
		int DeviceandSensorStatus = bundle.getInt(EXTRA_VALUE2);

		object.on_pulse_oximetry_spot_check_measurement(bundle, Flags,
				MeasurementStatus, DeviceandSensorStatus);
	}

	/**
	 * Not fully implemented
	 * 
	 * @param bundle
	 * @param characteristic
	 * @param offset
	 * @param nextOffset
	 * @return
	 */
	protected static int record_access_control_point(Bundle bundle,
			BluetoothGattCharacteristic characteristic, int offset,
			int[] nextOffset) {
		byte[] characteristicValue = characteristic.getValue();
		int OpCode = 0;
		int Operator = 0;
		byte[] Operand = null;

		OpCode = characteristic.getIntValue(
				BluetoothGattCharacteristic.FORMAT_UINT8, offset);
		offset += UINT8_SIZE;
		Operator = characteristic.getIntValue(
				BluetoothGattCharacteristic.FORMAT_UINT8, offset);
		offset += UINT8_SIZE;
		Operand = new byte[characteristicValue.length - offset];
		System.arraycopy(characteristicValue, offset, Operand, 0,
				Operand.length);
		offset = characteristicValue.length;

		bundle.putInt(EXTRA_VALUE0, OpCode);
		bundle.putInt(EXTRA_VALUE1, Operator);
		bundle.putByteArray(EXTRA_VALUE2, Operand);

		nextOffset[0] = offset;
		return MSG_record_access_control_point;
	}

	protected static void handle_record_access_control_point(Bundle bundle,
			IBluetoothGattCharacteristicHandler object)
			throws IllegalArgumentException {
		String sUUID = bundle.getString(BluetoothDevice.EXTRA_UUID);
		UUID aUUID = UUID.fromString(sUUID);
		if (!GATT_CHARACTERISTIC_record_access_control_point.equals(aUUID)) {
			throw new IllegalArgumentException(
					"The provided uuid is uncompatible with this method");
		}

		int OpCode = bundle.getInt(EXTRA_VALUE0);
		int Operator = bundle.getInt(EXTRA_VALUE1);
		byte[] Operand = bundle.getByteArray(EXTRA_VALUE2);

		object.on_record_access_control_point(bundle, OpCode, Operator, Operand);

	}

	protected static int reference_time_information(Bundle bundle,
			BluetoothGattCharacteristic characteristic, int offset,
			int[] nextOffset) {
		// byte[] characteristicValue = characteristic.getValue();
		int TimeSource = 0;
		int Accuracy = 0;
		int HoursSinceUpdate = 0;
		Bundle b0 = new Bundle();
		time_source(b0, characteristic, offset, nextOffset);
		offset = nextOffset[0];
		TimeSource = bundle.getInt(EXTRA_VALUE0);
		Bundle b1 = new Bundle();
		time_accuracy(b1, characteristic, offset, nextOffset);
		offset = nextOffset[0];
		Accuracy = bundle.getInt(EXTRA_VALUE0);
		HoursSinceUpdate = characteristic.getIntValue(
				BluetoothGattCharacteristic.FORMAT_UINT8, offset);
		offset += UINT8_SIZE;

		bundle.putInt(EXTRA_VALUE0, TimeSource);
		bundle.putInt(EXTRA_VALUE1, Accuracy);
		bundle.putInt(EXTRA_VALUE2, HoursSinceUpdate);

		nextOffset[0] = offset;
		return MSG_reference_time_information;
	}

	protected static void handle_reference_time_information(Bundle bundle,
			IBluetoothGattCharacteristicHandler object)
			throws IllegalArgumentException {
		String sUUID = bundle.getString(BluetoothDevice.EXTRA_UUID);
		UUID aUUID = UUID.fromString(sUUID);
		if (!GATT_CHARACTERISTIC_reference_time_information.equals(aUUID)) {
			throw new IllegalArgumentException(
					"The provided uuid is uncompatible with this method");
		}
		int TimeSource = bundle.getInt(EXTRA_VALUE0);
		int Accuracy = bundle.getInt(EXTRA_VALUE1);
		int HoursSinceUpdate = bundle.getInt(EXTRA_VALUE2);

		object.on_reference_time_information(bundle, TimeSource, Accuracy,
				HoursSinceUpdate);

	}

	/**
	 * not implemented
	 * 
	 * @param bundle
	 * @param characteristic
	 * @param offset
	 * @param nextOffset
	 * @return
	 */
	protected static int removable(Bundle bundle,
			BluetoothGattCharacteristic characteristic, int offset,
			int[] nextOffset) {
		// byte[] characteristicValue = characteristic.getValue();

		int Removable = 7;
		Removable = characteristic.getIntValue(
				BluetoothGattCharacteristic.FORMAT_UINT8, offset);

		bundle.putInt(EXTRA_VALUE0, Removable);

		nextOffset[0] = offset;
		return MSG_removable;
	}

	/**
	 * not implemented
	 * 
	 * @param bundle
	 * @param object
	 * @throws IllegalArgumentException
	 */
	protected static void handle_removable(Bundle bundle,
			IBluetoothGattCharacteristicHandler object)
			throws IllegalArgumentException {
		String sUUID = bundle.getString(BluetoothDevice.EXTRA_UUID);
		UUID aUUID = UUID.fromString(sUUID);
		if (!GATT_CHARACTERISTIC_removable.equals(aUUID)) {
			throw new IllegalArgumentException(
					"The provided uuid is uncompatible with this method");
		}

		int Removable = bundle.getInt(EXTRA_VALUE0);

		object.on_removable(bundle, Removable);
	}

	protected static int report(Bundle bundle,
			BluetoothGattCharacteristic characteristic, int offset,
			int[] nextOffset) {
		// byte[] characteristicValue = characteristic.getValue();
		int ReportValue = characteristic.getIntValue(
				BluetoothGattCharacteristic.FORMAT_UINT8, offset);
		offset += UINT8_SIZE;

		bundle.putInt(EXTRA_VALUE0, ReportValue);

		nextOffset[0] = offset;
		return MSG_report;
	}

	protected static void handle_report(Bundle bundle,
			IBluetoothGattCharacteristicHandler object)
			throws IllegalArgumentException {
		String sUUID = bundle.getString(BluetoothDevice.EXTRA_UUID);
		UUID aUUID = UUID.fromString(sUUID);
		if (!GATT_CHARACTERISTIC_report.equals(aUUID)) {
			throw new IllegalArgumentException(
					"The provided uuid is uncompatible with this method");
		}
		int ReportValue = bundle.getInt(EXTRA_VALUE0);

		object.on_report(bundle, ReportValue);
	}

	protected static int report_map(Bundle bundle,
			BluetoothGattCharacteristic characteristic, int offset,
			int[] nextOffset) {
		// byte[] characteristicValue = characteristic.getValue();
		int ReportMap = characteristic.getIntValue(
				BluetoothGattCharacteristic.FORMAT_UINT8, offset);
		offset += UINT8_SIZE;

		bundle.putInt(EXTRA_VALUE0, ReportMap);

		nextOffset[0] = offset;
		return MSG_report_map;
	}

	protected static void handle_report_map(Bundle bundle,
			IBluetoothGattCharacteristicHandler object)
			throws IllegalArgumentException {
		String sUUID = bundle.getString(BluetoothDevice.EXTRA_UUID);
		UUID aUUID = UUID.fromString(sUUID);
		if (!GATT_CHARACTERISTIC_report_map.equals(aUUID)) {
			throw new IllegalArgumentException(
					"The provided uuid is uncompatible with this method");
		}

		int ReportMap = bundle.getInt(EXTRA_VALUE0);

		object.on_report_map(bundle, ReportMap);
	}

	protected static int ringer_control_point(Bundle bundle,
			BluetoothGattCharacteristic characteristic, int offset,
			int[] nextOffset) {
		// byte[] characteristicValue = characteristic.getValue();
		int RingerControlPoint = 0;
		String RingerControlPointText = "Reserved for future use";
		RingerControlPoint = characteristic.getIntValue(
				BluetoothGattCharacteristic.FORMAT_UINT8, offset);
		offset += UINT8_SIZE;

		RingerControlPoint = bundle.getInt(EXTRA_VALUE0);
		switch (RingerControlPoint) {
		case 0:
			RingerControlPointText = "Reserved for future use";
			break;
		case 1:
			RingerControlPointText = "Silent Mode";
			break;
		case 2:
			RingerControlPointText = "Mute Once";
			break;
		case 3:
			RingerControlPointText = "Cancel Silent Mode";
			break;
		default:
			RingerControlPointText = "Reserved for future use";
		}

		bundle.putInt(EXTRA_VALUE0, RingerControlPoint);
		bundle.putString(EXTRA_VALUE1, RingerControlPointText);

		nextOffset[0] = offset;
		return MSG_ringer_control_point;
	}

	protected static void handle_ringer_control_point(Bundle bundle,
			IBluetoothGattCharacteristicHandler object)
			throws IllegalArgumentException {
		String sUUID = bundle.getString(BluetoothDevice.EXTRA_UUID);
		UUID aUUID = UUID.fromString(sUUID);
		if (!GATT_CHARACTERISTIC_ringer_control_point.equals(aUUID)) {
			throw new IllegalArgumentException(
					"The provided uuid is uncompatible with this method");
		}
		int RingerControlPoint = bundle.getInt(EXTRA_VALUE0);
		String RingerControlPointText = bundle.getString(EXTRA_VALUE1);

		object.on_ringer_control_point(bundle, RingerControlPoint,
				RingerControlPointText);
	}

	protected static int ringer_setting(Bundle bundle,
			BluetoothGattCharacteristic characteristic, int offset,
			int[] nextOffset) {
		// byte[] characteristicValue = characteristic.getValue();

		nextOffset[0] = offset;
		return MSG_ringer_setting;
	}

	protected static void handle_ringer_setting(Bundle bundle,
			IBluetoothGattCharacteristicHandler object)
			throws IllegalArgumentException {
		String sUUID = bundle.getString(BluetoothDevice.EXTRA_UUID);
		UUID aUUID = UUID.fromString(sUUID);
		if (!GATT_CHARACTERISTIC_ringer_setting.equals(aUUID)) {
			throw new IllegalArgumentException(
					"The provided uuid is uncompatible with this method");
		}

	}

	protected static int rsc_feature(Bundle bundle,
			BluetoothGattCharacteristic characteristic, int offset,
			int[] nextOffset) {
		// byte[] characteristicValue = characteristic.getValue();

		int RSCFeature = 0;
		RSCFeature = characteristic.getIntValue(
				BluetoothGattCharacteristic.FORMAT_UINT16, offset);
		offset += UINT16_SIZE;

		bundle.putInt(EXTRA_VALUE0, RSCFeature);

		nextOffset[0] = offset;
		return MSG_rsc_feature;
	}

	protected static void handle_rsc_feature(Bundle bundle,
			IBluetoothGattCharacteristicHandler object)
			throws IllegalArgumentException {
		String sUUID = bundle.getString(BluetoothDevice.EXTRA_UUID);
		UUID aUUID = UUID.fromString(sUUID);
		if (!GATT_CHARACTERISTIC_rsc_feature.equals(aUUID)) {
			throw new IllegalArgumentException(
					"The provided uuid is uncompatible with this method");
		}
		int RSCFeature = bundle.getInt(EXTRA_VALUE0);

		object.on_rsc_feature(bundle, RSCFeature);
	}

	protected static int rsc_measurement(Bundle bundle,
			BluetoothGattCharacteristic characteristic, int offset,
			int[] nextOffset) {
		// byte[] characteristicValue = characteristic.getValue();
		int Flags = 0;
		int InstantaneousSpeed = 0;
		int InstantaneousCadence = 0;
		int InstantaneousStrideLength = 0;
		int TotalDistance = 0;
		Flags = characteristic.getIntValue(
				BluetoothGattCharacteristic.FORMAT_UINT8, offset);
		offset += UINT8_SIZE;
		InstantaneousSpeed = characteristic.getIntValue(
				BluetoothGattCharacteristic.FORMAT_UINT16, offset);
		offset += UINT16_SIZE;
		InstantaneousCadence = characteristic.getIntValue(
				BluetoothGattCharacteristic.FORMAT_UINT8, offset);
		offset += UINT8_SIZE;
		if (((Flags & 1 << 0) >> 0) == 1) {
			InstantaneousStrideLength = characteristic.getIntValue(
					BluetoothGattCharacteristic.FORMAT_UINT16, offset);
			offset += UINT16_SIZE;
		}
		if (((Flags & 1 << 1) >> 1) == 1) {
			TotalDistance = characteristic.getIntValue(
					BluetoothGattCharacteristic.FORMAT_UINT32, offset);
			offset += UINT32_SIZE;
		}

		bundle.putInt(EXTRA_VALUE0, Flags);
		bundle.putInt(EXTRA_VALUE1, InstantaneousSpeed);
		bundle.putInt(EXTRA_VALUE2, InstantaneousCadence);
		bundle.putInt(EXTRA_VALUE3, InstantaneousStrideLength);
		bundle.putInt(EXTRA_VALUE4, TotalDistance);

		nextOffset[0] = offset;
		return MSG_rsc_measurement;
	}

	protected static void handle_rsc_measurement(Bundle bundle,
			IBluetoothGattCharacteristicHandler object)
			throws IllegalArgumentException {
		String sUUID = bundle.getString(BluetoothDevice.EXTRA_UUID);
		UUID aUUID = UUID.fromString(sUUID);
		if (!GATT_CHARACTERISTIC_rsc_measurement.equals(aUUID)) {
			throw new IllegalArgumentException(
					"The provided uuid is uncompatible with this method");
		}
		int Flags = bundle.getInt(EXTRA_VALUE0);
		int InstantaneousSpeed = bundle.getInt(EXTRA_VALUE1);
		int InstantaneousCadence = bundle.getInt(EXTRA_VALUE2);
		int InstantaneousStrideLength = bundle.getInt(EXTRA_VALUE3);
		int TotalDistance = bundle.getInt(EXTRA_VALUE4);

		object.on_rsc_measurement(bundle, Flags, InstantaneousSpeed,
				InstantaneousCadence, InstantaneousStrideLength, TotalDistance);
	}

	protected static int sc_control_point(Bundle bundle,
			BluetoothGattCharacteristic characteristic, int offset,
			int[] nextOffset) {
		// byte[] characteristicValue = characteristic.getValue();

		nextOffset[0] = offset;
		return MSG_sc_control_point;
	}

	protected static void handle_sc_control_point(Bundle bundle,
			IBluetoothGattCharacteristicHandler object)
			throws IllegalArgumentException {
		String sUUID = bundle.getString(BluetoothDevice.EXTRA_UUID);
		UUID aUUID = UUID.fromString(sUUID);
		if (!GATT_CHARACTERISTIC_sc_control_point.equals(aUUID)) {
			throw new IllegalArgumentException(
					"The provided uuid is uncompatible with this method");
		}

	}

	/**
	 * not implemented
	 * 
	 * @param bundle
	 * @param characteristic
	 * @param offset
	 * @param nextOffset
	 * @return
	 */
	protected static int scan_interval_window(Bundle bundle,
			BluetoothGattCharacteristic characteristic, int offset,
			int[] nextOffset) {
		// byte[] characteristicValue = characteristic.getValue();
		int OpCode = 0;
		int CumulativeValue = 0;
		int SensorLocationValue = 0;
		int RequestOpCode = 0;
		int ResponseValue = 0;
		int ResponsePArameter = 0;

		OpCode = characteristic.getIntValue(
				BluetoothGattCharacteristic.FORMAT_UINT8, offset);
		offset += UINT8_SIZE;

		if (((OpCode & 1 << 1) >> 1) == 1) {

		}

		nextOffset[0] = offset;
		return MSG_scan_interval_window;
	}

	/**
	 * @param bundle
	 * @param object
	 * @throws IllegalArgumentException
	 */
	protected static void handle_scan_interval_window(Bundle bundle,
			IBluetoothGattCharacteristicHandler object)
			throws IllegalArgumentException {
		String sUUID = bundle.getString(BluetoothDevice.EXTRA_UUID);
		UUID aUUID = UUID.fromString(sUUID);
		if (!GATT_CHARACTERISTIC_scan_interval_window.equals(aUUID)) {
			throw new IllegalArgumentException(
					"The provided uuid is uncompatible with this method");
		}

		object.on_default(bundle, sUUID);
	}

	protected static int scan_refresh(Bundle bundle,
			BluetoothGattCharacteristic characteristic, int offset,
			int[] nextOffset) {
		// byte[] characteristicValue = characteristic.getValue();
		int ScanRefreshValue = 0;
		ScanRefreshValue = characteristic.getIntValue(
				BluetoothGattCharacteristic.FORMAT_UINT8, offset);
		offset += UINT8_SIZE;

		bundle.putInt(EXTRA_VALUE0, ScanRefreshValue);

		nextOffset[0] = offset;
		return MSG_scan_refresh;
	}

	/**
	 * 
	 * 
	 * @param bundle
	 * @param object
	 * @throws IllegalArgumentException
	 */
	protected static void handle_scan_refresh(Bundle bundle,
			IBluetoothGattCharacteristicHandler object)
			throws IllegalArgumentException {
		String sUUID = bundle.getString(BluetoothDevice.EXTRA_UUID);
		UUID aUUID = UUID.fromString(sUUID);
		if (!GATT_CHARACTERISTIC_scan_refresh.equals(aUUID)) {
			throw new IllegalArgumentException(
					"The provided uuid is uncompatible with this method");
		}

		int ScanRefreshValue = bundle.getInt(EXTRA_VALUE0);

		object.on_scan_refresh(bundle, ScanRefreshValue);
	}

	/**
	 * version 0.9
	 * 
	 * @param bundle
	 * @param characteristic
	 * @param offset
	 * @param nextOffset
	 * @return
	 */
	protected static int scientific_temperature_celsius(Bundle bundle,
			BluetoothGattCharacteristic characteristic, int offset,
			int[] nextOffset) {
		// byte[] characteristicValue = characteristic.getValue();

		double ScientificTemperature = getFloat(characteristic, FORMAT_FLOAT64,
				offset, nextOffset);
		offset = nextOffset[0];

		bundle.putDouble(EXTRA_VALUE0, ScientificTemperature);

		nextOffset[0] = offset;
		return MSG_scientific_temperature_celsius;
	}

	/**
	 * not implemented
	 * 
	 * @param bundle
	 * @param object
	 * @throws IllegalArgumentException
	 */
	protected static void handle_scientific_temperature_celsius(Bundle bundle,
			IBluetoothGattCharacteristicHandler object)
			throws IllegalArgumentException {
		String sUUID = bundle.getString(BluetoothDevice.EXTRA_UUID);
		UUID aUUID = UUID.fromString(sUUID);
		if (!GATT_CHARACTERISTIC_scientific_temperature_celsius.equals(aUUID)) {
			throw new IllegalArgumentException(
					"The provided uuid is uncompatible with this method");
		}

		double ScientificTemperature = bundle.getDouble(EXTRA_VALUE0);

		object.on_scientific_temperature_celsius(bundle, ScientificTemperature);
	}

	/**
	 * this is a guess. the spec is not available
	 * 
	 * @param bundle
	 * @param characteristic
	 * @param offset
	 * @param nextOffset
	 * @return
	 */
	protected static int secondary_time_zone(Bundle bundle,
			BluetoothGattCharacteristic characteristic, int offset,
			int[] nextOffset) {
		// byte[] characteristicValue = characteristic.getValue();

		Bundle b0 = new Bundle();
		time_zone(b0, characteristic, offset, nextOffset);
		offset = nextOffset[0];

		bundle.putAll(b0);

		nextOffset[0] = offset;
		return MSG_secondary_time_zone;
	}

	protected static void handle_secondary_time_zone(Bundle bundle,
			IBluetoothGattCharacteristicHandler object)
			throws IllegalArgumentException {
		String sUUID = bundle.getString(BluetoothDevice.EXTRA_UUID);
		UUID aUUID = UUID.fromString(sUUID);
		if (!GATT_CHARACTERISTIC_secondary_time_zone.equals(aUUID)) {
			throw new IllegalArgumentException(
					"The provided uuid is uncompatible with this method");
		}
		int TimeZone = bundle.getInt(EXTRA_VALUE0);
		String TimeZoneString = bundle.getString(EXTRA_VALUE1);

		object.on_secondary_time_zone(bundle, TimeZone, TimeZoneString);

	}

	protected static int sensor_location(Bundle bundle,
			BluetoothGattCharacteristic characteristic, int offset,
			int[] nextOffset) {
		// byte[] characteristicValue = characteristic.getValue();
		int SensorLocation = 0;
		String SensorLocationText = "";
		SensorLocation = characteristic.getIntValue(
				BluetoothGattCharacteristic.FORMAT_UINT8, offset);
		offset += UINT8_SIZE;

		switch (SensorLocation) {
		case 0:
			SensorLocationText = "Other";
			break;
		case 1:
			SensorLocationText = "Top of shoe";
			break;
		case 2:
			SensorLocationText = "In shoe";
			break;
		case 3:
			SensorLocationText = "Hip";
			break;
		case 4:
			SensorLocationText = "Front Wheel";
			break;
		case 5:
			SensorLocationText = "Left Crank";
			break;
		case 6:
			SensorLocationText = "Right Crank";
			break;
		case 7:
			SensorLocationText = "Left Pedal";
			break;
		case 8:
			SensorLocationText = "Right Pedal";
			break;
		case 9:
			SensorLocationText = "Front Hub";
			break;
		case 10:
			SensorLocationText = "Rear Dropout";
			break;
		case 11:
			SensorLocationText = "Chainstay";
			break;
		case 12:
			SensorLocationText = "Rear Wheel";
			break;
		case 13:
			SensorLocationText = "Rear Hub";
			break;
		case 14:
			SensorLocationText = "Chest";
			break;
		default:
			SensorLocationText = "Reserved for future use";
			break;
		}

		bundle.putInt(EXTRA_VALUE0, SensorLocation);
		bundle.putString(EXTRA_VALUE1, SensorLocationText);

		nextOffset[0] = offset;
		return MSG_sensor_location;
	}

	protected static void handle_sensor_location(Bundle bundle,
			IBluetoothGattCharacteristicHandler object)
			throws IllegalArgumentException {
		String sUUID = bundle.getString(BluetoothDevice.EXTRA_UUID);
		UUID aUUID = UUID.fromString(sUUID);
		if (!GATT_CHARACTERISTIC_sensor_location.equals(aUUID)) {
			throw new IllegalArgumentException(
					"The provided uuid is uncompatible with this method");
		}
		int SensorLocation = bundle.getInt(EXTRA_VALUE0);
		String SensorLocationText = bundle.getString(EXTRA_VALUE1);

		object.on_sensor_location(bundle, SensorLocation, SensorLocationText);
	}

	/**
	 * put extra values into bundle: EXTRA_VALUE0 serial_number_string format
	 * String as hex code EXTRA_VALUE0 serial_number_string format String as
	 * UTF-8 as described by the specification
	 * 
	 * @param bundle
	 * @param characteristic
	 * @return response id to put in message.what
	 */
	protected static int serial_number_string(Bundle bundle,
			BluetoothGattCharacteristic characteristic, int offset,
			int[] nextOffset) {
		byte[] characteristicValue = characteristic.getValue();
		// bluegiga has the serialnumber in hex

		bundle.putString(
				EXTRA_VALUE0,
				getHex(characteristic, characteristicValue.length, offset,
						nextOffset));
		offset = nextOffset[0];
		// spec says UTF-8
		String serial_number_string = characteristic.getStringValue(0);
		bundle.putString(EXTRA_VALUE1, serial_number_string);

		nextOffset[0] = offset;
		return MSG_serial_number_string;
	}

	protected static void handle_serial_number_string(Bundle bundle,
			IBluetoothGattCharacteristicHandler object)
			throws IllegalArgumentException {
		String sUUID = bundle.getString(BluetoothDevice.EXTRA_UUID);
		UUID aUUID = UUID.fromString(sUUID);
		if (!GATT_CHARACTERISTIC_serial_number_string.equals(aUUID)) {
			throw new IllegalArgumentException(
					"The provided uuid is uncompatible with this method");
		}
		String serial_number_string = bundle.getString(EXTRA_VALUE0);
		object.on_serial_number_string(bundle, serial_number_string);
	}

	protected static int service_required(Bundle bundle,
			BluetoothGattCharacteristic characteristic, int offset,
			int[] nextOffset) {
		// byte[] characteristicValue = characteristic.getValue();

		int ServiceRequired = 7;
		ServiceRequired = characteristic.getIntValue(
				BluetoothGattCharacteristic.FORMAT_UINT8, offset);

		bundle.putInt(EXTRA_VALUE0, ServiceRequired);

		nextOffset[0] = offset;
		return MSG_service_required;
	}

	protected static void handle_service_required(Bundle bundle,
			IBluetoothGattCharacteristicHandler object)
			throws IllegalArgumentException {
		String sUUID = bundle.getString(BluetoothDevice.EXTRA_UUID);
		UUID aUUID = UUID.fromString(sUUID);
		if (!GATT_CHARACTERISTIC_service_required.equals(aUUID)) {
			throw new IllegalArgumentException(
					"The provided uuid is uncompatible with this method");
		}
		int ServiceRequired = bundle.getInt(EXTRA_VALUE0);

		object.on_service_required(bundle, ServiceRequired);
	}

	protected static int software_revision_string(Bundle bundle,
			BluetoothGattCharacteristic characteristic, int offset,
			int[] nextOffset) {
		// byte[] characteristicValue = characteristic.getValue();

		Bundle b0 = new Bundle();
		string(b0, characteristic, offset, nextOffset);
		offset = nextOffset[0];

		String rev = b0.getString(EXTRA_VALUE0);

		bundle.putString(EXTRA_VALUE0, rev);

		nextOffset[0] = offset;
		return MSG_software_revision_string;
	}

	protected static void handle_software_revision_string(Bundle bundle,
			IBluetoothGattCharacteristicHandler object)
			throws IllegalArgumentException {
		String sUUID = bundle.getString(BluetoothDevice.EXTRA_UUID);
		UUID aUUID = UUID.fromString(sUUID);
		if (!GATT_CHARACTERISTIC_software_revision_string.equals(aUUID)) {
			throw new IllegalArgumentException(
					"The provided uuid is uncompatible with this method");
		}
		String rev = bundle.getString(EXTRA_VALUE0);

		object.on_software_revision_string(bundle, rev);
	}

	/**
	 * this is a guess
	 * 
	 * @param bundle
	 * @param characteristic
	 * @param offset
	 * @param nextOffset
	 * @return
	 */
	protected static int string(Bundle bundle,
			BluetoothGattCharacteristic characteristic, int offset,
			int[] nextOffset) {
		byte[] characteristicValue = characteristic.getValue();

		String string = characteristic.getStringValue(offset);
		offset = characteristicValue.length;

		bundle.putString(EXTRA_VALUE0, string);

		nextOffset[0] = offset;
		return MSG_string;
	}

	protected static void handle_string(Bundle bundle,
			IBluetoothGattCharacteristicHandler object)
			throws IllegalArgumentException {
		String sUUID = bundle.getString(BluetoothDevice.EXTRA_UUID);
		UUID aUUID = UUID.fromString(sUUID);
		if (!GATT_CHARACTERISTIC_string.equals(aUUID)) {
			throw new IllegalArgumentException(
					"The provided uuid is uncompatible with this method");
		}

		String string = bundle.getString(EXTRA_VALUE0);

		object.on_string(bundle, string);
	}

	protected static int supported_new_alert_category(Bundle bundle,
			BluetoothGattCharacteristic characteristic, int offset,
			int[] nextOffset) {
		// byte[] characteristicValue = characteristic.getValue();

		Bundle b0 = new Bundle();
		alert_category_id_bit_mask(b0, characteristic, offset, nextOffset);
		offset = nextOffset[0];

		int categoryIDBitMask0 = bundle.getInt(EXTRA_VALUE0);
		int categoryIDBitMask1 = bundle.getInt(EXTRA_VALUE1);

		bundle.putInt(EXTRA_VALUE0, categoryIDBitMask0);
		bundle.putInt(EXTRA_VALUE1, categoryIDBitMask1);

		nextOffset[0] = offset;
		return MSG_supported_new_alert_category;
	}

	protected static void handle_supported_new_alert_category(Bundle bundle,
			IBluetoothGattCharacteristicHandler object)
			throws IllegalArgumentException {
		String sUUID = bundle.getString(BluetoothDevice.EXTRA_UUID);
		UUID aUUID = UUID.fromString(sUUID);
		if (!GATT_CHARACTERISTIC_supported_new_alert_category.equals(aUUID)) {
			throw new IllegalArgumentException(
					"The provided uuid is uncompatible with this method");
		}

		int categoryIDBitMask0 = bundle.getInt(EXTRA_VALUE0);
		int categoryIDBitMask1 = bundle.getInt(EXTRA_VALUE1);

		object.on_supported_new_alert_category(bundle, categoryIDBitMask0,
				categoryIDBitMask1);

	}

	protected static int supported_unread_alert_category(Bundle bundle,
			BluetoothGattCharacteristic characteristic, int offset,
			int[] nextOffset) {
		// byte[] characteristicValue = characteristic.getValue();

		Bundle b0 = new Bundle();
		alert_category_id_bit_mask(b0, characteristic, offset, nextOffset);
		offset = nextOffset[0];

		int categoryIDBitMask0 = bundle.getInt(EXTRA_VALUE0);
		int categoryIDBitMask1 = bundle.getInt(EXTRA_VALUE1);

		bundle.putInt(EXTRA_VALUE0, categoryIDBitMask0);
		bundle.putInt(EXTRA_VALUE1, categoryIDBitMask1);

		nextOffset[0] = offset;
		return MSG_supported_unread_alert_category;
	}

	protected static void handle_supported_unread_alert_category(Bundle bundle,
			IBluetoothGattCharacteristicHandler object)
			throws IllegalArgumentException {
		String sUUID = bundle.getString(BluetoothDevice.EXTRA_UUID);
		UUID aUUID = UUID.fromString(sUUID);
		if (!GATT_CHARACTERISTIC_supported_unread_alert_category.equals(aUUID)) {
			throw new IllegalArgumentException(
					"The provided uuid is uncompatible with this method");
		}

		int categoryIDBitMask0 = bundle.getInt(EXTRA_VALUE0);
		int categoryIDBitMask1 = bundle.getInt(EXTRA_VALUE1);

		object.on_supported_unread_alert_category(bundle, categoryIDBitMask0,
				categoryIDBitMask1);
	}

	protected static int system_id(Bundle bundle,
			BluetoothGattCharacteristic characteristic, int offset,
			int[] nextOffset) {
		// byte[] characteristicValue = characteristic.getValue();

		int initialOffset = offset;
		int[] manufacturerIdentifier = new int[5];
		for (int i = 0; i < 5; i++) {
			manufacturerIdentifier[i] = characteristic.getIntValue(
					BluetoothGattCharacteristic.FORMAT_UINT8, offset);
			offset += UINT8_SIZE;
		}
		int[] organizationallyUniqueIdentifier = new int[3];
		for (int i = 0; i < 3; i++) {
			organizationallyUniqueIdentifier[i] = characteristic.getIntValue(
					BluetoothGattCharacteristic.FORMAT_UINT8, offset);
			offset += UINT8_SIZE;
		}
		int manufacturerIdentifierint = getINT(characteristic, FORMAT_UINT40,
				initialOffset, nextOffset);
		initialOffset = nextOffset[0];
		int organizationallyUniqueIdentifieri = getINT(characteristic,
				FORMAT_UINT24, initialOffset, nextOffset);
		initialOffset = nextOffset[0];

		bundle.putIntArray(EXTRA_VALUE0, manufacturerIdentifier);
		bundle.putIntArray(EXTRA_VALUE1, organizationallyUniqueIdentifier);

		bundle.putInt(EXTRA_VALUE2, manufacturerIdentifierint);
		bundle.putInt(EXTRA_VALUE3, organizationallyUniqueIdentifieri);

		nextOffset[0] = offset;
		return MSG_system_id;
	}

	protected static void handle_system_id(Bundle bundle,
			IBluetoothGattCharacteristicHandler object)
			throws IllegalArgumentException {
		String sUUID = bundle.getString(BluetoothDevice.EXTRA_UUID);
		UUID aUUID = UUID.fromString(sUUID);
		if (!GATT_CHARACTERISTIC_system_id.equals(aUUID)) {
			throw new IllegalArgumentException(
					"The provided uuid is uncompatible with this method");
		}
		int[] manufacturerIdentifier = bundle.getIntArray(EXTRA_VALUE0);

		int[] organizationallyUniqueIdentifier = bundle
				.getIntArray(EXTRA_VALUE1);

		int manufacturerIdentifierint = bundle.getInt(EXTRA_VALUE2);
		int organizationallyUniqueIdentifieri = bundle.getInt(EXTRA_VALUE3);

		object.on_system_id(bundle, manufacturerIdentifier,
				organizationallyUniqueIdentifier);
	}

	/**
	 * version 0.5
	 * 
	 * @param bundle
	 * @param characteristic
	 * @return
	 */
	protected static int temperature_celsius(Bundle bundle,
			BluetoothGattCharacteristic characteristic, int offset,
			int[] nextOffset) {
		byte[] characteristicValue = characteristic.getValue();

		float Temperature = characteristic.getFloatValue(FORMAT_SFLOAT, offset);
		offset += SFLOAT_SIZE;

		bundle.putFloat(EXTRA_VALUE0, Temperature);

		nextOffset[0] = offset;
		return MSG_temperature_celsius;
	}

	/**
	 * version 0.5
	 * 
	 * @param bundle
	 * @param object
	 * @throws IllegalArgumentException
	 */
	protected static void handle_temperature_celsius(Bundle bundle,
			IBluetoothGattCharacteristicHandler object)
			throws IllegalArgumentException {
		String sUUID = bundle.getString(BluetoothDevice.EXTRA_UUID);
		UUID aUUID = UUID.fromString(sUUID);
		if (!GATT_CHARACTERISTIC_temperature_celsius.equals(aUUID)) {
			throw new IllegalArgumentException(
					"The provided uuid is uncompatible with this method");
		}

		float Temperature = bundle.getFloat(EXTRA_VALUE0);

		object.on_temperature_celsius(bundle, Temperature);
	}

	/**
	 * not implemented
	 * 
	 * @param bundle
	 * @param characteristic
	 * @return
	 */
	protected static int temperature_fahrenheit(Bundle bundle,
			BluetoothGattCharacteristic characteristic, int offset,
			int[] nextOffset) {
		// byte[] characteristicValue = characteristic.getValue();

		float Temperature = characteristic.getFloatValue(FORMAT_SFLOAT, offset);
		offset += SFLOAT_SIZE;

		bundle.putFloat(EXTRA_VALUE0, Temperature);

		nextOffset[0] = offset;
		return MSG_temperature_fahrenheit;
	}

	/**
	 * version 0.5
	 * 
	 * @param bundle
	 * @param object
	 * @throws IllegalArgumentException
	 */
	protected static void handle_temperature_fahrenheit(Bundle bundle,
			IBluetoothGattCharacteristicHandler object)
			throws IllegalArgumentException {
		String sUUID = bundle.getString(BluetoothDevice.EXTRA_UUID);
		UUID aUUID = UUID.fromString(sUUID);
		if (!GATT_CHARACTERISTIC_temperature_fahrenheit.equals(aUUID)) {
			throw new IllegalArgumentException(
					"The provided uuid is uncompatible with this method");
		}
		float Temperature = bundle.getFloat(EXTRA_VALUE0);

		object.on_temperature_fahrenheit(bundle, Temperature);
	}

	protected static int temperature_measurement(Bundle bundle,
			BluetoothGattCharacteristic characteristic, int offset,
			int[] nextOffset) {
		// byte[] characteristicValue = characteristic.getValue();

		int flags = characteristic.getIntValue(
				BluetoothGattCharacteristic.FORMAT_UINT8, offset);
		offset += UINT8_SIZE;

		int bitShift = 0;
		int TemperatureUnitFlag = (flags & (1 << bitShift)) >> bitShift++;
		int TimeStampFlag = (flags & (1 << bitShift)) >> bitShift++;
		int TemperatureTypeFlag = (flags & (1 << bitShift)) >> bitShift++;
		int Reservedforfutureuse3 = (flags & (1 << bitShift)) >> bitShift++;
		int Reservedforfutureuse4 = (flags & (1 << bitShift)) >> bitShift++;
		int Reservedforfutureuse5 = (flags & (1 << bitShift)) >> bitShift++;
		int Reservedforfutureuse6 = (flags & (1 << bitShift)) >> bitShift++;
		int Reservedforfutureuse7 = (flags & (1 << bitShift)) >> bitShift++;

		float TemperatureMeasurementValue = characteristic.getFloatValue(
				BluetoothGattCharacteristic.FORMAT_FLOAT, offset);
		offset += FLOAT_SIZE;

		bundle.putInt(EXTRA_VALUE0, flags);
		bundle.putFloat(EXTRA_VALUE1, TemperatureMeasurementValue);
		bundle.putInt(EXTRA_VALUE2, TemperatureUnitFlag);

		int[] TimeStamp = new int[6];
		if (TimeStampFlag == 1) {
			offset = getDateTime(characteristic, TimeStamp, offset);
			bundle.putIntArray(EXTRA_VALUE3, TimeStamp);
		}

		Bundle b = new Bundle();
		if (TemperatureTypeFlag == 1) {
			temperature_type(b, characteristic, offset, nextOffset);
		}
		offset = nextOffset[0];
		bundle.putInt(EXTRA_VALUE4, b.getInt(EXTRA_VALUE0, 0));
		bundle.putString(EXTRA_VALUE5,
				b.getString(EXTRA_VALUE1, "No temperature type"));

		nextOffset[0] = offset;
		return MSG_temperature_measurement;
	}

	protected static void handle_temperature_measurement(Bundle bundle,
			IBluetoothGattCharacteristicHandler object)
			throws IllegalArgumentException {
		String sUUID = bundle.getString(BluetoothDevice.EXTRA_UUID);
		UUID aUUID = UUID.fromString(sUUID);
		if (!GATT_CHARACTERISTIC_temperature_measurement.equals(aUUID)) {
			throw new IllegalArgumentException(
					"The provided uuid is uncompatible with this method");
		}
		int flags = bundle.getInt(EXTRA_VALUE0);
		float TemperatureMeasurementValue = bundle.getFloat(EXTRA_VALUE1);
		int TemperatureUnitFlag = bundle.getInt(EXTRA_VALUE2);
		int[] baseTime = bundle.getIntArray(EXTRA_VALUE3);
		int temperatureType = bundle.getInt(EXTRA_VALUE4);
		String temperatureTypeString = bundle.getString(EXTRA_VALUE5);

		Calendar date = dateValuesArrayAsCalendar(baseTime);

		object.on_temperature_measurement(bundle, flags,
				TemperatureMeasurementValue, TemperatureUnitFlag, date,
				temperatureType, temperatureTypeString);

	}

	/**
	 * EXTRA_VALUE0 : flags EXTRA_VALUE1 : Temperature Text Description
	 * 
	 * 
	 * @param bundle
	 * @param characteristic
	 * @param offset
	 * @return
	 */
	protected static int temperature_type(Bundle bundle,
			BluetoothGattCharacteristic characteristic, int offset,
			int[] nextOffset) {
		// byte[] characteristicValue = characteristic.getValue();

		int flag = characteristic.getIntValue(
				BluetoothGattCharacteristic.FORMAT_UINT8, offset);
		offset += UINT8_SIZE;
		String TemperatureTextDescription = "No temperature type";

		for (int i = 1; i < 256; i++) {
			if (flag == 0) {
				TemperatureTextDescription = "No temperature type";
			} else if (flag == 1) {
				TemperatureTextDescription = "Armpit";
			} else if (flag == 2) {
				TemperatureTextDescription = "Body (general)";
			} else if (flag == 3) {
				TemperatureTextDescription = "Ear (usually ear lobe)";
			} else if (flag == 4) {
				TemperatureTextDescription = "Gastro-intestinal Tract";
			} else if (flag == 5) {
				TemperatureTextDescription = "Mouth";
			} else if (flag == 6) {
				TemperatureTextDescription = "Armpit";
			} else if (flag == 7) {
				TemperatureTextDescription = "Rectum";
			} else if (flag == 8) {
				TemperatureTextDescription = "Toe";
			} else if (flag == 9) {
				TemperatureTextDescription = "Tympanum (ear drum)";
			} else {
				TemperatureTextDescription = "Reserved for future use";
			}
		}

		bundle.putInt(EXTRA_VALUE0, flag);
		bundle.putString(EXTRA_VALUE1, TemperatureTextDescription);

		nextOffset[0] = offset;
		return MSG_temperature_type;
	}

	protected static void handle_temperature_type(Bundle bundle,
			IBluetoothGattCharacteristicHandler object)
			throws IllegalArgumentException {
		String sUUID = bundle.getString(BluetoothDevice.EXTRA_UUID);
		UUID aUUID = UUID.fromString(sUUID);
		if (!GATT_CHARACTERISTIC_temperature_type.equals(aUUID)) {
			throw new IllegalArgumentException(
					"The provided uuid is uncompatible with this method");
		}
		int flag = bundle.getInt(EXTRA_VALUE0);
		String TemperatureTextDescription = bundle.getString(EXTRA_VALUE1);

		object.on_temperature_type(bundle, flag, TemperatureTextDescription);

	}

	/**
	 * Accuracy (drift) of time information in steps of 1/8 of a second (125ms)
	 * compared to a reference time source. Valid range from 0 to 253 (0s to
	 * 31.5s). A value of 254 means Accuracy is out of range (> 31.5s). A value
	 * of 255 means Accuracy is unknown. Exponent: Binary, -3
	 * 
	 * @param bundle
	 * @param characteristic
	 * @param offset
	 * @return
	 */
	protected static int time_accuracy(Bundle bundle,
			BluetoothGattCharacteristic characteristic, int offset,
			int[] nextOffset) {
		// byte[] characteristicValue = characteristic.getValue();

		int Accuracy = characteristic.getIntValue(
				BluetoothGattCharacteristic.FORMAT_UINT8, offset);
		offset += UINT8_SIZE;
		bundle.putInt(EXTRA_VALUE0, Accuracy);

		nextOffset[0] = offset;
		return MSG_time_accuracy;
	}

	protected static void handle_time_accuracy(Bundle bundle,
			IBluetoothGattCharacteristicHandler object)
			throws IllegalArgumentException {
		String sUUID = bundle.getString(BluetoothDevice.EXTRA_UUID);
		UUID aUUID = UUID.fromString(sUUID);
		if (!GATT_CHARACTERISTIC_time_accuracy.equals(aUUID)) {
			throw new IllegalArgumentException(
					"The provided uuid is uncompatible with this method");
		}
		int Accuracy = bundle.getInt(EXTRA_VALUE0);

		object.on_time_accuracy(bundle, Accuracy);

	}

	/**
	 * not implemented
	 * 
	 * @param bundle
	 * @param characteristic
	 * @param offset
	 * @return
	 */
	protected static int time_broadcast(Bundle bundle,
			BluetoothGattCharacteristic characteristic, int offset,
			int[] nextOffset) {
		// byte[] characteristicValue = characteristic.getValue();

		nextOffset[0] = offset;
		return MSG_time_broadcast;
	}

	/**
	 * not implemented
	 * 
	 * @param bundle
	 * @param object
	 * @throws IllegalArgumentException
	 */
	protected static void handle_time_broadcast(Bundle bundle,
			IBluetoothGattCharacteristicHandler object)
			throws IllegalArgumentException {
		String sUUID = bundle.getString(BluetoothDevice.EXTRA_UUID);
		UUID aUUID = UUID.fromString(sUUID);
		if (!GATT_CHARACTERISTIC_time_broadcast.equals(aUUID)) {
			throw new IllegalArgumentException(
					"The provided uuid is uncompatible with this method");
		}

		object.on_default(bundle, sUUID);
	}

	protected static int time_source(Bundle bundle,
			BluetoothGattCharacteristic characteristic, int offset,
			int[] nextOffset) {
		// byte[] characteristicValue = characteristic.getValue();
		int TimeSource = characteristic.getIntValue(
				BluetoothGattCharacteristic.FORMAT_UINT8, offset);
		offset += UINT8_SIZE;
		String TimeSourceString = "Unknown";
		switch (TimeSource) {
		case 0:
			TimeSourceString = "Unknown";
			break;
		case 1:
			TimeSourceString = "Network Time Protocol";
			break;
		case 2:
			TimeSourceString = "GPS";
			break;
		case 3:
			TimeSourceString = "Radio Time Signal";
			break;
		case 4:
			TimeSourceString = "Manual";
			break;
		case 5:
			TimeSourceString = "Atomic Clock";
			break;
		case 6:
			TimeSourceString = "Cellular Network";
			break;
		default:
			TimeSourceString = "Reserved for future use";

		}
		bundle.putInt(EXTRA_VALUE0, TimeSource);
		bundle.putString(EXTRA_VALUE1, TimeSourceString);

		nextOffset[0] = offset;
		return MSG_time_source;
	}

	protected static void handle_time_source(Bundle bundle,
			IBluetoothGattCharacteristicHandler object)
			throws IllegalArgumentException {
		String sUUID = bundle.getString(BluetoothDevice.EXTRA_UUID);
		UUID aUUID = UUID.fromString(sUUID);
		if (!GATT_CHARACTERISTIC_time_source.equals(aUUID)) {
			throw new IllegalArgumentException(
					"The provided uuid is uncompatible with this method");
		}

		int TimeSource = bundle.getInt(EXTRA_VALUE0);
		String TimeSourceString = bundle.getString(EXTRA_VALUE1);

		object.on_time_source(bundle, TimeSource, TimeSourceString);
	}

	protected static int time_update_control_point(Bundle bundle,
			BluetoothGattCharacteristic characteristic, int offset,
			int[] nextOffset) {
		// byte[] characteristicValue = characteristic.getValue();
		int TimeUpdateControlPoint = characteristic.getIntValue(
				BluetoothGattCharacteristic.FORMAT_UINT8, offset);
		offset += UINT8_SIZE;
		String TimeUpdateControlPointString = "Unknown";
		switch (TimeUpdateControlPoint) {
		case 0:
			TimeUpdateControlPointString = "Unknown";
			break;
		case 1:
			TimeUpdateControlPointString = "Get Reference Update";
			break;
		case 2:
			TimeUpdateControlPointString = "Cancel Reference Update";
			break;
		case 3:
			TimeUpdateControlPointString = "Reserved for future use";
			break;
		default:
			TimeUpdateControlPointString = "Reserved";

		}
		bundle.putInt(EXTRA_VALUE0, TimeUpdateControlPoint);
		bundle.putString(EXTRA_VALUE1, TimeUpdateControlPointString);

		nextOffset[0] = offset;
		return MSG_time_update_control_point;
	}

	protected static void handle_time_update_control_point(Bundle bundle,
			IBluetoothGattCharacteristicHandler object)
			throws IllegalArgumentException {
		String sUUID = bundle.getString(BluetoothDevice.EXTRA_UUID);
		UUID aUUID = UUID.fromString(sUUID);
		if (!GATT_CHARACTERISTIC_time_update_control_point.equals(aUUID)) {
			throw new IllegalArgumentException(
					"The provided uuid is uncompatible with this method");
		}

		int TimeUpdateControlPoint = bundle.getInt(EXTRA_VALUE0);
		String TimeUpdateControlPointString = bundle.getString(EXTRA_VALUE1);

		object.on_time_update_control_point(bundle, TimeUpdateControlPoint,
				TimeUpdateControlPointString);
	}

	protected static int time_update_state(Bundle bundle,
			BluetoothGattCharacteristic characteristic, int offset,
			int[] nextOffset) {
		// byte[] characteristicValue = characteristic.getValue();
		int CurrentState = characteristic.getIntValue(
				BluetoothGattCharacteristic.FORMAT_UINT8, offset);
		offset += UINT8_SIZE;
		String CurrentStateString = "Reserved";
		switch (CurrentState) {
		case 0:
			CurrentStateString = "Idle";
			break;
		case 1:
			CurrentStateString = "Update Pending";
			break;
		default:
			CurrentStateString = "Reserved";
		}
		int Result = characteristic.getIntValue(
				BluetoothGattCharacteristic.FORMAT_UINT8, offset);
		String ResultString = "Reserved";
		offset += UINT8_SIZE;
		switch (Result) {
		case 0:
			ResultString = "Successful";
			break;
		case 1:
			ResultString = "Canceled";
			break;
		case 2:
			ResultString = "No Connection To Reference";
			break;
		case 3:
			ResultString = "Reference responded with an error";
			break;
		case 4:
			ResultString = "Timeout";
			break;
		case 5:
			ResultString = "Update not attempted after reset";
			break;
		default:
			ResultString = "Reserved";
		}

		bundle.putInt(EXTRA_VALUE0, CurrentState);
		bundle.putString(EXTRA_VALUE1, CurrentStateString);
		bundle.putInt(EXTRA_VALUE2, Result);
		bundle.putString(EXTRA_VALUE3, ResultString);

		nextOffset[0] = offset;
		return MSG_time_update_state;
	}

	protected static void handle_time_update_state(Bundle bundle,
			IBluetoothGattCharacteristicHandler object)
			throws IllegalArgumentException {
		String sUUID = bundle.getString(BluetoothDevice.EXTRA_UUID);
		UUID aUUID = UUID.fromString(sUUID);
		if (!GATT_CHARACTERISTIC_time_update_state.equals(aUUID)) {
			throw new IllegalArgumentException(
					"The provided uuid is uncompatible with this method");
		}
		int CurrentState = bundle.getInt(EXTRA_VALUE0);
		String CurrentStateString = bundle.getString(EXTRA_VALUE1);
		int Result = bundle.getInt(EXTRA_VALUE2);
		String ResultString = bundle.getString(EXTRA_VALUE3);

		object.on_time_update_state(bundle, CurrentState, CurrentStateString,
				Result, ResultString);
	}

	protected static int time_with_dst(Bundle bundle,
			BluetoothGattCharacteristic characteristic, int offset,
			int[] nextOffset) {
		// byte[] characteristicValue = characteristic.getValue();

		Bundle b0 = new Bundle();
		date_time(b0, characteristic, offset, nextOffset);
		offset = nextOffset[0];
		int[] dateTimeArray = b0.getIntArray(EXTRA_VALUE0);

		Bundle b1 = new Bundle();
		dst_offset(b1, characteristic, offset, nextOffset);
		offset = nextOffset[0];
		offset += UINT8_SIZE;
		int dSTOffset = b1.getInt(EXTRA_VALUE0);
		String dSTOffsetValue = b1.getString(EXTRA_VALUE1);

		bundle.putIntArray(EXTRA_VALUE0, dateTimeArray);
		bundle.putInt(EXTRA_VALUE1, dSTOffset);
		bundle.putString(EXTRA_VALUE2, dSTOffsetValue);

		nextOffset[0] = offset;
		return MSG_time_with_dst;
	}

	protected static void handle_time_with_dst(Bundle bundle,
			IBluetoothGattCharacteristicHandler object)
			throws IllegalArgumentException {
		String sUUID = bundle.getString(BluetoothDevice.EXTRA_UUID);
		UUID aUUID = UUID.fromString(sUUID);
		if (!GATT_CHARACTERISTIC_time_with_dst.equals(aUUID)) {
			throw new IllegalArgumentException(
					"The provided uuid is uncompatible with this method");
		}

		int[] dateTimeArray = bundle.getIntArray(EXTRA_VALUE0);
		int dSTOffset = bundle.getInt(EXTRA_VALUE1);
		String dSTOffsetValue = bundle.getString(EXTRA_VALUE2);
		Calendar date = dateValuesArrayAsCalendar(dateTimeArray);
		object.on_time_with_dst(bundle, date, dSTOffset, dSTOffsetValue);
	}

	protected static int time_zone(Bundle bundle,
			BluetoothGattCharacteristic characteristic, int offset,
			int[] nextOffset) {
		// byte[] characteristicValue = characteristic.getValue();

		int TimeZone = characteristic.getIntValue(
				BluetoothGattCharacteristic.FORMAT_SINT8, offset);
		offset += SINT8_SIZE;
		String TimeZoneString = "time zone offset is not known";
		switch (TimeZone) {
		case -48:
			TimeZoneString = "UTC-12:00";
			break;
		case -44:
			TimeZoneString = "UTC-11:00";
			break;
		case -40:
			TimeZoneString = "UTC-10:00";
			break;
		case -38:
			TimeZoneString = "UTC-9:30";
			break;
		case -36:
			TimeZoneString = "UTC-9:00";
			break;
		case -32:
			TimeZoneString = "UTC-8:00";
			break;
		case -28:
			TimeZoneString = "UTC-7:00";
			break;
		case -24:
			TimeZoneString = "UTC-6:00";
			break;
		case -20:
			TimeZoneString = "UTC-5:00";
			break;
		case -18:
			TimeZoneString = "UTC-4:30";
			break;
		case -16:
			TimeZoneString = "UTC-4:00";
			break;
		case -14:
			TimeZoneString = "UTC-3:30";
			break;
		case -12:
			TimeZoneString = "UTC-3:00";
			break;
		case -8:
			TimeZoneString = "UTC-2:00";
			break;
		case -4:
			TimeZoneString = "UTC-1:00";
			break;
		case 0:
			TimeZoneString = "UTC+0:00";
			break;
		case 4:
			TimeZoneString = "UTC+1:00";
			break;
		case 8:
			TimeZoneString = "UTC+2:00";
			break;
		case 12:
			TimeZoneString = "UTC+3:00";
			break;
		case 14:
			TimeZoneString = "UTC+3:30";
			break;
		case 16:
			TimeZoneString = "UTC+4:00";
			break;
		case 18:
			TimeZoneString = "UTC+4:30";
			break;
		case 20:
			TimeZoneString = "UTC+5:00";
			break;
		case 22:
			TimeZoneString = "UTC+5:30";
			break;
		case 23:
			TimeZoneString = "UTC+5:45";
			break;
		case 24:
			TimeZoneString = "UTC+6:00";
			break;
		case 26:
			TimeZoneString = "UTC+6:30";
			break;
		case 28:
			TimeZoneString = "UTC+7:00";
			break;
		case 32:
			TimeZoneString = "UTC+8:00";
			break;
		case 35:
			TimeZoneString = "UTC+8:45";
			break;
		case 36:
			TimeZoneString = "UTC+9:00";
			break;
		case 38:
			TimeZoneString = "UTC+9:30";
			break;
		case 40:
			TimeZoneString = "UTC+10:00";
			break;
		case 42:
			TimeZoneString = "UTC+10:30";
			break;
		case 44:
			TimeZoneString = "UTC+11:00";
			break;
		case 46:
			TimeZoneString = "UTC+11:30";
			break;
		case 48:
			TimeZoneString = "UTC+12:00";
			break;
		case 51:
			TimeZoneString = "UTC+12:45";
			break;
		case 52:
			TimeZoneString = "UTC+13:00";
			break;
		case 56:
			TimeZoneString = "UTC+14:00";
			break;
		default:
			TimeZoneString = "time zone offset is not known";
		}

		bundle.putInt(EXTRA_VALUE0, TimeZone);
		bundle.putString(EXTRA_VALUE1, TimeZoneString);

		nextOffset[0] = offset;
		return MSG_time_zone;
	}

	protected static void handle_time_zone(Bundle bundle,
			IBluetoothGattCharacteristicHandler object)
			throws IllegalArgumentException {
		String sUUID = bundle.getString(BluetoothDevice.EXTRA_UUID);
		UUID aUUID = UUID.fromString(sUUID);
		if (!GATT_CHARACTERISTIC_time_zone.equals(aUUID)) {
			throw new IllegalArgumentException(
					"The provided uuid is uncompatible with this method");
		}
		int TimeZone = bundle.getInt(EXTRA_VALUE0);
		String TimeZoneString = bundle.getString(EXTRA_VALUE1);

		object.on_time_zone(bundle, TimeZone, TimeZoneString);
	}

	protected static int tx_power_level(Bundle bundle,
			BluetoothGattCharacteristic characteristic, int offset,
			int[] nextOffset) {
		// byte[] characteristicValue = characteristic.getValue();

		int txPoxerLevel = characteristic.getIntValue(
				BluetoothGattCharacteristic.FORMAT_SINT8, 0);
		offset += UINT8_SIZE;
		bundle.putInt(EXTRA_VALUE0, txPoxerLevel);

		nextOffset[0] = offset;
		return MSG_tx_power_level;
	}

	protected static void handle_tx_power_level(Bundle bundle,
			IBluetoothGattCharacteristicHandler object)
			throws IllegalArgumentException {
		String sUUID = bundle.getString(BluetoothDevice.EXTRA_UUID);
		UUID aUUID = UUID.fromString(sUUID);
		if (!GATT_CHARACTERISTIC_tx_power_level.equals(aUUID)) {
			throw new IllegalArgumentException(
					"The provided uuid is uncompatible with this method");
		}
		int txPoxer = bundle.getInt(EXTRA_VALUE0);

		object.on_tx_power_level(bundle, txPoxer);
	}

	protected static int unread_alert_status(Bundle bundle,
			BluetoothGattCharacteristic characteristic, int offset,
			int[] nextOffset) {
		// byte[] characteristicValue = characteristic.getValue();
		Bundle b0 = new Bundle();
		alert_category_id(b0, characteristic, offset, nextOffset);
		offset = nextOffset[0];

		int Unreadcount = characteristic.getIntValue(
				BluetoothGattCharacteristic.FORMAT_UINT8, offset);
		offset += UINT8_SIZE;

		int categoryId = b0.getInt(EXTRA_VALUE0);
		String comment = b0.getString(EXTRA_VALUE1);

		bundle.putInt(EXTRA_VALUE0, categoryId);
		bundle.putString(EXTRA_VALUE1, comment);
		bundle.putInt(EXTRA_VALUE2, Unreadcount);

		nextOffset[0] = offset;
		return MSG_unread_alert_status;
	}

	protected static void handle_unread_alert_status(Bundle bundle,
			IBluetoothGattCharacteristicHandler object)
			throws IllegalArgumentException {
		String sUUID = bundle.getString(BluetoothDevice.EXTRA_UUID);
		UUID aUUID = UUID.fromString(sUUID);
		if (!GATT_CHARACTERISTIC_unread_alert_status.equals(aUUID)) {
			throw new IllegalArgumentException(
					"The provided uuid is uncompatible with this method");
		}

		int categoryId = bundle.getInt(EXTRA_VALUE0);
		String comment = bundle.getString(EXTRA_VALUE1);
		int Unreadcount = bundle.getInt(EXTRA_VALUE2);

		object.on_unread_alert_status(bundle, categoryId, comment, Unreadcount);
	}

	// -----------------------BLUEGIGA EXAMPLES

	protected static int bluegiga_manufacturer_id(Bundle bundle,
			BluetoothGattCharacteristic characteristic, int offset,
			int[] nextOffset) {
		byte[] characteristicValue = characteristic.getValue();
		int length = characteristicValue.length;
		String hex = getHex(characteristic, length, offset, nextOffset);
		bundle.putString(EXTRA_VALUE0, hex);

		return MSG_bluegiga_manufacturer_id;
	}

	protected static void handle_bluegiga_manufacturer_id(Bundle bundle,
			IBluetoothGattCharacteristicHandler object)
			throws IllegalArgumentException {
		String sUUID = bundle.getString(BluetoothDevice.EXTRA_UUID);
		UUID aUUID = UUID.fromString(sUUID);
		if (!GATT_CHARACTERISTIC_bluegiga_manufacturer_id.equals(aUUID)) {
			throw new IllegalArgumentException(
					"The provided uuid is uncompatible with this method");
		}
		String hex = bundle.getString(EXTRA_VALUE0);

		object.on_bluegiga_manufacturer_id(bundle, hex);
	}

	protected static int bluegiga_model_number(Bundle bundle,
			BluetoothGattCharacteristic characteristic, int offset,
			int[] nextOffset) {
		byte[] characteristicValue = characteristic.getValue();
		int length = characteristicValue.length;
		String hex = getHex(characteristic, length, offset, nextOffset);
		bundle.putString(EXTRA_VALUE0, hex);

		return MSG_bluegiga_model_number;
	}

	protected static void handle_bluegiga_model_number(Bundle bundle,
			IBluetoothGattCharacteristicHandler object)
			throws IllegalArgumentException {
		String sUUID = bundle.getString(BluetoothDevice.EXTRA_UUID);
		UUID aUUID = UUID.fromString(sUUID);
		if (!GATT_CHARACTERISTIC_bluegiga_model_number.equals(aUUID)) {
			throw new IllegalArgumentException(
					"The provided uuid is uncompatible with this method");
		}
		String hex = bundle.getString(EXTRA_VALUE0);

		object.on_bluegiga_model_number(bundle, hex);
	}

	protected static int bluegiga_manufacturer_name(Bundle bundle,
			BluetoothGattCharacteristic characteristic, int offset,
			int[] nextOffset) {
		byte[] characteristicValue = characteristic.getValue();
		int length = characteristicValue.length;
		String bluegigaMnufacturerName = characteristic.getStringValue(offset);
		bundle.putString(EXTRA_VALUE0, bluegigaMnufacturerName);

		return MSG_bluegiga_manufacturer_name;
	}

	protected static void handle_bluegiga_manufacturer_name(Bundle bundle,
			IBluetoothGattCharacteristicHandler object)
			throws IllegalArgumentException {
		String sUUID = bundle.getString(BluetoothDevice.EXTRA_UUID);
		UUID aUUID = UUID.fromString(sUUID);
		if (!GATT_CHARACTERISTIC_bluegiga_manufacturer_name.equals(aUUID)) {
			throw new IllegalArgumentException(
					"The provided uuid is uncompatible with this method");
		}
		String hex = bundle.getString(EXTRA_VALUE0);

		object.on_bluegiga_manufacturer_name(bundle, hex);
	}

	/**
	 * Bluegiga dkble112 sample <service uuid="e001"> <description>Battery
	 * status</description> <include id="manufacturer" /> <characteristic
	 * uuid="e101" id="xgatt_battery"> <properties read="true" /> <value
	 * type="hex">ABCD</value> </characteristic> </service>
	 * 
	 * @param bundle
	 * @param characteristic
	 * @return response id to put in message.what
	 */
	protected static int bluegiga_xgatt_battery(Bundle bundle,
			BluetoothGattCharacteristic characteristic, int offset,
			int[] nextOffset) {
		byte[] characteristicValue = characteristic.getValue();

		String xgatt_battery = getHex(characteristic,
				characteristicValue.length, offset, nextOffset);
		offset = nextOffset[0];
		bundle.putString(EXTRA_VALUE0, xgatt_battery);

		nextOffset[0] = offset;
		return MSG_bluegiga_xgatt_battery;
	}

	/**
	 * bluegiga development kit example calls object.on_bluegiga_Battery(Bundle
	 * bundle, String value);
	 * 
	 * 
	 * @param bundle
	 * @param object
	 * @throws IllegalArgumentException
	 */
	protected static void handle_bluegiga_xgatt_battery(Bundle bundle,
			IBluetoothGattCharacteristicHandler object)
			throws IllegalArgumentException {
		String sUUID = bundle.getString(BluetoothDevice.EXTRA_UUID);
		UUID aUUID = UUID.fromString(sUUID);
		if (!GATT_CHARACTERISTIC_bluegiga_xgatt_battery.equals(aUUID)) {
			throw new IllegalArgumentException(
					"The provided uuid is uncompatible with this method");
		}

		String value = bundle.getString(EXTRA_VALUE0);

		object.on_bluegiga_Battery(bundle, value);
	}

	protected static int bluegiga_accelerometer_x_data(Bundle bundle,
			BluetoothGattCharacteristic characteristic, int offset,
			int[] nextOffset) {
		// byte[] characteristicValue = characteristic.getValue();
		int x_datai = characteristic.getIntValue(
				BluetoothGattCharacteristic.FORMAT_SINT16, offset);
		float x_data = characteristic.getFloatValue(
				BluetoothGattCharacteristic.FORMAT_SFLOAT, offset);
		offset += SFLOAT_SIZE;
		bundle.putFloat(EXTRA_VALUE0, x_data);

		nextOffset[0] = offset;
		return MSG_bluegiga_accelerometer_x_data;
	}

	protected static void handle_bluegiga_accelerometer_x_data(Bundle bundle,
			IBluetoothGattCharacteristicHandler object)
			throws IllegalArgumentException {
		String sUUID = bundle.getString(BluetoothDevice.EXTRA_UUID);
		UUID aUUID = UUID.fromString(sUUID);
		if (!GATT_CHARACTERISTIC_bluegiga_accelerometer_x_data.equals(aUUID)) {
			throw new IllegalArgumentException(
					"The provided uuid is uncompatible with this method");
		}

		float x_data = bundle.getFloat(EXTRA_VALUE0);

		object.on_handle_bluegiga_accelerometer_x_data(bundle, x_data);
	}

	protected static int bluegiga_accelerometer_y_data(Bundle bundle,
			BluetoothGattCharacteristic characteristic, int offset,
			int[] nextOffset) {
		// byte[] characteristicValue = characteristic.getValue();

		int y_datai = characteristic.getIntValue(
				BluetoothGattCharacteristic.FORMAT_SINT16, offset);
		float y_data = characteristic.getFloatValue(
				BluetoothGattCharacteristic.FORMAT_SFLOAT, offset);
		offset += SFLOAT_SIZE;
		bundle.putFloat(EXTRA_VALUE0, y_data);

		nextOffset[0] = offset;
		return MSG_bluegiga_accelerometer_y_data;
	}

	protected static void handle_bluegiga_accelerometer_y_data(Bundle bundle,
			IBluetoothGattCharacteristicHandler object)
			throws IllegalArgumentException {
		String sUUID = bundle.getString(BluetoothDevice.EXTRA_UUID);
		UUID aUUID = UUID.fromString(sUUID);
		if (!GATT_CHARACTERISTIC_bluegiga_accelerometer_y_data.equals(aUUID)) {
			throw new IllegalArgumentException(
					"The provided uuid is uncompatible with this method");
		}

		float y_data = bundle.getFloat(EXTRA_VALUE0);

		object.on_handle_bluegiga_accelerometer_y_data(bundle, y_data);
	}

	protected static int bluegiga_accelerometer_z_data(Bundle bundle,
			BluetoothGattCharacteristic characteristic, int offset,
			int[] nextOffset) {
		// byte[] characteristicValue = characteristic.getValue();
		int _offset = offset;
		int z_datai = characteristic.getIntValue(
				BluetoothGattCharacteristic.FORMAT_SINT16, _offset);
		float z_data = characteristic.getFloatValue(
				BluetoothGattCharacteristic.FORMAT_SFLOAT, _offset);
		_offset += SFLOAT_SIZE;
		bundle.putFloat(EXTRA_VALUE0, z_data);

		nextOffset[0] = _offset;
		return MSG_bluegiga_accelerometer_z_data;
	}

	protected static void handle_bluegiga_accelerometer_z_data(Bundle bundle,
			IBluetoothGattCharacteristicHandler object)
			throws IllegalArgumentException {
		String sUUID = bundle.getString(BluetoothDevice.EXTRA_UUID);
		UUID aUUID = UUID.fromString(sUUID);
		if (!GATT_CHARACTERISTIC_bluegiga_accelerometer_z_data.equals(aUUID)) {
			throw new IllegalArgumentException(
					"The provided uuid is uncompatible with this method");
		}
		float z_data = bundle.getFloat(EXTRA_VALUE0);

		object.on_handle_bluegiga_accelerometer_z_data(bundle, z_data);
	}

	protected static int asica_heart_rate(Bundle bundle,
			BluetoothGattCharacteristic characteristic, int offset,
			int[] nextOffset) {
		int _offset = offset;
		int[] date = new int[6];
		_offset = getDateTime(characteristic, date, _offset);
		bundle.putIntArray(EXTRA_VALUE0, date);
		bundle.putString(EXTRA_VALUE0_NAME, "Date [yy, mm, dd, hh, mm, ss]");

		int heartRate = characteristic.getIntValue(
				BluetoothGattCharacteristic.FORMAT_UINT8, _offset);
		_offset += UINT8_SIZE;
		bundle.putInt(EXTRA_VALUE1, heartRate);
		Log.i(TAG, "heartRate " + heartRate);
		nextOffset[0] = _offset;

		return MSG_asica_heart_rate;
	}

	/**
	 * heart rate given by Asica is the number of heartbeats on 30mn
	 * it is transformed on the minute
	 * 
	 * @param bundle
	 * @param object
	 * @throws IllegalArgumentException
	 */
	protected static void handle_asica_heart_rate(Bundle bundle,
			IBluetoothGattCharacteristicHandler object)
			throws IllegalArgumentException {
		String sUUID = bundle.getString(BluetoothDevice.EXTRA_UUID);
		UUID aUUID = UUID.fromString(sUUID);
		if (!GATT_CHARACTERISTIC_asica_heart_rate.equals(aUUID)) {
			throw new IllegalArgumentException(
					"The provided uuid is uncompatible with this method");
		}

		int[] baseTime = bundle.getIntArray(EXTRA_VALUE0);
		int heartRatePerMn = bundle.getInt(EXTRA_VALUE1) * 2;
		correctAsicaYearBigEndianness(baseTime, BluetoothGattCharacteristic.FORMAT_UINT16,CORRECT_ASICA_ENDIANNESS_BUG);
		Calendar date = dateValuesArrayAsCalendar(baseTime);

		object.on_handle_asica_heart_rate(bundle, date, heartRatePerMn);
	}

	protected static int asica_fall_detection_alert(Bundle bundle,
			BluetoothGattCharacteristic characteristic, int offset,
			int[] nextOffset) {
		int _offset = offset;
		int[] date = new int[6];
		_offset = getDateTime(characteristic, date, _offset);
		bundle.putIntArray(EXTRA_VALUE0, date);
		bundle.putString(EXTRA_VALUE0_NAME, "Date [yy, mm, dd, hh, mm, ss]");

		int flags = characteristic.getIntValue(
				BluetoothGattCharacteristic.FORMAT_UINT8, _offset);

		int bitShift = 0;
		Log.d(TAG, "shift " + bitShift + " " + ((1 << bitShift) >> bitShift));
		int alert = (flags & (1 << bitShift)) >> bitShift++;
		Log.d(TAG, "shift " + bitShift + " " + ((1 << bitShift) >> bitShift));
		int fall = (flags & (1 << bitShift)) >> bitShift++;
		Log.d(TAG, "shift " + bitShift + " " + ((1 << bitShift) >> bitShift));
		int lowBattery = (flags & (1 << bitShift)) >> bitShift++;
		Log.d(TAG, "shift " + bitShift + " " + ((1 << bitShift) >> bitShift));
		int holterRequest = (flags & (1 << bitShift)) >> bitShift;
		Log.d(TAG, "shift " + bitShift + " " + ((1 << bitShift) >> bitShift));
		bitShift += 2;
		int futureUse = (flags & (1 << bitShift)) >> bitShift;
		bitShift += 2;
		_offset += UINT8_SIZE;

		nextOffset[0] = _offset;

		bundle.putInt(EXTRA_VALUE1, alert);
		bundle.putString(EXTRA_VALUE1_NAME, "alert");
		bundle.putInt(EXTRA_VALUE2, fall);
		bundle.putString(EXTRA_VALUE2_NAME, "fall detection");
		bundle.putInt(EXTRA_VALUE3, lowBattery);
		bundle.putString(EXTRA_VALUE3_NAME, "low battery");
		bundle.putInt(EXTRA_VALUE4, holterRequest);
		bundle.putString(EXTRA_VALUE4_NAME, "fall detector status changed");
		bundle.putInt(EXTRA_VALUE5, futureUse);
		bundle.putString(EXTRA_VALUE5_NAME, "future use");

		return MSG_asica_fall_detection_alert;
	}

	protected static void handle_asica_fall_detection_alert(Bundle bundle,
			IBluetoothGattCharacteristicHandler object)
			throws IllegalArgumentException {
		String sUUID = bundle.getString(BluetoothDevice.EXTRA_UUID);
		UUID aUUID = UUID.fromString(sUUID);
		if (!GATT_CHARACTERISTIC_asica_fall_detection_alert.equals(aUUID)) {
			throw new IllegalArgumentException(
					"The provided uuid is uncompatible with this method");
		}

		int[] baseTime = bundle.getIntArray(EXTRA_VALUE0);
		correctAsicaYearBigEndianness(baseTime, BluetoothGattCharacteristic.FORMAT_UINT16,CORRECT_ASICA_ENDIANNESS_BUG);
		Calendar date = dateValuesArrayAsCalendar(baseTime);

		boolean alertButton = bundle.getInt(EXTRA_VALUE1) == 1;
		boolean fall = bundle.getInt(EXTRA_VALUE2) == 1;
		boolean lowBattery = bundle.getInt(EXTRA_VALUE3) == 1;
		boolean holterRequest = bundle.getInt(EXTRA_VALUE4) == 1;
		int futureUse = bundle.getInt(EXTRA_VALUE5);

		object.on_handle_asica_fall_detection_alert(bundle, date, alertButton,
				fall, lowBattery, holterRequest, futureUse);
	}

	protected static int asica_ambulatory_terminal_state(Bundle bundle,
			BluetoothGattCharacteristic characteristic, int offset,
			int[] nextOffset) {

		int _offset = offset;
		int[] date = new int[6];
		_offset = getDateTime(characteristic, date, _offset);
		bundle.putIntArray(EXTRA_VALUE0, date);
		bundle.putString(EXTRA_VALUE0_NAME, "Date [yy, mm, dd, hh, mm, ss]");

		int flags = characteristic.getIntValue(
				BluetoothGattCharacteristic.FORMAT_UINT8, _offset);

		int bitShift = 0;

		int fallDetectorWear = (flags & (1 << bitShift)) >> bitShift++;
		int personPosition = (flags & (1 << bitShift)) >> bitShift++;
		int earlobeSensorOff = (flags & (1 << bitShift)) >> bitShift++;
		int earlobeUnplugged = (flags & (1 << bitShift)) >> bitShift++;
		int futureUse = (flags & (1 << bitShift)) >> bitShift;

		_offset += UINT8_SIZE;

		nextOffset[0] = _offset;

		bundle.putInt(EXTRA_VALUE1, fallDetectorWear);
		bundle.putString(EXTRA_VALUE1_NAME, "fall detector is weared");
		bundle.putInt(EXTRA_VALUE2, personPosition);
		bundle.putString(EXTRA_VALUE2_NAME,
				"person position 0 lying down, 1 up");
		bundle.putInt(EXTRA_VALUE3, earlobeSensorOff);
		bundle.putString(EXTRA_VALUE3_NAME, "earlobe sensor on 0, off 1 ");
		bundle.putInt(EXTRA_VALUE4, earlobeUnplugged);
		bundle.putString(EXTRA_VALUE4_NAME,
				"earlobe sensor plugged 0, unplugged 1 ");
		bundle.putInt(EXTRA_VALUE5, futureUse);
		bundle.putString(EXTRA_VALUE5_NAME, "future use");

		return MSG_asica_ambulatory_terminal_state;
	}

	protected static void handle_asica_ambulatory_terminal_state(Bundle bundle,
			IBluetoothGattCharacteristicHandler object)
			throws IllegalArgumentException {
		String sUUID = bundle.getString(BluetoothDevice.EXTRA_UUID);
		UUID aUUID = UUID.fromString(sUUID);
		if (!GATT_CHARACTERISTIC_asica_AT_state.equals(aUUID)) {
			throw new IllegalArgumentException(
					"The provided uuid is uncompatible with this method");
		}

		int[] baseTime = bundle.getIntArray(EXTRA_VALUE0);
		int year = baseTime[0];
		// corrects Big endians on year
		correctAsicaYearBigEndianness(baseTime, BluetoothGattCharacteristic.FORMAT_UINT16,CORRECT_ASICA_ENDIANNESS_BUG);
		Calendar date = dateValuesArrayAsCalendar(baseTime);
		

		boolean ambulatoryTerminalWear = bundle.getInt(EXTRA_VALUE1) == 1;
		boolean horizontal = bundle.getInt(EXTRA_VALUE2) == 1;
		boolean earlobeSensorOff = bundle.getInt(EXTRA_VALUE3) == 1;
		boolean earlobeUnplugged = bundle.getInt(EXTRA_VALUE4) == 1;
		int futureUse = bundle.getInt(EXTRA_VALUE5);

		object.on_asica_ambulatory_terminal_state(bundle, date,
				ambulatoryTerminalWear, horizontal, earlobeSensorOff,
				earlobeUnplugged, futureUse);
	}

	protected static int asica_ambulatory_terminal_activity(Bundle bundle,
			BluetoothGattCharacteristic characteristic, int offset,
			int[] nextOffset) {
		int _offset = offset;
		int[] date = new int[6];
		_offset = getDateTime(characteristic, date, _offset);
		bundle.putIntArray(EXTRA_VALUE0, date);
		bundle.putString(EXTRA_VALUE0_NAME, "Date [yy, mm, dd, hh, mm, ss]");

		int flags = characteristic.getIntValue(
				BluetoothGattCharacteristic.FORMAT_UINT8, _offset);
		int bitShift = 0;
		int activity = (flags & (1 << bitShift)) >> bitShift;
		bitShift += 7;
		int futureUse = (flags & (1 << bitShift)) >> bitShift++;
		_offset += UINT8_SIZE;

		nextOffset[0] = _offset;

		bundle.putInt(EXTRA_VALUE1, activity);
		bundle.putString(EXTRA_VALUE1_NAME, "person activity from 0 to 100");
		bundle.putInt(EXTRA_VALUE2, futureUse);
		bundle.putString(EXTRA_VALUE2_NAME, "future use");

		return MSG_asica_fall_detection_activity;
	}

	protected static void handle_asica_ambulatory_terminal_activity(
			Bundle bundle, IBluetoothGattCharacteristicHandler object)
			throws IllegalArgumentException {

		String sUUID = bundle.getString(BluetoothDevice.EXTRA_UUID);
		UUID aUUID = UUID.fromString(sUUID);
		if (!GATT_CHARACTERISTIC_asica_fall_detection_activity.equals(aUUID)) {
			throw new IllegalArgumentException(
					"The provided uuid is uncompatible with this method");
		}

		int[] baseTime = bundle.getIntArray(EXTRA_VALUE0);
		correctAsicaYearBigEndianness(baseTime, BluetoothGattCharacteristic.FORMAT_UINT16,CORRECT_ASICA_ENDIANNESS_BUG);
		Calendar date = dateValuesArrayAsCalendar(baseTime);

		int activity = bundle.getInt(EXTRA_VALUE1);
		int futureUse = bundle.getInt(EXTRA_VALUE2);

		object.on_asica_ambulatory_terminal_activity(bundle, date, activity,
				futureUse);
	}
	
	
	public static void write_asica_fall_detection_hour_reset_request(Bundle bundle,
			BluetoothGattCharacteristic characteristic, int offset,
			int[] nextOffset){
		int _offset = offset;
		int[] date = bundle.getIntArray(EXTRA_VALUE0);
		correctAsicaYearBigEndianness(date, BluetoothGattCharacteristic.FORMAT_UINT16,CORRECT_ASICA_ENDIANNESS_BUG);
		_offset = setDateTime(characteristic, date, _offset);
		nextOffset[0] = _offset;
	}
	
	public static Calendar dateValuesArrayAsCalendar(int[] baseTime){
		Calendar date = Calendar.getInstance();
		date.set(baseTime[0], baseTime[1]-1, baseTime[2], baseTime[3],
				baseTime[4], baseTime[5]);
		if(baseTime.length == 7){
			date.set(Calendar.MILLISECOND, baseTime[6]);
		}
		return date;
	}
	

	/**
	 * 
	 * 7 bytes [yy,mm,dd,hh,mm,ss]
	 * caution months go from 1 to 12 and Java Calendar Months go from 0 to 11.
	 * yy = 0 means Year is not known
	 * mm = 0 means Month is not known
	 * dd = 0 means Day of Month is not known
	 * 
	 * @param characteristic
	 * @param date
	 *            date a minimum of int[6]
	 * @param offset
	 * @return [yy,mm,dd,hh,mm,ss,....]
	 * 
	 */
	public static int getDateTime(BluetoothGattCharacteristic characteristic,
			int[] date, int offset) {

		int _offset = offset;

		// year
		date[0] = characteristic.getIntValue(
				BluetoothGattCharacteristic.FORMAT_UINT16, _offset);
		_offset +=UINT16_SIZE;
		// month
		date[1] = characteristic.getIntValue(
				BluetoothGattCharacteristic.FORMAT_UINT8, _offset);
		_offset += UINT8_SIZE;
		// day
		date[2] = characteristic.getIntValue(
				BluetoothGattCharacteristic.FORMAT_UINT8, _offset);
		_offset += UINT8_SIZE;
		// hours
		date[3] = characteristic.getIntValue(
				BluetoothGattCharacteristic.FORMAT_UINT8, _offset);
		_offset += UINT8_SIZE;
		// minutes
		date[4] = characteristic.getIntValue(
				BluetoothGattCharacteristic.FORMAT_UINT8, _offset);
		_offset += UINT8_SIZE;
		// seconds
		date[5] = characteristic.getIntValue(
				BluetoothGattCharacteristic.FORMAT_UINT8, _offset);
		_offset += UINT8_SIZE;

		return _offset;
	}
	
	/**
	 * caution
	 * yy = 0 means Year is not known
	 * mm = 0 means Month is not known
	 * dd = 0 means Day of Month is not known
	 * 
	 * @param characteristic
	 * @param date
	 * @param offset
	 * @return
	 */
	private static int setDateTime(BluetoothGattCharacteristic characteristic,
			int[] date, int offset) {
		int _offset = offset;
		
		// it is important to set the length of the buffer before modifying each value independently
		byte[] bytes = new byte[7];
		characteristic.setValue(bytes);
		
		// year
		characteristic.setValue(date[0],BluetoothGattCharacteristic.FORMAT_UINT16, _offset);
		_offset += SINT16_SIZE;
		// month
		characteristic.setValue(date[1],
				BluetoothGattCharacteristic.FORMAT_UINT8, _offset);
		_offset += UINT8_SIZE;
		// day
		characteristic.setValue(date[2],
				BluetoothGattCharacteristic.FORMAT_UINT8, _offset);
		_offset += UINT8_SIZE;
		// hours
		characteristic.setValue(date[3],
				BluetoothGattCharacteristic.FORMAT_UINT8, _offset);
		_offset += UINT8_SIZE;
		// minutes
		characteristic.setValue(date[4],
				BluetoothGattCharacteristic.FORMAT_UINT8, _offset);
		_offset += UINT8_SIZE;
		// seconds
		characteristic.setValue(date[5],
				BluetoothGattCharacteristic.FORMAT_UINT8, _offset);
		_offset += UINT8_SIZE;
		return _offset;
	}
	
	public static int[] timeNowAsIntArray(){
		Calendar date = Calendar.getInstance();
		return calendarAsIntArray(date);
	}
	
	public static int[] calendarAsIntArray(Calendar date){
		int[] utcTime = new int[7];
		utcTime[0] = date.get(Calendar.YEAR);
		utcTime[1] = date.get(Calendar.MONTH)+1;
		utcTime[2] = date.get(Calendar.DATE);
		utcTime[3] = date.get(Calendar.HOUR_OF_DAY);
		utcTime[4] = date.get(Calendar.MINUTE);
		utcTime[5] = date.get(Calendar.SECOND);
		utcTime[6] = date.get(Calendar.MILLISECOND);
		return utcTime;
	}

	/**
	 * @param characteristic
	 * @param date
	 *            a minimum of int[7]
	 * @param offset
	 * @return [yy,mm,dd,hh,mm,ss,dw..]
	 */
	private static int getDayDateTime(
			BluetoothGattCharacteristic characteristic, int[] date, int offset) {

		int _offset = getDateTime(characteristic, date, offset);
		date[6] = characteristic.getIntValue(
				BluetoothGattCharacteristic.FORMAT_UINT8, _offset);
		_offset += UINT8_SIZE;

		return _offset;
	}

	/**
	 * 
	 * 
	 * 
	 * @param characteristic
	 * @param date
	 *            a minimum of int[8]
	 * @param offset
	 * @return [yy,mm,dd,hh,mm,ss,dw,s/256..]
	 */
	private static int getExactTime256(
			BluetoothGattCharacteristic characteristic, int[] date, int offset) {
		int _offset = getDayDateTime(characteristic, date, offset);
		date[7] = characteristic.getIntValue(
				BluetoothGattCharacteristic.FORMAT_UINT8, _offset);
		_offset += UINT8_SIZE;

		return _offset;
	}

	/**
	 * get a hex String from the array of bytes argument
	 * 
	 * @param bytes
	 * @return
	 */
	private static String getHex(BluetoothGattCharacteristic characteristic,
			int length, int offset, int[] nextOffset) {
		StringBuilder result = new StringBuilder();
		int b;
		for (int i = 0; i < length; i++) {
			b = characteristic.getIntValue(
					BluetoothGattCharacteristic.FORMAT_UINT8, offset);
			offset += UINT8_SIZE;
			if (b < 0xf) {
				result.append("0");
			}
			result.append(Integer.toHexString(b));
		}
		nextOffset[0] = offset;
		return result.toString();
	}

	/**
	 * mostly used for UINT24 and SINT24 that are not implemented in
	 * BluetoothGattCharacteristic
	 * 
	 * accepted format are FORMAT_UINT8 FORMAT_UINT16 FORMAT_UINT24
	 * FORMAT_UINT32
	 * 
	 * FORMAT_SINT8 FORMAT_SINT16 FORMAT_SINT24 FORMAT_SINT32
	 * 
	 * 
	 * 
	 * @param characteristic
	 * @param format
	 * @param offset
	 * @param nextOffset
	 *            a int[1] array. puts the new offset in the at nextOffset[0]
	 * @return
	 * @throws IllegalArgumentException
	 *             if formats are not in the range
	 */
	public static int getINT(BluetoothGattCharacteristic characteristic,
			int format, int offset, int[] nextOffset)
			throws IllegalArgumentException {
		int result = 0;
		int numberOfOctets = 0;
		boolean signed = false;
		switch (format) {
		case FORMAT_SINT8:
			signed = true;
		case FORMAT_UINT8:
			numberOfOctets = 1;
			break;
		case FORMAT_SINT16:
			signed = true;
		case FORMAT_UINT16:
			numberOfOctets = 2;
			break;
		case FORMAT_SINT24:
			signed = true;
		case FORMAT_UINT24:
			numberOfOctets = 3;
			break;
		case FORMAT_SINT32:
			signed = true;
		case FORMAT_UINT32:
			numberOfOctets = 4;
			break;
		default:
			throw new IllegalArgumentException("format " + format
					+ " is not included");
		}

		int bits = 0;
		for (int i = 0; i < numberOfOctets; i++) {
			bits = characteristic.getIntValue(
					BluetoothGattCharacteristic.FORMAT_UINT8, offset++);
			// if negative
			if (i == 0 && ((bits & 0x08) == 0x08) && signed) {
				// we put all bits to 1
				result = -1;
			}
			result = result << 8;

			result |= bits;
			offset += UINT8_SIZE;
		}

		nextOffset[0] = offset;
		return result;
	}

	/**
	 * get a long from 40,48, and 64 bits signed or not accepted formats :
	 * 
	 * FORMAT_SINT40 FORMAT_UINT40 FORMAT_SINT48 FORMAT_UINT48 FORMAT_SINT64
	 * FORMAT_UINT64
	 * 
	 * @param characteristic
	 * @param format
	 * @param offset
	 * @param nextOffset
	 * @return
	 * @throws IllegalArgumentException
	 */
	public static long getLONG(BluetoothGattCharacteristic characteristic,
			int format, int offset, int[] nextOffset)
			throws IllegalArgumentException {
		long result = 0;
		boolean signed = false;
		int numberOfOctets = 0;

		switch (format) {
		case FORMAT_SINT40:
			signed = true;
		case FORMAT_UINT40:
			numberOfOctets = 5;
			break;
		case FORMAT_SINT48:
			signed = true;
		case FORMAT_UINT48:
			numberOfOctets = 6;
			break;
		case FORMAT_SINT64:
			signed = true;
		case FORMAT_UINT64:
			numberOfOctets = 8;
			break;

		default:
			throw new IllegalArgumentException("format " + format
					+ " is not included");
		}

		int bits = 0;
		for (int i = 0; i < numberOfOctets; i++) {
			bits = characteristic.getIntValue(
					BluetoothGattCharacteristic.FORMAT_UINT8, offset++);
			// if negative : signed and the most significant bit is 1 of first
			// byte
			if (i == 0 && ((bits & 0x08) == 0x08) && signed) {
				// we put all bits to 1
				result = -1;
			}
			result = result << 8;

			result |= bits;
			offset += UINT8_SIZE;
		}

		nextOffset[0] = offset;
		return result;
	}

	/**
	 * reads 2 nibbles composing one Octet
	 * 
	 * @param characteristic
	 * @param offset
	 * @param nextOffset
	 * @return an int[2] with int[0] least significat bits and int[1] most
	 *         significant bits
	 */
	public static int[] getNibblePair(
			BluetoothGattCharacteristic characteristic, int offset,
			int[] nextOffset) {
		int[] result = new int[2];
		int value = characteristic.getIntValue(
				BluetoothGattCharacteristic.FORMAT_UINT8, offset);
		offset += UINT8_SIZE;
		result[0] = value & 0x03;
		result[1] = (value & 0x0c) >> 2;

		nextOffset[0] = offset;
		return result;
	}

	/**
	 * @param characteristic
	 * @param format
	 * @param offset
	 * @param nextOffset
	 * @return
	 * @throws IllegalArgumentException
	 */
	public static float getFloat(BluetoothGattCharacteristic characteristic,
			int format, int offset, int[] nextOffset)
			throws IllegalArgumentException {

		int intBits = 0;
		int numberOfOctets = 0;
		int bits = 0;
		int exponentAndSign = 0;
		float result = 0.0F;

		switch (format) {
		case FORMAT_FLOAT:
			numberOfOctets = 4;
			break;
		case FORMAT_SFLOAT:
			numberOfOctets = 2;
			break;
		default:
			throw new IllegalArgumentException("Format : " + format
					+ " is not appropriate");
		}

		for (int i = 0; i < numberOfOctets; i++) {
			bits = characteristic.getIntValue(
					BluetoothGattCharacteristic.FORMAT_UINT8, offset++);
			offset += UINT8_SIZE;
			// if negative : signed and the most significant bit is 1 of first
			// byte
			if (i == 0) {
				// we put all bits to 1
				exponentAndSign = bits << (3 * 8);
			} else {
				intBits = intBits << 8;
				intBits |= bits;
			}
		}

		intBits |= exponentAndSign;
		result = Float.intBitsToFloat(intBits);

		nextOffset[0] = offset;
		return result;
	}

	/**
	 * return a double
	 * 
	 * @param characteristic
	 * @param format
	 *            only accepted format : FORMAT_FLOAT64
	 * @param offset
	 * @param nextOffset
	 * @return
	 * @throws IllegalArgumentException
	 *             if format != FORMAT_FLOAT64
	 */
	public static double getDouble(BluetoothGattCharacteristic characteristic,
			int format, int offset, int[] nextOffset)
			throws IllegalArgumentException {
		double result = 0.0;
		if (format != FORMAT_FLOAT64) {
			throw new IllegalArgumentException("Format : " + format
					+ " is not appropriate");
		}
		long longBits = 0;
		long exponentAndSign = 0;
		int numberOfOctets = 8;
		long bits = 0;
		for (int i = 0; i < numberOfOctets; i++) {
			bits = characteristic.getIntValue(
					BluetoothGattCharacteristic.FORMAT_UINT8, offset++);
			offset += UINT8_SIZE;
			longBits = longBits << 8;
			longBits |= bits;
		}
		longBits |= exponentAndSign;
		result = Double.longBitsToDouble(longBits);

		nextOffset[0] = offset;
		return result;
	}

	/**
	 * non operational
	 * 
	 * @param characteristic
	 * @param format
	 * @param offset
	 * @param nextOffset
	 * @return
	 * @throws IllegalArgumentException
	 */
	public static BigInteger getDoubleLONG(
			BluetoothGattCharacteristic characteristic, int format, int offset,
			int[] nextOffset) throws IllegalArgumentException {
		boolean signed = false;
		byte[] bytes = new byte[16];
		BigInteger result = new BigInteger(bytes);
		if (format != FORMAT_SINT128 || format != FORMAT_UINT128) {
			throw new IllegalArgumentException("Format : " + format
					+ " is not appropriate");
		}

		switch (format) {
		case FORMAT_SINT128:
			bytes = new byte[16];
			result = new BigInteger(-1, bytes);
		case FORMAT_UINT128:
			bytes = new byte[16];
			result = new BigInteger(1, bytes);
			break;
		}

		// TODO

		return result;
	}
	
	/**
	 * this corrects the big endian bug of Asica
	 * 
	 * @param value
	 * @param format
	 * @return
	 */
	public static void correctAsicaYearBigEndianness(int[] date, int format, boolean activate){
		if(activate){
			int year = date[0];
			// corrects Big endians on year
			try {
				date[0] = swapEndianness(year, BluetoothGattCharacteristic.FORMAT_UINT16);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * BLE uses little endianness
	 * 
	 * used when a value is inverted
	 * 
	 * @param value
	 * @throws Exception 
	 */
	private static int swapEndianness(int value,int format ) throws Exception{
		int result = 0;
		int size = 0;
		switch(format){
		case FORMAT_SINT8:
		case FORMAT_UINT8:
			size = UINT8_SIZE;
			break;
		case FORMAT_SINT16:
		case FORMAT_UINT16:
			size = UINT16_SIZE;
			break;
		case FORMAT_SINT24:
		case FORMAT_UINT24:
			size = UINT24_SIZE;
			break;
		case FORMAT_SINT32:
		case FORMAT_UINT32:
			size = UINT32_SIZE;
			break;
		default :
			throw new Exception();
		}
		
		
		int i = size;
		while(i-->0) {
			result += (value>>(i*8) & 0xFF)<<((size-1 - i)*8);
		}
		return result;
	}

}
