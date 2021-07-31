package me.hitthetarget56.punishmentcore.util.storage

import org.jetbrains.exposed.sql.Table

/**
 * PunishmentCore
 *
 * @author Hitthetarget56 (https://github.com/Hitthetarget55)
 * 31/07/2021 at 18:49
 */
object PunishmentTable : Table() {

    val id = varchar("id", 5)
    val target = varchar("target", 36)
    val mod = varchar("mod", 36)
    val reason = text("reason")
    val expired = bool("expired")
    val addedOn = long("addedOn")
    val type = integer("type")

    /*
    * 1 - ban
    * 2 - mute
    * 3 - kick
    * 4 - ipban
     */

}