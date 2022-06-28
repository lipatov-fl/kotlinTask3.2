package ru.netology

import org.junit.Test

import org.junit.Assert.*

class MainKtTest {

        @Test
        fun commissionCount_VK_PAY() {
            val card = VK_PAY
            val amount = 10_000_00L
            val total = 30_000_00L

            val result = commissionCount(cardType = card, transactionAmount = amount, lastMonthAmount = total)
            assertEquals("Комиссия составляет 0 коп.", result)
        }

        @Test
        fun commissionCount_VK_PAY_limitDay() {
            val card = VK_PAY
            val amount = 20_000_00L
            val total = 30_000_00L

            val result = commissionCount(
                cardType = card,
                transactionAmount = amount,
                lastMonthAmount = total
            )
            assertEquals("Сумма превышает максимальную сумму за раз! (15_000р.)", result)
        }

        @Test
        fun commissionCount_VK_PAY_limitMonthly() {
            val card = VK_PAY
            val amount = 20_000_00L
            val total = 40_000_00L

            val result = commissionCount(
                cardType = card,
                transactionAmount = amount,
                lastMonthAmount = total
            )
            assertEquals("Исчерпан лимит переводов за месяц! (40_000р.)", result)
        }

        @Test
        fun commissionCount_MASTERCARD() {
            val card = MASTERCARD
            val amount = 80_000_00L
            val total = 30_000_00L

            val result = commissionCount(
                cardType = card,
                transactionAmount = amount,
                lastMonthAmount = total,
            )
            assertEquals("Комиссия составляет 50000 коп.", result)
        }

        @Test
        fun commissionCount_MASTERCARD_limitMonthly() {
            val card = MASTERCARD
            val amount = 80_000_00L
            val total = 700_000_00L

            val result = commissionCount(
                cardType = card,
                transactionAmount = amount,
                lastMonthAmount = total,
            )
            assertEquals("Исчерпан лимит переводов за месяц! (600_000р)", result)
        }

        @Test
        fun commissionCount_MAESTRO() {
            val card = MAESTRO
            val amount = 50_000_00L
            val total = 300_000_00L

            val result = commissionCount(
                cardType = card,
                transactionAmount = amount,
                lastMonthAmount = total,
            )
            assertEquals("Комиссия составляет 0 коп.", result)
        }

        @Test
        fun commissionCount_MAESTRO_limitDay() {
            val card = MAESTRO
            val amount = 200_000_00L
            val total = 300_000_00L

            val result = commissionCount(
                cardType = card,
                transactionAmount = amount,
                lastMonthAmount = total,
            )
            assertEquals("Сумма превышает суточный лимит! (150_000р)", result)
        }

        @Test
        fun commissionCount_VISA() {
            val card = VISA
            val amount = 100_000_00L
            val total = 300_000_00L

            val result = commissionCount(
                cardType = card,
                transactionAmount = amount,
                lastMonthAmount = total,
            )
            assertEquals("Комиссия составляет 75000 коп.", result)
        }

        @Test
        fun commissionCount_VISA_limitMonthly() {
            val card = VISA
            val amount = 100_000_00L
            val total = 700_000_00L

            val result = commissionCount(
                cardType = card,
                transactionAmount = amount,
                lastMonthAmount = total,
            )
            assertEquals("Исчерпан лимит переводов за месяц! (600_000р)", result)
        }

        @Test
        fun commissionCount_MIR() {
            val card = MIR
            val amount = 1_000_00L
            val total = 400_000_00L

            val result = commissionCount(
                cardType = card,
                transactionAmount = amount,
                lastMonthAmount = total,
            )
            assertEquals("Комиссия составляет 3500 коп.", result)
        }

        @Test
        fun commissionCount_MIR_limitDay() {
            val card = MIR
            val amount = 160_000_00L
            val total = 400_000_00L

            val result = commissionCount(
                cardType = card,
                transactionAmount = amount,
                lastMonthAmount = total,
            )
            assertEquals("Сумма превышает суточный лимит! (150_000р)", result)
        }
    }