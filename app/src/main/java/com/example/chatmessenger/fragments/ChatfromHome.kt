package com.example.chatmessenger.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.widget.Toolbar
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.example.chatmessenger.R
import com.example.chatmessenger.Utils
import com.example.chatmessenger.adapter.MessageAdapter
import com.example.chatmessenger.databinding.FragmentChatfromHomeBinding
import com.example.chatmessenger.modal.Messages
import com.example.chatmessenger.mvvm.ChatAppViewModel
import de.hdodenhof.circleimageview.CircleImageView
import android.annotation.SuppressLint
import java.text.SimpleDateFormat
import java.util.*
class ChatfromHome : Fragment() {



    lateinit var args : ChatfromHomeArgs
    lateinit var binding: FragmentChatfromHomeBinding
    lateinit var viewModel : ChatAppViewModel
    lateinit var toolbar: Toolbar
    lateinit var adapter : MessageAdapter



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_chatfrom_home, container, false)


        return binding.root

    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        toolbar = view.findViewById(R.id.toolBarChat)
        val circleImageView = toolbar.findViewById<CircleImageView>(R.id.chatImageViewUser)
        val textViewName = toolbar.findViewById<TextView>(R.id.chatUserName)


        args = ChatfromHomeArgs.fromBundle(requireArguments())


        viewModel = ViewModelProvider(this).get(ChatAppViewModel::class.java)


        binding.viewModel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner


        Glide.with(view.getContext()).load(args.recentchats.friendsimage!!).placeholder(R.drawable.person).dontAnimate().into(circleImageView);
        textViewName.setText(args.recentchats.name)
        //textViewStatus.setText(args.users.status)



        binding.chatBackBtn.setOnClickListener {


            view.findNavController().navigate(R.id.action_chatfromHome_to_homeFragment)

        }

        binding.sendBtn.setOnClickListener {


            viewModel.sendMessage(Utils.getUidLoggedIn(), args.recentchats.friendid!!, args.recentchats.name!!, args.recentchats.friendsimage!!)





        }


        viewModel.getMessages(args.recentchats.friendid!!).observe(viewLifecycleOwner, Observer {





            initRecyclerView(it)



        })




    }

    @SuppressLint("NotifyDataSetChanged")
    private fun initRecyclerView(list: List<Messages>) {
        if (!::adapter.isInitialized) {
            adapter = MessageAdapter()
            val layoutManager = LinearLayoutManager(context).apply {
                stackFromEnd = true
            }
            binding.messagesRecyclerView.layoutManager = layoutManager
            binding.messagesRecyclerView.adapter = adapter
        }

        // Định dạng thời gian giống với format bạn đang dùng
        val formatter = SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault())

        val sortedList = list.sortedBy {
            try {
                formatter.parse(it.time ?: "")?.time ?: 0L
            } catch (e: Exception) {
                0L
            }
        }

        adapter.setList(sortedList)
        adapter.notifyDataSetChanged()

        if (sortedList.isNotEmpty()) {
            binding.messagesRecyclerView.scrollToPosition(sortedList.size - 1)
        }
    }
}