package com.talo.pg


import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.talo.pg.databinding.ActivityMainBinding



class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var todoList = mutableListOf(
            Todo("Text String first", false),
            Todo("Text String second", false),
            Todo("Text String third", false),
            Todo("Text String fourth", false)
        )
        val adapter = TodoAdapter(todoList)
        binding.apply {
            rvTodos.adapter = adapter
            rvTodos.layoutManager = LinearLayoutManager(this@MainActivity)
            btnAddTodo.setOnClickListener {
                val title = etTodo.text.toString()
                val todo = Todo(title, false)
                todoList.add(todo)
                adapter.notifyItemInserted(todoList.size - 1)
            }
        }
    }
}