package version5

import scala.collection.mutable.ListBuffer
import scala.io.StdIn.readLine

/**
  * Created by Administrator on 17/06/2016.
  */
object warehouseOrders4 {

  def menu(): Unit = {

    val userInput = readLine("Which option would you like?") match {


      case "print" => {
        Order.printAllOrders()
        val orderNo = readLine("Which order would you like to view?").toInt
        println("OrderID: " + Order.findById(orderNo).get.ordId + ", DateTime: " + Order.findById(orderNo).get.datetime + ", CustomerID: " + Order.findById(orderNo).get.custId + ", Status: " + Order.findById(orderNo).get.status)
        val list = LineItem.findAllItemsInOrder(orderNo)

        for (item <- list){
          println("OrderID: " + item.orderId + ", ProductID: " + item.productId + ", Quantity: " + item.quantity + ", Quantity needing porousware: " + item.porouswareQuantity)
        }

        val newStatus = readLine("Type pick to pick this order and update its status")

        if (newStatus == "pick") {
          Order.pickOrder(orderNo)
        }

        menu()
      }


      case "remove" => {
        val prodId = readLine("What is the product id of the stock you want to remove?").toInt
        val quan = readLine("How many of these need removing?").toInt

        Product.removeStock(prodId, quan)

        for (i <- Product.products){
          println ("ProductID: " + i.prodId + ", Name: " + i.name + ", Quantity: " + i.quantity)
        }
        menu()
      }


      case "locate" => {
        val pId = readLine("What is the product id?").toInt
        Product.locateWarehouseProduct(pId)

        menu()
      }


      case "add" => {
        val id = readLine("What is the id of the new stock purchase?").toInt
        val date1 = readLine("What was the date and time of the purchase?")
        val supp = readLine("Who is the supplier")
        val stat = readLine("What is the status of the purchase?")
        val date2 = "Not Delivered"
        var newStock = new StockPurchase(id, date1, supp, stat, date2)

        StockPurchase.addNewStockPurchase(newStock)

        menu()
      }


      case "receive" => {
        val delId = readLine("What is the id of the delivered stock purchase?").toInt
        val date = readLine("What date and time was this stock delivered?")

        //Stock Purchase status needs to be updated to Delivered with a date/time inputted
        StockPurchase.updateStockPurchase(StockPurchase(StockPurchase.findSpById(delId).get.dId, StockPurchase.findSpById(delId).get.dtMade, StockPurchase.findSpById(delId).get.sup, "Delivered", date))

        menu()
      }


      case _ => menu()



      case "exit" => println("bye bye!")
    }
  }




    def printListOfOrders2(args: List[_]): Unit = {
      args.foreach(println)
    }





    //maybe this method belongs in the LineItem class??
    def updateInventory(orderID: Int, lineItems : Set[LineItem], products : Set[Product]){
      //update Inventory when an Order's status has changed to picked
      //decrement each product's quantity by the quantity in the lineItem instance
      for (i <- 0 to lineItems.size - 1){
        //if (orderID == lineItems(i).orderId){

          for (j <- 0 to products.size -1){
           // if (products(j).prodId == lineItems(i).productId){
           //   products(j).quantity -= lineItems(i).quantity
            //}
          }
        }
      }


   /* def removeStock(productID: Int, quantity: Int, products : Set[Product]){
      //update Inventory when stock needs to be removed
      /*for (i <- 0 to products.size - 1){
        if (productID == products(i).prodId){

          products(i).quantity -= quantity
        }
      } */

      for (prod <- products){
        if (productID == prod.prodId){

          prod.quantity -= quantity
        }
      }


    }*/






    def main(args: Array[String]) {


      println("options...")
      println("Type print to view list of Orders")
      println("Type remove to remove stock for a reason other than forfilling an order")
      println("Type locate to locate a product in the warehouse")
      println("Type add to add a stock purchase to the system")
      println("Type receive to receive a stock purchase delivery")

      menu()


      //print list of orders
      //val printList = readLine("Type yes to print a list of orders")
      //val StockPurchase = readLine("Type add to add a stock purchase or delivered if a stock purchase has been delivered")
      //val RemoveStock = readLine("Type remove to remove stock from Inventory")
      //val FindStock = readLine("Type find to locate stock in warehouse")




        /*



      } else if (RemoveStock == "remove"){
        val prodId = readLine("What is the product id of the stock you want to remove?").toInt
        val quan = readLine("How many of these need removing?").toInt

        removeStock(prodId, quan, products)

        for (i <- 0 to products.length - 1){
          println ("ProductID: " + products(i).prodId + ", Name: " + products(i).name + ", Quantity: " + products(i).quantity)
        }


      } else if(FindStock == "find"){
        val pId = readLine("What is the product id?").toInt
        locateWarehouseProduct(pId, products)

      } */




    }


}




case class AccountsMessage(var messages :String)



