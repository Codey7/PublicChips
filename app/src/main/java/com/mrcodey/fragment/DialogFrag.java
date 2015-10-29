package com.mrcodey.fragment;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;

import com.mrcodey.main.R;

/**
 * Created by Mr.Codey on 2015/9/19.
 */
public class DialogFrag extends DialogFragment
{
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        // Get the layout inflater
        LayoutInflater inflater = getActivity().getLayoutInflater();

        // Inflate and set the layout for the dialog
        // Pass null as the parent view because its going in the dialog layout
        builder.setView(inflater.inflate(R.layout.dialog_agree, null))
                // Add action buttons
                .setPositiveButton(R.string.agree, new DialogInterface.OnClickListener()
                {
                    @Override
                    public void onClick(DialogInterface dialog, int id)
                    {
                        // sign in the user ...
                    }
                });
        return builder.create();
    }
}
