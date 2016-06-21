package version5

import scala.collection.mutable.ListBuffer

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

  def printAllOrders() = orders.foreach { println }



  def pickOrder(ordId: Int): Unit ={
    updateOrder(Order(Order.findById(ordId).get.ordId, Order.findById(ordId).get.datetime, Order.findById(ordId).get.custId, "Picked"))
    orders.foreach { println }
    warehouseOrders4.updateInventory(ordId, LineItem.lineItems, Product.products)


    var productIDs = new ListBuffer[Int]()
    var productsToPick = new ListBuffer[Product]()

    for (item <- LineItem.lineItems) {
      var id = item.productId
      productIDs += id

    }
    productIDs.toList


    for (proID <- productIDs) {
      var proItem: Product = Product(Product.findProduct(proID).get.prodId, Product.findProduct(proID).get.name, Product.findProduct(proID).get.desc, Product.findProduct(proID).get.price, Product.findProduct(proID).get.quantity,  Product.findProduct(proID).get.location)
      productsToPick += proItem
    }

    val sorted: List[Product] = productsToPick.sortBy(_.location).toList

    for (s <- sorted){
      println ("ProductID: " + s.prodId + ", Name: " + s.name + ", Quantity: " + s.quantity + ", Location: " + s.location)
    }
  }







}
