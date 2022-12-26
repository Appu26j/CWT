# CWT
CWT, an OpenGL GUI made to look like Windows' native GUI.

Example code:

```
package apple26j;

import apple26j.components.Button;
import apple26j.components.CheckBox;
import apple26j.components.Tabs;

import java.awt.*;

public class Example
{
    public static void main(String[] args)
    {
        Window window = new Window("Win10", 205, 185, true, false, true, false).create();
        CheckBox totally = new CheckBox("Totally", 0, 0, 1, true, window);
        Button awesome = new Button("Awesome", 0, 0, 2, window);
        Tabs tabs = new Tabs(window, 5, 5, "Widget", 3, "Widget", "Toolkit");
        window.addComponents(awesome, totally, tabs);

        totally.setCheckBoxClickListener(new CheckBox.CheckBoxClickListener()
        {
            @Override
            public void onCheckBoxClick()
            {
                ;
            }
        });

        awesome.setButtonClickListener(new Button.ButtonClickListener()
        {
            @Override
            public void onButtonClick()
            {
                ;
            }
        });

        tabs.setTabClickListener(new Tabs.TabClickListener()
        {
            @Override
            public void onTabClick()
            {
                ;
            }
        });

        window.setMouseClickListener(new Window.MouseClickListener()
        {
            @Override
            public void onMouseClick(int mouseButton, int mouseX, int mouseY)
            {
                ;
            }
        });

        window.setMouseReleaseListener(new Window.MouseReleaseListener()
        {
            @Override
            public void onMouseRelease(int mouseButton, int mouseX, int mouseY)
            {
                ;
            }
        });

        while (!window.shouldClose())
        {
            window.beginUpdate();
            GUI.drawRect(0, 0, window.getWidth(), window.getHeight(), new Color(240, 240, 240));
            totally.changePosition(15, window.getHeight() - 23);
            awesome.changePosition(window.getWidth() - 88, window.getHeight() - 26);
            window.drawComponents();
            window.endUpdate();
        }

        window.destroy();
    }
}
```

![image](https://user-images.githubusercontent.com/121107142/209504572-8c505e00-b71b-46b1-968e-725e90762106.png)

