package outpostState

fun main() {
    val observer = ResourceObserver()
    val minerals = ObservableResource("Minerals", 100, observer)
    val energy = ObservableResource("Energy", 50, observer)
    manager.resources.add(minerals)
    manager.resources.add(energy)
    minerals.amount += 20
    energy.amount += 30
    StateStorage.save(manager.resources)
    println("\nЗагруженное состояние:")
    StateStorage.load(observer).forEach {
        println("${it.name}: ${it.amount}")
    }
}
