package keystrokesmod.module.impl.combat;

import keystrokesmod.module.Module;
import keystrokesmod.module.ModuleManager;
import keystrokesmod.module.impl.movement.LongJump;
import keystrokesmod.module.setting.impl.ButtonSetting;
import keystrokesmod.module.setting.impl.SliderSetting;
import keystrokesmod.utility.Utils;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import org.lwjgl.input.Keyboard;

public class Velocity extends Module {
    public static SliderSetting horizontal;
    public static SliderSetting vertical;
    private SliderSetting chance;
    private ButtonSetting onlyWhileTargeting;
    private ButtonSetting disableS;

    public Velocity() {
        super("Velocity", Module.category.combat, 0);
        this.registerSetting(horizontal = new SliderSetting("Horizontal", 90.0D, 0.0D, 100.0D, 1.0D));
        this.registerSetting(vertical = new SliderSetting("Vertical", 100.0D, 0.0D, 100.0D, 1.0D));
        this.registerSetting(chance = new SliderSetting("Chance", 100.0D, 0.0D, 100.0D, 1.0D));
        this.registerSetting(onlyWhileTargeting = new ButtonSetting("Only while targeting", false));
        this.registerSetting(disableS = new ButtonSetting("Disable while holding S", false));
    }

    @SubscribeEvent
    public void onLivingUpdate(LivingUpdateEvent ev) {
        if (Utils.nullCheck() && !LongJump.stopModules) {
            if (ModuleManager.antiKnockback.isEnabled()) {
                return;
            }
            if (mc.thePlayer.maxHurtTime <= 0 || mc.thePlayer.hurtTime != mc.thePlayer.maxHurtTime) {
                return;
            }
            if (onlyWhileTargeting.isToggled() && (mc.objectMouseOver == null || mc.objectMouseOver.entityHit == null)) {
                return;
            }
            if (disableS.isToggled() && Keyboard.isKeyDown(mc.gameSettings.keyBindBack.getKeyCode())) {
                return;
            }
            if (chance.getInput() != 100) {
                double ch = Math.random();
                if (ch >= chance.getInput() / 100.0D) {
                    return;
                }
            }
            if (horizontal.getInput() != 100.0D) {
                mc.thePlayer.motionX *= horizontal.getInput() / 100.0D;
                mc.thePlayer.motionZ *= horizontal.getInput() / 100.0D;
            }
            if (vertical.getInput() != 100.0D) {
                mc.thePlayer.motionY *= vertical.getInput() / 100.0D;
            }
        }
    }
}
