package com.heimnor.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelPoele extends ModelBase
{
    ModelRenderer poeleTour;
    ModelRenderer manche;
    ModelRenderer poeleTour1;
    ModelRenderer poeleTour2;
    ModelRenderer poeleTour3;
    ModelRenderer Block;

    public ModelPoele()
    {
        this( 0.0f );
    }

    public ModelPoele(float par1)
    {
        poeleTour = new ModelRenderer( this, 0, 13 );
        poeleTour.setTextureSize( 64, 32 );
        poeleTour.addBox( -6.5F, -1.5F, 0F, 13, 3, 0);
        poeleTour.setRotationPoint( 6F, -21F, 0F );
        manche = new ModelRenderer( this, 0, 0 );
        manche.setTextureSize( 64, 32 );
        manche.addBox( -5F, -1F, -1F, 10, 2, 2);
        manche.setRotationPoint( 11.07708F, -22F, 4.042516E-08F );
        poeleTour1 = new ModelRenderer( this, 13, 13 );
        poeleTour1.setTextureSize( 64, 32 );
        poeleTour1.addBox( -6.5F, -1.5F, 0F, 13, 3, 0);
        poeleTour1.setRotationPoint( -0.4999985F, -21F, 6.500001F );
        poeleTour2 = new ModelRenderer( this, 13, 13 );
        poeleTour2.setTextureSize( 64, 32 );
        poeleTour2.addBox( -6.5F, -1.5F, 0F, 13, 3, 0);
        poeleTour2.setRotationPoint( -6.999999F, -21F, 2.324581E-06F );
        poeleTour3 = new ModelRenderer( this, 13, 13 );
        poeleTour3.setTextureSize( 64, 32 );
        poeleTour3.addBox( -6.5F, -1.5F, 0F, 13, 3, 0);
        poeleTour3.setRotationPoint( -0.4600008F, -21F, -6.499999F );
        Block = new ModelRenderer( this, 13, 0 );
        Block.setTextureSize( 64, 32 );
        Block.addBox( -6.5F, 0F, -6.5F, 13, 0, 13);
        Block.setRotationPoint( -0.4999996F, -19.5F, 1.162291E-06F );
    }

   public void renderAll()
   {
        poeleTour.rotateAngleX = 0F;
        poeleTour.rotateAngleY = -1.570796F;
        poeleTour.rotateAngleZ = 0F;
        poeleTour.renderWithRotation(0.0625F);

        manche.rotateAngleX = 7.691645E-16F;
        manche.rotateAngleY = 1.685874E-07F;
        manche.rotateAngleZ = -0.1396263F;
        manche.renderWithRotation(0.0625F);

        poeleTour1.rotateAngleX = 0F;
        poeleTour1.rotateAngleY = 0F;
        poeleTour1.rotateAngleZ = 0F;
        poeleTour1.renderWithRotation(0.0625F);

        poeleTour2.rotateAngleX = 0F;
        poeleTour2.rotateAngleY = -1.570796F;
        poeleTour2.rotateAngleZ = 0F;
        poeleTour2.renderWithRotation(0.0625F);

        poeleTour3.rotateAngleX = 0F;
        poeleTour3.rotateAngleY = 0F;
        poeleTour3.rotateAngleZ = 0F;
        poeleTour3.renderWithRotation(0.0625F);

        Block.rotateAngleX = 0F;
        Block.rotateAngleY = 0F;
        Block.rotateAngleZ = 0F;
        Block.renderWithRotation(0.0625F);

    }

}
