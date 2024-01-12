package observer.device

import observer.log.{Entity, EntityChange, Loggable}
import scala.util.Random

case class BrightnessSensor(name: String) extends Sensor with Loggable[Entity, EntityChange]:
  private var measure: Double = 0.0d

  override def currentMeasure: Double = measure

  override def remeasure(): Unit = measure = Random.between(0.0d, 1.0d+Double.MinPositiveValue)