package me.relex.photodraweeview.sample;

import android.annotation.TargetApi;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.SharedElementCallback;
import android.support.v4.view.ViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.transition.AutoTransition;
import android.view.View;
import android.view.Window;
import java.util.List;
import me.relex.photodraweeview.OnPhotoTapListener;
import me.relex.photodraweeview.PhotoDraweeView;

public class SharedElementLaunchedActivity extends AppCompatActivity {

    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initWindowTransitions();
        setContentView(R.layout.activity_shared_element_launched);
        PhotoDraweeView draweeView = (PhotoDraweeView) findViewById(R.id.photo_drawee_view);
        ViewCompat.setTransitionName(draweeView, SharedElementActivity.SHARED_ELEMENT_NAME);

        draweeView.setPhotoUri(Uri.parse("res:///" + R.drawable.panda));
        draweeView.setOnPhotoTapListener(new OnPhotoTapListener() {
            @Override public void onPhotoTap(View view, float x, float y) {
                onBackPressed();
            }
        });
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP) private void initWindowTransitions() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);
            AutoTransition transition = new AutoTransition();
            getWindow().setSharedElementEnterTransition(transition);
            getWindow().setSharedElementExitTransition(transition);
            ActivityCompat.setEnterSharedElementCallback(this, new SharedElementCallback() {
                @Override public void onSharedElementEnd(List<String> sharedElementNames,
                        List<View> sharedElements, List<View> sharedElementSnapshots) {
                    for (final View view : sharedElements) {
                        if (view instanceof PhotoDraweeView) {
                            ((PhotoDraweeView) view).setScale(1f, true);
                        }
                    }
                }
            });
        }
    }
}
