package chainOfResponsibility

import interfaces.IPaymentHandler

class CreditCardHandler: IPaymentHandler() {
    override fun handleRequest(amount: Double): Boolean {
        if (amount <= 20) {
            println("Credit Card processed the payment.")
            return true
        }
        return false
    }
}