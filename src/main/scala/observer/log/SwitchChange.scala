package observer.log

enum SwitchChange extends EntityChange:
  case On
  case Off

  override def pretty: String = this match
    case On  => "switch turned on"
    case Off => "switch turned off"