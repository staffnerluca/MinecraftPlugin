package org.test.improvedcombatsystem;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.io.NotActiveException;
import java.util.Arrays;
public class test implements Listener{
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        ItemStack bow = new ItemStack(Material.BOW);
        ItemMeta bmeta = bow.getItemMeta();
        bmeta.setLore(Arrays.asList("teleport"));
        bow.setItemMeta(bmeta);
        if(!hasItem(player, bow)){
            player.getInventory().addItem(bow);
        }

;       ItemStack flamebow = new ItemStack(Material.BOW);
        ItemMeta fbmeta = bow.getItemMeta();
        fbmeta.setLore(Arrays.asList("flames"));
        bow.setItemMeta(fbmeta);
        if(!hasItem(player, flamebow)){
            player.getInventory().addItem(flamebow);
        }

        ItemStack arrow = new ItemStack(Material.ARROW, 64);
        if(!hasItem(player, arrow)){
            player.getInventory().addItem(bow, arrow);
        }

        ItemStack deathBow = new ItemStack(Material.BOW);
        ItemMeta dMeta = deathBow.getItemMeta();
        dMeta.setLore(Arrays.asList("death"));
        if(!hasItem(player, deathBow)){
            player.getInventory().addItem(deathBow);
        }

        ItemStack stick = new ItemStack(Material.STICK);
        ItemMeta smeta = stick.getItemMeta();
        smeta.setLore(Arrays.asList("shield"));
        stick.setItemMeta(smeta);
        if(!hasItem(player, stick)){
            player.getInventory().addItem(stick);
        }

        ItemStack irSwordExpl = new ItemStack(Material.IRON_SWORD);
        ItemMeta irSwordExplMeta = irSwordExpl.getItemMeta();
        irSwordExplMeta.setLore(Arrays.asList("explosion"));
        if(!hasItem(player, irSwordExpl)){
            player.getInventory().addItem(irSwordExpl);
        }

        ItemStack irSwordDeath = new ItemStack(Material.IRON_SWORD);
        ItemMeta irSwordDeathlMeta = irSwordExpl.getItemMeta();
        irSwordDeathlMeta.setLore(Arrays.asList("death"));
        if(!hasItem(player, irSwordDeath)){
            player.getInventory().addItem(irSwordDeath);
        }

        ItemStack irSwordLight = new ItemStack(Material.IRON_SWORD);
        ItemMeta irSwordLightMeta = irSwordExpl.getItemMeta();
        irSwordLightMeta.setLore(Arrays.asList("lightning"));
        if(!hasItem(player, irSwordLight)){
            player.getInventory().addItem(irSwordLight);
        }
    }

    public boolean hasItem(Player p, ItemStack it){
        if(it == null){
            return false;
        }
        for(ItemStack i: p.getInventory().getContents()){
            if(i != null && i.isSimilar(it)){
                return true;
            }
        }
        return false;
    }
}
