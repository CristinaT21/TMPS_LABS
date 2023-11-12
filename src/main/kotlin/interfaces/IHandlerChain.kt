package interfaces

interface IHandlerChain {
    fun processPayment(amount: Double, paymentHandlers:List<IPaymentHandler>): Boolean

}