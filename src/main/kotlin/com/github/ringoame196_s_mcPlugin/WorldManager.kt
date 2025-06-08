package com.github.ringoame196_s_mcPlugin

import org.bukkit.ChatColor
import org.bukkit.World
import org.bukkit.entity.Player

object WorldManager {
    fun teleportToWorld(player: Player, world: World?) {
        if (world != null) {
            val spawnLocation = world.spawnLocation
            val message = "${ChatColor.GOLD}${world.name}にテレポートします"
            player.teleport(spawnLocation)
            player.sendMessage(message)
        } else {
            val message = "${ChatColor.RED}ワールドが見つかりませんでした"
            player.sendMessage(message)
        }
    }
}
