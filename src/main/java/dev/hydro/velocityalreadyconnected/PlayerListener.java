package dev.hydro.velocityalreadyconnected;

import com.velocitypowered.api.event.Subscribe;
import com.velocitypowered.api.event.connection.PreLoginEvent;
import com.velocitypowered.api.proxy.Player;
import com.velocitypowered.api.proxy.ProxyServer;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;

public class PlayerListener {

    private final ProxyServer server;

    public PlayerListener(ProxyServer server) {
        this.server = server;
    }

    @Subscribe
    public void onPlayerJoin(PreLoginEvent event) {
        System.out.println("Event Fired.");
        String incomingUsername = event.getUsername();
        String incomingAddress = event.getConnection().getRemoteAddress().getAddress().getHostAddress();

        for (Player player : server.getAllPlayers()) {
            if (player.getUsername().equalsIgnoreCase(incomingUsername) &&
                    player.getRemoteAddress().getAddress().getHostAddress().equals(incomingAddress)) {
                Component kickMessage = Component.text("Duplicate login detected!").color(NamedTextColor.RED);
                player.disconnect(kickMessage);
                break;
            }
        }
    }
}
