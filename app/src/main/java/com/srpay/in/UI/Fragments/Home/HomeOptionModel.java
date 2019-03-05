package com.srpay.in.UI.Fragments.Home;

/**
 * Created by Localadmin on 11/19/2018.
 */

public class HomeOptionModel {

    private String optionName;
    private int optionIcon;
    private String optionDescription;
    private String OptionImage;

    public String getOptionImage() {
        return OptionImage;
    }

    public void setOptionImage(String optionImage) {
        OptionImage = optionImage;
    }

    public String getOptionName() {
        return optionName;
    }

    public void setOptionName(String optionName) {
        this.optionName = optionName;
    }

    public int getOptionIcon() {
        return optionIcon;
    }

    public void setOptionIcon(int optionIcon) {
        this.optionIcon = optionIcon;
    }

    public String getOptionDescription() {
        return optionDescription;
    }

    public void setOptionDescription(String optionDescription) {
        this.optionDescription = optionDescription;
    }
}
