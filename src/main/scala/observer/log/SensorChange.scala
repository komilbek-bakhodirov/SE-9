package observer.log

enum SensorChange extends EntityChange:
  case Increase(amount: Double)
  case Decrease(amount: Double)
  case NoChange

  override def pretty: String = this match
    case Increase(amount: Double) => s"measure increased by $amount"
    case Decrease(amount: Double) => s"measure decreased by $amount"
    case NoChange => "measure did not change"