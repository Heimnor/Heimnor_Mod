package com.heimnor.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;

public class ModelMiroir extends ModelBaseH
{
    ModelRenderer Block;
    ModelRenderer Block1;
    ModelRenderer Block2;
    ModelRenderer Block3;
    ModelRenderer Block4;
    ModelRenderer Block5;
    ModelRenderer Block6;

    public ModelMiroir()
    {
        this( 0.0f );
    }

    public ModelMiroir( float par1 )
    {
        Block = new ModelRenderer( this, 0, 12 );
        Block.setTextureSize( 128, 128 );
        Block.addBox( -12F, -24F, -0.5F, 24, 48, 1);
        Block.setRotationPoint( 0F, -9F, 0F );
        Block1 = new ModelRenderer( this, 0, 0 );
        Block1.setTextureSize( 128, 128 );
        Block1.addBox( -18F, -4F, -2F, 36, 8, 4);
        Block1.setRotationPoint( 0F, -37F, 0F );
        Block2 = new ModelRenderer( this, 52, 13 );
        Block2.setTextureSize( 128, 128 );
        Block2.addBox( -2F, -4F, -8.5F, 4, 8, 17);
        Block2.setRotationPoint( 14F, 19F, 0F );
        Block3 = new ModelRenderer( this, 52, 38 );
        Block3.setTextureSize( 128, 128 );
        Block3.addBox( -2F, -4F, -8.5F, 4, 8, 17);
        Block3.setRotationPoint( -14F, 19F, 0F );
        Block4 = new ModelRenderer( this, 0, 61 );
        Block4.setTextureSize( 128, 128 );
        Block4.addBox( -12F, -4F, -2F, 24, 8, 4);
        Block4.setRotationPoint( 0F, 19F, 0F );
        Block5 = new ModelRenderer( this, 112, 12 );
        Block5.setTextureSize( 128, 128 );
        Block5.addBox( -2F, -24F, -2F, 4, 48, 4);
        Block5.setRotationPoint( 14F, -9F, 0F );
        Block6 = new ModelRenderer( this, 96, 12 );
        Block6.setTextureSize( 128, 128 );
        Block6.addBox( -2F, -24F, -2F, 4, 48, 4);
        Block6.setRotationPoint( -14F, -9F, 0F );
    }

   public void renderAll()
   {
        Block.rotateAngleX = 0F;
        Block.rotateAngleY = 0F;
        Block.rotateAngleZ = 0F;
        Block.renderWithRotation(0.0625F);

        Block1.rotateAngleX = 0F;
        Block1.rotateAngleY = 0F;
        Block1.rotateAngleZ = 0F;
        Block1.renderWithRotation(0.0625F);

        Block2.rotateAngleX = 0F;
        Block2.rotateAngleY = 0F;
        Block2.rotateAngleZ = 0F;
        Block2.renderWithRotation(0.0625F);

        Block3.rotateAngleX = 0F;
        Block3.rotateAngleY = 0F;
        Block3.rotateAngleZ = 0F;
        Block3.renderWithRotation(0.0625F);

        Block4.rotateAngleX = 0F;
        Block4.rotateAngleY = 0F;
        Block4.rotateAngleZ = 0F;
        Block4.renderWithRotation(0.0625F);

        Block5.rotateAngleX = 0F;
        Block5.rotateAngleY = 0F;
        Block5.rotateAngleZ = 0F;
        Block5.renderWithRotation(0.0625F);

        Block6.rotateAngleX = 0F;
        Block6.rotateAngleY = 0F;
        Block6.rotateAngleZ = 0F;
        Block6.renderWithRotation(0.0625F);
    }

}
