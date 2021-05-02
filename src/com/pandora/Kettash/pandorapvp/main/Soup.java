package com.pandora.Kettash.pandorapvp.main;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

public class Soup implements Listener {
    @EventHandler
    public void onRightClickSoup(PlayerInteractEvent e)
    {
        Player p = e.getPlayer();

        ItemStack soup = new ItemStack(Material.MUSHROOM_STEW);



        ItemStack bowl = new ItemStack(Material.BOWL);


        if((e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK) && (p.getInventory().getItemInMainHand().equals(soup))){
            if(p.getFoodLevel() < 20)
            {
                if(p.getFoodLevel() > 14)
                {
                    p.setFoodLevel(20);
                } else {
                    p.setFoodLevel(p.getFoodLevel() + 6);
                }

                p.getInventory().setItemInMainHand(bowl);
            }
            else if(p.getHealth() < 20) {
                if(p.getHealth() > 14)
                {
                    p.setHealth(20);
                } else {
                    p.setHealth(p.getHealth() + 6);
                }
                p.getInventory().setItemInMainHand(bowl);
            }

        }
    }

}
