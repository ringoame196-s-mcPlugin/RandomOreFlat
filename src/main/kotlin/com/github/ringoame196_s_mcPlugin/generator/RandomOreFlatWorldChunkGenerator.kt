package com.github.ringoame196_s_mcPlugin.generator

import org.bukkit.Material
import org.bukkit.World
import org.bukkit.generator.ChunkGenerator
import kotlin.collections.iterator
import kotlin.random.Random

class RandomOreFlatWorldChunkGenerator : ChunkGenerator() {
    private val rawBlockChances = mapOf<Material, Double>(
        // 生成ブロック to 生成確率(合計1.0)
        Material.COAL_ORE to 0.04,
        Material.IRON_ORE to 0.03,
        Material.GOLD_ORE to 0.03,
        Material.LAPIS_ORE to 0.02,
        Material.REDSTONE_ORE to 0.02,
        Material.DIAMOND_ORE to 0.01,
        Material.LAVA to 0.06,
        Material.BEDROCK to 0.04,
        Material.COBBLED_DEEPSLATE to 0.3,
        Material.STONE to 0.45
    )

    override fun generateChunkData(
        world: World,
        random: java.util.Random,
        chunkZ: Int,
        z: Int,
        biome: BiomeGrid
    ): ChunkData {
        val chunk = createChunkData(world)

        for (centerZ in 0..15) {
            for (centerX in 0..15) {
                chunk.setBlock(centerX, 0, centerZ, Material.BEDROCK)
                for (centerY in 0..10) {
                    setRandomBlock(chunk, centerX, centerY, centerZ)
                }
                chunk.setBlock(centerX, 11, centerZ, Material.STONE)
            }
        }

        return chunk
    }

    private fun setRandomBlock(chunk: ChunkData, x: Int, y: Int, z: Int) {
        val randomBlockType = acquisitionRandomBlock()
        chunk.setBlock(x, y, z, randomBlockType)
    }

    private fun acquisitionRandomBlock(): Material {
        val r = Random.nextDouble()
        var cumulative = 0.0
        for ((material, chance) in rawBlockChances) {
            cumulative += chance
            if (r < cumulative) {
                return material
            }
        }
        return rawBlockChances.keys.last()
    }
}
