package observer.device

import observer.log.{Entity, EntityChange, Loggable, SwitchChange}

case class Switch(name: String) extends Control with Loggable[Entity, EntityChange]:
  private var state: Boolean = false

  override def currentState: Int = if state then 1 else 0

  override def set(state: Int): Boolean =
    val oldState = this.state
    val result = if (this.state)
      if (state <= 0)
        this.state = false
        true
      else
        false
    else
      if (state > 0)
        this.state = true
        true
      else
        false

    if (oldState != this.state){
      val delta = if (this.state) SwitchChange.On else SwitchChange.Off
      notifyObservers(this, delta, System.currentTimeMillis())
    }
    result 

