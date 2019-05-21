# Lazy Android Equalizer View

![screenshoot](https://github.com/a15dotCom/Lazy-Android-Equalizer-View/blob/master/screenshot.png "Lazy Android Equalizer View")

Fast Equalizer Library for Android 
==================================
This Equalizer Class extends SurfaceView implements SurfaceHolder.Callback
This Android Library project is created to let you use a animated equalizer inside your music related apps. Original version
from @a15dotCom

**Required Gradle and SDK **
- gradle:3.4.0
- compileSdkVersion 27

How to use it
----------------------

# Usage
Step 1. Add the JitPack repository to your build file
```groovy
allprojects {
        repositories {
            ...
            maven { url "https://jitpack.io" }
        }
    }
```
Step 2. Add the dependency
```groovy
dependencies {

 }
 ```

## Layout

````xml
        <com.ais.lazylibequalizer.LazyEqualizer
            android:id="@+id/lazy_eq"
            android:layout_width="match_parent"
            android:layout_height="40dp"
            android:layout_gravity="center_horizontal"
            app:barColor="@color/colorAccent"
            app:barCount="100"
            app:barSpacing="12"
            app:barSpeed="200"
            app:barWidth="10"
            app:bgColor="@color/colorPrimary"
            app:max_barHeight="130" />
````

### Attributes

There is some custom attributes you can adjust from the xml:
 - barColor : the equalizer bars color (default is black)
 - bgColor : the equalizer background color (default is white)
 - barSpeed : (millisecs) the animation speed.
 - barCount :  number of the bars
 - barWidth : bar width
 
## Activity

### Initialization + animation

To start animating the equalizer you should add:

````java
LazyEqualizer equalizer = findViewById(R.id.lazy_eq);
equalizer.startView(); // Whenever you want to tart the animation
equalizer.stopView(); // When you want equalizer stops animating
````
And... that's it!, so simple.


Contribution
------------
Every idea and suggestion is very welcome.

Author
--------
Ais Bertuah @a15dotCom

License
-------
http://opensource.org/licenses/MIT

