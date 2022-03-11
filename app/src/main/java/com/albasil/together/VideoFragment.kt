package com.albasil.together

import android.app.Activity
import android.app.Application
import android.content.Intent
import android.database.Cursor
import android.media.ApplicationMediaCapabilities
import android.net.Uri
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.provider.MediaStore
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.MediaController
import androidx.fragment.app.FragmentContainerView
import com.albasil.together.databinding.FragmentTextBinding
import com.albasil.together.databinding.VideoFragmentBinding

class VideoFragment : Fragment() {



    lateinit var binding:VideoFragmentBinding

    private lateinit var viewModel: VideoViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View{

        binding = VideoFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this).get(VideoViewModel::class.java)


        binding.button.setOnClickListener {


            var intent =Intent()
            intent.setType("video/*")

            intent.setAction(Intent.ACTION_GET_CONTENT)

            startActivityForResult(intent,101)

        }







    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (resultCode == Activity.RESULT_OK && data!=null)
        if (requestCode == 101){

            var uri :Uri = data.data!!

            var selectedVideo :String = getPath(uri)

        }
    }
    private fun getPath(uri:Uri):String{

        var projectionArray = arrayOf(MediaStore.Video.Media.DATA)

       // var cursor : Cursor =

        return projectionArray.toString()
    }
}


