package com.github.ringoame196_s_mcPlugin

import org.bukkit.Bukkit
import org.bukkit.Difficulty
import org.bukkit.GameRule
import org.bukkit.WorldCreator

object RandomOreFlatWorldManager {
    fun createWorld() {
        val creator = WorldCreator(Data.RANDOM_ORE_WORLD_NAME)
        creator.generator(RandomOreFlatWorldChunkGenerator())
        Bukkit.createWorld(creator)

        // ワールドの難易度を上げる
        val world = Bukkit.getWorld(Data.RANDOM_ORE_WORLD_NAME) ?: return
        world.difficulty = Difficulty.HARD
        world.setGameRule(GameRule.DO_DAYLIGHT_CYCLE, false)
        world.time = 18000
    }
}
