package ru.capjack.tool.lang

import kotlin.test.Test
import kotlin.test.assertEquals

@Suppress("SpellCheckingInspection")
class TestHex {
	@Test
	fun byte_to_hex_string() {
		assertEquals("00", 0.toByte().toHexString())
		assertEquals("01", 1.toByte().toHexString())
		assertEquals("07", 0x07.toByte().toHexString())
		assertEquals("0f", 0x0F.toByte().toHexString())
		assertEquals("80", 0x80.toByte().toHexString())
		assertEquals("f0", 0xF0.toByte().toHexString())
		assertEquals("ff", 0xFF.toByte().toHexString())
	}
	
	@Test
	fun byte_to_hex_string_appendable() {
		
		val values = byteArrayOf(0, 1, 0x07, 0x0F, 0x80.toByte(), 0xF0.toByte(), 0xFF.toByte())
		val target = StringBuilder()
		
		values.forEach { it.toHexString(target) }
		
		assertEquals("00" + "01" + "07" + "0f" + "80" + "f0" + "ff", target.toString())
	}
	
	@Test
	fun int_to_hex_string() {
		assertEquals("00000000", 0.toHexString())
		assertEquals("00000001", 1.toHexString())
		assertEquals("00007fff", 0x7FFF.toHexString())
		assertEquals("00008000", 0x8000.toHexString())
		assertEquals("7fffffff", 0x7FFFFFFF.toHexString())
		assertEquals("80000000", 0x80000000.toInt().toHexString())
		assertEquals("ffff0000", 0xFFFF0000.toInt().toHexString())
		assertEquals("ffffffff", 0xFFFFFFFF.toInt().toHexString())
	}
	
	
	@Test
	fun int_to_hex_string_appendable() {
		
		val values = intArrayOf(0, 1, 0x7FFF, 0x8000, 0x7FFFFFFF, 0x80000000.toInt(), 0xFFFF0000.toInt(), 0xFFFFFFFF.toInt())
		val target = StringBuilder()
		
		values.forEach { it.toHexString(target) }
		
		assertEquals(
			"00000000" +
				"00000001" +
				"00007fff" +
				"00008000" +
				"7fffffff" +
				"80000000" +
				"ffff0000" +
				"ffffffff",
			target.toString()
		)
	}
}