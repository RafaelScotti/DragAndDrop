package com.zanella.draganddrop

import android.content.ClipData
import android.databinding.DataBindingUtil
import android.graphics.Color
import android.os.Build
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.annotation.RequiresApi
import android.support.constraint.ConstraintLayout
import android.util.Log
import android.view.DragEvent
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import android.widget.GridLayout
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import com.zanella.draganddrop.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var text = "Move me!"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        val binding = DataBindingUtil
            .setContentView<ActivityMainBinding>(this, R.layout.activity_main)

        binding.main = MainActivity()
        imageView.setOnTouchListener(MyTouchListener())
        l1.setOnDragListener(MyDragListener())
        l2.setOnDragListener(MyDragListener())
        l3.setOnDragListener(MyDragListener())
        l4.setOnDragListener(MyDragListener())


    }

    class MyTouchListener : View.OnTouchListener{
        override fun onTouch(v: View, event: MotionEvent): Boolean {
            var data  = ClipData.newPlainText("simple_text", "txt")
            var sb : View.DragShadowBuilder = View.DragShadowBuilder(v)
            v.startDrag(data, sb, v, 0)
            //v.setVisibility(View.INVISIBLE)

            return true
        }
    }

    class MyDragListener: View.OnDragListener {

        override fun onDrag(v: View, event: DragEvent): Boolean {
            when (event.getAction()) {
                DragEvent.ACTION_DRAG_STARTED -> {}
                DragEvent.ACTION_DRAG_ENTERED -> {}
                DragEvent.ACTION_DRAG_EXITED -> {}
                DragEvent.ACTION_DROP -> {
                    val view = event.getLocalState() as View
                    val owner = view.getParent() as ViewGroup
                    owner.removeView(view)
                    val container = v as LinearLayout
                    container.addView(view)
                    view.setVisibility(View.VISIBLE)
                }
                DragEvent.ACTION_DRAG_ENDED -> {}
                else -> {}
            }
            return true
        }


    }



}
