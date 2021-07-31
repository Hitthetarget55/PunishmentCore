package me.hitthetarget56.punishmentcore.commands

import org.bukkit.ChatColor
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player

/**
 * @author Josh Becconsall (https://github.com/ignJosh)
 * @Date 31/07/2021 22:51
 */
object PunishCommand : BaseCommand (
    name = "punish",
    "/<command> <player>"
        ) {
    override fun exec(sender: CommandSender, label: String, args: Array<String>): Boolean {
        if (sender !is Player) sender.sendMessage("${ChatColor.RED}Only players can run this command!").let { false }
        val player = sender as Player
        if (args.size != 2) sender.sendMessage("${ChatColor.RED}${this.usage}").let { false }

        return true
    }
}