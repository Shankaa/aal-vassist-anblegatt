package org.aal.vassist.bluetooth.le.gatt;

import java.util.Calendar;

import org.aal.vassist.at.AAL_vAssist_Asica_AT_AccessService;

import android.bluetooth.BluetoothDevice;
import android.content.Context;
import android.os.Bundle;

/**
 * @author Shankaa, Hugues Sansen for AAL vAssist project
 * 
 * 		Licence : European Union Public License (EUPL)
 * 
 * objects of this class receive the data sent to the handler
 * 
 * you can always retrieve :
 * 		the characteristic uuid with 
 * 			String uuid = bundle.getString(BluetoothDevice.EXTRA_UUID);
 * 		the service of the characteristic by bundle.getString(BluetoothGattSpecification_Characteristics.EXTRA_SERVICE_UUID) where EXTRA_SERVICE_UUID = "org.aal.vassist.at.SERVICE.EXTRA_UUID");
 * 		the characteristic value with
 * 			byte[] characteristicValue = bundle.getByteArray(BluetoothGattSpecification_Characteristics.EXTRA_VALUE);
 * 
 * note that all keys to bundle extras have the format : 
 * 			"org.aal.vassist.at.VALUEx"; were x goes from "" to 8
 *  access to uuid as String is done with bundle.getString(BluetoothDevice.EXTRA_UUID);
 * in order to avoid any interference with your own extras
 * 
 * Since it is recommended that the handler be static
 * your IBluetoothGattCharacteristicHandler object may have to be accessed in a static way also.
 * This complexifies the communication with your context.
 * This is why we have added the setContext(Context context) method in order to access your context
 * 
 * if you need methods specific to your own context you must cast the local context variable
 * 
 * ((MyProprietaryContext) context).doSomething();
 * 
 * e.g. :
 * 
 * public class BluetoothGattCharacteristicHandler implements IBluetoothGattCharacteristicHandler{
 * 		private AAL_vAssist_Asica_AT_AccessService context;
 *		
 *		@Override
 *		public void setContext(Context context) {
 *			this.context = (AAL_vAssist_Asica_AT_AccessService)context;
 *			
 *		}
 * 		
 * 
 * 		.......
 * }
 * 
 * However you must be aware that is you have different instances of the same context you will end up
 * with only one context.
 * This is usually avoided by the fact that Bluetooth access will usually run in a unique Service
 * 
 * 
 */
public interface IBluetoothGattCharacteristicHandler {
	
	/**
	 * set your context here to access to it later
	 * Your must add a variable that you will use in your code
	 * 
	 * @param context
	 */
	public void setContext(Context context);
	
	
	/**
	 * the default callback if the characteristic uuid was not found by BluetoothGattSpecification_Characteristics
	 * 
	 * you can use this method to write your proprietary code
	 * access the characteristic uuid with 
	 * 			String uuid = bundle.getString(BluetoothGattSpecification_Characteristics.EXTRA_UUID);
	 * 		and the characteristic value with
	 * 			byte[] characteristicValue = bundle.getByteArray(BluetoothGattSpecification_Characteristics.EXTRA_VALUE);
	 * 
	 * @param bundle
	 */
	public void on_default(Bundle bundle,String uuid);

	/**
	 * refers to name="Aggregate Input" approved="NO" last-modified="2012-03-13"
	 * type="org.bluetooth.characteristic.aggregate_input" uuid="2A5A"
	 * 
	 * The Aggregate Input is an aggregate of the Digital Input Characteristic
	 * value (if available) and ALL Analog Inputs available.
	 * 
	 * @param bundle
	 *            can be used if additional extra_values have been included by
	 *            user
	 * @param inputBits
	 * @param analogInput
	 */
	public void on_aggregate_input(Bundle bundle, int inputBits, int analogInput);

	/**
	 * refers to name="Alert Category ID"
	 * type="org.bluetooth.characteristic.alert_category_id" uuid="2A43"
	 * 
	 * Categories of alerts/messages. The value of the characteristic is an
	 * unsigned 8 bit integer that has a fixed point exponent of 0. The Alert
	 * Category ID characteristic defines the predefined categories of messages
	 * as an enumeration.
	 * 
	 * 
	 * @param bundle
	 *            can be used if additional extra_values have been included by
	 *            user
	 * @param categoryID
	 * @param comment
	 *            category comments as provided by the specification
	 */
	public void on_alert_category_id(Bundle bundle, int categoryID,
			String comment);

	/**
	 * refers to name="Alert Category ID Bit Mask"
	 * type="org.bluetooth.characteristic.alert_category_id_bit_mask"
	 * uuid="2A42"
	 * 
	 * Categories of alerts/messages. The value of the characteristic is a bit
	 * mask implemented as an array of unsigned 8 bit integers. The Alert
	 * Category ID Bit Mask characteristic defines one bit for each predefined
	 * category ID.
	 * 
	 * @param bundle
	 *            can be used if additional extra_values have been included by
	 *            user
	 * @param categoryIDBitMask0
	 * @param categoryIDBitMask1
	 */
	public void on_alert_category_id_bit_mask(Bundle bundle,
			int categoryIDBitMask0, int categoryIDBitMask1);

	/**
	 * refers to name="Alert Level"
	 * type="org.bluetooth.characteristic.alert_level"
	 * uuid="2A06"
	 * 
	 * The level of an alert a device is to sound.
	 * If this level is changed while the alert is being sounded, the new level should take effect.
	 * 
	 * The value of the characteristic shall be an unsigned 8 bit integer that
	 * has a fixed point exponent of 0. The Alert Level characteristic defines
	 * the level of alert, and is one of the following three values: 
	 * Value 0, meaning “No Alert”
	 * Value 1, meaning “Mild Alert” 
	 * Value 2, meaning “High Alert”
	 * 3 - 255	 Reserved
	 * 
	 * @param bundle
	 *            can be used if additional extra_values have been included by
	 *            user
	 * @param alertLevel
	 */
	public void on_alert_level(Bundle bundle, int alertLevel);

