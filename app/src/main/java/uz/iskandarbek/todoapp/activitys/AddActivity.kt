package uz.iskandarbek.todoapp.activitys

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import uz.iskandarbek.todoapp.R
import uz.iskandarbek.todoapp.adapters.MySpinnerAdapter
import uz.iskandarbek.todoapp.databinding.ActivityAddBinding
import uz.iskandarbek.todoapp.models.MyInfo
import uz.iskandarbek.todoapp.models.MyTodo
import uz.iskandarbek.todoapp.utils.Mys

class AddActivity : AppCompatActivity() {
//    Development by : Iskandar Nosirov
    private val binding by lazy { ActivityAddBinding.inflate(layoutInflater) }
    var list: ArrayList<MyInfo> = ArrayList()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        list = ArrayList()
        list.add(MyInfo("Urgent", R.drawable.urgent))
        list.add(MyInfo("High", R.drawable.high))
        list.add(MyInfo("Medium", R.drawable.normal))
        list.add(MyInfo("Low", R.drawable.low))

        binding.spinner.adapter = MySpinnerAdapter(list, this)

        binding.save.setOnClickListener {
            if (binding.todoName.text.isNotBlank() && binding.todoDescription.text.isNotBlank() && binding.todoDate.text.isNotBlank() && binding.todoDeadline.text.isNotBlank()) {
                binding.apply {
                    Mys.init(this@AddActivity)
                    val todoList = Mys.todoList
                    todoList.add(
                        MyTodo(
                            todoName.text.toString(),
                            todoDescription.text.toString(),
                            spinner.selectedItem as MyInfo,
                            "open",
                            todoDate.text.toString(),
                            todoDeadline.text.toString()
                        )
                    )
                    Mys.todoList = todoList
                    Toast.makeText(this@AddActivity, "Saved", Toast.LENGTH_SHORT).show()
                    finish()
                }
            } else {
                Toast.makeText(this, "Fill in the fields completely", Toast.LENGTH_SHORT).show()
            }
        }
    }
}//    Development by : Iskandar Nosirov
