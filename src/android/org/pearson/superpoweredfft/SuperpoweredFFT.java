package org.pearson.superpoweredfft;

import org.apache.cordova.*;
import org.json.JSONObject;
import org.json.JSONArray;
import org.json.JSONException;
import android.app.Activity;
import android.os.Bundle;

public class SuperpoweredFFT extends CordovaPlugin {

	@Override
	public boolean execute(String action, JSONArray args, final CallbackContext callbackContext) throws JSONException {
		if (action.equals("getComplex")) { 
			JSONObject json = new JSONObject();
			json.put("real", "real");
			
			callbackContext.success(json);
			return true;
		} else {
			callbackContext.error("Invalid action");
			return false;
		}
	}
	
}