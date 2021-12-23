package com.example.ex10_picture_vote;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
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

        Integer imageFileId[] = { R.drawable.pic1, R.drawable.pic2, R.drawable.pic3,
                                  R.drawable.pic4, R.drawable.pic5, R.drawable.pic6,
                                  R.drawable.pic7, R.drawable.pic8, R.drawable.pic9 };

        //최대 득표수를 구한다
        //배열안에 있는 최대값을 구한다.
        //max 변수를 하나 만들고, max변수를 배열의 각 원소의 값과 비교해 가면서, 업데이트시킨다.

        int max=0;//최대값은 처음에는 0, 갱신될꺼임!
        int maxIndex=0;

        for(int i=0; i<voteCount.length;++i)
        {
            if(voteCount[i] > max)//배열의 한 원소의 값이 현재 최대값보다 크다면
            {
                max = voteCount[i];//최대값을 갱신한다. 배열의 원소의 값으로
                maxIndex = i;
            }
        }

        TextView tvMax = findViewById(R.id.tvMax);
        ImageView ivMax = findViewById(R.id.ivMax);

        tvMax.setText(imgName[maxIndex]);
        ivMax.setImageResource(imageFileId[maxIndex]);




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