package cc.alessio.gameframework;

/**
 * Created by alessio on 20/11/14.
 */
public class Color implements Comparable<Color>{

    // Colors from http://www.rapidtables.com/web/color/RGB_Color.htm
    public static Color MAROON                  = new Color(128, 0, 0);
    public static Color DARK_RED                = new Color(139, 0, 0);
    public static Color BROWN                   = new Color(165, 42, 42);
    public static Color FIREBRICK               = new Color(178, 34, 34);
    public static Color CRIMSON                 = new Color(220, 20, 60);
    public static Color RED                     = new Color(255, 0, 0);
    public static Color TOMATO                  = new Color(255, 99, 71);
    public static Color CORAL                   = new Color(255, 127, 80);
    public static Color INDIAN_RED              = new Color(205, 92, 92);
    public static Color LIGHT_CORAL             = new Color(240, 128, 128);
    public static Color DARK_SALMON             = new Color(233, 150, 122);
    public static Color SALMON                  = new Color(250, 128, 114);
    public static Color LIGHT_SALMON            = new Color(255, 160, 122);
    public static Color ORANGE_RED              = new Color(255, 69, 0);
    public static Color DARK_ORANGE             = new Color(255, 140, 0);
    public static Color ORANGE                  = new Color(255, 165, 0);
    public static Color GOLD                    = new Color(255, 215, 0);
    public static Color DARK_GOLDEN_ROD         = new Color(184, 134, 11);
    public static Color GOLDEN_ROD              = new Color(218, 165, 32);
    public static Color PALE_GOLDEN_ROD         = new Color(238, 232, 170);
    public static Color DARK_KHAKI              = new Color(189, 183, 107);
    public static Color KHAKI                   = new Color(240, 230, 140);
    public static Color OLIVE                   = new Color(128, 128, 0);
    public static Color YELLOW                  = new Color(255, 255, 0);
    public static Color YELLOW_GREEN            = new Color(154, 205, 50);
    public static Color DARK_OLIVE_GREEN        = new Color(85, 107, 47);
    public static Color OLIVE_DRAB              = new Color(107, 142, 35);
    public static Color LAWN_GREEN              = new Color(124, 252, 0);
    public static Color CHART_REUSE             = new Color(127, 255, 0);
    public static Color GREEN_YELLOW            = new Color(173, 255, 47);
    public static Color DARK_GREEN              = new Color(0, 100, 0);
    public static Color GREEN                   = new Color(0, 128, 0);
    public static Color FOREST_GREEN            = new Color(34, 139, 34);
    public static Color LIME                    = new Color(0, 255, 0);
    public static Color LIME_GREEN              = new Color(50, 205, 50);
    public static Color LIGHT_GREEN             = new Color(144, 238, 144);
    public static Color PALE_GREEN              = new Color(152, 251, 152);
    public static Color DARK_SEA_GREEN          = new Color(143, 188, 143);
    public static Color MEDIUM_SPRING_GREEN     = new Color(0, 250, 154);
    public static Color SPRING_GREEN            = new Color(0, 255, 127);
    public static Color SEA_GREEN               = new Color(46, 139, 87);
    public static Color MEDIUM_AQUA_MARINE      = new Color(102, 205, 170);
    public static Color MEDIUM_SEA_GREEN        = new Color(60, 179, 113);
    public static Color LIGHT_SEA_GREEN         = new Color(32, 178, 170);
    public static Color DARK_SLATE_GRAY         = new Color(47, 79, 79);
    public static Color TEAL                    = new Color(0, 128, 128);
    public static Color DARK_CYAN               = new Color(0, 139, 139);
    public static Color AQUA                    = new Color(0, 255, 255);
    public static Color CYAN                    = new Color(0, 255, 255);
    public static Color LIGHT_CYAN              = new Color(224, 255, 255);
    public static Color DARK_TURQUOISE          = new Color(0, 206, 209);
    public static Color TURQUOISE               = new Color(64, 224, 208);
    public static Color MEDIUM_TURQUOISE        = new Color(72, 209, 204);
    public static Color PALE_TURQUOISE          = new Color(175, 238, 238);
    public static Color AQUA_MARINE             = new Color(127, 255, 212);
    public static Color POWDER_BLUE             = new Color(176, 224, 230);
    public static Color CADET_BLUE              = new Color(95, 158, 160);
    public static Color STEEL_BLUE              = new Color(70, 130, 180);
    public static Color CORN_FLOWER_BLUE        = new Color(100, 149, 237);
    public static Color DEEP_SKY_BLUE           = new Color(0, 191, 255);
    public static Color DODGER_BLUE             = new Color(30, 144, 255);
    public static Color LIGHT_BLUE              = new Color(173, 216, 230);
    public static Color SKY_BLUE                = new Color(135, 206, 235);
    public static Color LIGHT_SKY_BLUE          = new Color(135, 206, 250);
    public static Color MIDNIGHT_BLUE           = new Color(25, 25, 112);
    public static Color NAVY                    = new Color(0, 0, 128);
    public static Color DARK_BLUE               = new Color(0, 0, 139);
    public static Color MEDIUM_BLUE             = new Color(0, 0, 205);
    public static Color BLUE                    = new Color(0, 0, 255);
    public static Color ROYAL_BLUE              = new Color(65, 105, 225);
    public static Color BLUE_VIOLET             = new Color(138, 43, 226);
    public static Color INDIGO                  = new Color(75, 0, 130);
    public static Color DARK_SLATE_BLUE         = new Color(72, 61, 139);
    public static Color SLATE_BLUE              = new Color(106, 90, 205);
    public static Color MEDIUM_SLATE_BLUE       = new Color(123, 104, 238);
    public static Color MEDIUM_PURPLE           = new Color(147, 112, 219);
    public static Color DARK_MAGENTA            = new Color(139, 0, 139);
    public static Color DARK_VIOLET             = new Color(148, 0, 211);
    public static Color DARK_ORCHID             = new Color(153, 50, 204);
    public static Color MEDIUM_ORCHID           = new Color(186, 85, 211);
    public static Color PURPLE                  = new Color(128, 0, 128);
    public static Color THISTLE                 = new Color(216, 191, 216);
    public static Color PLUM                    = new Color(221, 160, 221);
    public static Color VIOLET                  = new Color(238, 130, 238);
    public static Color MAGENTA                 = new Color(255, 0, 255);
    public static Color ORCHID                  = new Color(218, 112, 214);
    public static Color MEDIUM_VIOLET_RED       = new Color(199, 21, 133);
    public static Color PALE_VIOLET_RED         = new Color(219, 112, 147);
    public static Color DEEP_PINK               = new Color(255, 20, 147);
    public static Color HOT_PINK                = new Color(255, 105, 180);
    public static Color LIGHT_PINK              = new Color(255, 182, 193);
    public static Color PINK                    = new Color(255, 192, 203);
    public static Color ANTIQUE_WHITE           = new Color(250, 235, 215);
    public static Color BEIGE                   = new Color(245, 245, 220);
    public static Color BISQUE                  = new Color(255, 228, 196);
    public static Color BLANCHED_ALMOND         = new Color(255, 235, 205);
    public static Color WHEAT                   = new Color(245, 222, 179);
    public static Color CORN_SILK               = new Color(255, 248, 220);
    public static Color LEMON_CHIFFON           = new Color(255, 250, 205);
    public static Color LIGHT_GOLDEN_ROD_YELLOW = new Color(250, 250, 210);
    public static Color LIGHT_YELLOW            = new Color(255, 255, 224);
    public static Color SADDLE_BROWN            = new Color(139, 69, 19);
    public static Color SIENNA                  = new Color(160, 82, 45);
    public static Color CHOCOLATE               = new Color(210, 105, 30);
    public static Color PERU                    = new Color(205, 133, 63);
    public static Color SANDY_BROWN             = new Color(244, 164, 96);
    public static Color BURLY_WOOD              = new Color(222, 184, 135);
    public static Color TAN                     = new Color(210, 180, 140);
    public static Color ROSY_BROWN              = new Color(188, 143, 143);
    public static Color MOCCASIN                = new Color(255, 228, 181);
    public static Color NAVAJO_WHITE            = new Color(255, 222, 173);
    public static Color PEACH_PUFF              = new Color(255, 218, 185);
    public static Color MISTY_ROSE              = new Color(255, 228, 225);
    public static Color LAVENDER_BLUSH          = new Color(255, 240, 245);
    public static Color LINEN                   = new Color(250, 240, 230);
    public static Color OLD_LACE                = new Color(253, 245, 230);
    public static Color PAPAYA_WHIP             = new Color(255, 239, 213);
    public static Color SEA_SHELL               = new Color(255, 245, 238);
    public static Color MINT_CREAM              = new Color(245, 255, 250);
    public static Color SLATE_GRAY              = new Color(112, 128, 144);
    public static Color LIGHT_SLATE_GRAY        = new Color(119, 136, 153);
    public static Color LIGHT_STEEL_BLUE        = new Color(176, 196, 222);
    public static Color LAVENDER                = new Color(230, 230, 250);
    public static Color FLORAL_WHITE            = new Color(255, 250, 240);
    public static Color ALICE_BLUE              = new Color(240, 248, 255);
    public static Color GHOST_WHITE             = new Color(248, 248, 255);
    public static Color HONEYDEW                = new Color(240, 255, 240);
    public static Color IVORY                   = new Color(255, 255, 240);
    public static Color AZURE                   = new Color(240, 255, 255);
    public static Color SNOW                    = new Color(255, 250, 250);
    public static Color BLACK                   = new Color(0, 0, 0);
    public static Color DIM_GRAY                = new Color(105, 105, 105);
    public static Color GRAY                    = new Color(128, 128, 128);
    public static Color DARK_GRAY               = new Color(169, 169, 169);
    public static Color SILVER                  = new Color(192, 192, 192);
    public static Color LIGHT_GRAY              = new Color(211, 211, 211);
    public static Color GAINSBORO               = new Color(220, 220, 220);
    public static Color WHITE_SMOKE             = new Color(245, 245, 245);
    public static Color WHITE                   = new Color(255, 255, 255);

