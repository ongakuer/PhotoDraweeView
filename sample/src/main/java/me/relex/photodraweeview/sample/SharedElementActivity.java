package me.relex.photodraweeview.sample;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.view.ViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import com.facebook.drawee.view.SimpleDraweeView;
import java.util.List;

public class SharedElementActivity extends AppCompatActivity {

    public static final String SHARED_ELEMENT_NAME = "SHARED_ELEMENT_NAME";

    public static void startActivity(Context context) {
        context.startActivity(new Intent(context, SharedElementActivity.class));
    }

    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shared_element);

        ((Toolbar) findViewById(R.id.toolbar)).setNavigationOnClickListener(
                new View.OnClickListener() {
                    @Override public void onClick(View v) {
                        onBackPressed();
                    }
                });

        final SimpleDraweeView draweeView = (SimpleDraweeView) findViewById(R.id.photo_drawee_view);
        draweeView.setImageURI(Uri.parse("res:///" + R.drawable.panda));
        ViewCompat.setTransitionName(draweeView, SHARED_ELEMENT_NAME);
        draweeView.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {

                ActivityOptionsCompat optionsCompat =
                        ActivityOptionsCompat.makeSceneTransitionAnimation(
                                SharedElementActivity.this, draweeView, SHARED_ELEMENT_NAME);

                // FIX BUG https://github.com/facebook/fresco/issues/1445
                ActivityCompat.setExitSharedElementCallback(SharedElementActivity.this,
                        new android.support.v4.app.SharedElementCallback() {
                            @Override
                            public void onSharedElementEnd(List<String> sharedElementNames,
                                    List<View> sharedElements, List<View> sharedElementSnapshots) {
                                super.onSharedElementEnd(sharedElementNames, sharedElements,
                                        sharedElementSnapshots);
                                for (final View view : sharedElements) {
                                    if (view instanceof SimpleDraweeView) {
                                        view.setVisibility(View.VISIBLE);
                                    }
                                }
                            }
                        });

                ActivityCompat.startActivity(SharedElementActivity.this,
                        new Intent(SharedElementActivity.this, SharedElementLaunchedActivity.class),
                        optionsCompat.toBundle());
            }
        });
    }
}
