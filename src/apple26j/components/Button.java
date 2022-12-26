package apple26j.components;

import apple26j.GUI;
import apple26j.Window;

import java.awt.*;

public class Button extends Component
{
    private ButtonClickListener buttonClickListener;
    private boolean clicked = false, disabled;
    private final float temp1, temp2;
    private final int fontSize;

    public Button(String text, float x, float y, long componentID, Window parentWindow)
    {
        this.text = text;
        this.x = x;
        this.y = y;
        this.width = x + (this.temp1 = 73);
        this.height = y + (this.temp2 = 21);
        this.parentWindow = parentWindow;
        this.componentID = componentID;
        this.fontSize = 16;
        this.disabled = false;
    }

    public Button(String text, float x, float y, boolean disabled, long componentID, Window parentWindow)
    {
        this.text = text;
        this.x = x;
        this.y = y;
        this.width = x + (this.temp1 = 73);
        this.height = y + (this.temp2 = 21);
        this.parentWindow = parentWindow;
        this.componentID = componentID;
        this.fontSize = 16;
        this.disabled = disabled;
    }

    public Button(String text, float x, float y, int fontSize, long componentID, Window parentWindow)
    {
        this.text = text;
        this.x = x;
        this.y = y;
        this.width = x + (this.temp1 = 73);
        this.height = y + (this.temp2 = 21);
        this.parentWindow = parentWindow;
        this.componentID = componentID;
        this.fontSize = fontSize;
        this.disabled = false;
    }

    public Button(String text, float x, float y, int fontSize, boolean disabled, long componentID, Window parentWindow)
    {
        this.text = text;
        this.x = x;
        this.y = y;
        this.width = x + (this.temp1 = 73);
        this.height = y + (this.temp2 = 21);
        this.parentWindow = parentWindow;
        this.componentID = componentID;
        this.fontSize = fontSize;
        this.disabled = disabled;
    }

    public Button(String text, float x, float y, float width, float height, long componentID, Window parentWindow)
    {
        this.text = text;
        this.x = x;
        this.y = y;
        this.width = x + (this.temp1 = width);
        this.height = y + (this.temp2 = height);
        this.parentWindow = parentWindow;
        this.componentID = componentID;
        this.fontSize = 16;
        this.disabled = false;
    }

    public Button(String text, float x, float y, float width, float height, boolean disabled, long componentID, Window parentWindow)
    {
        this.text = text;
        this.x = x;
        this.y = y;
        this.width = x + (this.temp1 = width);
        this.height = y + (this.temp2 = height);
        this.parentWindow = parentWindow;
        this.componentID = componentID;
        this.fontSize = 16;
        this.disabled = disabled;
    }

    public Button(String text, float x, float y, float width, float height, int fontSize, long componentID, Window parentWindow)
    {
        this.text = text;
        this.x = x;
        this.y = y;
        this.width = x + (this.temp1 = width);
        this.height = y + (this.temp2 = height);
        this.parentWindow = parentWindow;
        this.componentID = componentID;
        this.fontSize = fontSize;
        this.disabled = false;
    }

    public Button(String text, float x, float y, float width, float height, int fontSize, boolean disabled, long componentID, Window parentWindow)
    {
        this.text = text;
        this.x = x;
        this.y = y;
        this.width = x + (this.temp1 = width);
        this.height = y + (this.temp2 = height);
        this.parentWindow = parentWindow;
        this.componentID = componentID;
        this.fontSize = fontSize;
        this.disabled = disabled;
    }

    @Override
    public void drawScreen(int mouseX, int mouseY)
    {
        if (this.disabled)
        {
            GUI.drawRect(this.x, this.y, this.width, this.height, new Color(205, 205, 205));
            GUI.drawOutline(this.x, this.y, this.width, this.height, new Color(190, 190, 190));
            this.parentWindow.getDefaultFontRenderer(this.fontSize).drawString(this.text, ((this.x + this.width) / 2) - (this.parentWindow.getDefaultFontRenderer(this.fontSize).getStringWidth(this.text) / 2), ((this.y + this.height) / 2) - (this.parentWindow.getDefaultFontRenderer(this.fontSize).getSize() / 2.0F), new Color(130, 130, 130));
        }

        else
        {
            GUI.drawRect(this.x, this.y, this.width, this.height, this.isInside(mouseX, mouseY, this.x, this.y, this.width, this.height) ? this.clicked ? new Color(205, 230, 245) : new Color(230, 240, 250) : this.clicked ? new Color(230, 240, 250) : new Color(225, 225, 225));
            GUI.drawOutline(this.x, this.y, this.width, this.height, this.isInside(mouseX, mouseY, this.x, this.y, this.width, this.height) ? this.clicked ? new Color(0, 85, 155) : new Color(0, 120, 215) : this.clicked ? new Color(0, 120, 215) : new Color(175, 175, 175));
            this.parentWindow.getDefaultFontRenderer(this.fontSize).drawString(this.text, ((this.x + this.width) / 2) - (this.parentWindow.getDefaultFontRenderer(this.fontSize).getStringWidth(this.text) / 2), ((this.y + this.height) / 2) - (this.parentWindow.getDefaultFontRenderer(this.fontSize).getSize() / 2.0F), new Color(0, 0, 0));
        }
    }

    @Override
    public void mouseClicked(int mouseButton, int mouseX, int mouseY)
    {
        if (!this.disabled && this.isInside(mouseX, mouseY, this.x, this.y, this.width, this.height) && mouseButton == 0)
        {
            this.clicked = true;
        }
    }

    @Override
    public void mouseReleased(int mouseButton, int mouseX, int mouseY)
    {
        if (!this.disabled && this.clicked)
        {
            if (this.isInside(mouseX, mouseY, this.x, this.y, this.width, this.height) && mouseButton == 0)
            {
                if (this.buttonClickListener != null)
                {
                    this.buttonClickListener.onButtonClick();
                }
            }

            this.clicked = false;
        }
    }

    @Override
    public void changePosition(float x, float y)
    {
        super.changePosition(x, y);
        this.width = x + this.temp1;
        this.height = y + this.temp2;
    }

    @Override
    public void changePositionAndSize(float x, float y, float width, float height)
    {
        super.changePosition(x, y);
        this.width = x + 73;
        this.height = y + 21;
    }

    public void setButtonClickListener(ButtonClickListener buttonClickListener)
    {
        this.buttonClickListener = buttonClickListener;
    }

    public void setDisabled(boolean disabled)
    {
        this.disabled = disabled;
    }

    private boolean isInside(int mouseX, int mouseY, float x, float y, float width, float height)
    {
        return mouseX >= x && mouseX <= width && mouseY >= y && mouseY <= height;
    }

    public abstract static class ButtonClickListener
    {
        public abstract void onButtonClick();
    }
}
