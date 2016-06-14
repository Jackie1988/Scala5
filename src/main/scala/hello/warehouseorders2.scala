package hello

import java.util.Calendar
import scala.collection.mutable.ListBuffer
import scala.io.StdIn.readLine

/**
  * Created by Administrator on 14/06/2016.
  */
object warehouseOrders {



  case class Order(ordId_ :Int, datetime_ :String, custId_ :Int, status_ :String) {
      var orderId = ordId_
      var dateTime = datetime_
      var customerId = custId_
      var status = status_
  }
  //this needs to be a list of OrderItems???

  case class OrderItem(orderId:Int, productId:Int, quantity:Int, porouswareQuantity: Int)

  case class OrderItemsList(lineItems:List[OrderItem])

  class Orders(a: Order*) {
    private val orderList:List[Order] = a.toList





    def updateInventory(){

    }


    def informAccounts(){
      //inform Accounts that a delivery has been made
    }


    def receiveNewStock(){
      //updateInventory with new stock
    }

    def locateWarehouseProduct(prodId:Int){
      //input product id and then return an area/shelve number
    }

    val orderslist = new Orders(Order(1, "13/06/2016 14:34", 3, "New"))



  }//end of class Orders

  def printListOfOrders2(args: List[_]): Unit = {
    args.foreach(println)
  }


  def pickNextOrder(){
    //checked there are unpicked orders available in the queue
    //view the oldest unpicked order
    //Lambda
    //select Order where datetime is the oldest and status = New

    //also update the status of the picked order to Picked and let the user view the order details



  }


  def updateOrderStatus(ordId: Int){

    for(i <- 0 to orders1.length - 1) {
      if(orders1(i).orderId.toString == orderNo) {
        //update status here
      } else {
        println("There is currently no order with that ID")
      }
    }
  }



    def main(args: Array[String]) {
      //New Orders
      val o1 = new Order(1, "13 JUN 2016 12:30", 1, "New")
      val o2 = new Order(2, "13 JUN 2016 12:32", 2, "New")
      val o3 = new Order(3, "14 JUN 2016 12:30", 3, "New")
      val o4 = new Order(4, "14 JUN 2016 12:32", 4, "New")

      val orders1 = Array(o1,o2,o3,o4)

      val orderNo = readLine("Which order would you like to view?")

      for(i <- 0 to orders1.length - 1) {
        if(orders1(i).orderId.toString == orderNo) {
            println("OrderID: " + orders1(i).orderId + " DateTime: " + orders1(i).dateTime)
        } else {
          println("There is currently no order with that ID")
        }
      }


    }





}


