package de.agilecoders.wicket.extensions.markup.html.bootstrap.behavior;

import de.agilecoders.wicket.core.markup.html.bootstrap.behavior.BootstrapBaseBehavior;
import de.agilecoders.wicket.core.util.References;
import de.agilecoders.wicket.extensions.markup.html.bootstrap.jqueryui.JQueryUIDraggableJavaScriptReference;
import org.apache.wicket.Component;
import org.apache.wicket.markup.head.IHeaderResponse;

import static de.agilecoders.wicket.core.util.JQuery.$;

/**
 * Makes an assigned component draggable.
 *
 * @author miha
 */
public class Draggable extends BootstrapBaseBehavior {

    private final DraggableConfig config;

    /**
     * Construct.
     */
    public Draggable() {
        this(new DraggableConfig().withCursor("move"));
    }

    /**
     * Construct.
     *
     * @param config The configuration
     */
    public Draggable(final DraggableConfig config) {
        this.config = config;
    }

    @Override
    public void renderHead(Component component, IHeaderResponse headerResponse) {
        super.renderHead(component, headerResponse);

        References.renderWithFilter(headerResponse, JQueryUIDraggableJavaScriptReference.instance());
        headerResponse.render($(component).chain("draggable", config).asDomReadyScript());
    }

    @Override
    public void bind(Component component) {
        super.bind(component);

        component.setOutputMarkupId(true);
    }

}
