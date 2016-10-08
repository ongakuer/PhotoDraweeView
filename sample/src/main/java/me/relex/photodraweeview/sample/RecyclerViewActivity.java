package me.relex.photodraweeview.sample;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import me.relex.photodraweeview.Attacher;
import me.relex.photodraweeview.PhotoDraweeView;

public class RecyclerViewActivity extends AppCompatActivity {

    public static void startActivity(Context context) {
        context.startActivity(new Intent(context, RecyclerViewActivity.class));
    }

    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);

        ((Toolbar) findViewById(R.id.toolbar)).setNavigationOnClickListener(
                new View.OnClickListener() {
                    @Override public void onClick(View v) {
                        onBackPressed();
                    }
                });

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new DraweeAdapter());
    }

    public class DraweeAdapter extends RecyclerView.Adapter<DraweeViewHolder> {

        private int[] mDrawables = new int[] {
                R.drawable.viewpager_1, R.drawable.viewpager_2, R.drawable.viewpager_3,
                R.drawable.viewpager_1, R.drawable.viewpager_2, R.drawable.viewpager_3,
        };

        @Override public DraweeViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return DraweeViewHolder.createViewHolder(parent);
        }

        @Override public void onBindViewHolder(DraweeViewHolder holder, int position) {
            holder.bindView(mDrawables[position]);
        }

        @Override public int getItemCount() {
            return mDrawables.length;
        }
    }

    public static class DraweeViewHolder extends RecyclerView.ViewHolder {

        private PhotoDraweeView mPhotoDraweeView;

        public DraweeViewHolder(View itemView) {
            super(itemView);
            mPhotoDraweeView = (PhotoDraweeView) itemView.findViewById(R.id.photo_drawee_view);
            mPhotoDraweeView.setOrientation(Attacher.VERTICAL);
        }

        public static DraweeViewHolder createViewHolder(ViewGroup viewGroup) {
            return new DraweeViewHolder(LayoutInflater.from(viewGroup.getContext())
                    .inflate(R.layout.item_photo_view, viewGroup, false));
        }

        public void bindView(int resId) {
            mPhotoDraweeView.setPhotoUri(Uri.parse("res:///" + resId));
        }
    }
}
