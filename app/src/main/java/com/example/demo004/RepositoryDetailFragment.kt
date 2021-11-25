package com.example.demo004

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.example.demo004.databinding.FragmentRepositoryDetailBinding
import com.example.demo004.extensions.imageUrl

class RepositoryDetailFragment : Fragment() {
    private var _binding: FragmentRepositoryDetailBinding? = null
    private val binding
        get() = _binding !!
    var name: String = ""
    var age: String = ""
    var date: String = ""
    var country: String = ""
    var picture: String = ""

    private lateinit var clickMe : TextView
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentRepositoryDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        requestData()
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
    fun requestData(){
        arguments.let {
            if (it != null) {
                name = it.getString("name").toString()
                age = it.getString("age").toString()
                date = it.getString("date").toString()
                picture = it.getString("picture").toString()
                country = it.getString("country").toString()
            }
        binding.tvAge.text = age
        binding.tvAux.text = name
        binding.tvCountryDetail.text = country
        binding.tvDate.text = date
        binding.imgIdDetail.imageUrl(picture)
        }

    }
}