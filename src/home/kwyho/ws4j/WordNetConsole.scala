package home.kwyho.ws4j

/**
 * Created by hok1 on 4/16/15.
 */
object WordNetConsole {
  def main(args: Array[String]) : Unit = {
    val wrapper = new WordNetWrapper()

    var word1 = readLine("word1 > ")
    var word2 = readLine("word2 > ")
    while ((word1.length()>0) && (word2.length()>0)) {
      println(word1+" ~ "+word2+" : "+wrapper.similarityBetweenWords(word1, word2, wrapper.similarityCalculators("WuPalmer")))

      word1 = readLine("word1 > ")
      word2 = readLine("word2 > ")
    }
  }
}
