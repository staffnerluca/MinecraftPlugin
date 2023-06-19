package org.test.improvedcombatsystem
import org.bukkit.Material
import org.bukkit.World
import org.bukkit.entity.Creature
import org.bukkit.entity.Entity
import org.bukkit.entity.EntityType
import org.bukkit.entity.LivingEntity
import org.bukkit.entity.Player
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.entity.EntityDamageByEntityEvent
import org.bukkit.inventory.ItemStack
import java.util.Random

//I decided to implement this class in Kotlin, because I wanted to try something new and my little brother asked me how Kotlin works so I had to learn it
class SwordImproved: Listener{
    @EventHandler
    fun onSwordHit(event: EntityDamageByEntityEvent){
        var victim = event.entity
        if(event.damager is Player){
            var player = event.entity as Player
            val weapon = player.inventory.itemInMainHand
            val world = player.world
            if(isSword(weapon.type)){
                if(isX(weapon,"explosion")){
                    player = createExpl(player)
                }
                else if(isX(weapon, "death")){
                    deathHit(player, victim)
                }
                else if(isX(weapon, "lightning")){
                    lightningHit(victim)
                }
                else if(isX(weapon, "toVillager")){
                    toVillager(victim, world)
                }
            }
        }
    }
    //? means nullable variable
    fun isX(item: ItemStack?, type: String?): Boolean {
        if (item == null) {
            return false
        }
        val meta = item.itemMeta
        if (meta != null && meta.hasLore()) {
            try {
                //!! throws excepton if the value is null
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

    private fun isSword(mat: Material?): Boolean{
        var isSword: Boolean = false
        if(mat == Material.WOODEN_SWORD){
            isSword = true
        }
        else if(mat == Material.STONE_SWORD){
            isSword = true
        }
        else if(mat == Material.IRON_SWORD){
            isSword = true
        }
        else if(mat == Material.DIAMOND_SWORD){
            isSword = true
        }
        return isSword
    }

    private fun createExpl(player: Player): Player{
        val world = player.world
        var health = player.health
        world.createExplosion(player.location, 10.0F)
        player.health = health
        return player
    }

    private fun deathHit(player: Player, ent: Entity){
        val rand = Random()
        val num = rand.nextInt(3)
        if(num == 0){
            player.health = 0.0
        }
        else{
            if(ent is Player)
                ent.health = 0.0
            else if(ent.type.isAlive && ent.type.isSpawnable){
                val e = ent as Creature
                e.health = 0.0
            }
        }
    }

    private fun lightningHit(ent: Entity){
        val loc = ent.location
        val world = ent.world
        world.strikeLightning(loc)
    }

    private fun toVillager(ent: Entity, world: World){
        val loc = ent.location
        if(ent is LivingEntity && !ent.isDead){
            ent.remove()
            world.spawnEntity(loc, EntityType.VILLAGER)
        }
    }
}