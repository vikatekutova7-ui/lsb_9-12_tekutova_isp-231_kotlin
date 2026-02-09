import modules.EnergyGenerator
import modules.ModuleResult
import modules.ResearchLab
import resources.OutpostResource
import resources.ResourceManager

fun handleModuleResult(result: ModuleResult) {
    when (result) {
        is ModuleResult.Success ->
            println("УСПЕХ: ${result.message}")
        is ModuleResult.ResourceProduced ->
            println("Произведено: ${result.resourceName} +${result.amount}")
        is ModuleResult.NotEnoughResources ->
            println("Недостаточно ресурса ${result.resourceName}. Нужно: ${result.required}, есть: ${result.available}")
        is ModuleResult.Error ->
            println("ОШИБКА: ${result.reason}")
    }
}

object SystemLogger{
    init {
        println("SystemLogger инициализирован")
    }
    fun log(message: String){
        println("[LOG] $message")
    }
}

val logger by lazy {
    SystemLogger
}

fun main() {
//    val manager = resources.ResourceManager()
//    val minerals = OutpostResource(1, "Minerals", 300)
//    val gas = OutpostResource(2, "Gas", 100)
//    manager.add(minerals)
//    manager.add(gas)
//    manager.printAll()
//    val bonus = minerals.copy(amount = minerals.amount + 50)
//    println("Копия минералов с бонусом: $bonus")
    logger.log("Запуск базы")
    val manager = ResourceManager()
    manager.add(OutpostResource(1, "Minerals", 120))
    manager.add(OutpostResource(2, "Gas", 40))
    val generator = EnergyGenerator()
    val lab = ResearchLab()
    generator.performAction(manager)
    lab.performAction(manager)
    println()
    manager.printAll()
    val generatorResult = generator.performAction(manager)
    val labResult = lab.performAction(manager)
    handleModuleResult(generatorResult)
    handleModuleResult(labResult)
    println()
    manager.printAll()
    val loadedResources = FileStorage.load()
    loadedResources.forEach { manager.add(it)
    manager.add(OutpostResource(1,"Minerals", 300))
    manager.add(OutpostResource(2,"Gas", 100))
    }
    FileStorage.save(manager.getAll())
}