package stage4

/**
  * Created by Administrator on 17/06/2016.
  */
case class Product(val prodId : Int, val name : String, val desc : String, val price : Double, var quantity : Int, val location : String)

object Product {

  var prod1 = new Product(1, "Big Blue Gnome", "This is a big blue gnome", 12.99, 99, "Aisle J, Shelve 5")
  var prod2 = new Product(2, "Little Blue Gnome", "This is a little blue gnome", 7.99, 90, "Aisle J, Shelve 4")
  var prod3 = new Product(3, "Green Gnome", "This is a green gnome", 17.99, 37, "Aisle H, Shelve 1")
  var prod4 = new Product(4, "Tiny Gnome", "This is a tiny gnome", 2.99, 99, "Aisle E, Shelve 3")
  var prod5 = new Product(5, "Pink Tiny Gnome", "This is a pink tiny gnome", 2.99, 11, "Aisle E, Shelve 1")
  var prod6 = new Product(6, "Justin Beiber Gnome", "This is a Justin Beiber gnome", 22.99, 20, "Aisle D, Shelve 1")
  var prod7 = new Product(7, "Chris Brown Gnome", "This is a Chris Brown gnome", 16.99, 10, "Aisle C, Shelve 2")

  var products = Set(prod1, prod2, prod3, prod4, prod5, prod6, prod7)

  def findProduct(prodId:Int) = products.find(_.prodId == prodId)


}
