package example

import javax.annotation.processing.Messager
import javax.print.attribute.standard.JobStateReason
import javax.xml.crypto.Data

sealed class NetworkResult{
    data class Success(val data: String): NetworkResult()
    data class Error(val message: String, val code: Int): NetworkResult()
    object Loading : NetworkResult()
}
sealed class OrderStatus{
    object Created : OrderStatus()
    object Paid : OrderStatus()
    object Shipped : OrderStatus()
    data class Cancelled(val reason: String) : OrderStatus()
}
fun handleOrder(status: OrderStatus){
    when (status){
        OrderStatus.Created -> println("Заказ создан")
        OrderStatus.Paid -> println("Заказ оплачен")
        OrderStatus.Shipped -> println("Заказ отправлен")
        is OrderStatus.Cancelled -> println("Отменен: ${status.reason}")
    }
}
fun handleResult(result: NetworkResult){
    when (result){
        is NetworkResult.Success ->{
            println("Успех: ${result.data}")
        }
        is NetworkResult.Error -> {
            println("Ошибка ${result.message}")
        }
        NetworkResult.Loading -> {
            println("Загрузка...")
        }
    }
}
fun main(){
    handleOrder(status = OrderStatus.Created)
    handleOrder(status = OrderStatus.Paid)
    handleOrder(status = OrderStatus.Shipped)
    handleOrder(status = OrderStatus.Cancelled(reason = "Нет товара на складе"))
//    val success = NetworkResult.Success(data = "Данные получены")
//    val error = NetworkResult.Error(message = "Сервер не отвечает", code = 500)
//    val loading = NetworkResult.Loading
//    handleResult(result = success)
//    handleResult(result = error)
//    handleResult(result = loading)
}