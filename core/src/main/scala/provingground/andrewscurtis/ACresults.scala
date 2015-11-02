package provingground.andrewscurtis

import provingground._

import Collections._

import upickle.default.{write => uwrite, read => uread, _}

import LinearStructure._

import FiniteDistribution._

import SimpleAcEvolution._

class ACresults(
    paths: Map[String, Vector[(FiniteDistribution[AtomicMove], FiniteDistribution[Moves])]]) {

  def names = (paths map (_._1)).toList
  
  def thmVec(name: String, rank: Int = 2) = paths(name) map (_._2) map (toPresentation(rank, _))

  def thmSupp(name: String, rank: Int = 2) = 
    ((thmVec(name, rank) map (_.supp.toSet)) reduce (_ union _)).toVector
  
  import FreeGroups._
  
  def entropyVec(name: String, rank: Int = 2)(p : Presentation) =
    thmVec(name, rank) map ((fd) => fd.entropy(p))    
  
  def sizes = for ((name, data) <- paths) yield (name -> data.size)

  def states = for ((name, data) <- paths) yield (name -> data.last)

  def combined = vBigSum(states.values.toList)

  def blended = combined |*| (1.0/ paths.size)

  def proofs = blended._2

  def moveWeights = blended._1

  def thms(rank: Int = 2) = toPresentation(rank, proofs)

//  def upickle = uwrite(ACPortableResults(paths))
}

object ACresults{
//  def unpickle(str: String) : ACresults = uread[ACPortableResults](str)
}

case class ACPortableResults(
    paths: Map[String, Vector[(FiniteDistribution[AtomicMove], FiniteDistribution[Moves])]]
    ) extends ACresults(paths)
