package com.customreactnativewebview

import com.facebook.react.module.annotations.ReactModule
import com.facebook.react.uimanager.ThemedReactContext
import com.facebook.react.uimanager.annotations.ReactProp
import com.reactnativecommunity.webview.RNCWebView
import com.reactnativecommunity.webview.RNCWebViewManager
import com.reactnativecommunity.webview.RNCWebViewWrapper

@ReactModule(name = WebViewManager.NAME)
class WebViewManager : RNCWebViewManager() {
  private class CustomWebView(reactContext: ThemedReactContext) : RNCWebView(reactContext) {
    var finalUrl: String? = null
  }

  override fun createViewInstance(reactContext: ThemedReactContext): RNCWebViewWrapper {
    return super.createViewInstance(
      reactContext, CustomWebView(reactContext)
    )
  }

  override fun getName() = NAME

  @ReactProp(name = "finalUrl")
  fun setFinalUrl(view: RNCWebViewWrapper, url: String?) {
    (view.webView as CustomWebView).finalUrl = url
  }

  companion object {
    const val NAME = "CustomWebView"
  }
}
