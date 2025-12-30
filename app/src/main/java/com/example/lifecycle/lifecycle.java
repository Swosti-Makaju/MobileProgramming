package com.example.lifecycle;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class lifecycle extends AppCompatActivity {

    private static final int REQUEST_CODE=1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_lifecycle);

        Button showFirstFragmentButton=findViewById(R.id.showFirstFragmentButton);
        Button showSecondFragmentButton=findViewById(R.id.showSecondFragmentButton);

        showFirstFragmentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                replacedFragment(new FirstFragment());
            }
        });
        showSecondFragmentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                replacedFragment(new SecondFragment());
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;


        });

//        Button btn_name=findViewById(R.id.LoginButton);
//        btn_name.setOnClickListener(new View.OnClickListener(){
//            @Override
//            public void onClick(View v){
//                Intent intent=new Intent(lifecycle.this,MainActivity.class);
//                intent.putExtra("message","Hello from first activity");
//             //   startActivity(intent);
//                startActivityForResult(intent,REQUEST_CODE);
//            }
//        });

       }

    private void replacedFragment(Fragment fragment){
        FragmentManager fragmentManager=getSupportFragmentManager();
        FragmentTransaction transaction=fragmentManager.beginTransaction();
        transaction.replace(R.id.fragment_container, fragment);
        transaction.commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.options_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item){
        int itemId=item.getItemId();
        if (itemId==R.id.action_profile){
            Toast.makeText(this,"Prfile Selected",Toast.LENGTH_SHORT).show();
            return true;
        } else if (itemId==R.id.action_setting) {
            Toast.makeText(this, "Setting Selected", Toast.LENGTH_SHORT).show();
            return true;
        }else if (itemId==R.id.action_help) {
            Toast.makeText(this, "Help Selected", Toast.LENGTH_SHORT).show();
            return true;
        }else if (itemId==R.id.exit) {
            showSimpleDialog();
            return true;
        }else if (itemId==R.id.list_item) {
            Intent intent=new Intent(lifecycle.this,ListViewActivity.class);
            startActivity(intent);
            Toast.makeText(this, "Item Selected", Toast.LENGTH_SHORT).show();
            return true;
        }else if (itemId==R.id.recyclerview) {
            Intent intent=new Intent(lifecycle.this,RecycleViewActivity.class);
            startActivity(intent);
            Toast.makeText(this, "Item Selected", Toast.LENGTH_SHORT).show();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void showSimpleDialog(){
        new AlertDialog.Builder(this)
                .setTitle("Exit Option Selected")
                .setMessage("You selected Exit. Continue?")
                .setPositiveButton("yes",(dialog, which) -> {
                    finishAffinity();
                })
                .setPositiveButton("Yes",(dialog, which) ->
                        Toast.makeText(this,"Confirmed",Toast.LENGTH_SHORT).show())
                .setNegativeButton("No",(dialog, which) -> dialog.dismiss())
                .create()
                .show();
    }



    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data){
        super.onActivityResult(requestCode,resultCode,data);
        if(requestCode==REQUEST_CODE && resultCode== Activity.RESULT_OK){
            if(data!= null && data.hasExtra("reply")){
                String reply=data.getStringExtra("reply");
                Toast.makeText(this,"Reply from mainactivity."+ reply,Toast.LENGTH_LONG).show();
            }
        }
    }

    @Override
    protected void onStart(){
        super.onStart();
        Log.d("Lifecycle Text","Activity Started");
        Toast.makeText(this,"onStart",Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onResume(){
        super.onResume();
        Log.d("Lifecycle Text","Activity Resumed");
        Toast.makeText(this,"onResume",Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onRestart(){
        super.onRestart();
        Log.d("Lifecycle Text","Activity Restarted");
        Toast.makeText(this,"onRestart",Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onPause(){
        super.onPause();
        Log.d("Lifecycle Text","Activity Paused");
        Toast.makeText(this,"onPause",Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onStop(){
        super.onStop();
        Log.d("Lifecycle Text","Activity Stopped");
        Toast.makeText(this,"onStop",Toast.LENGTH_SHORT).show();
    }


}
