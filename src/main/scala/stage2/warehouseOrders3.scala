package stage2

import java.util.Calendar
import scala.collection.mutable.ListBuffer
import scala.io.StdIn.readLine
/**
  * Created by Administrator on 15/06/2016.
  */
object warehouseOrders3 {

  case class Order(var ordId :Int, var datetime :String, var custId :Int, var status :String)

  case class StockPurchase(val dId :Int, val dtMade :String, val sup :String, var sta :String, var dtDelivered :String)

  case class StockPurchaseItem(val spiId : Int, val pId :Int, val sdId :Int, val quan : Int)

  case class LineItem(val lineId : Int, val orderId:Int, val productId:Int, val quantity:Int, val porouswareQuantity: Int)

  case class OrderItemsList(lineItems:List[LineItem])

  case class Product(val prodId : Int, val name : String, val desc : String, val price : Double, var quantity : Int, val location : String)

  class Orders(a: Order*) {
    private val orderList:List[Order] = a.toList



    def informAccounts(){
      //inform Accounts that a delivery has been made
    }





    val orderslist = new Orders(Order(1, "13/06/2016 14:34", 3, "New"))



  }//end of class Orders


  def printListOfOrders2(args: List[_]): Unit = {
    args.foreach(println)
  }


  def receiveNewStock(spId : Int, spItems : Array[StockPurchaseItem], products : Array[Product]){
    //updateInventory with new stock
    for (i <- 0 to spItems.length - 1){
      if (spId == spItems(i).sdId){

        for (j <- 0 to products.length - 1){
          if (products(j).prodId == spItems(i).pId){
            products(j).quantity += spItems(i).quan
          }
        }
      }
    }
  }



  def updateInventory(orderID: Int, lineItems : Array[LineItem], products : Array[Product]){
    //update Inventory when an Order's status has changed to picked
    //decrement each product's quantity by the quantity in the lineItem instance
    for (i <- 0 to lineItems.length - 1){
    if (orderID == lineItems(i).orderId){

      for (j <- 0 to products.length - 1){
        if (products(j).prodId == lineItems(i).productId){
          products(j).quantity -= lineItems(i).quantity
        }
      }
    }
    }
  }

  def removeStock(productID: Int, quantity: Int, products : Array[Product]){
    //update Inventory when stock needs to be removed
    for (i <- 0 to products.length - 1){
      if (productID == products(i).prodId){

            products(i).quantity -= quantity
      }
    }
  }


  def locateWarehouseProduct(prodId:Int, products : Array[Product]){
    //input product id and then return an aisle/shelve number
    for (i <- 0 to products.length - 1) {
      if (prodId == products(i).prodId) {
        val prodLocation = products(i).location

        print (prodLocation)
      }

    }
  }



