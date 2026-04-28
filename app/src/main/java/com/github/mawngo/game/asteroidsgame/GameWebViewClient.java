package com.github.mawngo.game.asteroidsgame;

import android.content.Context;
import android.content.Intent;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.webkit.WebViewAssetLoader;

public class GameWebViewClient extends WebViewClient {
    private static final String GAME_BASE_URL = "https://mawngo.github.io/space-shooter-game";
    private static final String LOCAL_BASE_URL = "https://appassets.androidplatform.net/assets/";

    private final WebViewAssetLoader assetLoader;

    public GameWebViewClient(Context context) {
        assetLoader = new WebViewAssetLoader.Builder()
                .addPathHandler("/assets/", new WebViewAssetLoader.AssetsPathHandler(context))
                .build();
    }

    @Override
    public WebResourceResponse shouldInterceptRequest(WebView view, WebResourceRequest request) {
        return assetLoader.shouldInterceptRequest(request.getUrl());
    }

    @Override
    public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
        final String url = request.getUrl().toString();
        if (url.startsWith(GAME_BASE_URL) || url.startsWith(LOCAL_BASE_URL)) {
            return false;
        }
        // Otherwise, the link isn't for a page on your site, so launch another
        // Activity that handles URLs.
        Intent intent = new Intent(Intent.ACTION_VIEW, request.getUrl());
        view.getContext().startActivity(intent);
        return true;
    }
}
