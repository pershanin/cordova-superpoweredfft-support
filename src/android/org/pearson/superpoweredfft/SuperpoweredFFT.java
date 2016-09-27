package org.pearson.superpoweredfft;

import org.apache.cordova.*;
import org.json.JSONObject;
import org.json.JSONArray;
import org.json.JSONException;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SuperpoweredFFT extends CordovaPlugin {

	@Override
	public boolean execute(String action, JSONArray args, final CallbackContext callbackContext) throws JSONException {
		if (action.equals("getComplex")) { 
			JSONObject arg_object = args.getJSONObject(0);
			int real = arg_object.getInt("real");
			int imag = arg_object.getInt("imag");
			int logSize = arg_object.getInt("logSize");
			boolean forward = arg_object.getBoolean("forward");
			
			SuperpoweredExample.onPlayPause(false);
			
			JSONObject json = new JSONObject();
			json.put("real", real);
			
			callbackContext.success(json);
			return true;
		} else {
			callbackContext.error("Invalid action");
			return false;
		}
	}
	
	public void SuperpoweredExample_PlayPause(View button) {  // Play/pause.
    	playing = !playing;
    	onPlayPause(playing);
    	Button b = (Button) findViewById(R.id.playPause);
    	b.setText(playing ? "Pause" : "Play");
    }
	
	private native void SuperpoweredExample(String apkPath, long[] offsetAndLength);
	private native void onPlayPause(boolean play);
    
    static {
        System.loadLibrary("SuperpoweredExample");
    }
	
}