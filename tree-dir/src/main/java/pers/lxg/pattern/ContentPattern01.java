package pers.lxg.pattern;

/**
 * @author lxg
 * @date 2022/5/22 16:15
 */
public class ContentPattern01 extends ContentPattern {
    public String commonIndent = "│    ";
    public String rearIndent = "     ";
    public String commonTier = "├─ ";
    public String rearTier = "└─ ";

    @Override
    public String getCommonIndent() {
        return commonIndent;
    }

    @Override
    public void setCommonIndent(String commonIndent) {
        this.commonIndent = commonIndent;
    }

    @Override
    public String getRearIndent() {
        return rearIndent;
    }

    @Override
    public void setRearIndent(String rearIndent) {
        this.rearIndent = rearIndent;
    }

    @Override
    public String getCommonTier() {
        return commonTier;
    }

    @Override
    public void setCommonTier(String commonTier) {
        this.commonTier = commonTier;
    }

    @Override
    public String getRearTier() {
        return rearTier;
    }

    @Override
    public void setRearTier(String rearTier) {
        this.rearTier = rearTier;
    }
}