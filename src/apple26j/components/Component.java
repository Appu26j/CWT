package apple26j.components;

import apple26j.Window;

public abstract class Component
{
    protected float x, y, width, height;
    protected Window parentWindow;
    protected long componentID;
    protected String text;

    protected Component()
    {
        ;
    }

    public abstract void drawScreen(int mouseX, int mouseY);

    public void mouseClicked(int mouseButton, int mouseX, int mouseY)
    {
        ;
    }

    public void mouseReleased(int mouseButton, int mouseX, int mouseY)
    {
        ;
    }

    public void changePosition(float x, float y)
    {
        this.x = x;
        this.y = y;
    }

    public void changePositionAndSize(float x, float y, float width, float height)
    {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public long getComponentID()
    {
        return this.componentID;
    }
}
