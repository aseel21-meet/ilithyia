package com.example.ilithyia;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatDialogFragment;

public class vdPopup  extends AppCompatDialogFragment {
    private TextView popInfo;
    public static int number=0;
    private String[] answers;
    public static String correct="correct";
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        AlertDialog.Builder builder=new AlertDialog.Builder(getActivity());
        LayoutInflater inflater= getActivity().getLayoutInflater();

        View view=inflater.inflate(R.layout.vdq,null);

        answers=new String[]{
                " vaginal discharge its a sluggish fluid that you might notice on your underwear, it is perfectly normal most of the time, it can be clear, or around milky whitish ",
                "vaginal discharge carries away dead cells and bacteria, this helps keep the vagina clean and moist \n",
                "Your menstrual cycle stages may affect the amount of vaginal discharge everyday (not extremely) \n" +
                        "When you are ovulating or breastfeeding you may notice these changes. \n",
                "No, some changes may be caused by imbalance of your vaginal bacteria. ",
                "Might notice shades of red in between periods, in her vaginal discharge ",
                " vaginal discharge is usually the result of bleeding, when? Some women may experiance an imbalance in their hormones,their periods wont be regular and might notice some bleeding in between, there are other causes to red discharge which you can check in our article on the subject. ",
                "\n" +
                        "Yes! Your nutrition and life style have a great affect on your vaginal health, a slight change of shades can show in your vaginal discharge following a diet change,as it might  turn into pale yellow.\n",
                "chunky and/or smelly yellowish greenish color might be a sign of a sexually transmitted disease, most commonly trichomoniasis, it is very important that you see a doctor",
                " bacterial vaginosis is the most common infection in women between the ages of 15-44, \n" +
                        "A white thick discharge with fishy smell can indicate such an infections. \n",
                " itching, burning and cottage cheese texture should be a sign of an infection called yeast infection that is related to a fungus called candida, dont worry it is  treatable ",
                "your blood turns darker and into brown with time, this is why you are likely to find these shades of color during the last days of your period\n"
                };
        popInfo= view.findViewById(R.id.answer);
        popInfo.setText(answers[number-1]);




            builder.setView(view)

                .setTitle(correct)
                .setPositiveButton("ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {


            }
        });
        //popInfo=view.findViewById(R.id.sth);
            return builder.create();


    }

}

