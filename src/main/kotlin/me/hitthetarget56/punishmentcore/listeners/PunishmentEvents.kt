package me.hitthetarget56.punishmentcore.listeners

import me.hitthetarget56.punishmentcore.util.hasActiveBan
import org.bukkit.event.EventHandler
import org.bukkit.event.player.AsyncPlayerPreLoginEvent
import org.bukkit.event.player.PlayerJoinEvent


/**
 * PunishmentCore
 *
 * @author Hitthetarget56 (https://github.com/Hitthetarget55)
 * 31/07/2021 at 19:43
 */
object PunishmentEvents : BaseListener {
    @EventHandler
    fun onJoin(event: AsyncPlayerPreLoginEvent){
        if(event.uniqueId.hasActiveBan()){
            event.disallow(AsyncPlayerPreLoginEvent.Result.KICK_OTHER, "You are banned from this server") // TODO: generate ban message
        }
    }

    // TODO: mute checker

}