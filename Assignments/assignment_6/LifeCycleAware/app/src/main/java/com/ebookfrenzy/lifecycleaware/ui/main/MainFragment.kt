package com.ebookfrenzy.lifecycleaware.ui.main

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.PackageManagerCompat.LOG_TAG
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.Observer
import androidx.lifecycle.OnLifecycleEvent
import com.ebookfrenzy.lifecycleaware.R

import com.ebookfrenzy.lifecycleaware.DemoObserver
import com.ebookfrenzy.lifecycleaware.databinding.ActivityMainBinding
import com.ebookfrenzy.lifecycleaware.databinding.FragmentMainBinding
import kotlinx.coroutines.delay
import java.util.*


class MainFragment : Fragment() {
    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!


    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        lifecycle.addObserver(DemoObserver())


        val resultObserver = Observer<String> {
                result -> binding.textView.text = result.toString()
        }
        viewModel.getStates().observe(viewLifecycleOwner, resultObserver)


    }





























// Unfortunately I couldn't figure out how to get rid of the null value

}