package fiuba.fp

import cats.effect._
import services._

object Run extends App {

    val program = IO { 
      println(s"Hello!")
      
      val movies = db.GetMovies()
      movies.foreach(e => println(s"movie: ${e}"))
    
      val anyMovie = db.GetMovieById(1019)
      println(s"Any Movie: ${anyMovie}")
    }

    program.unsafeRunSync() 
}