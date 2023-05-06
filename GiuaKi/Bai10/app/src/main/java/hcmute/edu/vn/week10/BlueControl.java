package hcmute.edu.vn.week10;

import android.Manifest;
import android.app.ProgressDialog;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import java.io.IOException;
import java.util.Set;
import java.util.UUID;



public class BlueControl extends AppCompatActivity {
    ImageButton btnTb1, btnTb2, btnDis;
    TextView txt1, txtMAC;
    BluetoothAdapter myBluetooth = null;
    BluetoothSocket btSocket = null;
    private Boolean isBtConnected = false;
    Set<BluetoothDevice> pairedDevices1;
    String address = null;
    private ProgressDialog progress;
    int flaglamp1;
    int flaglamp2;
    static final UUID myUUID = UUID.fromString("00001101-0000-1000-8000-00805F9B34FB");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent newint = getIntent();
        address = newint.getStringExtra(MainActivity.EXTRA_ADDRESS);
        setContentView(R.layout.activity_control);

        btnTb1 = (ImageButton) findViewById(R.id.btnTb1);
        btnTb2 = (ImageButton) findViewById(R.id.btnTb2);
        txt1 = (TextView) findViewById(R.id.textV1);
        txtMAC = (TextView) findViewById(R.id.textViewMac);
        btnDis = (ImageButton) findViewById(R.id.btnDisc);
        new ConnectBT().execute();
        btnTb1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                thietTbi1();
            }
        });
        btnTb2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                thietTbi7();
            }
        });
        btnDis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Disconnect();
            }
        });
    }

    private void thietTbi1() {
        if (btSocket != null) {
            try {
                if (this.flaglamp1 == 0) {
                    this.flaglamp1 = 1;
                    this.btnTb1.setBackgroundResource(R.drawable.tb1on);
                    btSocket.getOutputStream().write("1".toString().getBytes());
                    txt1.setText("Thiet bi so 1 dang bat");
                    return;
                } else {
                    if (this.flaglamp1 != 1) {
                        return;
                    }
                    {
                        this.flaglamp1 = 0;
                        this.btnTb1.setBackgroundResource(R.drawable.tboff);
                        btSocket.getOutputStream().write("A".toString().getBytes());
                        txt1.setText("Thiet bi so 1 dang tat");
                        return;
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void Disconnect() {
        if (btSocket != null) {
            try {
                btSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        finish();
    }

    private void thietTbi7() {
        if (btSocket != null) {
            try {
                if (this.flaglamp2 == 0) {
                    this.flaglamp2 = 1;
                    this.btnTb2.setBackgroundResource(R.drawable.tb7on);
                    btSocket.getOutputStream().write("7".toString().getBytes());
                    txt1.setText("Thiet bi so 7 dang bat");
                    return;
                } else {
                    if (this.flaglamp2 != 1) {
                        return;
                    }
                    {
                        this.flaglamp2 = 0;
                        this.btnTb2.setBackgroundResource(R.drawable.tboff);
                        btSocket.getOutputStream().write("G".toString().getBytes());
                        txt1.setText("Thiet bi so 7 dang tat");
                        return;
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private class ConnectBT extends AsyncTask<Void, Void, Void> {
        private boolean ConnectSuccess = true;
        @Override
        protected void onPreExecute() {
            progress = ProgressDialog.show(BlueControl.this, "Connecting...", "Please wait!!!");
        }
        @Override
        protected Void doInBackground(Void... devices) {
            try {
                if (btSocket == null || !isBtConnected) {
                    myBluetooth = BluetoothAdapter.getDefaultAdapter();
                    BluetoothDevice dispositivo = myBluetooth.getRemoteDevice(address);
                    if (ActivityCompat.checkSelfPermission(BlueControl.this, Manifest.permission.BLUETOOTH_CONNECT) != PackageManager.PERMISSION_GRANTED) {
                        btSocket = dispositivo.createRfcommSocketToServiceRecord(myUUID);
                        BluetoothAdapter.getDefaultAdapter().cancelDiscovery();
                        btSocket.connect();
                    }
                }
            } catch (IOException e) {
                ConnectSuccess = false;
            }
            return null;
        }
        @Override
        protected void onPostExecute(Void result) {
            super.onPostExecute(result);
            if (!ConnectSuccess) {
                Toast.makeText(getApplicationContext(), "Connection Failed. Is it a SPP Bluetooth? Try again.", Toast.LENGTH_LONG).show();
                finish();
            } else {
                Toast.makeText(getApplicationContext(), "Connected.", Toast.LENGTH_LONG).show( );
                isBtConnected = true;
                pairedDevicesList1();
            }
            progress.dismiss();
        }

    }
    private void pairedDevicesList1() {
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.BLUETOOTH_CONNECT) != PackageManager.PERMISSION_GRANTED) {
            pairedDevices1 = myBluetooth.getBondedDevices();
            if (pairedDevices1.size() > 0) {
                for (BluetoothDevice bt : pairedDevices1) {
                    txtMAC.setText(bt.getName() + "\n" + bt.getAddress());

                }
            } else {
                Toast.makeText(getApplicationContext(), "No Paired Bluetooth Devices Found.", Toast.LENGTH_LONG).show();
            }
        }

    }
}
