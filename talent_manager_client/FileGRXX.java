package com.example.talent_manager_client;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Paint;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import com.example.talent_manager_client.File_Listview.File;

//import com.example.talent_manager.databinding.FragmentFileDetailBinding;

public class FileGRXX extends AppCompatActivity{

    private ImageView imageView;
    private int position;

    private TextView title_textView;
    private TextView name_textView;
    private TextView date_textView;
    private TextView apartment_textView;
    private TextView content_textView;
    private TextView sex_textView;
    private Spinner spinner;

    //private MutableLiveData<String> name,date,apartment,content;


    private File file = new File();


    //FragmentFileDetailBinding binding;




    @RequiresApi(api = Build.VERSION_CODES.M)
    public void onCreate(Bundle savedInstanceState) {
        Log.e("TAfefdwfwefG", "hhhhhh");

        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN|
                WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);

        super.onCreate(savedInstanceState);


        setContentView(R.layout.fragment_file_grxx);
        Intent intent = getIntent();
        file = (File)intent.getSerializableExtra("data");
        //Log.e("dbwhjdbcwljcbhwlcbw",intent.getStringExtra("bdweh"));

        //Log.e("TAfefdwfwefG", "hhhhkjfvefwfwfwefhhh");

        title_textView = findViewById(R.id.file_text);
        title_textView.getPaint().setFlags(Paint. UNDERLINE_TEXT_FLAG ); //下划线
        title_textView.getPaint().setAntiAlias(true);//抗锯齿


        imageView = findViewById(R.id.eva_edit_image1);
        name_textView = findViewById(R.id.eva_edit_name);
        name_textView.setFocusable(false);name_textView.setFocusableInTouchMode(false);

        date_textView = findViewById(R.id.eva_edit_date);
        date_textView.setFocusable(false);date_textView.setFocusableInTouchMode(false);

        apartment_textView = findViewById(R.id.eva_edit_apartment);
        apartment_textView.setFocusable(false);apartment_textView.setFocusableInTouchMode(false);

        content_textView = findViewById(R.id.eva_edit_evaluate);
        content_textView.setFocusable(false);content_textView.setFocusableInTouchMode(false);


        sex_textView = findViewById(R.id.eva_edit_sex);
        sex_textView.setFocusable(false);sex_textView.setFocusableInTouchMode(false);

