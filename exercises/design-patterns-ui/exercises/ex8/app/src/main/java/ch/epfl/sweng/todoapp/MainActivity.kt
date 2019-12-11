package ch.epfl.sweng.todoapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import ch.epfl.sweng.todoapp.models.DataStore
import ch.epfl.sweng.todoapp.models.TodoItem

class MainActivity : AppCompatActivity() {

    private lateinit var button: Button
    private lateinit var edit: EditText
    private lateinit var itemList: LinearLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button = findViewById(R.id.add_button) as Button
        edit = findViewById(R.id.new_item_field) as EditText

        button.setOnClickListener {
            if (!edit.text.isBlank()) {
                val todo = TodoItem(edit.getText().toString(), TodoItem.ItemStatus.CURRENT)
                store.list.add(todo)
                edit.setText("")
                addToUI(todo)
            }
        }
    }

    val store = DataStore()

    fun addToUI(todo: TodoItem) {
        val v = layoutInflater.inflate(R.layout.item_viewholder, null)

        val text = v.findViewById(R.id.item_text) as TextView
        text.text = todo.name

        val check = v.findViewById(R.id.item_checkbox) as CheckBox
        check.setOnClickListener {
            todo.status =
                if (check.isChecked()) TodoItem.ItemStatus.DONE else TodoItem.ItemStatus.CURRENT
        }

        val button = v.findViewById(R.id.item_delete_button) as Button
        button.setOnClickListener{
            val idx = store.list.indexOf(todo)
            itemList.removeViewAt(idx)
            store.list.remove(todo)
        }

        // clean: delete current text in field

        itemList.addView(v)
    }
}
