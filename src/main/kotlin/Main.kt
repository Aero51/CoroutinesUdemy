package org.example

import kotlinx.coroutines.CoroutineName
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() {

runBlocking {
    val job1=launch {
        delay(3000L)
        println("Job1 launched")
    }
    job1.invokeOnCompletion { println("Job 1 completed") }
    delay(500L)

    println("Job 1 will be cancelled")
    job1.cancel()
}

}
/*
______________________________-
var functionCalls = 0
suspend fun completeMessage() {
    delay(500L)
    println("World")
    functionCalls++

}

suspend fun improveMessage() {
    delay(1000L)
    println("Suspend functions are cool")
    functionCalls++
}


fun main() {


    GlobalScope.launch { completeMessage()}
    GlobalScope.launch { improveMessage()}
        print("Hello, ")
        Thread.sleep(2000L)
        println("There have been $functionCalls calls so far")
    }




   _________________________________________
   runBlocking {
       launch(CoroutineName("MyCoroutine"))
       {
           println("This is run from ${coroutineContext.get(CoroutineName.Key)}")

       }



   }


   ____________________________________________
  println("Program execution will now block")
  runBlocking {
      launch {
          delay(1000L)
          println("Task from run blocking")
      }
      GlobalScope.launch {
          delay(500L)
          println("Task from GlobalScope")
      }
      coroutineScope {
          launch {
              delay(1500L)
              println("Task from coroutineScope")
          }
      }
  }
  println("Program execution will now continue")


  ___________________________________

  runBlocking {
      repeat(100_000) {
          launch { print(".") }
      }
  }


  ___________________________________-

  GlobalScope.launch {
      delay(1000)
      println("World!")
  }

  print ("Hello, ")
  Thread.sleep(2000)


   */
