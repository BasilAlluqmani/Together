package com.albasil.together

import android.content.Intent
import android.graphics.Bitmap
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.provider.MediaStore
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.albasil.together.databinding.FragmentTextBinding
import com.albasil.together.databinding.PhotoFragmentBinding

class PhotoFragment : Fragment() {

    lateinit var binding : PhotoFragmentBinding
    private lateinit var viewModel: PhotoViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        binding = PhotoFragmentBinding.inflate(inflater, container, false)
        return binding.root

       // return inflater.inflate(R.layout.photo_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this)[PhotoViewModel::class.java]


        binding.btnCamera.setOnClickListener {

            var intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE_SECURE)

            startActivityForResult(intent,123)
        }

        binding.btnGallary.setOnClickListener {
            var intent = Intent(Intent.ACTION_PICK)

            intent.type = "image/*"
            startActivityForResult(intent,456)

        }





    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)


        if (requestCode == 123){
            var bmp :Bitmap =data?.extras?.get("data")as Bitmap

            binding.imageView.setImageBitmap(bmp)

        }else if (requestCode == 456){
            binding.imageView.setImageURI(data?.data)
        }




    }



}