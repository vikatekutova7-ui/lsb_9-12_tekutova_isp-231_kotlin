package gameCharacter

fun main() {
    val hero = GameCharacter("Персонаж")
    hero.changeState(CharacterState.Idle)
    hero.changeState(CharacterState.Running)
    hero.changeState(CharacterState.Attacking(50))
    hero.changeState(CharacterState.Dead("упал в пропасть"))
}