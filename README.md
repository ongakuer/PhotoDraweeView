# PhotoDraweeView

[PhotoView](https://github.com/chrisbanes/PhotoView) For [Fresco](https://github.com/facebook/fresco)

![PhotoDraweeView](/screenshot.gif)



Gradle
------------
```groovy
dependencies {
    compile 'com.facebook.fresco:fresco:0.10.0'
    compile 'me.relex:photodraweeview:1.0.0'
}
```


Usage
--------

```java
PipelineDraweeControllerBuilder controller = Fresco.newDraweeControllerBuilder();
controller.setUri(URI);
controller.setOldController(mPhotoDraweeView.getController());
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
```


License
--------
```
Copyright 2015-2016 Relex

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```

