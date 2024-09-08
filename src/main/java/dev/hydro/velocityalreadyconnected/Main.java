package dev.hydro.velocityalreadyconnected;

import com.google.inject.Inject;

import com.velocitypowered.api.event.proxy.ProxyInitializeEvent;
import com.velocitypowered.api.event.Subscribe;
import com.velocitypowered.api.plugin.Plugin;
import com.velocitypowered.api.proxy.ProxyServer;

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
        this.server.getEventManager().register(this, new PlayerListener(this.server));
    }



}
