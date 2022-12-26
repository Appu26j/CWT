package apple26j.components;

import apple26j.GUI;
import apple26j.Window;
import org.lwjgl.opengl.GL14;

import java.awt.*;

import static org.lwjgl.opengl.GL11.*;

public class CheckBox extends Component
{
    private CheckBoxClickListener checkBoxClickListener;
    private boolean clicked = false, disabled, ticked;
    private final float temp1, temp2;
    private final int fontSize;

    public CheckBox(String text, float x, float y, long componentID, Window parentWindow)
    {
        this.text = text;
        this.x = x;
        this.y = y;
        this.width = x + (this.temp1 = 13);
        this.height = y + (this.temp2 = 13);
        this.parentWindow = parentWindow;
        this.componentID = componentID;
        this.fontSize = 16;
        this.disabled = false;
        this.ticked = false;
    }

    public CheckBox(String text, float x, float y, long componentID, boolean ticked, Window parentWindow)
    {
        this.text = text;
        this.x = x;
        this.y = y;
        this.width = x + (this.temp1 = 13);
        this.height = y + (this.temp2 = 13);
        this.parentWindow = parentWindow;
        this.componentID = componentID;
        this.fontSize = 16;
        this.disabled = false;
        this.ticked = ticked;
    }

    public CheckBox(String text, float x, float y, boolean disabled, long componentID, Window parentWindow)
    {
        this.text = text;
        this.x = x;
        this.y = y;
        this.width = x + (this.temp1 = 13);
        this.height = y + (this.temp2 = 13);
        this.parentWindow = parentWindow;
        this.componentID = componentID;
        this.fontSize = 16;
        this.disabled = disabled;
        this.ticked = false;
    }

    public CheckBox(String text, float x, float y, boolean disabled, long componentID, boolean ticked, Window parentWindow)
    {
        this.text = text;
        this.x = x;
        this.y = y;
        this.width = x + (this.temp1 = 13);
        this.height = y + (this.temp2 = 13);
        this.parentWindow = parentWindow;
        this.componentID = componentID;
        this.fontSize = 16;
        this.disabled = disabled;
        this.ticked = ticked;
    }

    public CheckBox(String text, float x, float y, int fontSize, long componentID, Window parentWindow)
    {
        this.text = text;
        this.x = x;
        this.y = y;
        this.width = x + (this.temp1 = 13);
        this.height = y + (this.temp2 = 13);
        this.parentWindow = parentWindow;
        this.componentID = componentID;
        this.fontSize = fontSize;
        this.disabled = false;
        this.ticked = false;
    }

    public CheckBox(String text, float x, float y, int fontSize, long componentID, boolean ticked, Window parentWindow)
    {
        this.text = text;
        this.x = x;
        this.y = y;
        this.width = x + (this.temp1 = 13);
        this.height = y + (this.temp2 = 13);
        this.parentWindow = parentWindow;
        this.componentID = componentID;
        this.fontSize = fontSize;
        this.disabled = false;
        this.ticked = ticked;
    }

    public CheckBox(String text, float x, float y, int fontSize, boolean disabled, long componentID, Window parentWindow)
    {
        this.text = text;
        this.x = x;
        this.y = y;
        this.width = x + (this.temp1 = 13);
        this.height = y + (this.temp2 = 13);
        this.parentWindow = parentWindow;
        this.componentID = componentID;
        this.fontSize = fontSize;
        this.disabled = disabled;
        this.ticked = false;
    }

    public CheckBox(String text, float x, float y, int fontSize, boolean disabled, long componentID, boolean ticked, Window parentWindow)
    {
        this.text = text;
        this.x = x;
        this.y = y;
        this.width = x + (this.temp1 = 13);
        this.height = y + (this.temp2 = 13);
        this.parentWindow = parentWindow;
        this.componentID = componentID;
        this.fontSize = fontSize;
        this.disabled = disabled;
        this.ticked = ticked;
    }

