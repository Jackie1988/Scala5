package hello

/**
  * Created by Administrator on 14/06/2016.
  */
class Product(id: Int, name:String, desc:String, price:Double, quantity:Int, warehouse_location:String) {

  def AddQuantity(id:Int, quantity:Int) {

    println("Customer id: " + id)
  }
}
