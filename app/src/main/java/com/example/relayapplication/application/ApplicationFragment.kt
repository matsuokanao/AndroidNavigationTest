package com.example.relayapplication.application

import android.app.Application
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.relayapplication.R
import com.example.relayapplication.home.HomeViewModel

class ApplicationFragment : Fragment() {
    private lateinit var applicationViewModel: ApplicationViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        applicationViewModel =
            ViewModelProviders.of(this).get(ApplicationViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_application, container, false)
        val textView: TextView = root.findViewById(R.id.text_application)
        applicationViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
        return root
    }
}
