package com.example.talent_manager_client;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.talent_manager_client.File_Listview.File;
import com.example.talent_manager_client.File_Listview.FilterListener;
import com.example.talent_manager_client.File_Listview.MyListAdapter;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FileFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FileFragment extends Fragment {


    private ListView mLv;
    private LiveData<List<File>> list = null;
    //private SearchDao searchDao = null;
    //private SearchDatabase searchDatabase ;
    boolean isFilter;
    private MyListAdapter adapter = null;
    private TextView textView;

    private FileViewModel fileViewModel = null;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public FileFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment fileFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static FileFragment newInstance(String param1, String param2) {
        FileFragment fragment = new FileFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
/*
        Typeface mTypeface = Typeface.createFromFile("fonts/锐字工房金刚粗黑简1.0.TTF");

        try {
            //Field field = Typeface.class.
            Field field = Typeface.class.getDeclaredField("MONOSPACE");
            field.setAccessible(true);
            field.set(null, mTypeface);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }*/

        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_file, container, false);

        //getActivity().deleteDatabase("file_database");
        fileViewModel = new ViewModelProvider(this).get(FileViewModel.class);
        View view =  inflater.inflate(R.layout.fragment_file, container, false);

        setViews();
        mLv = view.findViewById(R.id.file_listview);// ListView控件

        textView = view.findViewById(R.id.file_text);
        textView.getPaint().setFlags(Paint. UNDERLINE_TEXT_FLAG ); //下划线
        textView.getPaint().setAntiAlias(true);//抗锯齿

        setData();// 给listView设置adapter

        //setListeners();// 设置监听

        super.onCreate(savedInstanceState);
        return view;
    }

    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
