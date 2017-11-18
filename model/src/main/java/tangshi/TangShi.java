package tangshi;

/**
 * @Author lidepeng
 * @Date 2017-11-18 13:13
 * @Description
 */
public class TangShi {
    //作者
    private String author;
    //标题
    private String name;
    //内容
    private String text;
    //注解
    private String explain;
    //韵译
    private String clearfix;
    //评析
    private String clearfix2;

    public TangShi() {
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getExplain() {
        return explain;
    }

    public void setExplain(String explain) {
        this.explain = explain;
    }

    public String getClearfix() {
        return clearfix;
    }

    public void setClearfix(String clearfix) {
        this.clearfix = clearfix;
    }

    public String getClearfix2() {
        return clearfix2;
    }

    public void setClearfix2(String clearfix2) {
        this.clearfix2 = clearfix2;
    }
}
