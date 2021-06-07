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

public class FileJix extends AppCompatActivity {


    private int position;
    private File file;

    private ImageView imageView;

    private TextView title_textView;

    private TextView GZJX;
    private TextView JHWCL;
    private TextView SKWCL;
    private TextView XSFYL;
    private TextView XKHKZ;
    private TextView SCXXSJ;
    private TextView CQ;
    private TextView KG;
    private TextView QJ;
    private TextView CDZT;


    //private MutableLiveData<String> name,date,apartment,content;

    //private Button button;
    //private RadioButton radioButton1,radioButton2;
    //private File file = new File();
    private Spinner spinner;

    //FragmentFileDetailBinding binding;




    @RequiresApi(api = Build.VERSION_CODES.M)
    public void onCreate(Bundle savedInstanceState) {
        Log.e("TAfefdwfwefG", "hhhhhh");

        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN|
                WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);

        super.onCreate(savedInstanceState);


        setContentView(R.layout.fragment_file_jix);

        Intent intent = getIntent();
        file = (File)intent.getSerializableExtra("data");

        title_textView = findViewById(R.id.file_text);
        title_textView.getPaint().setFlags(Paint. UNDERLINE_TEXT_FLAG ); //下划线
        title_textView.getPaint().setAntiAlias(true);//抗锯齿

        GZJX = findViewById(R.id.eva_edit_name);
        JHWCL = findViewById(R.id.eva_edit_jhwcl);
        SKWCL = findViewById(R.id.eva_edit_date);
        XSFYL = findViewById(R.id.eva_edit_apartment);
        XKHKZ = findViewById(R.id.eva_edit_xkhkf);
        SCXXSJ = findViewById(R.id.eva_edit_scxxsj);
        CQ = findViewById(R.id.eva_edit_cq);
        KG = findViewById(R.id.eva_edit_kg);
        QJ = findViewById(R.id.eva_edit_qj);
        CDZT = findViewById(R.id.eva_edit_cdzt);
        imageView = findViewById(R.id.eva_edit_image1);

        GZJX.setText(file.getGZJX());
        JHWCL.setText(file.getJHWCL());
        SKWCL.setText(file.getSCXXSJ());
        XSFYL.setText(file.getXSFYL());
        XKHKZ.setText(file.getXKHKZ());
        SCXXSJ.setText(file.getSCXXSJ());
        CQ.setText(file.getCQ());
        KG.setText(file.getKG());
        QJ.setText(file.getQJ());
        CDZT.setText(file.getCDZT());

        byte[] in = file.getBitmap();
        Bitmap bmp = BitmapFactory.decodeByteArray(in, 0, in.length );
        imageView.setImageBitmap(bmp);





        spinner = findViewById(R.id.eva_edit_spinner2);
        spinner.setSelection(1);

        //Context context = spinner.getPopupContext();
        //spinner.get
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(position == 0){
                    Intent intent = new Intent();
                    intent = new Intent(FileJix.this, FileDetail.class );


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


    }

}