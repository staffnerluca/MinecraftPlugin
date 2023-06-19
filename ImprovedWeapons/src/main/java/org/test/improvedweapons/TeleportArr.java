package org.test.improvedcombatsystem;

import org.bukkit.entity.Fireball;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Player;
import org.bukkit.Location;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.util.Vector;

import java.util.Random;

public class TeleportArr implements Listener {
    //Code piece is too large. Refactoring needed
    @EventHandler
    public void onProjectileHit(ProjectileHitEvent event) {
        if (event.getEntity() instanceof Arrow) {
            Arrow arrow = (Arrow) event.getEntity();
            if(arrow.getShooter() instanceof Player){
                Player shooter = (Player) arrow.getShooter();
                if(isX(shooter.getInventory().getItemInMainHand(), "teleport")){
                    if (event.getHitBlock() != null) {
                        Location blockLocation = event.getHitBlock().getLocation();
                        shooter.teleport(blockLocation);
                    }
                }
                else if(isX(shooter.getInventory().getItemInMainHand(), "flames")){
                    Location location = arrow.getLocation();
                    Vector velocity = arrow.getVelocity();
                    Fireball fireball = location.getWorld().spawn(location, Fireball.class);
                    fireball.setDirection(velocity);
                    fireball.setShooter(shooter);
                    arrow.remove();
                }
                else if(isX(shooter.getInventory().getItemInMainHand(), "death")){
                    Random r = new Random();
                    int rand = r.nextInt(2);
                    if(rand != 0){
                        arrow.setDamage(100000000000000.0);
                    }
                    else{
                        shooter.setHealth(0.0);
                    }
                }
            }
        }
    }

    public boolean isX(ItemStack item, String type) {
        if (item == null) {
            return false;
        }
        ItemMeta meta = item.getItemMeta();
        if (meta != null && meta.hasLore()) {
            try {
                for (String l : meta.getLore()) {
                    if (l.contains(type)) {
                        return true;
                    }
                }
            } catch (NullPointerException ex) {
                return false;
            }
        }
        return false;
    }
}
