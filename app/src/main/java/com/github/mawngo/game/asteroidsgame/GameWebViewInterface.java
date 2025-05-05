package com.github.mawngo.game.asteroidsgame;

import android.app.Activity;
import android.content.pm.PackageInfo;
import android.util.Log;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import android.widget.Toast;

class GameWebViewInterface {
    private final Activity activity;
    private final WebView webView;

    GameWebViewInterface(Activity activity, WebView webView) {
        this.activity = activity;
        this.webView = webView;
    }

    @JavascriptInterface
    public void onGameVersion(String version) {
        final var context = activity.getApplicationContext();
        try {
            final PackageInfo pInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
            final String appVer = version.isEmpty()
                    ? pInfo.versionName
                    : pInfo.versionName + "." + version;
            activity.runOnUiThread(() -> {
                webView.evaluateJavascript("localStorage.setItem('gameVersion', '" + appVer + "')", null);
            });
        } catch (Exception e) {
            Log.e("GameWebViewInterface", "onGameVersion: ", e);
        }
    }

    @JavascriptInterface
    public void onGameQuit() {
        activity.finishAndRemoveTask();
    }
}
