package observer.device

import observer.log.Entity

trait Device extends Entity:
  val name: String

  override def identifier: String = name
