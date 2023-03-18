# Library to handle network state and speed

1. For handle network, please add this permission into your manifest.
```xml
    <uses-permission android:name="android.permission.INTERNET" />
    <uses-permission android:name="android.permission.ACCESS_NETWORK_STATE" />
    <uses-permission android:name="android.permission.ACCESS_WIFI_STATE" />
```
2. For using, you can just use `INetworkStateManager` interface with `NetworkStateManager` implementation. Or using extension function with `Context.isNetworkAvailable` or `Context.isHasConnection` functions.
