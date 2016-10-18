package me.relex.photodraweeview.sample.gestures;

import android.view.MotionEvent;
import me.relex.photodraweeview.Attacher;
import me.relex.photodraweeview.DefaultOnDoubleTapListener;

public class ScaleStepDoubleTapListener extends DefaultOnDoubleTapListener {

    private static float DEFAULT_SCALE_STEP = 1f;
    private float mScaleStep = DEFAULT_SCALE_STEP;

    public ScaleStepDoubleTapListener(Attacher attacher) {
        super(attacher);
        mAttacher = attacher;
    }

    public ScaleStepDoubleTapListener(Attacher attacher, float scaleStep) {
        super(attacher);
        mAttacher = attacher;
        mScaleStep = scaleStep;
    }

    public void setScaleStep(float scaleStep) {
        mScaleStep = scaleStep;
    }

    @Override public boolean onDoubleTap(MotionEvent event) {
        if (mAttacher == null) {
            return false;
        }

        try {
            float scale = mAttacher.getScale();
            float x = event.getX();
            float y = event.getY();

            // min, step, max
            float newScale = scale;
            if (scale < mAttacher.getMaximumScale()) {
                newScale += mScaleStep;
                if (newScale > mAttacher.getMaximumScale()) {
                    newScale = mAttacher.getMaximumScale();
                }
            } else {
                newScale = mAttacher.getMinimumScale();
            }

            mAttacher.setScale(newScale, x, y, true);
        } catch (Exception e) {
            // Can sometimes happen when getX() and getY() is called
        }
        return true;
    }
}
