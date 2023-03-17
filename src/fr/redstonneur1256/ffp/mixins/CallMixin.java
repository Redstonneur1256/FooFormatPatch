package fr.redstonneur1256.ffp.mixins;

import mindustry.Vars;
import mindustry.gen.Call;
import mindustry.gen.Player;
import mindustry.gen.SendMessageCallPacket;
import mindustry.net.NetConnection;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;

@SuppressWarnings("OverwriteAuthorRequired")
@Mixin(Call.class)
public abstract class CallMixin {

    @Shadow
    public static void sendMessage(String message) {
    }

    @Overwrite
    public static void sendMessage(String message, String unformatted, Player player) {
        if(Vars.net.server()) {
            sendMessage(message);
        }
    }

    @Overwrite
    public static void sendMessage(NetConnection connection, String message, String unformatted, Player player) {
        if(Vars.net.server()) {
            SendMessageCallPacket packet = new SendMessageCallPacket();
            packet.message = message;
            connection.send(packet, true);
        }
    }

}
