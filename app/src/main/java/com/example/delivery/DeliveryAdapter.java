package com.example.delivery;

<<<<<<< HEAD
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
=======
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
>>>>>>> origin/IT20152000
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
<<<<<<< HEAD
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.FirebaseDatabase;
import com.orhanobut.dialogplus.DialogPlus;
import com.orhanobut.dialogplus.ViewHolder;

import java.util.HashMap;
import java.util.Map;
=======
>>>>>>> origin/IT20152000

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
<<<<<<< HEAD
    protected void onBindViewHolder(@NonNull myViewHolder holder, final int position, @NonNull DeliveryModel model) {
=======
    protected void onBindViewHolder(@NonNull myViewHolder holder, int position, @NonNull DeliveryModel model) {
>>>>>>> origin/IT20152000
        holder.name.setText(model.getName());
        holder.address.setText(model.getAddress());
        holder.mobile.setText(model.getMobile());
        holder.email.setText(model.getEmail());

        Glide.with(holder.img.getContext())
<<<<<<< HEAD
                .load(model.getIurl())
=======
                .load(model.getName())
>>>>>>> origin/IT20152000
                .placeholder(R.drawable.common_google_signin_btn_icon_dark)
                .circleCrop()
                .error(R.drawable.common_google_signin_btn_icon_dark_normal)
                .into(holder.img);

<<<<<<< HEAD
        holder.btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final DialogPlus dialogPlus = DialogPlus.newDialog(holder.img.getContext())
                        .setContentHolder(new ViewHolder(R.layout.update_popup))
                        .setExpanded(true,1700)
                        .create();

                //dialogPlus.show();

                View view =dialogPlus.getHolderView();

                EditText name = view.findViewById(R.id.txtName);
                EditText address = view.findViewById(R.id.txtAddress);
                EditText mobile = view.findViewById(R.id.txtMobile);
                EditText email = view.findViewById(R.id.txtEmail);
                EditText iurl = view.findViewById(R.id.txtImageUrl);

                Button btnUpdate = view.findViewById(R.id.btnUpdate);

                name.setText(model.getName());
                address.setText(model.getAddress());
                mobile.setText(model.getMobile());
                email.setText(model.getEmail());
                iurl.setText(model.getIurl());

                dialogPlus.show();

                btnUpdate.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Map<String,Object> map = new HashMap<>();
                        map.put("name",name.getText().toString());
                        map.put("address",address.getText().toString());
                        map.put("mobile",mobile.getText().toString());
                        map.put("email",email.getText().toString());
                        map.put("iurl",iurl.getText().toString());

                        FirebaseDatabase.getInstance().getReference().child("delivery")
                                .child(getRef(position).getKey()).updateChildren(map)
                                .addOnSuccessListener(new OnSuccessListener<Void>() {
                                    @Override
                                    public void onSuccess(Void unused) {
                                        Toast.makeText(holder.name.getContext(), "Data Updated Successfully.", Toast.LENGTH_SHORT).show();
                                        dialogPlus.dismiss();
                                    }
                                })
                                .addOnFailureListener(new OnFailureListener() {
                                    @Override
                                    public void onFailure(Exception e) {
                                        Toast.makeText(holder.name.getContext(), "Error While Updating.", Toast.LENGTH_SHORT).show();
                                        dialogPlus.dismiss();
                                    }
                                });
                    }
                });

            }
        });

        holder.btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(holder.name.getContext());
                builder.setTitle("Are you Sure?");
                builder.setMessage("Deleted data can't be Undo.");

                builder.setPositiveButton("Delete", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        FirebaseDatabase.getInstance().getReference().child("delivery")
                                .child(getRef(position).getKey()).removeValue();
                    }
                });

                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(holder.name.getContext(), "Cancelled", Toast.LENGTH_SHORT).show();
                    }
                });
                builder.show();
            }
        });
=======
>>>>>>> origin/IT20152000

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

<<<<<<< HEAD
        Button btnEdit, btnDelete;

=======
>>>>>>> origin/IT20152000
        public myViewHolder(@NonNull View itemView) {
            super(itemView);

            img = (CircleImageView)itemView.findViewById(R.id.adimg1);
            name = (TextView)itemView.findViewById(R.id.nametext);
            address = (TextView)itemView.findViewById(R.id.addresstext);
            mobile = (TextView)itemView.findViewById(R.id.mobiletext);
            email = (TextView)itemView.findViewById(R.id.emailtext);
<<<<<<< HEAD

            btnEdit = (Button)itemView.findViewById(R.id.btnEdit);
            btnDelete = (Button)itemView.findViewById(R.id.btnDelete);

=======
>>>>>>> origin/IT20152000
        }
    }
}
