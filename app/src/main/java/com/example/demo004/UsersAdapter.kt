package com.example.demo004

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.demo004.databinding.ItemUserBinding
import com.example.demo004.extensions.imageUrl
import com.example.demo004.model.User

class UsersAdapter(private val onUserClicked: (User)-> Unit): ListAdapter<User, UsersAdapter.ViewHolder>(ResultItemCallBack()) {
    inner class ViewHolder(val binding: ItemUserBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding: ItemUserBinding = ItemUserBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val user = getItem(position)
        var aux = ""
        aux += user.name.title + " " + user.name.first + " " + user.name.last
        holder.binding.tvName.text = aux
        holder.binding.tvCountry.text = user.location.country
        holder.binding.ivUserPicture.imageUrl(user.picture.large)
        holder.binding.root.setOnClickListener { onUserClicked(user) }
    }

}

class ResultItemCallBack: DiffUtil.ItemCallback<User>(){
    override fun areItemsTheSame(oldItem: User, newItem: User): Boolean {
       return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: User, newItem: User): Boolean {
        return oldItem.id == newItem.id
    }
}