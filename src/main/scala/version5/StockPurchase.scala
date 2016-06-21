package version5

/**
  * Created by Administrator on 17/06/2016.
  */

case class StockPurchase(val dId :Int, val dtMade :String, val sup :String, var sta :String, var dtDelivered :String) {}

object StockPurchase {

  var sp1 = new StockPurchase(1, "16 JUN 2016 10:58", "Gnomes R Us", "Purchased", "Not Delivered")
  var sp2 = new StockPurchase(2, "10 JUN 2016 10:58", "Gnomes R Us", "Purchased", "Not Delivered")
  var sp3 = new StockPurchase(3, "1 JUN 2016 10:58", "Gnomes R Us", "Delivered", "6 JUN 2016 16:23")
  var sp4 = new StockPurchase(4, "4 JUN 2016 10:58", "Gnomes R Us", "Delivered", "9 JUN 2016 12:26")

  var stockpurchases = Set(sp1, sp2, sp3, sp4)


  def findSpById(spId:Int) = stockpurchases.find(_.dId == spId)


  //method to receive the new stock by finding the stock purchase object and updating it
  def updateStockPurchase(stockPurchase: StockPurchase): Unit = {
    stockpurchases -= (findSpById(stockPurchase.dId).get)
    stockpurchases = stockpurchases + stockPurchase
  }


  def addNewStockPurchase(newSP: StockPurchase): Unit ={
        stockpurchases += newSP
  }


  def printAllStockPurchases(): Unit ={
    for (s <- stockpurchases){
      println ("StockPurchaseID: " + s.dId + ", Status: " + s.sta + ", Date Delivered: " + s.dtDelivered)
    }
  }







}
