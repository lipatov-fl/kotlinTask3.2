package ru.netology

const val VK_PAY = "Vk_Pay"
const val MASTERCARD ="MasterCard"
const val MAESTRO = "Maestro"
const val VISA = "Visa"
const val MIR = "Мир"

const val CARD_LIMIT_DAY = 150_000_00
const val CARD_LIMIT_MONTHLY = 600_000_00
const val VK_PAY_LIMIT_DAY = 15_000_00
const val VK_PAY_LIMIT_MONTHLY = 40_000_00
const val VISA_MIR_MIN_COMMISSION = 35_00

fun main(){
    println(commissionCount(MAESTRO,80_000_00,250_000_00))
}

fun commissionCount(cardType: String = VK_PAY, transactionAmount: Long, lastMonthAmount: Long = 0): String {
    return when (cardType) {
        MASTERCARD -> commissionMastercardMaestro(transactionAmount, lastMonthAmount)
        MAESTRO -> commissionMastercardMaestro(transactionAmount, lastMonthAmount)
        VISA -> commissionVisaMir(transactionAmount, lastMonthAmount)
        MIR ->  commissionVisaMir(transactionAmount, lastMonthAmount)
        else -> commissionVkPay(transactionAmount, lastMonthAmount)
    }
}

fun commissionMastercardMaestro(transactionAmount: Long, lastMonthAmount: Long): String {
    var count = ((transactionAmount / 100 * 0.6) + 20_00).toInt()
    if (lastMonthAmount >= CARD_LIMIT_MONTHLY) {
        return "Исчерпан лимит переводов за месяц! (600_000р)"
    } else if (transactionAmount >= CARD_LIMIT_DAY) {
        return "Сумма превышает суточный лимит! (150_000р)"
    } else if (transactionAmount in 300_00..75_000_00) {
        return "Комиссия составляет 0 коп."
    } else {
        return "Комиссия составляет $count коп."
    }
}

fun commissionVisaMir(transactionAmount: Long, lastMonthAmount: Long): String {
    var count = (transactionAmount / 100 * 0.75).toInt()
    if (lastMonthAmount >= CARD_LIMIT_MONTHLY) {
        return "Исчерпан лимит переводов за месяц! (600_000р)"
    } else if (transactionAmount >= CARD_LIMIT_DAY) {
        return "Сумма превышает суточный лимит! (150_000р)"
    } else if (count <= VISA_MIR_MIN_COMMISSION) {
        return "Комиссия составляет 3500 коп."
    } else {
        return "Комиссия составляет $count коп."
    }
}

fun commissionVkPay(transactionAmount: Long, lastMonthAmount: Long): String {
    if (lastMonthAmount >= VK_PAY_LIMIT_MONTHLY) {
        return "Исчерпан лимит переводов за месяц! (40_000р.)"
    } else if (transactionAmount >= VK_PAY_LIMIT_DAY) {
        return "Сумма превышает максимальную сумму за раз! (15_000р.)"
    } else {
        return "Комиссия составляет 0 коп."
    }
}
