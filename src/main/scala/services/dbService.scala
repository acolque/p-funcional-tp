package dbService

import doobie._
import doobie.implicits._
import cats.effect.IO
import scala.concurrent.ExecutionContext

object db {
  def GetMovies(): List[Any] = {
    implicit val cs = IO.contextShift(ExecutionContext.global)

    val transactor = Transactor.fromDriverManager[IO](
        "org.postgresql.Driver",
        "jdbc:postgresql://localhost:5432/fpalgo",
        "fiuba","password")
    
    // val sql = sql"select name from fptp.movie where rating = 'R'"
    val sql = sql"select name from fptp.movie"
    val query = sql.query[String]
    val tQuery = query.to[List]
    val runnable = tQuery.transact(transactor)
    val result = runnable.unsafeRunSync()

    return result
  }

  def GetMovieById(id: Int): Any = {
    implicit val cs = IO.contextShift(ExecutionContext.global)

    val transactor = Transactor.fromDriverManager[IO](
        "org.postgresql.Driver",
        "jdbc:postgresql://localhost:5432/fpalgo",
        "fiuba","password")

    val q = sql"select name from fptp.movie where movie_id=${id}"
            .query[String]
            .unique
    val result = q.transact(transactor).unsafeRunSync()
    return result
  }
}

    

