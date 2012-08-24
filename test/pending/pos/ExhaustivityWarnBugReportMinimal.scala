object ExhaustivityWarnBugReportMinimal {
  //sealed is needed for the warning.
  sealed trait FoundNode[T]/*presence of parameters is irrelevant*/
  case class FoundFilter[T](/*presence of parameters is irrelevant*/) extends FoundNode[T]
  case class FoundTypeCase[T](/*presence of parameters is irrelevant*/) extends FoundNode[T]
  val f: Some[_] = ???
  f match {
    case x: Some[t] => //no warning
  }
  val v: (Some[_], FoundNode[_]) = (???, ???)
  v match {
    case (x: Some[t], _: FoundNode[_]) =>
  }
  //Warning here:
  v match {
    case (x: Some[t], _) =>
  }

  //No warning here:
  val v2: (Some[_], Int) = (???, ???)
  v2 match {
    case (x: Some[t], _) =>
  }
}
