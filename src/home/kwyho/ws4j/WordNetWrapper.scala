package home.kwyho.ws4j

import edu.cmu.lti.lexical_db.data.Concept
import edu.cmu.lti.lexical_db.{ILexicalDatabase, NictWordNet}
import edu.cmu.lti.ws4j.{Relatedness, RelatednessCalculator}
import edu.cmu.lti.ws4j.impl._
import edu.cmu.lti.ws4j.util.WS4JConfiguration

/**
 * Created by hok1 on 4/16/15.
 */
class WordNetWrapper {

  WS4JConfiguration getInstance() setMFS(true)
  val db : ILexicalDatabase = new NictWordNet()
  val similarityCalculators : Map[String, RelatednessCalculator] = Map(
    "HirstStOnge" -> new HirstStOnge(db), "LeacockChodorow" -> new LeacockChodorow(db),
    "Lesk" -> new Lesk(db), "WuPalmer" -> new WuPalmer(db), "Resnick" -> new Resnik(db),
    "JiangConrath" -> new JiangConrath(db), "Lin" -> new Lin(db), "Path" -> new Path(db)
  )

  def similarityBetweenWords(word1: String, word2: String)(calculator: RelatednessCalculator) : Double =
    calculator calcRelatednessOfWords(word1, word2)

  def similarityBetweenSynsets(synset1: Concept, synset2: Concept)(calculator: RelatednessCalculator) : Relatedness =
    calculator calcRelatednessOfSynset(synset1, synset2)

}
