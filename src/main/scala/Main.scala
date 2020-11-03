import dbService._

object Main extends App {
  println("Hello, World!!!")

  val movies = db.GetMovies()
  movies.foreach(e => println(s"movie: ${e}"))

  val anyMovie = db.GetMovieById(1019)
  println(s"Any Movie: ${anyMovie}")
}