package com.example.github

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.github.databinding.ItemGithubUserBinding

class GithubAdapter : RecyclerView.Adapter<GithubViewHolder>() {

    private val githubItemList = mutableListOf<GithubItem>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GithubViewHolder =
        GithubViewHolder(parent)

    override fun onBindViewHolder(holder: GithubViewHolder, position: Int) {
        holder.bind(githubItemList[position])
    }

    override fun getItemCount(): Int =
        githubItemList.size

    fun addAll(list: List<GithubItem>) {
        githubItemList.addAll(list)
        notifyDataSetChanged()
    }

    fun clear() {
        githubItemList.clear()
        notifyDataSetChanged()
    }
}


class GithubViewHolder(parent: ViewGroup) : RecyclerView.ViewHolder(
    LayoutInflater.from(parent.context).inflate(R.layout.item_github_user, parent, false)
) {

    private val binding = ItemGithubUserBinding.bind(itemView)

    fun bind(item: GithubItem) {


        with(binding) {
            user.text = item.login

            Glide.with(binding.root).load(item.avatar_url).into(image)

        }

    }

}