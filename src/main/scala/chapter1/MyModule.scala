package chapter1

object MyModule extends App {

  // exercise 2.1
  def fibonacci(n: Int): Int = {
    if (n <= 1) n
    else fibonacci(n-2) + fibonacci(n-1)
  }
  println(fibonacci(6)) //8

  //exercise 2.2 polymorphic functions
  def isSorted[A](as: Array[A], ordered: (A,A) => Boolean): Boolean = {
    @annotation.tailrec
    def loop(n: Int): Boolean = {
      if (n > as.length) true
      else if (!ordered(as(n), as(n+1))) false
      else loop(n+1)
    }
    loop(0)
  }

  def ordered[A](item1: A, item2: A): Boolean = {
    if (item2 == item1) true
    else false
  }
  println(isSorted(Array(1,2,3,4), ordered))

  // Exercise 2.3 currying. Has 3 type parameters ABC. Takes one argument as a function of 2 arguments and returns a function with one argument (which is another function).
  def curry[A,B,C](f: (A,B) => C): A => (B => C) =
    a => b => f(a, b)

  // Exercise 2.4. Has 3 type params ABC. Takes 1 argument as a function of one argument and returns a function with 2 arguments
  def uncurry[A,B,C](f: A => B => C): (A,B) => C =
    (a,b) => f(a)(b)
  // Exercise 2.5. Has 3 type params ABC. Takes 2 arguments, both functions with 1 argument. It returns another function with one argument
  def compose[A,B,C](f: B => C, g: A => B): A => C =
    a => f(g(a))

  def f(b: Int): Int = b / 2
  def g(a: Int): Int = a + 2

  println(compose(f, g)(22)) // (22 + 2) / 2 = 12
}

