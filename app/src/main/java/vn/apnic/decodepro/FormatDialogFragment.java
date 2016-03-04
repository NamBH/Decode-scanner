package vn.apnic.decodepro;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;

import com.doomy.zxing.ZXingScannerView;
import com.google.zxing.BarcodeFormat;

import java.util.ArrayList;

public class FormatDialogFragment extends DialogFragment {

    public interface FormatDialogListener {
        public void onFormatsSaved(ArrayList<Integer> selectedIndices);
    }

    private ArrayList<Integer> mSelectedIndices;
    private FormatDialogListener mListener;

    public void onCreate(Bundle state) {
        super.onCreate(state);
        setRetainInstance(true);
    }

    public static FormatDialogFragment newInstance(FormatDialogListener listener, ArrayList<Integer> selectedIndices) {
        FormatDialogFragment mFragment = new FormatDialogFragment();
        if(selectedIndices == null) {
            selectedIndices = new ArrayList<>();
        }
        mFragment.mSelectedIndices = new ArrayList<>(selectedIndices);
        mFragment.mListener = listener;
        return mFragment;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        if(mSelectedIndices == null || mListener == null) {
            dismiss();
            return null;
        }

        String[] mFormats = new String[ZXingScannerView.ALL_FORMATS.size()];
        boolean[] mCheckedIndices = new boolean[ZXingScannerView.ALL_FORMATS.size()];
        int i = 0;
        for(BarcodeFormat mFormat : ZXingScannerView.ALL_FORMATS) {
            mFormats[i] = Utils.renameFormat(mFormat.toString());
            if(mSelectedIndices.contains(i)) {
                mCheckedIndices[i] = true;
            } else {
                mCheckedIndices[i] = false;
            }
            i++;
        }

        AlertDialog.Builder mAlertBuilder = new AlertDialog.Builder(getActivity(), Utils.setThemeDialog());
		
        mAlertBuilder.setTitle(R.string.choose_format)
                .setMultiChoiceItems(mFormats, mCheckedIndices,
                        new DialogInterface.OnMultiChoiceClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                                if (isChecked) {
                                    mSelectedIndices.add(which);
                                } else if (mSelectedIndices.contains(which)) {
                                    mSelectedIndices.remove(mSelectedIndices.indexOf(which));
                                }
                            }
                        })
                .setPositiveButton(R.string.okay, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        if (mListener != null) {
                            mListener.onFormatsSaved(mSelectedIndices);
                        }
                    }
                })
                .setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                    }
                });

        return mAlertBuilder.create();
    }
}
