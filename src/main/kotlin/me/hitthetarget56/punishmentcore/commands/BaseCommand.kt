package me.hitthetarget56.punishmentcore.commands

import org.bukkit.command.CommandSender
import org.bukkit.command.defaults.BukkitCommand

/**
 * PunishmentCore
 *
 * @author Hitthetarget56 (https://github.com/Hitthetarget55)
 * 31/07/2021 at 18:50
 */
sealed class BaseCommand(
    name: String,
    description: String = "No description provided.",
    usage: String = "/<command>",
    aliases: List<String> = listOf()
) : BukkitCommand(name, description, usage, aliases) {
    final override fun execute(sender: CommandSender, label: String, args: Array<String>): Boolean {
        return exec(sender, label, args)
    }
    abstract fun exec(sender: CommandSender, label: String, args: Array<String>): Boolean

}