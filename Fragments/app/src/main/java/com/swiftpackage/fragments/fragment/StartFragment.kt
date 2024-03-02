package com.swiftpackage.fragments.fragment

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResultListener
import com.swiftpackage.fragments.R

class StartFragment : Fragment() {

    private val TAG = this::class.simpleName

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.d(TAG, "onCreateView")
        val view = inflater.inflate(R.layout.start_fragment, container, false)
        val button = view.findViewById<Button>(R.id.button)
        val textView = view.findViewById<TextView>(R.id.textView)
        val fragment = SecondFragment()
        val simpleName = fragment::class.simpleName
        setFragmentResultListener(SecondFragmentResult) { key, bundle ->
            textView.text = bundle.getString("name")
        }
        button.setOnClickListener {
            requireActivity().supportFragmentManager
                .apply {
                    val hasFragment = findFragmentByTag(simpleName)
                    beginTransaction().apply {
                        if (hasFragment != null) {
                            show(hasFragment)
                        } else {
                            add(R.id.container, fragment, simpleName)
                        }
                        addToBackStack(null)
                        commit()
                    }
                }
        }
        return view
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        Log.d(TAG, "onAttach")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "onCreate")
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "onStop")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Log.d(TAG, "onDestroyView")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy")
    }

    override fun onDetach() {
        super.onDetach()
        Log.d(TAG, "onDetach")
    }

}