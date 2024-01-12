package observer.log

import scala.collection.mutable.Set as mSet

trait Loggable[Subject, Delta]:
  val observers: mSet[LoggingObserver[Subject, Delta]] = mSet.empty

  ???
