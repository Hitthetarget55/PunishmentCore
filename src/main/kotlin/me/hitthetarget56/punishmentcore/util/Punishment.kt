package me.hitthetarget56.punishmentcore.util

/**
 * PunishmentCore
 *
 * @author Hitthetarget56 (https://github.com/Hitthetarget55)
 * 31/07/2021 at 19:07
 */
class Punishment(
    val id: String, // Randomly generated NanoID
    val target: String,
    val mod: String,
    val reason: String,
    val expired: Boolean,
    val addedOn: Long,
    val type: PunishmentType
) {
}