//        mViewModel = new ViewModelProvider(this).get(SearchViewModel.class);


        // TODO: Use the ViewModel
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(data==null){
            //Log.e("TAfefcwcwcwcwcdwfwefG", String.valueOf(requestCode));
            return ;
        }



        switch (requestCode) {
            case 1:
                File file = (File) data.getSerializableExtra("data");


                //fileViewModel.getValue().set(resultCode , file);
                //fileViewModel.updateFiles(file);

                //adapter.change(data.getIntExtra("position",0),file);
                adapter.notifyDataSetChanged();
                break;
        }

    }

    private void setData() {

        initData(getActivity());

        fileViewModel.getCount().observe(getActivity(), new Observer<Integer>() {
            @Override
            public void onChanged(Integer integer) {
                if(integer == 0){
                    initData(getActivity());
                }
            }
        });


        fileViewModel.getAllFileLive().observe(getActivity(), new Observer<List<File>>() {

            public void onChanged(List<File> files) {
                setItemClick(files);
                Log.e("TAfffffffffffffffG", String.valueOf(files.size()));
                //MyListAdapter adapter = null;
                adapter = new MyListAdapter(files, getActivity(), new FilterListener() {
                    // 回调方法获取过滤后的数据
                    public void getFilterData(List<File> list) {
                        // 这里可以拿到过滤后数据，所以在这里可以对搜索后的数据进行操作
                        Log.e("TAG", "接口回调成功");

                        //setItemClick(list);
                    }
                });
                mLv.setAdapter(adapter);
            }
        });

    }

    /**
     * 给listView添加item的单击事件
     * @param filter_lists  过滤后的数据集
     */

    //SearchDetail  dfragment = new SearchDetail();
    protected void setItemClick(List<File> filter_lists) {
        Log.e("TAG", String.valueOf(filter_lists.size()));
        mLv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                // 点击对应的item时，弹出toast提示所点击的内容
                Log.e("TAG", String.valueOf(position));
                Log.e("TAG", String.valueOf(filter_lists.size()));
                //NavController controller = Navigation.findNavController(view);
                //controller.navigate(R.id.action_masterFragment_to_detailFragment);
                //Intent intent=new Intent(SearchFragment.this,);
                //startActivityForResult(intent,0);
                Intent intent = new Intent();
                intent = new Intent(getActivity(), FileDetail.class);


                Bundle bundleObject = new Bundle();
                bundleObject.putSerializable("data", filter_lists.get(position));
                intent.putExtra("position",position);

                intent.putExtras(bundleObject);
                //intent.putExtras("data",filter_lists.get(position));
                //intent.put

                //intent.put
                /*
                Log.e("StringArray", filter_lists.get(position).getSex());
                intent.putExtra("image", filter_lists.get(position).getBitmap());
                intent.putExtra("content", filter_lists.get(position).getContent());
                intent.putExtra("name", filter_lists.get(position).getName());
                intent.putExtra("sex", filter_lists.get(position).getSex());
                intent.putExtra("date", filter_lists.get(position).getDate());
                intent.putExtra("apartment", filter_lists.get(position).getApartment());
                */


                //Log.e("TAG", filter_lists.get(position).getContent());
                startActivityForResult(intent,1);


                //Toast.makeText(getActivity(), "hddh", Toast.LENGTH_LONG).show();
            }
        });
    }

    /**
     * 简单的list集合添加一些测试数据
     */

    public Bitmap getBitmapFromVectorDrawable(Context context, int drawableId) {
        Drawable drawable = ContextCompat.getDrawable(context, drawableId);
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP) {
            drawable = (DrawableCompat.wrap(drawable)).mutate();
        }

        Bitmap bitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(),
                Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
        drawable.draw(canvas);

        return bitmap;
    }

    private void initData(Context context) {

        //searchDao.DeleteAll();
        //new SearchViewModel.DeleteAllAsyncTask(searchDao).execute();
        fileViewModel.deleteAllWorksFiles();


        InputStreamReader inputReader = null;
        List<String> Filename = new ArrayList<String>();


        Filename.add("01.txt");
        Filename.add("02.txt");
        Filename.add("03.txt");/*
        Filename.add("04.txt");
        Filename.add("05.txt");
        Filename.add("06.txt");
        Filename.add("07.txt");
        Filename.add("08.txt");
        Filename.add("09.txt");
        Filename.add("10.txt");*/

        for(int i = 0; i < Filename.size(); i++){


            try {
                Bitmap bmp = null;

                Log.e("333", String.valueOf(i));

                switch (i%3){
                    case 0:
                        bmp = getBitmapFromVectorDrawable(context , R.drawable.ic__avatar1);
                        break;
                    case 1:
                        bmp = getBitmapFromVectorDrawable(context , R.drawable.ic__avatar2);
                        break;
                    case 2:
                        bmp = getBitmapFromVectorDrawable(context , R.drawable.ic__avatar3);
                        break;
                }

                //Log.e("2", "hhhhhsdcjhwcwjhcbwjcgwjhcbajcbhjcbhcbhchjdcbjdcbjdcbdjcbdjcbdsbcd");

                ByteArrayOutputStream baos = new ByteArrayOutputStream();

                bmp.compress(Bitmap.CompressFormat.PNG, 100, baos);


                File file = new File();
                inputReader = new InputStreamReader(context.getResources().getAssets().open(Filename.get(i)));
                BufferedReader bufReader = new BufferedReader(inputReader);
                StringBuilder result = new StringBuilder();
                String line;


                //Log.e("1", "hhhhhsdcjhwcwjhcbwjcgwjhcbajcbhjcbhcbhchjdcbjdcbjdcbdjcbdjcbdsbcd");

                file.setBitmap(baos.toByteArray());

                file.setName(bufReader.readLine());
                file.setSex(bufReader.readLine());
                file.setDate(bufReader.readLine());
                file.setApartment(bufReader.readLine());
                file.setAge(bufReader.readLine());
                file.setEthnic(bufReader.readLine());
                file.setPstatus(bufReader.readLine());
                file.setDiscipline(bufReader.readLine());
                file.setJob(bufReader.readLine());

                Log.e("tttt",file.getAge());

                file.setGZJX(bufReader.readLine());
                file.setJHWCL(bufReader.readLine());
                file.setSKWCL(bufReader.readLine());
                file.setXSFYL(bufReader.readLine());
                file.setXKHKZ(bufReader.readLine());
                file.setSCXXSJ(bufReader.readLine());
                file.setCQ(bufReader.readLine());
                file.setKG(bufReader.readLine());
                file.setQJ(bufReader.readLine());
                file.setCDZT(bufReader.readLine());
                /*
                file.setGZJX(bufReader.readLine());
                file.setJHWCL(bufReader.readLine());
                file.setSKWCL(bufReader.readLine());
                file.setXSFYL(bufReader.readLine());
                file.setXKHKZ(bufReader.readLine());
                file.setSCXXSJ(bufReader.readLine());
                file.setCQ(bufReader.readLine());
                file.setKG(bufReader.readLine());
                file.setQJ(bufReader.readLine());
                file.setCDZT(bufReader.readLine());


                Log.e("TAG", file.getCDZT());*/

                while((line = bufReader.readLine()) != null) {
                    result.append(line);
                }
                String var6 = result.toString();
                file.setCevaluate(var6);



                fileViewModel.insertFiles(file);


            } catch (Exception var16) {
                var16.printStackTrace();
            } finally {
                if(null != inputReader) {
                    try {
                        inputReader.close();
                    } catch (IOException var15) {
                        var15.printStackTrace();
                    }
                }
            }
        }

    }



    /*
        private void initData() {

            list[0].add("看着飞舞的尘埃   掉下来");
            list[1].add("没人发现它存在");
            list[2].add("多自由自在");
            list[0].add("可世界都爱热热闹闹");
            list[1].add("容不下   我百无聊赖");
            list[2].add("不应该   一个人 发呆");
            list[0].add("只有我   守着安静的沙漠");
            list[1].add("等待着花开");
            list[2].add("只有我   看着别人的快乐");
        }
    */


    /**
     * 控件初始化
     */
    private void setViews() {
//        View view =  View.inflater.inflate(R.layout.search_fragment, container, false);
//        mEt = view.findViewById(R.id.search_editText);// EditText控件
//        mLv = view.findViewById(R.id.search_listview);// ListView控件
    }
}