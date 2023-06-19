package org.test.improvedweapons

import org.bukkit.entity.Arrow
import org.bukkit.entity.Fireball
import org.bukkit.entity.Player
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.entity.ProjectileHitEvent
import org.bukkit.inventory.ItemStack
import java.util.*

class BowImproved : Listener {
    //Code piece is too large. Refactoring needed
    @EventHandler
    fun onProjectileHit(event: ProjectileHitEvent) {
        if (event.entity is Arrow) {
            val arrow = event.entity as Arrow
            if (arrow.shooter is Player) {
                val shooter = arrow.shooter as Player?
                if (isX(shooter!!.inventory.itemInMainHand, "teleport")) {
                    if (event.hitBlock != null) {
                        val blockLocation = event.hitBlock!!.location
                        shooter.teleport(blockLocation)
                    }
                }
                else if (isX(shooter.inventory.itemInMainHand, "flames")) {
                    val location = arrow.location
                    val velocity = arrow.velocity
                    val fireball = location.world!!.spawn(location, Fireball::class.java)
                    fireball.direction = velocity
                    fireball.shooter = shooter
                    arrow.remove()
                }
                else if (isX(shooter.inventory.itemInMainHand, "death")) {
                    val r = Random()
                    val rand = r.nextInt(2)
                    if (rand != 0) {
                        arrow.damage = 100000000000000.0
                    } else {
                        shooter.health = 0.0
                    }
                }
            }
        }
    }

    fun isX(item: ItemStack?, type: String?): Boolean {
        if (item == null) {
            return false
        }
        val meta = item.itemMeta
        if (meta != null && meta.hasLore()) {
            try {
                for (l in meta.lore!!) {
                    if (l.contains(type!!)) {
                        return true
                    }
                }
            } catch (ex: NullPointerException) {
                return false
            }
        }
        return false
    }
}