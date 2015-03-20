package provingground
import HoTT._
import ScalaUniverses._
import math._
import scala.language.existentials

/**
 * @author gadgil
 */
object Families {
  
  /**
   * a single trait to hold all type patterns, independent of U, with members having type O.
   */
  sealed trait FmlyPtn[O <: Term with Subs[O], C <: Term with Subs[C]]{
    /**
     * the universe containing the type
     */
    val univLevel : Int

    /**
     * type of members
     */
    type MemberType = O
    
    /**
     * scala type (upper bound)
     */
    type FamilyType <:  Term with Subs[FamilyType]
    
    def contract(f: FamilyType)(arg: ArgType): O
    
    def collapse(mem: PairObj[FamilyType, ArgType]) = contract(mem.first)(mem.second)

    type ArgType <: Term with Subs[ArgType]
    
    /**
     * scala type of target for induced functions, i.e., with O = Term
     */
    type TargetType <: Term with Subs[TargetType]
    
    type DepTargetType <: Term with Subs[DepTargetType]
    
    /**
     * returns the type corresponding to the pattern, such as A -> W, given the (inductive) type W
     */
    def apply(tp : Typ[O]) : Typ[FamilyType]

    def target(x : Typ[Cod]) : Typ[TargetType]
    
    type Cod = C
    
    def withCod[CC <: Term with Subs[CC]] : FmlyPtn[O, CC]
    
    /**
    * function induced by f: W -> X of type (A -> W) -> (A -> X) etc
    *
    * @param f function from which to induce
    *
    * @param W the inductive type
    *
    * @param X codomain of the given function
    */
    def induced(f : Func[O, Cod]) : FamilyType => TargetType

    /**
    * dependent function induced by dependent f: W -> X(s) of type (A -> W) -> ((a : A) ~> Xs(a)) etc
    *
    * @param f dependent function from which to induce
    *
    * @param W the inductive type
    *
    * @param Xs family of codomains of the given dependent function
    */
    def inducedDep(f : FuncLike[O, Cod]) : FamilyType => DepTargetType
  }
  
 // type MemberPtn[F <: Term, A <: Term] = PairObj[F, A]
  
      /**
   * A pattern for families, e.g. of inductive types to be defined
   * for instance A -> B -> W, where W is the type to be defined;
   * ends with the type with members.
   * the pattern is a function of the type W.
   *
   * @param U (upper bound on) scala type of an object with the pattern - especially functions.
   * this is needed to ensure that families have a common scala type that can be used inductively.
   */
 /* sealed trait FmlyPtn[U <: Term, T <: Term, D <: Term with Subs[D], O <: Term with Subs[O] C <: Term] extends FmlyPtn[O, C]{
    /**
     * scala type (upper bound)
     */
       type FamilyType = U

       type TargetType= T
       
       type DepTargetType = D
       /*
       /**
        * function induced by f: W -> X of type (A -> W) -> (A -> X) etc
        */
        def induced(W : Typ[Term], X : Typ[Term])(f : Term => Term) : FamilyType => TargetType

        /**
        * dependent function induced by dependent f: W -> X(s) of type (A -> W) -> (A ~> X(s)) etc
        */
        def inducedDep(W : Typ[Term], Xs : Term => Typ[Term])(f : Term => Term) : FamilyType => TargetType
        */
  }
