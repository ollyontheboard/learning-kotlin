package com.example.nmykotlinapplication
//primary constructor initialized at header level
fun  main(args:Array<String>){


}
class SampleConstructor(var age:Int ) {

    //init block used to initialize primary constructor parameters
    init {
        age= 56
    }
//initialization of name (parameter to sec constructor). it's parameters cannot be reassigned(val)
    val name: String= "Olisah"
//secondary constructor declaration. with call to primary/super constructor
    constructor( name:String, age: Int):this(age){

    }


}