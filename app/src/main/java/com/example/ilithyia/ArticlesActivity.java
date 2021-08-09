package com.example.ilithyia;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ArticlesActivity extends AppCompatActivity implements View.OnClickListener {
    private int score;
    private TextView stav1,stav2, stav3, stav4, stav5;
    public Article[] articles;
    private String title;
    private Bundle extras;
    private ImageView imagePlayPause;
    private FirebaseDatabase db=FirebaseDatabase.getInstance("https://ilithy-64c52-default-rtdb.europe-west1.firebasedatabase.app/");
    private DatabaseReference root=db.getReference().child("evaluations");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_articles);
        Article a1=new Article("Male Puberty",
                "Around the age of eleven to fourteen, you might start to feel some changes happening to you, emotionally and physically. And that's okay!\n" +
                "This process is called Puberty, and the cause of these changes is hormones, and specifically one called “testosterone”. \n" +
                "\n" +
                "These hormones help determine your moods, and with the sudden changes during puberty, you might be in for a bit of a rollercoaster, or maybe a calmer ride. Puberty isn't an easy time, but it is a time of change and growth, a natural process that happens during our lives. It's natural to maybe feel insecure or depressed, but you gotta remember that it's happening to everyone, and it's okay to talk about it and feel what you feel.\n" +
                "\n" +
                "Beyond the emotional changes, physical changes also occur during puberty. \n" +
                "These changes include:\n" +
                "\n" +
                "   -Your genitals grow\n" +
                "   -You start to grow more hair all around your body, mainly hair under your armpits, facial hair, pubic hair.\n" +
                "   -Your voice becomes deeper, and you start to have “voice breaks”; sometimes your voice gets really deep for a minute then is really high for another.\n" +
                "   -Most boys also start to develop acne, mainly on your face and back.\n" +
                "   -You go through a big growth spurt that can last up until the age of twenty-one.\n",
                null);

        Article a2=new Article("Female Puberty",
                "Is there a name for the process I am going through as I am turning into an adult? \n" +
                " Yes PUBERTY! \n" +
                "Puberty is a period of time in which our bodies go through numeral changes until they reach sexual maturity. This process usually  starts at the age of 11 - 12 for females.\n" +
                "As females,  in the early stages, we might notice our breasts beginning to develop.\n" +
                " It might be overwhelming, but this change is completely normal and part of your turning-into-a-woman journey.\n" +
                "\n" +
                "Later on you will get your first period! An especially  red friend who will visit you each month for the coming years.\n" +
                "Period? \n" +
                "A period is part of the menstrual cycle, when a woman bleeds from her vagina for a few days.\n" +
                "On average this happens every 28 days, but of course for each woman it is different and can be less or more frequent.\n" +
                "Now do not worry about all the blood, you can use sanitary products to soak it up such as sanitary pads, tampons, menstrual cups. \n" +
                "# for further information check our article on periods!\n" +
                "You go through puberty before becoming an adult, the first signs for females are the development of the breasts and getting your first period!\n" +
                "\n" +
                " Are there any other changes? \n" +
                "Yes definitely. \n" +
                "You will be going through quite a few, it might be overwhelming and strange at the beginning, but the good news is YOU ARE NOT ALONE.  You can talk about it to any other woman who you trust and feel comfortable around.\n" +
                "\n" +
                "Now lets go over some of those changes:\n" +
                "   -Acne ew? nahhh \n" +
                "You might start noticing spots on your skin such as blackheads, whiteheads, pustules, and even if it is a little upsetting you need to remember it is totally normal and not at all gross. \n" +
                "You can make sure to keep your skin healthy by following a skin care routine, and Not popping those pimples!\n" +
                "   -Bras ? That is new...\n" +
                "As you go through puberty your breasts will continue developing, for each young woman her breasts will look different at different stages and we should embrace the uniqueness of our bodies, no shape is the right one!\n" +
                "You  might decide you want to start wearing a bra, (your size might change from time to time which is NORMAL.)  Deciding you do not want to wear bras is also an option, do what feels right for you!\n" +
                "   -Mustache? \n" +
                "During puberty you will notice hair growing in several part of your body, such as upper lip underarm and pubic hair, you do not need to stress about it, it is completely normal \n" +
                "   -There is a fluid on my underwear! \n" +
                "\tDo not panic! This is vaginal discharge and most women and girls get it. \n" +
                "\tThis fluid is actually protecting your vagina, keeping it clean and moist. \n" +
                "   Please note that changes in the color or texture of the discharge may be a sign of infection, so be sure to check out how to treat it. \n" +
                "   -Change in weight: \n" +
                "Girls when you go through puberty you will gain weight, the shape of your  body will change and it is totally okay and normal!\n" +
                "It is not something you need to worry about or be insecure about! Be confident in your own skin you are perfect just the way you are.  \n" +
                "\n" +
                "You will notice your body changing, signs of acne hair, developing breasts, gaining fat, vaginal discharge and periods, are all part of puberty. \n" +
                "\tWhen and how it happens differs from a girl to another. \n" +
                "Remember to love your body and enjoy the journey of turning into a powerful woman!\n",
                null);

        Article a3=new Article("Contraceptives 101",
                "So now you wanna have sex, and you’re not sure how to protect yourself and what exactly you need to do, well, we got you.\n" +
                "The most common types of contraceptives are condoms and Birth Control Pill, both relatively easy to obtain.\n" +
                "\n" +
                "Condoms:\n" +
                "Male Condoms, often called just Condoms, are slid on the penis before Sex inorder to prevent Sperm from entering the Vagina, and then thrown away after being used once. Latex condoms, the most common type, also help prevent STDs such as HIV.\n" +
                "\n" +
                "   Condoms should also be used when sleeping with a guy or giving oral sex!\n" +
                "\n" +
                "Are there other condoms beyond latex?\n" +
                "   Yes, there are. There are “Natural” or “Lambskin” which protect against pregnancy, but not STDs.\n" +
                "\n" +
                "Now, let’s move on to the Birth Control Pill.\n" +
                "Ladies, the Birth control pill is a pill taken once a day at the same time in order to prevent pregnancy (does not protect from STDs). Inorder to get it you go to a gynecologist, a woman's doctor, and together you will pick out the best pill for you.\n" +
                "\n" +
                "Does the pill have side effects?\n" +
                "   Yes, the pill does have side effects, though each type of pill has different effects. Some effects can be weight gain, mood swings, change in periods etc. The best way to know is to ask your doctor when you get the pill. And don't be scared to ask, they want to answer these questions.\n" +
                "\n" +
                "What is best? Birth Control Pill or Condoms?\n" +
                "   Both! The best way to keep you truly protected during sex is to use both a condom and to be on the pill. That way you are covered from an unwanted pregnancy and from STDs. Afterall, no form of contraception is perfect, so use as many as you can. \n",
                null);


        Article a4=new Article("consent",
                "[Categories: Sex 101]\n" +
                "Consent; an extremely vital component in any relationship between siblings, parents, friends, coworkers, and partners. Consent is often ignored. A lack of consent can make relationships uncomfortable. The absence of consent means the absence of respect, consideration, and clear communication. \n" +
                "\n" +
                "If you are not sure what consent looks like, it should include enthusiasm, should be freely given, and active (not assumed). If you feel like you are being pressured, unsafe, saying no, drunk, or high. It is NOT CONSENT. So don’t be afraid to say no if you are not ready and if you feel unsafe or threatened to reach out. Many people go through the same thing but are afraid to speak up.\n" +
                "\n" +
                "If you are ready, make sure that your partner is ready as well. Try using phrases such as:\n" +
                "Are you comfortable?\n" +
                "Is there anything you don’t want to do?\n" +
                "Do you want to stop?\n" +
                "Do you want to go further?\n" +
                "And remember, not saying yes, clearly means no. DON’T ASSUME, or else it becomes sexual assault.\n" +
                "\n" +
                "If you felt you were ready but changed your mind at any point later, make that clear as well. It’s okay to change your mind, you do not control how you feel.",
                null);
        Article a5=new Article("STD vs. STI",
                "Obviously these letters sound scary, but in reality, they are just a natural part of life, like contracting the flu or getting an infection. \n" +
                        "When you have Sex, there is always the possibility of getting an infection, but there are way to prevent and deal with it. That's what we will talk about in this article.\n" +
                        "\n" +
                        "So… what does STI mean? I’ve heard about STD, what does that Stand for?\n" +
                        "STI stands for sexually transmitted infection.\n" +
                        "STD stands for sexually transmitted disease\n" +
                        "\n" +
                        "What does that mean? How do you get them?\n" +
                        "Usually, but not always, STDs begin with STIs at first.\n" +
                        "A sexually transmitted Infection occurs when bacteria or a virus enters the body and begins multiplying. These bacterias can be passed through bodily fluids such as blood, semen and vaginal fluids among others.\n" +
                        "\n" +
                        "How can I keep myself safe from STIs?\n" +
                        "\n" +
                        "The best way is to use a latex condoms every time you have sex\n" +
                        "Wash and pee before and after intercourse\n" +
                        "Get You and your partner tested for STIs regularly. You can do this at the doctor's office or a sexual health clinic.\n" +
                        "Ask. It is perfectly okay to ask your partner about their past relationships, and to ask them to get tested before doing anything with them. The most important thing is that you take care of yourself.\n" +
                        "\n" +
                        "What are some of the most common STIs?\n" +
                        "HPV -  Nearly everyone gets this at some point in their life. When you are 11-12 you get vaccinated against this. It typically shows up as warts and bumps in the genitle area.\n" +
                        "Chlamydia - Also a common infection and very easily cured. Some symptoms may be abnormal discharge, burning sensation while urinating or bleeding from the rectum.\n" +
                        "Gonorrhea - Another common infection which can be treated well, though if untreated could lead to pelvic infection and up the risk of getting HIV. Some of the symptoms include burning sensation while urinating, swollen testicles or bleeding between periods.\n" +
                        "\n" +
                        "To read more about STDs, go to _____\n" +
                        "Citation: \n" +
                        "https://starkvilleurgentcareclinic.com/std-vs-sti-common-types-symptoms-and-treatment/#:~:text=STD%20stands%20for%20sexually%20transmitted,begin%20as%20sexually%20transmitted%20infections \n",
                null);

        Article a6=new Article("PMS",
                "https://youtu.be/WOi2Bwvp6hw\n" +
                "\n" +
                "Do you often feel irritable, angry, depressed,or maybe over sensitive? Do you find yourself crying often and alternating between sadness and rage a week or two before your menstrual period? This is called Premenstrual syndrome (PMS) and it affects a high percentage of women. It can cause wild, uncontrollable mood swings that randomly disappear and go back to a stable emotional state in the same day. \n" +
                "\n" +
                "These emotional disturbances are thought to be connected to the rise and fall of hormones (specifically estrogen) throughout the menstrual cycle. Estrogen levels rise immediately after a women’s cycle and then begin to drastically drop two weeks after. Estrogen has a big impact on the cognitive emotional side of the body: \n" +
                "\n" +
                "It increases serotonin(a hormone that stabilizes our mood, feeling of well being, and happiness) and the number of serotonin receptors in the brain.\n" +
                "It Modifies the production and the effects of endorphins (chemicals produced by the body to relieve stress and pain)\n" +
                "It protects nerves from damage and stimulates nerve growth\n" +
                "\n" +
                "PMS is very common but very difficult to deal with. You can find below ways in which to deal with the mood swings, irritability, anger and rage:\n" +
                "\n" +
                "Exercise\n" +
                "Eating small frequent meals during the day\n" +
                "Supplement your diet with Calcium\n" +
                "Avoid caffeine, alcohol, and sweets\n" +
                "Manage your stress through meditation, yoga, deep breathing etc..\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "sources:\n" +
                "shorturl.at/hwJNZ\n" +
                "shorturl.at/jnvE0\n" +
                "shorturl.at/gpDX2\n" +
                "shorturl.at/noAZ5\n" +
                "shorturl.at/hzMP7\n",null);

        articles=new Article[]{a1,a2,a3,a4,a5,a6};
        imagePlayPause=findViewById(R.id.imagePlayPause);
        extras = getIntent().getExtras();
        if (extras.getString("article_title").equals("Male Puberty")){
            final TextView tTextView = (TextView) findViewById(R.id.Article_title);
            tTextView.setText(articles[0].getTitle());
            final TextView cTextView = (TextView) findViewById(R.id.Article_content);
            cTextView.setText(articles[0].getText());
            imagePlayPause.setImageResource(R.mipmap.male_puberty_img_foreground);
        }
        if (extras.getString("article_title").equals("Female Puberty")){
            final TextView tTextView = (TextView) findViewById(R.id.Article_title);
            tTextView.setText(articles[1].getTitle());
            final TextView cTextView = (TextView) findViewById(R.id.Article_content);
            cTextView.setText(articles[1].getText());
            imagePlayPause.setImageResource(R.mipmap.female_puberty_img_foreground);
        }
        if (extras.getString("article_title").equals("Contraceptives")){
            final TextView tTextView = (TextView) findViewById(R.id.Article_title);
            tTextView.setText(articles[2].getTitle());
            final TextView cTextView = (TextView) findViewById(R.id.Article_content);
            cTextView.setText(articles[2].getText());
            imagePlayPause.setImageResource(R.mipmap.contraceptives_img_foreground);
        }
        if (extras.getString("article_title").equals("consent")){
            final TextView tTextView = (TextView) findViewById(R.id.Article_title);
            tTextView.setText(articles[3].getTitle());
            final TextView cTextView = (TextView) findViewById(R.id.Article_content);
            cTextView.setText(articles[3].getText());
        }
        if (extras.getString("article_title").equals("STD vs. STI")){
            final TextView tTextView = (TextView) findViewById(R.id.Article_title);
            tTextView.setText(articles[4].getTitle());
            final TextView cTextView = (TextView) findViewById(R.id.Article_content);
            cTextView.setText(articles[4].getText());

        }
        if (extras.getString("article_title").equals("PMS")){
            final TextView tTextView = (TextView) findViewById(R.id.Article_title);
            tTextView.setText(articles[5].getTitle());
            final TextView cTextView = (TextView) findViewById(R.id.Article_content);
            cTextView.setText(articles[5].getText());
        }


        //evaluation stars
        stav1=findViewById(R.id.star1);
        stav1.setOnClickListener(this);
        stav2=findViewById(R.id.star2);
        stav2.setOnClickListener(this);
        stav3=findViewById(R.id.star3);
        stav3.setOnClickListener(this);
        stav4=findViewById(R.id.star4);
        stav4.setOnClickListener(this);
        stav5=findViewById(R.id.star5);
        stav5.setOnClickListener(this);
        score=0;
        title="";

    }


    //

    @Override
    public void onClick(View view) {
        if(view==stav1)
        {
            stav1.setTextColor(Color.rgb(168,198,245) );
            score =1;
        }
        if(view==stav2)
        {
            stav1.setTextColor(Color.rgb(168,198,245) );
            stav2.setTextColor(Color.rgb(168,198,245));
            score =2;
        }
        if(view==stav3)
        {
            stav1.setTextColor(Color.rgb(168,198,245) );
            stav2.setTextColor(Color.rgb(168,198,245) );
            stav3.setTextColor(Color.rgb(168,198,245) );
            score=3;
        }
        if(view==stav4)
        {
            stav1.setTextColor(Color.rgb(168,198,245) );
            stav2.setTextColor(Color.rgb(168,198,245) );
            stav3.setTextColor(Color.rgb(168,198,245) );
            stav4.setTextColor(Color.rgb(168,198,245) );
            score=4;
        }
        if(view==stav5)
        {
            stav1.setTextColor(Color.rgb(168,198,245) );
            stav2.setTextColor(Color.rgb(168,198,245));
            stav3.setTextColor(Color.rgb(168,198,245));
            stav4.setTextColor(Color.rgb(168,198,245) );
            stav5.setTextColor(Color.rgb(168,198,245));
            score=5;
        }
        stav1.setEnabled(false);
        stav2.setEnabled(false);
        stav3.setEnabled(false);
        stav4.setEnabled(false);
        stav5.setEnabled(false);
        title=extras.getString("article_title");
        Rating rate=new Rating(title,score);
        root.push().setValue(rate);



    }
    //adds menu to page
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.bar, menu);
        return true;
    }


    //functionality for menu
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        //go to settings page
        if (id == R.id.settingsI){
            Intent intent = new Intent(this,LoggedInPro.class);
            startActivity(intent);
        }
        //go to proffetionals page
        else if(id== R.id.proI){
            Intent intent = new Intent(this,ProActivity.class);
            startActivity(intent);
        }
        //go to q&a
        else if(id == R.id.qnaI){
            Intent intent = new Intent(this,QandAActivity.class);
            startActivity(intent);
        }
        //go to about us page
        else if(id == R.id.aboutUsI){
            Intent intent = new Intent(this,aboutUs.class);
            startActivity(intent);
        }
        else if(id == R.id.homeI){
            Intent intent = new Intent(this,MainActivity.class);
            startActivity(intent);
        }
        return true;
    }

}