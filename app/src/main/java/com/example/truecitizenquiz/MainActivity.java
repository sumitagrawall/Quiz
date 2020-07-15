package com.example.truecitizenquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button yesbutton;
    private Button nobutton;
    private ImageButton next;
    private TextView ques;
    private ImageButton previous;
    private int currentquestionindex=0;
    Questions[] questionbank=new Questions[]{
            new Questions(R.string.my_question,true),
            new Questions(R.string.animal,true),
            new Questions(R.string.coffee,true),
            new Questions(R.string.tea,false),
            new Questions(R.string.silk,true),
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        previous=findViewById(R.id.previous_button);
        yesbutton=findViewById(R.id.yes_button);
        nobutton=findViewById(R.id.no_button);
        ques=findViewById(R.id.answer_text_view);
        next=findViewById(R.id.next_button);
        yesbutton.setOnClickListener(this);
        nobutton.setOnClickListener(this);
        next.setOnClickListener(this);
        previous.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.yes_button:
                   checkanswer(true);
                break;
            case R.id.no_button:
                    checkanswer(false);
                break;
            case R.id.next_button:
                currentquestionindex=(currentquestionindex+1)%questionbank.length;
                ques.setText(questionbank[currentquestionindex].getAnswerresid());
                break;
            case R.id.previous_button:
                if(currentquestionindex==0)
                    currentquestionindex=questionbank.length-1;
                else
                currentquestionindex=(currentquestionindex-1)%questionbank.length;
                ques.setText(questionbank[currentquestionindex].getAnswerresid());

        }
    }
    public void checkanswer(boolean userchoice){
         boolean correctanswer=questionbank[currentquestionindex].isAnswertrue();
        if(userchoice==correctanswer)
            Toast.makeText(MainActivity.this ,"right answer" , Toast.LENGTH_SHORT).show();
        else
            Toast.makeText(MainActivity.this ,"wrong answer" , Toast.LENGTH_SHORT).show();
    }
//    public void yes(View v)
//    {
//        Toast.makeText(getApplicationContext(),"Right answer",Toast.LENGTH_SHORT).show();
//    }
//    public void no(View v)
//    {
//        Toast.makeText(getApplicationContext(),"wrong answer",Toast.LENGTH_SHORT).show();
//    }
}
