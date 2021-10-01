package com.example.delivery;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.SearchView;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;

public class Delivery extends AppCompatActivity {

    RecyclerView recyclerView;
    DeliveryAdapter deliveryAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.delivery);

        recyclerView = (RecyclerView)findViewById(R.id.rv1);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        FirebaseRecyclerOptions<DeliveryModel> options =
                new FirebaseRecyclerOptions.Builder<DeliveryModel>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child("delivery"), DeliveryModel.class)
                        .build();

        deliveryAdapter = new DeliveryAdapter(options);
        recyclerView.setAdapter(deliveryAdapter);

    }

    @Override
    protected void onStart() {
        super.onStart();
        deliveryAdapter.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
        deliveryAdapter.stopListening();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.search,menu);
        MenuItem item = menu.findItem(R.id.search);
        SearchView searchView = (SearchView)item.getActionView();

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                txtSearch(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String query) {
                txtSearch(query);
                return false;
            }
        });


        return super.onCreateOptionsMenu(menu);
    }

    private void txtSearch(String str)
    {
        FirebaseRecyclerOptions<DeliveryModel> options =
                new FirebaseRecyclerOptions.Builder<DeliveryModel>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child("delivery").orderByChild("email").startAt(str).endAt(str+"~"), DeliveryModel.class)
                        .build();

        deliveryAdapter = new DeliveryAdapter(options);
        deliveryAdapter.startListening();
        recyclerView.setAdapter(deliveryAdapter);

    }
}
 
