package com.mona15dev.domain.product.detail.model

import org.junit.Assert.assertEquals
import org.junit.Test

class ProductConditionTest {

    @Test
    fun `fromString debería devolver un valor 'NEW'`() {
        // Arrange
        val expectedCondition = ProductCondition.NEW
        val sendCondition = "NEW"

        // Act
        val result = ProductCondition.fromString(sendCondition)

        // Assert
        assertEquals(expectedCondition, result)
    }

    @Test
    fun `fromString debería devolver un valor usado`() {
        // Arrange
        val expectedCondition = ProductCondition.USED
        val sendCondition = "used"

        // Act
        val result = ProductCondition.fromString(sendCondition)

        // Assert
        assertEquals(expectedCondition, result)
    }

    @Test
    fun `fromString debería devolver un valor usado cuando se envíe un valor no reconocido`() {
        // Arrange
        val expectedCondition = ProductCondition.USED
        val sendCondition = "unknown"

        // Act
        val result = ProductCondition.fromString(sendCondition)

        // Assert
        assertEquals(expectedCondition, result)
    }
}