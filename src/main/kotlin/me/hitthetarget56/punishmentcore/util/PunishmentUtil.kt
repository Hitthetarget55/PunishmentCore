package me.hitthetarget56.punishmentcore.util

import me.hitthetarget56.punishmentcore.util.storage.PunishmentTable
import me.hitthetarget56.punishmentcore.util.storage.PunishmentTable.target
import org.bukkit.entity.Player
import org.jetbrains.exposed.sql.insert
import org.jetbrains.exposed.sql.select
import org.jetbrains.exposed.sql.transactions.transaction

/**
 * PunishmentCore
 *
 * @author Hitthetarget56 (https://github.com/Hitthetarget55)
 * 31/07/2021 at 18:49
 */


fun Int.convertIntToType(): PunishmentType {
    return when(this){
        1 -> PunishmentType.BAN
        2 -> PunishmentType.MUTE
        3 -> PunishmentType.KICK
        4 -> PunishmentType.IPBAN
        else -> PunishmentType.BAN
    }
}

fun intFromPunishmentType(type: PunishmentType): Int {
    return when(type){
        PunishmentType.BAN -> 1
        PunishmentType.MUTE -> 2
        PunishmentType.KICK -> 3
        PunishmentType.IPBAN -> 4
        else -> 1
    }
}

fun Player.addPunishment(punishment: Punishment){
    transaction {
        PunishmentTable.insert {
            it[id] = punishment.id
            it[target] = punishment.target
            it[mod] = punishment.mod
            it[reason] = punishment.reason
            it[expired] = punishment.expired
            it[addedOn] = punishment.addedOn
            it[type] = intFromPunishmentType(punishment.type)
        }
    }
}

// TODO: add function to remove punishments

fun Player.getHistory(): List<Punishment> {
    val toReturn = mutableListOf<Punishment>()
    transaction {
        PunishmentTable.select { PunishmentTable.target eq this@getHistory.uniqueId.toString() }.forEach {
            toReturn.add(Punishment(
                it[PunishmentTable.id],
                it[PunishmentTable.target],
                it[PunishmentTable.mod],
                it[PunishmentTable.reason],
                it[PunishmentTable.expired],
                it[PunishmentTable.addedOn],
                it[PunishmentTable.type].convertIntToType()
            ))
        }
    }
    return toReturn.toList()
}

fun Player.isBanned(): Boolean {
    return this.getHistory().filter { !it.expired && it.type == PunishmentType.BAN }.isNotEmpty()
}

fun Player.getActivePunishments(): List<Punishment> {
    return this.getHistory().filter { !it.expired }.toList()
}
