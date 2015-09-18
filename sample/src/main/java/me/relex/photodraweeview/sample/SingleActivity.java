package me.relex.photodraweeview.sample;

import android.content.Intent;
import android.graphics.drawable.Animatable;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.backends.pipeline.PipelineDraweeControllerBuilder;
import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.imagepipeline.image.ImageInfo;
import me.relex.photodraweeview.OnPhotoTapListener;
import me.relex.photodraweeview.OnViewTapListener;
import me.relex.photodraweeview.PhotoDraweeView;

public class SingleActivity extends AppCompatActivity {

    private PhotoDraweeView mPhotoDraweeView;

    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single);

        initToolbar();

        mPhotoDraweeView = (PhotoDraweeView) findViewById(R.id.photo_drawee_view);
        PipelineDraweeControllerBuilder controller = Fresco.newDraweeControllerBuilder();
        controller.setUri(Uri.parse("res:///" + R.drawable.panda));
        controller.setOldController(mPhotoDraweeView.getController());
        // You need setControllerListener
        controller.setControllerListener(new BaseControllerListener<ImageInfo>() {
            @Override
            public void onFinalImageSet(String id, ImageInfo imageInfo, Animatable animatable) {
                super.onFinalImageSet(id, imageInfo, animatable);
                if (imageInfo == null || mPhotoDraweeView == null) {
                    return;
                }
                mPhotoDraweeView.update(imageInfo.getWidth(), imageInfo.getHeight());
            }
        });
        mPhotoDraweeView.setController(controller.build());
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
                if (menuItem.getItemId() == R.id.view_pager) {
                    startActivity(new Intent(SingleActivity.this, ViewPagerActivity.class));
                }
                return true;
            }
        });
    }
}
