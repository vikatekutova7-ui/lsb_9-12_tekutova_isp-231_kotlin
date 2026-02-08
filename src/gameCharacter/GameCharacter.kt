package gameCharacter

class GameCharacter(val name: String) {
    var currentState: CharacterState = CharacterState.Idle
    fun changeState(state: CharacterState) {
        currentState = state
        handleState()
    }
    fun handleState() {
        when (currentState) {
            CharacterState.Idle -> println("$name бездействует")
            CharacterState.Running -> println("$name бежит")
            is CharacterState.Attacking -> println("$name атакует с уроном ${(currentState as CharacterState.Attacking).damage}")
            is CharacterState.Dead -> println("$name погиб: ${(currentState as CharacterState.Dead).reason}")
        }
    }
}