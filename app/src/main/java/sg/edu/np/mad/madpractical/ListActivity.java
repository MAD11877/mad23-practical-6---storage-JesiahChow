package sg.edu.np.mad.madpractical;

import static android.content.ContentValues.TAG;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;

public class ListActivity extends AppCompatActivity {
    AlertDialog.Builder builder;
    ArrayList<User> userList = new ArrayList<>();





    myDBHandler myDBHandler;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        myDBHandler = new myDBHandler(ListActivity.this);

        setContentView(R.layout.activity_list);
        recyclerView = findViewById(R.id.myRecycler);
        filluserList();

        recyclerView = findViewById(R.id.myRecycler);
        recyclerView.setHasFixedSize(true);
        //use linear layout manager
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        //specify and adapter
        mAdapter = new RecyclerViewAdapter(userList,ListActivity.this) {
        };
        recyclerView.setAdapter(mAdapter);


    }
    private void filluserList(){

        //20 new users
        User user1 = new User("125467832", "39201948501", 1, false);
        User user2 = new User("473853593", "2953075404", 2, false);
        User user3 = new User("338534937", "8998313873", 3, true);
        User user4 = new User("138380438", "8953650300", 4, false);
        User user5 = new User("986784037", "1055961042", 5, false);
        User user6 = new User("308289340", "9358481376", 6, true);
        User user7 = new User("634054395", "9547866875", 7, true);
        User user8 = new User("499430947", "6850349597", 8, false);
        User user9 = new User("949439549", "1896314317", 9, true);
        User user10 = new User("884830587", "6655482992", 10, false);
        User user11 = new User("539895831", "2515393013", 11, true);
        User user12 = new User("504859684", "9590874652", 12, true);
        User user13 = new User("576840327", "5813539839", 13, false);
        User user14 = new User("293502124", "9347571431", 14, true);
        User user15 = new User("675840391", "1653442875", 15, false);
        User user16 = new User("768594307", "8176457810", 16, false);
        User user17 = new User("153256743", "7767894218", 17, true);
        User user18 = new User("091245693", "5749797976", 18, false);
        User user19 = new User("890985437", "3035795620", 19, true);
        User user20 = new User("456324564", "5863965737", 20, true);
        //dd 20 user objects
        userList.add(user1);
        userList.add(user2);
        userList.add(user3);
        userList.add(user4);
        userList.add(user5);
        userList.add(user6);
        userList.add(user7);
        userList.add(user8);
        userList.add(user9);
        userList.add(user10);
        userList.add(user11);
        userList.add(user12);
        userList.add(user13);
        userList.add(user14);
        userList.add(user15);
        userList.add(user16);
        userList.add(user17);
        userList.add(user18);
        userList.add(user19);
        userList.add(user20);



    }
    /*private void displayData(){
        Cursor cursor = myDBHandler.readAllData();
        if(cursor.getCount() == 0){
            Toast.makeText(ListActivity.this,"No data",Toast.LENGTH_SHORT).show();
        }
        else{
            while(cursor.moveToNext()){
                userList.add(cursor.);
            }
        }
    }*/
    @Override
    protected void onStart(){
        super.onStart();
        Log.v(TAG, "on start!!");


    }
    @Override
    protected void onPause(){
        super.onPause();
        Log.v(TAG, "On Pause!!");
    }
    @Override
    protected void onDestroy(){
        super.onDestroy();
        Log.v(TAG, "Destroy!!");
    }
    @Override
    protected void onStop(){
        super.onStop();
        Log.v(TAG, "On Stop!!!");
    }

}
