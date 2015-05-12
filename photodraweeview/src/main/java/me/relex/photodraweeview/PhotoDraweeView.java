package me.relex.photodraweeview;

import android.content.Context;
import android.graphics.Canvas;
import android.support.annotation.NonNull;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.view.SimpleDraweeView;

public class PhotoDraweeView extends SimpleDraweeView implements IAttacher {

    private Attacher mAttacher;

    public PhotoDraweeView(Context context, GenericDraweeHierarchy hierarchy) {
        super(context, hierarchy);
        init();
    }

    public PhotoDraweeView(Context context) {
        super(context);
        init();
    }

    public PhotoDraweeView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public PhotoDraweeView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    protected void init() {
        if (mAttacher == null || mAttacher.getDraweeView() == null) {
            mAttacher = new Attacher(this);
        }
    }

    @Override public boolean onTouchEvent(MotionEvent event) {

        return super.onTouchEvent(event);
    }

    @Override protected void onDraw(@NonNull Canvas canvas) {
        int saveCount = canvas.save();
        canvas.concat(mAttacher.getDrawMatrix());
        super.onDraw(canvas);
        canvas.restoreToCount(saveCount);
    }

    @Override protected void onAttachedToWindow() {
        init();
        super.onAttachedToWindow();
    }

    @Override protected void onDetachedFromWindow() {
        mAttacher.onDetachedFromWindow();
        super.onDetachedFromWindow();
    }

    @Override public float getMinimumScale() {
        return mAttacher.getMinimumScale();
    }

    @Override public float getMediumScale() {
        return mAttacher.getMediumScale();
    }

    @Override public float getMaximumScale() {
        return mAttacher.getMaximumScale();
    }

    @Override public void setMinimumScale(float minimumScale) {
        mAttacher.setMinimumScale(minimumScale);
    }

    @Override public void setMediumScale(float mediumScale) {
        mAttacher.setMediumScale(mediumScale);
    }

    @Override public void setMaximumScale(float maximumScale) {
        mAttacher.setMaximumScale(maximumScale);
    }

    @Override public float getScale() {
        return mAttacher.getScale();
    }

    @Override public void setScale(float scale) {
        mAttacher.setScale(scale);
    }

    @Override public void setScale(float scale, boolean animate) {
        mAttacher.setScale(scale, animate);
    }

    @Override public void setScale(float scale, float focalX, float focalY, boolean animate) {
        mAttacher.setScale(scale, focalX, focalY, animate);
    }

    @Override public void setZoomTransitionDuration(long duration) {
        mAttacher.setZoomTransitionDuration(duration);
    }

    @Override public void setAllowParentInterceptOnEdge(boolean allow) {
        mAttacher.setAllowParentInterceptOnEdge(allow);
    }

    @Override public void setOnDoubleTapListener(GestureDetector.OnDoubleTapListener listener) {
        mAttacher.setOnDoubleTapListener(listener);
    }

    @Override public void setOnScaleChangeListener(OnScaleChangeListener listener) {
        mAttacher.setOnScaleChangeListener(listener);
    }

    @Override public void setOnLongClickListener(OnLongClickListener listener) {
        mAttacher.setOnLongClickListener(listener);
    }

    @Override public void setOnPhotoTapListener(OnPhotoTapListener listener) {
        mAttacher.setOnPhotoTapListener(listener);
    }

    @Override public void setOnViewTapListener(OnViewTapListener listener) {
        mAttacher.setOnViewTapListener(listener);
    }

    @Override public OnPhotoTapListener getOnPhotoTapListener() {
        return mAttacher.getOnPhotoTapListener();
    }

    @Override public OnViewTapListener getOnViewTapListener() {
        return mAttacher.getOnViewTapListener();
    }

    @Override public void update(int imageInfoWidth, int imageInfoHeight) {
        mAttacher.update(imageInfoWidth, imageInfoHeight);
    }
}
