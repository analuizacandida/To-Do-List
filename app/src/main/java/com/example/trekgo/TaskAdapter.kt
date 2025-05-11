package com.example.trekgo

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class TaskAdapter(
    private var tasks: List<Task>,
    context: Context
) : RecyclerView.Adapter<TaskAdapter.TaskViewHolder>() {

    private val db: TasksDatabase = TasksDatabase(context)

    class TaskViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        // Referência aos views conforme IDs do layout task_item_improved.xml
        val nameTextView: TextView        = itemView.findViewById(R.id.nameTextView)
        val dateTimeTextView: TextView    = itemView.findViewById(R.id.dateTimeTextView)
        val descriptionTextView: TextView = itemView.findViewById(R.id.descriptionTextView)
        val updateButton: ImageButton     = itemView.findViewById(R.id.updateButton)
        val deleteButton: ImageButton     = itemView.findViewById(R.id.deleteButton)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
        val view = LayoutInflater.from(parent.context)
          
            .inflate(R.layout.task_item, parent, false)
        return TaskViewHolder(view)
    }

    override fun getItemCount(): Int = tasks.size

    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
        val task = tasks[position]
        // Popula dados
        holder.nameTextView.text        = task.name
        holder.dateTimeTextView.text    = "${task.date} ${task.time}"
        holder.descriptionTextView.text = task.description

        // Clique para editar
        holder.updateButton.setOnClickListener {
            val intent = Intent(holder.itemView.context, TaskUpdateActivity::class.java).apply {
                putExtra("task_id", task.id)
            }
            holder.itemView.context.startActivity(intent)
        }

        // Clique para excluir
        holder.deleteButton.setOnClickListener {
            db.deleteTask(task.id)
            refreshData(db.getAllTasks())
            Toast.makeText(holder.itemView.context, "Tarefa excluída", Toast.LENGTH_SHORT).show()
        }
    }

    /** Atualiza lista e notifica adapter */
    fun refreshData(newTasks: List<Task>) {
        tasks = newTasks
        notifyDataSetChanged()
    }
}

