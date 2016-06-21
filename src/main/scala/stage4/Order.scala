package stage4

/**
  * Created by Administrator on 17/06/2016.
  */
case class Order(var ordId :Int, var datetime :String, var custId :Int, var status :String) {}

object Order {
  var orders = Set(Order(1, "13 JUN 2016 12:30", 1, "New"),Order(2, "13 JUN 2016 12:32", 2, "New"),Order(3, "14 JUN 2016 12:30", 3, "New"),Order(4, "14 JUN 2016 12:39", 4, "New"))

  def findById(ordId:Int) = orders.find(_.ordId == ordId)

  def updateOrder(order: Order): Unit = {
    //orders.-(findById(order.ordId).get)
    orders -= (findById(order.ordId).get)
    orders = orders + order
  }


 /* def viewOrder(ordId: Int) : Order = {


  }*/




}