    private int r;
    private int g;
    private int b;
    private int a;

    public Color(int r, int g, int b) {
        this.r = r & 0xff;
        this.g = g & 0xff;
        this.b = b & 0xff;
        this.a = 255;
    }

    public Color(float r, float g, float b) {
        this.r = (int)(r * 255.0f) & 0xff;
        this.g = (int)(g * 255.0f) & 0xff;
        this.b = (int)(b * 255.0f) & 0xff;
        this.a = 255;
    }

    public Color(int r, int g, int b, int a) {
        this.r = r & 0xff;
        this.g = g & 0xff;
        this.b = b & 0xff;
        this.a = a & 0xff;
    }
    
    public Color(float r, float g, float b, float a) {
        this.r = (int)(r * 255.0f) & 0xff;
        this.g = (int)(g * 255.0f) & 0xff;
        this.b = (int)(b * 255.0f) & 0xff;
        this.a = (int)(a * 255.0f) & 0xff;
    }

    public int getRi() {
        return r;
    }

    public int getGi() {
        return g;
    }

    public int getBi() {
        return b;
    }

    public int getAi() {
        return a;
    }

    public float getRf() {
        return (float)r/255.0f;
    }

    public float getGf() {
        return (float)g/255.0f;
    }

    public float getBf() {
        return (float)b/255.0f;
    }

    public float getAf() {
        return (float)a/255.0f;
    }

    public Color setA(int a) {
        this.a = a;
        return this;
    }

    public Color setA(float a) {
        this.a = (int)(a * 255.0f) & 0xff;
        return this;
    }

    public int asInt() {
        return  (a << 24) | (r << 16) | (g << 8) | b;
    }

    @Override
    public int compareTo(Color o) {
        if (this.r > o.r)
            return 1;
        else if (this.r < o.r)
            return -1;
        else {
            if (this.g > o.g)
                return 1;
            else if (this.g < o.g)
                return -1;
            else {
                if (this.b > o.b)
                    return 1;
                else if (this.b < o.b)
                    return -1;
                else
                    return 0;
            }
        }
    }
}
