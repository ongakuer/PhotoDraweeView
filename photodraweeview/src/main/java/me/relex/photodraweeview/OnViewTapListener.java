package me.relex.photodraweeview;

import android.view.View;

/**
 * Interface definition for a callback to be invoked when the ImageView is tapped with a single
 * tap.
 *
 * @author Chris Banes
 */
public interface OnViewTapListener {
    /**
     * A callback to receive where the user taps on a ImageView. You will receive a callback if
     * the user taps anywhere on the view, tapping on 'whitespace' will not be ignored.
     *
     * @param view - View the user tapped.
     * @param x - where the user tapped from the left of the View.
     * @param y - where the user tapped from the top of the View.
     */
    void onViewTap(View view, float x, float y);
}