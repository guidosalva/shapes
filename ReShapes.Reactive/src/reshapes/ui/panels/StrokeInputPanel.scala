package reshapes.ui.panels

import java.awt.Color
import scala.events.behaviour.Var
import scala.swing.Action
import scala.swing.BoxPanel
import scala.swing.Button
import scala.swing.Component
import scala.swing.FlowPanel
import scala.swing.Frame
import scala.swing.Label
import scala.swing.Orientation
import scala.swing.Slider
import scala.swing.event.ValueChanged
import javax.swing.JColorChooser
import reswing.ReSlider
import reswing.ReButton

/**
 * Panel for various customization of the stroke.
 */
class StrokeInputPanel extends FlowPanel {
  private val colorWindow = new ColorWindow
  
  private val slider = ReSlider(
      min = 1,
      max = 50,
      value = 1,
      minorTickSpacing = 1,
      paintTicks = true)
  
  private val showColorWindow = ReButton("Show Colorinput")
  showColorWindow.clicked += {_ => colorWindow.visible = !colorWindow.visible}
  
  contents += new Label { text = "stroke width: " }
  contents += slider
  contents += showColorWindow
  
  val strokeWidth = slider.value
  val color = colorWindow.color
}

class ColorWindow extends Frame {
  title = "Choose color"
  
  private val colorChooser = new Component {
    override lazy val peer = new JColorChooser
  }
  
  contents = new BoxPanel(Orientation.Vertical) {
    contents += colorChooser
    contents += new Button(Action("OK") {
      color() = colorChooser.peer.getColor
      ColorWindow.this.visible = false
    })
  }
  
  val color = Var(Color.BLACK)
}