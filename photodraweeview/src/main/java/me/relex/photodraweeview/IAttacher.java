package me.relex.photodraweeview;

import android.view.GestureDetector;
import android.view.View;

/**
 * ****************************************************************************
 * Copyright 2011, 2012 Chris Banes.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * *****************************************************************************
 */

public interface IAttacher {

    float DEFAULT_MAX_SCALE = 3.0f;
    float DEFAULT_MID_SCALE = 1.75f;
    float DEFAULT_MIN_SCALE = 1.0f;
    long ZOOM_DURATION = 200L;

    float getMinimumScale();

    float getMediumScale();

    float getMaximumScale();

    void setMaximumScale(float maximumScale);

    void setMediumScale(float mediumScale);

    void setMinimumScale(float minimumScale);

    float getScale();

    void setScale(float scale);

    void setScale(float scale, boolean animate);

    void setScale(float scale, float focalX, float focalY, boolean animate);

    void setOrientation(@Attacher.OrientationMode int orientation);

    void setZoomTransitionDuration(long duration);

    void setAllowParentInterceptOnEdge(boolean allow);

    void setOnDoubleTapListener(GestureDetector.OnDoubleTapListener listener);

    void setOnScaleChangeListener(OnScaleChangeListener listener);

    void setOnLongClickListener(View.OnLongClickListener listener);

    void setOnPhotoTapListener(OnPhotoTapListener listener);

    void setOnViewTapListener(OnViewTapListener listener);

    OnPhotoTapListener getOnPhotoTapListener();

    OnViewTapListener getOnViewTapListener();

    void update(int imageInfoWidth, int imageInfoHeight);
}
