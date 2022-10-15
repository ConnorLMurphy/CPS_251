package com.ebookfrenzy.addnamesavedata1viewmodel.ui.main

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ebookfrenzy.addnamesavedata1viewmodel.R

import com.ebookfrenzy.addnamesavedata1viewmodel.databinding.FragmentMainBinding

class MainFragment : Fragment() {

    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!


    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        binding.DisplayNames.text = viewModel.getName()

        binding.AddName.setOnClickListener {
            if (binding.PersonName.text.isNotEmpty()) {
                viewModel.addName(binding.PersonName.text.toString())
                binding.DisplayNames.text = viewModel.getName().toString()
            } else {
                binding.DisplayNames.text = "No Names To Display"
            }
        }
    }


}