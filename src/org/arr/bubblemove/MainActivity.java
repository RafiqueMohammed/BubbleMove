package org.arr.bubblemove;

import android.app.Activity;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;

public class MainActivity extends Activity implements SensorEventListener {
	BubbleView bubbleView;
	SensorManager manager;
	Sensor accel;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		bubbleView = new BubbleView(this);
	    setContentView(bubbleView);
	    
	    manager = (SensorManager)getSystemService(SENSOR_SERVICE);
	    accel = manager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
	    manager.registerListener(this, accel, 
	        SensorManager.SENSOR_DELAY_GAME);

	}
	@Override
	public void onSensorChanged(SensorEvent event) {
		// TODO Auto-generated method stub
		bubbleView.move(event.values[0], event.values[1]);
	    bubbleView.invalidate();
	}
	@Override
	public void onAccuracyChanged(Sensor sensor, int accuracy) {
		// TODO Auto-generated method stub
		
	}




}

