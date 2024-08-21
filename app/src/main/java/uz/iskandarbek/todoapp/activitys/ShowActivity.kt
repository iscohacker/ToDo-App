package uz.iskandarbek.todoapp.activitys

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import uz.iskandarbek.todoapp.databinding.ActivityShowBinding
import uz.iskandarbek.todoapp.models.MyTodo
import uz.iskandarbek.todoapp.utils.Mys

class ShowActivity : AppCompatActivity() {
    private val binding by lazy { ActivityShowBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val openList = ArrayList<MyTodo>()
        val developmentList = ArrayList<MyTodo>()
        val uploadingList = ArrayList<MyTodo>()
        val rejectList = ArrayList<MyTodo>()
        val closedList = ArrayList<MyTodo>()

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

        val groupPosition = intent.getIntExtra("groupPosition", -1)
        val childPosition = intent.getIntExtra("childPosition", -1)
        binding.apply {
            when (groupPosition) {
                0 -> {
                    tvTitle.text = openList[childPosition].name
                    tvDescription.text = openList[childPosition].description
                    tvSpinner.text = openList[childPosition].degree.name
                    imgSpinner.setImageResource(openList[childPosition].degree.image)
                    tvDate.text = openList[childPosition].date
                    tvDeadline.text = openList[childPosition].deadline
                    radioOpen.isChecked = true
                }

                1 -> {
                    tvTitle.text = developmentList[childPosition].name
                    tvDescription.text = developmentList[childPosition].description
                    tvSpinner.text = developmentList[childPosition].degree.name
                    imgSpinner.setImageResource(developmentList[childPosition].degree.image)
                    tvDate.text = developmentList[childPosition].date
                    tvDeadline.text = developmentList[childPosition].deadline
                    radioDevelopment.isChecked = true
                }

                2 -> {
                    tvTitle.text = uploadingList[childPosition].name
                    tvDescription.text = uploadingList[childPosition].description
                    tvSpinner.text = uploadingList[childPosition].degree.name
                    imgSpinner.setImageResource(uploadingList[childPosition].degree.image)
                    tvDate.text = uploadingList[childPosition].date
                    tvDeadline.text = uploadingList[childPosition].deadline
                    radioUploading.isChecked = true
                }

                3 -> {
                    tvTitle.text = rejectList[childPosition].name
                    tvDescription.text = rejectList[childPosition].description
                    tvSpinner.text = rejectList[childPosition].degree.name
                    imgSpinner.setImageResource(rejectList[childPosition].degree.image)
                    tvDate.text = rejectList[childPosition].date
                    tvDeadline.text = rejectList[childPosition].deadline
                    radioReject.isChecked = true
                }

                4 -> {
                    tvTitle.text = closedList[childPosition].name
                    tvDescription.text = closedList[childPosition].description
                    tvSpinner.text = closedList[childPosition].degree.name
                    imgSpinner.setImageResource(closedList[childPosition].degree.image)
                    tvDate.text = closedList[childPosition].date
                    tvDeadline.text = closedList[childPosition].deadline
                    radioClosed.isChecked = true
                }
            }

            btnOk.setOnClickListener {
                for (i in sharedList.indices) {
                    when (groupPosition) {
                        0 -> {
                            if (radioOpen.isChecked) {
                                finish()
                            } else if (radioDevelopment.isChecked && sharedList[i] == openList[childPosition]) {
                                sharedList[i].checkedList = "development"
                                Mys.todoList = sharedList
                                finish()
                            } else if (radioUploading.isChecked && sharedList[i] == openList[childPosition]) {
                                sharedList[i].checkedList = "uploading"
                                Mys.todoList = sharedList
                                finish()
                            } else if (radioReject.isChecked && sharedList[i] == openList[childPosition]) {
                                sharedList[i].checkedList = "reject"
                                Mys.todoList = sharedList
                                finish()
                            } else if (radioClosed.isChecked && sharedList[i] == openList[childPosition]) {
                                sharedList[i].checkedList = "closed"
                                Mys.todoList = sharedList
                                finish()
                            }
                        }

                        1 -> {
                            if (radioOpen.isChecked && sharedList[i] == developmentList[childPosition]) {
                                sharedList[i].checkedList = "open"
                                Mys.todoList = sharedList
                                finish()
                            } else if (radioDevelopment.isChecked) {
                                finish()
                            } else if (radioUploading.isChecked && sharedList[i] == developmentList[childPosition]) {
                                sharedList[i].checkedList = "uploading"
                                Mys.todoList = sharedList
                                finish()
                            } else if (radioReject.isChecked && sharedList[i] == developmentList[childPosition]) {
                                sharedList[i].checkedList = "reject"
                                Mys.todoList = sharedList
                                finish()
                            } else if (radioClosed.isChecked && sharedList[i] == developmentList[childPosition]) {
                                sharedList[i].checkedList = "closed"
                                Mys.todoList = sharedList
                                finish()
                            }
                        }

                        2 -> {
                            if (radioOpen.isChecked && sharedList[i] == uploadingList[childPosition]) {
                                sharedList[i].checkedList = "open"
                                Mys.todoList = sharedList
                                finish()
                            } else if (radioDevelopment.isChecked && sharedList[i] == uploadingList[childPosition]) {
                                sharedList[i].checkedList = "development"
                                Mys.todoList = sharedList
                                finish()
                            } else if (radioUploading.isChecked) {
                                finish()
                            } else if (radioReject.isChecked && sharedList[i] == uploadingList[childPosition]) {
                                sharedList[i].checkedList = "reject"
                                Mys.todoList = sharedList
                                finish()
                            } else if (radioClosed.isChecked && sharedList[i] == uploadingList[childPosition]) {
                                sharedList[i].checkedList = "closed"
                                Mys.todoList = sharedList
                                finish()
                            }
                        }

                        3 -> {
                            if (radioOpen.isChecked && sharedList[i] == rejectList[childPosition]) {
                                sharedList[i].checkedList = "open"
                                Mys.todoList = sharedList
                                finish()
                            } else if (radioDevelopment.isChecked && sharedList[i] == rejectList[childPosition]) {
                                sharedList[i].checkedList = "development"
                                Mys.todoList = sharedList
                                finish()
                            } else if (radioUploading.isChecked && sharedList[i] == rejectList[childPosition]) {
                                sharedList[i].checkedList = "uploading"
                                Mys.todoList = sharedList
                                finish()
                            } else if (radioReject.isChecked) {
                                finish()
                            } else if (radioClosed.isChecked && sharedList[i] == rejectList[childPosition]) {
                                sharedList[i].checkedList = "closed"
                                Mys.todoList = sharedList
                                finish()
                            }
                        }

                        4 -> {
                            if (radioOpen.isChecked && sharedList[i] == closedList[childPosition]) {
                                sharedList[i].checkedList = "open"
                                Mys.todoList = sharedList
                                finish()
                            } else if (radioDevelopment.isChecked && sharedList[i] == closedList[childPosition]) {
                                sharedList[i].checkedList = "development"
                                Mys.todoList = sharedList
                                finish()
                            } else if (radioUploading.isChecked && sharedList[i] == closedList[childPosition]) {
                                sharedList[i].checkedList = "uploading"
                                Mys.todoList = sharedList
                                finish()
                            } else if (radioReject.isChecked && sharedList[i] == closedList[childPosition]) {
                                sharedList[i].checkedList = "reject"
                                Mys.todoList = sharedList
                                finish()
                            } else if (radioClosed.isChecked) {
                                finish()
                            }
                        }
                    }
                }
            }
        }
    }
}