package com.mype.richhome.ui.view;

import javafx.scene.Parent;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.loadui.testfx.GuiTest;
import org.loadui.testfx.utils.FXTestUtils;
import org.mockito.Mock;

import static org.loadui.testfx.Assertions.verifyThat;
import static org.loadui.testfx.controls.impl.ContainsNodesMatcher.contains;
import static org.mockito.MockitoAnnotations.initMocks;

public class MonthViewTest extends GuiTest {
    @Mock
    private MonthViewMediator mediator;

    @Before
    public void setUp() throws Exception {
        initMocks(this);
    }

    @Override
    protected Parent getRootNode() {
        MonthViewImpl monthView = new MonthViewImpl();
        monthView.setMediator(mediator);

        return monthView.getView().getParent();
    }

    @Ignore
    @Test
    public void shouldLoadEmpty() throws Exception {
        FXTestUtils.printGraph(getRootNode());

        verifyThat("monthView", contains("monthList"));
    }

}