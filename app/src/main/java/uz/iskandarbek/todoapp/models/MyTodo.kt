package uz.iskandarbek.todoapp.models

data class MyTodo(
    var name: String,
    var description: String,
    var degree: MyInfo,
    var checkedList: String,
    var date: String,
    var deadline: String
)
