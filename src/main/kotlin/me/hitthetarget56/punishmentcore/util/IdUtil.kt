package me.hitthetarget56.punishmentcore.util

import com.aventrix.jnanoid.jnanoid.NanoIdUtils
import java.util.*


/**
 * PunishmentCore
 *
 * @author Hitthetarget56 (https://github.com/Hitthetarget55)
 * 31/07/2021 at 19:09
 */


fun generateRandomId(): String{
    val random = Random()
    val alphabet = charArrayOf('1', '2', '3', '4', '5', '6', '7', '8', '9')
    val size = 5 // Don't change
    return NanoIdUtils.randomNanoId(random, alphabet, size)
}


