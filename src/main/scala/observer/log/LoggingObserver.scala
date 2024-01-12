package observer.log

trait LoggingObserver[Subject, Delta]:
  def update(subject: Subject, delta: Delta, timestamp: Long): Unit