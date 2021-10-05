package com.example.myapplication;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.myapplication.ui.home.DanhSachSach.DanhSachSach;
import com.example.myapplication.ui.home.DanhSachSach.Sach;
import com.example.myapplication.ui.home.DanhSachSach.SachAdapter;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Sach sach;
    ArrayList<Sach> sachArrayList;
    DanhSachSach danhSachSach;
    SachAdapter sachAdapter;
    private AppBarConfiguration mAppBarConfiguration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_gallery, R.id.nav_home)
                .setDrawerLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main, menu);
        // Inflate the menu; this adds items to the action bar if it is present.
        return true;
    }


    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }

//    @Override
//    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
//        sach = new Sach();
//        danhSachSach = new DanhSachSach();
//        ArrayList<Sach> arrayList = danhSachSach.getList();
//        switch (item.getItemId()){
//            case R.id.theLoai:
//                for(sach i : arrayList )
//                Toast.makeText(this, "Thể loại", Toast.LENGTH_SHORT).show();
//                break;
//            case R.id.hanhDong:
//                Toast.makeText(this, "Hành động", Toast.LENGTH_SHORT).show();
//        }
//        return super.onOptionsItemSelected(item);
//    }

//    public void FragmentDanhSachTruyen(View view){
//        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
//        fragmentTransaction.add(R.id.fragmentDanhSachTruyen, new Fragment(),"fragmentDanhSachTruyen");
//        fragmentTransaction.addToBackStack("fragmentDanhSachTruyen");
//        fragmentTransaction.commit();
//    }
//    public void ChiTietThongTinTruyen(View view){
//        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
//        fragmentTransaction.add(R.id.ChiTietThongTinTruyen, new Fragment(),"ChiTietThongTinTruyen");
//        fragmentTransaction.addToBackStack("ChiTietThongTinTruyen");
//        fragmentTransaction.commit();
//    }
//    public void DocTruyen(View view){
//        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
//        fragmentTransaction.add(R.id.fragmentDanhSachTruyen, new Fragment(),"DocTruyen");
//        fragmentTransaction.addToBackStack("DocTruyen");
//        fragmentTransaction.commit();
//    }
//    public void back(View view){
//        getFragmentManager().popBackStack();
//    }
}