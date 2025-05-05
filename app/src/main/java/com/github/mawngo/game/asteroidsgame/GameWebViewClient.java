package com.github.mawngo.game.asteroidsgame;

import android.content.Intent;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class GameWebViewClient extends WebViewClient {
    private static final String GAME_BASE_URL = "https://mawngo.github.io/space-shooter-game";

    @Override
    public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
        if (request.getUrl().toString().startsWith(GAME_BASE_URL)) {
            return false;
        }
        // Otherwise, the link isn't for a page on your site, so launch another
        // Activity that handles URLs.
        Intent intent = new Intent(Intent.ACTION_VIEW, request.getUrl());
        view.getContext().startActivity(intent);
        return true;
    }
}
