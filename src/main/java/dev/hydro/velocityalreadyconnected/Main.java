package dev.hydro.velocityalreadyconnected;

import com.google.inject.Inject;
import com.velocitypowered.api.event.connection.PreLoginEvent;
import com.velocitypowered.api.event.proxy.ProxyInitializeEvent;
import com.velocitypowered.api.event.Subscribe;
import com.velocitypowered.api.plugin.Plugin;
import com.velocitypowered.api.proxy.Player;
import com.velocitypowered.api.proxy.ProxyServer;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import org.slf4j.Logger;

@Plugin(
        id = "velocityalreadyconnected",
        name = "VelocityAlreadyConnected",
        version = BuildConstants.VERSION
)
public class Main {

    private final ProxyServer server;
    private final Logger logger;

    @Inject
    public Main(ProxyServer server, Logger logger) {
        this.server = server;
        this.logger = logger;
    }

    @Subscribe
    public void onProxyInitialization(ProxyInitializeEvent event) {
        this.server.getEventManager().register(this, this);
    }

    @Subscribe
    public void onPlayerJoin(PreLoginEvent event) {
        String incomingUsername = event.getUsername();
        String incomingAddress = event.getConnection().getRemoteAddress().getAddress().getHostAddress();

        for (Player player : this.server.getAllPlayers()) {
            if (player.getUsername().equalsIgnoreCase(incomingUsername) &&
                    player.getRemoteAddress().getAddress().getHostAddress().equals(incomingAddress)) {
                Component kickMessage = Component.text("Duplicate login detected!").color(NamedTextColor.RED);
                player.disconnect(kickMessage);
                break;
            }
        }
    }
}
