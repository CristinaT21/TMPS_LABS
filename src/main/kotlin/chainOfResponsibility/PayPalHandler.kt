package chainOfResponsibility

import interfaces.IPaymentHandler

class PayPalHandler: IPaymentHandler() {
    override fun handleRequest(amount: Double): Boolean {
        if (amount > 20){
            println("PayPal processed the payment.")
            return true
        }
        else {
            return false
        }
    }
}