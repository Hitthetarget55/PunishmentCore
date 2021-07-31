package me.hitthetarget56.punishmentcore

import me.hitthetarget56.punishmentcore.commands.BaseCommand
import me.hitthetarget56.punishmentcore.listeners.BaseListener
import me.hitthetarget56.punishmentcore.util.storage.PunishmentTable
import org.bukkit.Bukkit
import org.bukkit.command.CommandMap
import org.bukkit.plugin.java.JavaPlugin
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.SchemaUtils

class PunishmentCore : JavaPlugin() {

    companion object {
        lateinit var instance: PunishmentCore
    }

    override fun onEnable() {
        instance = this
        // Getting all subclasses of the BaseCommand (that extend BaseCommand) and mapping them with the object instance to get the BukkitCommand
        // Then I am getting the servers command map to automatically register them in here and the plugin.yml.
        val commandMapField = Bukkit.getServer().javaClass.getDeclaredField("commandMap")
        commandMapField.isAccessible = true
        val commandMap: CommandMap = commandMapField.get(Bukkit.getServer()) as CommandMap
        BaseCommand::class.sealedSubclasses.map { it.objectInstance!! }.forEach {
            commandMap.register(name, it)
        }
        // Doing the same with the listeners
        BaseListener::class.sealedSubclasses.forEach {
            server.pluginManager.registerEvents(it.objectInstance!!, this)
        }
        config.options().copyDefaults()
        saveDefaultConfig()

        val host = config.getString("database.host")
        val username = config.getString("database.username")
        val password = config.getString("database.password")

        if(host != null && username != null && password != null){
            Database.connect(host, driver = "com.mysql.jdbc.Driver", user = username, password = password)
            SchemaUtils.create(PunishmentTable)
        }




    }

}