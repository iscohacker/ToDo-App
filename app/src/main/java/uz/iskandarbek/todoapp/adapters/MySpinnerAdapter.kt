package uz.iskandarbek.todoapp.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import uz.iskandarbek.todoapp.R
import uz.iskandarbek.todoapp.models.MyInfo

class MySpinnerAdapter(val list: ArrayList<MyInfo>, private val context: Context) : BaseAdapter() {

    override fun getCount(): Int = list.size

    override fun getItem(position: Int): Any {

        return list[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var itemView: View
        if (convertView == null) {
            itemView =
                LayoutInflater.from(parent?.context).inflate(R.layout.item_flags, parent, false)
        } else {
            itemView = convertView
        }

        itemView.findViewById<TextView>(R.id.name).text = list[position].name
        if (list[position].image != -1)
            itemView.findViewById<ImageView>(R.id.flag).setImageResource(list[position].image)
        return itemView
    }
}