package observer.log

import scala.collection.mutable.Set as mSet

trait Loggable[Subject, Delta]:
  val observers: mSet[LoggingObserver[Subject, Delta]] = mSet.empty

  def attach(observer: LoggingObserver[Subject, Delta]): Unit = observers += observer
  def detach(observer: LoggingObserver[Subject, Delta]): Unit = observers -= observer

  def notifyObservers(subject: Subject, delta: Delta, timestamp: Long): Unit =
    for (observer <- observers)
      observer.update(subject, delta, timestamp)