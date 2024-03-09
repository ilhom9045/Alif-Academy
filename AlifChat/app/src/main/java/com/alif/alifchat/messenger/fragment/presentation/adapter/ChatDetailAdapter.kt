package com.alif.alifchat.messenger.fragment.presentation.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.IdRes
import androidx.recyclerview.widget.RecyclerView
import com.alif.alifchat.R
import com.alif.alifchat.messenger.fragment.presentation.model.ChatDetailModel

class ChatDetailAdapter(val items: List<ChatDetailModel>) :
    RecyclerView.Adapter<BaseViewHolder<ChatDetailModel>>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): BaseViewHolder<ChatDetailModel> {
        val layoutInflater = LayoutInflater.from(parent.context)
        return when (viewType) {
            MY_MESSAGE -> MyMessageViewHolder(
                layoutInflater.inflate(
                    R.layout.chat_detail_my_message,
                    parent,
                    false
                )
            )

            FRIEND_IMAGE_MESSAGE -> FriedImageMessageViewHolder(
                layoutInflater.inflate(
                    R.layout.chat_detail_friend_image_message,
                    parent,
                    false
                )
            )

            else -> FriedMessageViewHolder(
                layoutInflater.inflate(
                    R.layout.chat_detail_friend_message,
                    parent,
                    false
                )
            )
        }
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: BaseViewHolder<ChatDetailModel>, position: Int) =
        holder.bind(items[position])

    override fun getItemViewType(position: Int): Int {
        return when (items[position]) {
            is ChatDetailModel.MyMessage -> MY_MESSAGE
            is ChatDetailModel.FriendImageMessage -> FRIEND_IMAGE_MESSAGE
            is ChatDetailModel.FriendMessage -> FRIEND_MESSAGE
        }
    }

    private companion object {


        const val MY_MESSAGE = 0
        const val FRIEND_MESSAGE = 1
        const val FRIEND_IMAGE_MESSAGE = 2

    }

}

abstract class BaseViewHolder<T>(v: View) : RecyclerView.ViewHolder(v) {

    abstract fun bind(item: T)

    fun <T : View> findViewById(@IdRes id: Int): T = itemView.findViewById(id)

}

class MyMessageViewHolder(v: View) : BaseViewHolder<ChatDetailModel>(v) {

    private val textView: TextView = findViewById(R.id.textView)

    override fun bind(item: ChatDetailModel) {
        if (item is ChatDetailModel.MyMessage) {
            textView.text = item.message
        }
    }
}

class FriedMessageViewHolder(v: View) : BaseViewHolder<ChatDetailModel>(v) {

    private val textView: TextView = findViewById(R.id.textView)
    private val avatar: ImageView = findViewById(R.id.imageView)

    override fun bind(item: ChatDetailModel) {
        if (item is ChatDetailModel.FriendMessage) {
            textView.text = item.mesage
            avatar.setImageResource(item.avatar)
        }
    }
}

class FriedImageMessageViewHolder(v: View) : BaseViewHolder<ChatDetailModel>(v) {

    private val description: TextView = findViewById(R.id.descriptionTexView)
    private val avatar: ImageView = findViewById(R.id.avatarImageView)
    private val imageView: ImageView = findViewById(R.id.imageView)
    private val link: TextView = findViewById(R.id.linkTextView)

    override fun bind(item: ChatDetailModel) {
        if (item is ChatDetailModel.FriendImageMessage){
            avatar.setImageResource(item.avatar)
            imageView.setImageResource(item.image)
            description.text = item.description
            link.text = item.link
        }
    }
}