package com.EdwiserRemUI.TestCases;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.EdwiserRemUI.BaseTest.BaseClass;
import com.EdwiserRemUI.PageObjects.BrandColorPage;
import com.EdwiserRemUI.PageObjects.ColorConversion;
import com.EdwiserRemUI.PageObjects.DashBoardPage;
import com.EdwiserRemUI.PageObjects.HeaderColorSettingPage;

public class testScripts extends BaseClass {
	DashBoardPage dp;
	BrandColorPage bcp;
	ColorConversion cc;

	HeaderColorSettingPage hcsp;

	@BeforeClass
	public void Before_class() {
		dp = new DashBoardPage(driver);
		bcp = new BrandColorPage(driver);
		cc = new ColorConversion();
		hcsp = new HeaderColorSettingPage(driver);
	}
	
	@Test(priority = 1)
	public void Test() throws InterruptedException {
		driver.get(dashboard);
		
		  // Use JavaScript to get the content of the ::before pseudo-element
//        String script = "return window.getComputedStyle(arguments[0], ':before').getCssValue('background-color');";
//        JavascriptExecutor js = (JavascriptExecutor) driver;
//        String content = (String) js.executeScript(script, hcsp.EditModeSwitch);
//
//        // Print the content of the ::before pseudo-element
//        System.out.println("Content of ::before pseudo-element: " + content);
		System.out.println("HBG:RGB: "+hcsp.navsubbarelement.getCssValue("background-color"));
		System.out.println("HBG:Converted: "+ColorConversion.Color(hcsp.navsubbarelement.getCssValue("background-color")));
		
        String script = "return window.getComputedStyle(arguments[0], ':before').getPropertyValue('background-color');";
        JavascriptExecutor js = (JavascriptExecutor) driver;
        String backgroundColor = ColorConversion.convertRGBtoRGBA((String) js.executeScript(script, hcsp.EditModeSwitch));
       
        // Print the background-color of the ::before pseudo-element
                
        System.out.println(ColorConversion.Color(backgroundColor));
        
        System.out.println("Box Shadow : "+hcsp.SiteHeaderNav.getCssValue("box-shadow"));
        String boxShadowStyle = (String) js.executeScript("return window.getComputedStyle(arguments[0]).getPropertyValue('box-shadow');", hcsp.SiteHeaderNav);

        // Parse and print individual box shadow properties
        BoxShadowProperties properties = parseBoxShadow(boxShadowStyle);
        System.out.println("Color: " + properties.getColor());
        System.out.println("X Offset: " + properties.getOffsetX());
        System.out.println("Y Offset: " + properties.getOffsetY());
        System.out.println("Blur Radius: " + properties.getBlurRadius());
        System.out.println("Spread Radius: " + properties.getSpreadRadius());
//        int BR = properties.getBlurRadius();
//        System.out.println("Blur Radius in REM: " + BR.substring(0, BR.length() - 2));
        
        

	}
	

    private static BoxShadowProperties parseBoxShadow(String boxShadow) {
        // Regular expression to match the box shadow values
        String regex = "rgba?\\((\\d+),\\s*(\\d+),\\s*(\\d+)(?:,\\s*([\\d.]+))?\\)\\s*(-?\\d+)px\\s*(-?\\d+)px\\s*(-?\\d+)(?:px)?\\s*(-?\\d+)(?:px)?";

        // Extract values using regex
        java.util.regex.Pattern pattern = java.util.regex.Pattern.compile(regex);
        java.util.regex.Matcher matcher = pattern.matcher(boxShadow);

        if (matcher.matches()) {
            // Group 1, 2, and 3 are RGB values, 4 is the alpha value (if present), 5 is X offset, 6 is Y offset,
            // 7 is blur radius, and 8 is spread radius
            int red = Integer.parseInt(matcher.group(1));
            int green = Integer.parseInt(matcher.group(2));
            int blue = Integer.parseInt(matcher.group(3));
            float alpha = matcher.group(4) != null ? Float.parseFloat(matcher.group(4)) : 1.0f;
            int offsetX = Integer.parseInt(matcher.group(5));
            int offsetY = Integer.parseInt(matcher.group(6));
            int blurRadius = Integer.parseInt(matcher.group(7));
            int spreadRadius = Integer.parseInt(matcher.group(8));
            float BR = Float.parseFloat(matcher.group(7));
            float SR = Float.parseFloat(matcher.group(8));
            System.out.println("BR in Float : "+BR);
            System.out.println("SR in Float : "+SR);
            return new BoxShadowProperties(red, green, blue, alpha, offsetX, offsetY, blurRadius, spreadRadius);
        } else {
            throw new IllegalArgumentException("Invalid box-shadow style: " + boxShadow);
        }
    }

}
class BoxShadowProperties {
    private final int red;
    private final int green;
    private final int blue;
    private final float alpha;
    private final int offsetX;
    private final int offsetY;
    private final int blurRadius;
    private final int spreadRadius;

    public BoxShadowProperties(int red, int green, int blue, float alpha, int offsetX, int offsetY, int blurRadius, int spreadRadius) {
        this.red = red;
        this.green = green;
        this.blue = blue;
        this.alpha = alpha;
        this.offsetX = offsetX;
        this.offsetY = offsetY;
        this.blurRadius = blurRadius;
        this.spreadRadius = spreadRadius;
    }
    public String  getColor() {
    	String Color = "rgba("+red+", "+green+", "+blue+", "+alpha+")";
		return Color;
    	
    }
    
    public int getRed() {
        return red;
    }

    public int getGreen() {
        return green;
    }

    public int getBlue() {
        return blue;
    }

    public float getAlpha() {
        return alpha;
    }

    public int getOffsetX() {
        return offsetX;
    }

    public int getOffsetY() {
        return offsetY;
    }

    public int getBlurRadius() {
        return blurRadius;
    }

    public int getSpreadRadius() {
        return spreadRadius;
    }

    @Override
    public String toString() {
        return "BoxShadowProperties{" +
                "red=" + red +
                ", green=" + green +
                ", blue=" + blue +
                ", alpha=" + alpha +
                ", offsetX=" + offsetX +
                ", offsetY=" + offsetY +
                ", blurRadius=" + blurRadius +
                ", spreadRadius=" + spreadRadius +
                '}';
    }
}
