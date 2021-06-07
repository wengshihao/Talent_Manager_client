package com.example.talent_manager_client;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ResumeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ResumeFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public ResumeFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ResumeFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ResumeFragment newInstance(String param1, String param2) {
        ResumeFragment fragment = new ResumeFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    ChatViewModel chatViewModel;
    RecyclerView recyclerView;
    chat_adapter chatAdapter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_resume, container, false);

    }
    private ChatDao chatDao;
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        ChatDatabase chatDatabase= ChatDatabase.getDatabase(getContext());
        chatViewModel= ViewModelProviders.of(this).get(ChatViewModel.class);
        chatDao=chatDatabase.getChatDao();
        //chatViewModel.deleteAllChats();
        //插入数据
        if(chatDao.getchatcounts()==0) {
            Chat chat1 = new Chat("姓名：王先生", "性别：男", "年龄：29", "求职类型：人力资源类"
                    , "#3", "籍贯：江苏省苏州市吴江区",
                    "薪资要求：9000",
                    "项目时间：2015-05 - 2015-08\n" +
                            "\n" +
                            "项目名称：KPI绩效考核设计项目\n" +
                            "\n" +
                            "项目描述：\n" +
                            "项目介绍\n" +
                            "1、设计原则：复杂问题简单化，侧重关键指标，最大化避免中间程序繁杂引发的执行不到位，流程流于形式的问题。\n" +
                            "2、首先做人力成本核算：与财务部、董事长对公司成本总额、人力成本占比进行讨论，得出可以给予绩效考核开支的数据。\n" +
                            "3、绩效考核依据参考：查看了国企、外企、部分私企绩效考核的学术论文，对比了BSC平衡积分卡、MBO、EVA、360度考评、行为锚定法、EMBK、KPI等绩效考核工具的实施现状，确定以\"技能为导向，品德须兼备“的KPI绩效考核理念。\n" +
                            "4、确定关键指标：协同各部门主管自上而下地确定关键考核内容，找出最核心的指标作为占比最大值。其余不能量化或难以量化的考核指标以剩余百分比的70%为基础得分；若有加分/值得鼓励的考评项目，则以确定的增加值往上提高，最多不超过30%。\n" +
                            "5、与外部技术服务公司协作，搭建OA KPI绩效考核流程，将考评所有评分信息技术化、简便化。\n" +
                            "6、听意见：协同各部门主管自下而上的开会形式，听取员工对考核指标实质化的意见。将部分绩效考核的岗位调整其绩效考核方向，减少过多数量的关键指标带来的繁杂，重点在不能量化或难以量化的部分进行重点讨论。\n" +
                            "7、全公司开会，公告执行落实。");
            Chat chat2 = new Chat("姓名：王先生", "性别：男", "年龄：29", "求职类型：高层管理", "#2",
                    "籍贯：江苏省苏州市吴江区", "薪资要求：8000",
                    "项目名称：人效人力成本项目\n" +
                            "\n" +
                            "项目描述：\n" +
                            "项目介绍\n" +
                            "①项目目的：提高子公司人效、降低子公司人力成本；\n" +
                            "②项目内容：根据财务数据制作人效人力成本报表，对于超出标准公司打开具体分析；\n" +
                            "③项目时间：2016年至今；\n" +
                            "④项目情况：持续进行中；\n" +
                            "⑤具体实施：2016年主要负责人效人力成本报表制作，2017年负责子公司HRBP开始，就将人效人力成本数据具体打开分析，也同时制作人效人力成本分析的文件，及子公司人力自查工作的维度文件，同时编制实时监控，并季度确定预编；");
            Chat chat3 = new Chat("姓名：王先生", "性别：男", "年龄：29", "求职类型：技术支持", "#1",
                    "籍贯：江苏省苏州市吴江区", "薪资要求：7000",
                    "项目时间：2015-06 - 2015-07\n" +
                            "\n" +
                            "项目名称：比亚迪戴姆勒（腾势汽车）7.4广州专场招聘会\n" +
                            "\n" +
                            "项目描述：\n" +
                            "项目介绍\n" +
                            "深圳比亚迪戴姆勒新技术有限公司（腾势汽车）是由中国新能源汽车领军企业比亚迪与世界豪华车和商用车制造巨头德国戴姆勒共同设立的合资企业，于2010年正式成立，总部设在深圳。DENZA是深圳比亚迪戴姆勒新技术有限公司所拥有的品牌，是比亚迪与戴姆勒合资双方共同打造的中国首个专注于新能源汽车的品牌。\n" +
                            "2015.7.4广州腾势专场招聘会涉及职位17个，从基础营销岗位到高端技术岗位均有涉及。在一个月的时间内，完成沟通候选人217人，有效沟通135人，招聘会到场67人，最终入职19人。\n" +
                            "我的职责\n" +
                            "主要负责项目前期可行性调研，中期候选人沟通，面试邀约通知，以及招聘会现场远程支持工作。");
            chatViewModel.insertChats(chat1, chat2,chat3);
        }

        recyclerView=getActivity().findViewById(R.id.resume_rcv);
        chatAdapter=new chat_adapter(getContext());
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(chatAdapter);

        chatViewModel.getAllchatsLive().observe(getViewLifecycleOwner(), new Observer<List<Chat>>() {
            @Override
            public void onChanged(List<Chat> chats) {
                chatAdapter.setAllChats(chats);
                chatAdapter.notifyDataSetChanged();
            }
        });
    }
}