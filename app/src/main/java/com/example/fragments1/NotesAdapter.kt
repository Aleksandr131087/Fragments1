package com.example.fragments1

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class NotesAdapter(private val notes: List<Note>) : RecyclerView.Adapter<NotesAdapter.NoteViewHolder>() {

    class NoteViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val noteId: TextView = itemView.findViewById(R.id.note_id)
        val noteText: TextView = itemView.findViewById(R.id.note_text)
        val noteCheckbox: CheckBox = itemView.findViewById(R.id.note_checkbox)
        val noteTimestamp: TextView = itemView.findViewById(R.id.note_timestamp)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.note_item, parent, false)
        return NoteViewHolder(view)
    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        val note = notes[position]
        holder.noteId.text = note.id.toString()
        holder.noteText.text = note.text
        holder.noteCheckbox.isChecked = note.isChecked
        holder.noteTimestamp.text = note.timestamp

        holder.noteCheckbox.setOnCheckedChangeListener { _, isChecked ->
            note.isChecked = isChecked
        }
    }

    override fun getItemCount(): Int = notes.size
}