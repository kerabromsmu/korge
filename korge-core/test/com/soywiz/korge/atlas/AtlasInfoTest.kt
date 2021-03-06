package com.soywiz.korge.atlas

import com.soywiz.korio.async.syncTest
import com.soywiz.korio.vfs.ResourcesVfs
import com.soywiz.korma.geom.Rectangle
import com.soywiz.korma.geom.Size
import org.junit.Assert
import org.junit.Test

class AtlasInfoTest {
	@Test
	fun name() = syncTest {
		val atlas = AtlasInfo.loadJsonSpriter(ResourcesVfs["demo.json"].readString())
		Assert.assertEquals("Spriter", atlas.app)
		Assert.assertEquals("r10", atlas.version)
		Assert.assertEquals("demo.png", atlas.image)
		Assert.assertEquals("RGBA8888", atlas.format)
		Assert.assertEquals(124, atlas.frames.size)
		Assert.assertEquals(1.0, atlas.scale, 0.0)
		Assert.assertEquals(Size(1021, 1003), atlas.size.size)

		val firstFrame = atlas.frames.values.first()
		Assert.assertEquals("arms/forearm_jump_0.png", atlas.frames.keys.first())
		Assert.assertEquals(Rectangle(993, 319, 28, 41), firstFrame.frame.rect)
		Assert.assertEquals(Size(55, 47), firstFrame.sourceSize.size)
		Assert.assertEquals(Rectangle(7, 8, 28, 41), firstFrame.spriteSourceSize.rect)
		Assert.assertEquals(true, firstFrame.rotated)
		Assert.assertEquals(true, firstFrame.trimmed)
	}
}
