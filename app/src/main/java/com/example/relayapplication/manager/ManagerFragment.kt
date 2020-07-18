package com.example.relayapplication.manager

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


class ManagerFragment : Fragment() {
    private lateinit var managerViewModel: ManagerViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        managerViewModel =
            ViewModelProviders.of(this).get(ManagerViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_manager, container, false)
        val textView: TextView = root.findViewById(R.id.text_manager)
        managerViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
        return root
    }
}