package provingground.library
import provingground._
import HoTT._
import induction._
import implicits._
import shapeless._
import Fold._
object nat$decidable_eq$_main {
  lazy val value = lambda("'ag_1531296106_1797768165" :: "nat" :: Type)(({
    val rxyz = pprodInd.value(piDefn("'aj_470722926" :: "nat" :: Type)(("decidable" :: FuncTyp(Prop, Type))(("eq" :: piDefn("'c_761935938" :: Type)(FuncTyp("'c_761935938" :: Type, FuncTyp("'c_761935938" :: Type, Prop))))("nat" :: Type)("'ag_1531296106_1797768165" :: "nat" :: Type)("'aj_470722926" :: "nat" :: Type))))(({
      val rxyz = natInd.value.rec(Type)
      rxyz
    })("punit" :: Type)(lmbda("'h_159188406_215015389" :: "nat" :: Type)(lmbda("'i_854809894_1801626689" :: Type)(("pprod" :: FuncTyp(Type, FuncTyp(Type, Type)))(("pprod" :: FuncTyp(Type, FuncTyp(Type, Type)))(piDefn("'aj_1789259131" :: "nat" :: Type)(("decidable" :: FuncTyp(Prop, Type))(("eq" :: piDefn("'c_1408739709" :: Type)(FuncTyp("'c_1408739709" :: Type, FuncTyp("'c_1408739709" :: Type, Prop))))("nat" :: Type)("'h_159188406_215015389" :: "nat" :: Type)("'aj_1789259131" :: "nat" :: Type))))("'i_854809894_1801626689" :: Type))("punit" :: Type))))("'ag_1531296106_1797768165" :: "nat" :: Type)).rec(piDefn("'aj_1224635511" :: "nat" :: Type)(("decidable" :: FuncTyp(Prop, Type))(("eq" :: piDefn("'c_1670755523" :: Type)(FuncTyp("'c_1670755523" :: Type, FuncTyp("'c_1670755523" :: Type, Prop))))("nat" :: Type)("'ag_1531296106_1797768165" :: "nat" :: Type)("'aj_1224635511" :: "nat" :: Type))))
    rxyz
  })(lmbda("'s_318103601_1333226254" :: piDefn("'aj_15078438_836706814" :: "nat" :: Type)(("decidable" :: FuncTyp(Prop, Type))(("eq" :: piDefn("'c_1942891847" :: Type)(FuncTyp("'c_1942891847" :: Type, FuncTyp("'c_1942891847" :: Type, Prop))))("nat" :: Type)("'ag_1531296106_1797768165" :: "nat" :: Type)("'aj_15078438_836706814" :: "nat" :: Type))))(lmbda("_" :: ({
    val rxyz = natInd.value.rec(Type)
    rxyz
  })("punit" :: Type)(lmbda("'h_159188406_773676301" :: "nat" :: Type)(lmbda("'i_854809894_985531988" :: Type)(("pprod" :: FuncTyp(Type, FuncTyp(Type, Type)))(("pprod" :: FuncTyp(Type, FuncTyp(Type, Type)))(piDefn("'aj_742879486" :: "nat" :: Type)(("decidable" :: FuncTyp(Prop, Type))(("eq" :: piDefn("'c_334523289" :: Type)(FuncTyp("'c_334523289" :: Type, FuncTyp("'c_334523289" :: Type, Prop))))("nat" :: Type)("'h_159188406_773676301" :: "nat" :: Type)("'aj_742879486" :: "nat" :: Type))))("'i_854809894_985531988" :: Type))("punit" :: Type))))("'ag_1531296106_1797768165" :: "nat" :: Type))("'s_318103601_1333226254" :: piDefn("'aj_15078438_836706814" :: "nat" :: Type)(("decidable" :: FuncTyp(Prop, Type))(("eq" :: piDefn("'c_1942891847" :: Type)(FuncTyp("'c_1942891847" :: Type, FuncTyp("'c_1942891847" :: Type, Prop))))("nat" :: Type)("'ag_1531296106_1797768165" :: "nat" :: Type)("'aj_15078438_836706814" :: "nat" :: Type))))))(({
    val rxyz = natInd.value.induc(lmbda("'v_1087445862_1801460737" :: "nat" :: Type)(("pprod" :: FuncTyp(Type, FuncTyp(Type, Type)))(piDefn("'aj_88358220" :: "nat" :: Type)(("decidable" :: FuncTyp(Prop, Type))(("eq" :: piDefn("'c_812345374" :: Type)(FuncTyp("'c_812345374" :: Type, FuncTyp("'c_812345374" :: Type, Prop))))("nat" :: Type)("'v_1087445862_1801460737" :: "nat" :: Type)("'aj_88358220" :: "nat" :: Type))))(({
      val rxyz = natInd.value.rec(Type)
      rxyz
    })("punit" :: Type)(lmbda("'h_159188406_554630935" :: "nat" :: Type)(lmbda("'i_854809894_1919941674" :: Type)(("pprod" :: FuncTyp(Type, FuncTyp(Type, Type)))(("pprod" :: FuncTyp(Type, FuncTyp(Type, Type)))(piDefn("'aj_203517905" :: "nat" :: Type)(("decidable" :: FuncTyp(Prop, Type))(("eq" :: piDefn("'c_110552616" :: Type)(FuncTyp("'c_110552616" :: Type, FuncTyp("'c_110552616" :: Type, Prop))))("nat" :: Type)("'h_159188406_554630935" :: "nat" :: Type)("'aj_203517905" :: "nat" :: Type))))("'i_854809894_1919941674" :: Type))("punit" :: Type))))("'v_1087445862_1801460737" :: "nat" :: Type))))
    rxyz
  })(("pprod.mk" :: piDefn("'f_1570492005" :: Type)(piDefn("'g_888826819" :: Type)(FuncTyp("'f_1570492005" :: Type, FuncTyp("'g_888826819" :: Type, ("pprod" :: FuncTyp(Type, FuncTyp(Type, Type)))("'f_1570492005" :: Type)("'g_888826819" :: Type))))))(piDefn("'aj_962674117" :: "nat" :: Type)(("decidable" :: FuncTyp(Prop, Type))(("eq" :: piDefn("'c_279825786" :: Type)(FuncTyp("'c_279825786" :: Type, FuncTyp("'c_279825786" :: Type, Prop))))("nat" :: Type)("nat.zero" :: "nat" :: Type)("'aj_962674117" :: "nat" :: Type))))("punit" :: Type)(lambda("'ak_992690145_107411356" :: "nat" :: Type)(({
    val rxyz = natInd.value.induc(lmbda("$vuyd_613901509_1294323079" :: "nat" :: Type)(("decidable" :: FuncTyp(Prop, Type))(("eq" :: piDefn("'c_1217673599" :: Type)(FuncTyp("'c_1217673599" :: Type, FuncTyp("'c_1217673599" :: Type, Prop))))("nat" :: Type)("nat.zero" :: "nat" :: Type)("$vuyd_613901509_1294323079" :: "nat" :: Type))))
    rxyz
  })("_" :: ("decidable" :: FuncTyp(Prop, Type))(("eq" :: piDefn("'c_516009439" :: Type)(FuncTyp("'c_516009439" :: Type, FuncTyp("'c_516009439" :: Type, Prop))))("nat" :: Type)("nat.zero" :: "nat" :: Type)("nat.zero" :: "nat" :: Type)))(lambda("'k_621156251_343713537" :: "nat" :: Type)(lmbda("_" :: ("decidable" :: FuncTyp(Prop, Type))(("eq" :: piDefn("'c_1321398637" :: Type)(FuncTyp("'c_1321398637" :: Type, FuncTyp("'c_1321398637" :: Type, Prop))))("nat" :: Type)("nat.zero" :: "nat" :: Type)("'k_621156251_343713537" :: "nat" :: Type)))("_" :: ("decidable" :: FuncTyp(Prop, Type))(("eq" :: piDefn("'c_1472912530" :: Type)(FuncTyp("'c_1472912530" :: Type, FuncTyp("'c_1472912530" :: Type, Prop))))("nat" :: Type)("nat.zero" :: "nat" :: Type)(("nat.succ" :: FuncTyp("nat" :: Type, "nat" :: Type))("'k_621156251_343713537" :: "nat" :: Type))))))("'ak_992690145_107411356" :: "nat" :: Type)))("punit.star" :: "punit" :: Type))(lambda("'v_256405719_824809037" :: "nat" :: Type)(lmbda("'w_566843556_694375782" :: ("pprod" :: FuncTyp(Type, FuncTyp(Type, Type)))(piDefn("'aj_1281576755" :: "nat" :: Type)(("decidable" :: FuncTyp(Prop, Type))(("eq" :: piDefn("'c_2097588084" :: Type)(FuncTyp("'c_2097588084" :: Type, FuncTyp("'c_2097588084" :: Type, Prop))))("nat" :: Type)("'v_256405719_824809037" :: "nat" :: Type)("'aj_1281576755" :: "nat" :: Type))))(({
    val rxyz = natInd.value.rec(Type)
    rxyz
  })("punit" :: Type)(lmbda("'h_159188406_1252753868" :: "nat" :: Type)(lmbda("'i_854809894_1063004260" :: Type)(("pprod" :: FuncTyp(Type, FuncTyp(Type, Type)))(("pprod" :: FuncTyp(Type, FuncTyp(Type, Type)))(piDefn("'aj_1206240905" :: "nat" :: Type)(("decidable" :: FuncTyp(Prop, Type))(("eq" :: piDefn("'c_50167528" :: Type)(FuncTyp("'c_50167528" :: Type, FuncTyp("'c_50167528" :: Type, Prop))))("nat" :: Type)("'h_159188406_1252753868" :: "nat" :: Type)("'aj_1206240905" :: "nat" :: Type))))("'i_854809894_1063004260" :: Type))("punit" :: Type))))("'v_256405719_824809037" :: "nat" :: Type)))(("pprod.mk" :: piDefn("'f_675522330" :: Type)(piDefn("'g_846763706" :: Type)(FuncTyp("'f_675522330" :: Type, FuncTyp("'g_846763706" :: Type, ("pprod" :: FuncTyp(Type, FuncTyp(Type, Type)))("'f_675522330" :: Type)("'g_846763706" :: Type))))))(piDefn("'aj_1341981151" :: "nat" :: Type)(("decidable" :: FuncTyp(Prop, Type))(("eq" :: piDefn("'c_2091825704" :: Type)(FuncTyp("'c_2091825704" :: Type, FuncTyp("'c_2091825704" :: Type, Prop))))("nat" :: Type)(("nat.succ" :: FuncTyp("nat" :: Type, "nat" :: Type))("'v_256405719_824809037" :: "nat" :: Type))("'aj_1341981151" :: "nat" :: Type))))(("pprod" :: FuncTyp(Type, FuncTyp(Type, Type)))(("pprod" :: FuncTyp(Type, FuncTyp(Type, Type)))(piDefn("'aj_1316533546" :: "nat" :: Type)(("decidable" :: FuncTyp(Prop, Type))(("eq" :: piDefn("'c_407921702" :: Type)(FuncTyp("'c_407921702" :: Type, FuncTyp("'c_407921702" :: Type, Prop))))("nat" :: Type)("'v_256405719_824809037" :: "nat" :: Type)("'aj_1316533546" :: "nat" :: Type))))(({
    val rxyz = natInd.value.rec(Type)
    rxyz
  })("punit" :: Type)(lmbda("'h_159188406_172154436" :: "nat" :: Type)(lmbda("'i_854809894_13757603" :: Type)(("pprod" :: FuncTyp(Type, FuncTyp(Type, Type)))(("pprod" :: FuncTyp(Type, FuncTyp(Type, Type)))(piDefn("'aj_570766676" :: "nat" :: Type)(("decidable" :: FuncTyp(Prop, Type))(("eq" :: piDefn("'c_1357484458" :: Type)(FuncTyp("'c_1357484458" :: Type, FuncTyp("'c_1357484458" :: Type, Prop))))("nat" :: Type)("'h_159188406_172154436" :: "nat" :: Type)("'aj_570766676" :: "nat" :: Type))))("'i_854809894_13757603" :: Type))("punit" :: Type))))("'v_256405719_824809037" :: "nat" :: Type)))("punit" :: Type))(lambda("'ak_992690145_442713787" :: "nat" :: Type)(({
    val rxyz = natInd.value.induc(lmbda("$vuyd_613901509_342365532" :: "nat" :: Type)(("decidable" :: FuncTyp(Prop, Type))(("eq" :: piDefn("'c_1458801026" :: Type)(FuncTyp("'c_1458801026" :: Type, FuncTyp("'c_1458801026" :: Type, Prop))))("nat" :: Type)(("nat.succ" :: FuncTyp("nat" :: Type, "nat" :: Type))("'v_256405719_824809037" :: "nat" :: Type))("$vuyd_613901509_342365532" :: "nat" :: Type))))
    rxyz
  })("_" :: ("decidable" :: FuncTyp(Prop, Type))(("eq" :: piDefn("'c_725449410" :: Type)(FuncTyp("'c_725449410" :: Type, FuncTyp("'c_725449410" :: Type, Prop))))("nat" :: Type)(("nat.succ" :: FuncTyp("nat" :: Type, "nat" :: Type))("'v_256405719_824809037" :: "nat" :: Type))("nat.zero" :: "nat" :: Type)))(lambda("'k_217786156_1644604919" :: "nat" :: Type)(lmbda("_" :: ("decidable" :: FuncTyp(Prop, Type))(("eq" :: piDefn("'c_1680527083" :: Type)(FuncTyp("'c_1680527083" :: Type, FuncTyp("'c_1680527083" :: Type, Prop))))("nat" :: Type)(("nat.succ" :: FuncTyp("nat" :: Type, "nat" :: Type))("'v_256405719_824809037" :: "nat" :: Type))("'k_217786156_1644604919" :: "nat" :: Type)))("_" :: ("decidable" :: FuncTyp(Prop, Type))(("eq" :: piDefn("'c_732934483" :: Type)(FuncTyp("'c_732934483" :: Type, FuncTyp("'c_732934483" :: Type, Prop))))("nat" :: Type)(("nat.succ" :: FuncTyp("nat" :: Type, "nat" :: Type))("'v_256405719_824809037" :: "nat" :: Type))(("nat.succ" :: FuncTyp("nat" :: Type, "nat" :: Type))("'k_217786156_1644604919" :: "nat" :: Type))))))("'ak_992690145_442713787" :: "nat" :: Type)))(("pprod.mk" :: piDefn("'f_312051171" :: Type)(piDefn("'g_809320227" :: Type)(FuncTyp("'f_312051171" :: Type, FuncTyp("'g_809320227" :: Type, ("pprod" :: FuncTyp(Type, FuncTyp(Type, Type)))("'f_312051171" :: Type)("'g_809320227" :: Type))))))(("pprod" :: FuncTyp(Type, FuncTyp(Type, Type)))(piDefn("'aj_1549870794" :: "nat" :: Type)(("decidable" :: FuncTyp(Prop, Type))(("eq" :: piDefn("'c_1459284809" :: Type)(FuncTyp("'c_1459284809" :: Type, FuncTyp("'c_1459284809" :: Type, Prop))))("nat" :: Type)("'v_256405719_824809037" :: "nat" :: Type)("'aj_1549870794" :: "nat" :: Type))))(({
    val rxyz = natInd.value.rec(Type)
    rxyz
  })("punit" :: Type)(lmbda("'h_159188406_144083388" :: "nat" :: Type)(lmbda("'i_854809894_1751287348" :: Type)(("pprod" :: FuncTyp(Type, FuncTyp(Type, Type)))(("pprod" :: FuncTyp(Type, FuncTyp(Type, Type)))(piDefn("'aj_1096024289" :: "nat" :: Type)(("decidable" :: FuncTyp(Prop, Type))(("eq" :: piDefn("'c_276194302" :: Type)(FuncTyp("'c_276194302" :: Type, FuncTyp("'c_276194302" :: Type, Prop))))("nat" :: Type)("'h_159188406_144083388" :: "nat" :: Type)("'aj_1096024289" :: "nat" :: Type))))("'i_854809894_1751287348" :: Type))("punit" :: Type))))("'v_256405719_824809037" :: "nat" :: Type)))("punit" :: Type)("'w_566843556_694375782" :: ("pprod" :: FuncTyp(Type, FuncTyp(Type, Type)))(piDefn("'aj_1281576755" :: "nat" :: Type)(("decidable" :: FuncTyp(Prop, Type))(("eq" :: piDefn("'c_2097588084" :: Type)(FuncTyp("'c_2097588084" :: Type, FuncTyp("'c_2097588084" :: Type, Prop))))("nat" :: Type)("'v_256405719_824809037" :: "nat" :: Type)("'aj_1281576755" :: "nat" :: Type))))(({
    val rxyz = natInd.value.rec(Type)
    rxyz
  })("punit" :: Type)(lmbda("'h_159188406_1252753868" :: "nat" :: Type)(lmbda("'i_854809894_1063004260" :: Type)(("pprod" :: FuncTyp(Type, FuncTyp(Type, Type)))(("pprod" :: FuncTyp(Type, FuncTyp(Type, Type)))(piDefn("'aj_1206240905" :: "nat" :: Type)(("decidable" :: FuncTyp(Prop, Type))(("eq" :: piDefn("'c_50167528" :: Type)(FuncTyp("'c_50167528" :: Type, FuncTyp("'c_50167528" :: Type, Prop))))("nat" :: Type)("'h_159188406_1252753868" :: "nat" :: Type)("'aj_1206240905" :: "nat" :: Type))))("'i_854809894_1063004260" :: Type))("punit" :: Type))))("'v_256405719_824809037" :: "nat" :: Type)))("punit.star" :: "punit" :: Type)))))("'ag_1531296106_1797768165" :: "nat" :: Type)))
}
