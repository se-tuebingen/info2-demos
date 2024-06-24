package subtyping;

interface GUIComponent {
  void render();
}

interface Clickable extends GUIComponent {
  boolean onClick(int x, int y);
}


public class GuiExample {

  static void renderAll(GUIComponent[] components) {
    for (GUIComponent c : components) {
      c.render();
    }
  }

  static void handleClick(Clickable[] components, int x, int y) {
    for (Clickable c : components) {
      if (c.onClick(x, y)) break;
    }
  }

}
