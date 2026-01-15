package example

interface Movable{
    var speed: Int
    val model: String
    val number: String
    fun move()
    fun stop(){
        println("Останавливаемся...")
    }
}
interface Worker{
    fun work()
}
interface Student{
    fun study()
}
interface VideoPlayable{
    fun play() = println("Play video")
}
interface AudioPlayable{
    fun play() = println("Play audio")
}
class MediaPlayer: VideoPlayable, AudioPlayable{
    override fun play() = println("Play audio and video")
}
class Car(
    override val number: String,
    override val model: String
): Movable{
    override var speed = 60
        set(value) {}
    override fun move() {
        println("Едем на машине со скоростью $speed км/ч")
    }
}
class Aircraft(
    override val number: String,
    override val model: String
): Movable{
    override var speed = 600
    override fun move() {
        println("Летим на самолете со скоростью $speed км/ч")
    }
    override fun stop() = println("Приземляемся...")
}
class WorkingStudent(val name: String): Worker, Student{
    override fun work()=println("$name работает")
    override fun study()=println("$name учится")
}


fun main(){
    val player = MediaPlayer()
    player.play()
    val pavel = WorkingStudent(name = "Pavel")
    pavel.work()
    pavel.study()

    val car: Movable = Car(model = "LADA", number = "134LAD")
    val aircraft:Movable = Aircraft(model = "Boeing", number = "737 ")
    travel(obj = car)
    travel(obj = aircraft)
    aircraft.move()
    aircraft.stop()
}
fun travel(obj:Movable)=obj.move()
