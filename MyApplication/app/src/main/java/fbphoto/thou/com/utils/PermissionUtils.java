package fbphoto.thou.com.utils;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

/**
 * Created by Computer on 2/8/2018.
 */

public class PermissionUtils {
    private static String TAG=PermissionUtils.class.getSimpleName();
    public static final String Manifest_BODY_SENSORS = Manifest.permission.BODY_SENSORS;
    public static final String Manifest_READ_CALENDAR = Manifest.permission.READ_CALENDAR;
    public static final String Manifest_WRITE_CALENDAR = Manifest.permission.WRITE_CALENDAR;
    public static final String Manifest_READ_CONTACTS = Manifest.permission.READ_CONTACTS;
    public static final String Manifest_WRITE_CONTACTS = Manifest.permission.WRITE_CONTACTS;
    public static final String Manifest_GET_ACCOUNTS = Manifest.permission.GET_ACCOUNTS;
    public static final String Manifest_READ_EXTERNAL_STORAGE = Manifest.permission.READ_EXTERNAL_STORAGE;
    public static final String Manifest_WRITE_EXTERNAL_STORAGE = Manifest.permission.WRITE_EXTERNAL_STORAGE;
    public static final String Manifest_ACCESS_FINE_LOCATION = Manifest.permission.ACCESS_FINE_LOCATION;
    public static final String Manifest_ACCESS_COARSE_LOCATION = Manifest.permission.ACCESS_COARSE_LOCATION;
    public static final String Manifest_RECORD_AUDIO = Manifest.permission.RECORD_AUDIO;
    public static final String Manifest_READ_PHONE_STATE = Manifest.permission.READ_PHONE_STATE;
    public static final String Manifest_CALL_PHONE = Manifest.permission.CALL_PHONE;
    public static final String Manifest_READ_CALL_LOG = Manifest.permission.READ_CALL_LOG;
    public static final String Manifest_WRITE_CALL_LOG = Manifest.permission.WRITE_CALL_LOG;
    public static final String Manifest_ADD_VOICEMAIL = Manifest.permission.ADD_VOICEMAIL;
    public static final String Manifest_USE_SIP = Manifest.permission.USE_SIP;
    public static final String Manifest_PROCESS_OUTGOING_CALLS = Manifest.permission.PROCESS_OUTGOING_CALLS;
    public static final String Manifest_CAMERA = Manifest.permission.CAMERA;
    public static final String Manifest_SEND_SMS = Manifest.permission.SEND_SMS;
    public static final String Manifest_RECEIVE_SMS = Manifest.permission.RECEIVE_SMS;
    public static final String Manifest_READ_SMS = Manifest.permission.READ_SMS;
    public static final String Manifest_RECEIVE_WAP_PUSH = Manifest.permission.RECEIVE_WAP_PUSH;
    public static final String Manifest_RECEIVE_MMS = Manifest.permission.RECEIVE_MMS;

    public static final String Manifest_GROUP_CALENDAR=Manifest.permission_group.CALENDAR;
    public static final String Manifest_GROUP_CAMERA=Manifest.permission_group.CAMERA;
    public static final String Manifest_GROUP_CONTACTS=Manifest.permission_group.CONTACTS;
    public static final String Manifest_GROUP_LOCATION=Manifest.permission_group.LOCATION;
    public static final String Manifest_GROUP_MICROPHONE=Manifest.permission_group.MICROPHONE;
    public static final String Manifest_GROUP_PHONE=Manifest.permission_group.PHONE;
    public static final String Manifest_GROUP_SENSORS=Manifest.permission_group.SENSORS;
    public static final String Manifest_GROUP_SMS=Manifest.permission_group.SMS;
    public static final String Manifest_GROUP_STORAGE=Manifest.permission_group.STORAGE;

    public static boolean isStoragePermissionGranted(AppCompatActivity context) {
        if (Build.VERSION.SDK_INT >= 23) {
            if (context.checkSelfPermission(android.Manifest.permission.WRITE_EXTERNAL_STORAGE)
                    == PackageManager.PERMISSION_GRANTED && context.checkSelfPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
                    == PackageManager.PERMISSION_GRANTED) {
                Log.d(TAG, "Permission is granted");
                return true;
            } else {

                Log.d(TAG, "Permission is revoked");
                ActivityCompat.requestPermissions(context, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.READ_EXTERNAL_STORAGE}, 1);
                return false;
            }
        } else { //permission is automatically granted on sdk<23 upon installation
            Log.d(TAG, "Permission is granted");
            return true;
        }
    }


    public static boolean isCameraPermissionGranted(AppCompatActivity context) {
        if (Build.VERSION.SDK_INT >= 23) {
            if (context.checkSelfPermission(android.Manifest.permission.WRITE_EXTERNAL_STORAGE)
                    == PackageManager.PERMISSION_GRANTED && context.checkSelfPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
                    == PackageManager.PERMISSION_GRANTED &&context.checkSelfPermission(Manifest.permission.CAMERA)
                    == PackageManager.PERMISSION_GRANTED) {
                Log.d(TAG, "Permission is granted");
                return true;
            } else {

                Log.d(TAG, "Permission is revoked");
                ActivityCompat.requestPermissions(context, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.READ_EXTERNAL_STORAGE,Manifest.permission.CAMERA}, 1);
                return false;
            }
        } else { //permission is automatically granted on sdk<23 upon installation
            Log.d(TAG, "Permission is granted");
            return true;
        }
    }


    public interface PermissionResult{
        void permissionGranted();

        void permissionDenied();

        void permissionForeverDienid();
    }
}
