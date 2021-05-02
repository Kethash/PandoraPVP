package com.pandora.Kettash.pandorapvp.main;

import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.attribute.Attribute;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerJoinEvent;

public class OldPvp implements Listener {
    @EventHandler
    public void oldAttackSpeed(PlayerJoinEvent e)
    {
        Player p = e.getPlayer();

        p.getAttribute(Attribute.GENERIC_ATTACK_SPEED).setBaseValue(16);
    }


    @EventHandler
    public void onEntityDamageEntityEvent (EntityDamageByEntityEvent e) {

        EntityDamageEvent.DamageCause sweepDamageCause;

        if (e.getDamager() instanceof Player) {
            Player p = (Player) e.getDamager();

            if(isHoldingSword(p.getInventory().getItemInMainHand().getType()))
            {
                try{
                    // Will be available from some 1.11 version onwards
                    sweepDamageCause = EntityDamageEvent.DamageCause.valueOf("ENTITY_SWEEP_ATTACK");
                } catch(IllegalArgumentException ex){
                    sweepDamageCause = null;
                }

                if(sweepDamageCause != null){
                    if(e.getCause() == sweepDamageCause){
                        e.setCancelled(true);
                        p.stopSound(Sound.ENTITY_PLAYER_ATTACK_SWEEP);
                    }
                    // sweep attack detected or not, we do not need to fall back to the guessing implementation
                    return;
                }
            } else {
                switch (p.getInventory().getItemInMainHand().getType()) {
                    case WOODEN_AXE:
                        e.setDamage(DamageReducer(4, e.getDamage()));
                        break;
                    case STONE_AXE:
                        e.setDamage(DamageReducer(6, e.getDamage()));
                        break;
                    case IRON_AXE:
                        e.setDamage(DamageReducer(6, e.getDamage()));
                        break;
                    case GOLDEN_AXE:
                        e.setDamage(DamageReducer(4, e.getDamage()));
                        break;
                    case DIAMOND_AXE:
                        e.setDamage(DamageReducer(6, e.getDamage()));
                        break;
                    case NETHERITE_AXE:
                        e.setDamage(DamageReducer(7, e.getDamage()));
                        break;
                }
            }



        }
    }

    public Double DamageReducer(int i, double damage) {

        return damage - i;
    }

    public boolean isHoldingSword(Material type)
    {
        switch(type)
        {
            case WOODEN_SWORD:
                return true;

            case STONE_SWORD:
                return true;

            case IRON_SWORD:
                return true;

            case GOLDEN_SWORD:
                return true;

            case DIAMOND_SWORD:
                return true;

            case NETHERITE_SWORD:
                return true;
        }
        return false;
    }
}
