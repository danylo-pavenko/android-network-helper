# Library to handle network state and speed
**Jitpack**: [![](https://jitpack.io/v/danylo-pavenko/android-network-helper.svg)](https://jitpack.io/#danylo-pavenko/android-network-helper)

1. For handle network, please add this permission into your manifest.
```xml
    <uses-permission android:name="android.permission.INTERNET" />
    <uses-permission android:name="android.permission.ACCESS_NETWORK_STATE" />
    <uses-permission android:name="android.permission.ACCESS_WIFI_STATE" />
```
2. Prepare dependencies:
   1. **build.gradle** project level.
```groovy
allprojects {
    repositories {
        ...
        maven { url 'https://jitpack.io' }
    }
}
```
    2. **build.gradle** app/module level
```groovy
dependencies {
    implementation 'com.github.danylo-pavenko:android-network-helper:<latest_version>'
}
```
3. For using, you can just use `INetworkStateManager` interface with `NetworkStateManager` implementation. Or using extension function with `Context.isNetworkAvailable` or `Context.isHasConnection` functions.