    public CheckBox(String text, float x, float y, float width, float height, long componentID, Window parentWindow)
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
        this.ticked = false;
    }

    public CheckBox(String text, float x, float y, float width, float height, long componentID, boolean ticked, Window parentWindow)
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
        this.ticked = ticked;
    }

    public CheckBox(String text, float x, float y, float width, float height, boolean disabled, long componentID, Window parentWindow)
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
        this.ticked = false;
    }

    public CheckBox(String text, float x, float y, float width, float height, boolean disabled, long componentID, boolean ticked, Window parentWindow)
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
        this.ticked = ticked;
    }

    public CheckBox(String text, float x, float y, float width, float height, int fontSize, long componentID, Window parentWindow)
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
        this.ticked = false;
    }

    public CheckBox(String text, float x, float y, float width, float height, int fontSize, long componentID, boolean ticked, Window parentWindow)
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
        this.ticked = ticked;
    }

    public CheckBox(String text, float x, float y, float width, float height, int fontSize, boolean disabled, long componentID, Window parentWindow)
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
        this.ticked = false;
    }

    public CheckBox(String text, float x, float y, float width, float height, int fontSize, boolean disabled, long componentID, boolean ticked, Window parentWindow)
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
        this.ticked = ticked;
    }

    @Override
    public void drawScreen(int mouseX, int mouseY)
    {
        if (this.ticked)
        {
            if (this.disabled)
            {
                GUI.drawRect(this.x, this.y, this.width, this.height, new Color(255, 255, 255));
                glEnable(GL_ALPHA);
                glEnable(GL_BLEND);
                glEnable(GL_LINE_SMOOTH);
                glHint(GL_LINE_SMOOTH, GL_NICEST);
                float previousLineWidth = glGetFloat(GL_LINE_WIDTH);
                glLineWidth(1.5F);
                GL14.glBlendFuncSeparate(GL_SRC_ALPHA, GL_ONE_MINUS_SRC_ALPHA, 1, 0);
                int colorRGB = new Color(205, 205, 205).getRGB();
                float alpha = (float)((colorRGB >> 24) & 0xFF) / 255;
                float red = (float)((colorRGB >> 16) & 0xFF) / 255;
                float green = (float)((colorRGB >> 8) & 0xFF) / 255;
                float blue = (float)((colorRGB) & 0xFF) / 255;
                glColor4f(red, green, blue, alpha);
                glBegin(GL_LINES);
                glVertex2f(this.x + 2, this.y + 6);
                glVertex2f(this.x + 5, this.height - 4);
                glVertex2f(this.x + 5, this.height - 4);
                glVertex2f(this.width - 2, this.y + 3);
                glEnd();
                glColor4f(1, 1, 1, 1);
                glLineWidth(previousLineWidth);
                glDisable(GL_LINE_SMOOTH);
                glDisable(GL_BLEND);
                glDisable(GL_ALPHA);
            }

            else
            {
                GUI.drawRect(this.x, this.y, this.width, this.height, this.isInside(mouseX, mouseY, this.x, this.y, this.width + 5 + this.parentWindow.getDefaultFontRenderer(this.fontSize).getStringWidth(this.text), this.height) && this.clicked ? new Color(205, 230, 245) : new Color(255, 255, 255));
                glEnable(GL_ALPHA);
                glEnable(GL_BLEND);
                glEnable(GL_LINE_SMOOTH);
                glHint(GL_LINE_SMOOTH, GL_NICEST);
                float previousLineWidth = glGetFloat(GL_LINE_WIDTH);
                glLineWidth(1.5F);
                GL14.glBlendFuncSeparate(GL_SRC_ALPHA, GL_ONE_MINUS_SRC_ALPHA, 1, 0);
                int colorRGB = (this.isInside(mouseX, mouseY, this.x, this.y, this.width + 5 + this.parentWindow.getDefaultFontRenderer(this.fontSize).getStringWidth(this.text), this.height) ? this.clicked ? new Color(0, 85, 155) : new Color(0, 120, 215) : this.clicked ? new Color(0, 85, 155) : new Color(70, 70, 70)).getRGB();
                float alpha = (float)((colorRGB >> 24) & 0xFF) / 255;
                float red = (float)((colorRGB >> 16) & 0xFF) / 255;
                float green = (float)((colorRGB >> 8) & 0xFF) / 255;
                float blue = (float)((colorRGB) & 0xFF) / 255;
                glColor4f(red, green, blue, alpha);
                glBegin(GL_LINES);
                glVertex2f(this.x + 2, this.y + 6);
                glVertex2f(this.x + 5, this.height - 4);
                glVertex2f(this.x + 5, this.height - 4);
                glVertex2f(this.width - 2, this.y + 3);
                glEnd();
                glColor4f(1, 1, 1, 1);
                glLineWidth(previousLineWidth);
                glDisable(GL_LINE_SMOOTH);
                glDisable(GL_BLEND);
                glDisable(GL_ALPHA);
            }
        }

        if (this.disabled)
        {
            GUI.drawOutline(this.x, this.y, this.width, this.height, new Color(205, 205, 205));
            this.parentWindow.getDefaultFontRenderer(this.fontSize).drawString(this.text, this.width + 5, ((this.y + this.height) / 2) - (this.parentWindow.getDefaultFontRenderer(this.fontSize).getSize() / 2.0F), new Color(130, 130, 130));
        }

        else
        {
            GUI.drawOutline(this.x, this.y, this.width, this.height, this.isInside(mouseX, mouseY, this.x, this.y, this.width + 5 + this.parentWindow.getDefaultFontRenderer(this.fontSize).getStringWidth(this.text), this.height) ? this.clicked ? new Color(0, 85, 155) : new Color(0, 120, 215) : this.clicked ? new Color(0, 120, 215) : new Color(50, 50, 50));
            this.parentWindow.getDefaultFontRenderer(this.fontSize).drawString(this.text, this.width + 5, ((this.y + this.height) / 2) - (this.parentWindow.getDefaultFontRenderer(this.fontSize).getSize() / 2.0F), new Color(0, 0, 0));
        }
    }

    @Override
    public void mouseClicked(int mouseButton, int mouseX, int mouseY)
    {
        if (!this.disabled && this.isInside(mouseX, mouseY, this.x, this.y, this.width + 5 + this.parentWindow.getDefaultFontRenderer(this.fontSize).getStringWidth(this.text), this.height) && mouseButton == 0)
        {
            this.clicked = true;
        }
    }

    @Override
    public void mouseReleased(int mouseButton, int mouseX, int mouseY)
    {
        if (!this.disabled && this.clicked)
        {
            if (this.isInside(mouseX, mouseY, this.x, this.y, this.width + 5 + this.parentWindow.getDefaultFontRenderer(this.fontSize).getStringWidth(this.text), this.height) && mouseButton == 0)
            {
                this.ticked = !this.ticked;

                if (this.checkBoxClickListener != null)
                {
                    this.checkBoxClickListener.onCheckBoxClick();
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

    public void setCheckBoxClickListener(CheckBoxClickListener checkBoxClickListener)
    {
        this.checkBoxClickListener = checkBoxClickListener;
    }

    public boolean isTicked()
    {
        return this.ticked;
    }

    public void setDisabled(boolean disabled)
    {
        this.disabled = disabled;
    }

    private boolean isInside(int mouseX, int mouseY, float x, float y, float width, float height)
    {
        return mouseX >= x && mouseX <= width && mouseY >= y && mouseY <= height;
    }

    public abstract static class CheckBoxClickListener
    {
        public abstract void onCheckBoxClick();
    }
}
