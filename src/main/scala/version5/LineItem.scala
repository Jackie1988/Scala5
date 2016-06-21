package version5

/**
  * Created by Administrator on 17/06/2016.
  */

case class LineItem(val lineId : Int, val orderId:Int, val productId:Int, val quantity:Int, val porouswareQuantity: Int)

object LineItem {

  val li1 = new LineItem(1, 1, 1, 10, 5)
  val li2 = new LineItem(2, 1, 4, 1, 1)
  val li3 = new LineItem(3, 1, 2, 1, 0)
  val li4 = new LineItem(4, 1, 3, 1, 0)
  val li5 = new LineItem(5, 2, 1, 1, 1)
  val li6 = new LineItem(6, 1, 7, 1, 1)

  var lineItems = Set(li1, li2, li3, li4, li5, li6)

  var lineItems2 = List(li1, li2, li3, li4, li5, li6)

  def findItemsInOrder(ordId:Int) = lineItems.find(_.orderId == ordId)

  def findAllItemsInOrder(ordId: Int): List[LineItem] = lineItems2.filter(_.orderId == ordId)


}