	/**
	 * refers to name="Alert Notification Control Point"
	 * type="org.bluetooth.characteristic.alert_notification_control_point"
	 * uuid="2A44"
	 * 
	 * Control point of the Alert Notification server. Client can write the
	 * command here to request the several functions toward the server.
	 * 
	 * 
	 * @param bundle
	 *            can be used if additional extra_values have been included by
	 *            user
	 * @param commandID
	 * @param commandIDComment
	 *            as provided by the specification
	 * @param categoryID
	 *            Target category that the command applies to
	 * @param categoryIDComment
	 *            as provided by the specification
	 */
	public void on_alert_notification_control_point(Bundle bundle,
			int commandID, String commandIDComment, int categoryID,
			String categoryIDComment);

	/**
	 * refers to name="Alert Status" approved="Yes" last-modified="2011-08-30"
	 * type="org.bluetooth.characteristic.alert_status" uuid="2A3F"
	 * 
	 * The Alert Status characteristic defines the Status of alert.
	 * 
	 * @param bundle
	 *            can be used if additional extra_values have been included by
	 *            user
	 * @param alertStatus
	 *            raw result that contains the 3 following values. can be used
	 *            for additionnal proprietary values
	 * @param ringerState
	 * @param vibratorState
	 * @param displayAlertStatus
	 */
	public void on_alert_status(Bundle bundle, int alertStatus,
			int ringerState, int vibratorState, int displayAlertStatus);

	/**
	 * mlns:xsi="http://www.w3.org/2001/XMLSchema-instance" name="Analog Input"
	 * approved="NO" last-modified="2012-03-13"
	 * type="org.bluetooth.characteristic.analog_input" uuid="2A58"
	 * 
	 * The Analog Input characteristic represents the value of an analog input
	 * as a 16-bit integer (uint16). The format of the analog value depends on
	 * the implementation.
	 * 
	 * @param bundle
	 *            can be used if additional extra_values have been included by
	 *            user
	 * @param analogValue
	 */
	public void on_analog_input(Bundle bundle, int analogValue);

	/**
	 * refers to name="Analog Output" approved="NO" last-modified="2012-03-13"
	 * type="org.bluetooth.characteristic.analog_output" uuid="2A59"
	 * 
	 * The Analog Output characteristic represents the value of an analog output
	 * as a 16-bit integer (uint16). The format of the analog value depends on
	 * the implementation.
	 * 
	 * @param bundle
	 *            can be used if additional extra_values have been included by
	 *            user
	 * @param analogValue
	 */
	public void on_analog_output(Bundle bundle, int analogValue);

	/**
	 * name="Battery Level" approved="Yes" last-modified="2011-12-05"
	 * type="org.bluetooth.characteristic.battery_level" uuid="2A19"
	 * 
	 * The current charge level of a battery. 100% represents fully charged
	 * while 0% represents fully discharged.
	 * 
	 * @param bundle
	 *            can be used if additional extra_values have been included by
	 *            user
	 * @param level
	 *            The current charge level of a battery
	 */
	public void on_battery_level(Bundle bundle, int level);

	/**
	 * Caution version 0.5
	 * 
	 * name="Battery Level State"
	 * type="org.bluetooth.characteristic.battery_level_state"
	 * uuid="2A1B"
	 * 
	 * 
	 * 
	 * @param bundle
	 *            can be used if additional extra_values have been included by
	 *            user
	 * @param rawState
	 *            state raw values
	 * @param stateBits
	 *            an array of 4 int corresponding to 4 categories of states
	 * @param stateComments
	 *            an array of comments corresponding to each of 4 stateBits
	 */
	public void on_battery_level_state(Bundle bundle, int level, int rawState,
			int[] stateBits, String[] stateComments);

	/**
	 * refers to name="Battery Power State"
	 * type="org.bluetooth.characteristic.battery_power_state" uuid="2A1A"
	 * 
	 * 
	 * 
	 * @param bundle
	 * @param rawState
	 *            state raw values
	 * @param stateBits
	 *            an array of 4 int corresponding to 4 categories of states
	 * @param stateComments
	 *            an array of comments corresponding to each of 4 stateBits
	 */
	public void on_battery_power_state(Bundle bundle, int rawState,
			int[] stateBits, String[] stateComments);

	/**
	 * refers to name="Blood Pressure Feature"
	 * type="org.bluetooth.characteristic.blood_pressure_feature" uuid="2A49"
	 * 
	 * 
	 * The Blood Pressure Feature characteristic is used to describe the
	 * supported features of the Blood Pressure Sensor.
	 * 
	 * features[0] Body Movement Detection Support bit features[1] Cuff Fit
	 * Detection Support bit features[2] Irregular Pulse Detection Support bit
	 * features[3] Pulse Rate Range Detection Support bit features[4]
	 * Measurement Position Detection Support bit features[5] Multiple Bond
	 * Support bit features[6] ReservedForFutureUse...
	 * 
	 * 
	 * @param bundle
	 * @param bloodPressureFeature
	 *            raw
	 * @param features
	 *            a int[16] array : an expression of bloodPressureFeature
	 */
	public void on_blood_pressure_feature(Bundle bundle,
			int bloodPressureFeature, int[] features);

