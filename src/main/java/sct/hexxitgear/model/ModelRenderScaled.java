package sct.hexxitgear.model;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelRenderer;

public class ModelRendererScaled extends ModelRenderer {

    public final float scale;

    public ModelRendererScaled(ModelBase model, int texOffX, int texOffY, float scale) {
        super(model, texOffX, texOffY);
        this.scale = scale;
    }

    @Override
    public void render(float scale) {
        super.render(scale + this.scale);
    }

    @Override
    public void renderWithRotation(float scale) {
        super.renderWithRotation(scale + this.scale);
    }

    @Override
    public void postRender(float scale) {
        super.postRender(scale + this.scale);
    }

}
