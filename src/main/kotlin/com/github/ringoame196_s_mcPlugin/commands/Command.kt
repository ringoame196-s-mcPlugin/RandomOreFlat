package com.github.ringoame196_s_mcPlugin.commands

import com.github.ringoame196_s_mcPlugin.Data
import com.github.ringoame196_s_mcPlugin.WorldManager
import org.bukkit.Bukkit
import org.bukkit.ChatColor
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.command.TabCompleter
import org.bukkit.entity.Player

class Command : CommandExecutor, TabCompleter {

    override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<out String>): Boolean {
        if (args.isEmpty()) return false
        if (sender is Player) {
            val world = when (args[0]) {
                // コマンドによって テレポート先を変更
                CommandConst.WARP_COMMAND -> Bukkit.getWorld(Data.RANDOM_ORE_WORLD_NAME)
                CommandConst.HOME_COMMAND -> Bukkit.getWorlds().first()
                else -> return false
            }
            WorldManager.teleportToWorld(sender, world)
        } else {
            val message = "${ChatColor.RED}このコマンドはプレイヤーのみ実行可能です"
            sender.sendMessage(message)
        }

        return true
    }

    override fun onTabComplete(commandSender: CommandSender, command: Command, label: String, args: Array<out String>): MutableList<String>? {
        return when (args.size) {
            1 -> mutableListOf(CommandConst.WARP_COMMAND, CommandConst.HOME_COMMAND)
            else -> mutableListOf()
        }
    }
}