	/**
	 * refers to name="Blood Pressure Measurement"
	 * type="org.bluetooth.characteristic.blood_pressure_measurement"
	 * uuid="2A35"
	 * 
	 * The Blood Pressure Measurement characteristic is a variable length
	 * structure containing a Flags field, a Blood Pressure Measurement Compound
	 * Value field, and contains additional fields such as Time Stamp, Pulse
	 * Rate and User ID as determined by the contents of the Flags field.
	 * 
	 * @param bundle
	 * @param flags
	 * @param units
	 *            pressure units for systolic, diastolic, meanArterialPressure
	 *            if 0 mm of Hg if 1 kPa
	 * @param systolic
	 * @param diastolic
	 * @param meanArterialPressure
	 * @param date
	 *            [yy,mm,dd,hh,ss] partially or totally zeroed if not present
	 * @param calendar
	 * @param pulseRate
	 * @param userID
	 *            0 if not present
	 * @param measurementStatusBits
	 *            measurementStatusBits[0] body MovementDetection Flag
	 *            measurementStatusBits[1] cuffFit Detection Flag
	 *            measurementStatusBits[2] irregular Pulse Detection Flag
	 *            measurementStatusBits[3] pulse Rate Range Detection Flags
	 *            measurementStatusBits[4] measurement Position Detection Flag
	 *            measurementStatusBits[5] reserved For Future Use ...
	 * @param measurementStatusBitsComments
	 *            comments corresponding to measurementStatusBits values
	 */
	public void on_blood_pressure_measurement(Bundle bundle, int[] flags,
			int units, float systolic, float diastolic,
			float meanArterialPressure, int[] date,Calendar calendar, float pulseRate,
			int userID, int[] measurementStatusBits,
			String[] measurementStatusBitsComments);
	
	
	
	/**
	 * name="Body Sensor Location"
     *  type="org.bluetooth.characteristic.body_sensor_location"
     *  uuid="2A38"
	 * 
	 * @param bundle
	 * @param bodySensorLocation 
	 * @param value the corresponding text as defined by the specification
	 */
	public void on_body_sensor_location(Bundle bundle,int bodySensorLocation,String value);
	

	/**
	 * name="Boot Keyboard Input Report" approved="Yes"
	 * last-modified="2011-11-14"
	 * type="org.bluetooth.characteristic.boot_keyboard_input_report"
	 * uuid="2A22"
	 * 
	 * The Boot Keyboard Input Report characteristic is used to transfer fixed
	 * format and length Input Report data between a HID Host operating in Boot
	 * Protocol Mode and a HID Service corresponding to a boot keyboard.
	 * 
	 * @param bundle
	 * @param bootKeyboardInputReportValue
	 */
	public void on_handle_boot_keyboard_input_report(Bundle bundle,
			int bootKeyboardInputReportValue);

	/**
	 * name="Boot Keyboard Output Report" approved="Yes"
	 * last-modified="2011-11-14"
	 * type="org.bluetooth.characteristic.boot_keyboard_output_report"
	 * uuid="2A32"
	 * 
	 * The Boot Keyboard Output Report characteristic is used to transfer fixed
	 * format and length Output Report data between a HID Host operating in Boot
	 * Protocol Mode and a HID Service corresponding to a boot keyboard.
	 * 
	 * @param bundle
	 * @param bootKeyboardInputReportValue
	 */
	public void on_handle_boot_keyboard_output_report(Bundle bundle,
			int bootKeyboardInputReportValue);

	/**
	 * name="Boot Mouse Input Report" approved="Yes" last-modified="2011-11-14"
	 * type="org.bluetooth.characteristic.boot_mouse_input_report" uuid="2A33"
	 * 
	 * The Boot Mouse Input Report characteristic is used to transfer fixed
	 * format and length Input Report data between a HID Host operating in Boot
	 * Protocol Mode and a HID Service corresponding to a boot mouse.
	 * 
	 * 
	 * @param bundle
	 * @param bootMouseInputReportValue
	 */
	public void on_boot_mouse_input_report(Bundle bundle,
			int bootMouseInputReportValue);

	/**
	 * name="CSC Feature" approved="No" last-modified="2012-04-05"
	 * type="org.bluetooth.characteristic.csc_feature" uuid="2A5C"
	 * 
	 * The CSC Measurement characteristic (CSC refers to Cycling Speed and
	 * Cadence) is a variable length structure containing a Flags field and,
	 * based on the contents of the Flags field, may contain one or more
	 * additional fields as shown in the tables below.
	 * 
	 * 
	 * @param bundle
	 * @param cSCFeatureValue
	 * @param cSCFeatureBits
	 * @param cSCFeatureComments
	 */
	public void on_csc_feature(Bundle bundle, int cSCFeatureValue,
			int[] cSCFeatureBits, String[] cSCFeatureComments);

	/**
	 * name="CSC Measurement" approved="Yes" last-modified="2012-04-12"
	 * type="org.bluetooth.characteristic.csc_measurement" uuid="2A5B"
	 * 
	 * @param bundle
	 * @param flags
	 *            These flags define which data fields are present in the
	 *            Characteristic value
	 * @param _flags
	 *            the flags arranged in an array
	 * @param flagsComments
	 *            the falgs comments as provided by the specification
	 * @param cumulativeWheelRevolutions
	 *            org.bluetooth.unit.unitless
	 * @param lastWheelEventTime
	 *            Unit has a resolution of 1/1024s.
	 * @param cumulativeCrankRevolutions
	 *            unitless
	 * @param lastCrankEventTime
	 *            Unit has a resolution of 1/1024s
	 */
	public void on_csc_measurement(Bundle bundle, int flags, int[] _flags,
			String[] flagsComments, int cumulativeWheelRevolutions,
			int lastWheelEventTime, int cumulativeCrankRevolutions,
			int lastCrankEventTime);

	/**
	 * name="Current Time" type="org.bluetooth.characteristic.current_time"
	 * uuid="2A2B"
	 * 
	 * 
	 * @param bundle
	 * @param yy
	 * @param mm
	 * @param dd
	 * @param hh
	 * @param mn
	 * @param ss
	 * @param dw
	 * @param s_256
	 * @param adjustReason
	 */
	public void on_current_time(Bundle bundle, int yy, int mm, int dd, int hh,
			int mn, int ss, int dw, int s_256, int adjustReason);

