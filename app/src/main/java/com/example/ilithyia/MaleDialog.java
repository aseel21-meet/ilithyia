package com.example.ilithyia;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatDialogFragment;


public class MaleDialog extends AppCompatDialogFragment {
    private TextView popInfo,sth,title;
    public static int number=0;
    private int num;
    private String[] arr;



    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder=new AlertDialog.Builder(getActivity());
        LayoutInflater inflater= getActivity().getLayoutInflater();

        arr= new String[]{
                "1.Bladder: A hollow organ that stores the urine in the body",
                "2.Prostate Glands: glands through which the urethra goes through. In addition it secretes a fluid that nourishes and protects the sperm.\n",
                "3.Sperm duct: Sperm Duct, or Vas Deferens, carries the sperm from their storage place to the Urethra",
                "4.Urethra: The urethra is a small hole right at the tip of the penis ,through which you pee or ejeculate sperm when you reach your climax during sex.\n" +
                        "Can I pee and ejeculate at the same time?\n" +
                        "No. When you’re aroused, the flow of urine is blocked.\n",
                "5.Penis: The penis, used for bodily needs and sexual needs, is connected to the wall of your abdomen. That connection is called a root.\n" +
                        "After the root is the main body of the penis, shaped like a cylinder. This part is called the body or shaft. When you get aroused, the body of the penis fills with blood, making it rigid and ready for sex. \n",
                "6.Foreskin: Next up, right at the tip are the glands, a cone shaped ending covered with a loose piece of skin called foreskin, which is sometimes removed during a circumcision. (whatever you have, it's perfect!)\n",
                "7.Testes: The testes, or testicles, are located in the scrotum  (8). Testes are usually two oval organs, one on each side. Inside the testes are a bunch of tubes responsible for producing sperms, in addition to the testosterone that is produced there.\n" +
                        "Why are testicles sometimes nicknamed “the family jewels” in pop culture?\n" +
                        "Because the testicles are in charge of continuing the family. \n",
                "8.Scrotum:  The scrotum is right below the penis. It is a sac of skin which protects the testicles from getting hurt - from the weather, and from outside attack.\n"

        };
        View view=inflater.inflate(R.layout.layout_dialog,null);
        num=number+1;


        popInfo= view.findViewById(R.id.popinfo);
        popInfo.setText(arr[number]);

        View view2=inflater.inflate(R.layout.activity_male_anatomy_game,null);




        builder.setView(view)
                .setTitle((num)+"")
                .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {


                    }
                });
        //popInfo=view.findViewById(R.id.sth);
        return builder.create();


    }

}

