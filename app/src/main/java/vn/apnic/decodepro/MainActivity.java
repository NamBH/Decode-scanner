package vn.apnic.decodepro;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

public class MainActivity extends Activity {

    private boolean mValue;

    @Override
    public void onCreate(Bundle state) {
        super.onCreate(state);

        setTheme(Utils.setThemeVersion());

        setContentView(R.layout.activity_main);

        // Open "Hello" dialog at the first launch
        openFirstDialog();

        MainFragment mFragment = new MainFragment();
        getFragmentManager().beginTransaction().replace(R.id.fragment_container, mFragment).commit();
    }

    // Create AlertDialog for the first launch
    private void openFirstDialog() {
        mValue = getSharedPreferences("PREFERENCE", MODE_PRIVATE).getBoolean("mValue", true);

        if (mValue) {
            AlertDialog.Builder mAlertDialog = new AlertDialog.Builder(MainActivity.this, Utils.setThemeDialog());

            mAlertDialog.setTitle(getString(R.string.hello));
            mAlertDialog.setMessage(getString(R.string.message));
            mAlertDialog.setPositiveButton(getString(R.string.okay), new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();
                }
            });
            mAlertDialog.show();

            getSharedPreferences("PREFERENCE", MODE_PRIVATE).edit().putBoolean("mValue", false).commit();
        }
    }
}