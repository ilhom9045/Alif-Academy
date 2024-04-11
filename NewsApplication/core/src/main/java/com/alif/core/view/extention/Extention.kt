package com.alif.core.view.extention

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.annotation.IdRes
import androidx.annotation.LayoutRes
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.MenuProvider
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import com.alif.core.common.ifNotEmpty
import com.bumptech.glide.Glide

fun ViewGroup.inflate(@LayoutRes layoutResID: Int): View =
    LayoutInflater.from(this.context).inflate(layoutResID, this, false)

fun ImageView.loadImage(url: String) {
    Glide.with(context)
        .load(url)
        .into(this)
}

fun Fragment.transaction(
    containerId: Int,
    fragment: Fragment,
    isReplace: Boolean = true,
    addToBackStack: Boolean = false,
    tag: String? = null,
    hideAndShowPreviousFragment: Boolean = false
) {
    transaction(
        fragmentManager = requireActivity().supportFragmentManager,
        containerId = containerId,
        fragment = fragment,
        isReplace = isReplace,
        addToBackStack = addToBackStack,
        tag = tag,
        hideAndShowPreviousFragment = hideAndShowPreviousFragment
    )
}

fun AppCompatActivity.transaction(
    container_id: Int,
    fragment: Fragment,
    isReplace: Boolean = true,
    addToBackStack: Boolean = false,
    tag: String? = null,
    disableClickableInPreviousFragment: Boolean = false
) {
    transaction(
        fragmentManager = supportFragmentManager,
        containerId = container_id,
        fragment = fragment,
        isReplace = isReplace,
        addToBackStack = addToBackStack,
        tag = tag,
        hideAndShowPreviousFragment = disableClickableInPreviousFragment
    )
}

fun transaction(
    fragmentManager: FragmentManager,
    containerId: Int,
    fragment: Fragment,
    isReplace: Boolean = true,
    addToBackStack: Boolean = false,
    tag: String? = null,
    hideAndShowPreviousFragment: Boolean = false
) {
    fragmentManager.apply {
        beginTransaction().apply {
            if (isReplace) replace(containerId, fragment, tag)
            else add(containerId, fragment, tag)
            if (addToBackStack) {
                addToBackStack(tag)
            }
            if (hideAndShowPreviousFragment) {
                fragmentManager.fragments.ifNotEmpty {
                    hide(last())
                }
            }
            commitAllowingStateLoss()
        }
    }
}

fun FragmentManager.showLastFragmentWhenHide() {
    fragments.ifNotEmpty {
        val lastFragment = last()
        if (!lastFragment.isVisible) {
            beginTransaction().show(lastFragment).commitAllowingStateLoss()
        }
    }
}

val Fragment.appCompatActivity: AppCompatActivity? get() = (activity as AppCompatActivity?)
val Fragment.supportActionBar: ActionBar? get() = appCompatActivity?.supportActionBar

fun Fragment.setSupportActionBar(toolbar: Toolbar) {
    appCompatActivity?.setSupportActionBar(toolbar)
}

fun Fragment.addMenuProvider(
    menuProvider: MenuProvider,
    owner: LifecycleOwner = viewLifecycleOwner,
    state: Lifecycle.State = Lifecycle.State.CREATED
) {
    appCompatActivity?.addMenuProvider(menuProvider, owner, state)
}

fun Fragment.setFragmentResult(
    key: String,
    bundle: Bundle,
    fragmentManager: FragmentManager = parentFragmentManager,
) = fragmentManager.setFragmentResult(key, bundle)

fun Fragment.setFragmentResultListener(
    key: String,
    fragmentManager: FragmentManager = parentFragmentManager,
    listener: Bundle.(key: String) -> Unit
) = fragmentManager.setFragmentResultListener(key, viewLifecycleOwner) { k, bundle ->
    listener.invoke(bundle, k)
}

fun <T : View> Fragment.findViewById(@IdRes id: Int): T = requireView().findViewById(id)