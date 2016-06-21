package version5

/**
  * Created by Administrator on 17/06/2016.
  */

case class StockPurchaseItem(val spiId : Int, val pId :Int, val sdId :Int, val quan : Int)

object StockPurchaseItem {

  val spi1 = new StockPurchaseItem(1, 1, 1, 12)
  val spi2 = new StockPurchaseItem(2, 2, 1, 10)
  val spi3 = new StockPurchaseItem(3, 3, 1, 24)
  val spi4 = new StockPurchaseItem(4, 4, 1, 30)

  var stockPurchaseItems = Set(spi1, spi2, spi3, spi4)



  //method to add the received stock to the inventory
  def addNewStock(spId : Int, spItems : Array[StockPurchaseItem], products : Array[Product], date :String){
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
    //inform Accounts
    //var accountsMsg = new AccountsMessage("A Stock delivery was received on $date with an id of $spId")
  }





}
