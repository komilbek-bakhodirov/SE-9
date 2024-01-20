package observer.device

import observer.log.{Entity, EntityChange, Loggable, SensorChange}

import scala.util.Random

case class BrightnessSensor(name: String) extends Sensor with Loggable[Entity, EntityChange]:
  private var measure: Double = 0.0d

  override def currentMeasure: Double = measure

  override def remeasure(): Unit = {
    val oldMeasure = measure
    measure = Random.between(0.0d, 1.0d+Double.MinPositiveValue)

    val delta = if (measure > oldMeasure)
      SensorChange.Increase(measure - oldMeasure)
    else if (measure < oldMeasure)
      SensorChange.Decrease(oldMeasure - measure)
    else
      SensorChange.NoChange

    notifyObservers(this, delta, System.currentTimeMillis())
  }