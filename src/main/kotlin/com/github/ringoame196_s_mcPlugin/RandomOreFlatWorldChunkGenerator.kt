package com.github.ringoame196_s_mcPlugin

import org.bukkit.Material
import org.bukkit.World
import org.bukkit.generator.ChunkGenerator
import kotlin.random.Random

class RandomOreFlatWorldChunkGenerator : ChunkGenerator() {
    private val rawBlockChances = mapOf<Material, Double>(
        // 生成ブロック to 生成確率(合計1.0)
		Material.COAL_ORE to 0.08,
        Material.IRON_ORE to 0.06,
        Material.GOLD_ORE to 0.05,
        Material.LAPIS_ORE to 0.04,
        Material.REDSTONE_ORE to 0.03,
        Material.NETHERITE_BLOCK to 0.02,
        Material.LAVA to 0.08, // ある程度確保
        Data.explosionBlock to 0.05, // ある程度確保
        Material.COBBLED_DEEPSLATE to 0.15,
        Material.STONE to 0.54
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
