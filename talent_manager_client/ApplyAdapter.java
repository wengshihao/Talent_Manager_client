package com.example.talent_manager_client;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

public class ApplyAdapter extends RecyclerView.Adapter<ApplyAdapter.ApplyViewHolder> {



    @NonNull
    @Override
    public ApplyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater talentlayoutInflater = LayoutInflater.from(parent.getContext());
        View applyitemView = talentlayoutInflater.inflate(R.layout.apply_card,parent,false);

        return new ApplyViewHolder(applyitemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ApplyViewHolder holder, int position) {
        String work[] = {"人事经理", "销售主管", "人事经理", "销售主管"};
        String address[] = {"北京 海淀区 中关村", "北京 海淀区 清河", "北京 海淀区 中关村", "北京 海淀区 清河"};
        String year[] = {"3年以上", "经验不限", "5年以上", "5年以上"};
        String education[] = {"本科", "本科", "本科", "本科"};
        String salary[] = {"25-35k", "35-40k", "30-35k", "20-30k"};
        String company[] = {"今目标", "TX", "ALI", "BD"};

        holder.work.setText(work[position]);
        holder.address.setText(address[position]);
        holder.year.setText(year[position]);
        holder.education.setText(education[position]);
        holder.salary.setText(salary[position]);
        holder.company.setText(company[position]);

        holder.Src = "ic_talent_man" + String.valueOf(position+1);
        int Rid=holder.itemView.getResources().getIdentifier(holder.Src,"drawable","com.example.talent_manager_client");
        holder.face.setBackgroundResource(Rid);


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putInt("num",position);
                bundle.putInt("img",Rid);
                NavController navController = Navigation.findNavController(v);
                navController.navigate(R.id.action_applyFragment_to_applyFragment2,bundle);
            }
        });



    }

    @Override
    public int getItemCount() {
        return 4;
    }

    static class ApplyViewHolder extends RecyclerView.ViewHolder{
        TextView work, address, year, education, salary, company;
        ImageView face;
        String  Src;
        public ApplyViewHolder(@NonNull View itemView){
            super(itemView);
            work = itemView.findViewById(R.id.apply_work);
            address = itemView.findViewById(R.id.apply_address);
            year = itemView.findViewById(R.id.apply_year);
            education = itemView.findViewById(R.id.apply_education);
            salary = itemView.findViewById(R.id.apply_salary);
            company = itemView.findViewById(R.id.apply_company);
            face = itemView.findViewById(R.id.apply_face);

        }

    }


}

