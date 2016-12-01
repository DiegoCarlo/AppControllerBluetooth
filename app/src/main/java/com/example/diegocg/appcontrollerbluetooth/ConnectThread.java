package com.example.diegocg.appcontrollerbluetooth;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;
import android.util.Log;

import java.io.IOException;
import java.util.UUID;

/**
 * Created by DiegoCG on 01/12/2016.
 */

public class ConnectThread extends Thread {
    private final BluetoothSocket mmSocket;
    private final BluetoothDevice mmDevice;
    public static final UUID MY_UUID = UUID.fromString("00001101-0000-1000-8000-00805F9B34FB");

    BluetoothAdapter bluetoothAdapter;

    public ConnectThread(BluetoothDevice device) {
        BluetoothSocket tmp = null;
        mmDevice = device;

        // Get a BluetoothSocket to connect with the given BluetoothDevice
        try {
            // MY_UUID is the app's UUID string, also used by the server code
            tmp = device.createRfcommSocketToServiceRecord(MY_UUID);
            Log.i("ConnectThread", tmp.getRemoteDevice().getName()+" "+tmp.getRemoteDevice().getAddress());
        } catch (IOException e) {
            Log.e("ConnectThread", e.toString());
        }
        mmSocket = tmp;
    }

    public void run() {
        Log.i("ConnectThread", "run");
        // Cancel discovery because it will slow down the connection
        bluetoothAdapter.cancelDiscovery();

        try {
            // Connect the device through the socket. This will block
            // until it succeeds or throws an exception
            mmSocket.connect();
            Log.i("ConnectThread.run", mmSocket.toString()+"");
        } catch (IOException connectException) {
            Log.e("ConnectThread.run","Unable to connect; close the socket and get out");
            try {
                mmSocket.close();
                Log.e("ConnectThread.run","Get out");
            } catch (IOException closeException) {

                Log.e("ConnectThread.run","Unable to get out");
            }
            return;
        }

        // Do work to manage the connection (in a separate thread)
/*
        socket = mmSocket;
        mHandler.obtainMessage(SUCCESS_CONNECT, mmSocket).sendToTarget();*/
    }



    /** Will cancel an in-progress connection, and close the socket */
    public void cancel() {
        try {
            mmSocket.close();
        } catch (IOException e) { }
    }
}