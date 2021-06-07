package com.example.talent_manager_client;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Paint;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import com.example.talent_manager_client.File_Listview.File;

//import com.example.talent_manager.databinding.FragmentEvaluateDetailBinding;

public class FileDetail extends AppCompatActivity{

    private ImageView imageView;
    private int position;

    private TextView title_textView;
    private TextView name_textView;
    private TextView sex_textView;
    private TextView age_textView;

    private TextView ethnic_textView;
    private TextView pnation_textView;
    private TextView date_textView;
    private TextView job_textView;
    private TextView cevaluate_textView;

    private Button button;


    //private MutableLiveData<String> name,date,apartment,content;


    private File file = new File();


    //FragmentEvaluateDetailBinding binding;




    @RequiresApi(api = Build.VERSION_CODES.M)
    public void onCreate(Bundle savedInstanceState) {

        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN|
                WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);

        super.onCreate(savedInstanceState);


        setContentView(R.layout.fragment_file_detail);
        Intent intent = getIntent();
        file = (File)intent.getSerializableExtra("data");
        //Log.e("dbwhjdbcwljcbhwlcbw",intent.getStringExtra("bdweh"));

        //Log.e("TAfefdwfwefG", "hhhhkjfvefwfwfwefhhh");

        title_textView = findViewById(R.id.file_text);
        title_textView.getPaint().setFlags(Paint. UNDERLINE_TEXT_FLAG ); //下划线
        title_textView.getPaint().setAntiAlias(true);//抗锯齿


        imageView = findViewById(R.id.eva_edit_image1);
        name_textView = findViewById(R.id.file_job);
        sex_textView = findViewById(R.id.file_date);
        age_textView = findViewById(R.id.detail_file_age);
        ethnic_textView = findViewById(R.id.detail_file_ethnic);
        pnation_textView = findViewById(R.id.detail_file_pnation);
        date_textView = findViewById(R.id.detail_file_date);
        job_textView = findViewById(R.id.detail_file_job);
        cevaluate_textView = findViewById(R.id.edit_file_cevaluate);

        button = findViewById(R.id.eva_file_appeal);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent = new Intent(FileDetail.this, FileGRXX.class);


                Bundle bundleObject = new Bundle();
                bundleObject.putSerializable("data", file);
                intent.putExtra("position",position);

                intent.putExtras(bundleObject);

                startActivity(intent);
            }
        });




        position=intent.getIntExtra("position",0);

        //Log.e("TAfefdwfwefG", "hhhhkjfvefwfwfwefhhh");

        byte[] in = file.getBitmap();
        Bitmap bmp = BitmapFactory.decodeByteArray(in, 0, in.length );
        imageView.setImageBitmap(bmp);


        name_textView.setText(file.getName());
        sex_textView.setText(file.getSex());
        age_textView.setText(file.getAge());
        ethnic_textView.setText(file.getEthnic());
        pnation_textView.setText(file.getPstatus());
        date_textView.setText(file.getDate());
        job_textView.setText(file.getJob());
        cevaluate_textView.setText(file.getCevaluate());

    }


    @Override
    public void onBackPressed() {
        finish();
    }

}
