package com.albasil.together

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isEmpty
import androidx.core.view.isNotEmpty
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.albasil.together.databinding.FragmentHomeBinding
import com.albasil.together.databinding.FragmentTextBinding

class TextFragment : Fragment() {

    lateinit var binding: FragmentTextBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentTextBinding.inflate(inflater, container, false)
        return binding.root


    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



        binding.btnShare.setOnClickListener {


            if (!binding.etText.text.toString().isNullOrEmpty()){
                findNavController().navigate(R.id.action_textFragment_to_home2)

            }
        }
    }

}