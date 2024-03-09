package com.alif.alifchat.messenger.fragment.presentation.fragment

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.alif.alifchat.R
import com.alif.alifchat.messenger.fragment.presentation.adapter.ChatDetailAdapter
import com.alif.alifchat.messenger.fragment.presentation.model.ChatDetailModel

class ChatDetailFragment : Fragment(R.layout.fragment_chat_detail),
    ChatDetailAdapter.ItemClickListener {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.findViewById<RecyclerView>(R.id.chat_detail_recyclerView).apply {
            adapter = ChatDetailAdapter(
                listOf(
                    ChatDetailModel.FriendMessage(
                        mesage = "Looking forward to the trip.",
                        avatar = R.drawable.ic_bryin
                    ),
                    ChatDetailModel.MyMessage(
                        "Same! Can’t wait."
                    ),
                    ChatDetailModel.FriendImageMessage(
                        description = "Looking forward to the trip.",
                        link = "Looking forward to the trip.",
                        avatar = R.drawable.ic_bryin,
                        image = R.drawable.ic_conyon,
                    ),
                    ChatDetailModel.FriendMessage(
                        mesage = "What do you think?",
                        avatar = R.drawable.ic_bryin
                    ),
                    ChatDetailModel.MyMessage(
                        "Oh yes this looks great!"
                    ),
                ),
                this@ChatDetailFragment
            )
        }
    }

    override fun myMessageClicked(item: ChatDetailModel.MyMessage, position: Int) {
        Toast.makeText(requireContext(), item.toString(), Toast.LENGTH_SHORT).show()
    }

    override fun friedMessageClicked(item: ChatDetailModel.FriendMessage, position: Int) {
        Toast.makeText(requireContext(), item.toString(), Toast.LENGTH_SHORT).show()

    }

    override fun friedMessageClicked(item: ChatDetailModel.FriendImageMessage, position: Int) {
        Toast.makeText(requireContext(), item.toString(), Toast.LENGTH_SHORT).show()

    }

    override fun friedImageMessageClicked(item: ChatDetailModel.FriendImageMessage, position: Int) {
        Toast.makeText(requireContext(), item.toString(), Toast.LENGTH_SHORT).show()
    }

}