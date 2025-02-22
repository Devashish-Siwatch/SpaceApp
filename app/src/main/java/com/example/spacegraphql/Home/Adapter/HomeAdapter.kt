package com.example.spacegraphql.Home.Adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.api.load
import com.example.spacegraphql.LaunchListQuery
import com.example.spacegraphql.R
import com.example.spacegraphql.databinding.LaunchItemBinding

class HomeAdapter(val launches: List<LaunchListQuery.Launch>) :
    RecyclerView.Adapter<HomeAdapter.ViewHolder>() {


    class ViewHolder(val binding: LaunchItemBinding) : RecyclerView.ViewHolder(binding.root)

    override fun getItemCount(): Int {
        return launches.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = LaunchItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val launch = launches.get(position)
        holder.binding.site.text = launch.site ?: ""
        holder.binding.missionName.text = launch.mission?.name
        holder.binding.missionPatch.load(launch.mission?.missionPatch) {
            placeholder(R.drawable.rocket_rider)
        }
    }
}
