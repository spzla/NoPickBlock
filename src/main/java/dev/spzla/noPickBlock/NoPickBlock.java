package dev.spzla.noPickBlock;

import dev.spzla.noPickBlock.listener.PlayerEventListener;
import org.bukkit.plugin.java.JavaPlugin;

public final class NoPickBlock extends JavaPlugin {

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(new PlayerEventListener(), this);
    }
}
