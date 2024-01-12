package observer.log

import java.net.URI

enum AccountChange extends EntityChange:
  case NameChange(newName: String)
  case MailChange(newMail: String)
  case ProfilePictureChange(newProfilePicture: Option[URI])

  override def pretty: String = this match
    case NameChange(newName: String) => s"name changed to $newName"
    case MailChange(newMail: String) => s"mail changed to $newMail"
    case ProfilePictureChange(newProfilePicture: Option[URI]) => newProfilePicture match
      case Some(value) => s"profile picture changed to ${value.getPath}"
      case None => "removed profile picture"