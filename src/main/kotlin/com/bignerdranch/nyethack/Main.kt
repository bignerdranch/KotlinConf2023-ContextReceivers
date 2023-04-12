package com.bignerdranch.nyethack

fun main() {
    narrate("Welcome to NyetHack!")
    val playerName = promptHeroName()
    val player = Player(playerName)
    changeNarratorMood()

    val game = Game()
    with(game) {
        val playerContext = object : PlayerContext {
            override val player = player
        }
        with(playerContext) {
            startGame()
        }
    }
}

interface PlayerContext {
    val player: Player
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

context(Game, PlayerContext)
private fun startGame() {
    narrate("Welcome, adventurer")
    val mortality = if (player.isImmortal) "an immortal" else "a mortal"
    narrate("${player.name}, $mortality, has ${player.healthPoints} health points")

    while (true) {
        narrate("${player.name} of ${player.hometown}, ${player.title}, is in ${currentRoom.description()}")
        currentRoom.enterRoom()

        print("> Enter your command: ")
        Game.GameInput(readln()).processCommand()
    }
}