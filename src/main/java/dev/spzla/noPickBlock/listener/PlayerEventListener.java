package dev.spzla.noPickBlock.listener;

import io.papermc.paper.event.player.PlayerPickBlockEvent;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

import java.util.Locale;

public class PlayerEventListener implements Listener {

    private static final String BYPASS = "nopickblock.bypass";
    private static final String BLOCK_PREFIX = "nopickblock.deny.block.";
    private static final String DATA_PREFIX = "nopickblock.deny.data.";

    @EventHandler(ignoreCancelled = true)
    public void onPlayerPickBlock(PlayerPickBlockEvent event) {
        Player player = event.getPlayer();

        if (player.isOp() || player.hasPermission(BYPASS)) return;

        String name = event.getBlock().getType().name().toLowerCase(Locale.ROOT);

        if (player.hasPermission(BLOCK_PREFIX + name)) {
            event.setCancelled(true);
            return;
        }

        if (event.isIncludeData() && player.hasPermission( DATA_PREFIX + name)) {
            event.setCancelled(true);
        }
    }
}
