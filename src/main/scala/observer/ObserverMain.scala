package observer

import observer.device.{BrightnessSensor, Switch}
import observer.log.{Entity, EntityChange, TerminalLogger}

import javax.security.auth.Subject

@main def ObserverMain(): Unit =
  // Subjects
  val sensor = new BrightnessSensor("Sensor 1")
  val switch = new Switch("Switch 1")

  // Observer
  val logger = new TerminalLogger[Entity, EntityChange]

  // attach the logger to the subjects
  sensor.attach(logger)
  switch.attach(logger)

  sensor.remeasure()
  switch.set(1)
