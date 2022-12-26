package apple26j;

import apple26j.components.Component;
import apple26j.fontrenderer.FontRenderer;
import org.lwjgl.glfw.GLFWErrorCallback;
import org.lwjgl.opengl.GL;
import org.lwjgl.system.MemoryStack;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.InputStream;
import java.nio.DoubleBuffer;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL11.*;

public class Window
{
    private final ArrayList<FontRenderer> fontRenderers = new ArrayList<>();
    private final ArrayList<Component> components = new ArrayList<>();
    private boolean resizable, vsync, focusOnShow, alwaysOnTop;
    private MouseReleaseListener mouseReleaseListener;
    private MouseClickListener mouseClickListener;
    private int width, height, mouseX, mouseY;
    private String title;
    private long id;

    private Window()
    {
        ;
    }

    public Window(String title, int width, int height)
    {
        this.title = title;
        this.width = width;
        this.height = height;
        this.resizable = true;
        this.vsync = true;
        this.focusOnShow = false;
        this.alwaysOnTop = false;
    }

    public Window(String title, int width, int height, boolean resizable)
    {
        this.title = title;
        this.width = width;
        this.height = height;
        this.resizable = resizable;
        this.vsync = true;
        this.focusOnShow = false;
        this.alwaysOnTop = false;
    }

    public Window(String title, int width, int height, boolean resizable, boolean vsync)
    {
        this.title = title;
        this.width = width;
        this.height = height;
        this.resizable = resizable;
        this.vsync = vsync;
        this.focusOnShow = false;
        this.alwaysOnTop = false;
    }

    public Window(String title, int width, int height, boolean resizable, boolean vsync, boolean focusOnShow)
    {
        this.title = title;
        this.width = width;
        this.height = height;
        this.resizable = resizable;
        this.vsync = vsync;
        this.focusOnShow = focusOnShow;
        this.alwaysOnTop = false;
    }

    public Window(String title, int width, int height, boolean resizable, boolean vsync, boolean focusOnShow, boolean alwaysOnTop)
    {
        this.title = title;
        this.width = width;
        this.height = height;
        this.resizable = resizable;
        this.vsync = vsync;
        this.focusOnShow = focusOnShow;
        this.alwaysOnTop = alwaysOnTop;
    }

    public Window create()
    {
        GLFWErrorCallback.createPrint(System.err).set();
        glfwInit();
        glfwWindowHint(GLFW_RESIZABLE, this.resizable ? GLFW_TRUE : GLFW_FALSE);
        glfwWindowHint(GLFW_FOCUS_ON_SHOW, this.focusOnShow ? GLFW_TRUE : GLFW_FALSE);
        glfwWindowHint(GLFW_FLOATING, this.alwaysOnTop ? GLFW_TRUE : GLFW_FALSE);
        this.id = glfwCreateWindow(this.width, this.height, this.title, 0, 0);

        if (this.id != 0)
        {
            glfwSetWindowSizeCallback(this.id, (window, width, height) ->
            {
                this.width = width;
                this.height = height;
                this.initializeOpenGL();
            });

            glfwSetMouseButtonCallback(this.id, (window, button, action, mods) ->
            {
                if (action == 1)
                {
                    for (Component component : this.components)
                    {
                        component.mouseClicked(button, this.mouseX, this.mouseY);
                    }

                    if (this.mouseClickListener != null)
                    {
                        this.mouseClickListener.onMouseClick(button, this.mouseX, this.mouseY);
                    }
                }

                else
                {
                    for (Component component : this.components)
                    {
                        component.mouseReleased(button, this.mouseX, this.mouseY);
                    }

                    if (this.mouseReleaseListener != null)
                    {
                        this.mouseReleaseListener.onMouseRelease(button, this.mouseX, this.mouseY);
                    }
                }
            });

            glfwMakeContextCurrent(this.id);
            if (this.vsync) { glfwSwapInterval(1); }
            GL.createCapabilities();
            glClearColor(1, 1, 1, 1);
            this.initializeOpenGL();
        }

        return this;
    }

    private void initializeOpenGL()
    {
        glLoadIdentity();
        glOrtho(0, this.width, this.height, 0, 1, 0);
        glViewport(0, 0, this.width, this.height);
        this.fontRenderers.add(new FontRenderer(getFont("font/font.ttf"), 16));
    }

    public boolean shouldClose()
    {
        return this.id != 0 && glfwWindowShouldClose(this.id);
    }

