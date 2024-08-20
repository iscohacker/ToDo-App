package uz.iskandarbek.todoapp.utils

import android.content.Context
import android.content.SharedPreferences
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import uz.iskandarbek.todoapp.models.MyTodo

object Mys {
    private const val NAME = "catch_file_name"
    private const val MODE = Context.MODE_PRIVATE

    private lateinit var preferences: SharedPreferences

    fun init(context: Context) {
        preferences = context.getSharedPreferences(NAME, MODE)
    }

    private inline fun SharedPreferences.edit(operation: (SharedPreferences.Editor) -> Unit) {
        val editor = edit()
        operation(editor)
        editor.apply()
    }

    var todoList: ArrayList<MyTodo>
        get() = gsonStringToList(preferences.getString("todoList", "[]")!!)
        set(value) = preferences.edit {
            it.putString("todoList", listToGsonString(value))
        }

    private fun gsonStringToList(gsonString: String): ArrayList<MyTodo> {
        val list = ArrayList<MyTodo>()
        val type = object : TypeToken<ArrayList<MyTodo>>() {}.type
        list.addAll(Gson().fromJson(gsonString, type))
        return list
    }

    private fun listToGsonString(list: ArrayList<MyTodo>): String {
        return Gson().toJson(list)
    }
}