package me.hitthetarget56.punishmentcore.guis

import de.themoep.inventorygui.InventoryGui
import me.hitthetarget56.punishmentcore.PunishmentCore
import me.hitthetarget56.punishmentcore.util.Punishment
import org.bukkit.ChatColor
import org.bukkit.entity.Player

/**
 * @author Josh Becconsall (https://github.com/ignJosh)
 * @Date 31/07/2021 23:00
 */
class MainMenu {


    fun Player.openMainMenu() {

        var layout = arrayOf(
            "  s i z  ",
            "  ggggg  ",
            "  fpdnl  "
        )

        val gui = InventoryGui(PunishmentCore.instance, this, "${ChatColor.GRAY}Punishing ${player?.name}", layout)


    }



}