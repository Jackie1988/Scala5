package stage4

import java.util.Calendar

import scala.collection.mutable.ListBuffer
import scala.io.StdIn.readLine

/**
  * Created by Administrator on 17/06/2016.
  */
object warehouseOrders4 {

 /* def menue(): Unit = {
    println("options...")
    val userInput = readLine("Which order would you like to view?").toInt
    match(userInput) {
      case 1 => {
        viewOrder()
        menue()
      }
      case 2 => {
        receiveNewStock(_, _, _, _)
        menue()
      }
      case 3 => println("bye bye!")
      case _ => menue()
    }
  } */




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


      //print list of orders
      val printList = readLine("Type yes to print a list of orders")
      val StockPurchase = readLine("Type add to add a stock purchase or delivered if a stock purchase has been delivered")
      val RemoveStock = readLine("Type remove to remove stock from Inventory")
      val FindStock = readLine("Type find to locate stock in warehouse")

      if ((printList == "yes") || (printList == "Yes")){
        Order.orders.foreach { println }
        val orderNo = readLine("Which order would you like to view?").toInt
            println("OrderID: " + Order.findById(orderNo).get.ordId + ", DateTime: " + Order.findById(orderNo).get.datetime + ", CustomerID: " + Order.findById(orderNo).get.custId + ", Status: " + Order.findById(orderNo).get.status)

       // println("OrderID: " + LineItem.findItemsInOrder(orderNo).get.orderId + ", ProductID: " + LineItem.findItemsInOrder(orderNo).get.productId + ", Quantity: " + LineItem.findItemsInOrder(orderNo).get.quantity + ", Quantity needing porousware: " + LineItem.findItemsInOrder(orderNo).get.porouswareQuantity)

        val list = LineItem.findAllItemsInOrder(orderNo)

        for (item <- list){
          println("OrderID: " + item.orderId + ", ProductID: " + item.productId + ", Quantity: " + item.quantity + ", Quantity needing porousware: " + item.porouswareQuantity)
        }


        val newStatus = readLine("Type pick to pick this order and update its status")

            if (newStatus == "pick"){
              Order.updateOrder(Order(Order.findById(orderNo).get.ordId, Order.findById(orderNo).get.datetime, Order.findById(orderNo).get.custId, "Picked"))
              Order.orders.foreach { println }
              updateInventory(orderNo, LineItem.lineItems, Product.products)


              var productIDs = new ListBuffer[Int]()
              var productsToPick = new ListBuffer[Product]()

              for (item <- LineItem.lineItems) {
                  var id = item.productId
                  productIDs += id

              }
              productIDs.toList
              productIDs.foreach { println }


              for (proID <- productIDs) {
                  var proItem: Product = Product(Product.findProduct(proID).get.prodId, Product.findProduct(proID).get.name, Product.findProduct(proID).get.desc, Product.findProduct(proID).get.price, Product.findProduct(proID).get.quantity,  Product.findProduct(proID).get.location)
                  productsToPick += proItem
              }

                val sorted: List[Product] = productsToPick.sortBy(_.location).toList

                for (s <- sorted){
                  println ("ProductID: " + s.prodId + ", Name: " + s.name + ", Quantity: " + s.quantity + ", Location: " + s.location)
                }


             } else {
            }
          }

     /* else if(StockPurchase == "add"){

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
        receiveNewStock(delId, stockPurchaseItems, products, date)

        for (i <- 0 to products.length - 1){
          println ("ProductID: " + products(i).prodId + ", Name: " + products(i).name + ", Quantity: " + products(i).quantity + ", Location: " + products(i).location)
        }

        //Stock Purchase status needs to be updated to Delivered with a date/time inputted
        StockPurchase.stockpurchases(delId).sta = "Delivered"
        StockPurchase.stockpurchases(delId).dtDelivered = date

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

      } */




    }


}




case class AccountsMessage(var messages :String)



