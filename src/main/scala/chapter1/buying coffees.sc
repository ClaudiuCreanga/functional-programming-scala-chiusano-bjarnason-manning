val test: String = "da"
val test2: Char = 'd'

def compose[A,B,C](f: B => C, g: A => B): A => C =
  a => f(g(a))

def f(b: Int): Int = b / 2
def g(a: Int): Int = a + 2

println(compose(f, g)(0))
println(compose(f, g)(22) )