	/**
	 * name="Cycling Power Control Point" approved="Yes"
	 * last-modified="2013-05-13"
	 * type="org.bluetooth.characteristic.cycling_power_control_point"
	 * uuid="2A66"
	 * 
	 * 
	 * The Cycling Power Control Point characteristic is used to request a
	 * specific function to be executed on the receiving device.
	 * 
	 * not fully implemented : Parameter Value because optional and variable
	 * Request Op Code Response Value Response Parameter
	 * 
	 * use bundle.getByteArray(BluetoothGattSpecification_Characteristics.
	 * EXTRA_VALUE); to get the received byte array
	 * 
	 * @param bundle
	 */
	public void on_cycling_power_control_point(Bundle bundle, int opCodes,
			String opCodesValue, String opCodeDescription);

	/**
	 * name="Cycling Power Feature" approved="Yes" last-modified="2013-05-13"
	 * type="org.bluetooth.characteristic.cycling_power_feature" uuid="2A65"
	 * 
	 * The CP Feature characteristic is used to report a list of features
	 * supported by the device.
	 * 
	 * @param bundle
	 * @param cyclingPowerFeature
	 */
	public void on_cycling_power_feature(Bundle bundle, int cyclingPowerFeature);

	/**
	 * name="Cycling Power Vector" approved="Yes" last-modified="2013-05-13"
	 * type="org.bluetooth.characteristic.cycling_power_vector" uuid="2A64"
	 * 
	 * The Cycling Power Vector characteristic is a variable length structure
	 * containing a Flags fieldand based on the contents of the Flags field, may
	 * contain one or more additional fields as shown in the table below.
	 * 
	 * @param bundle
	 * @param flags
	 * @param crankRevolutionData_CumulativeCrankRevolutions
	 * @param crankRevolutionData_LastCrankEventTime
	 * @param firstCrankMeasurementAngle
	 * @param instantaneousForceMagnitudeArray
	 *            may be null
	 * @param instantaneousTorqueMagnitudeArray
	 *            may be null
	 * 
	 */
	public void on_cycling_power_vector(Bundle bundle, int flags,
			int crankRevolutionData_CumulativeCrankRevolutions,
			int crankRevolutionData_LastCrankEventTime,
			int firstCrankMeasurementAngle,
			int[] instantaneousForceMagnitudeArray,
			int[] instantaneousTorqueMagnitudeArray);

	/**
	 * @param bundle
	 * @param dateTimeArray
	 *            [yy,mm,dd,hh,mm,ss]
	 * @param date same value in Calendar format
	 */
	public void on_date_time(Bundle bundle, int[] dateTimeArray,Calendar date);

	/**
	 * @param bundle
	 * @param dateTimeArray
	 *            [yy,mm,dd,hh,mm,ss,dw]
	 * @param date same value in Calendar format
	 */
	public void on_day_date_time(Bundle bundle, int[] dayDateTimeArray,Calendar date);

	/**
	 * 
	 * @param bundle
	 * @param dayOfWeek
	 *            0-7
	 */
	public void on_day_of_week(Bundle bundle, int dayOfWeek);

	/**
	 * name="Digital Input" approved="NO" last-modified="2012-03-14"
	 * type="org.bluetooth.characteristic.digital_input" uuid="2A56"
	 * 
	 * 
	 * The Digital Input characteristic is a 1-bit array where each bit
	 * represents the state of one binary digital IO.
	 * 
	 * @param bundle
	 * @param bitArray
	 */
	public void on_digital_input(Bundle bundle, int[] bitArray);

	/**
	 * name="Digital Output" approved="NO" last-modified="2012-03-14"
	 * type="org.bluetooth.characteristic.digital_output" uuid="2A57"
	 * 
	 * The Digital Output characteristic is an array of n 2-bit values in a bit
	 * field.
	 * 
	 * @param bundle
	 * @param bitArray
	 */
	public void on_digital_output(Bundle bundle, int[] bitArray);

	/**
	 * name="DST Offset" type="org.bluetooth.characteristic.dst_offset"
	 * uuid="2A0D"
	 * 
	 * 
	 * 0 value="Standard Time" 2 value="Half An Hour Daylight Time (+0.5h)" 4
	 * value="Daylight Time (+1h)" 8 value="Double Daylight Time (+2h)" 255
	 * value="DST is not known" other value="Reserved"
	 * 
	 * 
	 * @param bundle
	 * @param dSTOffset
	 * @param value
	 */
	public void on_dst_offset(Bundle bundle, int dSTOffset, String value);

	/**
	 * name="Exact Time 100" type="org.bluetooth.characteristic.exact_time_100"
	 * uuid="2A0B"
	 * 
	 * 
	 * @param bundle
	 * @param exacTime100
	 *            [yy,mm,dd,hh,mm,ss,dw, s_100]
	 * 
	 *            s_100 1/100th of a second
	 */
	public void on_exact_time_100(Bundle bundle, int[] exacTime100);

	/**
	 * name="Exact Time 256" type="org.bluetooth.characteristic.exact_time_256"
	 * uuid="2A0C"
	 * 
	 * 
	 * @param bundle
	 * @param exacTime256
	 *            [yy,mm,dd,hh,mm,ss,dw, s_256]
	 * 
	 *            s_256 1/256th of a second
	 */
	public void on_exact_time_256(Bundle bundle, int[] exacTime256);

	/**
	 * name="Firmware Revision String" approved="Yes" last-modified="2011-05-24"
	 * type="org.bluetooth.characteristic.firmware_revision_string" uuid="2A26"
	 * 
	 * The value of this characteristic is a UTF-8 string representing the
	 * firmware revision for the firmware within the device.
	 * 
	 * @param bundle
	 * @param firmwareRevision
	 */
	public void on_firmware_revision_string(Bundle bundle,
			String firmwareRevision);

