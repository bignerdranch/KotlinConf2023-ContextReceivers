package com.bignerdranch.nyethack

lateinit var player: Player

fun main() {
    narrate("Welcome to NyetHack!")
    val playerName = promptHeroName()
    player = Player(playerName)
    changeNarratorMood()

    val game = Game()
    with(game) {
        startGame()
    }
}

private fun promptHeroName(): String {
    narrate("A hero enters the town of Kronstadt. What is their name?") { message ->
        // Prints the message in yellow
        "\u001b[33;1m$message\u001b[0m"
    }

    val input = readln()
    require(input.isNotEmpty()) {
        "The hero must have a name."
    }

    return input
}

context(Game)
private fun startGame() {
    narrate("Welcome, adventurer")
    val mortality = if (player.isImmortal) "an immortal" else "a mortal"
    narrate("${player.name}, $mortality, has ${player.healthPoints} health points")

    play()
}