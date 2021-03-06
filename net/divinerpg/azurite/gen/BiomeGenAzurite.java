package net.divinerpg.azurite.gen;

import java.util.Random;

import net.divinerpg.helper.block.TwilightBlockHelper;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.feature.WorldGenerator;

public class BiomeGenAzurite extends BiomeGenBase
{
    public BiomeGenAzurite(int var1)
    {
        super(var1);
        this.setBiomeName("Azurite");
        this.spawnableCreatureList.clear();
        this.spawnableMonsterList.clear();
        this.topBlock = (byte)TwilightBlockHelper.AzuriteGrass.blockID;
        this.fillerBlock = (byte)TwilightBlockHelper.AzuriteDirt.blockID;
        this.waterColorMultiplier = 2368548;
        this.theBiomeDecorator.treesPerChunk = 6;
    }

    /**
     * Gets a WorldGen appropriate for this biome.
     */
    @Override
    public WorldGenerator getRandomWorldGenForTrees(Random var1)
    {
        return this.worldGeneratorSwamp;
    }
}
