If you're running a Velocity server in offline mode, you've probably dealt with the annoying issue where a player gets disconnected and then can't rejoin, often getting stuck with an error message. This can be frustrating for both you and your players. In the best-case scenario, the player complains, but in the worst case, they might just leave and not come back.

![Velocity Server Issue](https://forum.craftersland.net/uploads/monthly_2017_11/WTF.PNG.e2b1912bbd33cf4bc80046cf9c215034.PNG)

In online mode, Velocity has a **kick-existing-players** setting that solves this problem by automatically kicking any existing connection when a player with the same username tries to join. Unfortunately, this setting doesn’t work in offline mode.

That’s where this simple plugin comes in. It fixes the problem by forcefully disconnecting any existing player who has the same username and IP as someone trying to reconnect. It's like the **kick-existing-players** setting, but it works even if your server is in offline mode.
