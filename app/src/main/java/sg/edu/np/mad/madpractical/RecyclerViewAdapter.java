package sg.edu.np.mad.madpractical;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.jar.Attributes;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {
    ArrayList<User> userList;
    Context context;

    public RecyclerViewAdapter(ArrayList<User> userList, Context context) {
        this.userList = userList;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_view,parent,false);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.name.setText("Name" + userList.get(position).getName());
        holder.desc.setText("Description" + userList.get(position).getDescription());
        holder.layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, MainActivity.class);
                intent.putExtra("name", userList.get(position).getName());
                intent.putExtra("description", userList.get(position).getDescription());
                context.startActivity(intent);

            }
        });
        //String name = userList.get(position).getName();
        //char lastChar = name.charAt(name.length() - 1);


    }

    @Override
    public int getItemCount() {
        return userList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        ImageView image5;
        ImageView image6;
        TextView name;
        TextView desc;
        ImageView image9;
        ImageView image10;
        ConstraintLayout layout;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            image5 = itemView.findViewById(R.id.imageView5);
            image6 = itemView.findViewById(R.id.imageView6);
            name = itemView.findViewById(R.id.name);
            desc = itemView.findViewById(R.id.desc);
            layout = itemView.findViewById(R.id.user_layout);
            //image9 = itemView.findViewById(R.id.imageView9);
            //image10 = itemView.findViewById(R.id.imageView10);

        }
    }
}
