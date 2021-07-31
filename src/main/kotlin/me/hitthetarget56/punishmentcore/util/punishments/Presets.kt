package me.hitthetarget56.punishmentcore.util.punishments

import me.hitthetarget56.punishmentcore.PunishmentCore
import me.hitthetarget56.punishmentcore.util.named
import me.hitthetarget56.punishmentcore.util.namedWithLore
import me.hitthetarget56.punishmentcore.util.toPunishmentType
import org.bukkit.Material
import org.bukkit.inventory.Inventory

/**
 * PunishmentCore
 *
 * @author Hitthetarget56 (https://github.com/Hitthetarget55)
 * 31/07/2021 at 20:02
 */

fun addPresets(inventory: Inventory){
    PunishmentCore.instance.config.getConfigurationSection("presets")?.getKeys(false)?.forEach {
        val reason = PunishmentCore.instance.config.getString("presets.${it}.reason")
        val type = PunishmentCore.instance.config.getString("presets.${it}.reason")?.toPunishmentType()
        // TODO: parse duration token
        val lore = PunishmentCore.instance.config.getStringList("presets.${it}.lore").toTypedArray()
        val item = namedWithLore(Material.ENDER_CHEST, reason!!, *lore) // spread to vararg
        inventory.addItem(item)
    }
}
