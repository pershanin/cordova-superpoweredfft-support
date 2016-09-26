package org.pearson.superpoweredfft;
 
import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.json.JSONObject;
import org.json.JSONArray;
import org.json.JSONException;

import android.app.Activity;
import android.content.Intent;

public class SuperpoweredFFT extends CordovaPlugin {

	@Override
	public boolean execute(String action, JSONArray args, final CallbackContext callbackContext) throws JSONException {
		if (action.equals("getComplex")) { 
			JSONObject arg_object = args.getJSONObject(0);
			double real = arg_object.getDouble("real");
			double imag = arg_object.getDouble("imag");
			int logSize = arg_object.getInt("logSize");
			boolean forward = arg_object.getBoolean("forward");
			
			String jniString = SuperpoweredJni.stringFromJNI();
			
			JSONObject json = new JSONObject();
			json.put("real", real + jniString);
			
			callbackContext.success(json);
			return true;
		} else {
			callbackContext.error("Invalid action");
			return false;
		}
	}
	
}