package sct.hexxitgear.model;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelHoodHelmet extends ModelBiped {

    ModelRenderer head;
    ModelRenderer Shape1;
    ModelRenderer Shape2;
    ModelRenderer Shape3;
    ModelRenderer Shape4;
    ModelRenderer Shape5;

    public ModelHoodHelmet() {
        textureWidth = 64;
        textureHeight = 32;

        head = new ModelRenderer(this, 0, 0);
        head.addBox(-4F, -8F, -4F, 8, 8, 8);
        head.setRotationPoint(0F, 0F, 0F);
        head.setTextureSize(64, 32);
        head.mirror = true;
        setRotation(head, 0F, 0F, 0F);
        Shape1 = new ModelRenderer(this, 48, 0);
        Shape1.addBox(-3.5F, -7.8F, 4F, 7, 5, 1);
        Shape1.setRotationPoint(0F, 0F, 0F);
        Shape1.setTextureSize(64, 32);
        Shape1.mirror = true;
        setRotation(Shape1, 0F, 0F, 0F);
        Shape2 = new ModelRenderer(this, 48, 6);
        Shape2.addBox(-3F, -7.6F, 5F, 6, 3, 1);
        Shape2.setRotationPoint(0F, 0F, 0F);
        Shape2.setTextureSize(64, 32);
        Shape2.mirror = true;
        setRotation(Shape2, 0F, 0F, 0F);
        Shape3 = new ModelRenderer(this, 48, 11);
        Shape3.addBox(-1.333333F, -7.5F, 6F, 3, 1, 1);
        Shape3.setRotationPoint(0F, 0F, 0F);
        Shape3.setTextureSize(64, 32);
        Shape3.mirror = true;
        setRotation(Shape3, 0F, 0F, 0F);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        float scaledUp = f5 + 0.01F;
        setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        head.render(scaledUp);
        Shape1.render(scaledUp);
        Shape2.render(scaledUp);
        Shape3.render(scaledUp);
    }

    private void setRotation(ModelRenderer model, float x, float y, float z) {
        model.rotateAngleX = x;
        model.rotateAngleY = y;
        model.rotateAngleZ = z;
    }

    @Override
    public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity)
    {
        super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        float newX = this.bipedHeadwear.rotateAngleX;
        float newY = this.bipedHeadwear.rotateAngleY;
        setRotation(head, newX, newY, 0);
        setRotation(Shape1, newX, newY, 0);
        setRotation(Shape2, newX, newY, 0);
        setRotation(Shape3, newX, newY, 0);

    }
}
