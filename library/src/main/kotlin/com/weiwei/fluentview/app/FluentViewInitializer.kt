package com.weiwei.fluentview.app

import android.annotation.SuppressLint
import android.content.Context
import androidx.startup.Initializer

@SuppressLint("StaticFieldLeak")
internal lateinit var mainContext: Context
  private set

/**
 * The main process is automatically initialized by default
 * Multiple processes need to be initialized manually: [FluentViewInitializer.initialize]
 */
class FluentViewInitializer : Initializer<Unit> {
  companion object {
    fun initialize(context: Context) {
      mainContext = context
    }
  }

  override fun create(context: Context) {
    mainContext = context
  }

  override fun dependencies(): MutableList<Class<out Initializer<*>>> = arrayListOf()
}