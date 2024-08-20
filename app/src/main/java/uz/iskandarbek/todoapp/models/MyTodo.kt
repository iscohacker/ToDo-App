package uz.iskandarbek.todoapp.models

data class MyTodo(
    var name: String,
    var description: String,
    var date: String,
    var deadline: String,
    var flag: MyInfo
)
