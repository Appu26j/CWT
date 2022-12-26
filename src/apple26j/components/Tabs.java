package apple26j.components;

import apple26j.GUI;
import apple26j.Window;

import java.awt.*;
import java.util.ArrayList;

public class Tabs extends Component
{
    private final ArrayList<Tab> tabs = new ArrayList<>();
    private TabClickListener tabClickListener;
    private String selectedTab;

    public Tabs(Window parentWindow, float x, float y, String selectedTab, long componentID, String... tabs)
    {
        this.parentWindow = parentWindow;
        this.x = x;
        this.y = y;
        this.selectedTab = selectedTab;
        this.componentID = componentID;
        float f = x;

        for (String tab : tabs)
        {
            this.tabs.add(new Tab(tab, f, y, this, parentWindow));
            f += (parentWindow.getDefaultFontRenderer(16).getStringWidth(tab) + 12);
        }
    }

    @Override
    public void drawScreen(int mouseX, int mouseY)
    {
        for (Tab tab : this.tabs)
        {
            tab.drawScreen(mouseX, mouseY);
        }
    }

    @Override
    public void mouseClicked(int mouseButton, int mouseX, int mouseY)
    {
        for (Tab tab : this.tabs)
        {
            tab.mouseClicked(mouseButton, mouseX, mouseY);
        }
    }

    public String getSelectedTab()
    {
        return this.selectedTab;
    }

    public void setSelectedTab(String selectedTab)
    {
        this.selectedTab = selectedTab;
    }

    public void setTabClickListener(TabClickListener tabClickListener)
    {
        this.tabClickListener = tabClickListener;
    }

    private static class Tab
    {
        private final Window parentWindow;
        private final Tabs parentTab;
        private final float x, y;
        private final String tab;

        public Tab(String tab, float x, float y, Tabs parentTab, Window parentWindow)
        {
            this.tab = tab;
            this.x = x;
            this.y = y;
            this.parentTab = parentTab;
            this.parentWindow = parentWindow;
        }

        public void drawScreen(int mouseX, int mouseY)
        {
            GUI.drawRect(this.x, this.parentTab.getSelectedTab().equals(this.tab) ? this.y - 2 : this.y, this.x + this.parentWindow.getDefaultFontRenderer(16).getStringWidth(tab) + 13, this.y + 18, this.parentTab.getSelectedTab().equals(this.tab) ? new Color(255, 255, 255) : this.isInside(mouseX, mouseY, this.x, this.parentTab.getSelectedTab().equals(this.tab) ? this.y - 2 : this.y, this.x + this.parentWindow.getDefaultFontRenderer(16).getStringWidth(tab) + 13, this.y + 18) ? new Color(215, 235, 250) : new Color(240, 240, 240));
            GUI.drawOutline(this.x, this.parentTab.getSelectedTab().equals(this.tab) ? this.y - 2 : this.y, this.x + this.parentWindow.getDefaultFontRenderer(16).getStringWidth(tab) + 13, this.y + 18, new Color(215, 215, 215));
            this.parentWindow.getDefaultFontRenderer(16).drawString(this.tab, this.x + 6, this.parentTab.getSelectedTab().equals(this.tab) ? this.y - 2 : this.y, new Color(0, 0, 0));
        }

        public void mouseClicked(int mouseButton, int mouseX, int mouseY)
        {
            if (this.isInside(mouseX, mouseY, this.x, this.parentTab.getSelectedTab().equals(this.tab) ? this.y - 2 : this.y, this.x + this.parentWindow.getDefaultFontRenderer(16).getStringWidth(tab) + 13, this.y + 18) && mouseButton == 0)
            {
                if (!this.parentTab.getSelectedTab().equals(this.tab))
                {
                    this.parentTab.setSelectedTab(this.tab);

                    if (this.parentTab.tabClickListener != null)
                    {
                        this.parentTab.tabClickListener.onTabClick();
                    }
                }
            }
        }

        private boolean isInside(int mouseX, int mouseY, float x, float y, float width, float height)
        {
            return mouseX >= x && mouseX <= width && mouseY >= y && mouseY <= height;
        }
    }

    public abstract static class TabClickListener
    {
        public abstract void onTabClick();
    }
}
