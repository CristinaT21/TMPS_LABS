package interfaces

abstract class IPaymentHandler {
    val successor: IPaymentHandler? = null

    abstract fun handleRequest(amount: Double): Boolean
}