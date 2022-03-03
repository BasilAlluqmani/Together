package com.albasil.together

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.albasil.together.databinding.FragmentHomeBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"


class Home : Fragment() {

    lateinit var binding: FragmentHomeBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



        binding.iconPhoto.setOnClickListener {

            findNavController().navigate(R.id.action_home2_to_photoFragment)
        }

        binding.iconText.setOnClickListener {

            findNavController().navigate(R.id.textFragment)
        }

        binding.iconVideo.setOnClickListener {

            findNavController().navigate(R.id.action_home2_to_videoFragment)

        }
    }

    private fun makeToast(text:String) {
        Toast.makeText(context, "this is $text", Toast.LENGTH_SHORT).show()
    }


}