**PaperMenuAPI**

Simple & lightweight API for menus!

Example:
```
PaperPlayer paperPlayer = paperMenuAPI.getPaperPlayerManager().getPaperPlayer(event.getPlayer());

        new PaperMenu(paperMenuAPI, paperPlayer, "Demo menu!")
                .setSize(54)
                .addClickableItem(0, new ItemBuilder(Material.STONE)
                        .setDisplayName("Demo item!")
                        .build(), () -> {
                    paperPlayer.getBukkitPlayer().sendMessage("Demo message! :D");
                        })

                .openMenu();
 ```


Start using this API!

```
    <repositories>
        <repository>
            <id>jitpack.io</id>
            <url>https://jitpack.io</url>
        </repository>
    </repositories>[/code]
    <dependency>
        <groupId>com.github.Ailakks-Resources</groupId>
        <artifactId>PaperMenuAPI</artifactId>
        <version>Tag</version>
    </dependency>[/code]
```


> Please ask for support (Discord) before posting a bad review!

> You are not permitted to claim this as your own creation.
