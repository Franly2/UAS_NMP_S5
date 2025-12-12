package com.example.uts_nmp

import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class StudentAdapter(private val studentList: List<Student>) :
    RecyclerView.Adapter<StudentAdapter.StudentViewHolder>() {

    class StudentViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val fotoImageView: ImageView = itemView.findViewById(R.id.imgFoto)
        val nameTextView: TextView = itemView.findViewById(R.id.txtNama)
        val nrpTextView: TextView = itemView.findViewById(R.id.txtNRP)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_student_card, parent, false)
        return StudentViewHolder(view)
    }

    override fun getItemCount(): Int = studentList.size

    override fun onBindViewHolder(holder: StudentViewHolder, position: Int) {
        val student = studentList[position]

        holder.nameTextView.text = student.nama
        holder.nrpTextView.text = student.nrp

        if (student.photo_url.isNotEmpty()) {
            Picasso.get()
                .load(student.photo_url)
                .placeholder(R.drawable.ic_person_placeholder)
                .error(R.drawable.ic_person_placeholder)
                .into(holder.fotoImageView, object : com.squareup.picasso.Callback {
                    override fun onSuccess() {
                        Log.e("PICASSO", "Load success")
                    }

                    override fun onError(e: Exception?) {
                        Log.e("PICASSO", "Load failed: ${e?.message}")
                    }
                })
        } else {
            holder.fotoImageView.setImageResource(R.drawable.ic_person_placeholder)
        }

        holder.itemView.setOnClickListener {
            val context = holder.itemView.context
            val intent = Intent(context, DetailActivity::class.java)
            intent.putExtra("nrp", student.nrp)
            intent.putExtra("nama", student.nama)
            intent.putExtra("email", student.email)
            intent.putExtra("program", student.program)
            intent.putExtra("about_me", student.about_me)
            intent.putExtra("my_course", student.my_course)
            intent.putExtra("my_experiences", student.my_experiences)
            intent.putExtra("photo_url", student.photo_url)
            context.startActivity(intent)
        }
    }}
