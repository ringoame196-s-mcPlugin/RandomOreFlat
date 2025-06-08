package com.github.ringoame196_s_mcPlugin

import com.github.ringoame196_s_mcPlugin.commands.Command
import org.bukkit.plugin.java.JavaPlugin

class Main : JavaPlugin() {
    private val plugin = this
    override fun onEnable() {
        super.onEnable()
        RandomOreFlatWorldManager.createWorld()
        val command = getCommand("randomoreflat")
        command!!.setExecutor(Command())
    }
}
