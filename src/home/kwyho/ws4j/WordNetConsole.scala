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
      println(word1+" ~ "+word2+" : ")
      def simCalculator = wrapper.similarityBetweenWords(word1, word2)(_)
      def printSimilarity(relatednessName: String) : Unit = println("\t"+relatednessName+" = "+simCalculator(wrapper.similarityCalculators(relatednessName)))
      wrapper.similarityCalculators.keys.foreach(printSimilarity)

      word1 = readLine("word1 > ")
      word2 = readLine("word2 > ")
    }
  }
}