	/**
	 * name="Appearance" approved="Yes" last-modified="2012-06-29"
	 * type="org.bluetooth.characteristic.gap.appearance" uuid="2A01"
	 * 
	 * The external appearance of this device. The values are composed of a
	 * category (10-bits) and sub-categories (6-bits).
	 * 
	 * @param bundle
	 * @param category
	 * @param subCategory
	 */
	public void on_gap_appearance(Bundle bundle, int category, int subCategory);

	/**
	 * name="Device Name" type="org.bluetooth.characteristic.gap.device_name"
	 * uuid="2A00"
	 * 
	 * The Information included in this page is informative. The normative
	 * descriptions are contained in the applicable specification.
	 * 
	 * 
	 * @param bundle
	 * @param deviceName
	 */
	public void on_gap_device_name(Bundle bundle, String deviceName);

	/**
	 *  name="Peripheral Preferred Connection Parameters"
     *  type="org.bluetooth.characteristic.gap.peripheral_preferred_connection_parameters"
     *  uuid="2A04"
	 * 
	 * 
	 * 
	 * 
	 * @param bundle
	 * @param minimumConnectionInterval connInterval_min = Minimum Connection Interval * 1.25 ms
	 * @param maximumConnectionInterval connInterval_max = Maximum Connection Interval * 1.25 ms. and is equal or greater than the Minimum Connection Interval
	 * @param slaveLatency
	 * @param connectionSupervisionTimeoutMultiplier
	 */
	public void on_gap_peripheral_preferred_connection_parameters(
			Bundle bundle, int minimumConnectionInterval,
			int maximumConnectionInterval, int slaveLatency,
			int connectionSupervisionTimeoutMultiplier);
	
	
	/**
	 * name="Peripheral Privacy Flag"
     *  type="org.bluetooth.characteristic.gap.peripheral_privacy_flag"
     *  uuid="2A02"
	 * 
	 * 
	 * @param bundle
	 * @param flag
	 * @param value 
	 * 		flag == false 	value="privacy is disabled in this device"
	 * 		flag == true	value="privacy is enabled in this device"
	 */
	public void on_gap_peripheral_privacy_flag(
			Bundle bundle, boolean flag, String value);
	
	/**
	 * name="Reconnection Address"
     *  type="org.bluetooth.characteristic.gap.reconnection_address"
     *  uuid="2A03"
	 * 
	 * 
	 * @param bundle
	 * @param address This is a non-resolvable private address
	 */
	public void on_gap_reconnection_address(Bundle bundle,int address);
	
	
	/**
	 * name="Service Changed"
     *  type="org.bluetooth.characteristic.gatt.service_changed"
     *  uuid="2A05"
	 * 
	 * 
	 * @param bundle
	 * @param startOfAffectedAttributeHandleRange
	 * @param endOfAffectedAttributeHandleRange
	 */
	public void on_gatt_service_changed(Bundle bundle,
			int startOfAffectedAttributeHandleRange,
			int endOfAffectedAttributeHandleRange);
	
	/**
	 * name="Glucose Feature"
     *  approved="Yes"
     *  last-modified="2011-11-25"
     *  type="org.bluetooth.characteristic.glucose_feature"
     *  uuid="2A51"
	 * 
	 * The Glucose Feature characteristic is used to describe the supported features of the Server. When read, the Glucose Feature characteristic returns a value that is used by a Client to determine the supported features of the Server.
	 * 
	 * @param bundle
	 * @param glucoseFeature
	 * @param glucoseFeatures  glucoseFeature as a booleab array
	 * @param glucoseFeatureValues corresponding text for glucoseFeatures 
	 */
	public void on_glucose_feature(Bundle bundle,int glucoseFeature, boolean[] glucoseFeatures, String[] glucoseFeatureValues);
	
	
	
	/**
	 * 
	 * 
	 * @param bundle
	 * @param flags
	 * @param sequenceNumber
	 * @param date
	 * @param timeOffset  return 0 if absent
	 * @param glucoseConcentration_units_of_kg_per_L return 0 if absent
	 * @param glucoseConcentration_units_of_mol_per_L return 0 if absent
	 * @param type
	 * @param sampleLocation
	 * @param sensorStatusAnnunciation
	 */
	public void on_glucose_measurement(Bundle bundle,
			int flags,
			int sequenceNumber,
			Calendar date,
			int timeOffset,
			float glucoseConcentration_units_of_kg_per_L,
			float glucoseConcentration_units_of_mol_per_L,
			int type,
			int sampleLocation,
			int sensorStatusAnnunciation);
	
	public void on_glucose_measurement_context(Bundle bundle,int flags,int sequenceNumber,int extendedFlags,
			int carbohydrateID,float carbohydrate_unitsofkilograms,
			int meal,int tester ,int health,
			int exerciseDuration,int exerciseIntensity,int medicationID,float medication_units, int MedicationValueUnits, float hbA1c);
	
	public void on_hardware_revision_string(Bundle bundle,String hardwareRevision);
	
	public void on_heart_rate_control_point(Bundle bundle,int heartRateControlPoint);
	
	public void on_heart_rate_measurement(Bundle bundle,int flags,int sensorContactStatusbits,String sensorContactStatus, int heartRateMeasurementValue,int energyExpended,int rr_Interval);
	
	public void on_hid_control_point(Bundle bundle, int hIDControlPointCommand);
	
	public void on_hid_information(Bundle bundle, int bcdHID ,int bCountryCode,int flags);
	
	public void on_handle_ieee_11073_20601_regulatory_certification_data_list(Bundle bundle,IEEE_11073_20601_REGULATORY_CERTIFICATION_DATA_LIST list);
	
	public void on_intermediate_cuff_pressure(Bundle bundle, int[] flags,
			int units, float systolic, float diastolic,
			float meanArterialPressure, int[] date,Calendar calendar, float pulseRate,
			int userID, int[] measurementStatusBits,
			String[] measurementStatusBitsComments);
	
	public void on_intermediate_temperature(Bundle bundle,
			int flags,
			float TemperatureMeasurementValue,
			int TemperatureUnitFlag,
			Calendar date,
			int temperatureType,
			String temperatureTypeString);
	
