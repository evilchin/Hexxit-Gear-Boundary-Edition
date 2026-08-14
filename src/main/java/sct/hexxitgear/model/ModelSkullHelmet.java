/*
 * HexxitGear
 * Copyright (C) 2013  Ryan Cohen
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package sct.hexxitgear.model;

import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.Entity;

public class ModelSkullHelmet extends ModelBiped {

    ModelRenderer Shape4;
    ModelRenderer Shape1;
    ModelRenderer Shape2;
    ModelRenderer Shape3;

    public ModelSkull(float modelSize) {
        super(modelSize, 0.0F, 64, 32);

        Shape4 = new ModelRenderer(this, 25, 0);
        Shape4.addBox(4F, -7F, 0F, 3, 2, 2);
        Shape4.setRotationPoint(0F, 0F, 0F);
        Shape4.setTextureSize(64, 32);
        Shape4.mirror = true;
        Shape1 = new ModelRenderer(this, 25, 0);
        Shape1.addBox(4F, -7F, 0F, 3, 2, 2);
        Shape1.setRotationPoint(0F, 0F, 0F);
        Shape1.setTextureSize(64, 32);
        Shape1.mirror = true;
        Shape2 = new ModelRenderer(this, 25, 5);
        Shape2.addBox(6F, -8F, 0F, 1, 1, 1);
        Shape2.setRotationPoint(0F, 0F, 0F);
        Shape2.setTextureSize(64, 32);
        Shape2.mirror = true;
        Shape3 = new ModelRenderer(this, 25, 5);
        Shape3.addBox(-5F, -7F, 0F, 1, 1, 1);
        Shape3.setRotationPoint(0F, 0F, 0F);
        Shape3.setTextureSize(64, 32);
        Shape3.mirror = true;

        bipedHead.addChild(Shape4);
        bipedHead.addChild(Shape1);
        bipedHead.addChild(Shape2);
        bipedHead.addChild(Shape3);
    }

    @Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		float scaledUp = f5 + 0.01F;
		setRotationAngles(f, f1, f2, f3, f4, f5, entity);
		GlStateManager.pushMatrix();
		if (entity.isSneaking()) GlStateManager.translate(0, .2, 0);
		head.render(scaledUp);
		Shape4.render(scaledUp);
		Shape1.render(scaledUp);
		Shape2.render(scaledUp);
		Shape3.render(scaledUp);
		GlStateManager.popMatrix();
	}

	private void setRotation(ModelRenderer model, float x, float y, float z) {
		model.rotateAngleX = x;
		model.rotateAngleY = y;
		model.rotateAngleZ = z;
		model.rotationPointY = (this.isSneak) ? 1.0f : 0;
	}

	@Override
	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity) {
		super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
		float newX = this.bipedHeadwear.rotateAngleX;
		float newY = this.bipedHeadwear.rotateAngleY;
		setRotation(head, newX, newY, 0);
		setRotation(Shape1, newX, newY, 0);
		setRotation(Shape2, newX, newY, 0);
		setRotation(Shape3, newX, newY, 0);
		setRotation(Shape4, newX, newY, 0);
	}

}
