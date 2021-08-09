
package com.example.ilithyia;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatDialogFragment;

    public class Stam extends AppCompatDialogFragment {
        private TextView popInfo,sth;
        public static int number=0;
        private String[] arr;

        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            AlertDialog.Builder builder=new AlertDialog.Builder(getActivity());
            LayoutInflater inflater= getActivity().getLayoutInflater();

            arr= new String[]{"1.Clitoris: is right at the top, under the point where the inner lips meet and form a little hood.\n It is known to be the center of the vulva.\n The Clitoris is a bundle of nerves, with no main purpose beyond giving pleasure.\n", "2", "3", "4", "5", "6", "7"};
            View view=inflater.inflate(R.layout.layout_dialog,null);

            builder.setView(view)
                    .setTitle(arr[number])
                    .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {

                        }
                    });
            //popInfo=view.findViewById(R.id.sth);

            return builder.create();

        }
        // public void setNum(String num)
        //{
        //  number=num;
        //}
    }


