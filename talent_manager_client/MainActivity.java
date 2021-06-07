package com.example.talent_manager_client;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.motion.widget.MotionLayout;
import androidx.navigation.NavController;
import androidx.navigation.NavDestination;
import androidx.navigation.Navigation;

import android.os.Bundle;
import android.view.View;
import com.githang.statusbar.StatusBarCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        StatusBarCompat.setStatusBarColor(this, getResources().getColor(R.color.barcolor), true);
        NavController navController= Navigation.findNavController(this,R.id.fragment);
        MotionLayout m1=findViewById(R.id.m1MotionLayout);
        MotionLayout m2=findViewById(R.id.m2MotionLayout);
        MotionLayout m3=findViewById(R.id.m3MotionLayout);
        MotionLayout m4=findViewById(R.id.m4MotionLayout);



        m1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navController.navigate(R.id.resumeFragment);
            }
        });

        m2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navController.navigate(R.id.fileFragment);
            }
        });

        m3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navController.navigate(R.id.applyFragment);
            }
        });

        m4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navController.navigate(R.id.meFragment);
            }
        });



        navController.addOnDestinationChangedListener(new NavController.OnDestinationChangedListener() {
            @Override
            public void onDestinationChanged(@NonNull NavController controller, @NonNull NavDestination destination, @Nullable Bundle arguments) {
                m1.setProgress(0);
                m2.setProgress(0);
                m3.setProgress(0);
                m4.setProgress(0);
                if (destination.getId()==R.id.resumeFragment)
                {
                    m1.transitionToEnd();
                }
                if (destination.getId()==R.id.fileFragment)
                {
                    m2.transitionToEnd();
                }
                if (destination.getId()==R.id.applyFragment)
                {
                    m3.transitionToEnd();
                }
                if (destination.getId()==R.id.meFragment)
                {
                    m4.transitionToEnd();
                }

            }
        });
    }
}