*/

    /**
   * The identity family
   */
  case class IdFmlyPtn[O <: Term with Subs[O], C <: Term with Subs[C]]() extends FmlyPtn[O, C]{
    def apply(W : Typ[O]) = W

    type FamilyType =  O
    
    type ArgType = AtomicTerm
    
    def contract(f: FamilyType)(arg: ArgType): O = f
    
    type TargetType = C
    
    type DepTargetType = C
 
    def target(x: Typ[Cod]) = x
    
    def withCod[CC <: Term with Subs[CC]] = IdFmlyPtn[O, CC]
    
//    type Cod = C
    
//    type MemberType = O
    
    val univLevel = 0

    /**
     * induced function is the given one.
     */
    def induced(f : Func[O, C]) = f

    /**
     * induced function is the given one.
     */
    def inducedDep(f : FuncLike[O, C]) = f
  }
  
  trait RecFmlyPtn[V <: Term with Subs[V], S <: Term with Subs[S], 
    T <: Term, D<: Term with Subs[D], O <: Term with Subs[O], C <: Term with Subs[C]] extends 
        FmlyPtn[O, C]{
    
    type FamilyType <:  FuncLike[Term, V] with Subs[FamilyType]
    
 //   type ArgType <: AbsPair[Typ[Term], S] with Subs[AbsPair[Typ[Term], S]]
    
 //   def contract(f: FamilyType)(arg: ArgType): O = headfibre(arg).contract(f(arg.first))(arg.second)
    
    type TargetType <: FuncLike[Term, T] with Subs[TargetType]
    
    type DepTargetType = FuncLike[Term, D]
    
    val tail : Typ[Term]
    
    val headfibre: Term => FmlyPtn[O, C]{type FamilyType = V; type ArgType = S; type TargetType = T; type DepTargetType = D}
  }
  
  case class FuncFmlyPtn[V <: Term with Subs[V], S<: Term with Subs[S], 
    T <: Term with Subs[T], D <: Term with Subs[D], O <: Term with Subs[O], C <: Term with Subs[C]](
      tail : Typ[Term], 
      head : FmlyPtn[O, C]{type FamilyType = V; type ArgType = S; 
      type TargetType = T; type DepTargetType = D})/*(
        implicit su: ScalaUniv[V])*/ extends RecFmlyPtn[V, S, T, D, O, C]{
    def apply(W: Typ[O]) = FuncTyp[Term, V](tail, head(W))

    type FamilyType =  Func[Term, V]
    
    type ArgType = PairObj[Term, S]
    
    def contract(f: FamilyType)(arg: ArgType): O = headfibre(arg).contract(f(arg.first))(arg.second)
    
    type TargetType = Func[Term, T]
    
  //  type DepTargetType = FuncLike[Term, D]
    
    def target(x: Typ[Cod]) = tail ->: head.target(x)
    
//    type Cod = head.Cod
    
    def withCod[CC <: Term with Subs[CC]] ={
      val newHead = head.withCod[CC]
      FuncFmlyPtn[newHead.FamilyType, newHead.ArgType, newHead.TargetType, newHead.DepTargetType, O, CC](tail, newHead)
    }
    
    val headfibre = (arg: Term) => head 
    
    val univLevel = max(head.univLevel, univlevel(tail.typ))

    /**
     * inductively defining the induced function.
     * maps (g : tail --> head(W)) to func : tail --> head(X) given (head(W) --> head(X))
     *
     */
    def induced(f : Func[O, Cod]) : FamilyType => TargetType = {
        val x = "x" :: tail
        val g = "g" :: apply(f.dom)
        lmbda(g)(
            lmbda(x)(head.induced(f)(g(x))))
        /*
        val func =((t : Term) => head.induced(W, X)(f) (g(t)))
        val codomain = head(X)
        FuncDefn[Term, head.FamilyType](func, tail, codomain)*/
    }

    /**
     * inductively defining the induced function.
     * maps (g : tail --> head(W)) to func : (t : tail) ~> head(Xs(t)) given (head(W) --> (t: tail) ~> head(Xs(t)))
     *
     */
    def inducedDep(f : FuncLike[O, Cod]) : FamilyType => DepTargetType = {
        val x = "x" :: tail
        val g = "g" :: apply(f.dom)
        lambda(g)(
            lambda(x)(head.inducedDep(f)(g(x))))
      /*
      (g : FamilyType) =>
        val func =((t : Term) => head.inducedDep(W, Xs)(f) (g(t)))
        val section = (t : Term) => head(Xs(t))
        val x = "x" :: tail
        val fiber = lmbda(x)(section(x))
     //   val fiber = typFamily[Term, head.FamilyType](tail, section)
        DepFuncDefn[Term, head.FamilyType](func, tail, fiber)*/
    }
  }

    /**
   * Extending by a constant type A a family of type patterns depending on (a : A).
   *
   */
  case class DepFuncFmlyPtn[V <: Term with Subs[V], 
    S<: Term with Subs[S],
    T <: Term with Subs[T], D <: Term with Subs[D], O<: Term with Subs[O], C<: Term with Subs[C]](
      tail: Typ[Term],
      headfibre : Term => FmlyPtn[O, C]{type FamilyType = V; type ArgType = S;
      type TargetType = T; type DepTargetType = D}, 
      headlevel: Int = 0)
      /*(implicit su: ScalaUniv[V])*/ extends RecFmlyPtn[V, S, T, D, O, C]{
    
    type FamilyType =  FuncLike[Term, V]
    
    type ArgType = DepPair[Term, S]
    
    def contract(f: FamilyType)(arg: ArgType): O = headfibre(arg).contract(f(arg.first))(arg.second)
    
    type TargetType = FuncLike[Term, T]
    
   // type DepTargetType = FuncLike[Term, D]
    
    def apply(W : Typ[O]) = {
      val x = "x" :: tail
      val fiber = lmbda(x)(headfibre(x)(W))
   //   val fiber = typFamily(tail,  (t : Term) => headfibre(t)(W))
      PiTyp[Term, V](fiber)
    }
    
  //  type Cod = C

    def target(x: Typ[Cod]) = {
      val a = "a" :: tail
      val targfibre = lmbda(a)(headfibre(a).target(x))
      PiTyp(targfibre)
    }
    
    def withCod[CC <: Term with Subs[CC]] ={
      val newHead = headfibre(tail.symbObj(""))
      type VV = newHead.FamilyType
      type SS = newHead.ArgType
      type TT = newHead.TargetType
      type DD = newHead.DepTargetType
      val newHeadFibre = (t: Term) => 
        (
            headfibre(t).withCod[CC].asInstanceOf[FmlyPtn[O, CC]{
              type FamilyType = VV; type ArgType = SS;
              type TargetType = TT; type DepTargetType = DD}]
            )
      DepFuncFmlyPtn[VV, SS, TT, DD, O, CC](tail, newHeadFibre)
    }
    
    val head = headfibre(tail.symbObj(""))

//    type FamilyType = FuncLike[Term, head.FamilyType]

     def induced(f : Func[O, Cod]) : FamilyType => TargetType = {
        val x = "x" :: tail
        val g = "g" :: apply(f.dom)
        lambda(g)(
            lambda(x)(head.induced(f)(g(x))))
       /*
      (g : FamilyType) =>
        val func =((t : Term) => headfibre(t).induced(W, X)(f) (g(t)))
        val x = "x" :: tail
        val fiber = lmbda(x)(headfibre(x)(X))
    //    val fiber = typFamily[Term, V](tail,  (t : Term) => headfibre(t)(X))
        DepFuncDefn[Term, V](func, tail, fiber)*/
    }

    def inducedDep(f : FuncLike[O, Cod]) : FamilyType => DepTargetType = {
        val x = "x" :: tail
        val g = "g" :: apply(f.dom)
        lambda(g)(
            lambda(x)(head.inducedDep(f)(g(x))))
      /*
      (g : FamilyType) =>
        val func =((t : Term) => headfibre(t).induced(W, Xs(t))(f) (g(t)))
        val x = "x" :: tail
        val fiber = lmbda(x)(headfibre(x)(Xs(x)))
      //  val fiber = typFamily[Term, V](tail, (t : Term) => headfibre(t)(Xs(t)))
        DepFuncDefn[Term, V](func, tail, fiber)*/
    }

    val univLevel = max(univlevel(tail.typ), headlevel)
  }
  
  /*
  trait Member[V <: Term with Subs[V], O <: Term with Subs[O] C <: Term]{self =>
//    type Cod <: Term
    
    val fmlyPtn : FmlyPtn[O, C]{type FamilyType = self.FamilyType; 
      type TargetType = self.TargetType; 
      type DepTargetType = self.DepTargetType}
    
    type FamilyType = V
    
    type TargetType <: Term with Subs[TargetType]
    
    type DepTargetType <: Term with Subs[DepTargetType]
    
 //   val typ: Typ[O]
    
 //   val value:  O
   
    def apply(f: FamilyType) : O
  }
  
  
  case class JustMember[O <: Term with Subs[O], C <: Term with Subs[C]]() extends Member[O, O, C]{
    lazy val fmlyPtn = IdFmlyPtn[O, C]
    type Cod = Term
    
//    type FamilyType =  O
    
    type TargetType = C
    
    type DepTargetType = C
    
    def apply(f: FamilyType) = f
  }
  
  
  
  case class FuncMember[V <: Term with Subs[V], T <: Term with Subs[T], D <: Term with Subs[D], O <: Term with Subs[O] C <: Term](
      tail : Typ[Term], arg: Term, 
      headfibre : Term => Member[V, O, C]{//type FamilyType = V; 
        type TargetType = T; 
        type DepTargetType = D}
      ) extends Member[Func[Term, V], O, C]{self =>
 //   type FamilyType = Func[Term, V]; 
    
    type TargetType = Func[Term, T]; 
    
    type DepTargetType = FuncLike[Term, D]
    
    
    lazy val fmlyPtn = FuncFmlyPtn(tail, headfibre(arg).fmlyPtn)
      //FuncFmlyPtn(tail, headfibre(arg).fmlyPtn)
   
//    lazy val typ = FuncTyp(tail, headfibre(arg).typ) 
   
 //   lazy val value = headfibre(arg).value
    
    def apply(f: FamilyType) = headfibre(arg)(f(arg))
  }
  
  case class DepFuncMember[V <: Term with Subs[V], T <: Term with Subs[T], D <: Term with Subs[D], O <: Term with Subs[O] C <: Term](
      tail : Typ[Term], arg: Term, 
      headfibre : Term => Member[V, O, C]{type FamilyType = V; 
        type TargetType = T; 
        type DepTargetType = D}
      ) extends Member[FuncLike[Term, V], O, C]{
 //   type FamilyType = FuncLike[Term, V]; 
    
    type TargetType = FuncLike[Term, T]; 
    
    type DepTargetType = FuncLike[Term, D]
    
    private val x = "x" :: tail
    
    lazy val fmlyPtn = DepFuncFmlyPtn[V, T, D, O, C](tail, (a: Term) => headfibre(a).fmlyPtn)
   
 //   lazy val fibre = lmbda(x)(headfibre(x).typ)
    
 //   lazy val typ = PiTyp(fibre)  
   
    def apply(f: FamilyType) = headfibre(arg)(f(arg))
    
 //   lazy val value = headfibre(arg).value
  }
  */

}