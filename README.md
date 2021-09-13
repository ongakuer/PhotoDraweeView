# PhotoDraweeView

[PhotoView](https://github.com/chrisbanes/PhotoView) For [Fresco](https://github.com/facebook/fresco)

[![Maven Central](https://maven-badges.herokuapp.com/maven-central/me.relex/photodraweeview/badge.svg)](https://maven-badges.herokuapp.com/maven-central/me.relex/photodraweeview)


![PhotoDraweeView](/screenshot.gif)

## Gradle

###### AndroidX
```groovy
dependencies {
    implementation 'com.facebook.fresco:fresco:x.x.x' // (latest)
    implementation 'me.relex:photodraweeview:2.1.0'
}
```

###### Android Support Library
```groovy
dependencies {
    implementation 'com.facebook.fresco:fresco:x.x.x' // (latest)
    implementation 'me.relex:photodraweeview:1.1.3'
}
```



## Usage
```java
mPhotoDraweeView.setPhotoUri(Uri.parse("http://your.image.url"));
```



##### Using the ControllerBuilder
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


## [Issues With ViewGroups](https://github.com/chrisbanes/PhotoView#issues-with-viewgroups)


