package com.example.gs.firebaserecycler;

import android.content.Context;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.firebase.ui.database.FirebaseRecyclerAdapter;

import com.google.firebase.database.Query;
import com.ms.square.android.expandabletextview.ExpandableTextView;
import com.squareup.picasso.Picasso;

public class Drams extends AppCompatActivity {
    private RecyclerView mBlogList;
    static String keyword;
    private static FirebaseDatabase database;
    DatabaseReference myRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Recycler View
        mBlogList = (RecyclerView)findViewById(R.id.blog_list);
        mBlogList.setHasFixedSize(true);
        mBlogList.setLayoutManager(new LinearLayoutManager(this));

        // Send a Query to the database
        database = FirebaseDatabase.getInstance();

        myRef = database.getReference("Drams");

        android.support.v7.app.ActionBar actionBar = getSupportActionBar();
        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setDisplayShowHomeEnabled(true);
    }


    public static FirebaseDatabase getDatabase() {
        if (database == null) {
            database = FirebaseDatabase.getInstance();
            database.setPersistenceEnabled(true);
        }
        FirebaseDatabase.getInstance().setPersistenceEnabled(true);
        return database;
    }
    @Override
    protected void onStart() {
        super.onStart();

        FirebaseRecyclerAdapter<ModelClass, BlogViewHolder> firebaseRecyclerAdapter =
                new FirebaseRecyclerAdapter<ModelClass, BlogViewHolder>(ModelClass.class, R.layout.design_row, BlogViewHolder.class, myRef)  {
                    @Override
                    protected void populateViewHolder(BlogViewHolder viewHolder, ModelClass model,int position) {
                        viewHolder.setTitle(model.getTitle());
                        viewHolder.setImage(getApplicationContext(), model.getImage());
                        viewHolder.setDesc(model.getDesc());
                    }
                };
        mBlogList.setAdapter(firebaseRecyclerAdapter);
    }
    //View Holder For Recycler View
    public static class BlogViewHolder extends RecyclerView.ViewHolder  {
        View mView;
        public BlogViewHolder(View itemView) {
            super(itemView);
            mView = itemView;
        }
        public void setTitle(String title){
            TextView post_title = (TextView)mView.findViewById(R.id.titleText);
            post_title.setText(title);
        }
        public void setImage(Context ctx , String image){
            ImageView post_image = (ImageView)mView.findViewById(R.id.imageViewy);
            Picasso.with(ctx).load(image).into(post_image);
        }
        public void setDesc(String desc){
            ExpandableTextView post_desc = (ExpandableTextView)mView.findViewById(R.id.expandable_text_view);
            post_desc.setText(desc);

        }
    }
    @Override
    public boolean onSupportNavigateUp(){
        finish();
        return true;
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        final SearchView searchView = (SearchView) MenuItemCompat.getActionView(menu.findItem(R.id.search));

        ImageView closeButton = (ImageView) searchView.findViewById(R.id.search_close_btn);

        // Set on click listener
        closeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseRecyclerAdapter<ModelClass, PDC.BlogViewHolder> firebaseRecyclerAdapter =
                        new FirebaseRecyclerAdapter<ModelClass, PDC.BlogViewHolder>(ModelClass.class, R.layout.design_row, PDC.BlogViewHolder.class, myRef)  {
                            @Override
                            protected void populateViewHolder(PDC.BlogViewHolder viewHolder, ModelClass model, int position) {
                                viewHolder.setTitle(model.getTitle());
                                viewHolder.setImage(getApplicationContext(), model.getImage());
                                viewHolder.setDesc(model.getDesc());
                            }
                        };
                mBlogList.setAdapter(firebaseRecyclerAdapter);
                EditText et = (EditText) findViewById(R.id.search_src_text);
                //Clear the text from EditText view
                et.setText("");
                searchView.setQuery("", false);
                searchView.onActionViewCollapsed();
            }
        });
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextChange(String newText) {
                // your text view here
                return true;
            }

            @Override
            public boolean onQueryTextSubmit(String query) {
                keyword = query;
                FirebaseRecyclerAdapter<ModelClass, PDC.BlogViewHolder> searchadapter =
                        new FirebaseRecyclerAdapter<ModelClass, PDC.BlogViewHolder>(ModelClass.class, R.layout.design_row, PDC.BlogViewHolder.class, (Query) database.getReference("Drams").orderByChild("node").equalTo(keyword.toUpperCase())) {
                            @Override
                            protected void populateViewHolder(PDC.BlogViewHolder viewHolder, ModelClass model, int position) {
                                viewHolder.setTitle(model.getTitle());
                                viewHolder.setImage(getApplicationContext(), model.getImage());
                                viewHolder.setDesc(model.getDesc());
                            }
                        };
                mBlogList.setAdapter(searchadapter);
                return true;
            }
        });
        return true;
    }
}