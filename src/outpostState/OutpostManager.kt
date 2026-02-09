package outpostState

class OutpostManager {
    val resources = mutableListOf<ObservableResource>()
    init {
        println("Менеджер создан")
    }
}

val manager: OutpostManager by lazy {
    OutpostManager()
}