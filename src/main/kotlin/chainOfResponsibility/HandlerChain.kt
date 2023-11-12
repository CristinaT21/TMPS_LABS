package chainOfResponsibility

import interfaces.IHandlerChain
import interfaces.IPaymentHandler

class HandlerChain : IHandlerChain{
    override fun processPayment(amount: Double, paymentHandlers:List<IPaymentHandler>): Boolean{
        for (handler in paymentHandlers){
            if (handler.handleRequest(amount)){
                return true
            }
        }
        return false
    }
}