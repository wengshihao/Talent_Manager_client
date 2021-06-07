package com.example.talent_manager_client;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;


public class ApplyFragment2 extends Fragment {

    TextView company, work, demand, phone;
    ImageView face;
    Button submit;

    public ApplyFragment2() {
        // Required empty public constructor
    }

    public static ApplyFragment2 newInstance(String param1, String param2) {
        ApplyFragment2 fragment = new ApplyFragment2();

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_apply2, container, false);
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        int num = getArguments().getInt("num");

        String _work[] = {"人事经理", "销售主管", "人事经理", "销售主管"};
        String _address[] = {"北京 海淀区 中关村", "北京 海淀区 清河", "北京 海淀区 中关村", "北京 海淀区 清河"};
        String _year[] = {"3年以上", "经验不限", "5年以上", "5年以上"};
        String _education[] = {"本科", "本科", "本科", "本科"};
        String _salary[] = {"25-35k", "35-40k", "30-35k", "20-30k"};
        String _company[] = {"今目标", "TX", "ALI", "BD"};
        String _demand[] = {
                "1.做好招聘与任用的具体事务性工作，包括发放招募启示、收集和汇总应聘资料;\n" +
                        "2.计算员工信息资料及各类人事资料;\n" +
                        "3.办理人事招聘、人才引进、内部调动、解聘、退休、接纳和转移保险、公积金缴纳的相关手续；",
                "1.公司提供的客户资源，联系目标客户;\n2.了解客户需求，向客户介绍公司业务，并与客户签订合同、收集资料，并做好跟踪服务;\n" +
                        "3.及时跟进项目的结算和收款工作",
                "1.做好招聘与任用的具体事务性工作，包括发放招募启示、收集和汇总应聘资料;\n" +
                        "2.计算员工信息资料及各类人事资料;\n" +
                        "3.办理人事招聘、人才引进、内部调动、解聘、退休、接纳和转移保险、公积金缴纳的相关手续；",
                "1.公司提供的客户资源，联系目标客户;\n2.了解客户需求，向客户介绍公司业务，并与客户签订合同、收集资料，并做好跟踪服务;\n" +
                        "3.及时跟进项目的结算和收款工作"

        };

        company = getActivity().findViewById(R.id.apply_company2);
        work = getActivity().findViewById(R.id.apply_work2);
        demand = getActivity().findViewById(R.id.apply_deman2);
        face = getActivity().findViewById(R.id.apply_face2);
        phone = getActivity().findViewById(R.id.apply_phone2);
        submit = getActivity().findViewById(R.id.apply_submit2);

        company.setText(_company[num]+"有限公司");
        work.setText(_work[num]+"(" + _salary[num]+")");
        demand.setText(_demand[num]);
        face.setBackgroundResource(getArguments().getInt("img"));

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavController navController = Navigation.findNavController(v);
                navController.navigate(R.id.action_applyFragment2_to_applyFragment);
                Toast toast = Toast.makeText(getContext(),"投递成功",Toast.LENGTH_LONG);
                toast.setText("投递成功");
                toast.show();
                return ;
            }
        });

//        phone.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//            }
//        });



    }
}