package com.github.ringoame196_s_mcPlugin

import org.bukkit.Bukkit
import org.bukkit.WorldCreator

object RandomOreFlatWorldManager {
    fun createWorld() {
        val creator = WorldCreator(Data.RANDOM_ORE_WORLD_NAME)
        creator.generator(RandomOreFlatWorldChunkGenerator())
        Bukkit.createWorld(creator)
    }
}
