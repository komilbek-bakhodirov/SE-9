package observer.device

trait Sensor extends Device:
  def currentMeasure: Double
  def remeasure(): Unit
