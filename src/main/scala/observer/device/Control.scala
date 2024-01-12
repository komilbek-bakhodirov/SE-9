package observer.device

trait Control extends Device:
  def currentState: Int
  def set(state: Int): Boolean
