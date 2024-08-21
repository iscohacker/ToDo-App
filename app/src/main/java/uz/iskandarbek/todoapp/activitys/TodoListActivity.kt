package uz.iskandarbek.todoapp.activitys

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import uz.iskandarbek.todoapp.adapters.ExpandAdapter
import uz.iskandarbek.todoapp.databinding.ActivityTodoListBinding
import uz.iskandarbek.todoapp.models.MyTodo
import uz.iskandarbek.todoapp.utils.Mys

class TodoListActivity : AppCompatActivity() {
    //    Development by : Iskandar Nosirov
    private val binding by lazy { ActivityTodoListBinding.inflate(layoutInflater) }
    private lateinit var expandAdapter: ExpandAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }

    override fun onResume() {
        super.onResume()

        val openList = ArrayList<MyTodo>()
        val developmentList = ArrayList<MyTodo>()
        val uploadingList = ArrayList<MyTodo>()
        val rejectList = ArrayList<MyTodo>()
        val closedList = ArrayList<MyTodo>()

        try {
            Mys.init(this)
            val sharedList = Mys.todoList
            for (i in sharedList) {
                if (i.checkedList == "open") {
                    openList.add(i)
                }
                if (i.checkedList == "development") {
                    developmentList.add(i)
                }
                if (i.checkedList == "uploading") {
                    uploadingList.add(i)
                }
                if (i.checkedList == "reject") {
                    rejectList.add(i)
                }
                if (i.checkedList == "closed") {
                    closedList.add(i)
                }
            }

            val expandList = arrayListOf("Open", "Development", "Uploading", "Reject", "Closed")
            val map = HashMap<String, ArrayList<MyTodo>>()

            map[expandList[0]] = openList
            map[expandList[1]] = developmentList
            map[expandList[2]] = uploadingList
            map[expandList[3]] = rejectList
            map[expandList[4]] = closedList

            expandAdapter = ExpandAdapter(expandList, map)
            binding.myExpand.setAdapter(expandAdapter)
        } catch (e: Exception) {
            Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show()
        }

        binding.myExpand.setOnChildClickListener { parent, view, groupPosition, childPosition, id ->
            val intent = Intent(this, ShowActivity::class.java)
            intent.putExtra("groupPosition", groupPosition)
            intent.putExtra("childPosition", childPosition)
            startActivity(intent)
            true
        }
    }
}//    Development by : Iskandar Nosirov