	public void on_ln_control_point(Bundle bundle,
			int OpCodes,
			String OpCodeString,
			String OpCodeComment,
			int ResponseValue,
			String ResponseValueString,
			String ResponseValueComment,
			int[] ResponseParameter);
	
	public void on_ln_feature(Bundle bundle,int LNFeature,String[] LNFeatureValues);
	
	public void on_local_time_information(Bundle bundle,int TimeZone,String TimeZoneString,int dSTOffset,String value);
	
	/**
	 * Name: Location and Speed Characteristic
	 * Type: org.bluetooth.characteristic.location_and_speed
	 * Assigned Number: 0x2A67
	 * 
	 * The Location and Speed characteristic is a variable length structure containing a Flags field and,
	 * based on the contents of the Flags field, may contain a combination of data fields listed below.
	 * Note that it is possible for this characteristic to exceed the default LE MTU size.
	 * 
	 * @param bundle
	 * @param flags
	 * @param flagValues array of Strings text corresponding to flags
	 * @param InstantaneousSpeed 	optional Integer.MIN_VALUE if absent
	 * @param TotalDistance			optional Integer.MIN_VALUE if absent
	 * @param LocationLatitude		optional Integer.MIN_VALUE if absent
	 * @param LocationLongitude		optional Integer.MIN_VALUE if absent
	 * @param Elevation				optional Integer.MIN_VALUE if absent
	 * @param Heading				optional Integer.MIN_VALUE if absent
	 * @param RollingTime			optional Integer.MIN_VALUE if absent
	 * @param UTCTime				optional, local device date of reception if absent
	 */
	public void on_location_and_speed(Bundle bundle,
			int flags,
			String[] flagValues,
			int InstantaneousSpeed, 
			int TotalDistance, 
			int LocationLatitude,
			int LocationLongitude,
			int Elevation,
			int Heading,
			int RollingTime,
			Calendar date);
	
	public void on_manufacturer_name_string(Bundle bundle, String manufacturer_name_string);
	
	public void on_measurement_interval(Bundle bundle,int MeasurementInterval);
	
	public void on_model_number_string(Bundle bundle,String model_number);
	
	/**
	 * Name: Navigation
	 * Type: org.bluetooth.characteristic.navigation
	 * Assigned Number: 0x2A68
	 * 
	 * The Navigation characteristic is a variable length structure containing a Flags field,
	 * a Bearing field, a Heading field and, based on the contents of the Flags field,
	 * may contain a combination of data fields listed below.
	 * 
	 * 
	 * @param bundle
	 * @param flags
	 * @param FlagsValues
	 * @param Bearing
	 * @param Heading
	 * @param RemainingDistance // optional  Integer.MIN_VALUE if absent
	 * @param RemainingVerticalDistance //optional Integer.MIN_VALUE if absent
	 * @param eta //optional the date of the reception by the local device if absent
	 */
	public void on_navigation(Bundle bundle,
			int flags,
			String[] FlagsValues,
			int Bearing,
			int Heading,
			int RemainingDistance,
			int RemainingVerticalDistance,
			Calendar eta);
	
	public void on_new_alert(Bundle bundle,int NumberofNewAlert,String TextStringInformation);
	
	public void on_pnp_id(Bundle bundle,int VendorIDSource,int VendorID,int ProductID,int ProductVersion);
	
	public void on_position_quality(Bundle bundle,int Flags,int NumberofBeaconsinSolution,int NumberofBeaconsinView,int TimetoFirstFix,int EHPE,int EVPE,int HDOP,int VDOP);
	
	public void on_protocol_mode(Bundle bundle,int ProtocolModeValue);
	
	
	/**
	 * CAUTION : version 0.5
	 * 
	 *  Name: Pulse Oximetry Continuous Measurement
	 *  Type: org.bluetooth.characteristic.pulse_oximetry_continuous_measurement
	 *  Assigned Number: 0x2A5F
	 *  
	 *  This characteristic is a variable length structure containing a Flags field,
	 *  a SpO2PR-Normal field, and based on the contents of the Flags field, may contain a SpO2PR-Fast field,
	 *  a SpO2PR-Slow field, a Measurement Status field, a Device and Sensor Status field,
	 *  a Sequence Number field, and/or a Threshold Status field.
	 *  
	 *  The maximum length of this structure is 20 octets, if all Flags are set.
	 *  
	 *  Author : According to the spec available we see only 6 octets
	 * 
	 * 
	 * @param bundle
	 * @param Flags
	 * @param MeasurementStatus
	 * @param DeviceandSensorStatus
	 * @param ThresholdStatus
	 */
	public void on_pulse_oximetry_continuous_measurement(Bundle bundle,int Flags,int MeasurementStatus,int DeviceandSensorStatus,int ThresholdStatus);
	
	/**
	 * CAUTION : version 0.5
	 * 
	 *  Name: Pulse Oximetry Continuous Measurement
	 *  Type: org.bluetooth.characteristic.pulse_oximetry_continuous_measurement
	 *  Assigned Number: 0x2A5F
	 *  
	 *  This characteristic is a variable length structure containing a Flags field, 
	 *  a SpO2PR-Normal field, and based on the contents of the Flags field, 
	 *  may contain a SpO2PR-Fast field, a SpO2PR-Slow field, a Measurement Status field, 
	 *  a Device and Sensor Status field, 
	 *  a Sequence Number field, and/or a Threshold Status field.
	 *  
	 *  The maximum length of this structure is 20 octets, if all Flags are set.
	 * 
	 *  Author : According to the spec available we see only 6 octets
	 * 
	 * @param bundle
	 * @param Flags
	 * @param MeasurementStatus
	 * @param DeviceandSensorStatus
	 * @param ThresholdStatus
	 */
	public void on_pulse_oximetry_control_point(Bundle bundle,int Flags,int MeasurementStatus,int DeviceandSensorStatus,int ThresholdStatus);
	
