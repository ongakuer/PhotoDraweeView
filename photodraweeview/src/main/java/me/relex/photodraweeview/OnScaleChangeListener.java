package me.relex.photodraweeview;

/**
 * Interface definition for callback to be invoked when attached ImageView scale changes
 *
 * @author Marek Sebera
 */
public interface OnScaleChangeListener {
    /**
     * Callback for when the scale changes
     *
     * @param scaleFactor the scale factor
     * @param focusX focal point X position
     * @param focusY focal point Y position
     */
    void onScaleChange(float scaleFactor, float focusX, float focusY);
}
