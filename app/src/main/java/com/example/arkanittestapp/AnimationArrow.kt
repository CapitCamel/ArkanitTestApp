package com.example.arkanittestapp

import android.view.View

object AnimationArrow {
     fun animArrow(view: View, isExpanded: Boolean): Boolean{
        if (isExpanded) {
            view.animate().setDuration(200).rotation(180f)
            return true
        } else {
            view.animate().setDuration(200).rotation(0f)
            return false
        }
    }
}