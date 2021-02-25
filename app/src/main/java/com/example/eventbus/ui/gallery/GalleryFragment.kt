package com.example.eventbus.ui.gallery

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.eventbus.R
import com.example.eventbus.message.MessageEvent
import org.greenrobot.eventbus.EventBus

class GalleryFragment : Fragment() {


    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_gallery, container, false)

        val button = view.findViewById<Button>(R.id.gallery_button)

        button.setOnClickListener {
            val messageEditText = view.findViewById<EditText>(R.id.gallery_edit_text)
            val messageString = messageEditText.text.toString()

            val newMessageToSend: MessageEvent = MessageEvent(messageString)

            EventBus.getDefault().post(newMessageToSend)
        }


        return view
    }
}