    public void beginUpdate()
    {
        if (this.id != 0)
        {
            glClear(GL_COLOR_BUFFER_BIT);

            try (MemoryStack memoryStack = MemoryStack.stackPush())
            {
                DoubleBuffer mouseX = memoryStack.mallocDouble(1), mouseY = memoryStack.mallocDouble(1);
                glfwGetCursorPos(this.id, mouseX, mouseY);
                this.mouseX = (int) mouseX.get();
                this.mouseY = (int) mouseY.get();
            }
        }
    }

    public void drawComponents()
    {
        if (this.id != 0)
        {
            for (Component component : this.components)
            {
                component.drawScreen(this.mouseX, this.mouseY);
            }
        }
    }

    public void endUpdate()
    {
        if (this.id != 0)
        {
            glfwSwapBuffers(this.id);
            glfwPollEvents();
        }
    }

    public void destroy()
    {
        if (this.id != 0)
        {
            glfwDestroyWindow(this.id);
            glfwTerminate();
            Objects.requireNonNull(glfwSetErrorCallback(null)).free();
        }
    }

    public void requestClose()
    {
        if (this.id != 0)
        {
            glfwSetWindowShouldClose(this.id, true);
        }
    }

    public void minimize()
    {
        if (this.id != 0)
        {
            glfwIconifyWindow(this.id);
        }
    }

    public void maximize()
    {
        if (this.id != 0)
        {
            glfwMaximizeWindow(this.id);
        }
    }

    public void setMouseReleaseListener(MouseReleaseListener mouseReleaseListener)
    {
        this.mouseReleaseListener = mouseReleaseListener;
    }

    public void setMouseClickListener(MouseClickListener mouseClickListener)
    {
        this.mouseClickListener = mouseClickListener;
    }

    public void addComponents(Component... components)
    {
        this.components.addAll(Arrays.asList(components));
    }

    public FontRenderer getDefaultFontRenderer(int size)
    {
        FontRenderer fontRenderer = this.fontRenderers.stream().filter(fontRenderer1 -> fontRenderer1.getSize() == size).findFirst().orElse(null);

        if (fontRenderer == null)
        {
            fontRenderer = new FontRenderer(getFont("font/font.ttf"), size);
            this.fontRenderers.add(fontRenderer);
            return fontRenderer;
        }

        return fontRenderer;
    }

    public ArrayList<Component> getComponents()
    {
        return this.components;
    }

    public Component getComponent(long componentID)
    {
        return this.components.stream().filter(component -> component.getComponentID() == componentID).findFirst().orElse(null);
    }

    public boolean isResizable()
    {
        return resizable;
    }

    public boolean isVSYNC()
    {
        return this.vsync;
    }

    public String getTitle()
    {
        return this.id == 0 ? null : this.title;
    }

    public void setTitle(String title)
    {
        if (this.id != 0)
        {
            glfwSetWindowTitle(this.id, title);
        }
    }

    public int getWidth()
    {
        return width;
    }

    public int getHeight()
    {
        return height;
    }

    public int getMouseX()
    {
        return this.mouseX;
    }

    public int getMouseY()
    {
        return this.mouseY;
    }

    public void setSize(int width, int height)
    {
        this.width = width;
        this.height = height;
    }

    public long getID()
    {
        return this.id;
    }

    private File getFont(String fontPath)
    {
        File file = new File(System.getProperty("java.io.tmpdir"), fontPath);

        if (file.exists())
        {
            return file;
        }

        else
        {
            if (!file.getParentFile().exists())
            {
                file.getParentFile().mkdirs();
            }

            try { file.createNewFile(); } catch (Exception ignored) { }

            try (InputStream inputStream = Window.class.getResourceAsStream(fontPath); BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(Files.newOutputStream(file.toPath())))
            {
                byte [] bytes = new byte[4096];
                int read;

                while ((read = inputStream.read(bytes)) != -1)
                {
                    bufferedOutputStream.write(bytes, 0, read);
                }
            }

            catch (Exception e)
            {
                ;
            }

            return file;
        }
    }

    public abstract static class MouseClickListener
    {
        public abstract void onMouseClick(int mouseButton, int mouseX, int mouseY);
    }

    public abstract static class MouseReleaseListener
    {
        public abstract void onMouseRelease(int mouseButton, int mouseX, int mouseY);
    }
}
