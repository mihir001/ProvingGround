package provingground.library
import provingground._
import HoTT._
import induction._
import implicits._
import shapeless._
import Fold._

import interface._
object LeanMemo {
  val defMap = Map(trepplein.Name("decidable") -> ("decidable" :: FuncTyp(Prop, Type)), trepplein.Name("nat", "brec_on") -> nat$brec_on.value, trepplein.Name("nat", "decidable_eq", "_main") -> nat$decidable_eq$_main.value, trepplein.Name("monoid", "mul") -> monoid$mul.value, trepplein.Name("monoid", "to_has_one") -> monoid$to_has_one.value, trepplein.Name("decidable", "cases_on") -> decidable$cases_on.value, trepplein.Name("has_inv", "mk") -> ("has_inv.mk" :: piDefn("'c" :: Type)(FuncTyp(FuncTyp("'c" :: Type, "'c" :: Type), ("has_inv" :: FuncTyp(Type, Type))("'c" :: Type)))), trepplein.Name("has_one") -> ("has_one" :: FuncTyp(Type, Type)), trepplein.Name("monoid", "one") -> monoid$one.value, trepplein.Name("punit", "star") -> ("punit.star" :: "punit" :: Type), trepplein.Name("nat", "zero") -> ("nat.zero" :: "nat" :: Type), trepplein.Name("nat", "succ") -> ("nat.succ" :: FuncTyp("nat" :: Type, "nat" :: Type)), trepplein.Name("monoid") -> ("monoid" :: FuncTyp(Type, Type)), trepplein.Name("pprod", "mk") -> ("pprod.mk" :: piDefn("'f_867761158" :: Type)(piDefn("'g_952015611" :: Type)(FuncTyp("'f_867761158" :: Type, FuncTyp("'g_952015611" :: Type, ("pprod" :: FuncTyp(Type, FuncTyp(Type, Type)))("'f_867761158" :: Type)("'g_952015611" :: Type)))))), trepplein.Name("nat", "no_confusion") -> nat$no_confusion.value, trepplein.Name("pprod") -> ("pprod" :: FuncTyp(Type, FuncTyp(Type, Type))), trepplein.Name("eq", "refl") -> ("eq.refl" :: piDefn("'e_1731622754" :: Type)(piDefn("'f_1219463498" :: "'e_1731622754" :: Type)(("eq" :: piDefn("'c_1674425354" :: Type)(FuncTyp("'c_1674425354" :: Type, FuncTyp("'c_1674425354" :: Type, Prop))))("'e_1731622754" :: Type)("'f_1219463498" :: "'e_1731622754" :: Type)("'f_1219463498" :: "'e_1731622754" :: Type)))), trepplein.Name("has_inv", "inv") -> has_inv$inv.value, trepplein.Name("nat", "decidable_eq", "_match_1") -> nat$decidable_eq$_match_1.value, trepplein.Name("has_mul", "mk") -> ("has_mul.mk" :: piDefn("'d" :: Type)(FuncTyp(FuncTyp("'d" :: Type, FuncTyp("'d" :: Type, "'d" :: Type)), ("has_mul" :: FuncTyp(Type, Type))("'d" :: Type)))), trepplein.Name("punit") -> ("punit" :: Type), trepplein.Name("rfl") -> rfl.value, trepplein.Name("nat", "decidable_eq") -> nat$decidable_eq.value, trepplein.Name("decidable", "is_true") -> ("decidable.is_true" :: piDefn("'c_389126704" :: Prop)(FuncTyp("'c_389126704" :: Prop, ("decidable" :: FuncTyp(Prop, Type))("'c_389126704" :: Prop)))), trepplein.Name("monoid", "to_semigroup") -> monoid$to_semigroup.value, trepplein.Name("semigroup") -> ("semigroup" :: FuncTyp(Type, Type)), trepplein.Name("has_one", "one") -> has_one$one.value, trepplein.Name("nat", "below") -> nat$below.value, trepplein.Name("group", "mk") -> ("group.mk" :: piDefn("'dh" :: Type)(piDefn("'di" :: FuncTyp("'dh" :: Type, FuncTyp("'dh" :: Type, "'dh" :: Type)))(piDefn("'dj" :: piDefn("'dj" :: "'dh" :: Type)(piDefn("'dk" :: "'dh" :: Type)(piDefn("'dl" :: "'dh" :: Type)(("eq" :: piDefn("'c_1129900022" :: Type)(FuncTyp("'c_1129900022" :: Type, FuncTyp("'c_1129900022" :: Type, Prop))))("'dh" :: Type)(("'di" :: FuncTyp("'dh" :: Type, FuncTyp("'dh" :: Type, "'dh" :: Type)))(("'di" :: FuncTyp("'dh" :: Type, FuncTyp("'dh" :: Type, "'dh" :: Type)))("'dj" :: "'dh" :: Type)("'dk" :: "'dh" :: Type))("'dl" :: "'dh" :: Type))(("'di" :: FuncTyp("'dh" :: Type, FuncTyp("'dh" :: Type, "'dh" :: Type)))("'dj" :: "'dh" :: Type)(("'di" :: FuncTyp("'dh" :: Type, FuncTyp("'dh" :: Type, "'dh" :: Type)))("'dk" :: "'dh" :: Type)("'dl" :: "'dh" :: Type)))))))(piDefn("'dk" :: "'dh" :: Type)(piDefn("'dl" :: piDefn("'dl" :: "'dh" :: Type)(("eq" :: piDefn("'c_1129900022" :: Type)(FuncTyp("'c_1129900022" :: Type, FuncTyp("'c_1129900022" :: Type, Prop))))("'dh" :: Type)(("'di" :: FuncTyp("'dh" :: Type, FuncTyp("'dh" :: Type, "'dh" :: Type)))("'dk" :: "'dh" :: Type)("'dl" :: "'dh" :: Type))("'dl" :: "'dh" :: Type)))(piDefn("'dm" :: piDefn("'dm" :: "'dh" :: Type)(("eq" :: piDefn("'c_1129900022" :: Type)(FuncTyp("'c_1129900022" :: Type, FuncTyp("'c_1129900022" :: Type, Prop))))("'dh" :: Type)(("'di" :: FuncTyp("'dh" :: Type, FuncTyp("'dh" :: Type, "'dh" :: Type)))("'dm" :: "'dh" :: Type)("'dk" :: "'dh" :: Type))("'dm" :: "'dh" :: Type)))(piDefn("'dn" :: FuncTyp("'dh" :: Type, "'dh" :: Type))(FuncTyp(piDefn("'do" :: "'dh" :: Type)(("eq" :: piDefn("'c_1129900022" :: Type)(FuncTyp("'c_1129900022" :: Type, FuncTyp("'c_1129900022" :: Type, Prop))))("'dh" :: Type)(("'di" :: FuncTyp("'dh" :: Type, FuncTyp("'dh" :: Type, "'dh" :: Type)))(("'dn" :: FuncTyp("'dh" :: Type, "'dh" :: Type))("'do" :: "'dh" :: Type))("'do" :: "'dh" :: Type))("'dk" :: "'dh" :: Type)), ("group" :: FuncTyp(Type, Type))("'dh" :: Type)))))))))), trepplein.Name("id_rhs") -> id_rhs.value, trepplein.Name("group") -> ("group" :: FuncTyp(Type, Type)), trepplein.Name("has_inv") -> ("has_inv" :: FuncTyp(Type, Type)), trepplein.Name("not") -> not.value, trepplein.Name("eq") -> ("eq" :: piDefn("'c_1129900022" :: Type)(FuncTyp("'c_1129900022" :: Type, FuncTyp("'c_1129900022" :: Type, Prop)))), trepplein.Name("has_mul") -> ("has_mul" :: FuncTyp(Type, Type)), trepplein.Name("decidable", "is_false") -> ("decidable.is_false" :: piDefn("'d_1452985099" :: Prop)(FuncTyp(FuncTyp("'d_1452985099" :: Prop, "false" :: Prop), ("decidable" :: FuncTyp(Prop, Type))("'d_1452985099" :: Prop)))), trepplein.Name("group", "mul") -> group$mul.value, trepplein.Name("has_mul", "mul") -> has_mul$mul.value, trepplein.Name("nat", "cases_on") -> nat$cases_on.value, trepplein.Name("semigroup", "to_has_mul") -> semigroup$to_has_mul.value, trepplein.Name("monoid", "mk") -> ("monoid.mk" :: piDefn("'at" :: Type)(piDefn("'au" :: FuncTyp("'at" :: Type, FuncTyp("'at" :: Type, "'at" :: Type)))(piDefn("'av" :: piDefn("'av" :: "'at" :: Type)(piDefn("'aw" :: "'at" :: Type)(piDefn("'ax" :: "'at" :: Type)(("eq" :: piDefn("'c_1129900022" :: Type)(FuncTyp("'c_1129900022" :: Type, FuncTyp("'c_1129900022" :: Type, Prop))))("'at" :: Type)(("'au" :: FuncTyp("'at" :: Type, FuncTyp("'at" :: Type, "'at" :: Type)))(("'au" :: FuncTyp("'at" :: Type, FuncTyp("'at" :: Type, "'at" :: Type)))("'av" :: "'at" :: Type)("'aw" :: "'at" :: Type))("'ax" :: "'at" :: Type))(("'au" :: FuncTyp("'at" :: Type, FuncTyp("'at" :: Type, "'at" :: Type)))("'av" :: "'at" :: Type)(("'au" :: FuncTyp("'at" :: Type, FuncTyp("'at" :: Type, "'at" :: Type)))("'aw" :: "'at" :: Type)("'ax" :: "'at" :: Type)))))))(piDefn("'aw" :: "'at" :: Type)(FuncTyp(piDefn("'ax" :: "'at" :: Type)(("eq" :: piDefn("'c_1129900022" :: Type)(FuncTyp("'c_1129900022" :: Type, FuncTyp("'c_1129900022" :: Type, Prop))))("'at" :: Type)(("'au" :: FuncTyp("'at" :: Type, FuncTyp("'at" :: Type, "'at" :: Type)))("'aw" :: "'at" :: Type)("'ax" :: "'at" :: Type))("'ax" :: "'at" :: Type)), FuncTyp(piDefn("'ay" :: "'at" :: Type)(("eq" :: piDefn("'c_1129900022" :: Type)(FuncTyp("'c_1129900022" :: Type, FuncTyp("'c_1129900022" :: Type, Prop))))("'at" :: Type)(("'au" :: FuncTyp("'at" :: Type, FuncTyp("'at" :: Type, "'at" :: Type)))("'ay" :: "'at" :: Type)("'aw" :: "'at" :: Type))("'ay" :: "'at" :: Type)), ("monoid" :: FuncTyp(Type, Type))("'at" :: Type)))))))), trepplein.Name("false") -> ("false" :: Prop), trepplein.Name("nat", "no_confusion_type") -> nat$no_confusion_type.value, trepplein.Name("nat") -> ("nat" :: Type), trepplein.Name("semigroup", "mul") -> semigroup$mul.value, trepplein.Name("pprod", "fst") -> pprod$fst.value, trepplein.Name("eq", "subst") -> eq$subst.value, trepplein.Name("semigroup", "mk") -> ("semigroup.mk" :: piDefn("'q" :: Type)(piDefn("'r" :: FuncTyp("'q" :: Type, FuncTyp("'q" :: Type, "'q" :: Type)))(FuncTyp(piDefn("'s" :: "'q" :: Type)(piDefn("'t" :: "'q" :: Type)(piDefn("'u" :: "'q" :: Type)(("eq" :: piDefn("'c_1129900022" :: Type)(FuncTyp("'c_1129900022" :: Type, FuncTyp("'c_1129900022" :: Type, Prop))))("'q" :: Type)(("'r" :: FuncTyp("'q" :: Type, FuncTyp("'q" :: Type, "'q" :: Type)))(("'r" :: FuncTyp("'q" :: Type, FuncTyp("'q" :: Type, "'q" :: Type)))("'s" :: "'q" :: Type)("'t" :: "'q" :: Type))("'u" :: "'q" :: Type))(("'r" :: FuncTyp("'q" :: Type, FuncTyp("'q" :: Type, "'q" :: Type)))("'s" :: "'q" :: Type)(("'r" :: FuncTyp("'q" :: Type, FuncTyp("'q" :: Type, "'q" :: Type)))("'t" :: "'q" :: Type)("'u" :: "'q" :: Type)))))), ("semigroup" :: FuncTyp(Type, Type))("'q" :: Type))))), trepplein.Name("monoid", "mul_assoc") -> monoid$mul_assoc.value, trepplein.Name("absurd") -> absurd.value, trepplein.Name("has_one", "mk") -> ("has_one.mk" :: piDefn("'c" :: Type)(FuncTyp("'c" :: Type, ("has_one" :: FuncTyp(Type, Type))("'c" :: Type)))))
  val indMap = Map(trepplein.Name("decidable") -> SimpleIndMod(trepplein.Name("decidable"), "decidable" :: FuncTyp(Prop, Type), Vector("decidable.is_false" :: piDefn("'d_418551053" :: Prop)(FuncTyp(FuncTyp("'d_418551053" :: Prop, "false" :: Prop), ("decidable" :: FuncTyp(Prop, Type))("'d_418551053" :: Prop))), "decidable.is_true" :: piDefn("'c_694600335" :: Prop)(FuncTyp("'c_694600335" :: Prop, ("decidable" :: FuncTyp(Prop, Type))("'c_694600335" :: Prop)))), 1, false), trepplein.Name("has_one") -> SimpleIndMod(trepplein.Name("has_one"), "has_one" :: FuncTyp(Type, Type), Vector("has_one.mk" :: piDefn("'c" :: Type)(FuncTyp("'c" :: Type, ("has_one" :: FuncTyp(Type, Type))("'c" :: Type)))), 1, false), trepplein.Name("monoid") -> SimpleIndMod(trepplein.Name("monoid"), "monoid" :: FuncTyp(Type, Type), Vector("monoid.mk" :: piDefn("'at" :: Type)(piDefn("'au" :: FuncTyp("'at" :: Type, FuncTyp("'at" :: Type, "'at" :: Type)))(piDefn("'av" :: piDefn("'av" :: "'at" :: Type)(piDefn("'aw" :: "'at" :: Type)(piDefn("'ax" :: "'at" :: Type)(("eq" :: piDefn("'c_1129900022" :: Type)(FuncTyp("'c_1129900022" :: Type, FuncTyp("'c_1129900022" :: Type, Prop))))("'at" :: Type)(("'au" :: FuncTyp("'at" :: Type, FuncTyp("'at" :: Type, "'at" :: Type)))(("'au" :: FuncTyp("'at" :: Type, FuncTyp("'at" :: Type, "'at" :: Type)))("'av" :: "'at" :: Type)("'aw" :: "'at" :: Type))("'ax" :: "'at" :: Type))(("'au" :: FuncTyp("'at" :: Type, FuncTyp("'at" :: Type, "'at" :: Type)))("'av" :: "'at" :: Type)(("'au" :: FuncTyp("'at" :: Type, FuncTyp("'at" :: Type, "'at" :: Type)))("'aw" :: "'at" :: Type)("'ax" :: "'at" :: Type)))))))(piDefn("'aw" :: "'at" :: Type)(FuncTyp(piDefn("'ax" :: "'at" :: Type)(("eq" :: piDefn("'c_1129900022" :: Type)(FuncTyp("'c_1129900022" :: Type, FuncTyp("'c_1129900022" :: Type, Prop))))("'at" :: Type)(("'au" :: FuncTyp("'at" :: Type, FuncTyp("'at" :: Type, "'at" :: Type)))("'aw" :: "'at" :: Type)("'ax" :: "'at" :: Type))("'ax" :: "'at" :: Type)), FuncTyp(piDefn("'ay" :: "'at" :: Type)(("eq" :: piDefn("'c_1129900022" :: Type)(FuncTyp("'c_1129900022" :: Type, FuncTyp("'c_1129900022" :: Type, Prop))))("'at" :: Type)(("'au" :: FuncTyp("'at" :: Type, FuncTyp("'at" :: Type, "'at" :: Type)))("'ay" :: "'at" :: Type)("'aw" :: "'at" :: Type))("'ay" :: "'at" :: Type)), ("monoid" :: FuncTyp(Type, Type))("'at" :: Type)))))))), 1, false), trepplein.Name("pprod") -> SimpleIndMod(trepplein.Name("pprod"), "pprod" :: FuncTyp(Type, FuncTyp(Type, Type)), Vector("pprod.mk" :: piDefn("'f_873800778" :: Type)(piDefn("'g_388540903" :: Type)(FuncTyp("'f_873800778" :: Type, FuncTyp("'g_388540903" :: Type, ("pprod" :: FuncTyp(Type, FuncTyp(Type, Type)))("'f_873800778" :: Type)("'g_388540903" :: Type)))))), 2, false), trepplein.Name("punit") -> SimpleIndMod(trepplein.Name("punit"), "punit" :: Type, Vector("punit.star" :: "punit" :: Type), 0, false), trepplein.Name("semigroup") -> SimpleIndMod(trepplein.Name("semigroup"), "semigroup" :: FuncTyp(Type, Type), Vector("semigroup.mk" :: piDefn("'q" :: Type)(piDefn("'r" :: FuncTyp("'q" :: Type, FuncTyp("'q" :: Type, "'q" :: Type)))(FuncTyp(piDefn("'s" :: "'q" :: Type)(piDefn("'t" :: "'q" :: Type)(piDefn("'u" :: "'q" :: Type)(("eq" :: piDefn("'c_1129900022" :: Type)(FuncTyp("'c_1129900022" :: Type, FuncTyp("'c_1129900022" :: Type, Prop))))("'q" :: Type)(("'r" :: FuncTyp("'q" :: Type, FuncTyp("'q" :: Type, "'q" :: Type)))(("'r" :: FuncTyp("'q" :: Type, FuncTyp("'q" :: Type, "'q" :: Type)))("'s" :: "'q" :: Type)("'t" :: "'q" :: Type))("'u" :: "'q" :: Type))(("'r" :: FuncTyp("'q" :: Type, FuncTyp("'q" :: Type, "'q" :: Type)))("'s" :: "'q" :: Type)(("'r" :: FuncTyp("'q" :: Type, FuncTyp("'q" :: Type, "'q" :: Type)))("'t" :: "'q" :: Type)("'u" :: "'q" :: Type)))))), ("semigroup" :: FuncTyp(Type, Type))("'q" :: Type))))), 1, false), trepplein.Name("group") -> SimpleIndMod(trepplein.Name("group"), "group" :: FuncTyp(Type, Type), Vector("group.mk" :: piDefn("'dh" :: Type)(piDefn("'di" :: FuncTyp("'dh" :: Type, FuncTyp("'dh" :: Type, "'dh" :: Type)))(piDefn("'dj" :: piDefn("'dj" :: "'dh" :: Type)(piDefn("'dk" :: "'dh" :: Type)(piDefn("'dl" :: "'dh" :: Type)(("eq" :: piDefn("'c_1129900022" :: Type)(FuncTyp("'c_1129900022" :: Type, FuncTyp("'c_1129900022" :: Type, Prop))))("'dh" :: Type)(("'di" :: FuncTyp("'dh" :: Type, FuncTyp("'dh" :: Type, "'dh" :: Type)))(("'di" :: FuncTyp("'dh" :: Type, FuncTyp("'dh" :: Type, "'dh" :: Type)))("'dj" :: "'dh" :: Type)("'dk" :: "'dh" :: Type))("'dl" :: "'dh" :: Type))(("'di" :: FuncTyp("'dh" :: Type, FuncTyp("'dh" :: Type, "'dh" :: Type)))("'dj" :: "'dh" :: Type)(("'di" :: FuncTyp("'dh" :: Type, FuncTyp("'dh" :: Type, "'dh" :: Type)))("'dk" :: "'dh" :: Type)("'dl" :: "'dh" :: Type)))))))(piDefn("'dk" :: "'dh" :: Type)(piDefn("'dl" :: piDefn("'dl" :: "'dh" :: Type)(("eq" :: piDefn("'c_1129900022" :: Type)(FuncTyp("'c_1129900022" :: Type, FuncTyp("'c_1129900022" :: Type, Prop))))("'dh" :: Type)(("'di" :: FuncTyp("'dh" :: Type, FuncTyp("'dh" :: Type, "'dh" :: Type)))("'dk" :: "'dh" :: Type)("'dl" :: "'dh" :: Type))("'dl" :: "'dh" :: Type)))(piDefn("'dm" :: piDefn("'dm" :: "'dh" :: Type)(("eq" :: piDefn("'c_1129900022" :: Type)(FuncTyp("'c_1129900022" :: Type, FuncTyp("'c_1129900022" :: Type, Prop))))("'dh" :: Type)(("'di" :: FuncTyp("'dh" :: Type, FuncTyp("'dh" :: Type, "'dh" :: Type)))("'dm" :: "'dh" :: Type)("'dk" :: "'dh" :: Type))("'dm" :: "'dh" :: Type)))(piDefn("'dn" :: FuncTyp("'dh" :: Type, "'dh" :: Type))(FuncTyp(piDefn("'do" :: "'dh" :: Type)(("eq" :: piDefn("'c_1129900022" :: Type)(FuncTyp("'c_1129900022" :: Type, FuncTyp("'c_1129900022" :: Type, Prop))))("'dh" :: Type)(("'di" :: FuncTyp("'dh" :: Type, FuncTyp("'dh" :: Type, "'dh" :: Type)))(("'dn" :: FuncTyp("'dh" :: Type, "'dh" :: Type))("'do" :: "'dh" :: Type))("'do" :: "'dh" :: Type))("'dk" :: "'dh" :: Type)), ("group" :: FuncTyp(Type, Type))("'dh" :: Type)))))))))), 1, false), trepplein.Name("has_inv") -> SimpleIndMod(trepplein.Name("has_inv"), "has_inv" :: FuncTyp(Type, Type), Vector("has_inv.mk" :: piDefn("'c" :: Type)(FuncTyp(FuncTyp("'c" :: Type, "'c" :: Type), ("has_inv" :: FuncTyp(Type, Type))("'c" :: Type)))), 1, false), trepplein.Name("has_mul") -> SimpleIndMod(trepplein.Name("has_mul"), "has_mul" :: FuncTyp(Type, Type), Vector("has_mul.mk" :: piDefn("'d" :: Type)(FuncTyp(FuncTyp("'d" :: Type, FuncTyp("'d" :: Type, "'d" :: Type)), ("has_mul" :: FuncTyp(Type, Type))("'d" :: Type)))), 1, false), trepplein.Name("eq") -> IndexedIndMod(trepplein.Name("eq"), "eq" :: piDefn("'c_1579184312" :: Type)(FuncTyp("'c_1579184312" :: Type, FuncTyp("'c_1579184312" :: Type, Prop))), Vector("eq.refl" :: piDefn("'e_281689086" :: Type)(piDefn("'f_225244113" :: "'e_281689086" :: Type)(("eq" :: piDefn("'c_1590984540" :: Type)(FuncTyp("'c_1590984540" :: Type, FuncTyp("'c_1590984540" :: Type, Prop))))("'e_281689086" :: Type)("'f_225244113" :: "'e_281689086" :: Type)("'f_225244113" :: "'e_281689086" :: Type)))), 2, true), trepplein.Name("false") -> SimpleIndMod(trepplein.Name("false"), "false" :: Prop, Vector(), 0, true), trepplein.Name("nat") -> SimpleIndMod(trepplein.Name("nat"), "nat" :: Type, Vector("nat.zero" :: "nat" :: Type, "nat.succ" :: FuncTyp("nat" :: Type, "nat" :: Type)), 0, false))
  val defTaskMap = Map(trepplein.Name("decidable") -> monix.eval.Task("decidable" :: FuncTyp(Prop, Type)), trepplein.Name("nat", "brec_on") -> monix.eval.Task(nat$brec_on.value), trepplein.Name("nat", "decidable_eq", "_main") -> monix.eval.Task(nat$decidable_eq$_main.value), trepplein.Name("monoid", "mul") -> monix.eval.Task(monoid$mul.value), trepplein.Name("monoid", "to_has_one") -> monix.eval.Task(monoid$to_has_one.value), trepplein.Name("decidable", "cases_on") -> monix.eval.Task(decidable$cases_on.value), trepplein.Name("has_inv", "mk") -> monix.eval.Task("has_inv.mk" :: piDefn("'c" :: Type)(FuncTyp(FuncTyp("'c" :: Type, "'c" :: Type), ("has_inv" :: FuncTyp(Type, Type))("'c" :: Type)))), trepplein.Name("has_one") -> monix.eval.Task("has_one" :: FuncTyp(Type, Type)), trepplein.Name("monoid", "one") -> monix.eval.Task(monoid$one.value), trepplein.Name("punit", "star") -> monix.eval.Task("punit.star" :: "punit" :: Type), trepplein.Name("nat", "zero") -> monix.eval.Task("nat.zero" :: "nat" :: Type), trepplein.Name("nat", "succ") -> monix.eval.Task("nat.succ" :: FuncTyp("nat" :: Type, "nat" :: Type)), trepplein.Name("monoid") -> monix.eval.Task("monoid" :: FuncTyp(Type, Type)), trepplein.Name("pprod", "mk") -> monix.eval.Task("pprod.mk" :: piDefn("'f_867761158" :: Type)(piDefn("'g_952015611" :: Type)(FuncTyp("'f_867761158" :: Type, FuncTyp("'g_952015611" :: Type, ("pprod" :: FuncTyp(Type, FuncTyp(Type, Type)))("'f_867761158" :: Type)("'g_952015611" :: Type)))))), trepplein.Name("nat", "no_confusion") -> monix.eval.Task(nat$no_confusion.value), trepplein.Name("pprod") -> monix.eval.Task("pprod" :: FuncTyp(Type, FuncTyp(Type, Type))), trepplein.Name("eq", "refl") -> monix.eval.Task("eq.refl" :: piDefn("'e_1731622754" :: Type)(piDefn("'f_1219463498" :: "'e_1731622754" :: Type)(("eq" :: piDefn("'c_1674425354" :: Type)(FuncTyp("'c_1674425354" :: Type, FuncTyp("'c_1674425354" :: Type, Prop))))("'e_1731622754" :: Type)("'f_1219463498" :: "'e_1731622754" :: Type)("'f_1219463498" :: "'e_1731622754" :: Type)))), trepplein.Name("has_inv", "inv") -> monix.eval.Task(has_inv$inv.value), trepplein.Name("nat", "decidable_eq", "_match_1") -> monix.eval.Task(nat$decidable_eq$_match_1.value), trepplein.Name("has_mul", "mk") -> monix.eval.Task("has_mul.mk" :: piDefn("'d" :: Type)(FuncTyp(FuncTyp("'d" :: Type, FuncTyp("'d" :: Type, "'d" :: Type)), ("has_mul" :: FuncTyp(Type, Type))("'d" :: Type)))), trepplein.Name("punit") -> monix.eval.Task("punit" :: Type), trepplein.Name("rfl") -> monix.eval.Task(rfl.value), trepplein.Name("nat", "decidable_eq") -> monix.eval.Task(nat$decidable_eq.value), trepplein.Name("decidable", "is_true") -> monix.eval.Task("decidable.is_true" :: piDefn("'c_389126704" :: Prop)(FuncTyp("'c_389126704" :: Prop, ("decidable" :: FuncTyp(Prop, Type))("'c_389126704" :: Prop)))), trepplein.Name("monoid", "to_semigroup") -> monix.eval.Task(monoid$to_semigroup.value), trepplein.Name("semigroup") -> monix.eval.Task("semigroup" :: FuncTyp(Type, Type)), trepplein.Name("has_one", "one") -> monix.eval.Task(has_one$one.value), trepplein.Name("nat", "below") -> monix.eval.Task(nat$below.value), trepplein.Name("group", "mk") -> monix.eval.Task("group.mk" :: piDefn("'dh" :: Type)(piDefn("'di" :: FuncTyp("'dh" :: Type, FuncTyp("'dh" :: Type, "'dh" :: Type)))(piDefn("'dj" :: piDefn("'dj" :: "'dh" :: Type)(piDefn("'dk" :: "'dh" :: Type)(piDefn("'dl" :: "'dh" :: Type)(("eq" :: piDefn("'c_1129900022" :: Type)(FuncTyp("'c_1129900022" :: Type, FuncTyp("'c_1129900022" :: Type, Prop))))("'dh" :: Type)(("'di" :: FuncTyp("'dh" :: Type, FuncTyp("'dh" :: Type, "'dh" :: Type)))(("'di" :: FuncTyp("'dh" :: Type, FuncTyp("'dh" :: Type, "'dh" :: Type)))("'dj" :: "'dh" :: Type)("'dk" :: "'dh" :: Type))("'dl" :: "'dh" :: Type))(("'di" :: FuncTyp("'dh" :: Type, FuncTyp("'dh" :: Type, "'dh" :: Type)))("'dj" :: "'dh" :: Type)(("'di" :: FuncTyp("'dh" :: Type, FuncTyp("'dh" :: Type, "'dh" :: Type)))("'dk" :: "'dh" :: Type)("'dl" :: "'dh" :: Type)))))))(piDefn("'dk" :: "'dh" :: Type)(piDefn("'dl" :: piDefn("'dl" :: "'dh" :: Type)(("eq" :: piDefn("'c_1129900022" :: Type)(FuncTyp("'c_1129900022" :: Type, FuncTyp("'c_1129900022" :: Type, Prop))))("'dh" :: Type)(("'di" :: FuncTyp("'dh" :: Type, FuncTyp("'dh" :: Type, "'dh" :: Type)))("'dk" :: "'dh" :: Type)("'dl" :: "'dh" :: Type))("'dl" :: "'dh" :: Type)))(piDefn("'dm" :: piDefn("'dm" :: "'dh" :: Type)(("eq" :: piDefn("'c_1129900022" :: Type)(FuncTyp("'c_1129900022" :: Type, FuncTyp("'c_1129900022" :: Type, Prop))))("'dh" :: Type)(("'di" :: FuncTyp("'dh" :: Type, FuncTyp("'dh" :: Type, "'dh" :: Type)))("'dm" :: "'dh" :: Type)("'dk" :: "'dh" :: Type))("'dm" :: "'dh" :: Type)))(piDefn("'dn" :: FuncTyp("'dh" :: Type, "'dh" :: Type))(FuncTyp(piDefn("'do" :: "'dh" :: Type)(("eq" :: piDefn("'c_1129900022" :: Type)(FuncTyp("'c_1129900022" :: Type, FuncTyp("'c_1129900022" :: Type, Prop))))("'dh" :: Type)(("'di" :: FuncTyp("'dh" :: Type, FuncTyp("'dh" :: Type, "'dh" :: Type)))(("'dn" :: FuncTyp("'dh" :: Type, "'dh" :: Type))("'do" :: "'dh" :: Type))("'do" :: "'dh" :: Type))("'dk" :: "'dh" :: Type)), ("group" :: FuncTyp(Type, Type))("'dh" :: Type)))))))))), trepplein.Name("id_rhs") -> monix.eval.Task(id_rhs.value), trepplein.Name("group") -> monix.eval.Task("group" :: FuncTyp(Type, Type)), trepplein.Name("has_inv") -> monix.eval.Task("has_inv" :: FuncTyp(Type, Type)), trepplein.Name("not") -> monix.eval.Task(not.value), trepplein.Name("eq") -> monix.eval.Task("eq" :: piDefn("'c_1129900022" :: Type)(FuncTyp("'c_1129900022" :: Type, FuncTyp("'c_1129900022" :: Type, Prop)))), trepplein.Name("has_mul") -> monix.eval.Task("has_mul" :: FuncTyp(Type, Type)), trepplein.Name("decidable", "is_false") -> monix.eval.Task("decidable.is_false" :: piDefn("'d_1452985099" :: Prop)(FuncTyp(FuncTyp("'d_1452985099" :: Prop, "false" :: Prop), ("decidable" :: FuncTyp(Prop, Type))("'d_1452985099" :: Prop)))), trepplein.Name("group", "mul") -> monix.eval.Task(group$mul.value), trepplein.Name("has_mul", "mul") -> monix.eval.Task(has_mul$mul.value), trepplein.Name("nat", "cases_on") -> monix.eval.Task(nat$cases_on.value), trepplein.Name("semigroup", "to_has_mul") -> monix.eval.Task(semigroup$to_has_mul.value), trepplein.Name("monoid", "mk") -> monix.eval.Task("monoid.mk" :: piDefn("'at" :: Type)(piDefn("'au" :: FuncTyp("'at" :: Type, FuncTyp("'at" :: Type, "'at" :: Type)))(piDefn("'av" :: piDefn("'av" :: "'at" :: Type)(piDefn("'aw" :: "'at" :: Type)(piDefn("'ax" :: "'at" :: Type)(("eq" :: piDefn("'c_1129900022" :: Type)(FuncTyp("'c_1129900022" :: Type, FuncTyp("'c_1129900022" :: Type, Prop))))("'at" :: Type)(("'au" :: FuncTyp("'at" :: Type, FuncTyp("'at" :: Type, "'at" :: Type)))(("'au" :: FuncTyp("'at" :: Type, FuncTyp("'at" :: Type, "'at" :: Type)))("'av" :: "'at" :: Type)("'aw" :: "'at" :: Type))("'ax" :: "'at" :: Type))(("'au" :: FuncTyp("'at" :: Type, FuncTyp("'at" :: Type, "'at" :: Type)))("'av" :: "'at" :: Type)(("'au" :: FuncTyp("'at" :: Type, FuncTyp("'at" :: Type, "'at" :: Type)))("'aw" :: "'at" :: Type)("'ax" :: "'at" :: Type)))))))(piDefn("'aw" :: "'at" :: Type)(FuncTyp(piDefn("'ax" :: "'at" :: Type)(("eq" :: piDefn("'c_1129900022" :: Type)(FuncTyp("'c_1129900022" :: Type, FuncTyp("'c_1129900022" :: Type, Prop))))("'at" :: Type)(("'au" :: FuncTyp("'at" :: Type, FuncTyp("'at" :: Type, "'at" :: Type)))("'aw" :: "'at" :: Type)("'ax" :: "'at" :: Type))("'ax" :: "'at" :: Type)), FuncTyp(piDefn("'ay" :: "'at" :: Type)(("eq" :: piDefn("'c_1129900022" :: Type)(FuncTyp("'c_1129900022" :: Type, FuncTyp("'c_1129900022" :: Type, Prop))))("'at" :: Type)(("'au" :: FuncTyp("'at" :: Type, FuncTyp("'at" :: Type, "'at" :: Type)))("'ay" :: "'at" :: Type)("'aw" :: "'at" :: Type))("'ay" :: "'at" :: Type)), ("monoid" :: FuncTyp(Type, Type))("'at" :: Type)))))))), trepplein.Name("false") -> monix.eval.Task("false" :: Prop), trepplein.Name("nat", "no_confusion_type") -> monix.eval.Task(nat$no_confusion_type.value), trepplein.Name("nat") -> monix.eval.Task("nat" :: Type), trepplein.Name("semigroup", "mul") -> monix.eval.Task(semigroup$mul.value), trepplein.Name("pprod", "fst") -> monix.eval.Task(pprod$fst.value), trepplein.Name("eq", "subst") -> monix.eval.Task(eq$subst.value), trepplein.Name("semigroup", "mk") -> monix.eval.Task("semigroup.mk" :: piDefn("'q" :: Type)(piDefn("'r" :: FuncTyp("'q" :: Type, FuncTyp("'q" :: Type, "'q" :: Type)))(FuncTyp(piDefn("'s" :: "'q" :: Type)(piDefn("'t" :: "'q" :: Type)(piDefn("'u" :: "'q" :: Type)(("eq" :: piDefn("'c_1129900022" :: Type)(FuncTyp("'c_1129900022" :: Type, FuncTyp("'c_1129900022" :: Type, Prop))))("'q" :: Type)(("'r" :: FuncTyp("'q" :: Type, FuncTyp("'q" :: Type, "'q" :: Type)))(("'r" :: FuncTyp("'q" :: Type, FuncTyp("'q" :: Type, "'q" :: Type)))("'s" :: "'q" :: Type)("'t" :: "'q" :: Type))("'u" :: "'q" :: Type))(("'r" :: FuncTyp("'q" :: Type, FuncTyp("'q" :: Type, "'q" :: Type)))("'s" :: "'q" :: Type)(("'r" :: FuncTyp("'q" :: Type, FuncTyp("'q" :: Type, "'q" :: Type)))("'t" :: "'q" :: Type)("'u" :: "'q" :: Type)))))), ("semigroup" :: FuncTyp(Type, Type))("'q" :: Type))))), trepplein.Name("monoid", "mul_assoc") -> monix.eval.Task(monoid$mul_assoc.value), trepplein.Name("absurd") -> monix.eval.Task(absurd.value), trepplein.Name("has_one", "mk") -> monix.eval.Task("has_one.mk" :: piDefn("'c" :: Type)(FuncTyp("'c" :: Type, ("has_one" :: FuncTyp(Type, Type))("'c" :: Type)))))
  val indTaskMap = Map(trepplein.Name("decidable") -> monix.eval.Task(SimpleIndMod(trepplein.Name("decidable"), "decidable" :: FuncTyp(Prop, Type), Vector("decidable.is_false" :: piDefn("'d_418551053" :: Prop)(FuncTyp(FuncTyp("'d_418551053" :: Prop, "false" :: Prop), ("decidable" :: FuncTyp(Prop, Type))("'d_418551053" :: Prop))), "decidable.is_true" :: piDefn("'c_694600335" :: Prop)(FuncTyp("'c_694600335" :: Prop, ("decidable" :: FuncTyp(Prop, Type))("'c_694600335" :: Prop)))), 1, false)), trepplein.Name("has_one") -> monix.eval.Task(SimpleIndMod(trepplein.Name("has_one"), "has_one" :: FuncTyp(Type, Type), Vector("has_one.mk" :: piDefn("'c" :: Type)(FuncTyp("'c" :: Type, ("has_one" :: FuncTyp(Type, Type))("'c" :: Type)))), 1, false)), trepplein.Name("monoid") -> monix.eval.Task(SimpleIndMod(trepplein.Name("monoid"), "monoid" :: FuncTyp(Type, Type), Vector("monoid.mk" :: piDefn("'at" :: Type)(piDefn("'au" :: FuncTyp("'at" :: Type, FuncTyp("'at" :: Type, "'at" :: Type)))(piDefn("'av" :: piDefn("'av" :: "'at" :: Type)(piDefn("'aw" :: "'at" :: Type)(piDefn("'ax" :: "'at" :: Type)(("eq" :: piDefn("'c_1129900022" :: Type)(FuncTyp("'c_1129900022" :: Type, FuncTyp("'c_1129900022" :: Type, Prop))))("'at" :: Type)(("'au" :: FuncTyp("'at" :: Type, FuncTyp("'at" :: Type, "'at" :: Type)))(("'au" :: FuncTyp("'at" :: Type, FuncTyp("'at" :: Type, "'at" :: Type)))("'av" :: "'at" :: Type)("'aw" :: "'at" :: Type))("'ax" :: "'at" :: Type))(("'au" :: FuncTyp("'at" :: Type, FuncTyp("'at" :: Type, "'at" :: Type)))("'av" :: "'at" :: Type)(("'au" :: FuncTyp("'at" :: Type, FuncTyp("'at" :: Type, "'at" :: Type)))("'aw" :: "'at" :: Type)("'ax" :: "'at" :: Type)))))))(piDefn("'aw" :: "'at" :: Type)(FuncTyp(piDefn("'ax" :: "'at" :: Type)(("eq" :: piDefn("'c_1129900022" :: Type)(FuncTyp("'c_1129900022" :: Type, FuncTyp("'c_1129900022" :: Type, Prop))))("'at" :: Type)(("'au" :: FuncTyp("'at" :: Type, FuncTyp("'at" :: Type, "'at" :: Type)))("'aw" :: "'at" :: Type)("'ax" :: "'at" :: Type))("'ax" :: "'at" :: Type)), FuncTyp(piDefn("'ay" :: "'at" :: Type)(("eq" :: piDefn("'c_1129900022" :: Type)(FuncTyp("'c_1129900022" :: Type, FuncTyp("'c_1129900022" :: Type, Prop))))("'at" :: Type)(("'au" :: FuncTyp("'at" :: Type, FuncTyp("'at" :: Type, "'at" :: Type)))("'ay" :: "'at" :: Type)("'aw" :: "'at" :: Type))("'ay" :: "'at" :: Type)), ("monoid" :: FuncTyp(Type, Type))("'at" :: Type)))))))), 1, false)), trepplein.Name("pprod") -> monix.eval.Task(SimpleIndMod(trepplein.Name("pprod"), "pprod" :: FuncTyp(Type, FuncTyp(Type, Type)), Vector("pprod.mk" :: piDefn("'f_873800778" :: Type)(piDefn("'g_388540903" :: Type)(FuncTyp("'f_873800778" :: Type, FuncTyp("'g_388540903" :: Type, ("pprod" :: FuncTyp(Type, FuncTyp(Type, Type)))("'f_873800778" :: Type)("'g_388540903" :: Type)))))), 2, false)), trepplein.Name("punit") -> monix.eval.Task(SimpleIndMod(trepplein.Name("punit"), "punit" :: Type, Vector("punit.star" :: "punit" :: Type), 0, false)), trepplein.Name("semigroup") -> monix.eval.Task(SimpleIndMod(trepplein.Name("semigroup"), "semigroup" :: FuncTyp(Type, Type), Vector("semigroup.mk" :: piDefn("'q" :: Type)(piDefn("'r" :: FuncTyp("'q" :: Type, FuncTyp("'q" :: Type, "'q" :: Type)))(FuncTyp(piDefn("'s" :: "'q" :: Type)(piDefn("'t" :: "'q" :: Type)(piDefn("'u" :: "'q" :: Type)(("eq" :: piDefn("'c_1129900022" :: Type)(FuncTyp("'c_1129900022" :: Type, FuncTyp("'c_1129900022" :: Type, Prop))))("'q" :: Type)(("'r" :: FuncTyp("'q" :: Type, FuncTyp("'q" :: Type, "'q" :: Type)))(("'r" :: FuncTyp("'q" :: Type, FuncTyp("'q" :: Type, "'q" :: Type)))("'s" :: "'q" :: Type)("'t" :: "'q" :: Type))("'u" :: "'q" :: Type))(("'r" :: FuncTyp("'q" :: Type, FuncTyp("'q" :: Type, "'q" :: Type)))("'s" :: "'q" :: Type)(("'r" :: FuncTyp("'q" :: Type, FuncTyp("'q" :: Type, "'q" :: Type)))("'t" :: "'q" :: Type)("'u" :: "'q" :: Type)))))), ("semigroup" :: FuncTyp(Type, Type))("'q" :: Type))))), 1, false)), trepplein.Name("group") -> monix.eval.Task(SimpleIndMod(trepplein.Name("group"), "group" :: FuncTyp(Type, Type), Vector("group.mk" :: piDefn("'dh" :: Type)(piDefn("'di" :: FuncTyp("'dh" :: Type, FuncTyp("'dh" :: Type, "'dh" :: Type)))(piDefn("'dj" :: piDefn("'dj" :: "'dh" :: Type)(piDefn("'dk" :: "'dh" :: Type)(piDefn("'dl" :: "'dh" :: Type)(("eq" :: piDefn("'c_1129900022" :: Type)(FuncTyp("'c_1129900022" :: Type, FuncTyp("'c_1129900022" :: Type, Prop))))("'dh" :: Type)(("'di" :: FuncTyp("'dh" :: Type, FuncTyp("'dh" :: Type, "'dh" :: Type)))(("'di" :: FuncTyp("'dh" :: Type, FuncTyp("'dh" :: Type, "'dh" :: Type)))("'dj" :: "'dh" :: Type)("'dk" :: "'dh" :: Type))("'dl" :: "'dh" :: Type))(("'di" :: FuncTyp("'dh" :: Type, FuncTyp("'dh" :: Type, "'dh" :: Type)))("'dj" :: "'dh" :: Type)(("'di" :: FuncTyp("'dh" :: Type, FuncTyp("'dh" :: Type, "'dh" :: Type)))("'dk" :: "'dh" :: Type)("'dl" :: "'dh" :: Type)))))))(piDefn("'dk" :: "'dh" :: Type)(piDefn("'dl" :: piDefn("'dl" :: "'dh" :: Type)(("eq" :: piDefn("'c_1129900022" :: Type)(FuncTyp("'c_1129900022" :: Type, FuncTyp("'c_1129900022" :: Type, Prop))))("'dh" :: Type)(("'di" :: FuncTyp("'dh" :: Type, FuncTyp("'dh" :: Type, "'dh" :: Type)))("'dk" :: "'dh" :: Type)("'dl" :: "'dh" :: Type))("'dl" :: "'dh" :: Type)))(piDefn("'dm" :: piDefn("'dm" :: "'dh" :: Type)(("eq" :: piDefn("'c_1129900022" :: Type)(FuncTyp("'c_1129900022" :: Type, FuncTyp("'c_1129900022" :: Type, Prop))))("'dh" :: Type)(("'di" :: FuncTyp("'dh" :: Type, FuncTyp("'dh" :: Type, "'dh" :: Type)))("'dm" :: "'dh" :: Type)("'dk" :: "'dh" :: Type))("'dm" :: "'dh" :: Type)))(piDefn("'dn" :: FuncTyp("'dh" :: Type, "'dh" :: Type))(FuncTyp(piDefn("'do" :: "'dh" :: Type)(("eq" :: piDefn("'c_1129900022" :: Type)(FuncTyp("'c_1129900022" :: Type, FuncTyp("'c_1129900022" :: Type, Prop))))("'dh" :: Type)(("'di" :: FuncTyp("'dh" :: Type, FuncTyp("'dh" :: Type, "'dh" :: Type)))(("'dn" :: FuncTyp("'dh" :: Type, "'dh" :: Type))("'do" :: "'dh" :: Type))("'do" :: "'dh" :: Type))("'dk" :: "'dh" :: Type)), ("group" :: FuncTyp(Type, Type))("'dh" :: Type)))))))))), 1, false)), trepplein.Name("has_inv") -> monix.eval.Task(SimpleIndMod(trepplein.Name("has_inv"), "has_inv" :: FuncTyp(Type, Type), Vector("has_inv.mk" :: piDefn("'c" :: Type)(FuncTyp(FuncTyp("'c" :: Type, "'c" :: Type), ("has_inv" :: FuncTyp(Type, Type))("'c" :: Type)))), 1, false)), trepplein.Name("has_mul") -> monix.eval.Task(SimpleIndMod(trepplein.Name("has_mul"), "has_mul" :: FuncTyp(Type, Type), Vector("has_mul.mk" :: piDefn("'d" :: Type)(FuncTyp(FuncTyp("'d" :: Type, FuncTyp("'d" :: Type, "'d" :: Type)), ("has_mul" :: FuncTyp(Type, Type))("'d" :: Type)))), 1, false)), trepplein.Name("eq") -> monix.eval.Task(IndexedIndMod(trepplein.Name("eq"), "eq" :: piDefn("'c_1579184312" :: Type)(FuncTyp("'c_1579184312" :: Type, FuncTyp("'c_1579184312" :: Type, Prop))), Vector("eq.refl" :: piDefn("'e_281689086" :: Type)(piDefn("'f_225244113" :: "'e_281689086" :: Type)(("eq" :: piDefn("'c_1590984540" :: Type)(FuncTyp("'c_1590984540" :: Type, FuncTyp("'c_1590984540" :: Type, Prop))))("'e_281689086" :: Type)("'f_225244113" :: "'e_281689086" :: Type)("'f_225244113" :: "'e_281689086" :: Type)))), 2, true)), trepplein.Name("false") -> monix.eval.Task(SimpleIndMod(trepplein.Name("false"), "false" :: Prop, Vector(), 0, true)), trepplein.Name("nat") -> monix.eval.Task(SimpleIndMod(trepplein.Name("nat"), "nat" :: Type, Vector("nat.zero" :: "nat" :: Type, "nat.succ" :: FuncTyp("nat" :: Type, "nat" :: Type)), 0, false)))
}
