package com.example.modernartui;


import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

/*Polichronis Charitidis*/

public class MyDialogFragment extends DialogFragment {

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        DialogInterface.OnClickListener positiveClick = new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //Toast.makeText(getActivity().getBaseContext(), "Application finishing ...", Toast.LENGTH_SHORT).show();

                Intent intent=new Intent(Intent.ACTION_VIEW,Uri.parse("http://www.moma.org"));
                getActivity().startActivity(intent);
            }
        };

        DialogInterface.OnClickListener negativeClick = new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // Toast.makeText(getActivity().getBaseContext(), "No option selecting", Toast.LENGTH_SHORT).show();

                dismiss();
            }
        };

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        //builder.setMessage("Do you want Yes or No ?");

        builder.setNegativeButton("Not Now", negativeClick);
        builder.setPositiveButton("Visit MOMA", positiveClick);
        builder.setTitle("Visit to learn more");
        Dialog dialog = builder.create();
        return dialog;
    }
}