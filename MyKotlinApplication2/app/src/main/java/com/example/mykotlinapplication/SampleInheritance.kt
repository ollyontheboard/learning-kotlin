package com.example.mykotlinapplication

//parent class uses keyword open
open class SampleInheritance {
//member variable for parent class
    var day = "Wednesday"

    open fun hello(){
        print("Hello")
    }

}
//child class inheriting parent class
class  ChildClass: SampleInheritance(){
    //object instantiation
      var childClass = ChildClass()
      override fun hello(){}


    fun main(args: Array<String>){
//accessing parent member variable using child class
        childClass.day= "Friday"
        childClass.hello()
    }


}
