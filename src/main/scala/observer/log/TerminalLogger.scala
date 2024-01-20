package observer.log

class TerminalLogger[Subject <: Entity, Delta <: EntityChange] extends LoggingObserver[Subject, Delta] {

  def update(subject: Subject, delta: Delta, timestamp: Long): Unit = {
    val logEntry = s"$timestamp;${subject.identifier};${delta.pretty}"
    println(logEntry)
  }
}