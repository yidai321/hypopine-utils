package pers.lxg.pattern;

/**
 * @author lxg
 * @date 2022/5/22 16:24
 * <p>
 * 目录样式的抽象
 */


public abstract class ContentPattern {
    private String commonIndent;
    private String rearIndent;
    private String commonTier;
    private String rearTier;

    public abstract String getCommonIndent();

    public abstract void setCommonIndent(String commonIndent);

    public abstract String getRearIndent();

    public abstract void setRearIndent(String rearIndent);

    public abstract String getCommonTier();

    public abstract void setCommonTier(String commonTier);

    public abstract String getRearTier();

    public abstract void setRearTier(String rearTier);
}