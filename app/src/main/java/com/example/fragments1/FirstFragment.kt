package com.example.fragments1

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toolbar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale


class FirstFragment : Fragment() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: NotesAdapter
    private val notes = mutableListOf<Note>()
    private lateinit var noteInput: EditText

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_first2, container, false)

        val toolbar: Toolbar = view.findViewById(R.id.toolbar)
        noteInput = view.findViewById(R.id.note_input)
        val addButton: Button = view.findViewById(R.id.add_button)
        recyclerView = view.findViewById(R.id.recycler_view)

        adapter = NotesAdapter(notes)
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = adapter

        addButton.setOnClickListener { addNote() }

        return view
    }

    private fun addNote() {
        val text = noteInput.text.toString()
        if (text.isNotEmpty()) {
            val timestamp = SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault()).format(Date())
            val note = Note(notes.size + 1, text, false, timestamp)
            notes.add(note)
            adapter.notifyItemInserted(notes.size - 1)
            noteInput.text.clear()
        }
    }
}
