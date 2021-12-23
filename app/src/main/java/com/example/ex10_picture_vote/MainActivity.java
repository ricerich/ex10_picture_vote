package com.example.ex10_picture_vote;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        ImageView iv1= findViewById(R.id.iv1);
//        ImageView iv2= findViewById(R.id.iv2);
//        ImageView iv3= findViewById(R.id.iv3);
//        ImageView iv4= findViewById(R.id.iv4);
//        ImageView iv5= findViewById(R.id.iv5);

        final String imgName[] = { "독서하는 소녀", "꽃장식 모자 소녀", "부채를 든 소녀",
                                   "이레느깡 단 베르양", "잠자는 소녀", "테라스의 두 자매",
                                   "피아노 레슨", "피아노 앞의 소녀들","해변에서" };

        ImageView ivArr[] = new ImageView[9];//1.이미지뷰 객체 "배열" 생성

//        ivArr[0] = findViewById(R.id.iv1);
//        ivArr[1] = findViewById(R.id.iv2);

        int idArr[] = {R.id.iv1, R.id.iv2, R.id.iv3, R.id.iv4, R.id.iv5, R.id.iv6, R.id.iv7, R.id.iv8, R.id.iv9};
        for(int i=0; i< ivArr.length;++i)//2.바인딩
            ivArr[i] = findViewById(idArr[i]);


        //득표수를 저장할 배열을 만든다. 9개짜리
        int voteCount[] = new int[9];
        for(int i=0; i<voteCount.length;++i)
            voteCount[i]=0;


        //3.이벤트처리
        for(int i=0;i<ivArr.length;++i)
        {
            final int finalI = i;
            ivArr[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    voteCount[finalI]++;
                    Toast.makeText(getApplicationContext(),
                            imgName[finalI] +" 총 " + voteCount[finalI] + " 표",
                            Toast.LENGTH_SHORT).show();
                }
            });
        }

        Button btn1 = findViewById(R.id.btnResult);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(getApplicationContext(), ResultActivity.class);

                //1.그림 이름과 2.득표수를 넘긴다. extra에 담아서
                intent1.putExtra("ImageName", imgName);
                intent1.putExtra("VoteCount", voteCount);

                startActivity(intent1);

            }
        });

    }
}


















