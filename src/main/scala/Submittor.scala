import sttp.client._
import sttp.client.circe._
import io.circe.{ Decoder, Encoder, HCursor, Json }
import scala.io.Source
case class Payload(
                  code: String,
                  language: String = "scala",
                  contest_slug: String = "master",
                  playlist_slug: String = "",
                  ) {

}

case class MResponse(model: Model)

case class Model(
                    id: Int,
                    status_code: Int
                  ) {
}

object Submittor {
  implicit val encode: Encoder[Payload] = new Encoder[Payload] {
    final def apply(a: Payload): Json = Json.obj(
      ("code", Json.fromString(a.code)),
      ("language", Json.fromString(a.language)),
      ("contest_slug", Json.fromString(a.contest_slug)),
      ("playlist_slug", Json.fromString(a.playlist_slug)),
    )
  }

  implicit val decodeModel: Decoder[Model] = new Decoder[Model] {
    final def apply(c: HCursor): Decoder.Result[Model] =
      for {
        id <- c.downField("id").as[Int]
        status_code <- c.downField("status_code").as[Int]
      } yield {
        Model(id, status_code)
      }
  }

  implicit val decode: Decoder[MResponse] = new Decoder[MResponse] {
    final def apply(c: HCursor): Decoder.Result[MResponse] =
      for {
        model <- c.downField("model").as[Model]
      } yield {
        MResponse(model)
      }
  }

  def submit(): Unit = {
    val sort: Option[String] = None
    val query = "http language:scala"

    val code = Source.fromResource("sample.txt").getLines.mkString
    implicit val backend = HttpURLConnectionBackend()

    val response = basicRequest
      .auth.basic("", "")
      .post(uri"https://www.hackerrank.com/rest/contests/master/challenges/maximum-perimeter-triangle/submissions")
      .body(Payload(code))
      .response(asJson[MResponse])
      .send()

    println(response.body)
  }

  def main(args: Array[String]): Unit = {
    submit()
  }
}