	/**
	 * Caution : version 0.5
	 * 
	 *  Name: Pulse Oximetry Pulsatile Event Characteristic
	 *  Type: org.bluetooth.characteristic.pulse_oximetry_pulsatile_event
	 *  Assigned Number: 0x2A60
	 * 
	 * 
	 * 
	 * @param bundle
	 * @param Flags
	 * @param PulseFlags
	 */
	public void on_pulse_oximetry_pulsatile_event(Bundle bundle,int Flags,int PulseFlags);
	
	/**
	 *  Name: Pulse Oximetry Features
	 *  Type: org.bluetooth.characteristic.pulse_oximetry_features
	 *  Assigned Number: 0x2A61
	 * 
	 * This characteristic is a variable length structure containing a Flags field,
	 * a Supported Configuration Features field, and based upon the contents of the Flags field,
	 * may also contain the following fields: 
	 * • Measurement Status Support 
	 * • Device and Sensor Status Support 
	 * • Spot-Check Operating Mode Support 
	 * • Continuous Measurement Operating Mode Support
	 * 
	 * The maximum length of this structure if all flags are set is 8 octets.
	 * 
	 * 
	 * @param bundle
	 * @param Flags
	 * @param ConfigurationSupport
	 * @param MeasurementStatusSupport
	 * @param DeviceandSensorStatus
	 * @param SpotCheckOperatingMode
	 * @param ContinuousMeasurementOperatingModeSupport
	 */
	public void on_pulse_oximetry_features(Bundle bundle,
			int Flags,
			int ConfigurationSupport,
			int MeasurementStatusSupport,
			int DeviceandSensorStatus,
			int SpotCheckOperatingMode,
			int ContinuousMeasurementOperatingModeSupport);
	
	/**
	 * CAUTION version 0.5
	 * 
	 *  Name: Pulse Oximetry Spot-Check Measurement
	 *  Type: org.bluetooth.characteristic.pulse_oximetry_spot-check_measurement
	 *  Assigned Number: 0x2A5E
	 *  
	 *  This characteristic is a variable length structure containing 
	 *  a Flags field, 
	 *  a SpO2PR-Fully-Qualified field, 
	 *  a Timestamp Field,   >>>> not present in the specification
	 *  and based upon the contents of the Flags field may contain 
	 *  a Measurement Status field 
	 *  and a Device and Sensor Status field.
	 *  The maximum length of this structure if all Flags are set is 16 octets. 
	 * 
	 * 
	 * @param bundle
	 * @param Flags
	 * @param MeasurementStatus
	 * @param DeviceandSensorStatus
	 */
	public void on_pulse_oximetry_spot_check_measurement(Bundle bundle,
			int Flags,
			int MeasurementStatus,
			int DeviceandSensorStatus);
	
	
	/**
	 * CAUTION version 0.5
	 * Not fully implemented
	 * 
	 * 
	 * Name: Record Access Control Point
	 * Type: org.bluetooth.characteristic.record_access_control_point
	 * Assigned Number: 0x2A52
	 * 
	 * This control point is used with a service to provide basic management functionality for the Glucose Sensor
	 * patient record database. This enables functions including counting records, transmitting records and clearing
	 * records based on filter criterion. The filter criterion in the Operand field is defined by the service that
	 * references this characteristic as is the format of a record (which may be comprised of one or more characteristics)
	 * and the sequence of transferred records.
	 * 
	 * @param bundle
	 * @param OpCode
	 * @param Operator
	 * @param RestOfRecord variable an hard to determine at this stage
	 */
	public void on_record_access_control_point(Bundle bundle,int OpCode,int Operator,byte[] RestOfRecord);
	
	public void on_reference_time_information(Bundle bundle,int TimeSource,int Accuracy,int HoursSinceUpdate);
	
	public void on_removable(Bundle bundle,int Removable);
	
	public void on_report(Bundle bundle,int ReportValue);
	
	public void on_report_map(Bundle bundle,int ReportMap);
	
	/**
	 * Name: Ringer Control point
	 * Type: org.bluetooth.characteristic.ringer_control_point
	 * Assigned Number: 0x2A40
	 * The Ringer Control Point characteristic defines the Control Point of Ringer.
	 * Value 1, meaning “Silent Mode"
	 * Value 2, meaning “Mute Once”
	 * Value 3, meaning “Cancel Silent Mode”
	 * Example:
	 * The value 0x01 shall be interpreted as “Silent Mode”
	 * 
	 * 
	 * @param bundle
	 * @param RingerControlPoint
	 * @param RingerControlPointText
	 */
	public void on_ringer_control_point(Bundle bundle,int RingerControlPoint,String RingerControlPointText);
	
	public void on_rsc_feature(Bundle bundle,int RSCFeature);
	
	public void on_rsc_measurement(Bundle bundle,int Flags,int InstantaneousSpeed,int InstantaneousCadence,int InstantaneousStrideLength,int TotalDistance);
	
	
	public void on_scan_refresh(Bundle bundle,int ScanRefreshValue);
	
	public void on_scientific_temperature_celsius(Bundle bundle,double ScientificTemperature);
	
	public void on_secondary_time_zone(Bundle bundle,int TimeZone,String TimeZoneString);
	
	public void on_sensor_location(Bundle bundle,int SensorLocation,String SensorLocationText);
	
	/**
	 * 
	 * 
	 * 
	 * @param bundle
	 * @param serial_number_string
	 */
	public void on_serial_number_string(Bundle bundle, String serial_number_string);
	
	/**
	 * CAUTION : version 0.5 but unlikely to change
	 * 
	 *  Name: Service Required
	 *  Type: org.bluetooth.characteristic.service_required
	 *  Assigned Number: 0x2A3B
	 * 
	 * @param bundle
	 * @param ServiceRequired
	 */
	public void on_service_required(Bundle bundle,int ServiceRequired);
	
