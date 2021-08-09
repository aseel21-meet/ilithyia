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


public class InfoDialog extends AppCompatDialogFragment {
    private TextView popInfo,sth,title;
    public static int number=0;
    private int num;
    private String[] arr;



    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder=new AlertDialog.Builder(getActivity());
        LayoutInflater inflater= getActivity().getLayoutInflater();

        arr= new String[]{
                "1.Clitoris: is right at the top, under the point where the inner lips meet and form a little hood.\n It is known to be the center of the vulva.\n The Clitoris is a bundle of nerves, with no main purpose beyond giving pleasure.\n",
                "2. Urinary Tract: The place from where you pee",
                "3. Vagina: a muscular canal that extends from the vulva to the cervix. It is the place where the lining of the uterus sheds during menstruation, where penetration can ocur during sex, and where a baby descends through during child birth.\n",
                "4. Labia Majora (outer lips), folds of skin around the vaginal opening. They are usually fleshy and covered with pubic hair (nothing to be ashamed of.) ",
                "5. Labia Minora (inner lips): folds of skin around your vagina that are inside the labia majora(4). They begin at the clitoris  and end under the opening of the vagina.\n" +
                        "\n",
                "6.Bartholing’s glands: located on each side of  the vaginal opening, they are responsible for secreting fluid that helps lubricate the vagina when you are aroused.",
                "7.Anus: a hole through which bodily waste comes out of (poop)\n",
                "1.The Uterus (one of the main parts): it is the hollow, pear-shaped organ in a woman's pelvis. It is the place where we all grew for approximately 9 months before we were born. It is also responsible for producing vaginal and uterine secretions (which helps transiting the sperm to the fallopian tubes.)\n",
                "2.Ovaries (the second main part): a pair of female glands that produce the egg cell. They also produce and secrete the hormones estrogen and progesterone, which play an important role in the changes that occur during puberty. These hormones are responsible for breast development, body shape, and body hair.\n",
                "3.Vagina: a muscular canal that extends from the vulva to the cervix. It is the place where the lining of the uterus sheds during menstruation, where penetration can ocur during sex, and where a baby descends to during child birth.\n",
                "4.Cervix: is the lower narrow end of the uterus that forms a canal between the uterus and vagina, connecting them together.",
                "5.Fallopian tubes: a pair of tubes that connect between the ovaries and the Uterus.\n" +
                        "Eggs travel through these tubes, from the ovaries to the uterus.\n"
        };
        View view=inflater.inflate(R.layout.layout_dialog,null);
        if(number>=7)
        {
            num=number-6;
        }
        else{
            num=number+1;
        }


        popInfo= view.findViewById(R.id.popinfo);
        popInfo.setText(arr[number]);

        View view2=inflater.inflate(R.layout.activity_female_anatomy_quiz,null);




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
