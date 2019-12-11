package ch.epfl.sweng.todoapp.models

class TodoItem(val name: String, status: ItemStatus){

    enum class ItemStatus{
        CURRENT,
        DONE
    }

    var status = ItemStatus.CURRENT
        set(value) {
            field = value
        }
        get
}