package modules

import resources.OutpostResource
import resources.ResourceManager

class ResearchLab: OutpostModule(
    name="Исследовательская лаборатория"
) {
    override fun performAction(manager: ResourceManager) : ModuleResult {
        val minerals = manager.get("Minerals")
        if (minerals==null || minerals.amount<30){
            println("Недостаточно минералов для исследования")
            return ModuleResult.NotEnoughResources(
                resourceName = "Minerals",
                required = 30,
                available = minerals?.amount ?: 0
            )
        }
        minerals.amount -= 30
        return ModuleResult.Success(message = "Исследование завершено")
    }
}
fun main(){
    val manager = ResourceManager()
    manager.add(OutpostResource(id=1, name="Minerals", amount = 120))
    manager.add(OutpostResource(id=2, name="Gas", amount = 40))
    val generator = EnergyGenerator()
    val lab = ResearchLab()
    generator.performAction(manager)
    lab.performAction(manager)
    println()
    manager.printAll()
}