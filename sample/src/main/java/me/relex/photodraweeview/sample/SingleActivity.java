package me.relex.photodraweeview.sample;

import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;
import me.relex.photodraweeview.OnPhotoTapListener;
import me.relex.photodraweeview.OnViewTapListener;
import me.relex.photodraweeview.PhotoDraweeView;
import me.relex.photodraweeview.sample.gestures.ScaleStepDoubleTapListener;

public class SingleActivity extends AppCompatActivity {

    private PhotoDraweeView mPhotoDraweeView;

    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single);

        initToolbar();
        mPhotoDraweeView = (PhotoDraweeView) findViewById(R.id.photo_drawee_view);
        mPhotoDraweeView.setPhotoUri(Uri.parse("res:///" + R.drawable.panda));
        mPhotoDraweeView.setOnPhotoTapListener(new OnPhotoTapListener() {
            @Override public void onPhotoTap(View view, float x, float y) {
                Toast.makeText(view.getContext(), "onPhotoTap :  x =  " + x + ";" + " y = " + y,
                        Toast.LENGTH_SHORT).show();
            }
        });
        mPhotoDraweeView.setOnViewTapListener(new OnViewTapListener() {
            @Override public void onViewTap(View view, float x, float y) {
                Toast.makeText(view.getContext(), "onViewTap", Toast.LENGTH_SHORT).show();
            }
        });

        mPhotoDraweeView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override public boolean onLongClick(View v) {
                Toast.makeText(v.getContext(), "onLongClick", Toast.LENGTH_SHORT).show();
                return true;
            }
        });
    }

    private void initToolbar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.inflateMenu(R.menu.single);
        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override public boolean onMenuItemClick(MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.default_image:
                        mPhotoDraweeView.setOnDoubleTapListener(null);
                        mPhotoDraweeView.setPhotoUri(Uri.parse("res:///" + R.drawable.panda));
                        break;
                    case R.id.failure_image:
                        mPhotoDraweeView.setPhotoUri(Uri.parse("http://google.com/404.jpg"));
                        break;
                    case R.id.view_pager:
                        ViewPagerActivity.startActivity(SingleActivity.this);
                        break;
                    case R.id.recycler_view:

                        RecyclerViewActivity.startActivity(SingleActivity.this);
                        break;
                    case R.id.scale_step:
                        mPhotoDraweeView.setOnDoubleTapListener(
                                new ScaleStepDoubleTapListener(mPhotoDraweeView.getAttacher(),
                                        0.25f));
                        break;
                    case R.id.shared_element:
                        SharedElementActivity.startActivity(SingleActivity.this);
                        break;
                }

                return true;
            }
        });
    }
}
