package com.example.delivery;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

import de.hdodenhof.circleimageview.CircleImageView;

public class DeliveryAdapter extends FirebaseRecyclerAdapter <DeliveryModel,DeliveryAdapter.myViewHolder>{

    /**
     * Initialize a {@link RecyclerView.Adapter} that listens to a Firebase query. See
     * {@link FirebaseRecyclerOptions} for configuration options.
     *
     * @param options
     */
    public DeliveryAdapter(@NonNull FirebaseRecyclerOptions<DeliveryModel> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull myViewHolder holder, int position, @NonNull DeliveryModel model) {
        holder.name.setText(model.getName());
        holder.address.setText(model.getAddress());
        holder.mobile.setText(model.getMobile());
        holder.email.setText(model.getEmail());

        Glide.with(holder.img.getContext())
                .load(model.getName())
                .placeholder(R.drawable.common_google_signin_btn_icon_dark)
                .circleCrop()
                .error(R.drawable.common_google_signin_btn_icon_dark_normal)
                .into(holder.img);


    }

    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.main_address,parent,false);
        return new myViewHolder(view);
    }

    class myViewHolder extends RecyclerView.ViewHolder{

        CircleImageView img;
        TextView name, address, mobile, email;

        public myViewHolder(@NonNull View itemView) {
            super(itemView);

            img = (CircleImageView)itemView.findViewById(R.id.adimg1);
            name = (TextView)itemView.findViewById(R.id.nametext);
            address = (TextView)itemView.findViewById(R.id.addresstext);
            mobile = (TextView)itemView.findViewById(R.id.mobiletext);
            email = (TextView)itemView.findViewById(R.id.emailtext);
        }
    }
}