	public void on_software_revision_string(Bundle bundle,String rev);
	
	public void on_string(Bundle bundle,String string);
	
	public void on_supported_new_alert_category(Bundle bundle,int categoryIDBitMask0,int categoryIDBitMask1);
	
	public void on_supported_unread_alert_category(Bundle bundle,int categoryIDBitMask0,int categoryIDBitMask1);
	
	public void on_system_id(Bundle bundle,int[] manufacturerIdentifier,int[] organizationallyUniqueIdentifier);
	
	
	public void on_temperature_celsius(Bundle bundle,float Temperature);
	
	public void on_temperature_fahrenheit(Bundle bundle,float Temperature);
	
	
	/**
	 * @param bundle
	 * @param flags
	 * @param TemperatureMeasurementValue Celcius or Farenheit check TemperatureUnitFlag
	 * @param TemperatureUnitFlag  0 : Celcius, 1 : Farenheit
	 * @param date if not present in the device, gives a local date
	 * @param temperatureType
	 * @param temperatureTypeString
	 */
	public void on_temperature_measurement(Bundle bundle,
			int flags,
			float TemperatureMeasurementValue,
			int TemperatureUnitFlag,
			Calendar date,
			int temperatureType,
			String temperatureTypeString);
	
	/**
	 * temperatureTypeDescription is 
	 * 
	 * 
	 * 
	 * @param bundle
	 * @param flag the flag that determines the TemperatureTextDescription
	 * @param TemperatureTextDescription 
	 * 				one of the following values
	 * 					Armpit
	 *					Body (general)
	 * 					Ear (usually ear lobe)
	 * 					Gastro-intestinal Tract
	 * 					Mouth
	 * 					Armpit
	 * 					Rectum
	 * 					Toe
	 * 					Tympanum (ear drum)
	 * 					Reserved for future use
	 */
	public void on_temperature_type(Bundle bundle,int flag,String TemperatureTextDescription);
	
	
	public void on_time_accuracy(Bundle bundle,int Accuracy);
	
	public void on_time_source(Bundle bundle,int TimeSource,String TimeSourceString);
	
	public void on_time_update_control_point(Bundle bundle,int TimeUpdateControlPoint,String TimeUpdateControlPointString);
	
	public void on_time_update_state(Bundle bundle,int CurrentState,String CurrentStateString,int Result,String ResultString);
	
	public void on_time_with_dst(Bundle bundle,Calendar date,int dSTOffset,String dSTOffsetValue);
	
	public void on_time_zone(Bundle bundle,int TimeZone,String TimeZoneString);
	
	/**
	 * Name: Tx Power Level
	 * Type: org.bluetooth.characteristic.tx_power_level
	 * Assigned Number: 0x2A07
	 * 
	 * Abstract:
	 * The Transmit Power Level characteristic represents the current transmit power level in dBm, and the level ranges from -100 dBm to +20 dBm to a resolution of 1 dBm.
	 * Summary:
	 * The value of the characteristic is a signed 8 bit integer that has a fixed point exponent of 0.
	 * Examples:
	 * The value 0x12 is interpreted as +18dBm
	 * The value 0xED is interpreted as -18dBm
	 * 
	 * @param bundle
	 * @param txPoxerLevel 				Unit:org.bluetooth.unit.logarithmic_radio_quantity.decibel
	 */
	public void on_tx_power_level(Bundle bundle,int txPoxer);
	
	
	
	/**
	 * Name: Unread Alert Status
	 * Type: org.bluetooth.characteristic.unread_alert_status
	 * Assigned Number: 0x2A45
	 * 
	 * Abstract:
	 * This characteristic shows how many numbers of unread alerts exist in the specific category in the device.
	 * 
	 * Summary:
	 * This characteristic consists of “Category ID” and “uint8” which shows the number of unread alerts/messages.
	 * 
	 * Example:
	 * The value 0x01, 0x04 are interpreted that the server has 4 unread messages in Email category.
	 * 
	 * 
	 * @param bundle
	 * @param categoryId
	 * @param comment
	 * @param Unreadcount
	 */
	public void on_unread_alert_status(Bundle bundle,int categoryId,String comment ,int Unreadcount);
	
	
	public void on_bluegiga_manufacturer_id(Bundle bundle, String hex);
	
	public void on_bluegiga_model_number(Bundle bundle, String hex);
	
	public void on_bluegiga_manufacturer_name(Bundle bundle, String hex);
	
	/**
	 * the Battery status as defined in bluegiga dkle112 example
	 * 	<service uuid="e001">
     *	 	<description>Battery status</description>
     *	 	<include id="manufacturer" />
     *	 	<characteristic uuid="e101" id="xgatt_battery">
     *    		<properties read="true" />
     *   	 	<value type="hex">ABCD</value>
     *		</characteristic>
     *	</service>
	 * 
	 * @param bundle
	 */
	public void on_bluegiga_Battery(Bundle bundle, String value);
	
	public void on_handle_bluegiga_accelerometer_x_data(Bundle bundle,float x_data);
	public void on_handle_bluegiga_accelerometer_y_data(Bundle bundle,float y_data);
	public void on_handle_bluegiga_accelerometer_z_data(Bundle bundle,float z_data);
	
	
	//Asica
	public void on_handle_asica_heart_rate(Bundle bundle,Calendar date,int heartRate);
	public void on_handle_asica_fall_detection_alert(Bundle bundle,Calendar date,boolean alertButtonPressed,boolean fallDetected,boolean lowBattery,boolean ambulatoryTerminalRequest,int futureUse);
	public void on_asica_ambulatory_terminal_state(Bundle bundle,Calendar date,boolean fallDetectorWear,boolean horizontal,boolean earlobeSensorOff,boolean earlobeUnplugged,int futureUse);
	public void on_asica_ambulatory_terminal_activity(Bundle bundle,Calendar date,int activity,int futureUse);
}
