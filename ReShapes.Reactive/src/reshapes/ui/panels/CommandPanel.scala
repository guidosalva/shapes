package reshapes.ui.panels

import scala.swing.BoxPanel
import scala.swing.Component
import scala.swing.Orientation
import scala.swing.ScrollPane

import macro.SignalMacro.{SignalM => Signal}
import react.SignalSynt
import react.events.Event
import reshapes.ReShapes
import reshapes.drawing.Command
import reshapes.util.ReactiveUtil.UnionEvent
import reswing.ReBoxPanel
import reswing.ReButton

/**
 * The CommandPanel lists all executed commands and makes it possible to revert them
 */
class CommandPanel extends BoxPanel(Orientation.Vertical) {
  def state = ReShapes.drawingSpaceState
  
  val commands = Signal { if (state() != null) state().commands() else List.empty }
  
  val buttonsEvents = Signal {
    commands() map { command =>
      val button = ReButton(command.description)
      (button: Component, button.clicked map {_: Any => command}) }
  }
  
  val revert = UnionEvent(Signal {
    buttonsEvents() map { case (_, ev) => ev: Event[Command] }
  })
  
  val commandPanel = ReBoxPanel(
    orientation = Orientation.Vertical,
    contents = Signal { (buttonsEvents() map { case (btn, _) => btn }): Seq[Component] })
  
  contents += new ScrollPane {
    contents = commandPanel
  }
}