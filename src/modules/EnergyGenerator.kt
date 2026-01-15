package modules
import resources.OutpostResource
import resources.ResourceManager
class EnergyGenerator: OutpostModule(name="Генератор энергии") {
    override fun performAction(manager: ResourceManager) {
        println("Генератор работает... Производит 20 энергии")
        val energy = manager.get("Energy")
    }
}
