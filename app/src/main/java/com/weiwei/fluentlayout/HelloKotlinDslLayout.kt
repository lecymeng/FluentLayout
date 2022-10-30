package com.weiwei.fluentlayout

import android.annotation.SuppressLint
import android.content.Context
import android.util.AttributeSet
import android.widget.FrameLayout
import com.fluent.view.appcompat.imageView
import com.fluent.view.appcompat.textView
import com.fluent.view.constraint.chainPacked
import com.fluent.view.constraint.constraintLayout
import com.fluent.view.constraint.constraintParams
import com.fluent.view.constraint.parentId
import com.fluent.view.createRefs
import com.fluent.view.matchParent
import com.fluent.view.ui.imageResource
import com.fluent.view.ui.unit.dp

/**
 * @author weiwei
 * @date 2021.05.08
 */
@SuppressLint("SetTextI18n")
class HelloKotlinDslLayout : FrameLayout {
  constructor(context: Context) : super(context)
  constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)
  constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

  val v = constraintLayout {
    layoutParams = constraintParams(matchParent, matchParent) { }

    val (iconId, textId) = createRefs()

    imageView(iconId) {
      layoutParams = constraintParams(40.dp, 40.dp) {
        leftToLeft = parentId
        topToTop = parentId
        rightToRight = parentId
        bottomToTop = textId
        verticalChainStyle = chainPacked
      }
      imageResource = R.drawable.ic_android_24dp
    }

    textView(textId) {
      layoutParams = constraintParams {
        topMargin = 8.dp
        leftToLeft = parentId
        topToBottom = iconId
        rightToRight = parentId
        bottomToBottom = parentId
      }
      text = "Hello Android"
    }
  }

  init {
    createView()
  }

  private fun createView() {
    // materialButton(style = R.style.AppWidget_MaterialButton) {
    //   layoutParams = constraintParams {
    //     topMargin = 48.dp
    //     leftToLeft = parentId
    //     topToBottom = iconId
    //     rightToRight = parentId
    //     bottomToBottom = parentId
    //   }
    //   text = "Hello Android"
    // }
  }
}