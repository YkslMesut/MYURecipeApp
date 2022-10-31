package com.myu.myurecipeapp.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.navigation.fragment.navArgs
import coil.load
import com.myu.myurecipeapp.R
import com.myu.myurecipeapp.databinding.FragmentDetailsBinding
import com.myu.myurecipeapp.models.Result
import java.util.zip.ZipEntry

class DetailsFragment : Fragment(R.layout.fragment_details) {
    private var _binding : FragmentDetailsBinding? = null
    private val binding get() = _binding!!
    private val args : DetailsFragmentArgs by navArgs()
    private lateinit var recipe : Result


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        _binding = FragmentDetailsBinding.inflate(inflater,container,false)


        return binding.root
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recipe = args.recipe

        populateUI()
    }

    private fun populateUI() {
        binding.apply {
            tvIngredient.text  = recipe.ingredients
            textViewTitleDetail.text = recipe.title
            imageViewDetail.load(recipe.thumbnail) {
                crossfade(true)
                crossfade(1000)
            }

            button.setOnClickListener { mView ->
                val direction = DetailsFragmentDirections.actionDetailsFragmentToWebViewFragment(recipe)
                    mView.findNavController().navigate(direction)
            }
        }
    }
}