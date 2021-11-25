package com.example.demo004

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.SearchView
import android.widget.TextView
import android.widget.Toast
import androidx.navigation.NavDirections
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.demo004.databinding.FragmentRepositoryListBinding
import com.example.demo004.model.User
import com.example.demo004.model.Users
import com.example.demo004.network.PunkApiSevice
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

const val email = "email"

class RepositoryListFragment : Fragment() {
    private lateinit var clickMe : TextView
    private var _binding: FragmentRepositoryListBinding? = null
    private val binding
    get() = _binding !!
    private  val adapter = UsersAdapter { user ->
        var aux: String = "${user.name.title} ${user.name.first} ${user.name.last}"
        val action =
            RepositoryListFragmentDirections.actionRepositoryListFragmentToRepositoryDetailFragment(name = aux, age = user.dob.age.toString(), date = user.dob.date, picture = user.picture.large, country = user.location.country)
        findNavController().navigate(action)
    }

    fun SetupSearchView(){
        val svSearchView: androidx.appcompat.widget.SearchView = binding.svSearch
        svSearchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener,
            androidx.appcompat.widget.SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(p0: String?): Boolean {
                TODO("Not yet implemented")
            }

            override fun onQueryTextChange(p0: String?): Boolean {
                TODO("Not yet implemented")
            }

        })
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentRepositoryListBinding.inflate(inflater, container, false)
        binding.rvUsers.addItemDecoration(
            DividerItemDecoration(context, LinearLayoutManager.VERTICAL)
        )
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.rvUsers.adapter = adapter
        binding.rvUsers.layoutManager = LinearLayoutManager(context)
        requestData()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
    private fun requestData(){
        val retrofit = Retrofit.Builder()
            .baseUrl("https://randomuser.me/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        val service = retrofit.create(PunkApiSevice::class.java)
        service.getAllUsers().enqueue(object : Callback<Users>{
            override fun onResponse(call: Call<Users>, response: Response<Users>) {
                if (response.isSuccessful) {
                    Log.d("getAllUsers", "users:${response.body()}")
                    adapter.submitList(response.body()?.results)
                }else{
                    showError()
                }
            }

            override fun onFailure(call: Call<Users>, t: Throwable) {
                Log.d("OnFailure", "error ${t.message}", t)
            }
        })
    }
    private fun showError(){
        Toast.makeText(context, "Error en la peticion", Toast.LENGTH_SHORT).show()
    }

}

