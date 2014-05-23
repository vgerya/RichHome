package com.mype.richhome.ui.control.monthlist;

import com.sun.javafx.scene.control.behavior.BehaviorBase;
import com.sun.javafx.scene.control.behavior.KeyBinding;

import java.util.List;

/**
 * @author Vitaliy Gerya
 */
public class MonthListBehaviour extends BehaviorBase<MonthList> {
    /**
     * Create a new BehaviorBase for the given control. The Control must not
     * be null.
     *
     * @param control     The control. Must not be null.
     * @param keyBindings The key bindings that should be used with this behavior.
     */
    public MonthListBehaviour(final MonthList control, final List<KeyBinding> keyBindings) {
        super(control, keyBindings);
    }
}
