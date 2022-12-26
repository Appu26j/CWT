package apple26j;

import org.lwjgl.opengl.GL14;

import java.awt.*;

import static org.lwjgl.opengl.GL11.*;

public class GUI
{
    public static void drawRect(float x, float y, float width, float height, Color color)
    {
        glEnable(GL_ALPHA);
        glEnable(GL_BLEND);
        GL14.glBlendFuncSeparate(GL_SRC_ALPHA, GL_ONE_MINUS_SRC_ALPHA, 1, 0);
        int colorRGB = color.getRGB();
        float alpha = (float)((colorRGB >> 24) & 0xFF) / 255;
        float red = (float)((colorRGB >> 16) & 0xFF) / 255;
        float green = (float)((colorRGB >> 8) & 0xFF) / 255;
        float blue = (float)((colorRGB) & 0xFF) / 255;
        glColor4f(red, green, blue, alpha);
        glBegin(GL_QUADS);
        glVertex2f(x, height);
        glVertex2f(width, height);
        glVertex2f(width, y);
        glVertex2f(x, y);
        glEnd();
        glColor4f(1, 1, 1, 1);
        glDisable(GL_BLEND);
        glDisable(GL_ALPHA);
    }

    public static void drawOutline(float x, float y, float width, float height, Color color)
    {
        drawRect(x, y, width, y + 1, color);
        drawRect(x, height - 1, width, height, color);
        drawRect(x, y, x + 1, height, color);
        drawRect(width - 1, y, width, height, color);
    }
}