  def main(args: Array[String]) {


    //New Orders
    var o1 = new Order(1, "13 JUN 2016 12:30", 1, "New")
    var o2 = new Order(2, "13 JUN 2016 12:32", 2, "New")
    var o3 = new Order(3, "14 JUN 2016 12:30", 3, "New")
    var o4 = new Order(4, "14 JUN 2016 12:32", 4, "New")

    var orders1 = Array(o1,o2,o3,o4)

    var prod1 = new Product(1, "Big Blue Gnome", "This is a big blue gnome", 12.99, 99, "Aisle J, Shelve 5")
    var prod2 = new Product(2, "Little Blue Gnome", "This is a little blue gnome", 7.99, 90, "Aisle J, Shelve 4")
    var prod3 = new Product(3, "Green Gnome", "This is a green gnome", 17.99, 37, "Aisle H, Shelve 1")
    var prod4 = new Product(4, "Tiny Gnome", "This is a tiny gnome", 2.99, 99, "Aisle E, Shelve 3")

    var products = Array(prod1, prod2, prod3, prod4)

    val li1 = new LineItem(1, 1, 1, 10, 5)
    val li2 = new LineItem(2, 1, 4, 1, 1)
    val li3 = new LineItem(3, 1, 2, 1, 0)
    val li4 = new LineItem(4, 1, 3, 1, 0)

    var lineItems = Array(li1, li2, li3, li4)

    var sp1 = new StockPurchase(1, "16 JUN 2016 10:58", "Gnomes R Us", "Purchased", "Not Delivered")
    var sp2 = new StockPurchase(2, "10 JUN 2016 10:58", "Gnomes R Us", "Purchased", "Not Delivered")
    var sp3 = new StockPurchase(3, "1 JUN 2016 10:58", "Gnomes R Us", "Delivered", "6 JUN 2016 16:23")
    var sp4 = new StockPurchase(4, "4 JUN 2016 10:58", "Gnomes R Us", "Delivered", "9 JUN 2016 12:26")

    var stockpurchases = Array(sp1, sp2, sp3, sp4)

    val spi1 = new StockPurchaseItem(1, 1, 1, 12)
    val spi2 = new StockPurchaseItem(2, 2, 1, 10)
    val spi3 = new StockPurchaseItem(3, 3, 1, 24)
    val spi4 = new StockPurchaseItem(4, 4, 1, 30)

    var stockPurchaseItems = Array(spi1, spi2, spi3, spi4)




    //print list of orders
    val printList = readLine("Type yes to print a list of orders")
    val StockPurchase = readLine("Type add to add a stock purchase or delivered if a stock purchase has been delivered")
    val RemoveStock = readLine("Type remove to remove stock from Inventory")
    val FindStock = readLine("Type find to locate stock in warehouse")

    if ((printList == "yes") || (printList == "Yes")){
      orders1.foreach { println }


      val orderNo = readLine("Which order would you like to view?").toInt

      for(i <- 0 to orders1.length - 1) {
        if(orders1(i).ordId == orderNo) {

          println("OrderID: " + orders1(i).ordId + ", DateTime: " + orders1(i).datetime + ", CustomerID: " + orders1(i).custId + ", Status: " + orders1(i).status)

          for (i <- 0 to lineItems.length - 1){
            if (orderNo == lineItems(i).orderId){
              println("OrderID: " + lineItems(i).orderId + ", ProductID: " + lineItems(i).productId + ", Quantity: " + lineItems(i).quantity + ", Quantity needing porousware: " + lineItems(i).porouswareQuantity)
            }
          }

          val newStatus = readLine("Type picked to pick this order and update its status")

          if (newStatus == "picked"){
            println (newStatus)
            orders1(orderNo - 1).status = newStatus
            orders1.foreach { println }
            updateInventory(orderNo, lineItems, products)

            for (i <- 0 to products.length - 1){
              println ("ProductID: " + products(i).prodId + ", Name: " + products(i).name + ", Quantity: " + products(i).quantity + ", Location: " + products(i).location)
            }
          }

        } else {

        }
      }
    }//end of orders
    else if(StockPurchase == "add"){

      val id = readLine("What is the id of the new stock purchase?").toInt
      val date1 = readLine("What was the date and time of the purchase?")
      val supp = readLine("Who is the supplier")
      var stat = readLine("What is the status of the purchase?")
      var date2 = "Not Delivered"

      var newStock = new StockPurchase(id, date1, supp, stat, date2)

      var stockpurchases2 = Array(newStock)

      var allStockPurchases = stockpurchases ++ stockpurchases2

      for (i <- 0 to allStockPurchases.length - 1){
      println ("StockPurchaseID: " + allStockPurchases(i).dId + " Date/Time of Purchase: " + allStockPurchases(i).dtMade + " Supplier: " + allStockPurchases(i).sup + " Status: " + allStockPurchases(i).sta + " Date/Time of Delivery: " + allStockPurchases(i).dtDelivered)
      }



    } else if (StockPurchase == "delivered") {
      val delId = readLine("What is the id of the delivered stock purchase?").toInt
      val date = readLine("What date and time was this stock delivered?")
      receiveNewStock(delId, stockPurchaseItems, products)

      for (i <- 0 to products.length - 1){
        println ("ProductID: " + products(i).prodId + ", Name: " + products(i).name + ", Quantity: " + products(i).quantity + ", Location: " + products(i).location)
      }

      //Stock Purchase status needs to be updated to Delivered with a date/time inputted
      stockpurchases(delId).sta = "Delivered"
      stockpurchases(delId).dtDelivered = date

      for (i <- 0 to stockpurchases.length - 1){
        println ("DeliveryID: " + stockpurchases(i).dId + ", Status: " + stockpurchases(i).sta + ", Date Delivered: " + stockpurchases(i).dtDelivered)
      }

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

    }





  }


}
