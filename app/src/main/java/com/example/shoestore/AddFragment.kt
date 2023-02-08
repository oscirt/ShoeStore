package com.example.shoestore

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.shoestore.databinding.FragmentAddBinding
import com.example.shoestore.models.Shoe
import com.example.shoestore.viewModels.ShoeListViewModel

class AddFragment : Fragment() {

    private lateinit var binding: FragmentAddBinding
    private val viewModel: ShoeListViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater,
            R.layout.fragment_add, container, false)

        binding.cancelButton.setOnClickListener {
            findNavController().navigate(AddFragmentDirections.actionAddFragmentToListFragment(null))
        }

        binding.saveButton.setOnClickListener {
            val title = binding.titleEdit.text
            val size = binding.sizeEdit.text
            val company = binding.companyEdit.text
            val description = binding.descrEdit.text
            if (title.isNotBlank() && size.isNotBlank() &&
                company.isNotBlank() && description.isNotBlank()) {
                val shoe = Shoe(title.toString(),
                    size.toString().toDouble(),
                    company.toString(),
                    description.toString()
                )
                viewModel.addShoe(shoe)
                findNavController().navigate(AddFragmentDirections.actionAddFragmentToListFragment(shoe))
            }
        }

        return binding.root
    }
}