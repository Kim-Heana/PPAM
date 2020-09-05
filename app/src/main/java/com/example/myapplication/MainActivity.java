package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_dashboard);
        // main_activity로 해놔서 null 오류난거 (내가 원하는 버튼은 main에 있던게 아니라서)

        Button b1 = (Button) findViewById(R.id.Clickbtn);
        // findViewById(R.id.btn); 메서드는 앞서 setContentView에 지정한
        // activity_main.xml 파일을 보고 구성된 화면에서
        // R.id.btn (리소스 ID가 btn) 인 View 객체를 가져오라는 뜻

        b1.setOnClickListener(new View.OnClickListener() {
            // setOnClickListener : b1 버튼에 OnClickListener을 적용시켜 클릭에 반응할 수 있도록 함

            @Override
            public void onClick(View v) {
                // 버튼 눌렀을 때 일어나는 이벤트

                Toast.makeText(getApplicationContext(), "이동합니다", Toast.LENGTH_SHORT).show();
                // Toast : 팝업 창 조그맣게 뜨는 눌렀을 때 뜨는 창 -> show() 꼭 사용

                Intent intent = new Intent(MainActivity.this, SubActivity.class);
                // 위 코드 : 앞에 있는 매개변수에서 뒤에 있는 매개변수로 이동하라는 뜻
                // this 쓴 이유는 현재 있는 위치에서 서브 액티비티로 이동할 것이기 때문(class로 써도 무방)
                startActivity(intent);  // 이거 써야 intent 기능 정상 작동
                // intent : 버튼 눌렀을 때 이동시켜주는 기능
            }
        });

        BottomNavigationView navView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications)
                .build();

        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(navView, navController);


    }
}