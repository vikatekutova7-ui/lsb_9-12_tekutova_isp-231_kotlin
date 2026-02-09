package outpostState
import java.io.File

object StateStorage {
    private const val FILE_NAME = "outpostState.txt"
    fun save(resources: List<ObservableResource>) {
        val file = File(FILE_NAME)
        file.writeText(
            text = resources.joinToString("\n") {
                "${it.name};${it.amount}"
            }
        )
        println("Состояние базы сохранено в файл")
    }
    fun load(observer: ResourceObserver): List<ObservableResource> {
        val file = File(FILE_NAME)
        if (!file.exists()) return emptyList()
        println("Загрузка состояния базы из файла")
        return file.readLines().map { line ->
            val (name, amount) = line.split(";")
            ObservableResource(name, amount.toInt(), observer)
        }
    }
}