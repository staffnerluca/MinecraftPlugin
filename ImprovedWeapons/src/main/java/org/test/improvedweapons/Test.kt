package org.test.improvedweapons

import org.bukkit.Material
import org.bukkit.entity.Player
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerJoinEvent
import org.bukkit.inventory.ItemStack

class Test : Listener {
    @EventHandler
    fun onPlayerJoin(event: PlayerJoinEvent) {
        val player = event.player
        val bow = ItemStack(Material.BOW)
        val bmeta = bow.itemMeta
        bmeta!!.lore = mutableListOf("teleport")
        bow.setItemMeta(bmeta)
        if (!hasItem(player, bow)) {
            player.inventory.addItem(bow)
        }
        val flamebow = ItemStack(Material.BOW)
        val fbmeta = bow.itemMeta
        fbmeta!!.lore = mutableListOf("flames")
        bow.setItemMeta(fbmeta)
        if (!hasItem(player, flamebow)) {
            player.inventory.addItem(flamebow)
        }
        val arrow = ItemStack(Material.ARROW, 64)
        if (!hasItem(player, arrow)) {
            player.inventory.addItem(bow, arrow)
        }
        val deathBow = ItemStack(Material.BOW)
        val dMeta = deathBow.itemMeta
        dMeta!!.lore = mutableListOf("death")
        if (!hasItem(player, deathBow)) {
            player.inventory.addItem(deathBow)
        }
        val stick = ItemStack(Material.STICK)
        val smeta = stick.itemMeta
        smeta!!.lore = mutableListOf("shield")
        stick.setItemMeta(smeta)
        if (!hasItem(player, stick)) {
            player.inventory.addItem(stick)
        }
        val irSwordExpl = ItemStack(Material.IRON_SWORD)
        val irSwordExplMeta = irSwordExpl.itemMeta
        irSwordExplMeta!!.lore = mutableListOf("explosion")
        if (!hasItem(player, irSwordExpl)) {
            player.inventory.addItem(irSwordExpl)
        }
        val irSwordDeath = ItemStack(Material.IRON_SWORD)
        val irSwordDeathlMeta = irSwordExpl.itemMeta
        irSwordDeathlMeta!!.lore = mutableListOf("death")
        if (!hasItem(player, irSwordDeath)) {
            player.inventory.addItem(irSwordDeath)
        }
        val irSwordLight = ItemStack(Material.IRON_SWORD)
        val irSwordLightMeta = irSwordExpl.itemMeta
        irSwordLightMeta!!.lore = mutableListOf("lightning")
        if (!hasItem(player, irSwordLight)) {
            player.inventory.addItem(irSwordLight)
        }
    }

    fun hasItem(p: Player, it: ItemStack?): Boolean {
        if (it == null) {
            return false
        }
        for (i in p.inventory.contents) {
            if (i != null && i.isSimilar(it)) {
                return true
            }
        }
        return false
    }
}