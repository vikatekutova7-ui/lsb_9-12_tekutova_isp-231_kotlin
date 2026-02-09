package outpostState

class ResourceObserver {
    fun onChange(name: String, old: Int, new: Int) {
        println("Наблюдатель: $name изменился: $old → $new")
    }
}