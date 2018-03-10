package com.heimnor.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelFour extends ModelBase
{
    ModelRenderer Block;
    ModelRenderer Block1;
    ModelRenderer Block2;
    ModelRenderer Block3;
    ModelRenderer Block11;
    ModelRenderer Block21;
    ModelRenderer Block6;
    ModelRenderer Block4;
    ModelRenderer Block41;
    ModelRenderer Block42;
    ModelRenderer Block43;
    ModelRenderer Block5;

    public ModelFour()
    {
        this( 0.0f );
    }

    public ModelFour( float par1 )
    {
        Block = new ModelRenderer( this, 0, 0 );
        Block.setTextureSize( 128, 128 );
        Block.addBox( -16F, 0F, -16F, 32, 0, 32);
        Block.setRotationPoint( 0F, -8F, 0F );
        Block1 = new ModelRenderer( this, 0, 0 );
        Block1.setTextureSize( 128, 128 );
        Block1.addBox( 0F, -16F, -16F, 0, 32, 32);
        Block1.setRotationPoint( -16F, -24F, 0F );
        Block2 = new ModelRenderer( this, 0, 32 );
        Block2.setTextureSize( 128, 128 );
        Block2.addBox( -16F, -16F, 0F, 32, 32, 0);
        Block2.setRotationPoint( 0F, -24F, 16F );
        Block3 = new ModelRenderer( this, 0, 0 );
        Block3.setTextureSize( 128, 128 );
        Block3.addBox( 0F, -16F, -16F, 0, 32, 32);
        Block3.setRotationPoint( 16F, -24F, 0F );
        Block11 = new ModelRenderer( this, 64, 42 );
        Block11.setTextureSize( 128, 128 );
        Block11.addBox( 0F, -11F, -16F, 0, 22, 32);
        Block11.setRotationPoint( 0F, -19F, -16F );
        Block21 = new ModelRenderer( this, 64, 64 );
        Block21.setTextureSize( 128, 128 );
        Block21.addBox( -16F, -5F, 0F, 32, 10, 0);
        Block21.setRotationPoint( 0F, -35F, -16F );
        Block6 = new ModelRenderer( this, 32, 32 );
        Block6.setTextureSize( 128, 128 );
        Block6.addBox( -16F, 0F, -16F, 32, 0, 32);
        Block6.setRotationPoint( 0F, -40F, 0F );
        Block4 = new ModelRenderer( this, 8, 64 );
        Block4.setTextureSize( 128, 128 );
        Block4.addBox( -12F, -2F, -2F, 24, 4, 4);
        Block4.setRotationPoint( 0F, -10F, 0F );
        Block41 = new ModelRenderer( this, 8, 64 );
        Block41.setTextureSize( 128, 128 );
        Block41.addBox( -12F, -2F, -2F, 24, 4, 4);
        Block41.setRotationPoint( 0F, -10F, 0F );
        Block42 = new ModelRenderer( this, 8, 64 );
        Block42.setTextureSize( 128, 128 );
        Block42.addBox( -12F, -2F, -2F, 24, 4, 4);
        Block42.setRotationPoint( 0F, -10F, 0F );
        Block43 = new ModelRenderer( this, 8, 64 );
        Block43.setTextureSize( 128, 128 );
        Block43.addBox( -12F, -2F, -2F, 24, 4, 4);
        Block43.setRotationPoint( 0F, -10F, 0F );
        Block5 = new ModelRenderer( this, -32, 72 );
        Block5.setTextureSize( 128, 128 );
        Block5.addBox( -16F, 0F, -16F, 32, 0, 32);
        Block5.setRotationPoint( 0F, -18F, 0F );
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

        Block11.rotateAngleX = 0F;
        Block11.rotateAngleY = -1.570796F;
        Block11.rotateAngleZ = 0F;
        Block11.renderWithRotation(0.0625F);

        Block21.rotateAngleX = 0F;
        Block21.rotateAngleY = -3.141593F;
        Block21.rotateAngleZ = 0F;
        Block21.renderWithRotation(0.0625F);

        Block6.rotateAngleX = 0F;
        Block6.rotateAngleY = 0F;
        Block6.rotateAngleZ = -3.141593F;
        Block6.renderWithRotation(0.0625F);

        Block4.rotateAngleX = 0F;
        Block4.rotateAngleY = 0F;
        Block4.rotateAngleZ = 0F;
        Block4.renderWithRotation(0.0625F);

        Block41.rotateAngleX = 0F;
        Block41.rotateAngleY = 1.570796F;
        Block41.rotateAngleZ = 0F;
        Block41.renderWithRotation(0.0625F);

        Block42.rotateAngleX = 0F;
        Block42.rotateAngleY = 2.321288F;
        Block42.rotateAngleZ = 0F;
        Block42.renderWithRotation(0.0625F);

        Block43.rotateAngleX = 0F;
        Block43.rotateAngleY = -2.321288F;
        Block43.rotateAngleZ = 0F;
        Block43.renderWithRotation(0.0625F);

        Block5.rotateAngleX = 0F;
        Block5.rotateAngleY = 0F;
        Block5.rotateAngleZ = 0F;
        Block5.renderWithRotation(0.0625F);

    }

}
