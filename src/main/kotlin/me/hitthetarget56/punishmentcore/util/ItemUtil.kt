package me.hitthetarget56.punishmentcore.util

import org.bukkit.Material
import org.bukkit.inventory.ItemStack

/**
 * PunishmentCore
 *
 * @author Hitthetarget56 (https://github.com/Hitthetarget55)
 * 31/07/2021 at 20:06
 */

fun named(material: Material, name: String): ItemStack {
    val item = ItemStack(material)
    val meta = item.itemMeta
    meta?.setDisplayName(name)
    item.itemMeta = meta
    return item
}
fun namedWithLore(material: Material, name: String, vararg lore: String): ItemStack{
    val item = ItemStack(material)
    val meta = item.itemMeta
    meta?.setDisplayName(name)
    meta?.lore = lore.toList()
    item.itemMeta = meta
    return item
}