package fr.redstonneur1256.ffp;

import arc.Events;
import mindustry.Vars;
import mindustry.game.EventType;
import mindustry.mod.Plugin;

public class FooFormatPatch extends Plugin {

    @Override
    public void init() {
        Events.run(EventType.ClientLoadEvent.class, () -> Vars.ui.showErrorMessage("FooFormatPatch is a server plugin, using it on the client might have undetermined effects"));
    }

}
