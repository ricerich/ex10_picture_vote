package com.example.ex10_picture_vote;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;

import org.w3c.dom.Text;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.result);
        setTitle("결과");

//        Intent intent1 = new Intent(A, B);
        Intent intent1 = getIntent();
        String imgName[] = intent1.getStringArrayExtra("ImageName");
        int voteCount[] = intent1.getIntArrayExtra("VoteCount");

        int tvIDarr[] = { R.id.tv1, R.id.tv2, R.id.tv3,
                          R.id.tv4, R.id.tv5, R.id.tv6,
                          R.id.tv7, R.id.tv8, R.id.tv9 };
        int rbarIDarr[] = { R.id.rbar1, R.id.rbar2, R.id.rbar3,
                            R.id.rbar4, R.id.rbar5, R.id.rbar6,
                            R.id.rbar7, R.id.rbar8, R.id.rbar9 };

        TextView tvArr[] = new TextView[9];
        for(int i=0; i<tvIDarr.length;++i)
            tvArr[i] = findViewById(tvIDarr[i]);

        RatingBar rbarArr[] = new RatingBar[9];
        for(int i=0; i<rbarArr.length;++i)
            rbarArr[i] = findViewById(rbarIDarr[i]);

        for(int i=0; i<tvIDarr.length;++i)
            tvArr[i].setText(imgName[i]);

        for(int i=0; i<rbarArr.length;++i)
            rbarArr[i].setRating((float)voteCount[i]);


        Button btn1 = findViewById(R.id.btnReturn);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });



    }
}