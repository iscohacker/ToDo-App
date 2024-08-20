package uz.iskandarbek.todoapp

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import uz.iskandarbek.todoapp.activitys.AddActivity
import uz.iskandarbek.todoapp.activitys.TodoListActivity
import uz.iskandarbek.todoapp.databinding.ActivityMainBinding
import uz.iskandarbek.todoapp.utils.Mys

class MainActivity : AppCompatActivity() {
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)


        binding.apply {
            todolist.setOnClickListener {
                startActivity(Intent(this@MainActivity, TodoListActivity::class.java))
            }
            addtodo.setOnClickListener {
                startActivity(Intent(this@MainActivity, AddActivity::class.java))
            }
        }
    }
}