        spinner = findViewById(R.id.eva_edit_spinner2);
        spinner.setSelection(0);
        /*button = findViewById(R.id.eva_edit_button);
        button.setText("修  改");

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(button.getText().equals("修  改")){
                    button.setText("保  存");
                    content_textView.setFocusableInTouchMode(true);content_textView.setFocusable(true);content_textView.requestFocus();
                }
                else{
                    Toast.makeText(getApplicationContext(),"保存成功", Toast.LENGTH_SHORT).show();
                    file.setCevaluate(content_textView.getText().toString());
                    button.setText("修  改");
                    content_textView.setFocusable(false);content_textView.setFocusableInTouchMode(false);
                }
            }
        });*/


        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(position == 1){
                    Intent intent = new Intent();
                    intent = new Intent(FileGRXX.this, FileJix.class);

                    Log.e("feefff","bcuwcbuhcbwcuwcb");

                    Bundle bundleObject = new Bundle();
                    bundleObject.putSerializable("data", file);
                    intent.putExtra("position",position);

                    intent.putExtras(bundleObject);

                    startActivity(intent);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        //button = findViewById(R.id.eva_edit_change);

        /*name_textView.setFocusable(false);name_textView.setFocusableInTouchMode(false);
        date_textView.setFocusable(false);date_textView.setFocusableInTouchMode(false);
        apartment_textView.setFocusable(false);apartment_textView.setFocusableInTouchMode(false);
        content_textView.setFocusable(false);content_textView.setFocusableInTouchMode(false);
        radioButton1.setEnabled(false);
        radioButton2.setEnabled(false);*/

        position=intent.getIntExtra("position",0);

        //Log.e("TAfefdwfwefG", "hhhhkjfvefwfwfwefhhh");

        byte[] in = file.getBitmap();
        Bitmap bmp = BitmapFactory.decodeByteArray(in, 0, in.length );
        imageView.setImageBitmap(bmp);


        //name_textView.setMovementMethod(ScrollingMovementMethod.getInstance());
        name_textView.setText(file.getName());
        date_textView.setText(file.getDate());
        apartment_textView.setText(file.getApartment());
        sex_textView.setText(file.getSex());

        content_textView.setText(file.getCevaluate());
        /*file.setName(intent.getStringExtra("name"));
        file.setDate(intent.getStringExtra("date"));
        file.setApartment(intent.getStringExtra("apartment"));
        file.setContent(intent.getStringExtra("content"));
        file.setSex(intent.getStringExtra("sex"));*/

        //Log.e("TAfefdwfwefG", intent.getStringExtra("sex"));


        //button.getText()

        //Log.e("TAfefdwfwefG", "hhhhkjfvefwfwfwefhhh");
        /*
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(button.getText().equals("修改")){
                    button.setText("保存");
                    radioButton1.setEnabled(true);
                    radioButton2.setEnabled(true);
                    name_textView.setFocusableInTouchMode(true);name_textView.setFocusable(true);name_textView.requestFocus();
                    date_textView.setFocusableInTouchMode(true);date_textView.setFocusable(true);date_textView.requestFocus();
                    apartment_textView.setFocusableInTouchMode(true);apartment_textView.setFocusable(true);apartment_textView.requestFocus();
                    content_textView.setFocusableInTouchMode(true);content_textView.setFocusable(true);content_textView.requestFocus();
                }
                else{
                    Toast.makeText(getApplicationContext(),"保存成功", Toast.LENGTH_SHORT).show();
                    button.setText("修改");
                    radioButton1.setEnabled(false);
                    radioButton2.setEnabled(false);
                    name_textView.setFocusable(false);name_textView.setFocusableInTouchMode(false);
                    date_textView.setFocusable(false);date_textView.setFocusableInTouchMode(false);
                    apartment_textView.setFocusable(false);apartment_textView.setFocusableInTouchMode(false);
                    content_textView.setFocusable(false);content_textView.setFocusableInTouchMode(false);

                    if(radioButton1.isChecked()){
                        file.setSex("男");
                    }else{
                        file.setSex("女");
                    }



                }

            }
        });*/

        file.setName(name_textView.getText().toString());
        file.setEevaluate(content_textView.getText().toString());
        file.setDate(date_textView.getText().toString());
        file.setApartment(apartment_textView.getText().toString());


        //intent.putExtra("image", filter_lists.get(position).getBitmap());
        /*
        intent.putExtra("content", file.getContent());
        intent.putExtra("name", file.getName());
        intent.putExtra("sex", file.getSex());
        intent.putExtra("date", file.getDate());
        intent.putExtra("apartment", file.getApartment());*/
    }


    @Override
    public void onBackPressed() {
        Intent intent = new Intent();
        intent = new Intent(this, FileDetail.class);


        Bundle bundleObject = new Bundle();
        bundleObject.putSerializable("data", file);
        intent.putExtra("position",position);

        intent.putExtras(bundleObject);

        setResult(position,intent);
        finish();
    }
/*
    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if ((view.getId() == R.id.textView10 && canVerticalScroll(content_textView))) {

            view.getParent().requestDisallowInterceptTouchEvent(true);
            if (motionEvent.getAction() == MotionEvent.ACTION_UP) {
                view.getParent().requestDisallowInterceptTouchEvent(false);
            }
        }
        return false;
    }

    private boolean canVerticalScroll(EditText editText) {
        //滚动的距离
        int scrollY = editText.getScrollY();
        //控件内容的总高度
        int scrollRange = editText.getLayout().getHeight();
        //控件实际显示的高度
        int scrollExtent = editText.getHeight() - editText.getCompoundPaddingTop() -editText.getCompoundPaddingBottom();
        //控件内容总高度与实际显示高度的差值
        int scrollDifference = scrollRange - scrollExtent;

        if(scrollDifference == 0) {
            return false;
        }

        return (scrollY > 0) || (scrollY < scrollDifference - 1);
    }*/
}